package com.revivir.cementerio.negocios.manager;

import java.util.List;

import com.revivir.cementerio.negocios.Verificador;
import com.revivir.cementerio.persistencia.FactoryOBD;
import com.revivir.cementerio.persistencia.entidades.Usuario;
import com.revivir.cementerio.persistencia.interfaces.UsuarioOBD;

public class UsuarioManager {
	
	public static void guardar(Usuario usuario) throws Exception {
		usuario = Verificador.usuario(usuario, null);
		UsuarioOBD obd = FactoryOBD.crearUsuarioOBD();
		obd.insert(usuario);
	}
	
	public static void modificar(Usuario nuevo, Usuario anterior) throws Exception {
		nuevo = Verificador.usuario(nuevo, anterior);
		UsuarioOBD obd = FactoryOBD.crearUsuarioOBD();
		obd.update(nuevo);
	}

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

	
}