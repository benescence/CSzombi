package com.revivir.cementerio.vista;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.revivir.cementerio.vista.servicios.ControladorServiciosABM;
import com.revivir.cementerio.vista.util.PanelVertical;
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
		
		// Acciones para las opciones de menu
		ventana.getServicioConsulta().addActionListener(e -> servicioConsulta());
	}

	private void servicioConsulta() {
		mostrarVentana(new ControladorServiciosABM(this));
	}
	
	private void mostrarVentana(ControladorInterno controlador) {
		if (controladorInterno == null || controladorInterno.finalizar()) {
	        controladorInterno = controlador;
	        PanelVertical panel = new PanelVertical();
	        panel.add(controladorInterno.getVentana());
			ventana.setContentPane(panel);
		}
	}
	
	private void cerrarAplicacion() {
		if (Popup.confirmar("¿Está seguro de que desea cerrar la aplicación?")) {
			ventana.dispose();
			ventana = null;
		}
	}
	
	public VentanaPrincipal getVentana() {
		return ventana;
	}
	
}