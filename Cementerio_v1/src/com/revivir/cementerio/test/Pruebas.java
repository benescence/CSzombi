package com.revivir.cementerio.test;

import java.awt.Dimension;

import com.revivir.cementerio.vista.util.Boton;
import com.revivir.cementerio.vista.util.PanelVertical;
import com.revivir.cementerio.vista.util.PresionarEnterListener;
import com.revivir.cementerio.vista.util.Ventana;

public class Pruebas extends Ventana {
	private static final long serialVersionUID = 1L;

	public Pruebas() {
		super("Prueba de boton", 500, 500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		Boton boton1 = new Boton("Boton 1", new Dimension(100, 25));
		Boton boton2 = new Boton("Boton 2", new Dimension(100, 25));
		
		boton1.addActionListener(e->boton1());
		boton2.addActionListener(e->boton2());
		
		boton1.addKeyListener(new PresionarEnterListener(e -> boton1()));
		boton2.addKeyListener(new PresionarEnterListener(e -> boton2()));
		
		PanelVertical panel = crearPanelPrincipal();
		panel.add(boton1);
		panel.add(boton2);
		compactar();
	}

	private void boton1() {
		System.out.println("Boton 1");
	}

	private void boton2() {
		System.out.println("Boton 2");
	}

	public static void main(String[] args) {
		new ControladorIniciarSesion();
	}
	
}