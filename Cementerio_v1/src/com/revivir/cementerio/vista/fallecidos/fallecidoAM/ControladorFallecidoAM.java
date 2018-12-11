package com.revivir.cementerio.vista.fallecidos.fallecidoAM;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.revivir.cementerio.persistencia.entidades.Fallecido;
import com.revivir.cementerio.vista.fallecidos.ControladorFallecidosABM;
import com.revivir.cementerio.vista.util.Popup;

public class ControladorFallecidoAM {
	private VentanaFallecidoAM ventana;
	private ControladorFallecidosABM invocador;
	
	public ControladorFallecidoAM(ControladorFallecidosABM invocador, Fallecido fallecido) {
		this.invocador = invocador;
		ventana = new VentanaFallecidoAM();
		inicializar();
	}
	
	public ControladorFallecidoAM(ControladorFallecidosABM invocador) {
		this.invocador = invocador;
		ventana = new VentanaFallecidoAM();
		inicializar();
	}
	
	private void inicializar() {
		ventana.botonAceptar().addActionListener(e -> aceptar());
		ventana.botonCancelar().addActionListener(e -> cancelar());
		ventana.mostrar();
		ventana.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				volver();
			}
		});
	} 
	
	private void aceptar() {
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
			volver();
		}
		
	}
	
	private void cancelar() {
		if (Popup.confirmar("Se perderan los datos ingresados.\n¿Esta seguro de que desea cancelar la operacion?"))
			volver();
	}

	private void volver() {
		ventana.dispose();
		ventana = null;
		invocador.mostrar();
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