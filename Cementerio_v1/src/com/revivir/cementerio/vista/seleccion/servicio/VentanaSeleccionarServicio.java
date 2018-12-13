package com.revivir.cementerio.vista.seleccion.servicio;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import com.revivir.cementerio.negocios.manager.ServicioManager;
import com.revivir.cementerio.vista.tablas.TablaServicios;
import com.revivir.cementerio.vista.util.Boton;
import com.revivir.cementerio.vista.util.PanelHorizontal;
import com.revivir.cementerio.vista.util.PanelVertical;
import com.revivir.cementerio.vista.util.Ventana;

public class VentanaSeleccionarServicio extends Ventana {
	private static final long serialVersionUID = 1L;
	private TablaServicios tabla;
	private Boton btnAceptar, btnCancelar;
	
	public VentanaSeleccionarServicio() {
		super("Seleccionar servicio", 500, 500);
		Dimension dimBoton = new Dimension(100, 25);
		
		tabla = new TablaServicios(ServicioManager.traerTodo());
		JScrollPane panelTabla = new JScrollPane(tabla);
		
		btnAceptar = new Boton("Aceptar", dimBoton);
		btnCancelar = new Boton("Cancelar", dimBoton);
		PanelHorizontal panelBotones = new PanelHorizontal();
		panelBotones.add(btnAceptar);
		panelBotones.add(btnCancelar);
		
		PanelVertical panelprincipal = new PanelVertical();
		panelprincipal.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(panelprincipal);
		
		panelprincipal.add(panelTabla);
		panelprincipal.add(panelBotones);
	}

	public TablaServicios getTabla() {
		return tabla;
	}
	
	public JButton botonAceptar() {
		return btnAceptar;
	}

	public JButton botonCancelar() {
		return btnCancelar;
	}

}