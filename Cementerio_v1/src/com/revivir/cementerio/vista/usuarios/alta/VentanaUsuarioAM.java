package com.revivir.cementerio.vista.usuarios.alta;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.revivir.cementerio.persistencia.definidos.Rol;
import com.revivir.cementerio.persistencia.entidades.Usuario;
import com.revivir.cementerio.vista.util.Boton;
import com.revivir.cementerio.vista.util.EntradaTexto;
import com.revivir.cementerio.vista.util.PanelHorizontal;
import com.revivir.cementerio.vista.util.PanelVertical;
import com.revivir.cementerio.vista.util.Ventana;

public class VentanaUsuarioAM extends Ventana {
	private static final long serialVersionUID = 1L;
	private EntradaTexto inUsuario, inPassword;
	private JComboBox<Rol> inPermisos;
	private Boton btnAceptar, btnCancelar;
	private Usuario usuario = null;

	public VentanaUsuarioAM() {
		super("Alta de usuario", 500, 500);
		cargarcomponentes();
	}
	
	public VentanaUsuarioAM(Usuario usuario) {
		super("Modificación de usuario", 500, 500);
		cargarcomponentes();
		this.usuario = usuario;
		inUsuario.getTextField().setText(usuario.getUsuario());
		inPassword.getTextField().setText(usuario.getPassword());
		inPermisos.setSelectedItem(usuario.getRol());
	}
	
	public void cargarcomponentes() {
		Dimension largoLabel = new Dimension(150, 25);
		Dimension largoEntrada = new Dimension(300, 25);
		Dimension dimBoton = new Dimension(100, 25);
		
		inUsuario = new EntradaTexto("Usuario", largoLabel, largoEntrada);
		inPassword = new EntradaTexto("Password", largoLabel, largoEntrada);
		
		JLabel lblPermisos = new JLabel("Permisos");
		lblPermisos.setMinimumSize(largoLabel);
		lblPermisos.setPreferredSize(largoLabel);
		lblPermisos.setMaximumSize(largoLabel);

		inPermisos = new JComboBox<Rol>();
		inPermisos.setMinimumSize(largoEntrada);
		inPermisos.setPreferredSize(largoEntrada);
		inPermisos.setMaximumSize(largoEntrada);
		inPermisos.addItem(Rol.ADMINISTRATIVO);
		inPermisos.addItem(Rol.SUPERVISOR);

		PanelHorizontal panelPermisos = new PanelHorizontal();
		panelPermisos.add(lblPermisos);
		panelPermisos.add(inPermisos);
		
		btnAceptar = new Boton("Aceptar", dimBoton);
		btnCancelar = new Boton("Cancelar", dimBoton);
		PanelHorizontal panelBotones = new PanelHorizontal();
		panelBotones.add(btnAceptar);
		panelBotones.add(btnCancelar);
		panelBotones.setBorder(new EmptyBorder(10, 0, 0, 0));
		
		// PANELES
		PanelVertical panelPrincipal = new PanelVertical();
		panelPrincipal.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(panelPrincipal);
		
		panelPrincipal.add(inUsuario);
		panelPrincipal.add(inPassword);
		panelPrincipal.add(panelPermisos);
		panelPrincipal.add(new JSeparator());
		panelPrincipal.add(panelBotones);
		
		pack();
		setResizable(false);
		setLocationRelativeTo(null);
	}
	
	public JTextField getUsuario() {
		return inUsuario.getTextField();
	}
	
	public JTextField getPassword() {
		return inPassword.getTextField();
	}
	
	public JComboBox<Rol> getPermisos() {
		return inPermisos;
	}
	
	public JButton botonAceptar() {
		return btnAceptar;
	}

	public JButton botonCancelar() {
		return btnCancelar;
	}
	
	public Usuario getUsuarioModificacion() {
		return usuario;
	}
	
}