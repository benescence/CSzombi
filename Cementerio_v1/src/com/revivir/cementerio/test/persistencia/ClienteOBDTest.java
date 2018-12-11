package com.revivir.cementerio.test.persistencia;

import java.util.List;

import com.revivir.cementerio.persistencia.FactoryOBD;
import com.revivir.cementerio.persistencia.entidades.Cliente;
import com.revivir.cementerio.persistencia.interfaces.ClienteOBD;

public class ClienteOBDTest {

	public static void insertTest(Cliente cliente) {
		System.out.println("___ insert test");
		ClienteOBD obd = FactoryOBD.crearClienteOBD();
		obd.insert(cliente);
	}

	public static void updateTest(Cliente cliente) {
		System.out.println("___ Update test");
		ClienteOBD obd = FactoryOBD.crearClienteOBD();
		obd.update(cliente);
	}

	public static void deleteTest(Cliente cliente) {
		System.out.println("___ Delete test");
		ClienteOBD obd = FactoryOBD.crearClienteOBD();
		obd.delete(cliente);
	}
	
	public static List<Cliente> selectTest() {
		System.out.println("___ Select test");
		ClienteOBD obd = FactoryOBD.crearClienteOBD();
		List<Cliente> lista = obd.select();
		System.out.println("Cantidad: "+lista.size());
		for (Cliente elemento : lista)
			System.out.println(elemento.getApellido()+", "+elemento.getNombre());
		return lista;
	}
	
	public static Cliente selectByIDTest(Integer ID) {
		System.out.println("____ Select by ID Test");
		ClienteOBD obd = FactoryOBD.crearClienteOBD();
		Cliente cliente = obd.selectByID(ID);
		System.out.println("Cliente: "+cliente.getApellido()+", "+cliente.getNombre());
		return cliente;
	}
	
	public static void main(String[] args) {
		Cliente cliente = new Cliente(-1, "3", "Caballero", "Carlos", "44655", "email@com");
		insertTest(cliente);
		selectTest();
		Cliente clienteBD = selectByIDTest(1);
		clienteBD.setApellido("Apellido editado");
		updateTest(clienteBD);
		selectTest();
		deleteTest(clienteBD);
		selectTest();
	}

}