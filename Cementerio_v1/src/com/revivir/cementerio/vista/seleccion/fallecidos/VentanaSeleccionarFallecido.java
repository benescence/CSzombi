package com.revivir.cementerio.vista.seleccion.fallecidos;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import com.revivir.cementerio.negocios.manager.FallecidoManager;
import com.revivir.cementerio.vista.tablas.TablaFallecidos;
import com.revivir.cementerio.vista.util.Boton;
import com.revivir.cementerio.vista.util.contenedores.PanelHorizontal;
import com.revivir.cementerio.vista.util.contenedores.PanelVertical;
import com.revivir.cementerio.vista.util.contenedores.Ventana;

public class VentanaSeleccionarFallecido extends Ventana {
	private static final long serialVersionUID = 1L;
	private TablaFallecidos tabla;
	private Boton btnAceptar, btnCancelar;
	
	public VentanaSeleccionarFallecido() {
		super("Seleccionar fallecido", 500, 500);
		Dimension dimBoton = new Dimension(100, 25);
		
		tabla = new TablaFallecidos(FallecidoManager.traerTodo());
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

	public TablaFallecidos getTabla() {
		return tabla;
	}
	
	public JButton botonAceptar() {
		return btnAceptar;
	}

	public JButton botonCancelar() {
		return btnCancelar;
	}

}