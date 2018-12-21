package com.revivir.cementerio.vista.menu.clientes;

import java.util.List;

import javax.swing.JInternalFrame;

import com.revivir.cementerio.negocios.manager.ClienteManager;
import com.revivir.cementerio.persistencia.entidades.Cliente;
import com.revivir.cementerio.vista.ControladorInterno;
import com.revivir.cementerio.vista.ControladorPrincipal;
import com.revivir.cementerio.vista.menu.clientes.clienteAM.ClienteInvocable;
import com.revivir.cementerio.vista.menu.clientes.clienteAM.ControladorClientesAM;
import com.revivir.cementerio.vista.util.Popup;

public class ControladorClientesABM implements ControladorInterno, ClienteInvocable {
	private VentanaClientesABM ventana;
	private ControladorPrincipal invocador;
	
	public ControladorClientesABM(ControladorPrincipal invocador) {
		this.invocador = invocador;
		ventana = new VentanaClientesABM();
		ventana.botonAgregar().addActionListener(e -> agregar());
		ventana.botonModificar().addActionListener(e -> modificar());
		ventana.botonEliminar().addActionListener(e -> eliminar());
	}
	
	private void agregar() {
		invocador.getVentana().setEnabled(false);
		new ControladorClientesAM(this);
	}

	private void modificar() {
		List<Cliente> lista = ventana.getTabla().obtenerSeleccion();
		
		if (lista.size() != 1) {
			Popup.mostrar("Debe seleccionar exactamente 1 cliente para modificarlo");
			return;
		}
		
		invocador.getVentana().setEnabled(false);
		new ControladorClientesAM(this, lista.get(0));
	}
	
	private void eliminar() {
		List<Cliente> lista = ventana.getTabla().obtenerSeleccion();
		
		if (lista.isEmpty()) {
			Popup.mostrar("Debe seleccionar al menos un cliente para eliminarlo");
			return;
		}
		
		if (Popup.confirmar("�Esta seguro de que desea eliminar los registros seleccionados?"))
			for (Cliente elemento : lista)
				ClienteManager.eliminar(elemento);
		
		actualizar();
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

	public void actualizar() {
		ventana.getTabla().recargar(ClienteManager.traerTodo());
	}

	@Override
	public void actualizarClientes() {
		actualizar();
	}

}