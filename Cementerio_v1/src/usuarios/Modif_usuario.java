package usuarios;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Color;

public class Modif_usuario extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Modif_usuario frame = new Modif_usuario();
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
	public Modif_usuario() {
		
		setMaximizable(true);
		
		setBackground(SystemColor.inactiveCaptionBorder);
		setBorder(null);
		setBounds(0, 0, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(10, 65, 63, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(10, 118, 63, 14);
		getContentPane().add(lblContrasea);
		
		textField = new JTextField();
		textField.setBounds(152, 65, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(152, 118, 86, 20);
		getContentPane().add(textField_1);
		
		JLabel lblNivelDePermisos = new JLabel("Nivel de permisos");
		lblNivelDePermisos.setBounds(10, 93, 93, 14);
		getContentPane().add(lblNivelDePermisos);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(152, 90, 86, 20);
		comboBox.insertItemAt("Usuario", 0);
		comboBox.insertItemAt("Administrador", 1);
		
		getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("Modificar");
		btnNewButton.setBounds(83, 156, 116, 23);
		getContentPane().add(btnNewButton);
		setTitle("Modificar Usuario");
		
	}
}
