package com.revivir.cementerio.negocios.manager;

import java.util.List;

import com.revivir.cementerio.negocios.Verificador;
import com.revivir.cementerio.persistencia.FactoryOBD;
import com.revivir.cementerio.persistencia.entidades.Cargo;
import com.revivir.cementerio.persistencia.entidades.Fallecido;
import com.revivir.cementerio.persistencia.interfaces.CargoOBD;

public class CargoManager {

	public static void guardar(Cargo cargo) throws Exception {
		cargo = Verificador.cargo(cargo, null);
		CargoOBD obd = FactoryOBD.crearCargoOBD();
		obd.insert(cargo);
	}

	public static void modificar(Cargo nuevo, Cargo anterior) throws Exception {
		nuevo = Verificador.cargo(nuevo, anterior);
		CargoOBD obd = FactoryOBD.crearCargoOBD();
		obd.update(nuevo);
	}
		
	public static void eliminar(Cargo eliminar) {
		CargoOBD obd = FactoryOBD.crearCargoOBD();
		obd.delete(eliminar);
	}

	public static List<Cargo> traerTodo() {
		CargoOBD obd = FactoryOBD.crearCargoOBD();
		return obd.select();
	}

	public static Cargo traerPorID(Integer ID) {
		CargoOBD obd = FactoryOBD.crearCargoOBD();
		return obd.selectByID(ID);
	}
	
	public static List<Cargo> traerPorFallecido(Fallecido fallecido) {
		CargoOBD obd = FactoryOBD.crearCargoOBD();
		return obd.selectByFallecido(fallecido);
	}
	
}