package com.revivir.cementerio.vista.cargos;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.revivir.cementerio.negocios.Vinculador;
import com.revivir.cementerio.persistencia.entidades.Cliente;
import com.revivir.cementerio.persistencia.entidades.Fallecido;
import com.revivir.cementerio.vista.ControladorPrincipal;
import com.revivir.cementerio.vista.seleccion.clientes.ClienteSeleccionable;
import com.revivir.cementerio.vista.seleccion.clientes.ControladorSeleccionCliente;
import com.revivir.cementerio.vista.seleccion.fallecidos.ControladorSeleccionarFallecido;
import com.revivir.cementerio.vista.seleccion.fallecidos.FallecidoSeleccionable;
import com.revivir.cementerio.vista.util.Popup;

public class ControladorCargoAM implements ClienteSeleccionable, FallecidoSeleccionable {
	private VentanaCargoAM ventana;
	private ControladorPrincipal principal;
	private Fallecido fallecido;
	
	public ControladorCargoAM(ControladorPrincipal invocador) {
		this.principal = invocador;
		ventana = new VentanaCargoAM();
		inicializar();
	}
	
	private void inicializar() {
		ventana.botonFallecido().addActionListener(e -> seleccionarFallecido());
		//ventana.botonAceptar().addActionListener(e -> aceptar());
		//ventana.botonCancelar().addActionListener(e -> cancelar());
		//ventana.botonSeleccionarCliente().addActionListener(e -> seleccionarCliente());
		ventana.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				cancelar();
			}
		});
	} 
	
	private void seleccionarCliente() {
		ventana.setEnabled(false);
		new ControladorSeleccionCliente(this);
	}

	private void seleccionarFallecido() {
		ventana.setEnabled(false);
		new ControladorSeleccionarFallecido(this);
	}
	
	private void aceptar() {
		/*Cliente cliente = ventana.getCliente();
		Fallecido fallecido = ventana.getFallecido();
		
		if (cliente == null || fallecido == null) {
			Popup.mostrar("Debe seleccionar un cliente y un fallecido para poder vincularlos.");
			return;
		}
		
		Vinculador.vincular(cliente, fallecido);
		volver();*/
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
	public void setCliente(Cliente cliente) {
		/*ventana.setCliente(cliente);
		ventana.getNombreCliente().getTextField().setText(cliente.getNombre());
		ventana.getApellidoCliente().getTextField().setText(cliente.getApellido());
		ventana.getDNICliente().getTextField().setText(cliente.getDni());*/
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
	
}