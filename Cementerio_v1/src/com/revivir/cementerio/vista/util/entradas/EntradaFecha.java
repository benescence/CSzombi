package com.revivir.cementerio.vista.util.entradas;

import java.awt.Dimension;
import java.sql.Date;

import javax.swing.JLabel;

import com.revivir.cementerio.vista.util.contenedores.PanelHorizontal;
import com.toedter.calendar.JDateChooser;

public class EntradaFecha extends PanelHorizontal {
	private static final long serialVersionUID = 1L;
	private JDateChooser dateChooser;
	private JLabel label;
	
	public EntradaFecha(Date fecha, String texto, Dimension dimTexto, Dimension dimEntrada) {
		label = new JLabel(texto);
		label.setMaximumSize(dimTexto);
		label.setMinimumSize(dimTexto);
		label.setPreferredSize(dimTexto);
		add(label);
		
		dateChooser = new JDateChooser(fecha);
		dateChooser.setMaximumSize(dimEntrada);
		dateChooser.setMinimumSize(dimEntrada);
		dateChooser.setPreferredSize(dimEntrada);
		add(dateChooser);
	}
	
	public void bloquear(boolean bloquear) {
		label.setEnabled(bloquear);
		dateChooser.setEnabled(bloquear);
	}

	public JDateChooser getDataChooser() {
		return dateChooser;
	}

}