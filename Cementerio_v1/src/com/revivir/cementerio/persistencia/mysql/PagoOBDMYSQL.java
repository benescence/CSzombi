package com.revivir.cementerio.persistencia.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.revivir.cementerio.persistencia.OBD;
import com.revivir.cementerio.persistencia.entidades.Pago;
import com.revivir.cementerio.persistencia.interfaces.PagoOBD;


public class PagoOBDMYSQL extends OBD implements PagoOBD{
	private final String campos = " cargo, cliente, importe, observaciones, fecha";
	private final String tabla = "rev_pagos";
	
	@Override
	public void insert(Pago pago) {
		String valores = pago.getCargo()
				+", '"+pago.getCliente()+"'"
				+", '"+pago.getImporte()+"'"
				+", '"+pago.getObservaciones()+"'"
				+", '"+pago.getFecha()+"'";
		String sql = "insert into "+tabla+"("+campos+") values("+valores+");";
		ejecutarSQL(sql);		
	}

	@Override
	public void update(Pago pago) {
		String condicion = "ID = "+pago.getID();
		String valores = " Cargo = '"+pago.getCargo()+"'"
				+", Cliente = '"+pago.getCliente()+"'"
				+", Importe = '"+pago.getObservaciones()+"'"
				+", fecha= '"+pago.getFecha()+"'";
		String consulta = "update "+tabla+" set "+valores+"  where ("+condicion+");";
		ejecutarSQL(consulta);
	}

	@Override
	public void delete(Pago pago) {
		String condicion = "ID = "+pago.getID();
		String consulta = "delete from "+tabla+" where ("+condicion+");";
		ejecutarSQL(consulta);
	}

	@Override
	public List<Pago> select() {
		return selectByCondicion("true");
	}

	@Override
	public List<Pago> selectByCliente(Integer cliente) {
		String condicion = "";
		condicion += "cliente = " +(cliente != null ? "'"+cliente+"'" : "cliente");
		return selectByCondicion(condicion);
	}

	private List<Pago> selectByCondicion(String condicion) {
		List<Pago> ret = new ArrayList<Pago>();
		String comandoSQL = "select ID, "+campos+" from "+tabla+" where ("+condicion+");";  
		
		try { 
			Class.forName(driver); 
			Connection conexion = DriverManager.getConnection(cadenaConexion, usuarioBD, passwordBD); 
			Statement sentencia = conexion.createStatement ();
			ResultSet resultados = sentencia.executeQuery(comandoSQL);			

			while (resultados.next()) {
				ret.add(new Pago(
						resultados.getInt("ID"),
						resultados.getInt("cargo"),
						resultados.getInt("cliente"),
						resultados.getInt("importe"),
						resultados.getString("observaciones"),
						resultados.getDate("fecha")
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
	public Pago selectByFecha(Date fecha) {
		String condicion = "fecha = '"+fecha+"'";
		List<Pago> lista = selectByCondicion(condicion);
		if (lista.isEmpty())
			return null;
		return lista.get(0);
	}

	@Override
	public List<Pago> selectByClienteServivcio(Integer cliente, Integer servicio) {
		// TODO Auto-generated method stub
		return null;
	}
}
