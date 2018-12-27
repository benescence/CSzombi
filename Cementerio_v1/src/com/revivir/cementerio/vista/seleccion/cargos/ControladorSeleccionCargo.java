package com.revivir.cementerio.vista.seleccion.cargos;

import java.util.ArrayList;
import java.util.List;

import com.revivir.cementerio.negocios.Validador;
import com.revivir.cementerio.negocios.manager.CargoManager;
import com.revivir.cementerio.negocios.manager.ClienteManager;
import com.revivir.cementerio.negocios.manager.FallecidoManager;
import com.revivir.cementerio.persistencia.entidades.Cargo;
import com.revivir.cementerio.persistencia.entidades.Cliente;
import com.revivir.cementerio.persistencia.entidades.Fallecido;
import com.revivir.cementerio.vista.seleccion.clientes.ClienteSeleccionable;
import com.revivir.cementerio.vista.seleccion.clientes.ControladorSeleccionCliente;
import com.revivir.cementerio.vista.seleccion.fallecidos.ControladorSeleccionarFallecido;
import com.revivir.cementerio.vista.seleccion.fallecidos.FallecidoSeleccionable;
import com.revivir.cementerio.vista.util.AccionCerrarVentana;
import com.revivir.cementerio.vista.util.Popup;

public class ControladorSeleccionCargo implements FallecidoSeleccionable, ClienteSeleccionable {
	private VentanaSeleccionCargo ventana;
	private CargoSeleccionable invocador;
	private Fallecido fallecido;
	private Cliente cliente;

	public ControladorSeleccionCargo(CargoSeleccionable invocador) {
		this.invocador = invocador;
		ventana = new VentanaSeleccionCargo();
		ventana.addWindowListener(new AccionCerrarVentana(e -> cancelar()));

		ventana.botonSeleccionar().setAccion(e -> seleccionar());
		ventana.botonCancelar().setAccion(e -> cancelar());
		ventana.botonLimpiar().setAccion(e -> limpiar());
		
		ventana.botonSelFallecido().setAccion(e -> seleccionarFallecido());
		ventana.botonCargarFallecido().setAccion(e -> cargarFallecido());
		
		ventana.botonSelCliente().setAccion(e -> seleccionarCliente());
		ventana.botonCargarCliente().setAccion(e -> cargarCliente());
		
	}

	private void seleccionarFallecido() {
		ventana.deshabilitar();
		new ControladorSeleccionarFallecido(this);
	}
	
	private void seleccionarCliente() {
		ventana.deshabilitar();
		new ControladorSeleccionCliente(this);
	}
	
	private void cargarCliente() {
		ventana.requestFocusInWindow();
		
		String DNI = ventana.getDNICli().getTextField().getText();
		if (!Validador.DNI(DNI)) {
			Popup.mostrar("El DNI solo puede consistir de numeros");
			return;
		}
		
		Cliente directo = ClienteManager.traerPorDNI(DNI);
		if (directo == null) {
			Popup.mostrar("No hay registros de un cliente con el DNI: "+DNI+".");
			return;
		}
		
		seleccionarCliente(directo);
		ventana.getDNIFal().getTextField().requestFocusInWindow();
	}

	private void cargarFallecido() {
		ventana.requestFocusInWindow();
		
		String DNI = ventana.getDNIFal().getTextField().getText();
		if (!Validador.DNI(DNI)) {
			Popup.mostrar("El DNI solo puede consistir de numeros");
			return;
		}
		
		Fallecido directo = FallecidoManager.traerPorDNI(DNI);
		if (directo == null) {
			Popup.mostrar("No hay registros de un fallecido con el DNI: "+DNI+".");
			return;
		}
		
		seleccionarFallecido(directo);
		ventana.getDNICli().getTextField().requestFocusInWindow();
	}
	
	private void limpiar() {
		fallecido = null;
		ventana.getNombreFal().getTextField().setText("");
		ventana.getApellidoFal().getTextField().setText("");
		ventana.getDNIFal().getTextField().setText("");
		
		cliente = null;
		ventana.getNombreCli().getTextField().setText("");
		ventana.getApellidoCli().getTextField().setText("");
		ventana.getDNICli().getTextField().setText("");
		ventana.getTabla().recargar(new ArrayList<>());
	}
	
	private void seleccionar() {
		List<Cargo> seleccion = ventana.getTabla().obtenerSeleccion();
		if (seleccion.size() != 1)
			Popup.mostrar("Debe seleccionar exactamente un cargo");
		else {
			invocador.seleccionarCargo(seleccion.get(0));
			ventana.dispose();
			invocador.mostrar();
		}
	}
		
	private void cancelar() {
		ventana.dispose();
		invocador.mostrar();
	}
	
	public void actualizarCargos() {
		if (cliente != null || fallecido != null) {
			List<Cargo> lista = CargoManager.traerPorFallecidoCliente(fallecido, cliente);
			ventana.getTabla().recargar(lista);
		}		
	}

	@Override
	public void seleccionarFallecido(Fallecido fallecido) {
		this.fallecido = fallecido;
		ventana.getNombreFal().getTextField().setText(fallecido.getNombre());
		ventana.getApellidoFal().getTextField().setText(fallecido.getApellido());
		ventana.getDNIFal().getTextField().setText(fallecido.getDNI());
		actualizarCargos();
	}

	@Override
	public void seleccionarCliente(Cliente cliente) {
		this.cliente = cliente;
		ventana.getNombreCli().getTextField().setText(cliente.getNombre());
		ventana.getApellidoCli().getTextField().setText(cliente.getApellido());
		ventana.getDNICli().getTextField().setText(cliente.getDNI());
		actualizarCargos();
	}

	@Override
	public void mostrar() {
		ventana.mostrar();
	}
	
}