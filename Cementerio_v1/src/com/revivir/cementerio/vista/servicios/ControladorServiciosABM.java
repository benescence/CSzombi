package com.revivir.cementerio.vista.servicios;

import javax.swing.JInternalFrame;

import com.revivir.cementerio.vista.ControladorInterno;
import com.revivir.cementerio.vista.ControladorPrincipal;
import com.revivir.cementerio.vista.servicios.servicioAM.ControladorServicioAM;

public class ControladorServiciosABM implements ControladorInterno {
	private VentanaServiciosABM ventana;
	private ControladorPrincipal invocador;
	
	public ControladorServiciosABM(ControladorPrincipal invocador) {
		this.invocador = invocador;
		ventana = new VentanaServiciosABM();
		ventana.botonAgregar().addActionListener(e -> agregar());
	}
	
	private void agregar() {
		invocador.getVentana().setEnabled(false);
		new ControladorServicioAM(this);
	}

	
	
	
	@Override
	public boolean finalizar() {
		return true;
	}
	

	public void mostrar() {
		invocador.getVentana().setEnabled(true);
		invocador.getVentana().toFront();
	}

	@Override
	public JInternalFrame getVentana() {
		
		return ventana;
	}

}
