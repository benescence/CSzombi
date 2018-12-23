package com.revivir.cementerio.vista.menu.movimientos;

import java.sql.Date;

import com.revivir.cementerio.negocios.Almanaque;
import com.revivir.cementerio.negocios.manager.FallecidoManager;
import com.revivir.cementerio.negocios.manager.MovimientoManager;
import com.revivir.cementerio.persistencia.entidades.Fallecido;
import com.revivir.cementerio.persistencia.entidades.Movimiento;
import com.revivir.cementerio.vista.menu.movimientos.translado.MovimientoInvocable;
import com.revivir.cementerio.vista.seleccion.fallecidos.ControladorSeleccionarFallecido;
import com.revivir.cementerio.vista.seleccion.fallecidos.FallecidoSeleccionable;
import com.revivir.cementerio.vista.util.AccionCerrarVentana;
import com.revivir.cementerio.vista.util.Formato;
import com.revivir.cementerio.vista.util.Popup;

public class ControladorTranslado implements  FallecidoSeleccionable {

	private VentanaTranslado ventana;
	private MovimientoInvocable invocador;
	private Movimiento modificar;
	private Fallecido fallecido;
	
	
	public ControladorTranslado(MovimientoInvocable invocador, Movimiento modificar) {
		this.fallecido = FallecidoManager.traerPorID(modificar.getFallecido());
		this.invocador = invocador;
		this.modificar = modificar;
		seleccionarFallecido(fallecido);
		ventana = new VentanaTranslado(modificar);
		inicializar();
	}
	
	public ControladorTranslado(MovimientoInvocable invocador) {
		this.invocador = invocador;
		ventana = new VentanaTranslado();
	
		inicializar();
	}
	
	private void inicializar() {
	
		
		ventana.botonSeleccionar().setAccion(e -> seleccionarFallecido());
		ventana.addWindowListener(new AccionCerrarVentana(e -> cancelar()));
		ventana.botonAceptar().setAccion(e -> aceptar());
		ventana.botonCancelar().setAccion(e -> cancelar());
	
	} 
	

	
	
	
	private void aceptar() {
		ventana.requestFocusInWindow();
		
		try {
			String causa= ventana.getInCausa().getText();;
			Integer ubicacionAnt= this.fallecido.getUbicacion();
			String observacion= (!ventana.getInObservacions().getText().equals("") ? ventana.getInObservacions().getText() : null);
			Date fecha = Almanaque.hoy();
			Fallecido fallecido = this.fallecido;
			Movimiento nuevo = new Movimiento(-1,fallecido.getID(), Formato.ubicacion(fallecido), causa, observacion, fecha);
			
			
			if (modificar == null)
				MovimientoManager.guardar(fallecido.getID(),  Formato.ubicacion(fallecido), causa, observacion, fecha);
			
			// Modificar uno existente
			else 
				MovimientoManager.modificar(modificar);
				FallecidoManager.modificar(fallecido);
			invocador.actualizarMovimientos();
			ventana.dispose();
			ventana = null;
			invocador.mostrar();
			
		} catch (Exception e) {
			Popup.mostrar(e.getMessage());
		}
		
	}
	private void seleccionarFallecido() {
		ventana.setEnabled(false);
		new ControladorSeleccionarFallecido(this);
	}
	private void cancelar() {
		if (Popup.confirmar("Se perderan los datos ingresados.\n¿Esta seguro de que desea cancelar la operacion?")) {
			ventana.dispose();
			ventana = null;
			invocador.mostrar();
		}
	}

	@Override
	public void seleccionarFallecido(Fallecido fallecido) {
		this.fallecido = fallecido;
		ventana.getInUbicacion().habilitado(true);
		ventana.getInFallecido().habilitado(true);
		ventana.getInUbicacion().getTextField().setText(Formato.ubicacion(fallecido));
		ventana.getInFallecido().getTextField().setText(fallecido.getApellido());
		
	}

	@Override
	public void mostrar() {
		ventana.mostrar();
	}

}
