package com.revivir.cementerio.vista.menu.clientes.clienteAM;

import com.revivir.cementerio.negocios.Recepcion;
import com.revivir.cementerio.persistencia.entidades.Cliente;
import com.revivir.cementerio.vista.util.AccionCerrarVentana;
import com.revivir.cementerio.vista.util.Popup;

public class ControladorClientesAM {
	private VentanaClientesAM ventana;
	private ClienteInvocable invocador;
	private Cliente modificar;
	
	public ControladorClientesAM(ClienteInvocable invocador, Cliente modificar) {
		this.invocador = invocador;
		this.modificar = modificar;
		ventana = new VentanaClientesAM(modificar);
		inicializar();
	}
	
	public ControladorClientesAM(ClienteInvocable invocador) {
		this.invocador = invocador;
		ventana = new VentanaClientesAM();
		inicializar();
	}
	
	private void inicializar() {
		ventana.addWindowListener(new AccionCerrarVentana(e->cancelar()));
		ventana.botonAceptar().setAccion(e -> aceptar());
		ventana.botonCancelar().setAccion(e -> cancelar());
	} 
	
	private void aceptar() {
		ventana.requestFocusInWindow();
		
		try {
			String nombre = ventana.getInNombre().getText();
			String apellido = ventana.getInApellido().getText();
			String dni = ventana.getInDNI().getText();
			String telefono = ventana.getInTelefono().getText();
			String email = ventana.getInEmail().getText();
			String domicilio = ventana.getDomicilio().getText();			
			
			// Crear un nuevo cliente
			if (modificar == null)
				Recepcion.registrarCliente(nombre, apellido, dni, telefono, email, domicilio);
			
			// Modificar uno existente
			else 
				Recepcion.modificarCliente(modificar, nombre, apellido, dni, telefono, email, domicilio);
			
			invocador.actualizarClientes();
			ventana.dispose();
			ventana = null;
			invocador.mostrar();
			
		} catch (Exception e) {
			Popup.mostrar(e.getMessage());
		}
		
	}
	
	private void cancelar() {
		if (Popup.confirmar("Se perderan los datos ingresados.\n¿Esta seguro de que desea cancelar la operacion?")) {
			ventana.dispose();
			ventana = null;
			invocador.mostrar();
		}
	}

}