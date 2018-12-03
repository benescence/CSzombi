package com.revivir.cementerio.vista.usuarios;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.revivir.cementerio.persistencia.entidades.Usuario;
import com.revivir.cementerio.vista.tablas.TablaUsuarios;
import com.revivir.cementerio.vista.util.EntradaTexto;
import com.revivir.cementerio.vista.util.PanelHorizontal;
import com.revivir.cementerio.vista.util.PanelVertical;
import com.revivir.cementerio.vista.util.VentanaInterna;

public class VentanaUsuarios extends VentanaInterna {
	private static final long serialVersionUID = 1L;
	private EntradaTexto inUsuario;
	private JButton btnAgregar, btnModificar, btnEliminar, btnBuscar, btnLimpiar;
	private TablaUsuarios tabla;
	
	public VentanaUsuarios() {
		super("Usuarios del sistema", 500, 500);
		
		// ENTRADAS
		Dimension largoLabel = new Dimension(200, 30);
		Dimension largoTextfield = new Dimension(200, 30);
		inUsuario = new EntradaTexto("Usuario", largoLabel, largoTextfield);
		
		// BOTONES
		btnAgregar = new JButton("Agregar");
		btnModificar = new JButton("Modificar");
		btnEliminar = new JButton("Eliminar");
		btnBuscar = new JButton("Buscar");
		btnLimpiar = new JButton("Limpiar");
		PanelHorizontal panelBotones = new PanelHorizontal();
		panelBotones.add(btnAgregar);
		panelBotones.add(btnModificar);
		panelBotones.add(btnEliminar);
		panelBotones.add(btnBuscar);
		panelBotones.add(btnLimpiar);
		
		// TABLA
		List<Usuario> usuarios = new ArrayList<>();
		tabla = new TablaUsuarios(usuarios);
		JScrollPane panelTabla = new JScrollPane(tabla);
		
		// PANELES
		PanelVertical panelPrincipal = new PanelVertical();
		panelPrincipal.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(panelPrincipal);
		
		panelBotones.setBorder(new EmptyBorder(10, 10, 10, 10));
		panelPrincipal.add(inUsuario);
		panelPrincipal.add(panelTabla);
		panelPrincipal.add(panelBotones);		
	}

	public JTextField getUsuario() {
		return inUsuario.getTextField();
	}

	public JButton botonAgregar() {
		return btnAgregar;
	}

	public JButton botonModificar() {
		return btnModificar;
	}

	public JButton botonEliminar() {
		return btnEliminar;
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