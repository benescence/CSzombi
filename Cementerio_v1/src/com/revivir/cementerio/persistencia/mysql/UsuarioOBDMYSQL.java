package com.revivir.cementerio.persistencia.mysql;

import java.util.List;

import com.revivir.cementerio.persistencia.Definido;
import com.revivir.cementerio.persistencia.OBD;
import com.revivir.cementerio.persistencia.entidades.Usuario;
import com.revivir.cementerio.persistencia.interfaces.UsuarioOBD;

public class UsuarioOBDMYSQL extends OBD implements UsuarioOBD{
	private final String campos = "usuario, password, rol"; 
	private final String tabla = "rev_usuarios";
	
	@Override
	public void insert(Usuario usuario) {
		String valores = "'"+usuario.getUsuario()+"'"
				+", '"+usuario.getPassword()+"'"
				+", "+Definido.rol(usuario.getRol());
		String sql = "insert into "+tabla+"("+campos+") values("+valores+");";
		ejecutarSQL(sql);
	}
	
	@Override
	public void update(Usuario usuario) {
		String condicion = "ID = "+usuario.getID();
		String valores = "'"+usuario.getUsuario()+"'"
				+", '"+usuario.getPassword()+"'"
				+", '"+usuario.getRol()+"'";
		String consulta = "update "+tabla+" set "+valores+"  where ("+condicion+");";
		ejecutarSQL(consulta);
	}

	@Override
	public void delete(Usuario usuario) {
		String condicion = "ID = "+usuario.getID();
		String consulta = "delete from "+tabla+" where ("+condicion+");";
		ejecutarSQL(consulta);
	}

	@Override
	public List<Usuario> select() {
		// TODO Toma como ejemplo el de fallecidos
		return null;
	}

}