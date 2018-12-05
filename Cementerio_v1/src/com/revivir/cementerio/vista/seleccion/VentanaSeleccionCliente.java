package com.revivir.cementerio.vista.seleccion;

import javax.swing.JScrollPane;

import com.revivir.cementerio.negocios.manager.ClienteManager;
import com.revivir.cementerio.vista.tablas.TablaClientes;
import com.revivir.cementerio.vista.util.Boton;
import com.revivir.cementerio.vista.util.PanelHorizontal;
import com.revivir.cementerio.vista.util.PanelVertical;
import com.revivir.cementerio.vista.util.Ventana;

import java.awt.Dimension;

import javax.swing.JButton;

public class VentanaSeleccionCliente extends Ventana {
	private static final long serialVersionUID = 1L;
	private TablaClientes tabla;
	private Boton btnSeleccionar, btnCancelar;
	
	public VentanaSeleccionCliente() {
		super("Seleccionar cliente", 500, 500);
		Dimension dimBoton = new Dimension(100, 25);
		
		
		// TABLA
		tabla = new TablaClientes(ClienteManager.traerTodo());
		JScrollPane panelTabla = new JScrollPane();
		panelTabla.setViewportView(tabla);
		
		// BOTONES
		btnSeleccionar = new Boton("Seleccionar", dimBoton);
		btnCancelar = new Boton("Cancelar", dimBoton);
		PanelHorizontal panelBotones = new PanelHorizontal();
		panelBotones.add(btnSeleccionar);
		panelBotones.add(btnCancelar);
		
		// ORGANIZO PANELES
		PanelVertical panelprincipal = new PanelVertical();
		setContentPane(panelprincipal);
		
		panelprincipal.add(panelTabla);
		panelprincipal.add(panelBotones);
	}

	
	public TablaClientes getTabla() {
		return tabla;
	}

	
	public JButton botonSeleccionar() {
		return btnSeleccionar;
	}


	public JButton botonCancelar() {
		return btnCancelar;
	}

}