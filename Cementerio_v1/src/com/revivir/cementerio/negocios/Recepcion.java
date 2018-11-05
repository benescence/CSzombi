package com.revivir.cementerio.negocios;

import java.sql.Date;

import com.revivir.cementerio.persistencia.FactoryOBD;
import com.revivir.cementerio.persistencia.entidades.Obciso;
import com.revivir.cementerio.persistencia.interfaces.ObcisoOBD;

public class Recepcion {
	
	public static void guardarObciso(Integer tipoFallecimiento, String dni, String nombre,
			String apellido, String cocheria, Date fechaFallecimiento) {
		
		Obciso obciso = new Obciso(-1, tipoFallecimiento, dni, apellido, nombre, cocheria, fechaFallecimiento);
		ObcisoOBD obd = FactoryOBD.crearObcisoOBD();
		obd.insert(obciso);
	}

}
