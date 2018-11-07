package com.revivir.cementerio.negocios.manager;

import java.util.List;

import com.revivir.cementerio.persistencia.FactoryOBD;
import com.revivir.cementerio.persistencia.entidades.Cliente;
import com.revivir.cementerio.persistencia.interfaces.ClienteOBD;

public class ClienteManager {
	
	public static List<Cliente> traerTodo() {
		ClienteOBD obd = FactoryOBD.crearClienteOBD();
		return obd.select();
	}
	
	public static void guardarCliente(String DNI, String nombres, String apellido, String telefono, String email) {
		
	}
	
	public static Cliente traerPorDNI(String DNI) {
		
		return null;
	}

}