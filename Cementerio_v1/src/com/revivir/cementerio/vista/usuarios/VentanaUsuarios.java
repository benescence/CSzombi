package com.revivir.cementerio.vista.usuarios;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.revivir.cementerio.vista.tablas.TablaUsuarios;
import com.revivir.cementerio.vista.util.EntradaTexto;
import com.revivir.cementerio.vista.util.PanelHorizontal;
import com.revivir.cementerio.vista.util.PanelVertical;
import com.revivir.cementerio.vista.util.VentanaInterna;

public class VentanaUsuarios extends VentanaInterna {
	private static final long serialVersionUID = 1L;
	private EntradaTexto inUsuario;
	private JButton btnBuscar, btnLimpiar;
	private TablaUsuarios tabla;
	
	public VentanaUsuarios() {
		super("Usuarios del sistema", 500, 500);
		
		// ENTRADAS
		Dimension largoLabel = new Dimension(200, 30);
		Dimension largoTextfield = new Dimension(200, 30);
		inUsuario = new EntradaTexto("Usuario", largoLabel, largoTextfield);
		
		// BOTONES
		btnBuscar = new JButton("Buscar");
		btnLimpiar = new JButton("Limpiar");
		PanelHorizontal panelBotones = new PanelHorizontal();
		panelBotones.add(btnBuscar);
		panelBotones.add(btnLimpiar);
		
		// TABLA
		tabla = new TablaUsuarios(null);
		JScrollPane panelTabla = new JScrollPane();
		panelTabla.setViewportView(tabla);
		
		// PANELES
		PanelVertical panelPrincipal = new PanelVertical();
		panelPrincipal.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(panelPrincipal);
		
		panelPrincipal.add(inUsuario);
		panelPrincipal.add(panelBotones);
		panelPrincipal.add(panelTabla);
		
		pack();
	}


	public JTextField getUsuario() {
		return inUsuario.getTextField();
	}
	

	public JButton botonBuscar() {
		return btnBuscar;
	}
	

	public JButton botonLimpiar() {
		return btnLimpiar;
	}
	

	public TablaUsuarios getTabla() {
		return tabla;
	}

}