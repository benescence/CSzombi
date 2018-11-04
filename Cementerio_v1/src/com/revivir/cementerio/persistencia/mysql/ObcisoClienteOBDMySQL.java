package com.revivir.cementerio.persistencia.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revivir.cementerio.persistencia.OBD;
import com.revivir.cementerio.persistencia.entidades.ObcisoCliente;
import com.revivir.cementerio.persistencia.interfaces.ObcisoClienteOBD;

public class ObcisoClienteOBDMySQL extends OBD implements ObcisoClienteOBD{
	private final String campos = "obciso, cliente";
	private final String tabla = "rev_clientes_obcisos";
	
	@Override
	public void insert(ObcisoCliente obcisoCliente) {
		String valores = obcisoCliente.getObciso()
				+", "+obcisoCliente.getCliente();
		String sql = "insert into "+tabla+"("+campos+") values("+valores+");";
		ejecutarSQL(sql);		
	}

	@Override
	public void delete(ObcisoCliente obcisoCliente) {
		String condicion = "obciso = "+obcisoCliente.getObciso()+" and cliente = "+obcisoCliente.getCliente();
		String consulta = "delete from "+tabla+" where ("+condicion+");";
		ejecutarSQL(consulta);
	}

	@Override
	public List<ObcisoCliente> select() {
		return selectByCondicion("true");
	}

	private List<ObcisoCliente> selectByCondicion(String condicion) {
		List<ObcisoCliente> ret = new ArrayList<ObcisoCliente>();
		String comandoSQL = "select "+campos+" from "+tabla+" where ("+condicion+");";  
		
		try { 
			Class.forName(driver); 
			Connection conexion = DriverManager.getConnection(cadenaConexion, usuarioBD, passwordBD); 
			Statement sentencia = conexion.createStatement ();
			ResultSet resultados = sentencia.executeQuery(comandoSQL);			

			while (resultados.next()) {
				ret.add(new ObcisoCliente(
						resultados.getInt("cliente"),
						resultados.getInt("obciso")
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