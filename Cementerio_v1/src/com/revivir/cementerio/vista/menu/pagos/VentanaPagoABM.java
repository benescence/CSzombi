package com.revivir.cementerio.vista.menu.pagos;

import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import com.revivir.cementerio.negocios.manager.PagoManager;
import com.revivir.cementerio.vista.tablas.TablaPagos;
import com.revivir.cementerio.vista.util.Boton;
import com.revivir.cementerio.vista.util.contenedores.PanelHorizontal;
import com.revivir.cementerio.vista.util.contenedores.PanelVertical;
import com.revivir.cementerio.vista.util.contenedores.VentanaInterna;

public class VentanaPagoABM extends VentanaInterna {
	private static final long serialVersionUID = 1L;
	private TablaPagos tabla;
	private Boton btnAgregar, btnModificar, btnEliminar;
	
	public VentanaPagoABM() {
		super("Gestion de pagos", 500, 500);
		
		//tabla = new TablaPagos(new ArrayList<>());
		tabla = new TablaPagos(PagoManager.traerTodo());
		JScrollPane panelTabla = new JScrollPane(tabla);
		
		Dimension dimBoton = new Dimension(100, 25);
		btnAgregar = new Boton("Agregar", dimBoton);
		btnModificar = new Boton("Modificar", dimBoton);
		btnEliminar = new Boton("Eliminar", dimBoton);
		PanelHorizontal panelBotones = new PanelHorizontal();
		panelBotones.setBorder(new EmptyBorder(10, 0, 0, 0));
		panelBotones.add(btnAgregar);
		panelBotones.add(btnModificar);
		panelBotones.add(btnEliminar);
		
		PanelVertical panelPrincipal = new PanelVertical();
		panelPrincipal.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(panelPrincipal);
		
		panelPrincipal.add(panelTabla);
		panelPrincipal.add(panelBotones);
	}
	
	public TablaPagos getTabla() {
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
	
}