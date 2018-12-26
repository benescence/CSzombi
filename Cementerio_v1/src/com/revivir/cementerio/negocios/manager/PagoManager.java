package com.revivir.cementerio.negocios.manager;

import java.util.List;

import com.revivir.cementerio.negocios.Verificador;
import com.revivir.cementerio.persistencia.FactoryOBD;
import com.revivir.cementerio.persistencia.entidades.Pago;
import com.revivir.cementerio.persistencia.interfaces.PagoOBD;

public class PagoManager {

	public static void guardar(Pago nuevo) throws Exception {
		nuevo = Verificador.pago(nuevo);
		PagoOBD obd = FactoryOBD.crearPagoOBD();
		obd.insert(nuevo);
	}

	public static void modificar(Pago modificar) throws Exception {
		modificar = Verificador.pago(modificar);
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