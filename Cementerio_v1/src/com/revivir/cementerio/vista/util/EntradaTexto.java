package com.revivir.cementerio.vista.util;

import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class EntradaTexto extends PanelHorizontal {
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JLabel label;
	
	public EntradaTexto(String texto, Dimension dimLabel, Dimension dimTextfield) {
		label = new JLabel(texto);
		label.setMaximumSize(dimLabel);
		label.setMinimumSize(dimLabel);
		label.setPreferredSize(dimLabel);
		add(label);
		
		textField = new JTextField();
		textField.setMaximumSize(dimTextfield);
		textField.setMinimumSize(dimTextfield);
		textField.setPreferredSize(dimTextfield);
		add(textField);
	}
	
	public void habilitado(boolean bloquear) {
		label.setEnabled(bloquear);
		textField.setEnabled(bloquear);
	}

	public JTextField getTextField() {
		return textField;
	}

}