package com.revivir.cementerio.vista.clientes;

import javax.swing.JInternalFrame;

import com.revivir.cementerio.vista.ControladorInterno;
import com.revivir.cementerio.vista.ControladorPrincipal;
import com.revivir.cementerio.vista.clientes.clienteAM.ControladorClientesAM;

public class ControladorClientesABM implements ControladorInterno {
	private VentanaClientesABM ventana;
	private ControladorPrincipal invocador;
	
	public ControladorClientesABM(ControladorPrincipal invocador) {
		this.invocador = invocador;
		ventana = new VentanaClientesABM();
		ventana.botonAgregar().addActionListener(e -> agregar());
	}
	
	private void agregar() {
		invocador.getVentana().setEnabled(false);
		new ControladorClientesAM(this);
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
