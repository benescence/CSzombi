package com.revivir.cementerio.test.junit.persistencia;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.Test;
import com.revivir.cementerio.negocios.Almanaque;
import com.revivir.cementerio.persistencia.FactoryOBD;
import com.revivir.cementerio.persistencia.entidades.Expensas;
import com.revivir.cementerio.persistencia.interfaces.ExpensasOBD;


class ExpensasOBDMySQL {

	private Expensas objeto = crearObjeto();
	private ExpensasOBD obd = FactoryOBD.crearExpensasOBD();
	
	private Expensas crearObjeto() {
		
		return new Expensas(-1, 8, 1, 2,Almanaque.hoy(), 600, "obs");
	}

	@Test
	void testInsert() {
		obd.insert(objeto);
		Expensas objetoBD = obd.ultimoInsertado();
		iguales(objeto, objetoBD);
		obd.delete(objetoBD);
	}
	
	@Test
	void testUpdate() {
		obd.insert(objeto);
		Expensas objetoBD1 = obd.ultimoInsertado();
		objetoBD1.setFechavencimiento(Almanaque.hoy());
		objetoBD1.setImporte(800);
		objetoBD1.setObservaciones("observaciones");
		obd.update(objetoBD1);
		Expensas objetoBD2 = obd.ultimoInsertado();
		iguales(objetoBD1, objetoBD2);
		obd.delete(objetoBD1);
	}
	
	@Test
	void testDelete() {
		obd.insert(objeto);
		Expensas objetoBD = obd.ultimoInsertado();
		obd.delete(objetoBD);
		objetoBD = obd.ultimoInsertado();
		if (objetoBD != null)
			distintos(objeto, objetoBD);
	}

	@Test
	void testUltimoInsertado() {
		obd.insert(objeto);
		Expensas clienteBD = obd.ultimoInsertado();
		iguales(objeto, clienteBD);
		obd.delete(clienteBD);
	}	

	@Test
	void testSelectByID() {
		obd.insert(objeto);
		Expensas objetoBD1 = obd.ultimoInsertado();
		Expensas objetoBD2 = obd.selectByID(objetoBD1.getID());
		iguales(objetoBD1, objetoBD2);
		obd.delete(objetoBD1);
	}	

	@Test
	void testSelect() {
		obd.insert(objeto);
		Expensas objetoBD1 = obd.ultimoInsertado();
		List<Expensas> lista = obd.select();
		assertTrue(lista.size() > 0);
		obd.delete(objetoBD1);
	}	

	private void iguales(Expensas obj1, Expensas obj2) {
		assertTrue(obj1.getUbicacion().equals(obj2.getUbicacion()));
		assertTrue(obj1.getResponsable().equals(obj2.getResponsable()));
		assertTrue(obj1.getPeriodo().equals(obj2.getPeriodo()));
		assertTrue(obj1.getFechavencimiento().equals(obj2.getFechavencimiento()));
		assertTrue(obj1.getImporte().equals(obj2.getImporte()));
		assertTrue(obj1.getObservaciones().equals(obj2.getObservaciones()));
	}
	
	private void distintos(Expensas obj1, Expensas obj2) {
		boolean ubicacion = obj1.getUbicacion().equals(obj2.getUbicacion());
		boolean responsable =obj1.getResponsable().equals(obj2.getResponsable());
		boolean periodo= obj1.getPeriodo().equals(obj2.getPeriodo());
		boolean fecha = obj1.getFechavencimiento().equals(obj2.getFechavencimiento());
		boolean importe = obj1.getImporte().equals(obj2.getImporte());
		boolean obs = obj1.getObservaciones().equals(obj2.getObservaciones());
		assertFalse(ubicacion && responsable && periodo && fecha && importe && obs);
	}

}
