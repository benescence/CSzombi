package com.revivir.cementerio.negocios.manager;

import java.util.List;
import com.revivir.cementerio.persistencia.FactoryOBD;
import com.revivir.cementerio.persistencia.entidades.Usuario;
import com.revivir.cementerio.persistencia.interfaces.UsuarioOBD;

public class UsuarioManager {
	
	public static List<Usuario> traerTodo() {
		UsuarioOBD obd = FactoryOBD.crearUsuarioOBD();
		return obd.select();
	}

	public static void eliminar(Usuario usuario) {
		UsuarioOBD obd = FactoryOBD.crearUsuarioOBD();
		obd.delete(usuario);
	}

	public static Usuario traerPorUsuario(String usuario) {
		UsuarioOBD obd = FactoryOBD.crearUsuarioOBD();
		return obd.selectByUsuario(usuario);
	}

	public static void guardar(Usuario usuario) {
		UsuarioOBD obd = FactoryOBD.crearUsuarioOBD();
		obd.insert(usuario);
	}
	
	public static void modificar(Usuario usuario) {
		UsuarioOBD obd = FactoryOBD.crearUsuarioOBD();
		obd.update(usuario);
	}
	
}