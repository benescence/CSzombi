package com.revivir.cementerio.vista.util;

import javax.swing.JFrame;

public abstract class Ventana extends JFrame{
	private static final long serialVersionUID = 1L;
	
	public Ventana(String titulo, int ancho, int alto) {
		setTitle(titulo);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, ancho, alto);
		setLocationRelativeTo(null);
		mostrar();
	}

	public void ocultar() {
		setVisible(false);
	}
	
	public void deshabilitar() {
		setEnabled(false);
	}
	
	public void mostrar() {
		setVisible(true);
		setEnabled(true);
	}
	
}