package com.revivir.cementerio.negocios;

import java.util.List;

import com.revivir.cementerio.persistencia.FactoryOBD;
import com.revivir.cementerio.persistencia.entidades.Cliente;
import com.revivir.cementerio.persistencia.entidades.Fallecido;
import com.revivir.cementerio.persistencia.interfaces.ClienteOBD;
import com.revivir.cementerio.persistencia.interfaces.FallecidoOBD;

public class Busqueda {
	
	public static List<Cliente> clientes(String DNI, String nombres, String apellido) {
		ClienteOBD obd = FactoryOBD.crearClienteOBD();
		return obd.selectByNombreApellidoDNI(nombres, apellido, DNI);
	}

	public static List<Fallecido> fallecidos(String DNI, String nombres, String apellido) {
		// SI TIENE UNA CADENA VACIA LE MANDO NULL
		DNI = (DNI != null && DNI.equals("")) ? null : DNI;
		nombres = (nombres != null && nombres.equals("")) ? null : nombres;
		apellido = (apellido != null && apellido.equals("")) ? null : apellido;
		
		FallecidoOBD obd = FactoryOBD.crearFallecidoOBD();
		return obd.selectByNombreApellidoDNI(nombres, apellido, DNI);
	}

}
