package com.revivir.cementerio.test.junit.persistencia;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.revivir.cementerio.persistencia.FactoryOBD;
import com.revivir.cementerio.persistencia.entidades.Cliente;
import com.revivir.cementerio.persistencia.entidades.Fallecido;
import com.revivir.cementerio.persistencia.entidades.Responsable;
import com.revivir.cementerio.persistencia.interfaces.ResponsableOBD;

class ResponsableOBDTest {
	private Responsable objeto = crearObjetoDePrueba();
	private ResponsableOBD obd = FactoryOBD.crearResponsableOBD();
	
	private Responsable crearObjetoDePrueba() {
		Cliente cliente = FactoryOBD.crearClienteOBD().ultimoInsertado();
		Fallecido fallecido = FactoryOBD.crearFallecidoOBD().ultimoInsertado();
		return new Responsable(-1, cliente.getID(), fallecido.getID(), "Observaciones");
	}

	@Test
	void testUpdate() {
		obd.insert(objeto);
		Responsable objetoBD1 = obd.ultimoInsertado();
		objetoBD1.setObservaciones("Prueba1");
		obd.update(objetoBD1);
		Responsable clienteBD2 = obd.ultimoInsertado();
		iguales(objetoBD1, clienteBD2);
		obd.delete(objetoBD1);
	}
	
	@Test
	void testDelete() {
		obd.insert(objeto);
		Responsable objetoBD = obd.ultimoInsertado();
		obd.delete(objetoBD);
		objetoBD = obd.ultimoInsertado();
		if (objetoBD != null)
			distintos(objeto, objetoBD);
	}

	@Test
	void testUltimoInsertado() {
		obd.insert(objeto);
		Responsable clienteBD = obd.ultimoInsertado();
		iguales(objeto, clienteBD);
		obd.delete(clienteBD);
	}	

	private void iguales(Responsable c1, Responsable c2) {
		assertTrue(c1.getCliente().equals(c2.getCliente()));
		assertTrue(c1.getFallecido().equals(c2.getFallecido()));
		assertTrue(c1.getObservaciones().equals(c2.getObservaciones()));
	}
	
	private void distintos(Responsable c1, Responsable c2) {
		boolean cliente = c1.getCliente().equals(c2.getCliente());
		boolean fallecido = c1.getFallecido().equals(c2.getFallecido());
		boolean observaciones = c1.getObservaciones().equals(c2.getObservaciones());
		assertFalse(cliente && fallecido && observaciones);
	}

}