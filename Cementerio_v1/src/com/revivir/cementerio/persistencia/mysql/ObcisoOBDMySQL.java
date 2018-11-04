package com.revivir.cementerio.persistencia.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revivir.cementerio.persistencia.OBD;
import com.revivir.cementerio.persistencia.entidades.Obciso;
import com.revivir.cementerio.persistencia.interfaces.ObcisoOBD;

public class ObcisoOBDMySQL extends OBD implements ObcisoOBD{
	private final String campos = "DNI, apellido, nombre, fecha_fallecimiento, tipo_fallecimiento, cocheria";
	private final String tabla = "rev_obcisos";
	
	@Override
	public void insert(Obciso obciso) {
		String valores = "'"+obciso.getDni()+"'"
				+", '"+obciso.getApellido()+"'"
				+", '"+obciso.getNombre()+"'"
				+", '"+obciso.getFechaFallecimiento()+"'"
				+", "+obciso.getTipoFallecimiento()
				+", '"+obciso.getCocheria()+"'";
		String sql = "insert into "+tabla+"("+campos+") values("+valores+");";
		ejecutarSQL(sql);		
	}

	@Override
	public void update(Obciso obciso) {
		String condicion = "ID = "+obciso.getID();
		String valores = "DNI = '"+obciso.getDni()+"'"
				+", apellido = '"+obciso.getApellido()+"'"
				+", nombre = '"+obciso.getNombre()+"'"
				+", fecha_fallecimiento = '"+obciso.getFechaFallecimiento()+"'"
				+", tipo_fallecimiento = "+obciso.getTipoFallecimiento()
				+", cocheria = '"+obciso.getCocheria()+"'";
		String consulta = "update "+tabla+" set "+valores+"  where ("+condicion+");";
		ejecutarSQL(consulta);
	}

	@Override
	public void delete(Obciso obciso) {
		String condicion = "ID = "+obciso.getID();
		String consulta = "delete from "+tabla+" where ("+condicion+");";
		ejecutarSQL(consulta);
	}

	@Override
	public List<Obciso> select() {
		return selectByCondicion("true");
	}

	private List<Obciso> selectByCondicion(String condicion) {
		List<Obciso> ret = new ArrayList<Obciso>();
		String comandoSQL = "select ID, "+campos+" from "+tabla+" where ("+condicion+");";  
		
		try { 
			Class.forName(driver); 
			Connection conexion = DriverManager.getConnection(cadenaConexion, usuarioBD, passwordBD); 
			Statement sentencia = conexion.createStatement ();
			ResultSet resultados = sentencia.executeQuery(comandoSQL);			

			while (resultados.next()) {
				ret.add(new Obciso(
						resultados.getInt("ID"),
						resultados.getInt("tipo_fallecimiento"),
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