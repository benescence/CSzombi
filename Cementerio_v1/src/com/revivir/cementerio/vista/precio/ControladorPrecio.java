package com.revivir.cementerio.vista.precio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JInternalFrame;

import com.revivir.cementerio.negocios.Busqueda;
import com.revivir.cementerio.persistencia.entidades.Precio;
import com.revivir.cementerio.vista.ControladorInterno;
import com.revivir.cementerio.vista.util.Popup;

public class ControladorPrecio implements ActionListener, ControladorInterno{
	private VentanaPrecio ventana;
	
	public ControladorPrecio() {
		ventana = new VentanaPrecio();
		ventana.botonBuscar().addActionListener(this);
		ventana.botonLimpiar().addActionListener(this);
		ventana.botonEliminar().addActionListener(this);
		ventana.botonAgregar().addActionListener(this);
		ventana.botonModificar().addActionListener(this);
		//ventana.mostrar();
	}

	public void actionPerformed(ActionEvent e) {
		// BOTON BUSCAR
		if (e.getSource() == ventana.botonBuscar())
			buscar();
	
		// BOTON LIMPIAR CAMPOS
		else if (e.getSource() == ventana.botonLimpiar())
			limpiar();
		else if (e.getSource() == ventana.botonAgregar())
			agregar();
		else if (e.getSource() == ventana.botonModificar())
			modificar();
		else if (e.getSource() == ventana.botonEliminar())
			eliminar();
	}
	
	private void eliminar() {
		// TODO Auto-generated method stub
		
	}

	private void modificar() {
		// TODO Auto-generated method stub
		
	}

	private void agregar() {
		// TODO Auto-generated method stub
		
	}

	private void limpiar() {
		ventana.getCodigo().setText("");
		ventana.getDescripcion().setText("");		
	}

	private void buscar() {
		String codigo = (ventana.getCodigo().getText().equals("") ? null : ventana.getCodigo().getText());
		String descripcion = (ventana.getDescripcion().getText().equals("") ? null : ventana.getDescripcion().getText());
		List<Precio> precios = Busqueda.precios(codigo, descripcion);
		ventana.getTabla().recargar(precios);
		if (precios.size() == 0)
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
