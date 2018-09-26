package consultas;

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

public class Reporte_clientes extends JInternalFrame {
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reporte_clientes frame = new Reporte_clientes();
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
	public Reporte_clientes() {
		
		setMaximizable(true);
		
		setBackground(SystemColor.inactiveCaptionBorder);
		setBorder(null);
		setBounds(0, 0, 569, 332);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cliente");
		lblNewLabel.setBounds(10, 11, 63, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblContrasea = new JLabel("Buscar por:");
		lblContrasea.setBounds(167, 14, 63, 14);
		getContentPane().add(lblContrasea);
		
		textField = new JTextField();
		textField.setBounds(64, 8, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(233, 8, 136, 20);
		comboBox.insertItemAt("Apellido y Nombre", 0);
		comboBox.insertItemAt("DNI", 1);
		
		getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setBounds(402, 7, 89, 23);
		getContentPane().add(btnNewButton);
		
		table = new JTable();
		table.setBounds(10, 62, 549, 218);
		getContentPane().add(table);
		setTitle("Buscar por ");
		
	}
}
