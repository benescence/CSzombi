package com.revivir.cementerio.antiguo.consultas;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JTable;
import com.toedter.calendar.JCalendar;
import java.awt.event.ActionListener;
import java.time.Year;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;

public class Movimientos_dia extends JInternalFrame {
	private JTable table;
	private JTextField txt_anio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Movimientos_dia frame = new Movimientos_dia();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Movimientos_dia() {
		
		setMaximizable(true);
		
		setBackground(SystemColor.inactiveCaptionBorder);
		setBorder(null);
		setBounds(0, 0, 668, 496);
		getContentPane().setLayout(null);
		
		table = new JTable();
		table.setBounds(20, 210, 638, 248);
		getContentPane().add(table);
		
		JLabel lblBuscarPor = new JLabel("Buscar por:");
		lblBuscarPor.setBounds(39, 53, 76, 14);
		getContentPane().add(lblBuscarPor);
		
		JCalendar calendar = new JCalendar();
		calendar.setDecorationBackgroundVisible(false);
		calendar.setBounds(296, 41, 216, 158);
		calendar.setVisible(false);
		getContentPane().add(calendar);
		
	
		JComboBox<String> cmb_mes = new JComboBox<String>();
		cmb_mes.setBounds(110, 83, 142, 20);
		cmb_mes.insertItemAt("Seleccionar...", 0);
		cmb_mes.insertItemAt("Enero", 1);
		cmb_mes.insertItemAt("Febrero", 2);
		cmb_mes.insertItemAt("Marzo", 3);
		cmb_mes.insertItemAt("Abril", 4);
		cmb_mes.insertItemAt("Mayo", 5);
		cmb_mes.insertItemAt("Junio", 6);
		cmb_mes.insertItemAt("Julio", 7);
		cmb_mes.insertItemAt("Agosto", 8);
		cmb_mes.insertItemAt("Septiembre", 9);
		cmb_mes.insertItemAt("Octubre", 10);
		cmb_mes.insertItemAt("Noviembre", 11);
		cmb_mes.insertItemAt("Diciembre", 12);
		cmb_mes.setSelectedItem(0);
		getContentPane().add(cmb_mes);
		cmb_mes.setVisible(false);
	
		Calendar fecha = Calendar.getInstance();
	    int anio = fecha.get(Calendar.YEAR);
		
		txt_anio = new JTextField();
		txt_anio.setBounds(120, 114, 69, 20);
		txt_anio.setText(""+anio);
		getContentPane().add(txt_anio);
		txt_anio.setVisible(false);
		txt_anio.setColumns(10);
		
				
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedIndex()==0){
					calendar.setVisible(true);
					txt_anio.setVisible(false);
					cmb_mes.setVisible(false);
				}
				else if (comboBox.getSelectedIndex()==1){
					calendar.setVisible(true);
					txt_anio.setVisible(false);
					cmb_mes.setVisible(false);
				} else{
					calendar.setVisible(false);
					txt_anio.setVisible(true);
					cmb_mes.setVisible(true);
				}
			}
		});
		comboBox.setBounds(110, 50, 142, 20);
		comboBox.insertItemAt("Diario", 0);
		comboBox.insertItemAt("Semanal", 1);
		comboBox.insertItemAt("Mensual", 2);
		getContentPane().add(comboBox);
		

		setTitle("Movimientos");
		
	}
}
