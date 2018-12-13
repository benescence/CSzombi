package com.revivir.cementerio.vista.seleccion.servicio;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import com.revivir.cementerio.persistencia.entidades.Servicio;
import com.revivir.cementerio.vista.util.Popup;

public class ControladorSeleccionarServicio {
	private VentanaSeleccionarServicio ventana;
	private ServicioSeleccionable invocador;

	public ControladorSeleccionarServicio(ServicioSeleccionable invocador) {
		this.invocador = invocador;
		ventana = new VentanaSeleccionarServicio();
		ventana.botonAceptar().addActionListener(e -> seleccionar());
		ventana.botonCancelar().addActionListener(e -> cancelar());
		ventana.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				cancelar();
			}
		});
	}

	private void seleccionar() {
		List<Servicio> seleccion = ventana.getTabla().obtenerSeleccion();
		if (seleccion.size() != 1)
			Popup.mostrar("Debe seleccionar exactamente un servicio");
		else {
			invocador.seleccionarServicio(seleccion.get(0));
			ventana.dispose();
			invocador.mostrar();
		}
	}
		
	private void cancelar() {
		ventana.dispose();
		invocador.mostrar();
	}
	
}