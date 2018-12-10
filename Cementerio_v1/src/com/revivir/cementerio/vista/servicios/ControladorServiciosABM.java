package com.revivir.cementerio.vista.servicios;

import javax.swing.JInternalFrame;

import com.revivir.cementerio.vista.ControladorInterno;
import com.revivir.cementerio.vista.ControladorPrincipal;

public class ControladorServiciosABM implements ControladorInterno {
	private VentanaServiciosABM ventana;
	private ControladorPrincipal invocador;
	
	public ControladorServiciosABM(ControladorPrincipal invocador) {
		this.invocador = invocador;
		ventana = new VentanaServiciosABM();
	}

	
	
	
	@Override
	public boolean finalizar() {
		return true;
	}
	
	public void name() {
		invocador.getVentana().setEnabled(false);
	}

	@Override
	public JInternalFrame getVentana() {
		
		return ventana;
	}

}
