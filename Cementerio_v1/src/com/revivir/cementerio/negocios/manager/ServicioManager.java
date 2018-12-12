package com.revivir.cementerio.negocios.manager;

import java.util.List;

import com.revivir.cementerio.persistencia.FactoryOBD;
import com.revivir.cementerio.persistencia.entidades.Servicio;
import com.revivir.cementerio.persistencia.interfaces.ServicioOBD;

public class ServicioManager {

	public static void crearServicio(int codigo, String nombre, Double monto, String descripcion, Integer historico) {
		Servicio precio = new Servicio(-1, codigo, descripcion, monto, nombre, historico);
		ServicioOBD obd = FactoryOBD.crearPrecioOBD();
		obd.insert(precio);
	}

	public static void modificar(Servicio precio) {
			
	}
		
	public static void eliminar(Servicio precio) {
		
	}
	
	public static List<Servicio> traerTodo() {
		ServicioOBD obd = FactoryOBD.crearPrecioOBD();
		return obd.select();
	}
	
	public static Servicio traerPorID(int ID) {
		return null;
	}
	
	public static Servicio traerPorCodigo(int codigo) {
		ServicioOBD obd = FactoryOBD.crearPrecioOBD();		
		return obd.selectBycodigo(codigo);
	}
}
