package com.revivir.cementerio.vista.clientes.alta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JInternalFrame;

import com.revivir.cementerio.persistencia.entidades.Cliente;
import com.revivir.cementerio.persistencia.mysql.ClienteOBDMySQL;
import com.revivir.cementerio.vista.ControladorInterno;
import com.revivir.cementerio.vista.seleccion.ClienteSeleccionable;
import com.revivir.cementerio.vista.seleccion.ControladorSeleccionCliente;
import com.revivir.cementerio.vista.seleccion.VentanaSeleccionCliente;
import pantallas.Main;

public class ControladorAltaServicio implements ActionListener, ClienteSeleccionable, ControladorInterno{
	private VentanaAltaServicio ventana;
	private Cliente cliente = null;

	public ControladorAltaServicio() {
		ventana = new VentanaAltaServicio();
		ventana.botonExistente().addActionListener(this);
		ventana.botonLimpiar().addActionListener(this);
		ventana.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		// BOTON EXISTENTE
		if (e.getSource() == ventana.botonExistente())
			seleccionarCliente();
	
		// BOTON CANCELAR
		else if (e.getSource() == ventana.botonLimpiar())
			limpiarCampos();
	}
	
	private void seleccionarCliente() {
		ventana.deshabilitar();
		new ControladorSeleccionCliente(this);
	}
		
	private void limpiarCampos() {
		cliente = null;
		ventana.getDNI().setText("");
		ventana.getApellido().setText("");
		ventana.getNombre().setText("");
		ventana.getTelefono().setText("");
		ventana.getEmail().setText("");
		
		ventana.getDNI().setEnabled(true);
		ventana.getApellido().setEnabled(true);
		ventana.getNombre().setEnabled(true);
		ventana.getTelefono().setEnabled(true);
		ventana.getEmail().setEnabled(true);
	}

	@Override
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
		ventana.getDNI().setText(cliente.getDni());
		ventana.getNombre().setText(cliente.getNombre());
		ventana.getApellido().setText(cliente.getApellido());
		ventana.getTelefono().setText(cliente.getTelefono());
		ventana.getEmail().setText(cliente.getEmail());
		
		ventana.getDNI().setEnabled(false);
		ventana.getApellido().setEnabled(false);
		ventana.getNombre().setEnabled(false);
		ventana.getTelefono().setEnabled(false);
		ventana.getEmail().setEnabled(false);
	}

	@Override
	public void mostrar() {
		ventana.mostrar();
	}

	public JInternalFrame getVentana() {
		return ventana;
	}

	@Override
	public void finalizar() {
		ventana.dispose();
		ventana = null;
	}

	}