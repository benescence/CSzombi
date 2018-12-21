package com.revivir.cementerio.test.negocios;

import java.util.List;

import com.revivir.cementerio.negocios.Busqueda;
import com.revivir.cementerio.persistencia.entidades.Cliente;
import com.revivir.cementerio.persistencia.entidades.Fallecido;

public class BusquedaTest {
	
	public static void clientesTest(String DNI, String nombres, String apellido) {
		/*System.out.println("___ Busqueda de clientes test");
		List<Cliente> lista = Busqueda.clientes(DNI, nombres, apellido);
		System.out.println("Cantidad: "+lista.size());
		for (Cliente elemento : lista)
			System.out.println(elemento.getApellido()+", "+elemento.getNombre());*/
	}

	public static void fallecidosTest(String DNI, String nombres, String apellido) {
		System.out.println("___ Busqueda de fallecidos test");
		List<Fallecido> lista = Busqueda.fallecidos(DNI, nombres, apellido);
		System.out.println("Cantidad: "+lista.size());
		for (Fallecido elemento : lista)
			System.out.println(elemento.getApellido()+", "+elemento.getNombre());
	}

	public static void main(String[] args) {
		//clientesTest("2", null, null);
		fallecidosTest(null, null, null);
	}
		
}