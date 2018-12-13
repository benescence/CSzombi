package com.revivir.cementerio.test.junit;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import com.revivir.cementerio.persistencia.FactoryOBD;
import com.revivir.cementerio.persistencia.entidades.Cliente;
import com.revivir.cementerio.persistencia.interfaces.ClienteOBD;

class ClienteOBDTest {
	private Cliente objeto = crearObjetoDePrueba();
	private ClienteOBD obd = FactoryOBD.crearClienteOBD();
	
	private Cliente crearObjetoDePrueba() {
		return new Cliente(-1, "000", "Apellido", "Nombre", "Telefono", "Email");
	}

	@Test
	void testUpdate() {
		obd.insert(objeto);
		Cliente clienteBD1 = obd.ultimoInsertado();
		clienteBD1.setNombre("Prueba1");
		clienteBD1.setApellido("Prueba2");
		clienteBD1.setDni("Prueba3");
		clienteBD1.setTelefono("Prueba4");
		clienteBD1.setEmail("Prueba5");
		obd.update(clienteBD1);
		Cliente clienteBD2 = obd.ultimoInsertado();
		iguales(clienteBD1, clienteBD2);
		obd.delete(clienteBD1);
	}
	
	@Test
	void testDelete() {
		obd.insert(objeto);
		Cliente clienteBD = obd.ultimoInsertado();
		obd.delete(clienteBD);
		clienteBD = obd.ultimoInsertado();
		distintos(objeto, clienteBD);
	}

	@Test
	void testUltimoInsertado() {
		obd.insert(objeto);
		Cliente clienteBD = obd.ultimoInsertado();
		iguales(objeto, clienteBD);
		obd.delete(clienteBD);
	}	

	private void iguales(Cliente c1, Cliente c2) {
		assertTrue(c1.getNombre().equals(c2.getNombre()));
		assertTrue(c1.getApellido().equals(c2.getApellido()));
		assertTrue(c1.getDni().equals(c2.getDni()));
		assertTrue(c1.getTelefono().equals(c2.getTelefono()));
		assertTrue(c1.getEmail().equals(c2.getEmail()));
	}
	
	private void distintos(Cliente c1, Cliente c2) {
		boolean nombre = c1.getNombre().equals(c2.getNombre());
		boolean apellido = c1.getApellido().equals(c2.getApellido());
		boolean dni = c1.getDni().equals(c2.getDni());
		boolean telefono = c1.getTelefono().equals(c2.getTelefono());
		boolean email = c1.getEmail().equals(c2.getEmail());
		assertFalse(nombre && apellido && dni && telefono && email);
	}

}