package com.revivir.cementerio.vista.usuarios.alta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;

import com.revivir.cementerio.vista.ControladorInterno;

public class ControladorAltaUsuario implements ActionListener, ControladorInterno {
	private VentanaAltaUsuario ventana;
	
	public ControladorAltaUsuario() {
		ventana = new VentanaAltaUsuario();
		ventana.botonAceptar().addActionListener(this);
		ventana.mostrar();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ventana.botonAceptar())
			aceptar();
	}
	
	private void aceptar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean finalizar() {
		return true;
	}

	@Override
	public JInternalFrame getVentana() {
		return ventana;
	}
	
}