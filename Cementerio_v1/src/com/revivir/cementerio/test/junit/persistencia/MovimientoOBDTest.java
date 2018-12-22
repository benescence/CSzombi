package com.revivir.cementerio.test.junit.persistencia;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.revivir.cementerio.negocios.Almanaque;
import com.revivir.cementerio.persistencia.FactoryOBD;
import com.revivir.cementerio.persistencia.entidades.Fallecido;
import com.revivir.cementerio.persistencia.entidades.Movimiento;
import com.revivir.cementerio.persistencia.interfaces.MovimientoOBD;

class MovimientoOBDTest {
	private Movimiento objeto = crearObjeto();
	private MovimientoOBD obd = FactoryOBD.crearMovimientoOBD();
	
	private Movimiento crearObjeto() {
		Fallecido fallecido = FactoryOBD.crearFallecidoOBD().ultimoInsertado();
		if (fallecido == null)
			fail("Debe existir al menos un fallecido en la BD para correr este test");

		return new Movimiento(-1,fallecido.getID(), "antiguaUbicacion", "Causa Translado", "observaciones",Almanaque.hoy());
	}

	@Test
	void testInsert() {
		obd.insert(objeto);
		Movimiento objetoBD = obd.ultimoInsertado();
		iguales(objeto, objetoBD);
		obd.delete(objetoBD);
	}
	
	@Test
	void testUpdate() {
		obd.insert(objeto);
		Movimiento objetoBD1 = obd.ultimoInsertado();
		objetoBD1.setAntiguaUbicacion("antiguaUbicacion2");
		objetoBD1.setCausaTraslado("causaTraslado2");
		objetoBD1.setObservaciones("observaciones2");
		objetoBD1.setFerchaTranslado(Almanaque.hoy());
		obd.update(objetoBD1);
		Movimiento objetoBD2 = obd.ultimoInsertado();
		iguales(objetoBD1, objetoBD2);
		obd.delete(objetoBD1);
	}
	
	@Test
	void testDelete() {
		obd.insert(objeto);
		Movimiento objetoBD = obd.ultimoInsertado();
		obd.delete(objetoBD);
		objetoBD = obd.ultimoInsertado();
		if (objetoBD != null)
			distintos(objeto, objetoBD);
	}

	@Test
	void testUltimoInsertado() {
		obd.insert(objeto);
		Movimiento objetoBD = obd.ultimoInsertado();
		iguales(objeto, objetoBD);
		obd.delete(objetoBD);
	}	

	@Test
	void testSelectByID() {
		obd.insert(objeto);
		Movimiento objetoBD1 = obd.ultimoInsertado();
		Movimiento objetoBD2 = obd.selectByID(objetoBD1.getID());
		iguales(objetoBD1, objetoBD2);
		obd.delete(objetoBD1);
	}	

	@Test
	void testSelect() {
		obd.insert(objeto);
		Movimiento objetoBD1 = obd.ultimoInsertado();
		List<Movimiento> lista = obd.select();
		assertTrue(lista.size() > 0);
		obd.delete(objetoBD1);
	}
	
	private void iguales(Movimiento obj1, Movimiento obj2) {
		assertTrue(obj1.getFallecido().equals(obj2.getFallecido()));
		assertTrue(obj1.getAntiguaUbicacion().equals(obj2.getAntiguaUbicacion()));
		assertTrue(obj1.getCausaTraslado().equals(obj2.getCausaTraslado()));
		assertTrue(obj1.getObservaciones().equals(obj2.getObservaciones()));
		Date normal1 = Almanaque.normalizar(obj1.getFerchaTranslado());
		Date normal2 = Almanaque.normalizar(obj2.getFerchaTranslado());
		assertTrue(normal1.equals(normal2));
		
	}
	
	private void distintos(Movimiento obj1, Movimiento obj2) {
		boolean fallecido = obj1.getFallecido().equals(obj2.getFallecido());
		boolean antiguaUbi = obj1.getAntiguaUbicacion().equals(obj2.getAntiguaUbicacion());
		boolean causaTranslado = obj1.getCausaTraslado().equals(obj2.getCausaTraslado());
		boolean obs = obj1.getObservaciones().equals(obj2.getObservaciones());
		boolean fecha = obj1.getFerchaTranslado().equals(obj2.getFerchaTranslado());

		assertFalse(fallecido && antiguaUbi && causaTranslado && obs && fecha);
	}

}
