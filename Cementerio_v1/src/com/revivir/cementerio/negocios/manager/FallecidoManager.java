package com.revivir.cementerio.negocios.manager;

import java.sql.Date;
import java.util.List;

import com.revivir.cementerio.persistencia.FactoryOBD;
import com.revivir.cementerio.persistencia.definidos.TipoFallecimiento;
import com.revivir.cementerio.persistencia.entidades.Fallecido;
import com.revivir.cementerio.persistencia.entidades.Ubicacion;
import com.revivir.cementerio.persistencia.interfaces.FallecidoOBD;

public class FallecidoManager {
	
	public static void guardar(String nombre, String apellido, String dni, String cocheria,  
			TipoFallecimiento tipo, Date fecha, Ubicacion ubicacion) {
		
		Fallecido fallecido = new Fallecido(-1, ubicacion.getId(), tipo, dni, apellido,
				nombre, cocheria, fecha);
		
		FallecidoOBD obd = FactoryOBD.crearFallecidoOBD();
		obd.insert(fallecido);	
	}

	public static void modificar(Fallecido fallecido) {
		FallecidoOBD obd = FactoryOBD.crearFallecidoOBD();
		obd.update(fallecido);
	}
	
	public static void eliminar(Fallecido fallecido) {
		FallecidoOBD obd = FactoryOBD.crearFallecidoOBD();
		obd.delete(fallecido);
	}
	
	public static List<Fallecido> traerTodo() {
		FallecidoOBD obd = FactoryOBD.crearFallecidoOBD();
		return obd.select();
	}

	public static Fallecido traerPorDNI(String DNI) {
		FallecidoOBD obd = FactoryOBD.crearFallecidoOBD();
		return obd.selectByDNI(DNI);
	}

}