package com.revivir.cementerio.persistencia;

import com.revivir.cementerio.persistencia.interfaces.ClienteOBD;
import com.revivir.cementerio.persistencia.interfaces.ObcisoClienteOBD;
import com.revivir.cementerio.persistencia.interfaces.ObcisoOBD;
import com.revivir.cementerio.persistencia.mysql.ClienteOBDMySQL;
import com.revivir.cementerio.persistencia.mysql.ObcisoClienteOBDMySQL;
import com.revivir.cementerio.persistencia.mysql.ObcisoOBDMySQL;

public class Factory {
	
	public static ObcisoOBD crearObcisoOBD() {
		return new ObcisoOBDMySQL();
	}

	public static ClienteOBD crearClienteOBD() {
		return new ClienteOBDMySQL();
	}
	
	public static ObcisoClienteOBD crearObcisoClienteOBD() {
		return new ObcisoClienteOBDMySQL();
	}
	
}