package com.revivir.cementerio.vista.menu.servicios;

import java.util.List;

import javax.swing.JInternalFrame;

import com.revivir.cementerio.negocios.manager.ServicioManager;
import com.revivir.cementerio.persistencia.entidades.Servicio;
import com.revivir.cementerio.vista.ControladorInterno;
import com.revivir.cementerio.vista.ControladorPrincipal;
import com.revivir.cementerio.vista.menu.servicios.servicioAM.ControladorServicioAM;
import com.revivir.cementerio.vista.menu.servicios.servicioAM.ServicioInvocable;
import com.revivir.cementerio.vista.util.Popup;

public class ControladorServiciosABM implements ControladorInterno, ServicioInvocable {
	private VentanaServiciosABM ventana;
	private ControladorPrincipal invocador;
	
	public ControladorServiciosABM(ControladorPrincipal invocador) {
		this.invocador = invocador;
		ventana = new VentanaServiciosABM();
		ventana.botonAgregar().addActionListener(e -> agregar());
		ventana.botonModificar().addActionListener(e -> modificar());
		ventana.botonEliminar().addActionListener(e -> eliminar());
	}
	
	private void agregar() {
		invocador.getVentana().setEnabled(false);
		new ControladorServicioAM(this);
	}

	private void modificar() {
		List<Servicio> seleccion = ventana.getTabla().obtenerSeleccion();
		if (seleccion.size() != 1) {
			Popup.mostrar("Debe seleccionar exactamente 1 servicio para poder modificarlo.");
			return;
		}
		
		invocador.getVentana().setEnabled(false);
		new ControladorServicioAM(this, seleccion.get(0));
	}
	
	private void eliminar() {
		List<Servicio> seleccion = ventana.getTabla().obtenerSeleccion();
		if (seleccion.isEmpty()) {
			Popup.mostrar("Debe seleccionar algun servicio para poder eliminarlo.");
			return;
		}
		
		if (Popup.confirmar("¿Esta seguro de que desea eliminar los servicio seleccionados?")) {
			for (Servicio elemento : seleccion)
				ServicioManager.eliminar(elemento);
			
			actualizarServicios();
		}
	}
	
	public void mostrar() {
		invocador.getVentana().mostrar();
		invocador.getVentana().toFront();
	}
	
	@Override
	public boolean finalizar() {
		return true;
	}

	@Override
	public JInternalFrame getVentana() {		
		return ventana;
	}

	@Override
	public void actualizarServicios() {
		ventana.getTabla().recargar(ServicioManager.traerTodo());		
	}

}