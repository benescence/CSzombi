package com.revivir.cementerio.negocios;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.revivir.cementerio.persistencia.FactoryOBD;
import com.revivir.cementerio.persistencia.definidos.Sector;
import com.revivir.cementerio.persistencia.definidos.SubSector;
import com.revivir.cementerio.persistencia.entidades.Fallecido;
import com.revivir.cementerio.persistencia.entidades.Ubicacion;
import com.revivir.cementerio.persistencia.interfaces.UbicacionOBD;

public class Localizador {
	
	public static List<Sector> traerSectores() {
		List<Sector> ret = new ArrayList<>();
		for (Sector sector : Sector.values())
			ret.add(sector);
		return ret;
	}
	
	public static List<SubSector> traerSubSectores(Sector sector) {
		List<SubSector> ret = new ArrayList<>();
		
		if (sector == Sector.SEPULTURAS) {
			ret.add(SubSector.SEPULTURAS);
			ret.add(SubSector.INDIGENTES);
		}
		
		else if (sector == Sector.PALMERAS) {
			ret.add(SubSector.PALMERAS_ATAUD);
			ret.add(SubSector.PALMERAS_CENIZAS);
			ret.add(SubSector.PALMERAS_RESTOS);
			ret.add(SubSector.PALMERAS_SEPULTURAS);
		}

		else if (sector == Sector.NICHERA)
			ret.add(SubSector.NICHERA);
		
		else if (sector == Sector.CENIZARIO)
			ret.add(SubSector.CENIZARIO);
		
		else if (sector == Sector.BOVEDA)
			ret.add(SubSector.BOVEDA);
		
		return ret;
	}

	public static void guardarUbicacion(SubSector subsector, String otroCementerio,
			String osario, String nicho, String fila, String seccion, String macizo, String unidad,
			String bis, String bis_macizo, String numero, String sepultura, String parcela,
			String mueble, String inhumacion, String circ, Date vencimiento) {
		
		Ubicacion ubicacion = new Ubicacion(-1, subsector, otroCementerio,
				osario, nicho, fila, seccion, macizo, unidad, bis, bis_macizo, numero,
				sepultura, parcela, mueble, inhumacion, circ, vencimiento);
		
		UbicacionOBD obd = FactoryOBD.crearUbicacionOBD();
		obd.insert(ubicacion);
	}
	
	public static Ubicacion traerUltimaUbicacionGuardada() {
		UbicacionOBD obd = FactoryOBD.crearUbicacionOBD();
		return obd.ultimoInsertado();
	}
	
	public static Ubicacion traerUbicacionDeFallecido(Fallecido fallecido) {
		UbicacionOBD obd = FactoryOBD.crearUbicacionOBD();
		return obd.selectByFallecido(fallecido);
	}
	
}