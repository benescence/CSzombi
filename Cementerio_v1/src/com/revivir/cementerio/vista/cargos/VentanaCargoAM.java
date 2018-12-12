package com.revivir.cementerio.vista.cargos;

import java.awt.Dimension;

import javax.swing.border.EmptyBorder;

import com.revivir.cementerio.vista.util.Boton;
import com.revivir.cementerio.vista.util.EntradaTexto;
import com.revivir.cementerio.vista.util.PanelHorizontal;
import com.revivir.cementerio.vista.util.PanelVertical;
import com.revivir.cementerio.vista.util.Ventana;

public class VentanaCargoAM extends Ventana {
	private static final long serialVersionUID = 1L;
	private EntradaTexto inFallecido, inServicio, inObservaciones, inPagado;
	private Boton btnAceptar, btnCancelar;
	
	public VentanaCargoAM() {
		super("Alta de cargo", 500, 500);
		
		Dimension dimLabel = new Dimension(100, 25);
		Dimension dimTextfield = new Dimension(250, 25);
		Dimension dimBoton = new Dimension(100, 25);
		
		inFallecido = new EntradaTexto("Fallecido", dimLabel, dimTextfield);
		inServicio = new EntradaTexto("Servicio", dimLabel, dimTextfield);
		inObservaciones = new EntradaTexto("Observaciones", dimLabel, dimTextfield);
		inPagado = new EntradaTexto("Pagado", dimLabel, dimTextfield);
		
		btnAceptar = new Boton("Aceptar", dimBoton);
		btnCancelar = new Boton("Cancelar", dimBoton);		
		PanelHorizontal panelBotones = new PanelHorizontal();
		panelBotones.setBorder(new EmptyBorder(10, 0, 0, 0));
		panelBotones.add(btnAceptar);
		panelBotones.add(btnCancelar);
		
		// PANELES
		PanelVertical panelPrincipal = new PanelVertical();
		panelPrincipal.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(panelPrincipal);
		
		panelPrincipal.add(inFallecido);
		panelPrincipal.add(inServicio);
		panelPrincipal.add(inObservaciones);
		panelPrincipal.add(inPagado);
		panelPrincipal.add(panelBotones);
		pack();
	}

}