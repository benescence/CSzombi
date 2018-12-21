package com.revivir.cementerio.vista.precio;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.revivir.cementerio.persistencia.entidades.Servicio;

import com.revivir.cementerio.vista.tablas.TablaPrecios;
import com.revivir.cementerio.vista.util.contenedores.PanelHorizontal;
import com.revivir.cementerio.vista.util.contenedores.PanelVertical;
import com.revivir.cementerio.vista.util.contenedores.VentanaInterna;

public class VentanaPrecio extends VentanaInterna{
	private static final long serialVersionUID = 1L;
	private TablaPrecios tabla;
	private JTextField incodigo, indescripcion;
	private JButton btnBuscar, btnLimpiar, btnAgregar, btnEliminar, btnModificar;
	
	public VentanaPrecio() {
		super("Gestion de precios", 450, 300);
		Dimension largoEntrada = new Dimension(Short.MAX_VALUE, 25);
		Dimension largoLabel = new Dimension(100, 25);

		// LA TABLA
		tabla = new TablaPrecios(new ArrayList<Servicio>());
		JScrollPane panelTabla = new JScrollPane();
		panelTabla.setViewportView(tabla);
		
		// ENTRADAS
		JLabel lblcodigo = new JLabel("Codigo");
		JLabel lbldescripcion = new JLabel("Descripcion");
		
		
		lblcodigo.setPreferredSize(largoLabel);
		lbldescripcion.setPreferredSize(largoLabel);

		
		incodigo = new JTextField();
		indescripcion = new JTextField();
		
		
		incodigo.setMaximumSize(largoEntrada);
		indescripcion.setMaximumSize(largoEntrada);
		
		
		// BOTONES
		btnBuscar = new JButton("Buscar codigo");
		btnLimpiar = new JButton("Limpiar campos");
		btnAgregar = new JButton("Agregar");
		btnEliminar = new JButton("Eliminar");
		btnModificar = new JButton("Modificar");
		PanelHorizontal panelBotones = new PanelHorizontal();
		panelBotones.add(btnBuscar);
		panelBotones.add(btnLimpiar);
		panelBotones.add(btnEliminar);
		panelBotones.add(btnAgregar);
		panelBotones.add(btnModificar);
				
		// ORGANIZACION DE PANELES
		PanelVertical panelPrincipal = new PanelVertical();
		setContentPane(panelPrincipal);
		
		PanelHorizontal panelCodigo = new PanelHorizontal();
		panelCodigo.add(lblcodigo);
		panelCodigo.add(incodigo);

		PanelHorizontal panelDescripcion = new PanelHorizontal();
		panelDescripcion.add(lbldescripcion);
		panelDescripcion.add(indescripcion);

		
		
		panelPrincipal.add(panelCodigo);
		panelPrincipal.add(panelDescripcion);
		panelPrincipal.add(panelTabla);
		panelPrincipal.add(panelBotones);
	}

	public TablaPrecios getTabla() {
		return tabla;
	}

	public JTextField getCodigo() {
		return incodigo;
	}

	public JTextField getDescripcion() {
		return indescripcion;
	}


	public JButton botonBuscar() {
		return btnBuscar;
	}

	public JButton botonLimpiar() {
		return btnLimpiar;
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
}
