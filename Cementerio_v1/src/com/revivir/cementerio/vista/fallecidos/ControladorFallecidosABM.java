package com.revivir.cementerio.vista.fallecidos;

import javax.swing.JInternalFrame;

import com.revivir.cementerio.vista.ControladorInterno;
import com.revivir.cementerio.vista.ControladorPrincipal;
import com.revivir.cementerio.vista.fallecidos.fallecidoAM.ControladorFallecidoAM;

public class ControladorFallecidosABM implements ControladorInterno {
	private VentanaFallecidosABM ventana;
	private ControladorPrincipal invocador;
	
	public ControladorFallecidosABM(ControladorPrincipal invocador) {
		this.invocador = invocador;
		ventana = new VentanaFallecidosABM();
		ventana.botonAgregar().addActionListener(e -> agregar());
	}

	private void agregar() {
		invocador.getVentana().setEnabled(false);
		new ControladorFallecidoAM(this);
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