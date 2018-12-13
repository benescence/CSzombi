package com.revivir.cementerio.test.junit.negocios;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.revivir.cementerio.negocios.manager.ClienteManager;
import com.revivir.cementerio.persistencia.FactoryOBD;
import com.revivir.cementerio.persistencia.entidades.Cliente;
import com.revivir.cementerio.persistencia.interfaces.ClienteOBD;

class ClienteManagerTest {
	private String nombre = "N", apellido = "A", dni = "0", telefono = "1", email = "e";
	private ClienteOBD obd = FactoryOBD.crearClienteOBD();
	
	@Test
	void testGuardar() {
		Cliente local = new Cliente(-1, dni, apellido, nombre, telefono, email);
		ClienteManager.guardar(nombre, apellido, dni, telefono, email);
		Cliente clienteBD = obd.ultimoInsertado();
		iguales(clienteBD, local);
		obd.delete(clienteBD);
	}
	
	@Test
	void testModificar() {
		ClienteManager.guardar(nombre, apellido, dni, telefono, email);
		Cliente clienteBD1 = obd.ultimoInsertado();
		
		clienteBD1.setNombre("Prueba1");
		clienteBD1.setApellido("Prueba2");
		clienteBD1.setDni("Prueba3");
		clienteBD1.setTelefono("Prueba4");
		clienteBD1.setEmail("Prueba5");
		
		ClienteManager.modificar(clienteBD1);
		Cliente clienteBD2 = obd.ultimoInsertado();
		
		iguales(clienteBD1, clienteBD2);
		obd.delete(clienteBD1);
	}
	
	@Test
	void testEliminar() {
		ClienteManager.guardar(nombre, apellido, dni, telefono, email);
		Cliente clienteBD1 = obd.ultimoInsertado();		
		ClienteManager.eliminar(clienteBD1);
		Cliente clienteBD2 = obd.ultimoInsertado();
		distintos(clienteBD1, clienteBD2);
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