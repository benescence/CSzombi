package com.revivir.cementerio.test.junit.persistencia;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.revivir.cementerio.persistencia.FactoryOBD;
import com.revivir.cementerio.persistencia.entidades.Servicio;
import com.revivir.cementerio.persistencia.interfaces.ServicioOBD;

class ServicioOBDTest {
	private Servicio objeto = crearObjetoDePrueba();
	private ServicioOBD obd = FactoryOBD.crearServicioOBD();
	
	private Servicio crearObjetoDePrueba() {
		return new Servicio(-1, "99", "Nombre", "descripcion", 999.0, false);
	}

	@Test
	void testInsert() {
		obd.insert(objeto);
		Servicio objetoBD = obd.ultimoInsertado();
		iguales(objeto, objetoBD);
		obd.delete(objetoBD);
	}
	
	@Test
	void testUpdate() {
		obd.insert(objeto);
		Servicio objetoBD1 = obd.ultimoInsertado();
		objetoBD1.setNombre("Prueba1");
		objetoBD1.setCodigo("888");
		objetoBD1.setDescripcion("hola");
		objetoBD1.setImporte(555.0);
		obd.update(objetoBD1);
		Servicio clienteBD2 = obd.ultimoInsertado();
		iguales(objetoBD1, clienteBD2);
		obd.delete(objetoBD1);
	}
	
	@Test
	void testDelete() {
		obd.insert(objeto);
		Servicio objetoBD = obd.ultimoInsertado();
		obd.delete(objetoBD);
		objetoBD = obd.ultimoInsertado();
		if (objetoBD != null)
			distintos(objeto, objetoBD);
	}

	@Test
	void testUltimoInsertado() {
		obd.insert(objeto);
		Servicio clienteBD = obd.ultimoInsertado();
		iguales(objeto, clienteBD);
		obd.delete(clienteBD);
	}	

	private void iguales(Servicio c1, Servicio c2) {
		assertTrue(c1.getCodigo().equals(c2.getCodigo()));
		assertTrue(c1.getNombre().equals(c2.getNombre()));
		assertTrue(c1.getDescripcion().equals(c2.getDescripcion()));
		assertTrue(c1.getImporte().equals(c2.getImporte()));
	}
	
	private void distintos(Servicio c1, Servicio c2) {
		boolean codigo = c1.getCodigo().equals(c2.getCodigo());
		boolean nombre = c1.getNombre().equals(c2.getNombre());
		boolean descripcion = c1.getDescripcion().equals(c2.getDescripcion());
		boolean importe = c1.getImporte().equals(c2.getImporte());
		assertFalse(codigo && nombre && descripcion && importe);
	}

}