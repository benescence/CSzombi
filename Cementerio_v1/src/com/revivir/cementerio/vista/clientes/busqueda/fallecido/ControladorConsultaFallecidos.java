package com.revivir.cementerio.vista.clientes.busqueda.fallecido;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JInternalFrame;

import com.revivir.cementerio.negocios.Busqueda;
import com.revivir.cementerio.persistencia.entidades.Fallecido;
import com.revivir.cementerio.vista.ControladorInterno;
import com.revivir.cementerio.vista.util.Popup;

public class ControladorConsultaFallecidos implements ActionListener, ControladorInterno{
	private VentanaConsultaFallecidos ventana;
	
	public ControladorConsultaFallecidos() {
		ventana = new VentanaConsultaFallecidos();
		ventana.botonBuscar().addActionListener(this);
		ventana.botonLimpiar().addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		// BOTON BUSCAR
		if (e.getSource() == ventana.botonBuscar())
			buscar();
	
		// BOTON LIMPIAR CAMPOS
		else if (e.getSource() == ventana.botonLimpiar())
			limpiar();
	}
	
	private void limpiar() {
		ventana.getDNI().setText("");
		ventana.getNombre().setText("");
		ventana.getApellido().setText("");		
	}

	private void buscar() {
		String DNI = ventana.getDNI().getText();
		String nombres = ventana.getNombre().getText();
		String apellido = ventana.getApellido().getText();
		List<Fallecido> lista = Busqueda.fallecidos(DNI, nombres, apellido);
		ventana.getTabla().recargar(lista);
		if (lista.size() == 0)
			Popup.mostrar("No se ha encontrado ningun resultado con los criterios ingresados.");
	}

	@Override
	public boolean finalizar() {
		ventana.dispose();
		ventana = null;
		return true;
	}

	@Override
	public JInternalFrame getVentana() {
		return ventana;
	}
	
}