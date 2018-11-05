package com.revivir.cementerio.vista.seleccion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import com.revivir.cementerio.persistencia.entidades.Cliente;
import com.revivir.cementerio.vista.util.Popup;

public class ControladorSeleccionCliente implements ActionListener{
	private VentanaSeleccionCliente ventana;
	private ClienteSeleccionable invocador;

	public ControladorSeleccionCliente(ClienteSeleccionable invocador) {
		this.invocador = invocador;
		ventana = new VentanaSeleccionCliente();
		ventana.botonCancelar().addActionListener(this);
		ventana.botonSeleccionar().addActionListener(this);
		ventana.mostrar();
	}

	public void actionPerformed(ActionEvent e) {
		// BOTON SELECCIONAR
		if (e.getSource() == ventana.botonSeleccionar())
			seleccionar();
	
		// BOTON CANCELAR
		else if (e.getSource() == ventana.botonCancelar())
			cancelar();
	}
	
	private void seleccionar() {
		List<Cliente> seleccion = ventana.getTabla().obtenerSeleccion();
		if (seleccion.size() != 1)
			Popup.mostrar("Debe seleccionar exactamente un cliente");
		else {
			invocador.setCliente(seleccion.get(0));
			ventana.dispose();
			invocador.mostrar();
		}
	}
		
	private void cancelar() {
		ventana.dispose();
		invocador.mostrar();
	}
	
}