package com.revivir.cementerio.vista.util;

import java.awt.Dimension;
import javax.swing.JButton;

public class Boton extends JButton{
	private static final long serialVersionUID = 1L;

	public Boton(String texto, Dimension dimBoton) {
		super(texto);
		setMaximumSize(dimBoton);
		setMinimumSize(dimBoton);
		setPreferredSize(dimBoton);
	}

}