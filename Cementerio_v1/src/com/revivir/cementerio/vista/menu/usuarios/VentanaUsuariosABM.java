package com.revivir.cementerio.vista.menu.usuarios;

import java.awt.Dimension;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.revivir.cementerio.negocios.manager.UsuarioManager;
import com.revivir.cementerio.persistencia.entidades.Usuario;
import com.revivir.cementerio.vista.tablas.TablaUsuarios;
import com.revivir.cementerio.vista.util.Boton;
import com.revivir.cementerio.vista.util.contenedores.PanelHorizontal;
import com.revivir.cementerio.vista.util.contenedores.PanelVertical;
import com.revivir.cementerio.vista.util.contenedores.VentanaInterna;
import com.revivir.cementerio.vista.util.entradas.EntradaTexto;

public class VentanaUsuariosABM extends VentanaInterna {
	private static final long serialVersionUID = 1L;
	private EntradaTexto inUsuario;
	private Boton btnAgregar, btnModificar, btnEliminar, btnBuscar, btnLimpiar;
	private TablaUsuarios tabla;
	
	public VentanaUsuariosABM() {
		super("Usuarios del sistema", 500, 500);
		
		Dimension largoLabel = new Dimension(200, 30);
		Dimension largoTextfield = new Dimension(200, 30);
		Dimension dimBoton = new Dimension(100, 25);
		
		inUsuario = new EntradaTexto("Usuario", largoLabel, largoTextfield);
		
		btnAgregar = new Boton("Agregar", dimBoton);
		btnModificar = new Boton("Modificar", dimBoton);
		btnEliminar = new Boton("Eliminar", dimBoton);
		btnBuscar = new Boton("Buscar", dimBoton);
		btnLimpiar = new Boton("Limpiar", dimBoton);
		
		PanelHorizontal panelBotones = new PanelHorizontal();
		panelBotones.add(btnAgregar);
		panelBotones.add(btnModificar);
		panelBotones.add(btnEliminar);
		panelBotones.add(btnBuscar);
		panelBotones.add(btnLimpiar);
		
		List<Usuario> usuarios = UsuarioManager.traerTodo();
		tabla = new TablaUsuarios(usuarios);
		JScrollPane panelTabla = new JScrollPane(tabla);
		
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