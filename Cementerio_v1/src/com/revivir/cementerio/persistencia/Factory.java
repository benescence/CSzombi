package com.revivir.cementerio.persistencia;

import com.revivir.cementerio.persistencia.interfaces.ObcisoOBD;

import revivir.com.cementerio.persistencia.mysql.ObcisoOBDMySQL;

public class Factory {
	
	public static ObcisoOBD crearObcisoOBD() {
		return new ObcisoOBDMySQL();
	}

}
