package com.revivir.cementerio.vista.menu.cargos.fallecidos;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import com.revivir.cementerio.vista.tablas.TablaCargos;
import com.revivir.cementerio.vista.util.Boton;
import com.revivir.cementerio.vista.util.EntradaTexto;
import com.revivir.cementerio.vista.util.PanelHorizontal;
import com.revivir.cementerio.vista.util.PanelVertical;
import com.revivir.cementerio.vista.util.VentanaInterna;

public class VentanaCargosDeFallecidos extends VentanaInterna {
	private static final long serialVersionUID = 1L;
	private TablaCargos tabla;
	private Boton btnAgregar, btnModificar, btnEliminar, btnSeleccionar;
	private EntradaTexto inNombre, inApellido, inDNI;
	
	public VentanaCargosDeFallecidos() {
		super("Gestion de cargos de fallecidos", 500, 500);
		
		tabla = new TablaCargos(new ArrayList<>());
		JScrollPane panelTabla = new JScrollPane(tabla);
		
		Dimension dimBoton = new Dimension(100, 25);
		btnAgregar = new Boton("Agregar", dimBoton);
		btnModificar = new Boton("Modificar", dimBoton);
		btnEliminar = new Boton("Eliminar", dimBoton);
		btnSeleccionar = new Boton("Seleccionar", dimBoton);
		PanelHorizontal panelBotones = new PanelHorizontal();
		panelBotones.setBorder(new EmptyBorder(10, 0, 0, 0));
		panelBotones.add(btnAgregar);
		panelBotones.add(btnModificar);
		panelBotones.add(btnEliminar);
		panelBotones.add(btnSeleccionar);
		
		PanelVertical panelPrincipal = new PanelVertical();
		panelPrincipal.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(panelPrincipal);
		
		panelPrincipal.add(panelTabla);
		panelPrincipal.add(panelFallecido());
		panelPrincipal.add(panelBotones);
	}
	
	private PanelVertical panelFallecido() {
		Dimension dimLabel = new Dimension(100, 25);
		Dimension dimTextfield = new Dimension(300, 25);

		inNombre = new EntradaTexto("Nombres", dimLabel, dimTextfield);
		inApellido = new EntradaTexto("Apellidos", dimLabel, dimTextfield);
		inDNI = new EntradaTexto("DNI", dimLabel, dimTextfield);
		
		inNombre.habilitado(false);
		inApellido.habilitado(false);
		inDNI.habilitado(false);
		
		PanelVertical ret = new PanelVertical();
		ret.add(inNombre);
		ret.add(inApellido);
		ret.add(inDNI);
		return ret;
	}
	
	public TablaCargos getTabla() {
		return tabla;
	}
	
	public Boton botonAgregar() {
		return btnAgregar;
	}

	public Boton botonModificar() {
		return btnModificar;
	}
	
	public Boton botonEliminar() {
		return btnEliminar;
	}
	
	public Boton botonSeleccionar() {
		return btnSeleccionar;
	}

	public EntradaTexto getNombre() {
		return inNombre;
	}

	public EntradaTexto getApellido() {
		return inApellido;
	}

	public EntradaTexto getDNI() {
		return inDNI;
	}
	
}