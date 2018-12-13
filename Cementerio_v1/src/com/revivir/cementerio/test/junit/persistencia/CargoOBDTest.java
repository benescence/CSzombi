package com.revivir.cementerio.test.junit.persistencia;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.revivir.cementerio.persistencia.FactoryOBD;
import com.revivir.cementerio.persistencia.entidades.Cargo;
import com.revivir.cementerio.persistencia.entidades.Fallecido;
import com.revivir.cementerio.persistencia.entidades.Servicio;
import com.revivir.cementerio.persistencia.interfaces.CargoOBD;

class CargoOBDTest {
	private Cargo objeto = crearObjetoDePrueba();
	private CargoOBD obd = FactoryOBD.crearCargoOBD();
	
	private Cargo crearObjetoDePrueba() {
		Fallecido fallecido = FactoryOBD.crearFallecidoOBD().ultimoInsertado();
		Servicio servicio = FactoryOBD.crearServicioOBD().ultimoInsertado();
		return new Cargo(-1, fallecido.getID(), servicio.getID(), "observaciones", false);
	}

	@Test
	void testInsert() {
		obd.insert(objeto);
		Cargo objetoBD = obd.ultimoInsertado();
		iguales(objeto, objetoBD);
		obd.delete(objetoBD);
	}
	
	@Test
	void testUpdate() {
		obd.insert(objeto);
		Cargo objetoBD1 = obd.ultimoInsertado();
		objetoBD1.setObservaciones("Prueba1");
		obd.update(objetoBD1);
		Cargo clienteBD2 = obd.ultimoInsertado();
		iguales(objetoBD1, clienteBD2);
		obd.delete(objetoBD1);
	}
	
	@Test
	void testDelete() {
		obd.insert(objeto);
		Cargo objetoBD = obd.ultimoInsertado();
		obd.delete(objetoBD);
		objetoBD = obd.ultimoInsertado();
		if (objetoBD != null)
			distintos(objeto, objetoBD);
	}

	@Test
	void testUltimoInsertado() {
		obd.insert(objeto);
		Cargo clienteBD = obd.ultimoInsertado();
		iguales(objeto, clienteBD);
		obd.delete(clienteBD);
	}	

	private void iguales(Cargo c1, Cargo c2) {
		assertTrue(c1.getServicio().equals(c2.getServicio()));
		assertTrue(c1.getFallecido().equals(c2.getFallecido()));
		assertTrue(c1.getObservaciones().equals(c2.getObservaciones()));
		assertTrue(c1.getPagado().equals(c2.getPagado()));
	}
	
	private void distintos(Cargo c1, Cargo c2) {
		boolean servicio = c1.getServicio().equals(c2.getServicio());
		boolean fallecido = c1.getFallecido().equals(c2.getFallecido());
		boolean observaciones = c1.getObservaciones().equals(c2.getObservaciones());
		boolean pagado = c1.getPagado().equals(c2.getPagado());
		assertFalse(servicio && fallecido && observaciones && pagado);
	}

}