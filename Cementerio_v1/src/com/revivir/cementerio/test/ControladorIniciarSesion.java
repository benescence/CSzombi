package com.revivir.cementerio.test;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.revivir.cementerio.vista.util.PresionarEnterListener;

public class ControladorIniciarSesion {
	private VentanaIniciarSesion ventana;
	
	public ControladorIniciarSesion() {
		ventana = new VentanaIniciarSesion();
		ventana.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				cancelar();
			}
		});		

		ventana.botonAceptar().addActionListener(e -> aceptar());
		ventana.botonCancelar().addActionListener(e -> cancelar());
		ventana.botonAceptar().addKeyListener(new PresionarEnterListener(e -> aceptar()));
		ventana.botonCancelar().addKeyListener(new PresionarEnterListener(e -> cancelar()));
		
	}

	private void aceptar() {
		System.out.println("Aceptar");
	}


	private void cancelar() {
		System.out.println("Cancelar");
	}

}