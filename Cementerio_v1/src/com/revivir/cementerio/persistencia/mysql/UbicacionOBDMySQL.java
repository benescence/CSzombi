package com.revivir.cementerio.persistencia.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revivir.cementerio.persistencia.Definido;
import com.revivir.cementerio.persistencia.OBD;
import com.revivir.cementerio.persistencia.entidades.Ubicacion;
import com.revivir.cementerio.persistencia.interfaces.UbicacionOBD;

public class UbicacionOBDMySQL extends OBD implements UbicacionOBD{
	private final String campos = "subsector, deposito, otro_cementerio, osario, nicho, fila,"
			+ "seccion, macizo, unidad, bis, bis_macizo, numero, sepultura, parcela, mueble, inhumacion, circ";
	private final String tabla = "rev_ubicaciones";
	
	@Override
	public void insert(Ubicacion ubicacion) {
		String valores = Definido.subsector(ubicacion.getSubsector())
				+", "+ubicacion.getDeposito()
				+", '"+ubicacion.getOtroCementerio()+"'"
				+", '"+ubicacion.getOsario()+"'"
				+", '"+ubicacion.getNicho()+"'"
				+", '"+ubicacion.getFila()+"'"
				+", '"+ubicacion.getSeccion()+"'"
				+", '"+ubicacion.getMacizo()+"'"
				+", '"+ubicacion.getUnidad()+"'"
				+", '"+ubicacion.getBis()+"'"
				+", '"+ubicacion.getBis_macizo()+"'"
				+", '"+ubicacion.getNumero()+"'"
				+", '"+ubicacion.getSepultura()+"'"
				+", '"+ubicacion.getParcela()+"'"
				+", '"+ubicacion.getMueble()+"'"
				+", '"+ubicacion.getInhumacion()+"'"
				+", '"+ubicacion.getCirc()+"'";
		String sql = "insert into "+tabla+"("+campos+") values("+valores+");";
		ejecutarSQL(sql);		
	}

	@Override
	public List<Ubicacion> select() {
		return selectByCondicion("true");
	}
	
	private List<Ubicacion> selectByCondicion(String condicion) {
		List<Ubicacion> ret = new ArrayList<>();
		String comandoSQL = "select ID, "+campos+" from "+tabla+" where ("+condicion+");";  
		
		try { 
			Class.forName(driver); 
			Connection conexion = DriverManager.getConnection(cadenaConexion, usuarioBD, passwordBD); 
			Statement sentencia = conexion.createStatement ();
			ResultSet resultados = sentencia.executeQuery(comandoSQL);			

			while (resultados.next()) {
				ret.add(new Ubicacion(
						resultados.getInt("ID"),
						Definido.subsector(resultados.getInt("subsector")),
						resultados.getInt("deposito"),
						resultados.getString("otro_cementerio"),
						resultados.getString("osario"),
						resultados.getString("nicho"),
						resultados.getString("fila"),
						resultados.getString("seccion"),
						resultados.getString("macizo"),
						resultados.getString("unidad"),
						resultados.getString("bis"),
						resultados.getString("bis_macizo"),
						resultados.getString("numero"),
						resultados.getString("sepultura"),
						resultados.getString("parcela"),
						resultados.getString("mueble"),
						resultados.getString("inhumacion"),
						resultados.getString("circ")
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