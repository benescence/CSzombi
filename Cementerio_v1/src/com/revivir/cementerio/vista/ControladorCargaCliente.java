package com.revivir.cementerio.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import com.revivir.cementerio.persistencia.entidades.Cliente;
import com.revivir.cementerio.persistencia.mysql.ClienteOBDMySQL;
import com.revivir.cementerio.vista.seleccion.ClienteSeleccionable;
import com.revivir.cementerio.vista.seleccion.ControladorSeleccionCliente;
import com.revivir.cementerio.vista.seleccion.VentanaSeleccionCliente;
import pantallas.Main;

public class ControladorCargaCliente implements ActionListener, ClienteSeleccionable{
	private VentanaCargaClientes ventana;
	private Cliente cliente = null;

	public ControladorCargaCliente() {
		ventana = new VentanaCargaClientes();
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

	public VentanaCargaClientes getVentana() {
		return ventana;
	}
}