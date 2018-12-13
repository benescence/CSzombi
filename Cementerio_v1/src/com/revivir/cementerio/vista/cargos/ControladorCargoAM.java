package com.revivir.cementerio.vista.cargos;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.revivir.cementerio.negocios.manager.CargoManager;
import com.revivir.cementerio.persistencia.entidades.Fallecido;
import com.revivir.cementerio.persistencia.entidades.Servicio;
import com.revivir.cementerio.vista.ControladorPrincipal;
import com.revivir.cementerio.vista.seleccion.fallecidos.ControladorSeleccionarFallecido;
import com.revivir.cementerio.vista.seleccion.fallecidos.FallecidoSeleccionable;
import com.revivir.cementerio.vista.seleccion.servicio.ControladorSeleccionarServicio;
import com.revivir.cementerio.vista.seleccion.servicio.ServicioSeleccionable;
import com.revivir.cementerio.vista.util.Popup;

public class ControladorCargoAM implements ServicioSeleccionable, FallecidoSeleccionable {
	private VentanaCargoAM ventana;
	private ControladorPrincipal principal;
	private Fallecido fallecido;
	private Servicio servicio;
	
	public ControladorCargoAM(ControladorPrincipal invocador) {
		this.principal = invocador;
		ventana = new VentanaCargoAM();
		inicializar();
	}
	
	private void inicializar() {
		ventana.botonAceptar().addActionListener(e -> aceptar());
		ventana.botonCancelar().addActionListener(e -> cancelar());
		ventana.botonFallecido().addActionListener(e -> seleccionarFallecido());
		ventana.botonServicio().addActionListener(e -> seleccionarServicio());
		ventana.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				cancelar();
			}
		});
	} 
	
	private void seleccionarServicio() {
		ventana.setEnabled(false);
		new ControladorSeleccionarServicio(this);
	}

	private void seleccionarFallecido() {
		ventana.setEnabled(false);
		new ControladorSeleccionarFallecido(this);
	}
	
	private void aceptar() {
		if (servicio == null || fallecido == null) {
			Popup.mostrar("Debe seleccionar un servicio y un fallecido para poder crear un cargo.");
			return;
		}
		
		String observaciones = ventana.getObservaciones().getTextField().getText();
		CargoManager.guardar(fallecido, servicio, observaciones, false);
		volver();
	}
	
	private void cancelar() {
		if (Popup.confirmar("Se perderan los datos ingresados.\n¿Esta seguro de que desea cancelar la operacion?"))
			volver();
	}

	private void volver() {
		ventana.dispose();
		ventana = null;
		principal.getVentana().mostrar();
	}

	@Override
	public void mostrar() {
		ventana.mostrar();
	}

	@Override
	public void seleccionarFallecido(Fallecido fallecido) {
		this.fallecido = fallecido;
		ventana.getNombre().getTextField().setText(fallecido.getNombre());
		ventana.getApellido().getTextField().setText(fallecido.getApellido());
		ventana.getDNI().getTextField().setText(fallecido.getDni());
	}

	@Override
	public void seleccionarServicio(Servicio servicio) {
		this.servicio = servicio;
		ventana.getCodigo().getTextField().setText(servicio.getCodigo());
		ventana.getNombreServicio().getTextField().setText(servicio.getNombre());
		ventana.getDescripcion().getTextField().setText(servicio.getDescripcion());
		ventana.getImporte().getTextField().setText(servicio.getImporte().toString());
	}
	
}