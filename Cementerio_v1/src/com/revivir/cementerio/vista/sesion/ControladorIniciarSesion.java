package com.revivir.cementerio.vista.sesion;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import com.revivir.cementerio.negocios.Sesion;
import com.revivir.cementerio.negocios.Validador;
import com.revivir.cementerio.vista.ControladorPrincipal;
import com.revivir.cementerio.vista.util.Popup;

public class ControladorIniciarSesion {
	private VentanaIniciarSesion ventana;
	
	public ControladorIniciarSesion() {
		ventana = new VentanaIniciarSesion();
		ventana.botonAceptar().addActionListener(e -> aceptar());
		ventana.botonCancelar().addActionListener(e -> cancelar());
		ventana.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				cancelar();
			}
		});
		ventana.botonAceptar().addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				aceptar();
			}
			
			@Override
			public void keyReleased(KeyEvent e) {}
			
			@Override
			public void keyPressed(KeyEvent e) {}
		});
	}

	@SuppressWarnings("deprecation")
	private void aceptar() {
		if (validarCampos()) {
			String nombre = ventana.getUsuario().getText();
			String password = ventana.getPassword().getText();
			
			try {
				Sesion.iniciarSesion(nombre, password);
				ventana.dispose();
				ventana = null;
				new ControladorPrincipal();
				
			} catch (Exception e) {
				Popup.mostrar(e.getMessage());
			}
		}
	}

	@SuppressWarnings("deprecation")
	private boolean validarCampos() {
		String nombre = ventana.getUsuario().getText();
		String password = ventana.getPassword().getText();
		String mensaje = "";
		
		if (nombre.equals(""))
			mensaje += "\n    -El campo USUARIO no puede estar vacio.";
		else if (!Validador.validarUsuario(nombre))
			mensaje += "\n    -El campo USUARIO solo puede contener letras y numeros.";
		
		if (password.equals(""))
			mensaje += "\n    -El campo PASSWORD no puede estar vacio.";
		else if (!Validador.validarPassword(password))
			mensaje += "\n    -El campo PASSWORD solo puede contener letras y numeros.";
		
		if (mensaje.equals(""))
			return true;
		
		Popup.mostrar("Se encontraron los siguientes errores:"+mensaje);
		return false;
	}

	private void cancelar() {
		ventana.dispose();
		ventana = null;
	}

}