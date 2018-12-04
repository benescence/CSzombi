package com.revivir.cementerio.negocios;

import com.revivir.cementerio.persistencia.FactoryOBD;
import com.revivir.cementerio.persistencia.entidades.Usuario;
import com.revivir.cementerio.persistencia.interfaces.UsuarioOBD;

public class Sesion {
	private static Usuario usuario;
	
	public static void iniciarSesion(String nombre, String password) throws Exception {
		UsuarioOBD obd = FactoryOBD.crearUsuarioOBD();
		Usuario usuarioBD = obd.selectByUsuario(nombre);

		if (usuarioBD == null)
			throw new Exception("No existe un usuario con el nombre de usuario: "+nombre);

		if (!usuarioBD.getPassword().equals(password))
			throw new Exception("Contraseña incorrecta.");
		
		usuario = usuarioBD;
	}
	
	public static Usuario getUsuario() {
		return usuario;
	}

}