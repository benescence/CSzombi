package com.revivir.cementerio.test.seleccionar;

import com.revivir.cementerio.persistencia.entidades.Servicio;
import com.revivir.cementerio.vista.seleccion.servicio.ControladorSeleccionarServicio;
import com.revivir.cementerio.vista.seleccion.servicio.ServicioSeleccionable;

public class SeleccionarServicioTest implements ServicioSeleccionable {

	@Override
	public void seleccionarServicio(Servicio fallecido) {
		System.out.println("Se ha seleccionado el servicio: "+fallecido.getNombre()+", "+fallecido.getCodigo());
	}

	@Override
	public void mostrar() {
	
	}
	
	public static void main(String[] args) {
		new ControladorSeleccionarServicio(new SeleccionarServicioTest());
	}

}