package com.revivir.cementerio.persistencia;

import com.revivir.cementerio.persistencia.interfaces.ClienteOBD;
import com.revivir.cementerio.persistencia.interfaces.FallecidoOBD;
import com.revivir.cementerio.persistencia.interfaces.ServicioOBD;
import com.revivir.cementerio.persistencia.interfaces.UbicacionOBD;
import com.revivir.cementerio.persistencia.interfaces.UsuarioOBD;
import com.revivir.cementerio.persistencia.mysql.ClienteOBDMySQL;
import com.revivir.cementerio.persistencia.mysql.FallecidoOBDMySQL;
import com.revivir.cementerio.persistencia.mysql.ServicioOBDMySQL;
import com.revivir.cementerio.persistencia.mysql.UbicacionOBDMySQL;
import com.revivir.cementerio.persistencia.mysql.UsuarioOBDMYSQL;

public class FactoryOBD {
	
	public static FallecidoOBD crearFallecidoOBD() {
		return new FallecidoOBDMySQL();
	}

	public static ClienteOBD crearClienteOBD() {
		return new ClienteOBDMySQL();
	}

	public static UbicacionOBD crearUbicacionOBD() {
		return new UbicacionOBDMySQL();
	}
	
	public static UsuarioOBD crearUsuarioOBD() {
		return new UsuarioOBDMYSQL();
	}

	public static ServicioOBD crearPrecioOBD() {
		return new ServicioOBDMySQL();
	}
	
}