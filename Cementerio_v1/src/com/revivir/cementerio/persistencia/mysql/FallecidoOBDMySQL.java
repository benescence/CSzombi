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
import com.revivir.cementerio.persistencia.interfaces.FallecidoOBD;

public class FallecidoOBDMySQL extends OBD implements FallecidoOBD{
	private final String campos = "cliente, ubicacion, DNI, apellido, nombre, fecha_fallecimiento, tipo_fallecimiento, cocheria";
	private final String tabla = "rev_fallecidos";
	
	@Override
	public void insert(Fallecido obciso) {
		String valores = obciso.getCliente()
				+", "+obciso.getUbicacion()
				+", '"+obciso.getDni()+"'"
				+", '"+obciso.getApellido()+"'"
				+", '"+obciso.getNombre()+"'"
				+", '"+obciso.getFechaFallecimiento()+"'"
				+", "+Definido.tipoFallecimiento(obciso.getTipoFallecimiento())
				+", '"+obciso.getCocheria()+"'";
		String sql = "insert into "+tabla+"("+campos+") values("+valores+");";
		ejecutarSQL(sql);		
	}

	@Override
	public void update(Fallecido obciso) {
		String condicion = "ID = "+obciso.getID();
		String valores = "cliente = "+obciso.getCliente() 
				+", DNI = '"+obciso.getDni()+"'"
				+", apellido = '"+obciso.getApellido()+"'"
				+", nombre = '"+obciso.getNombre()+"'"
				+", fecha_fallecimiento = '"+obciso.getFechaFallecimiento()+"'"
				+", tipo_fallecimiento = "+Definido.tipoFallecimiento(obciso.getTipoFallecimiento())
				+", cocheria = '"+obciso.getCocheria()+"'";
		String consulta = "update "+tabla+" set "+valores+"  where ("+condicion+");";
		ejecutarSQL(consulta);
	}

	@Override
	public void delete(Fallecido obciso) {
		String condicion = "ID = "+obciso.getID();
		String consulta = "delete from "+tabla+" where ("+condicion+");";
		ejecutarSQL(consulta);
	}

	@Override
	public List<Fallecido> select() {
		return selectByCondicion("true");
	}

	@Override
	public List<Fallecido> selectByNombreApellidoDNI(String nombre, String apellido, String DNI) {
		String condicion = "";
		condicion += "nombre = " +(nombre != null ? "'"+nombre+"'" : "nombre");
		condicion += " and apellido = " +(apellido != null ? "'"+apellido+"'" : "apellido");
		condicion += " and DNI = " +(DNI != null ? "'"+DNI+"'" : "DNI");
		return selectByCondicion(condicion);
	}

	private List<Fallecido> selectByCondicion(String condicion) {
		List<Fallecido> ret = new ArrayList<Fallecido>();
		String comandoSQL = "select ID, "+campos+" from "+tabla+" where ("+condicion+");";  
		
		try { 
			Class.forName(driver); 
			Connection conexion = DriverManager.getConnection(cadenaConexion, usuarioBD, passwordBD); 
			Statement sentencia = conexion.createStatement ();
			ResultSet resultados = sentencia.executeQuery(comandoSQL);			

			while (resultados.next()) {
				ret.add(new Fallecido(
						resultados.getInt("ID"),
						resultados.getInt("cliente"),
						resultados.getInt("ubicacion"),
						Definido.tipoFallecimiento(resultados.getInt("tipo_fallecimiento")),
						resultados.getString("DNI"),
						resultados.getString("apellido"),
						resultados.getString("nombre"),
						resultados.getString("cocheria"),
						resultados.getDate("fecha_fallecimiento")
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