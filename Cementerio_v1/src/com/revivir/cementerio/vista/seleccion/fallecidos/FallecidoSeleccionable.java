package com.revivir.cementerio.vista.seleccion.fallecidos;

import com.revivir.cementerio.persistencia.entidades.Fallecido;

public interface FallecidoSeleccionable {
	
	public void seleccionarFallecido(Fallecido fallecido);
	
	public void mostrar();

}