package com.revivir.cementerio.vista.servicios.servicioAM;

import java.awt.Dimension;

import javax.swing.border.EmptyBorder;

import com.revivir.cementerio.vista.util.Boton;
import com.revivir.cementerio.vista.util.EntradaTexto;
import com.revivir.cementerio.vista.util.PanelHorizontal;
import com.revivir.cementerio.vista.util.PanelVertical;
import com.revivir.cementerio.vista.util.Ventana;

public class VentanaServicioAM extends Ventana {
	private static final long serialVersionUID = 1L;
	private EntradaTexto inCodigo, inNombre, inImporte, inDescripcion;
	private Boton btnAceptar, btnCancelar;
	
	public VentanaServicioAM(String titulo, int ancho, int alto) {
		super("Agregar servicio", 500, 500);
		iniciarComponentes();
	}

	private void iniciarComponentes() {
		Dimension dimLabel = new Dimension(100, 25);
		Dimension dimTextfield = new Dimension(250, 25);
		Dimension dimBoton = new Dimension(100, 25);
		
		inCodigo = new EntradaTexto("Codigo", dimLabel, dimTextfield);
		inNombre = new EntradaTexto("Nombre", dimLabel, dimTextfield);
		inImporte = new EntradaTexto("Importe", dimLabel, dimTextfield);
		inDescripcion = new EntradaTexto("Descripcion", dimLabel, dimTextfield);
		
		btnAceptar = new Boton("Aceptar", dimBoton);
		btnCancelar = new Boton("Cancelar", dimBoton);
		PanelHorizontal panelBotones = new PanelHorizontal();
		panelBotones.setBorder(new EmptyBorder(10, 0, 0, 0));
		panelBotones.add(btnAceptar);
		panelBotones.add(btnCancelar);
		
		PanelVertical panelPrincipal = new PanelVertical();
		panelPrincipal.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(panelPrincipal);
		
		panelPrincipal.add(inCodigo);
		panelPrincipal.add(inNombre);
		panelPrincipal.add(inImporte);
		panelPrincipal.add(inDescripcion);
		panelPrincipal.add(panelBotones);
		pack();
	}

}