package com.revivir.cementerio.vista.util;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Boton extends JButton{
	private static final long serialVersionUID = 1L;
	
	public Boton(String texto, Dimension dimBoton) {
		super(texto);
		setMaximumSize(dimBoton);
		setMinimumSize(dimBoton);
		setPreferredSize(dimBoton);
	}
	
	public void setAccion(ActionListener accion) {
		addKeyListener(new PresionarEnterListener(accion));
		addMouseListener(new EntradaMouse(accion));
	}
	
}