package com.revivir.cementerio.persistencia.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revivir.cementerio.persistencia.OBD;
import com.revivir.cementerio.persistencia.entidades.Responsable;
import com.revivir.cementerio.persistencia.interfaces.ResponsableOBD;


public class ResponsableOBDMYSQL extends OBD implements ResponsableOBD{
	private final String campos = " cliente, fallecido, observaciones";
	private final String tabla = "rev_responsables";
	
	@Override
	public void insert(Responsable responsable) {
		String valores = responsable.getCliente()
				+", '"+responsable.getFallecido()+"'"
				+", '"+responsable.getObservaciones()+"'";
		String sql = "insert into "+tabla+"("+campos+") values("+valores+");";
		ejecutarSQL(sql);		
	}

	@Override
	public void update(Responsable responsable) {
		String condicion = "ID = "+responsable.getID();
		String valores = " Cliente = '"+responsable.getCliente()+"'"
				+", Fallecido= '"+responsable.getFallecido()+"'"
				+", Observaciones = '"+responsable.getObservaciones()+"'";
		String consulta = "update "+tabla+" set "+valores+"  where ("+condicion+");";
		ejecutarSQL(consulta);
	}

	@Override
	public void delete(Responsable responsable) {
		String condicion = "ID = "+responsable.getID();
		String consulta = "delete from "+tabla+" where ("+condicion+");";
		ejecutarSQL(consulta);
	}

	@Override
	public List<Responsable> select() {
		return selectByCondicion("true");
	}

	@Override
	public List<Responsable> selectByCliente(Integer cliente) {
		String condicion = "";
		condicion += "cliente = " +"'"+cliente+"'";
		return selectByCondicion(condicion);
	}
	
	@Override
	public List<Responsable> selectByFallecido(Integer fallecido) {
		String condicion = "";
		condicion += "fallecido = " +"'"+fallecido+"'";
		return selectByCondicion(condicion);
	}
	
	private List<Responsable> selectByCondicion(String condicion) {
		List<Responsable> ret = new ArrayList<Responsable>();
		String comandoSQL = "select ID, "+campos+" from "+tabla+" where ("+condicion+");";  
		
		try { 
			Class.forName(driver); 
			Connection conexion = DriverManager.getConnection(cadenaConexion, usuarioBD, passwordBD); 
			Statement sentencia = conexion.createStatement ();
			ResultSet resultados = sentencia.executeQuery(comandoSQL);			

			while (resultados.next()) {
				ret.add(new Responsable(
						resultados.getInt("ID"),
						resultados.getInt("cliente"),
						resultados.getInt("fallecido"),
						resultados.getString("observaciones")
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