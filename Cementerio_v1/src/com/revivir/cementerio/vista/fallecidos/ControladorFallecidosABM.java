package com.revivir.cementerio.vista.fallecidos;

import java.util.List;

import javax.swing.JInternalFrame;

import com.revivir.cementerio.negocios.manager.FallecidoManager;
import com.revivir.cementerio.persistencia.entidades.Fallecido;
import com.revivir.cementerio.vista.ControladorInterno;
import com.revivir.cementerio.vista.ControladorPrincipal;
import com.revivir.cementerio.vista.fallecidos.fallecidoAM.ControladorFallecidoAM;
import com.revivir.cementerio.vista.util.Popup;

public class ControladorFallecidosABM implements ControladorInterno {
	private VentanaFallecidosABM ventana;
	private ControladorPrincipal invocador;
	
	public ControladorFallecidosABM(ControladorPrincipal invocador) {
		this.invocador = invocador;
		ventana = new VentanaFallecidosABM();
		ventana.botonAgregar().addActionListener(e -> agregar());
		ventana.botonModificar().addActionListener(e -> modificar());
		ventana.botonEliminar().addActionListener(e -> eliminar());
	}

	private void modificar() {
		List<Fallecido> lista = ventana.getTabla().obtenerSeleccion();
		
		if (lista.size() != 1) {
			Popup.mostrar("Debe seleccionar exactamente 1 fallecido para modificarlo");
			return;
		}
		
		invocador.getVentana().setEnabled(false);
		new ControladorFallecidoAM(this, lista.get(0));
	}
	
	private void eliminar() {
		List<Fallecido> lista = ventana.getTabla().obtenerSeleccion();
		
		if (lista.isEmpty()) {
			Popup.mostrar("Debe seleccionar al menos un fallecido para eliminarlo");
			return;
		}
		
		if (Popup.confirmar("¿Esta seguro de que desea eliminar los registros seleccionados?"))
			for (Fallecido elemento : lista)
				FallecidoManager.eliminar(elemento);
		
		actualizar();
	}

	private void agregar() {
		invocador.getVentana().setEnabled(false);
		new ControladorFallecidoAM(this);
	}
	
	public void mostrar() {
		invocador.getVentana().setEnabled(true);
		invocador.getVentana().toFront();
	}
	
	public void actualizar() {
		ventana.getTabla().recargar(FallecidoManager.traerTodo());
	}
	
	@Override
	public boolean finalizar() {
		return true;
	}
	
	@Override
	public JInternalFrame getVentana() {		
		return ventana;
	}

}