package com.revivir.cementerio.vista.util;

import com.revivir.cementerio.negocios.Localizador;
import com.revivir.cementerio.persistencia.entidades.Fallecido;
import com.revivir.cementerio.persistencia.entidades.Ubicacion;

public class Formato {
	
	public static String ubicacion(Ubicacion ubicacion) {
		String ret = "Sector "+ubicacion.getSubsector();
		ret += (ubicacion.getNicho() != null) ? ", nicho "+ubicacion.getNicho() : ""; 
		ret += (ubicacion.getFila() != null) ? ", fila "+ubicacion.getFila() : ""; 
		ret += (ubicacion.getSeccion() != null) ? ", seccion "+ubicacion.getSeccion() : ""; 
		ret += (ubicacion.getMacizo() != null) ? ", macizo "+ubicacion.getMacizo() : ""; 
		ret += (ubicacion.getUnidad() != null) ? ", unidad "+ubicacion.getUnidad() : ""; 
		ret += (ubicacion.getBis() != null) ? ", bis "+ubicacion.getBis() : ""; 
		ret += (ubicacion.getBis_macizo() != null) ? ", bis macizo "+ubicacion.getBis_macizo() : ""; 
		ret += (ubicacion.getNumero() != null) ? ", numero "+ubicacion.getNumero(): ""; 
		ret += (ubicacion.getSepultura() != null) ? ", sepultura "+ubicacion.getSepultura() : ""; 
		ret += (ubicacion.getParcela() != null) ? ", parcela "+ubicacion.getParcela() : ""; 
		ret += (ubicacion.getMueble() != null) ? ", mueble "+ubicacion.getMueble() : ""; 
		ret += (ubicacion.getInhumacion() != null) ? ", inhumacion "+ubicacion.getInhumacion() : ""; 
		ret += (ubicacion.getCirc() != null) ? ", circ "+ubicacion.getCirc() : ""; 
		return ret;
	}
	
	public static String ubicacion(Fallecido fallecido) {
		Ubicacion ubicacion = Localizador.traerUbicacionDeFallecido(fallecido);
		return ubicacion(ubicacion);
	}

}