package com.revivir.cementerio.negocios;

import java.sql.Date;

import com.revivir.cementerio.persistencia.FactoryOBD;
import com.revivir.cementerio.persistencia.definidos.TipoFallecimiento;
import com.revivir.cementerio.persistencia.entidades.Fallecido;
import com.revivir.cementerio.persistencia.interfaces.FallecidoOBD;

public class Recepcion {
	
	public static void guardarObciso(TipoFallecimiento tipo, Integer cliente, String dni, String nombre,
			String apellido, String cocheria, Date fechaFallecimiento) {
		
		Fallecido obciso = new Fallecido(-1, cliente,tipo, dni, apellido, nombre, cocheria, fechaFallecimiento);
		FallecidoOBD obd = FactoryOBD.crearFallecidoOBD();
		obd.insert(obciso);
	}
	
	

}