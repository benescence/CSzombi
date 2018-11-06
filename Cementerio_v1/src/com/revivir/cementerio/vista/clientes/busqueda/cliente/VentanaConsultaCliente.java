package com.revivir.cementerio.vista.clientes.busqueda.cliente;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.revivir.cementerio.persistencia.entidades.Cliente;
import com.revivir.cementerio.vista.tablas.TablaClientes;
import com.revivir.cementerio.vista.util.PanelHorizontal;
import com.revivir.cementerio.vista.util.PanelVertical;
import com.revivir.cementerio.vista.util.VentanaInterna;

public class VentanaConsultaCliente extends VentanaInterna{
	private static final long serialVersionUID = 1L;
	private TablaClientes tabla;
	private JTextField inDNI, inApellido, inNombre;
	private JButton btnBuscar, btnLimpiar;
	
	public VentanaConsultaCliente() {
		super("Consulta de clientes", 450, 300);
		Dimension largoEntrada = new Dimension(Short.MAX_VALUE, 25);
		Dimension largoLabel = new Dimension(100, 25);

		// LA TABLA
		tabla = new TablaClientes(new ArrayList<Cliente>());
		JScrollPane panelTabla = new JScrollPane();
		panelTabla.setViewportView(tabla);
		
		// ENTRADAS
		JLabel lblDNI = new JLabel("DNI");
		JLabel lblApellidos = new JLabel("Apellidos");
		JLabel lblNombres = new JLabel("Nombres");
		
		lblDNI.setPreferredSize(largoLabel);
		lblApellidos.setPreferredSize(largoLabel);
		lblNombres.setPreferredSize(largoLabel);
		
		inDNI = new JTextField();
		inApellido = new JTextField();
		inNombre = new JTextField();
		
		inDNI.setMaximumSize(largoEntrada);
		inApellido.setMaximumSize(largoEntrada);
		inNombre.setMaximumSize(largoEntrada);
		
		// BOTONES
		btnBuscar = new JButton("Buscar clientes");
		btnLimpiar = new JButton("Limpiar campos");
		PanelHorizontal panelBotones = new PanelHorizontal();
		panelBotones.add(btnBuscar);
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
		
		panelPrincipal.add(panelDNI);
		panelPrincipal.add(panelApellido);
		panelPrincipal.add(panelNombre);
		panelPrincipal.add(panelTabla);
		panelPrincipal.add(panelBotones);
	}

	public TablaClientes getTabla() {
		return tabla;
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

	public JButton botonBuscar() {
		return btnBuscar;
	}

	public JButton botonLimpiar() {
		return btnLimpiar;
	}

}