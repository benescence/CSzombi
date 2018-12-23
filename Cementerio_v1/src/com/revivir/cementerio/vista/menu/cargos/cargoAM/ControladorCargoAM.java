package com.revivir.cementerio.vista.menu.cargos.cargoAM;

import com.revivir.cementerio.negocios.Validador;
import com.revivir.cementerio.negocios.manager.CargoManager;
import com.revivir.cementerio.negocios.manager.FallecidoManager;
import com.revivir.cementerio.negocios.manager.ServicioManager;
import com.revivir.cementerio.persistencia.entidades.Cargo;
import com.revivir.cementerio.persistencia.entidades.Fallecido;
import com.revivir.cementerio.persistencia.entidades.Servicio;
import com.revivir.cementerio.vista.seleccion.fallecidos.ControladorSeleccionarFallecido;
import com.revivir.cementerio.vista.seleccion.fallecidos.FallecidoSeleccionable;
import com.revivir.cementerio.vista.seleccion.servicio.ControladorSeleccionarServicio;
import com.revivir.cementerio.vista.seleccion.servicio.ServicioSeleccionable;
import com.revivir.cementerio.vista.util.AccionCerrarVentana;
import com.revivir.cementerio.vista.util.Popup;

public class ControladorCargoAM implements ServicioSeleccionable, FallecidoSeleccionable {
	private VentanaCargoAM ventana;
	private CargoInvocable invocador;
	private Fallecido fallecido;
	private Servicio servicio;
	private Cargo cargo;
	
	public ControladorCargoAM(CargoInvocable invocador) {
		this.invocador = invocador;
		ventana = new VentanaCargoAM();
		inicializar();
	}
	
	public ControladorCargoAM(CargoInvocable invocador, Fallecido fallecido) {
		this.invocador = invocador;
		ventana = new VentanaCargoAM();
		seleccionarFallecido(fallecido);
		inicializar();
	}

	public ControladorCargoAM(CargoInvocable invocador, Cargo cargo) {
		this.invocador = invocador;
		this.cargo = cargo;
		this.servicio = ServicioManager.traerPorID(cargo.getServicio());
		this.fallecido = FallecidoManager.traerPorID(cargo.getFallecido());
		ventana = new VentanaCargoAM();
		seleccionarFallecido(fallecido);
		seleccionarServicio(servicio);
		ventana.getObservaciones().getTextField().setText(cargo.getObservaciones());
		inicializar();
	}

	private void inicializar() {
		ventana.addWindowListener(new AccionCerrarVentana(e -> cancelar()));

		ventana.botonAceptar().setAccion(e -> aceptar());
		ventana.botonCancelar().setAccion(e -> cancelar());
		
		ventana.botonSelServicio().setAccion(e -> seleccionarServicio());
		ventana.botonSelFallecido().setAccion(e -> seleccionarFallecido());
		
		ventana.botonCargarFallecido().setAccion(e -> cargarFallecido());
		ventana.botonCargarServicio().setAccion(e -> cargarServicio());
	} 
	
	private void cargarServicio() {
		ventana.requestFocusInWindow();
		
		String codigo = ventana.getCodigo().getTextField().getText();
		if (!Validador.codigo(codigo)) {
			Popup.mostrar("El CODIGO solo puede consistir de numeros");
			return;
		}
		
		Servicio directo = ServicioManager.traerActivoPorCodigo(codigo);
		if (directo == null) {
			Popup.mostrar("No hay registros de un servicio con el codigo: "+codigo+".");
			return;
		}
		
		seleccionarServicio(directo);
		ventana.getObservaciones().getTextField().requestFocusInWindow();
	}
	
	private void cargarFallecido() {
		ventana.requestFocusInWindow();
		
		String DNI = ventana.getDNI().getTextField().getText();
		if (!Validador.DNI(DNI)) {
			Popup.mostrar("El DNI solo puede consistir de numeros");
			return;
		}
		
		Fallecido directo = FallecidoManager.traerPorDNI(DNI);
		if (directo == null) {
			Popup.mostrar("No hay registros de un fallecidos con el DNI "+DNI+".");
			return;
		}
		
		seleccionarFallecido(directo);
		ventana.getCodigo().getTextField().requestFocusInWindow();
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
		ventana.requestFocusInWindow();
		
		try {
			if (servicio == null || fallecido == null) {
				Popup.mostrar("Debe seleccionar un servicio y un fallecido para poder crear un cargo.");
				return;
			}
			
			String observaciones = ventana.getObservaciones().getTextField().getText();
			Cargo nuevo = new Cargo(-1, fallecido.getID(), servicio.getID(), observaciones, false);
			
			// Estoy dando el alta
			if (cargo == null)
				CargoManager.guardar(nuevo);

			// Estoy modificando
			else
				CargoManager.modificar(nuevo, cargo);
			
			ventana.dispose();
			invocador.actualizarCargos();
			invocador.mostrar();
		} catch (Exception e) {
			Popup.mostrar(e.getMessage());
		}
	}
	
	private void cancelar() {
		if (Popup.confirmar("Se perderan los datos ingresados.\n¿Esta seguro de que desea cancelar la operacion?")) {
			ventana.dispose();
			invocador.mostrar();
		}
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
		ventana.getDNI().getTextField().setText(fallecido.getDNI());
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