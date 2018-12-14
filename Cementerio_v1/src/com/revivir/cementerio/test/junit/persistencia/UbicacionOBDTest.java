package com.revivir.cementerio.test.junit.persistencia;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.revivir.cementerio.negocios.Almanaque;
import com.revivir.cementerio.persistencia.FactoryOBD;
import com.revivir.cementerio.persistencia.definidos.SubSector;
import com.revivir.cementerio.persistencia.entidades.Ubicacion;
import com.revivir.cementerio.persistencia.interfaces.UbicacionOBD;

class UbicacionOBDTest {
	private Ubicacion objeto = crearObjetoDePrueba();
	private UbicacionOBD obd = FactoryOBD.crearUbicacionOBD();
	
	private Ubicacion crearObjetoDePrueba() {
		return new Ubicacion(-1, SubSector.BOVEDA, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Almanaque.hoy());
	}

	@Test
	void testInsert() {
		obd.insert(objeto);
		Ubicacion objetoBD = obd.ultimoInsertado();
		iguales(objeto, objetoBD);
		obd.delete(objetoBD);
	}
	
	@Test
	void testUpdate() {
		obd.insert(objeto);
		Ubicacion objetoBD1 = obd.ultimoInsertado();
		objetoBD1.setSubsector(SubSector.DEPOSITO1);
		obd.update(objetoBD1);
		Ubicacion clienteBD2 = obd.ultimoInsertado();
		iguales(objetoBD1, clienteBD2);
		obd.delete(objetoBD1);
	}
	
	@Test
	void testDelete() {
		obd.insert(objeto);
		Ubicacion objetoBD = obd.ultimoInsertado();
		obd.delete(objetoBD);
		objetoBD = obd.ultimoInsertado();
		if (objetoBD != null)
			distintos(objeto, objetoBD);
	}

	@Test
	void testUltimoInsertado() {
		obd.insert(objeto);
		Ubicacion clienteBD = obd.ultimoInsertado();
		iguales(objeto, clienteBD);
		obd.delete(clienteBD);
	}	

	private void iguales(Ubicacion c1, Ubicacion c2) {
		assertTrue(c1.getSubsector().equals(c2.getSubsector()));
	}
	
	private void distintos(Ubicacion c1, Ubicacion c2) {
		boolean subsector = c1.getSubsector().equals(c2.getSubsector());
		assertFalse(subsector);
	}

}