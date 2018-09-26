package usuarios;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;

import logica.Users;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Alta_usuario extends JInternalFrame {
	private JTextField txt_Id;
	private JTextField txt_pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Alta_usuario frame = new Alta_usuario();
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
	public Alta_usuario() {
		
		setMaximizable(true);
		
		setBackground(SystemColor.inactiveCaptionBorder);
		setBorder(null);
		setBounds(0, 0, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(10, 65, 63, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(10, 89, 117, 14);
		getContentPane().add(lblContrasea);
		
		txt_Id = new JTextField();
		txt_Id.setBounds(155, 62, 159, 20);
		getContentPane().add(txt_Id);
		txt_Id.setColumns(10);
		
		txt_pass = new JTextField();
		txt_pass.setColumns(10);
		txt_pass.setBounds(155, 86, 159, 20);
		getContentPane().add(txt_pass);
		
		JLabel lblNivelDePermisos = new JLabel("Nivel de permisos");
		lblNivelDePermisos.setBounds(10, 116, 117, 14);
		getContentPane().add(lblNivelDePermisos);
		
		JComboBox cmb_permiso = new JComboBox();
		cmb_permiso.setBounds(155, 110, 159, 20);
		cmb_permiso.insertItemAt("Usuario", 0);
		cmb_permiso.insertItemAt("Administrador", 1);
		
		getContentPane().add(cmb_permiso);
		
		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Users user = new Users();
				user.setId(txt_Id.getText());
				user.setpwd(txt_pass.getText());
				user.settype(cmb_permiso.getSelectedIndex());
				user.crearUsuario();
			}
		});
		btnNewButton.setBounds(155, 160, 89, 23);
		getContentPane().add(btnNewButton);
		setTitle("Altas de Usuarios");
		
	}
}
