package com.revivir.cementerio.negocios.manager;

import java.sql.Date;

import com.revivir.cementerio.persistencia.FactoryOBD;
import com.revivir.cementerio.persistencia.definidos.TipoFallecimiento;
import com.revivir.cementerio.persistencia.entidades.Fallecido;
import com.revivir.cementerio.persistencia.interfaces.FallecidoOBD;

public class FallecidoManager {
	
	public static void guardarFallecido(Integer cliente, Integer ubicacion, TipoFallecimiento tipo,
			String dni, String apellido, String nombre, String cocheria, Date fechaFallecimiento) {
		
		Fallecido fallecido = new Fallecido(-1, cliente, ubicacion,tipo, dni, apellido,
				nombre, cocheria, fechaFallecimiento);
		
		FallecidoOBD obd = FactoryOBD.crearFallecidoOBD();
		obd.insert(fallecido);
		
	}

}
