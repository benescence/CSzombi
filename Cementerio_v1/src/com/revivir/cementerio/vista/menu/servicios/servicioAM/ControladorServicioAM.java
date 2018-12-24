package com.revivir.cementerio.vista.menu.servicios.servicioAM;

import com.revivir.cementerio.negocios.manager.ServicioManager;
import com.revivir.cementerio.persistencia.entidades.Servicio;
import com.revivir.cementerio.vista.ControladorExterno;
import com.revivir.cementerio.vista.util.AccionCerrarVentana;
import com.revivir.cementerio.vista.util.Popup;

public class ControladorServicioAM implements ControladorExterno{
	private VentanaServicioAM ventana;
	private ServicioInvocable invocador;
	private Servicio modificar;
	
	public ControladorServicioAM(ServicioInvocable invocador, Servicio modificar) {
		this.invocador = invocador;
		this.modificar = modificar;
		ventana = new VentanaServicioAM(modificar);
		inicializar();
	}

	public ControladorServicioAM(ServicioInvocable invocador) {
		this.invocador = invocador;
		ventana = new VentanaServicioAM();
		inicializar();
	}
	
	private void inicializar() {
		ventana.addWindowListener(new AccionCerrarVentana(e -> cancelar()));
		ventana.botonAceptar().setAccion(e -> aceptar());
		ventana.botonCancelar().setAccion(e -> cancelar());
	} 
	
	private void aceptar() {
		ventana.requestFocusInWindow();
		try {
			String codigo = ventana.getCodigo().getText();
			String nombre = ventana.getNombre().getText();
			String descripcion = ventana.getDescripcion().getText();
			Double importe = new Double(ventana.getImporte().getText());
			Servicio nuevo = new Servicio(-1, codigo, nombre, descripcion, importe, false);
			
			// Creando un nuevo servicio
			if (modificar == null)
				ServicioManager.guardar(nuevo);
			
			// Modificando un servicio existente
			else
				ServicioManager.modificar(nuevo, modificar);
			
			ventana.dispose();
			ventana = null;
			invocador.mostrar();
			invocador.actualizarServicios();
			
		} catch (NumberFormatException e) {
			Popup.mostrar("El valor para el importe no tiene un formato valido para numero decimal.");
		
		} catch (Exception e) {
			Popup.mostrar(e.getMessage());
		}
		
	}
	
	private void cancelar() {
		if (Popup.confirmar("Se perderan los datos ingresados.\n�Esta seguro de que desea cancelar la operacion?")) {
			ventana.dispose();
			ventana = null;
			invocador.mostrar();
		}
	}
	
}