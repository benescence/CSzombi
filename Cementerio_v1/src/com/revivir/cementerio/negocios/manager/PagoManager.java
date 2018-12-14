package com.revivir.cementerio.negocios.manager;

import java.sql.Date;
import java.util.List;

import com.revivir.cementerio.persistencia.FactoryOBD;
import com.revivir.cementerio.persistencia.entidades.Cargo;
import com.revivir.cementerio.persistencia.entidades.Cliente;
import com.revivir.cementerio.persistencia.entidades.Pago;
import com.revivir.cementerio.persistencia.interfaces.PagoOBD;

public class PagoManager {

	public static void guardar(Cargo cargo, Cliente cliente, String observaciones, Integer importe, Date fecha) {
		Pago nuevo = new Pago(-1, cargo.getID(), cliente.getID(), importe, observaciones, fecha);
		PagoOBD obd = FactoryOBD.crearPagoOBD();
		obd.insert(nuevo);
	}

	public static void modificar(Pago modificar) {
		PagoOBD obd = FactoryOBD.crearPagoOBD();
		obd.update(modificar);
	}
		
	public static void eliminar(Pago eliminar) {
		PagoOBD obd = FactoryOBD.crearPagoOBD();
		obd.delete(eliminar);
	}
	
	public static List<Pago> traerTodo() {
		PagoOBD obd = FactoryOBD.crearPagoOBD();
		return obd.select();
	}
	
}