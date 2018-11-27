package com.revivir.cementerio.persistencia.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revivir.cementerio.persistencia.Definido;
import com.revivir.cementerio.persistencia.OBD;
import com.revivir.cementerio.persistencia.entidades.Fallecido;
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
		String valores = " usuario = '"+usuario.getUsuario()+"'"
				+", password = '"+usuario.getPassword()+"'"
				+", rol =  "+ Definido.rol(usuario.getRol());
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
		return selectByCondicion("true");
	}

	@Override
	public List<Usuario> selectByRol(String rol) {
		String condicion = "";
		condicion += "rol = " +(rol != null ? "'"+rol+"'" : "rol");
	
		return selectByCondicion(condicion);
	}
	
	
	private List<Usuario> selectByCondicion(String condicion) {
		List<Usuario> ret = new ArrayList<Usuario>();
		String comandoSQL = "select ID, "+campos+" from "+tabla+" where ("+condicion+");";  
		
		try { 
			Class.forName(driver); 
			Connection conexion = DriverManager.getConnection(cadenaConexion, usuarioBD, passwordBD); 
			Statement sentencia = conexion.createStatement ();
			ResultSet resultados = sentencia.executeQuery(comandoSQL);			

			while (resultados.next()) {
				ret.add(new Usuario(
						resultados.getInt("ID"),
						resultados.getString("usuario"),
						resultados.getString("password"),
						Definido.rol(resultados.getInt("rol"))
						
						));
			}
			
			resultados.close();
			sentencia.close();
			conexion.close();
			
		}catch(Exception e) {
			System.out.println(comandoSQL);
			e.printStackTrace();
		}
			
		return ret;
	}

	

}