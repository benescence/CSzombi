package com.revivir.cementerio.vista.menu.pagos;

import java.util.List;

import javax.swing.JInternalFrame;

import com.revivir.cementerio.negocios.manager.PagoManager;
import com.revivir.cementerio.persistencia.entidades.Pago;
import com.revivir.cementerio.vista.ControladorInterno;
import com.revivir.cementerio.vista.ControladorPrincipal;
import com.revivir.cementerio.vista.menu.pagos.pagoAM.ControladorPagoAM;
import com.revivir.cementerio.vista.menu.pagos.pagoAM.PagoInvocable;
import com.revivir.cementerio.vista.util.Popup;

public class ControladorPagoABM implements ControladorInterno, PagoInvocable {
	private VentanaPagoABM ventana;
	private ControladorPrincipal invocador;
	
	public ControladorPagoABM(ControladorPrincipal invocador) {
		this.invocador = invocador;
		ventana = new VentanaPagoABM();
		ventana.botonAgregar().addActionListener(e -> agregar());
		ventana.botonModificar().addActionListener(e -> modificar());
		ventana.botonEliminar().addActionListener(e -> eliminar());
	}
	
	private void agregar() {
		invocador.getVentana().setEnabled(false);
		new ControladorPagoAM(this);
	}

	private void modificar() {
		List<Pago> lista = ventana.getTabla().obtenerSeleccion();
		
		if (lista.size() != 1) {
			Popup.mostrar("Debe seleccionar exactamente 1 pago para modificarlo");
			return;
		}
		
		invocador.getVentana().setEnabled(false);
		new ControladorPagoAM(this, lista.get(0));
	}
	
	private void eliminar() {
		List<Pago> lista = ventana.getTabla().obtenerSeleccion();
		
		if (lista.isEmpty()) {
			Popup.mostrar("Debe seleccionar al menos un pago para eliminarlo");
			return;
		}
		
		if (Popup.confirmar("¿Esta seguro de que desea eliminar los registros seleccionados?"))
			for (Pago elemento : lista)
				PagoManager.eliminar(elemento);
		
		actualizarPagos();
	}

	@Override
	public boolean finalizar() {
		return true;
	}
	
	public void mostrar() {
		invocador.getVentana().mostrar();
		invocador.getVentana().toFront();
	}

	@Override
	public JInternalFrame getVentana() {		
		return ventana;
	}

	@Override
	public void actualizarPagos() {
		ventana.getTabla().recargar(PagoManager.traerTodo());
	}

}