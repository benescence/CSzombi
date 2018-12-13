package com.revivir.cementerio.negocios.manager;

import java.util.List;

import com.revivir.cementerio.persistencia.FactoryOBD;
import com.revivir.cementerio.persistencia.entidades.Cargo;
import com.revivir.cementerio.persistencia.entidades.Fallecido;
import com.revivir.cementerio.persistencia.entidades.Servicio;
import com.revivir.cementerio.persistencia.interfaces.CargoOBD;

public class CargoManager {

	public static void guardar(Fallecido fallecido, Servicio servicio, String observaciones, Boolean pagado) {
		Cargo nuevo = new Cargo(-1, fallecido.getID(), servicio.getID(), observaciones, pagado);
		CargoOBD obd = FactoryOBD.crearCargoOBD();
		obd.insert(nuevo);
	}

	public static void modificar(Cargo modificar) {
		CargoOBD obd = FactoryOBD.crearCargoOBD();
		obd.insert(modificar);
	}
		
	public static void eliminar(Cargo eliminar) {
		CargoOBD obd = FactoryOBD.crearCargoOBD();
		obd.delete(eliminar);
	}
	
	public static List<Cargo> traerTodo() {
		CargoOBD obd = FactoryOBD.crearCargoOBD();
		return obd.select();
	}
	
	public static List<Cargo> traerPorFallecido(Fallecido fallecido) {
		CargoOBD obd = FactoryOBD.crearCargoOBD();
		return obd.selectByFallecido(fallecido);
	}
	
}