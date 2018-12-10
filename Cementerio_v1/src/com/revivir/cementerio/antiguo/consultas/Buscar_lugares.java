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

public class Buscar_lugares extends JInternalFrame {
	private JTextField txt_sector;
	private JTextField txt_fila;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Buscar_lugares frame = new Buscar_lugares();
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
	public Buscar_lugares() {
		
		setMaximizable(true);
		
		setBackground(SystemColor.inactiveCaptionBorder);
		setBorder(null);
		setBounds(0, 0, 542, 328);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sector");
		lblNewLabel.setBounds(10, 65, 63, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblContrasea = new JLabel("Tipo");
		lblContrasea.setBounds(10, 89, 63, 14);
		getContentPane().add(lblContrasea);
		
		txt_sector = new JTextField();
		txt_sector.setBounds(64, 62, 115, 20);
		getContentPane().add(txt_sector);
		txt_sector.setColumns(10);
		
		txt_fila = new JTextField();
		txt_fila.setColumns(10);
		txt_fila.setBounds(64, 113, 115, 20);
		getContentPane().add(txt_fila);
		
		JLabel lblNivelDePermisos = new JLabel("Fila");
		lblNivelDePermisos.setBounds(10, 116, 93, 14);
		getContentPane().add(lblNivelDePermisos);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(64, 86, 115, 20);
		comboBox.insertItemAt("Nicho", 0);
		comboBox.insertItemAt("Tumba", 1);
		
		getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setBounds(61, 152, 89, 23);
		getContentPane().add(btnNewButton);
		
		table = new JTable();
		table.setBounds(189, 62, 327, 198);
		getContentPane().add(table);
		setTitle("Buscar por ");
		
	}
}
