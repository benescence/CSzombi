package com.revivir.cementerio.antiguo.usuarios;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;

import com.revivir.cementerio.antiguo.db.Busquedas;
import com.revivir.cementerio.antiguo.logica.Users;

import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Baja_usuario extends JInternalFrame {
	private JTextField txt_user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Baja_usuario frame = new Baja_usuario();
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
	public Baja_usuario() {
		setMaximizable(true);
		getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		setBorder(null);
		
		setTitle("Bajas de Usuarios");
		setBounds(0, 0, 450, 300);
		getContentPane().setLayout(null);
		
		txt_user = new JTextField();
		txt_user.setBounds(140, 34, 131, 20);
		getContentPane().add(txt_user);
		txt_user.setColumns(10);
		
		
		JLabel lblNombre = new JLabel("Usuario");
		lblNombre.setBounds(36, 33, 53, 14);
		getContentPane().add(lblNombre);
		

		JLabel lbl_resultado = new JLabel("Resultado de la busqueda: ");
		lbl_resultado.setBounds(10, 138, 389, 14);
		getContentPane().add(lbl_resultado);
		
		
		JComboBox<String> cmb_tipo = new JComboBox<String>();
		JLabel label = new JLabel("Nivel de permisos");
		label.setBounds(10, 75, 120, 14);
		cmb_tipo.insertItemAt("Administrador", 0);
		cmb_tipo.insertItemAt("Usuario", 1);
		getContentPane().add(label);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Users u = new Users();
				Users user=new Users(); 
				u.buscarUnUsuario(user);
				if (!user.equals(null)){
					lbl_resultado.setText(lbl_resultado.getText()+"Error: Hay dos usuarios con el mismo nombre");
				}else{
					lbl_resultado.setText("Dar de baja a "+user.getId()+" - tipo"+user.getType());
				}
			}
		});
		btnBuscar.setBounds(299, 33, 89, 23);
		getContentPane().add(btnBuscar);
		
		JButton btnConfirmarEliminar = new JButton("Confirmar eliminar");
		btnConfirmarEliminar.setBounds(141, 163, 169, 23);
		getContentPane().add(btnConfirmarEliminar);
		
	
		
		
		cmb_tipo.setBounds(140, 76, 131, 20);
		getContentPane().add(cmb_tipo);
		
		
		
		

	}
}
