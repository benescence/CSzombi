package com.revivir.cementerio.persistencia.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revivir.cementerio.persistencia.OBD;
import com.revivir.cementerio.persistencia.entidades.Cliente;
import com.revivir.cementerio.persistencia.interfaces.ClienteOBD;

public class ClienteOBDMySQL extends OBD implements ClienteOBD{
	private final String campos = "DNI, apellido, nombre, telefono, email";
	private final String tabla = "rev_clientes";
	
	@Override
	public void insert(Cliente cliente) {
		String valores = "'"+cliente.getDni()+"'"
				+", '"+cliente.getApellido()+"'"
				+", '"+cliente.getNombre()+"'"
				+", '"+cliente.getTelefono()+"'"
				+", '"+cliente.getEmail()+"'";
		String sql = "insert into "+tabla+"("+campos+") values("+valores+");";
		ejecutarSQL(sql);		
	}

	@Override
	public void update(Cliente cliente) {
		String condicion = "ID = "+cliente.getID();
		String valores = "DNI = '"+cliente.getDni()+"'"
				+", apellido = '"+cliente.getApellido()+"'"
				+", nombre = '"+cliente.getNombre()+"'"
				+", telefono = '"+cliente.getTelefono()+"'"
				+", email = '"+cliente.getEmail()+"'";
		String consulta = "update "+tabla+" set "+valores+"  where ("+condicion+");";
		ejecutarSQL(consulta);
	}

	@Override
	public void delete(Cliente cliente) {
		String condicion = "ID = "+cliente.getID();
		String consulta = "delete from "+tabla+" where ("+condicion+");";
		ejecutarSQL(consulta);
	}

	@Override
	public List<Cliente> select() {
		return selectByCondicion("true");
	}
	
	@Override
	public List<Cliente> selectByNombreApellidoDNI(String nombre, String apellido, String DNI) {
		String condicion = "";
		condicion += "nombre = " +(nombre != null ? "'"+nombre+"'" : "nombre");
		condicion += " and apellido = " +(apellido != null ? "'"+apellido+"'" : "apellido");
		condicion += " and DNI = " +(DNI != null ? "'"+DNI+"'" : "DNI");
		return selectByCondicion(condicion);
	}
	
	private List<Cliente> selectByCondicion(String condicion) {
		List<Cliente> ret = new ArrayList<Cliente>();
		String comandoSQL = "select ID, "+campos+" from "+tabla+" where ("+condicion+");";  
		
		try { 
			Class.forName(driver); 
			Connection conexion = DriverManager.getConnection(cadenaConexion, usuarioBD, passwordBD); 
			Statement sentencia = conexion.createStatement ();
			ResultSet resultados = sentencia.executeQuery(comandoSQL);			

			while (resultados.next()) {
				ret.add(new Cliente(
						resultados.getInt("ID"),
						resultados.getString("DNI"),
						resultados.getString("apellido"),
						resultados.getString("nombre"),
						resultados.getString("telefono"),
						resultados.getString("email")
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