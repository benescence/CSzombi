package com.revivir.cementerio.vista.util;

import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class EntradaTexto extends PanelHorizontal {
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JLabel label;
	
	public EntradaTexto(String texto, Dimension largoLabel, Dimension largoTextfield) {
		label = new JLabel(texto);
		label.setMaximumSize(largoLabel);
		label.setMinimumSize(largoLabel);
		label.setPreferredSize(largoLabel);
		add(label);
		
		textField = new JTextField();
		textField.setMaximumSize(largoTextfield);
		textField.setMinimumSize(largoTextfield);
		textField.setPreferredSize(largoTextfield);
		add(textField);
	}
	
	public void bloquear() {
		label.setEnabled(false);
		textField.setEnabled(false);
	}

	public void desbloquear() {
		label.setEnabled(true);
		textField.setEnabled(true);
	}
	
	public JTextField getTextField() {
		return textField;
	}

}