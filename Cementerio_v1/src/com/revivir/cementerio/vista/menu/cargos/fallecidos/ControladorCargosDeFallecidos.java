package com.revivir.cementerio.vista.menu.cargos.fallecidos;

import java.util.List;

import javax.swing.JInternalFrame;

import com.revivir.cementerio.negocios.manager.CargoManager;
import com.revivir.cementerio.persistencia.entidades.Cargo;
import com.revivir.cementerio.persistencia.entidades.Fallecido;
import com.revivir.cementerio.vista.ControladorInterno;
import com.revivir.cementerio.vista.ControladorPrincipal;
import com.revivir.cementerio.vista.menu.cargos.cargoAM.ControladorCargoAM;
import com.revivir.cementerio.vista.seleccion.fallecidos.ControladorSeleccionarFallecido;
import com.revivir.cementerio.vista.seleccion.fallecidos.FallecidoSeleccionable;
import com.revivir.cementerio.vista.util.Popup;

public class ControladorCargosDeFallecidos implements ControladorInterno, FallecidoSeleccionable {
	private VentanaCargosDeFallecidos ventana;
	private ControladorPrincipal invocador;
	private Fallecido fallecido;
	
	public ControladorCargosDeFallecidos(ControladorPrincipal invocador) {
		this.invocador = invocador;
		ventana = new VentanaCargosDeFallecidos();
		ventana.botonSeleccionar().addActionListener(e -> seleccionar());
		ventana.botonAgregar().addActionListener(e -> agregar());
		ventana.botonModificar().addActionListener(e -> modificar());
		ventana.botonEliminar().addActionListener(e -> eliminar());
	}
	
	private void seleccionar() {
		ventana.deshabilitar();
		new ControladorSeleccionarFallecido(this);
	}

	private void agregar() {
		//invocador.getVentana().setEnabled(false);
		//if (fallecido == null)
	//		new ControladorCargoAM(invocador);
		//else
			//new ControladorCargoAM(this, fallecido);
	}

	private void modificar() {
		List<Cargo> lista = ventana.getTabla().obtenerSeleccion();
		
		if (lista.size() != 1) {
			Popup.mostrar("Debe seleccionar exactamente 1 cargo para modificarlo");
			return;
		}
		
		invocador.getVentana().setEnabled(false);
		//new ControladorCargoAM(this, lista.get(0));
	}
	
	private void eliminar() {
		List<Cargo> lista = ventana.getTabla().obtenerSeleccion();
		
		if (lista.isEmpty()) {
			Popup.mostrar("Debe seleccionar al menos un cargo para eliminarlo");
			return;
		}
		
		if (Popup.confirmar("¿Esta seguro de que desea eliminar los registros seleccionados?"))
			for (Cargo elemento : lista)
				CargoManager.eliminar(elemento);
		
		actualizar();
	}

	@Override
	public boolean finalizar() {
		return true;
	}
	
	public void mostrar() {
		invocador.getVentana().setEnabled(true);
		invocador.getVentana().toFront();
	}

	@Override
	public JInternalFrame getVentana() {		
		return ventana;
	}

	public void actualizar() {
		if (fallecido != null)
			ventana.getTabla().recargar(CargoManager.traerPorFallecido(fallecido));
	}

	@Override
	public void seleccionarFallecido(Fallecido fallecido) {
		this.fallecido = fallecido;
		ventana.getNombre().getTextField().setText(fallecido.getNombre());
		ventana.getApellido().getTextField().setText(fallecido.getApellido());
		ventana.getDNI().getTextField().setText(fallecido.getDni());
		ventana.getTabla().recargar(CargoManager.traerPorFallecido(fallecido));
	}

}