package com.revivir.cementerio.antiguo.usuarios;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.revivir.cementerio.antiguo.db.Busquedas;
import com.revivir.cementerio.antiguo.logica.Users;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Buscar_usuarios extends JInternalFrame {
	protected static final TableModel u = null;
	private JTextField txt_user;
	private JTable table;
	
	Connection conexion = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Buscar_usuarios frame = new Buscar_usuarios();
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
	public Buscar_usuarios() {
		
		setMaximizable(true);
		
		setBackground(SystemColor.inactiveCaptionBorder);
		setBorder(null);
		setBounds(0, 0, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setBounds(10, 65, 63, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblContrasea = new JLabel("Nivel");
		lblContrasea.setBounds(10, 89, 63, 14);
		getContentPane().add(lblContrasea);
		
		txt_user = new JTextField();
		txt_user.setBounds(64, 62, 86, 20);
		getContentPane().add(txt_user);
		txt_user.setColumns(10);
		
		JComboBox<String> cmb_tipo = new JComboBox<String>();
		cmb_tipo.setBounds(64, 86, 86, 20);
		cmb_tipo.insertItemAt("Usuario", 0);
		cmb_tipo.insertItemAt("Administrador", 1);
		cmb_tipo.insertItemAt("", 2);
		getContentPane().add(cmb_tipo);
		
		table = new JTable();
		table.setBounds(160, 62, 280, 167);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Users user = new Users();
				user.setId(txt_user.getText());
				user.settype(cmb_tipo.getSelectedIndex());
				ArrayList<Users> u = new ArrayList<Users>();
				 DefaultTableModel modelo = new DefaultTableModel();
				 modelo =  (new DefaultTableModel(
						 null, new String [] {
								 "User","Pass",
								 "Tipo"}){
								 Class[] types = new Class [] {
								 java.lang.String.class,
								 java.lang.String.class,
								 java.lang.String.class,
								 };
				 			});
				 
				table.setModel(modelo);
				user.buscarUsuario(u);
//				System.out.println(u.get(0));
				Object O[]=null;
				
				if (u.size() != 0){
					for(int i=0;i<u.size();i++){
						modelo.addRow(O);
						Users aux = u.get(i);
						String auxUser;
						if (aux.getType().equals(1))
							auxUser = "Administrador";
						else
							auxUser = "Usuario";
						table.setValueAt(aux.getId(), i, 0);
						table.setValueAt(aux.getPwd(), i, 1);
						table.setValueAt(auxUser, i, 2);
					}
				}
			}
			 
		});
		btnNewButton.setBounds(61, 152, 89, 23);
		getContentPane().add(btnNewButton);
		
		getContentPane().add(table);
		setTitle("Buscar por Usuarios");
		
		
		
	}	
	
}
