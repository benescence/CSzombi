package com.revivir.cementerio.vista.responsables.porcliente;

import javax.swing.JInternalFrame;

import com.revivir.cementerio.negocios.Vinculador;
import com.revivir.cementerio.persistencia.entidades.Cliente;
import com.revivir.cementerio.vista.ControladorInterno;
import com.revivir.cementerio.vista.ControladorPrincipal;
import com.revivir.cementerio.vista.seleccion.clientes.ClienteSeleccionable;
import com.revivir.cementerio.vista.seleccion.clientes.ControladorSeleccionCliente;

public class ControladorConsultarPorCliente implements ControladorInterno, ClienteSeleccionable {
	private VentanaConsultarPorCliente ventana;
	private ControladorPrincipal invocador;
	
	public ControladorConsultarPorCliente(ControladorPrincipal invocador) {
		this.invocador = invocador;
		ventana = new VentanaConsultarPorCliente();
		ventana.botonSeleccionar().addActionListener(e -> seleccionar());
	}
	
	private void seleccionar() {
		invocador.getVentana().setEnabled(false);
		new ControladorSeleccionCliente(this);
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

	@Override
	public void setCliente(Cliente cliente) {
		ventana.getNombre().getTextField().setText(cliente.getNombre());
		ventana.getApellido().getTextField().setText(cliente.getApellido());
		ventana.getDNI().getTextField().setText(cliente.getDni());
		ventana.getTelefono().getTextField().setText(cliente.getTelefono());
		ventana.getEmail().getTextField().setText(cliente.getEmail());
		ventana.getTabla().recargar(Vinculador.traerFallecidosDeCliente(cliente));
	}

}