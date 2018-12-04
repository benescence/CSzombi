package com.revivir.cementerio.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorPrincipal implements ActionListener {
	VentanaPrincipal ventana;
	ControladorInterno controladorInterno;
	
	public ControladorPrincipal() {
		ventana = new VentanaPrincipal();
		ventana.getMenu1opcion1().addActionListener(this);
		ventana.getMenu1opcion2().addActionListener(this);
		ventana.getMenu1opcion3().addActionListener(this);
		ventana.getMenu2opcion1().addActionListener(this);
		ventana.getMenu2opcion2().addActionListener(this);
		ventana.itemUsuariosAlta().addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == ventana.getMenu1opcion1())
			System.out.println("Presionando menu 1 opcion 1");

		else if (e.getSource() == ventana.getMenu1opcion2())
			System.out.println("Presionando menu 1 opcion 2");
		
		else if (e.getSource() == ventana.getMenu1opcion3())
			System.out.println("Presionando menu 1 opcion 3");
		
		else if (e.getSource() == ventana.getMenu2opcion1())
			System.out.println("Presionando menu 2 opcion 1");
		
		else if (e.getSource() == ventana.getMenu2opcion2())
			System.out.println("Presionando menu 2 opcion 2");
		
		else if (e.getSource() == ventana.itemUsuariosAlta())
			mostrarIniciarSesion();
	}

	private void mostrarIniciarSesion() {
		System.out.println("metodo");
		//mostrarVentana(new ControladorUsuarioAM());
	}

	/*private void mostrarVentana(ControladorInterno controlador) {
		if (controladorInterno == null || controladorInterno.finalizar()) {
			ventana.getContentPane().removeAll();
			ventana.getContentPane().repaint();
			 
			controladorInterno = controlador;
			PanelVertical panel = new PanelVertical();
		    panel.add(controladorInterno.getVentana());
			ventana.setContentPane(panel);
			System.out.println("Clickeo");
		}
	}*/
	
}