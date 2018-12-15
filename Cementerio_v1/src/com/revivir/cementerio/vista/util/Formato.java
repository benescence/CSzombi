package com.revivir.cementerio.vista.util;

import com.revivir.cementerio.negocios.Localizador;
import com.revivir.cementerio.negocios.manager.CargoManager;
import com.revivir.cementerio.negocios.manager.ClienteManager;
import com.revivir.cementerio.negocios.manager.FallecidoManager;
import com.revivir.cementerio.negocios.manager.ServicioManager;
import com.revivir.cementerio.persistencia.entidades.Cargo;
import com.revivir.cementerio.persistencia.entidades.Cliente;
import com.revivir.cementerio.persistencia.entidades.Fallecido;
import com.revivir.cementerio.persistencia.entidades.Pago;
import com.revivir.cementerio.persistencia.entidades.Servicio;
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

	public static String cliente(Pago pago) {
		Cliente cliente = ClienteManager.traerPorID(pago.getCliente());
		return cliente.getApellido()+", "+cliente.getNombre();
	}

	public static String cargo(Pago pago) {
		Cargo cargo = CargoManager.traerPorID(pago.getCargo());
		return servicio(cargo);
	}

	public static String fallecido(Cargo cargo) {
		Fallecido fallecido = FallecidoManager.traerPorID(cargo.getFallecido());
		return fallecido.getApellido()+", "+fallecido.getNombre();
	}

	public static String servicio(Cargo cargo) {
		Servicio servicio = ServicioManager.traerPorID(cargo.getServicio());
		return servicio.getNombre();
	}
	
	
	/*public static String fallecidos(Cliente cliente) {
		List<Fallecido> fallecidos = FallecidoManager.traerPorCliente(cliente);
		String ret = "<html>";

		for (Fallecido fallecido : fallecidos) {
			String nombre = fallecido.getApellido()+", "+fallecido.getNombre();
			if (fallecido != fallecidos.get(0))
				nombre = "<br>" + nombre;
			ret += nombre;
		}
		
		return ret += "</html>";
	}
*/
	public static Integer contarRenglones(String texto) {
		Integer cantidad = 1;
		
		for (int i = 0; i < texto.length()-3; i++)
			if (texto.charAt(i) == '<' && texto.charAt(i+1) == 'b' && texto.charAt(i+2) == 'r' && texto.charAt(i+3) == '>')
				cantidad++;
		
		return cantidad;
	}
	
	public static Integer calcularAlturaDeCelda(Object[] fila) {
		int renglonesMaximo = 0;
		for (Object objecto : fila) {
			int renglones = Formato.contarRenglones((String)objecto);
			if (renglones>renglonesMaximo)
				renglonesMaximo = renglones;
		}
		
		return renglonesMaximo*20;
	}

}