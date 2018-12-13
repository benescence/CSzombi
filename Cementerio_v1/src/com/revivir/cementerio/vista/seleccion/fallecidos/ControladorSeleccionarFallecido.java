package com.revivir.cementerio.vista.seleccion.fallecidos;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import com.revivir.cementerio.persistencia.entidades.Fallecido;
import com.revivir.cementerio.vista.util.Popup;

public class ControladorSeleccionarFallecido {
	private VentanaSeleccionarFallecido ventana;
	private FallecidoSeleccionable invocador;

	public ControladorSeleccionarFallecido(FallecidoSeleccionable invocador) {
		this.invocador = invocador;
		ventana = new VentanaSeleccionarFallecido();
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
		List<Fallecido> seleccion = ventana.getTabla().obtenerSeleccion();
		if (seleccion.size() != 1)
			Popup.mostrar("Debe seleccionar exactamente un fallecido");
		else {
			invocador.seleccionarFallecido(seleccion.get(0));
			ventana.dispose();
			invocador.mostrar();
		}
	}
		
	private void cancelar() {
		ventana.dispose();
		invocador.mostrar();
	}
	
}