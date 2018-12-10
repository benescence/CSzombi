package com.revivir.cementerio.vista.clientes;

import javax.swing.JInternalFrame;

import com.revivir.cementerio.vista.ControladorInterno;
import com.revivir.cementerio.vista.ControladorPrincipal;

public class ControladorClientesABM implements ControladorInterno {
	private VentanaClientesABM ventana;
	private ControladorPrincipal invocador;
	
	public ControladorClientesABM(ControladorPrincipal invocador) {
		System.out.println("Creando controlador cleinte");
		this.invocador = invocador;
		ventana = new VentanaClientesABM();
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
