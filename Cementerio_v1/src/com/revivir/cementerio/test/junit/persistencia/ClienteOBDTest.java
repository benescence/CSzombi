package com.revivir.cementerio.test.junit.persistencia;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.revivir.cementerio.persistencia.FactoryOBD;
import com.revivir.cementerio.persistencia.entidades.Cliente;
import com.revivir.cementerio.persistencia.interfaces.ClienteOBD;

class ClienteOBDTest {
	private Cliente objeto = crearObjeto();
	private ClienteOBD obd = FactoryOBD.crearClienteOBD();
	
	private Cliente crearObjeto() {
		return new Cliente(-1, "000", "Apellido", "Nombre", "Telefono", "Email");
	}

	@Test
	void testInsert() {
		obd.insert(objeto);
		Cliente objetoBD = obd.ultimoInsertado();
		iguales(objeto, objetoBD);
		obd.delete(objetoBD);
	}
	
	@Test
	void testUpdate() {
		obd.insert(objeto);
		Cliente objetoBD1 = obd.ultimoInsertado();
		objetoBD1.setNombre("Nombre1");
		objetoBD1.setApellido("Nombre2");
		objetoBD1.setDni("Nombre3");
		objetoBD1.setTelefono("Nombre4");
		objetoBD1.setEmail("Nombre5");
		obd.update(objetoBD1);
		Cliente objetoBD2 = obd.ultimoInsertado();
		iguales(objetoBD1, objetoBD2);
		obd.delete(objetoBD1);
	}
	
	@Test
	void testDelete() {
		obd.insert(objeto);
		Cliente objetoBD = obd.ultimoInsertado();
		obd.delete(objetoBD);
		objetoBD = obd.ultimoInsertado();
		distintos(objeto, objetoBD);
	}

	@Test
	void testUltimoInsertado() {
		obd.insert(objeto);
		Cliente objetoBD = obd.ultimoInsertado();
		iguales(objeto, objetoBD);
		obd.delete(objetoBD);
	}	

	@Test
	void testSelectByID() {
		obd.insert(objeto);
		Cliente objetoBD1 = obd.ultimoInsertado();
		Cliente objetoBD2 = obd.selectByID(objetoBD1.getID());
		iguales(objetoBD1, objetoBD2);
		obd.delete(objetoBD1);
	}	

	@Test
	void testSelect() {
		obd.insert(objeto);
		Cliente objetoBD1 = obd.ultimoInsertado();
		List<Cliente> lista = obd.select();
		assertTrue(lista.size() > 0);
		obd.delete(objetoBD1);
	}
	
	private void iguales(Cliente obj1, Cliente obj2) {
		assertTrue(obj1.getNombre().equals(obj2.getNombre()));
		assertTrue(obj1.getApellido().equals(obj2.getApellido()));
		assertTrue(obj1.getDni().equals(obj2.getDni()));
		assertTrue(obj1.getTelefono().equals(obj2.getTelefono()));
		assertTrue(obj1.getEmail().equals(obj2.getEmail()));
	}
	
	private void distintos(Cliente obj1, Cliente obj2) {
		boolean nombre = obj1.getNombre().equals(obj2.getNombre());
		boolean apellido = obj1.getApellido().equals(obj2.getApellido());
		boolean dni = obj1.getDni().equals(obj2.getDni());
		boolean telefono = obj1.getTelefono().equals(obj2.getTelefono());
		boolean email = obj1.getEmail().equals(obj2.getEmail());
		assertFalse(nombre && apellido && dni && telefono && email);
	}

}