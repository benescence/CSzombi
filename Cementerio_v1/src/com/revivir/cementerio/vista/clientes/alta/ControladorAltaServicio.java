package com.revivir.cementerio.vista.clientes.alta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JInternalFrame;

import com.revivir.cementerio.negocios.Localizador;
import com.revivir.cementerio.negocios.manager.ClienteManager;
import com.revivir.cementerio.negocios.manager.FallecidoManager;
import com.revivir.cementerio.persistencia.definidos.SubSector;
import com.revivir.cementerio.persistencia.definidos.TipoFallecimiento;
import com.revivir.cementerio.persistencia.entidades.Cliente;
import com.revivir.cementerio.vista.ControladorInterno;
import com.revivir.cementerio.vista.seleccion.ClienteSeleccionable;
import com.revivir.cementerio.vista.seleccion.ControladorSeleccionCliente;
import com.revivir.cementerio.vista.util.Popup;

public class ControladorAltaServicio implements ActionListener, ClienteSeleccionable, ControladorInterno{
	private VentanaAltaServicio ventana;
	private Cliente cliente = null;

	public ControladorAltaServicio() {
		ventana = new VentanaAltaServicio();
		ventana.botonExistente().addActionListener(this);
		ventana.botonLimpiarCliente().addActionListener(this);
		ventana.botonConfirmar().addActionListener(this);
		ventana.botonLimpiarTodo().addActionListener(this);
		ventana.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ventana.botonExistente())
			seleccionarCliente();
	
		else if (e.getSource() == ventana.botonLimpiarCliente())
			limpiarCliente();

		else if (e.getSource() == ventana.botonLimpiarTodo())
			limpiarTodo();
		
		else if (e.getSource() == ventana.botonConfirmar())
			confirmar();
	}
	
	private void confirmar() {

		// GUARDO AL CLIENTE
		if (cliente == null) {
			String DNI = ventana.getDNI().getText();
			String nombres = ventana.getNombre().getText();
			String apellidos  = ventana.getApellido().getText();
			String telefono = ventana.getTelefono().getText();
			String email = ventana.getEmail().getText();
			ClienteManager.guardarCliente(DNI, nombres, apellidos, telefono, email);
			cliente = ClienteManager.traerPorDNI(DNI);
		}
		
		// GUARDAR LA UBICACION
		SubSector subsector = (SubSector) ventana.getInSubSector().getSelectedItem();
		Integer deposito = null;
		String otroCementerio = null;
		String osario = null;
		String nicho = null;
		String fila = null;
		String seccion = null;
		String macizo= null;
		String unidad = null;
		String bis = "a";
		String bis_macizo = null;
		String numero= null;
		String sepultura = null;
		String parcela= null;
		String mueble= null;
		String inhumacion = null;
		String circ = null;
		
		Localizador.guardarUbicacion(subsector, deposito, otroCementerio, osario, nicho, fila, seccion,
				macizo, unidad, bis, bis_macizo, numero, sepultura, parcela, mueble, inhumacion, circ);
		
		// GUARDO AL FALLECIDO
		Integer ubicacion = 1;
		TipoFallecimiento tipo = (TipoFallecimiento) ventana.getInTipoFallecimiento().getSelectedItem();
		String dni = null;
		String apellido= null;
		String nombre= null;
		String cocheria= null;
		Date fechaFallecimiento = new Date(ventana.getInFechaFallecimiento().getDate().getTime());
		FallecidoManager.guardarFallecido(cliente.getID(), ubicacion, tipo, dni, apellido, nombre, cocheria, fechaFallecimiento);
		
		// FINALIZO EL GUARDADO
		Popup.mostrar("El servicio se ha guardado exitosamente");
		limpiarTodo();
	}

	private void limpiarTodo() {
		limpiarCliente();
		ventana.getInNombreFallecido().setText("");
		ventana.getInApellidoFallecido().setText("");
		ventana.getInDNIFallecido().setText("");
		ventana.getInCirc().setText("");
		ventana.getInFila().setText("");
		ventana.getInUnidad().setText("");
		ventana.getInNicho().setText("");
		ventana.getInSeccion().setText("");
		ventana.getInCheckBis().setSelected(false);
		ventana.getInCheckMacizo().setSelected(false);
	}

	private void seleccionarCliente() {
		ventana.deshabilitar();
		new ControladorSeleccionCliente(this);
	}
		
	private void limpiarCliente() {
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