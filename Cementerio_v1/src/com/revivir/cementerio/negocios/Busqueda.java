package com.revivir.cementerio.negocios;

import java.util.List;

import com.revivir.cementerio.persistencia.FactoryOBD;
import com.revivir.cementerio.persistencia.entidades.Cliente;
import com.revivir.cementerio.persistencia.interfaces.ClienteOBD;

public class Busqueda {
	
	public static List<Cliente> clientes(String DNI, String nombres, String apellido) {
		ClienteOBD obd = FactoryOBD.crearClienteOBD();
		return obd.selectByNombreApellidoDNI(nombres, apellido, DNI);
	}

}
