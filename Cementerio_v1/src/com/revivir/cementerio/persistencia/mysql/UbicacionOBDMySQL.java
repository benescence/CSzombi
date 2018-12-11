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
import com.revivir.cementerio.persistencia.entidades.Ubicacion;
import com.revivir.cementerio.persistencia.interfaces.UbicacionOBD;

public class UbicacionOBDMySQL extends OBD implements UbicacionOBD{
	private final String campos = "subsector, otro_cementerio, osario, nicho, fila,"
			+ "seccion, macizo, unidad, bis, bis_macizo, numero_sepultura, sepultura, parcela, mueble, inhumacion, circ, vencimiento";
	private final String tabla = "rev_ubicaciones";
	
	
	@Override
	public void insert(Ubicacion ubicacion) {
		String otroCementerio = (ubicacion.getOtroCementerio() != null) ? "'"+ubicacion.getOtroCementerio()+"'" : null;
		String osario = (ubicacion.getOsario() != null) ? "'"+ubicacion.getOsario()+"'" : null;
		String seccion = (ubicacion.getSeccion() != null) ? "'"+ubicacion.getSeccion()+"'" : null;
		String macizo = (ubicacion.getMacizo() != null) ? "'"+ubicacion.getMacizo()+"'" : null;
		String parcela = (ubicacion.getParcela() != null) ? "'"+ubicacion.getParcela()+"'" : null;
		String mueble = (ubicacion.getMueble() != null) ? "'"+ubicacion.getMueble()+"'" : null;
		String inhumacion = (ubicacion.getInhumacion()!= null) ? "'"+ubicacion.getInhumacion()+"'" : null;
		String circ = (ubicacion.getCirc() != null) ? "'"+ubicacion.getCirc()+"'" : null;
		String fila = (ubicacion.getFila()!= null) ? "'"+ubicacion.getFila()+"'" : null;
		String unidad = (ubicacion.getUnidad() != null) ? "'"+ubicacion.getUnidad()+"'" : null;
		String nicho = (ubicacion.getNicho() != null) ? "'"+ubicacion.getNicho()+"'" : null;
		String bis = (ubicacion.getBis() != null) ? "'"+ubicacion.getBis()+"'" : null;
		String bisMacizo = (ubicacion.getBis_macizo() != null) ? "'"+ubicacion.getBis_macizo()+"'" : null;
		String numero = (ubicacion.getNumero() != null) ? "'"+ubicacion.getNumero()+"'" : null;
		String sepultura = (ubicacion.getSepultura() != null) ? "'"+ubicacion.getSepultura()+"'" : null;
		String vencimiento = (ubicacion.getVencimiento() != null) ? "'"+ubicacion.getVencimiento()+"'" : null;
		
		String valores = Definido.subsector(ubicacion.getSubsector())
				+", "+otroCementerio
				+", "+osario
				+", "+nicho
				+", "+fila
				+", "+seccion
				+", "+macizo
				+", "+unidad
				+", "+bis
				+", "+bisMacizo
				+", "+numero
				+", "+sepultura
				+", "+parcela
				+", "+mueble
				+", "+inhumacion
				+", "+circ
				+", "+vencimiento;
		String sql = "insert into "+tabla+"("+campos+") values("+valores+");";
		ejecutarSQL(sql);		
	}

	@Override
	public List<Ubicacion> select() {
		return selectByCondicion("true");
	}

	@Override
	public Ubicacion selectByFallecido(Fallecido fallecido) {
		String condicion = "ID = "+fallecido.getUbicacion();
		List<Ubicacion> lista = selectByCondicion(condicion);
		if (lista.size()>0)
			return lista.get(0);
		return null;
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
						resultados.getString("otro_cementerio"),
						resultados.getString("osario"),
						resultados.getString("nicho"),
						resultados.getString("fila"),
						resultados.getString("seccion"),
						resultados.getString("macizo"),
						resultados.getString("unidad"),
						resultados.getString("bis"),
						resultados.getString("bis_macizo"),
						resultados.getString("numero_sepultura"),
						resultados.getString("sepultura"),
						resultados.getString("parcela"),
						resultados.getString("mueble"),
						resultados.getString("inhumacion"),
						resultados.getString("circ"),
						resultados.getDate("vencimiento")
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

	@Override
	public Integer selectLastID() {
		return selectLastID(tabla);
	}

	
}