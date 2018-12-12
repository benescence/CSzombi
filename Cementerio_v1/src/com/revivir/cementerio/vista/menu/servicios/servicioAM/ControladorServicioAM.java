package com.revivir.cementerio.vista.menu.servicios.servicioAM;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.revivir.cementerio.negocios.manager.ServicioManager;
import com.revivir.cementerio.persistencia.entidades.Servicio;
import com.revivir.cementerio.vista.ControladorPrincipal;
import com.revivir.cementerio.vista.menu.servicios.ControladorServiciosABM;
import com.revivir.cementerio.vista.util.Popup;

public class ControladorServicioAM {
	private VentanaServicioAM ventana;
	private ControladorServiciosABM invocador;
	private ControladorPrincipal principal;
	private Servicio servicio;
	
	public ControladorServicioAM(ControladorServiciosABM invocador, Servicio servicio) {
		this.invocador = invocador;
		this.servicio = servicio;
		ventana = new VentanaServicioAM(servicio);
		inicializar();
	}
	
	public ControladorServicioAM(ControladorServiciosABM invocador) {
		this.invocador = invocador;
		ventana = new VentanaServicioAM();
		inicializar();
	}
	
	public ControladorServicioAM(ControladorPrincipal principal) {
		this.principal = principal;
		ventana = new VentanaServicioAM();
		inicializar();
	}
	
	private void inicializar() {
		ventana.botonAceptar().addActionListener(e -> aceptar());
		ventana.botonCancelar().addActionListener(e -> cancelar());
		ventana.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				volver();
			}
		});
	} 
	
	private void aceptar() {
		String codigo = ventana.getCodigo().getText();
		String nombre = ventana.getNombre().getText();
		String descripcion = ventana.getDescripcion().getText();
		Double importe = new Double(ventana.getImporte().getText());
		
		// Creando un nuevo servicio
		if (servicio == null) {
			ServicioManager.guardar(codigo, nombre, importe, descripcion, false);
		}
		
		// Modificando un servicio existente
		else {
			servicio.setCodigo(codigo);
			servicio.setNombre(nombre);
			servicio.setDescripcion(descripcion);
			servicio.setImporte(importe);
			ServicioManager.modificar(servicio);
		}
		
		if (invocador != null)
			invocador.actualizar();
		volver();
	}
	
	private void cancelar() {
		if (Popup.confirmar("Se perderan los datos ingresados.\n¿Esta seguro de que desea cancelar la operacion?"))
			volver();
	}

	private void volver() {
		ventana.dispose();
		ventana = null;
		if (invocador != null)
			invocador.mostrar();
		else
			principal.getVentana().mostrar();
	}
	
}