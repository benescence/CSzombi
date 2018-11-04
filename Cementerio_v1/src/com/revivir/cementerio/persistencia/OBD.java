package com.revivir.cementerio.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class OBD {
	protected final String driver = "com.mysql.jdbc.Driver";
	protected final String cadenaConexion = "jdbc:mysql://sql143.main-hosting.eu:3306/u147800277_cemen"; 
	protected String usuarioBD = "u147800277_ben";
	protected String passwordBD = "Tiburones";
			
	// Ejecutar sentencias que no traigan resultados
	public void ejecutarSQL(String sql) {
		try { 
			Class.forName(driver); 
			Connection conexion = DriverManager.getConnection(cadenaConexion, usuarioBD, passwordBD);
			Statement sentencia = conexion.createStatement();
			sentencia.execute(sql);
			sentencia.close();
			conexion.close();
			
		}catch(Exception e) {
			System.out.println("       ERROR: "+sql);
			e.printStackTrace();
		}
	}

}