package com.revivir.cementerio.negocios;

import java.util.List;

import com.revivir.cementerio.persistencia.FactoryOBD;
import com.revivir.cementerio.persistencia.entidades.Cliente;
import com.revivir.cementerio.persistencia.entidades.Fallecido;
import com.revivir.cementerio.persistencia.entidades.Servicio;
import com.revivir.cementerio.persistencia.interfaces.ClienteOBD;
import com.revivir.cementerio.persistencia.interfaces.FallecidoOBD;

public class Busqueda {
	
	public static List<Servicio> precios(String codigo, String descripcion) {
		//ServicioOBD obd = FactoryOBD.crearPrecioOBD();
		//return obd.selectByDescripcion(descripcion);
		return null;
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
