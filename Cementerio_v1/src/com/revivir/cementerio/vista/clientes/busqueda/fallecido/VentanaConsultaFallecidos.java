package com.revivir.cementerio.vista.clientes.busqueda.fallecido;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.revivir.cementerio.persistencia.entidades.Fallecido;
import com.revivir.cementerio.vista.tablas.TablaFallecidos;
import com.revivir.cementerio.vista.util.EntradaTexto;
import com.revivir.cementerio.vista.util.PanelHorizontal;
import com.revivir.cementerio.vista.util.PanelVertical;
import com.revivir.cementerio.vista.util.VentanaInterna;

public class VentanaConsultaFallecidos extends VentanaInterna{
	private static final long serialVersionUID = 1L;
	private TablaFallecidos tabla;
	private EntradaTexto inDNI, inNombre, inApellido;
	private JButton btnBuscar, btnLimpiar;
	
	public VentanaConsultaFallecidos() {
		super("Consulta de fallecidos", 450, 300);

		// LA TABLA
		tabla = new TablaFallecidos(new ArrayList<Fallecido>());
		JScrollPane spTabla = new JScrollPane(tabla);
		//spTabla.setViewportView(tabla);
		PanelHorizontal panelTabla = new PanelHorizontal();
		panelTabla.setBorder(new EmptyBorder(10, 10, 10, 10));
		panelTabla.add(spTabla);
		
		// ENTRADAS
		Dimension largoTextfield = new Dimension(Short.MAX_VALUE, 25);
		Dimension largoLabel = new Dimension(100, 25);

		inDNI = new EntradaTexto("DNI", largoLabel, largoTextfield);
		inNombre = new EntradaTexto("Nombre", largoLabel, largoTextfield);
		inApellido = new EntradaTexto("Apellido", largoLabel, largoTextfield);
		
		// BOTONES
		btnBuscar = new JButton("Buscar");
		btnLimpiar = new JButton("Limpiar campos");
		PanelHorizontal panelBotones = new PanelHorizontal();
		panelBotones.add(btnBuscar);
		panelBotones.add(btnLimpiar);
				
		// ORGANIZACION DE PANELES
		PanelVertical panelPrincipal = new PanelVertical();
		panelPrincipal.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(panelPrincipal);
		
		panelPrincipal.add(inDNI);
		panelPrincipal.add(inApellido);
		panelPrincipal.add(inNombre);
		panelPrincipal.add(panelTabla);
		panelPrincipal.add(panelBotones);
	}

	public TablaFallecidos getTabla() {
		return tabla;
	}

	public JTextField getDNI() {
		return inDNI.getTextField();
	}

	public JTextField getApellido() {
		return inApellido.getTextField();
	}

	public JTextField getNombre() {
		return inNombre.getTextField();
	}

	public JButton botonBuscar() {
		return btnBuscar;
	}

	public JButton botonLimpiar() {
		return btnLimpiar;
	}

}