package com.revivir.cementerio.negocios.manager;

import java.util.List;

import com.revivir.cementerio.negocios.Verificador;
import com.revivir.cementerio.persistencia.FactoryOBD;
import com.revivir.cementerio.persistencia.entidades.Servicio;
import com.revivir.cementerio.persistencia.interfaces.ServicioOBD;

public class ServicioManager {

	public static void guardar(Servicio nuevo) throws Exception {
		Servicio servicio = Verificador.servicio(nuevo, null); 
		ServicioOBD obd = FactoryOBD.crearServicioOBD();
		obd.insert(servicio);
	}

	public static void modificar(Servicio nuevo, Servicio anterior) throws Exception {
		Servicio servicio = Verificador.servicio(nuevo, anterior);
		ServicioOBD obd = FactoryOBD.crearServicioOBD();
		
		// El anterior pasa aser historico
		anterior.setHistorico(true);
		obd.update(anterior);
		
		// El actual lo inserto como uno nuevo
		obd.insert(servicio);
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
	
	public static Servicio traerMasReciente() {
		ServicioOBD obd = FactoryOBD.crearServicioOBD();
		return obd.ultimoInsertado();
	}
	
	public static Servicio traerActivoPorCodigo(String codigo) {
		ServicioOBD obd = FactoryOBD.crearServicioOBD();	
		return obd.selectActivoBycodigo(codigo);
	}

}