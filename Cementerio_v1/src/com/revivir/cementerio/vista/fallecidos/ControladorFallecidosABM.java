package com.revivir.cementerio.vista.fallecidos;

import javax.swing.JInternalFrame;

import com.revivir.cementerio.vista.ControladorInterno;
import com.revivir.cementerio.vista.ControladorPrincipal;

public class ControladorFallecidosABM implements ControladorInterno {
	private VentanaFallecidosABM ventana;
	private ControladorPrincipal invocador;
	
	public ControladorFallecidosABM(ControladorPrincipal invocador) {
		this.invocador = invocador;
		ventana = new VentanaFallecidosABM();
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