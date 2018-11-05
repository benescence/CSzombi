package com.revivir.cementerio.vista;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.revivir.cementerio.vista.util.PanelHorizontal;
import com.revivir.cementerio.vista.util.PanelVertical;
import com.revivir.cementerio.vista.util.VentanaInterna;

public class VentanaCargaClientes extends VentanaInterna {
	private static final long serialVersionUID = 1L;
	private JTextField inDNI, inApellido, inNombre, inTelefono, inEmail;
	private JButton btnExistente, btnLimpiar;
	
	public VentanaCargaClientes() {
		super("Carga de clientes", 450, 300);
		Dimension largoEntrada = new Dimension(Short.MAX_VALUE, 25);
		Dimension largoLabel = new Dimension(100, 25);

		// ENTRADAS
		JLabel lblDNI = new JLabel("DNI");
		JLabel lblApellidos = new JLabel("Apellidos");
		JLabel lblNombres = new JLabel("Nombres");
		JLabel lblTelefono = new JLabel("Telefono");
		JLabel lblEmail = new JLabel("E-Mail");

		lblDNI.setPreferredSize(largoLabel);
		lblApellidos.setPreferredSize(largoLabel);
		lblNombres.setPreferredSize(largoLabel);
		lblTelefono.setPreferredSize(largoLabel);
		lblEmail.setPreferredSize(largoLabel);

		inDNI = new JTextField();
		inApellido = new JTextField();
		inNombre = new JTextField();
		inTelefono = new JTextField();
		inEmail = new JTextField();
		
		inDNI.setMaximumSize(largoEntrada);
		inApellido.setMaximumSize(largoEntrada);
		inNombre.setMaximumSize(largoEntrada);
		inTelefono.setMaximumSize(largoEntrada);
		inEmail.setMaximumSize(largoEntrada);
		
		// BOTONES
		btnExistente = new JButton("Cargar cliente existente");
		btnLimpiar = new JButton("Limpiar campos");
		PanelHorizontal panelBotones = new PanelHorizontal();
		panelBotones.add(btnExistente);
		panelBotones.add(btnLimpiar);
		
		// ORGANIZACION DE PANELES
		PanelVertical panelPrincipal = new PanelVertical();
		setContentPane(panelPrincipal);
		
		PanelHorizontal panelDNI = new PanelHorizontal();
		panelDNI.add(lblDNI);
		panelDNI.add(inDNI);

		PanelHorizontal panelApellido = new PanelHorizontal();
		panelApellido.add(lblApellidos);
		panelApellido.add(inApellido);

		PanelHorizontal panelNombre = new PanelHorizontal();
		panelNombre.add(lblNombres);
		panelNombre.add(inNombre);

		PanelHorizontal panelTelefono = new PanelHorizontal();
		panelTelefono.add(lblTelefono);
		panelTelefono.add(inTelefono);

		PanelHorizontal panelEmail = new PanelHorizontal();
		panelEmail.add(lblEmail);
		panelEmail.add(inEmail);
		
		panelPrincipal.add(panelDNI);
		panelPrincipal.add(panelApellido);
		panelPrincipal.add(panelNombre);
		panelPrincipal.add(panelTelefono);
		panelPrincipal.add(panelEmail);
		panelPrincipal.add(panelBotones);
	}

	public JTextField getDNI() {
		return inDNI;
	}

	public JTextField getApellido() {
		return inApellido;
	}

	public JTextField getNombre() {
		return inNombre;
	}

	public JTextField getTelefono() {
		return inTelefono;
	}

	public JTextField getEmail() {
		return inEmail;
	}

	public JButton botonExistente() {
		return btnExistente;
	}

	public JButton botonLimpiar() {
		return btnLimpiar;
	}
	
}