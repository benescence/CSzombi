package com.revivir.cementerio.vista.responsables;

import java.awt.Dimension;

import javax.swing.border.EmptyBorder;

import com.revivir.cementerio.vista.util.Boton;
import com.revivir.cementerio.vista.util.EntradaTexto;
import com.revivir.cementerio.vista.util.PanelHorizontal;
import com.revivir.cementerio.vista.util.PanelVertical;
import com.revivir.cementerio.vista.util.Ventana;

public class VentanaVincular extends Ventana {
	private static final long serialVersionUID = 1L;
	private EntradaTexto inNombre, inApellido, inDNI, inTelefono, inEmail;
	private EntradaTexto inDNIFallecido, inApellidoFallecido, inNombreFallecido;
	private Boton btnAceptar, btnCancelar;
	
	public VentanaVincular() {
		super("Vincular clientes con fallecidos", 500, 500);
		inicializar();
	}
	
	private void inicializar() {
		PanelHorizontal panelH = new PanelHorizontal();
		panelH.add(crearPanelCliente());
		panelH.add(crearPanelFallecido());
		
		Dimension dimBoton = new Dimension(100, 25);
		btnAceptar = new Boton("Aceptar", dimBoton);
		btnCancelar = new Boton("Cancelar", dimBoton);
		PanelHorizontal panelBotones = new PanelHorizontal();
		panelBotones.setBorder(new EmptyBorder(10, 0, 0, 0));
		panelBotones.add(btnAceptar);
		panelBotones.add(btnCancelar);

		PanelVertical panelPrincipal = new PanelVertical();
		panelPrincipal.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(panelPrincipal);

		panelPrincipal.add(panelH);
		panelPrincipal.add(panelBotones);
		pack();
	}
	
	private PanelVertical crearPanelCliente() {
		Dimension dimensionLabel = new Dimension(100, 25);
		Dimension largoTextfield = new Dimension(300, 25);

		inNombre = new EntradaTexto("Nombres", dimensionLabel, largoTextfield);
		inApellido = new EntradaTexto("Apellidos", dimensionLabel, largoTextfield);
		inDNI = new EntradaTexto("DNI", dimensionLabel, largoTextfield);
		inTelefono = new EntradaTexto("Telefono", dimensionLabel, largoTextfield);
		inEmail = new EntradaTexto("E-Mail", dimensionLabel, largoTextfield);
		
		PanelVertical ret = new PanelVertical();
		ret.add(inNombre);
		ret.add(inApellido);
		ret.add(inDNI);
		ret.add(inTelefono);
		ret.add(inEmail);
		return ret;
	}

	private PanelVertical crearPanelFallecido() {
		Dimension dimensionLabel = new Dimension(100, 25);
		Dimension largoTextfield = new Dimension(300, 25);

		inNombreFallecido = new EntradaTexto("Nombres", dimensionLabel, largoTextfield);
		inApellidoFallecido = new EntradaTexto("Apellidos", dimensionLabel, largoTextfield);
		inDNIFallecido = new EntradaTexto("DNI", dimensionLabel, largoTextfield);
		
		PanelVertical ret = new PanelVertical();
		ret.add(inNombreFallecido);
		ret.add(inApellidoFallecido);
		ret.add(inDNIFallecido);
		return ret;
	}
	
	
	
	

}
