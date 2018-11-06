package com.revivir.cementerio.vista.clientes.busqueda.cliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JInternalFrame;

import com.revivir.cementerio.negocios.Busqueda;
import com.revivir.cementerio.persistencia.entidades.Cliente;
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
		List<Cliente> clientes = Busqueda.clientes(DNI, nombres, apellido);
		ventana.getTabla().recargar(clientes);
	}

	@Override
	public void finalizar() {
		ventana.dispose();
		ventana = null;
	}

	@Override
	public JInternalFrame getVentana() {
		return ventana;
	}
	
}