package com.revivir.cementerio.vista.util;

import java.awt.Component;

import javax.swing.JLabel;

import com.revivir.cementerio.vista.util.contenedores.PanelVertical;

public class TextoCentrado extends PanelVertical {
	private static final long serialVersionUID = 1L;

	public TextoCentrado(String texto) {
		JLabel label = new JLabel(texto);
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(label);
	}
	
}