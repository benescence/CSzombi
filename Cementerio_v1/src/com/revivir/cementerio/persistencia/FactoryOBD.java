package com.revivir.cementerio.persistencia;

import com.revivir.cementerio.persistencia.interfaces.ClienteOBD;
import com.revivir.cementerio.persistencia.interfaces.FallecidoOBD;
import com.revivir.cementerio.persistencia.mysql.ClienteOBDMySQL;
import com.revivir.cementerio.persistencia.mysql.FallecidoOBDMySQL;

public class FactoryOBD {
	
	public static FallecidoOBD crearFallecidoOBD() {
		return new FallecidoOBDMySQL();
	}

	public static ClienteOBD crearClienteOBD() {
		return new ClienteOBDMySQL();
	}
		
}