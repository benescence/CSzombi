package com.revivir.cementerio.vista.menu.clientes.clienteAM;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.revivir.cementerio.negocios.manager.ClienteManager;
import com.revivir.cementerio.persistencia.entidades.Cliente;
import com.revivir.cementerio.vista.ControladorPrincipal;
import com.revivir.cementerio.vista.menu.clientes.ControladorClientesABM;
import com.revivir.cementerio.vista.util.Popup;

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
		ventana.botonAceptar().addActionListener(e -> aceptar());
		ventana.botonCancelar().addActionListener(e -> cancelar());
		ventana.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				cancelar();
			}
		});
	} 
	
	private void aceptar() {
		String nombre = ventana.getInNombre().getText();
		String apellido = ventana.getInApellido().getText();
		String dni = ventana.getInDNI().getText();
		String telefono = ventana.getInTelefono().getText();
		String email = ventana.getInEmail().getText();

		// Crear un nuevo cliente
		if (cliente == null) {
			ClienteManager.guardar(nombre, apellido, dni, telefono, email);
		}
		
		// Modificar uno existente
		else {
			cliente.setNombre(nombre);
			cliente.setApellido(apellido);
			cliente.setDNI(dni);
			cliente.setTelefono(telefono);
			cliente.setEmail(email);
			ClienteManager.modificar(cliente);
		}
		
		if (invocador != null)
			invocador.actualizar();
		
		volver();
		
		
		
		if (validarCampos()) {
/*
			String usuario = ventana.getUsuario().getText();
			String password = ventana.getPassword().getText();
			Rol rol = (Rol) ventana.getPermisos().getSelectedItem();
			Usuario usuarioActual = ventana.getUsuarioModificacion();
			
			// AGREGAR USUARIO
			if (usuarioActual == null) {
				Usuario nuevo = new Usuario(-1, usuario, password, rol);
				UsuarioManager.guardar(nuevo);
			}
			
			// MODIFICAR USUARIO
			else {
				usuarioActual.setUsuario(usuario);
				usuarioActual.setPassword(password);
				usuarioActual.setRol(rol);
				UsuarioManager.modificar(usuarioActual);
			}
			
			invocador.actualizarTabla();*/
		}
		
	}
	
	private void cancelar() {
		if (Popup.confirmar("Se perderan los datos ingresados.\n¿Esta seguro de que desea cancelar la operacion?"))
			volver();
	}

	private void volver() {
		ventana.dispose();
		ventana = null;
		if (invocador != null)
			invocador.mostrar();
		else
			principal.getVentana().mostrar();
	}
	
	private boolean validarCampos() {/*
		String usuario = ventana.getUsuario().getText();
		String password = ventana.getPassword().getText();
		Usuario usuarioActual = ventana.getUsuarioModificacion();
		Usuario usuarioBD = UsuarioManager.traerPorUsuario(usuario);
		String mensaje = "";
		
		if (usuario.equals(""))
			mensaje += "\n   -El USUARIO no puede estar vacio.";
		else if (usuarioBD != null) {
			if (usuarioActual == null || usuarioActual.getID() != usuarioBD.getID())
				mensaje += "\n   -Ya existe un usuario con el nombre de usuario "+usuario+".";
		}
		
		if (password.equals(""))
			mensaje += "\n   -El PASSWORD no puede estar vacio.";
		
		if (!mensaje.equals("")) {
			Popup.mostrar("Se encontraron los siguientes errores:"+mensaje);
			return false;
		}
		*/
		return true;
	}

}