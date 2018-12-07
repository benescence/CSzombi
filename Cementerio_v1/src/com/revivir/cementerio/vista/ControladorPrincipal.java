package com.revivir.cementerio.vista;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.revivir.cementerio.vista.util.Popup;

public class ControladorPrincipal {
	VentanaPrincipal ventana;
	ControladorInterno controladorInterno;
	
	public ControladorPrincipal() {
		ventana = new VentanaPrincipal();
		ventana.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				cerrarAplicacion();
			}
		});
	}

	private void cerrarAplicacion() {
		if (Popup.confirmar("�Est� seguro de que desea cerrar la aplicaci�n?")) {
			ventana.dispose();
			ventana = null;
		}
	}
	
}