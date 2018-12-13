package com.revivir.cementerio.negocios.manager;

import java.util.List;

import com.revivir.cementerio.persistencia.FactoryOBD;
import com.revivir.cementerio.persistencia.entidades.Servicio;
import com.revivir.cementerio.persistencia.interfaces.ServicioOBD;

public class ServicioManager {

	public static void guardar(String codigo, String nombre, Double importe, String descripcion, boolean historico) {
		Servicio servicio = new Servicio(-1, codigo, nombre, descripcion, importe, historico);
		ServicioOBD obd = FactoryOBD.crearServicioOBD();
		obd.insert(servicio);
	}

	public static void modificar(Servicio servicio) {
		ServicioOBD obd = FactoryOBD.crearServicioOBD();
		obd.update(servicio);
	}
		
	public static void eliminar(Servicio servicio) {
		ServicioOBD obd = FactoryOBD.crearServicioOBD();
		obd.delete(servicio);
	}
	
	public static List<Servicio> traerTodo() {
		ServicioOBD obd = FactoryOBD.crearServicioOBD();
		return obd.select();
	}
	
	public static Servicio traerPorID(Integer ID) {
		ServicioOBD obd = FactoryOBD.crearServicioOBD();
		return obd.selectByID(ID);
	}
	
	public static Servicio traerPorCodigo(String codigo) {
		ServicioOBD obd = FactoryOBD.crearServicioOBD();	
		return obd.selectBycodigo(codigo);
	}

}