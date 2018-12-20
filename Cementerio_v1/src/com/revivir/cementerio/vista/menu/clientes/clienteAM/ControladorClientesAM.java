package com.revivir.cementerio.vista.menu.clientes.clienteAM;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.revivir.cementerio.negocios.Recepcion;
import com.revivir.cementerio.negocios.manager.ClienteManager;
import com.revivir.cementerio.persistencia.entidades.Cliente;
import com.revivir.cementerio.vista.ControladorInterno;
import com.revivir.cementerio.vista.ControladorPrincipal;
import com.revivir.cementerio.vista.menu.clientes.ControladorClientesABM;
import com.revivir.cementerio.vista.util.EntradaMouse;
import com.revivir.cementerio.vista.util.Popup;
import com.revivir.cementerio.vista.util.PresionarEnterListener;

public class ControladorClientesAM {
	private VentanaClientesAM ventana;
	private ControladorClientesABM invocador;
	private ControladorPrincipal principal;
	private Cliente cliente;
	
	public ControladorClientesAM(ControladorClientesABM invocador, Cliente cliente) {
		this.invocador = invocador;
		this.cliente = cliente;
		ventana = new VentanaClientesAM(cliente);
		inicializar();
	}
	
	public ControladorClientesAM(ControladorClientesABM invocador) {
		this.invocador = invocador;
		ventana = new VentanaClientesAM();
		inicializar();
	}
	
	public ControladorClientesAM(ControladorPrincipal invocador) {
		this.principal = invocador;
		ventana = new VentanaClientesAM();
		inicializar();
	}
	
	private void inicializar() {
		ventana.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				cancelar();
			}
		});
		
		ventana.botonAceptar().addKeyListener(new PresionarEnterListener(e -> aceptar()));
		ventana.botonCancelar().addKeyListener(new PresionarEnterListener(e -> cancelar()));
		
		ventana.botonAceptar().addMouseListener(new EntradaMouse(e -> aceptar()));
		ventana.botonCancelar().addMouseListener(new EntradaMouse(e -> cancelar()));
	} 
	
	private void aceptar() {
		ventana.requestFocusInWindow();
		
		try {
			String nombre = ventana.getInNombre().getText();
			String apellido = ventana.getInApellido().getText();
			String dni = ventana.getInDNI().getText();
			String telefono = ventana.getInTelefono().getText();
			String email = ventana.getInEmail().getText();
			String domicilio = "sss";			
			
			// Crear un nuevo cliente
			if (cliente == null) {
				Recepcion.registrarCliente(nombre, apellido, dni, telefono, email, domicilio);
			}
			
			// Modificar uno existente
			else {
				cliente.setNombre(nombre);
				cliente.setApellido(apellido);
				cliente.setDNI(dni);
				cliente.setTelefono(telefono);
				cliente.setEmail(email);
				cliente.setDomicilio(domicilio);
				ClienteManager.modificar(cliente);
			}
			
			actualizarVentana();
			volver();
			
		} catch (Exception e) {
			Popup.mostrar(e.getMessage());
		}
		
	}
	
	private void cancelar() {
		if (Popup.confirmar("Se perderan los datos ingresados.\n¿Esta seguro de que desea cancelar la operacion?"))
			volver();
	}

	private void actualizarVentana() {
		if (invocador != null)
			invocador.actualizar();
		else {
			ControladorInterno c = principal.getControladorInterno();
			if (c != null && c instanceof ControladorClientesABM)
				((ControladorClientesABM)c).actualizar();
		}
	}
	
	private void volver() {
		ventana.dispose();
		ventana = null;
		if (invocador != null)
			invocador.mostrar();
		else
			principal.getVentana().mostrar();
	}	

}