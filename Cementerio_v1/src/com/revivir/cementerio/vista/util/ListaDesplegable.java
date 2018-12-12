package com.revivir.cementerio.vista.util;

import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JLabel;

public class ListaDesplegable<E> extends PanelHorizontal {
	private static final long serialVersionUID = 1L;
	private JComboBox<E> lista;
	private JLabel label;
	
	public ListaDesplegable (String texto, Dimension dimLabel, Dimension dimTextfield) {
		label = new JLabel(texto);
		label.setMaximumSize(dimLabel);
		label.setMinimumSize(dimLabel);
		label.setPreferredSize(dimLabel);
		add(label);
		
		lista = new JComboBox<E>();
		lista.setMaximumSize(dimTextfield);
		lista.setMinimumSize(dimTextfield);
		lista.setPreferredSize(dimTextfield);
		add(lista);
	}
	
	public void bloquear(boolean bloquear) {
		label.setEnabled(bloquear);
		lista.setEnabled(bloquear);
	}

	public JComboBox<E> getComboBox() {
		return lista;
	}

}