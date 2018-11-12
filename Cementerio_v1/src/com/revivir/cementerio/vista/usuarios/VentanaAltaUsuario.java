package com.revivir.cementerio.vista.usuarios;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.revivir.cementerio.vista.util.PanelHorizontal;
import com.revivir.cementerio.vista.util.PanelVertical;
import com.revivir.cementerio.vista.util.VentanaInterna;
import javax.swing.JSeparator;

public class VentanaAltaUsuario extends VentanaInterna {
	private static final long serialVersionUID = 1L;
	private JTextField inUsuario, inPassword;
	private JComboBox<String> inPermisos;
	private Dimension largoLabel = new Dimension(150, 25), largoEntrada = new Dimension(400, 25);
	private JButton btnAceptar;

	public VentanaAltaUsuario() {
		super("Alta de usuarios", 500, 500);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setMinimumSize(largoLabel);
		lblUsuario.setPreferredSize(largoLabel);
		lblUsuario.setMaximumSize(largoLabel);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setMinimumSize(largoLabel);
		lblPassword.setPreferredSize(largoLabel);
		lblPassword.setMaximumSize(largoLabel);

		JLabel lblPermisos = new JLabel("Permisos");
		lblPermisos.setMinimumSize(largoLabel);
		lblPermisos.setPreferredSize(largoLabel);
		lblPermisos.setMaximumSize(largoLabel);

		inPassword = new JTextField();
		inPassword.setMinimumSize(largoEntrada);
		inPassword.setPreferredSize(largoEntrada);
		inPassword.setMaximumSize(largoEntrada);

		inUsuario = new JTextField();
		inUsuario.setMinimumSize(largoEntrada);
		inUsuario.setPreferredSize(largoEntrada);
		inUsuario.setMaximumSize(largoEntrada);

		inPermisos = new JComboBox<String>();
		inPermisos.setMinimumSize(largoEntrada);
		inPermisos.setPreferredSize(largoEntrada);
		inPermisos.setMaximumSize(largoEntrada);
		inPermisos.addItem("Adminstrativo");
		inPermisos.addItem("Supervisor");
		
		btnAceptar = new JButton("Agregar nuevo usuario");

		// PANELES
		PanelHorizontal panelUsuario = new PanelHorizontal();
		panelUsuario.add(lblUsuario);
		panelUsuario.add(inUsuario);
		
		PanelHorizontal panelPassword = new PanelHorizontal();
		panelPassword.add(lblPassword);
		panelPassword.add(inPassword);
		
		PanelHorizontal panelPermisos = new PanelHorizontal();
		panelPermisos.add(lblPermisos);
		panelPermisos.add(inPermisos);
		
		PanelVertical panelPrincipal = new PanelVertical();
		panelPrincipal.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(panelPrincipal);
		
		panelPrincipal.add(panelUsuario);
		panelPrincipal.add(panelPassword);
		panelPrincipal.add(panelPermisos);
		panelPrincipal.add(new JSeparator());
		panelPrincipal.add(btnAceptar);
	}

}