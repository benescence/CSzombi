package com.revivir.cementerio.persistencia.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revivir.cementerio.persistencia.OBD;
import com.revivir.cementerio.persistencia.entidades.Precio;
import com.revivir.cementerio.persistencia.interfaces.PrecioOBD;

public class PrecioOBDMySQL extends OBD implements PrecioOBD{
	// TODO falta cambiar los campos aca arriba
	private final String campos = "codigo, nombre, monto,descripcion, historico ";
	private final String tabla = "rev_servicios";
	
	@Override
	public void insert(Precio precio) {
		String valores = "'"+precio.getCodigo()+"'"
				+", '"+precio.getDescripcion()+"'"
				+", '"+precio.getMonto()+"'"
				+", '"+precio.getNombre()+"'";
		String sql = "insert into "+tabla+"("+campos+") values("+valores+");";
		ejecutarSQL(sql);		
	}

	// TODO fijate que las cadenas van entre comillas simples pero los enteros no
	@Override
	public void update(Precio precio) {
		String condicion = "ID = "+precio.getID();
		String valores = "codigo = '"+precio.getCodigo()+"'"
				+", descripcion = '"+precio.getDescripcion()+"'"
				+", monto = '"+precio.getMonto()+"'"
				+", nombre = '"+precio.getNombre()+"'";
		String consulta = "update "+tabla+" set "+valores+"  where ("+condicion+");";
		ejecutarSQL(consulta);
	}

	@Override
	public void delete(Precio precio) {
		String condicion = "ID = "+precio.getID();
		String consulta = "delete from "+tabla+" where ("+condicion+");";
		ejecutarSQL(consulta);
	}

	@Override
	public List<Precio> select() {
		return selectByCondicion("true");
	}

	@Override
	public List<Precio> selectByDescripcion(String descripcion) {
		String condicion = "";
		condicion += "descripcion = " +(descripcion != null ? "'"+descripcion+"'" : "descripcion");
		return selectByCondicion(condicion);
	}

	@Override
	public List<Precio> selectByNombre(String nombre) {
		String condicion = "";
		condicion += "descripcion = " +(nombre != null ? "'"+nombre+"'" : "nombre");
		return selectByCondicion(condicion);
	}
	
	@Override
	public Precio selectBycodigo(Integer codigo) {
		String condicion = "codigo = " +(codigo != null ? "'"+codigo+"'" : "codigo");
		List<Precio> lista = selectByCondicion(condicion);
		if (lista.size() > 0)
			return lista.get(0);
		return null;
	}
	
	private List<Precio> selectByCondicion(String condicion) {
		List<Precio> ret = new ArrayList<Precio>();
		String comandoSQL = "select ID, "+campos+" from "+tabla+" where ("+condicion+");";  
		
		try { 
			Class.forName(driver); 
			Connection conexion = DriverManager.getConnection(cadenaConexion, usuarioBD, passwordBD); 
			Statement sentencia = conexion.createStatement ();
			ResultSet resultados = sentencia.executeQuery(comandoSQL);			

			while (resultados.next()) {
				ret.add(new Precio(
						resultados.getInt("ID"),
						resultados.getInt("codigo"),
						resultados.getString("descripcion"),
						resultados.getDouble("monto"),
						resultados.getString("nombre")
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
