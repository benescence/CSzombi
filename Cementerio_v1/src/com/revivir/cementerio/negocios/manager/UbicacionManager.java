package com.revivir.cementerio.negocios.manager;

import java.util.List;

import com.revivir.cementerio.persistencia.FactoryOBD;
import com.revivir.cementerio.persistencia.definidos.SubSector;
import com.revivir.cementerio.persistencia.entidades.Fallecido;
import com.revivir.cementerio.persistencia.entidades.Ubicacion;
import com.revivir.cementerio.persistencia.interfaces.UbicacionOBD;

public class UbicacionManager {

	public static void guardar(SubSector subsector, String otroCementerio, Integer nicho, Integer fila, String seccion, Integer macizo, Integer unidad,
			Integer bis, Integer bis_macizo, Integer numero, Integer sepultura, Integer parcela,
			Integer mueble, Integer inhumacion, Integer circ) {
		
		Ubicacion nuevo = new Ubicacion(-1, subsector, otroCementerio, nicho, fila, seccion, macizo, unidad, bis, bis_macizo,
				sepultura, parcela, mueble, inhumacion, circ);
		UbicacionOBD obd = FactoryOBD.crearUbicacionOBD();
		obd.insert(nuevo);
	}

	public static void modificar(Ubicacion modificar) {
		UbicacionOBD obd = FactoryOBD.crearUbicacionOBD();
		obd.update(modificar);
	}
		
	public static void eliminar(Ubicacion eliminar) {
		UbicacionOBD obd = FactoryOBD.crearUbicacionOBD();
		obd.delete(eliminar);
	}
	
	public static List<Ubicacion> traerTodo() {
		UbicacionOBD obd = FactoryOBD.crearUbicacionOBD();
		return obd.select();
	}
	
	public static Ubicacion traerPorFallecido(Fallecido fallecido) {
		UbicacionOBD obd = FactoryOBD.crearUbicacionOBD();
		return obd.selectByFallecido(fallecido);
	}
	
	public static Ubicacion traerMasReciente() {
		UbicacionOBD obd = FactoryOBD.crearUbicacionOBD();
		return obd.ultimoInsertado();
	}
	
}