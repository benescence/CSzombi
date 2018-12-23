package com.revivir.cementerio.vista.clientes2.busqueda.cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;

import com.revivir.cementerio.vista.ControladorInterno;


public class ControladorConsultaCliente implements ActionListener, ControladorInterno{
	private VentanaConsultaCliente ventana;
	
	public ControladorConsultaCliente() {
		ventana = new VentanaConsultaCliente();
		ventana.botonBuscar().addActionListener(this);
		ventana.botonLimpiar().addActionListener(this);
		//ventana.mostrar();
	}

	public void actionPerformed(ActionEvent e) {
		// BOTON BUSCAR
		if (e.getSource() == ventana.botonBuscar())
			buscar();
	
		// BOTON LIMPIAR CAMPOS
		else if (e.getSource() == ventana.botonLimpiar())
			limpiar();
	}
	
	private void limpiar() {
		ventana.getDNI().setText("");
		ventana.getNombre().setText("");
		ventana.getApellido().setText("");		
	}

	private void buscar() {
		String DNI = (ventana.getDNI().getText().equals("") ? null : ventana.getDNI().getText());
		String nombres = (ventana.getNombre().getText().equals("") ? null : ventana.getNombre().getText());
		String apellido = (ventana.getApellido().getText().equals("") ? null : ventana.getApellido().getText());
	//List<Cliente> clientes = Busqueda.clientes(DNI, nombres, apellido);
		//ventana.getTabla().recargar(clientes);
		//if (clientes.size() == 0)
			//Popup.mostrar("No se ha encontrado ningun resultado con los criterios ingresados.");
	}

	@Override
	public boolean finalizar() {
		ventana.dispose();
		ventana = null;
		return true;
	}

	@Override
	public JInternalFrame getVentana() {
		return ventana;
	}
	
}