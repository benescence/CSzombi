package com.revivir.cementerio.test;

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
	
	public static void selectTest() {
		System.out.println("___ select test");
		ClienteOBD obd = FactoryOBD.crearClienteOBD();
		List<Cliente> lista = obd.select();
		System.out.println("Cantidad: "+lista.size());
		for (Cliente elemento : lista)
			System.out.println(elemento.getApellido()+", "+elemento.getNombre());
	}
	
	public static void main(String[] args) {
		Cliente cliente = new Cliente(-1, "2", "Ramirez", "Cyntia", "44655", "email@com");
		insertTest(cliente);
		selectTest();
	}

}