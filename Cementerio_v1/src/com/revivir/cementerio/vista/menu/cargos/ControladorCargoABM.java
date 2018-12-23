package com.revivir.cementerio.vista.menu.cargos;

import java.util.List;

import javax.swing.JInternalFrame;

import com.revivir.cementerio.negocios.manager.CargoManager;
import com.revivir.cementerio.persistencia.entidades.Cargo;
import com.revivir.cementerio.persistencia.entidades.Cliente;
import com.revivir.cementerio.persistencia.entidades.Fallecido;
import com.revivir.cementerio.vista.ControladorInterno;
import com.revivir.cementerio.vista.ControladorPrincipal;
import com.revivir.cementerio.vista.menu.cargos.cargoAM.ControladorCargoAM;
import com.revivir.cementerio.vista.seleccion.clientes.ClienteSeleccionable;
import com.revivir.cementerio.vista.seleccion.clientes.ControladorSeleccionCliente;
import com.revivir.cementerio.vista.seleccion.fallecidos.ControladorSeleccionarFallecido;
import com.revivir.cementerio.vista.seleccion.fallecidos.FallecidoSeleccionable;
import com.revivir.cementerio.vista.util.Popup;

public class ControladorCargoABM implements ControladorInterno, FallecidoSeleccionable, ClienteSeleccionable {
	private VentanaCargoABM ventana;
	private ControladorPrincipal invocador;
	private Fallecido fallecido;
	private Cliente cliente;
	
	public ControladorCargoABM(ControladorPrincipal invocador) {
		this.invocador = invocador;
		ventana = new VentanaCargoABM();
		ventana.botonAgregar().addActionListener(e -> agregar());
		ventana.botonModificar().addActionListener(e -> modificar());
		ventana.botonEliminar().addActionListener(e -> eliminar());
		
		ventana.botonSelFallecido().setAccion(e -> seleccionarFallecido());
		ventana.botonSelCliente().setAccion(e -> seleccionarCliente());
	}
	
	private void seleccionarFallecido() {
		ventana.deshabilitar();
		new ControladorSeleccionarFallecido(this);
	}

	private void seleccionarCliente() {
		ventana.deshabilitar();
		new ControladorSeleccionCliente(this);
	}

	private void agregar() {
		//invocador.getVentana().setEnabled(false);
		//if (fallecido == null)
	//		new ControladorCargoAM(invocador);
		//else
			//new ControladorCargoAM(this, fallecido);
	}

	private void modificar() {
		/*List<Cargo> lista = ventana.getTabla().obtenerSeleccion();
		
		if (lista.size() != 1) {
			Popup.mostrar("Debe seleccionar exactamente 1 cargo para modificarlo");
			return;
		}
		
		invocador.getVentana().setEnabled(false);*/
		//new ControladorCargoAM(this, lista.get(0));
	}
	
	private void eliminar() {/*
		List<Cargo> lista = ventana.getTabla().obtenerSeleccion();
		
		if (lista.isEmpty()) {
			Popup.mostrar("Debe seleccionar al menos un cargo para eliminarlo");
			return;
		}
		
		if (Popup.confirmar("¿Esta seguro de que desea eliminar los registros seleccionados?"))
			for (Cargo elemento : lista)
				CargoManager.eliminar(elemento);
		
		actualizar();*/
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
		List<Cargo> lista = CargoManager.traerPorFallecidoCliente(fallecido, cliente);
		ventana.getTabla().recargar(lista);
	}

	@Override
	public void seleccionarFallecido(Fallecido fallecido) {
		this.fallecido = fallecido;
		ventana.getNombreFal().getTextField().setText(fallecido.getNombre());
		ventana.getApellidoFal().getTextField().setText(fallecido.getApellido());
		ventana.getDNIFal().getTextField().setText(fallecido.getDni());
		actualizar();
	}

	@Override
	public void seleccionarCliente(Cliente cliente) {
		this.cliente = cliente;
		ventana.getNombreCli().getTextField().setText(cliente.getNombre());
		ventana.getApellidoCli().getTextField().setText(cliente.getApellido());
		ventana.getDNICli().getTextField().setText(cliente.getDNI());
		actualizar();
	}

}