package com.revivir.cementerio.vista.clientes.clienteAM;

import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.revivir.cementerio.vista.util.Boton;
import com.revivir.cementerio.vista.util.EntradaTexto;
import com.revivir.cementerio.vista.util.PanelHorizontal;
import com.revivir.cementerio.vista.util.PanelVertical;
import com.revivir.cementerio.vista.util.Ventana;

public class VentanaClientesAM extends Ventana {
	private static final long serialVersionUID = 1L;
	private EntradaTexto inNombre, inApellido, inDNI, inTelefono, inEmail;
	private Boton btnAceptar, btnCancelar;
	
	public VentanaClientesAM() {
		super("Alta de cliente", 500, 500);

		Dimension largoLabel = new Dimension(100, 25);
		Dimension largoTextfield = new Dimension(300, 25);
		Dimension dimBoton = new Dimension(100, 25);

		inNombre = new EntradaTexto("Nombres", largoLabel, largoTextfield);
		inApellido = new EntradaTexto("Apellidos", largoLabel, largoTextfield);
		inDNI = new EntradaTexto("DNI", largoLabel, largoTextfield);
		inTelefono = new EntradaTexto("Telefono", largoLabel, largoTextfield);
		inEmail = new EntradaTexto("E-Mail", largoLabel, largoTextfield);
		
		btnAceptar = new Boton("Aceptar", dimBoton);
		btnCancelar = new Boton("Cancelar", dimBoton);
		PanelHorizontal panelBotones = new PanelHorizontal();
		panelBotones.setBorder(new EmptyBorder(10, 0, 0, 0));
		panelBotones.add(btnAceptar);
		panelBotones.add(btnCancelar);

		PanelVertical panelPrincipal = new PanelVertical();
		panelPrincipal.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(panelPrincipal);

		panelPrincipal.add(inNombre);
		panelPrincipal.add(inApellido);
		panelPrincipal.add(inDNI);
		panelPrincipal.add(inTelefono);
		panelPrincipal.add(inEmail);
		panelPrincipal.add(panelBotones);
		pack();
	}

	
	public JTextField getInNombre() {
		return inNombre.getTextField();
	}
	

	public JTextField getInApellido() {
		return inApellido.getTextField();
	}
	

	public JTextField getInDNI() {
		return inDNI.getTextField();
	}
	

	public JTextField getInTelefono() {
		return inTelefono.getTextField();
	}
	

	public JTextField getInEmail() {
		return inEmail.getTextField();
	}
	

	public Boton botonAceptar() {
		return btnAceptar;
	}
	

	public Boton botonCancelar() {
		return btnCancelar;
	}
		
}