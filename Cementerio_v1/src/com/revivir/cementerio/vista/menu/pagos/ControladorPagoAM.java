package com.revivir.cementerio.vista.menu.pagos;

import com.revivir.cementerio.negocios.Validador;
import com.revivir.cementerio.negocios.manager.CargoManager;
import com.revivir.cementerio.negocios.manager.ClienteManager;
import com.revivir.cementerio.negocios.manager.FallecidoManager;
import com.revivir.cementerio.negocios.manager.ServicioManager;
import com.revivir.cementerio.persistencia.entidades.Cargo;
import com.revivir.cementerio.persistencia.entidades.Cliente;
import com.revivir.cementerio.persistencia.entidades.Fallecido;
import com.revivir.cementerio.persistencia.entidades.Servicio;
import com.revivir.cementerio.vista.ControladorExterno;
import com.revivir.cementerio.vista.seleccion.cargos.CargoSeleccionable;
import com.revivir.cementerio.vista.seleccion.cargos.ControladorSeleccionCargo;
import com.revivir.cementerio.vista.seleccion.clientes.ClienteSeleccionable;
import com.revivir.cementerio.vista.seleccion.clientes.ControladorSeleccionCliente;
import com.revivir.cementerio.vista.seleccion.fallecidos.ControladorSeleccionarFallecido;
import com.revivir.cementerio.vista.seleccion.fallecidos.FallecidoSeleccionable;
import com.revivir.cementerio.vista.seleccion.servicio.ControladorSeleccionarServicio;
import com.revivir.cementerio.vista.seleccion.servicio.ServicioSeleccionable;
import com.revivir.cementerio.vista.util.AccionCerrarVentana;
import com.revivir.cementerio.vista.util.Popup;

public class ControladorPagoAM implements ControladorExterno, ClienteSeleccionable, CargoSeleccionable {
	private VentanaPagoAM ventana;
	private PagoInvocable invocador;
	private Cargo cargo;
	private Cliente cliente;
	
	public ControladorPagoAM(PagoInvocable invocador) {
		this.invocador = invocador;
		ventana = new VentanaPagoAM();
		inicializar();
	}

	private void inicializar() {
		ventana.addWindowListener(new AccionCerrarVentana(e -> cancelar()));

		ventana.botonAceptar().setAccion(e -> aceptar());
		ventana.botonCancelar().setAccion(e -> cancelar());
		ventana.botonSelCliente().setAccion(e -> seleccionarCliente());
		ventana.botonCargarCliente().setAccion(e -> cargarCliente());
		ventana.botonSelCargo().setAccion(e -> seleccionarCargo());
		
		//ventana.botonCargarServicio().setAccion(e -> cargarServicio());
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
		
		//seleccionarServicio(directo);
		ventana.getObservaciones().getTextField().requestFocusInWindow();
	}
	
	private void cargarCliente() {
		ventana.requestFocusInWindow();
		
		String DNI = ventana.getDNICli().getTextField().getText();
		if (!Validador.DNI(DNI)) {
			Popup.mostrar("El DNI solo puede consistir de numeros.");
			return;
		}
		
		Cliente directo = ClienteManager.traerPorDNI(DNI);
		if (directo == null) {
			Popup.mostrar("No hay registros de un cliente con el DNI "+DNI+".");
			return;
		}
		
		seleccionarCliente(directo);
		//ventana.getCodigo().getTextField().requestFocusInWindow();
	}
	
	private void seleccionarCargo() {
		ventana.setEnabled(false);
		new ControladorSeleccionCargo(this);
	}

	private void seleccionarCliente() {
		ventana.setEnabled(false);
		new ControladorSeleccionCliente(this);
	}
	
	private void aceptar() {
		ventana.requestFocusInWindow();
		/*
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
		}*/
	}
	
	private void cancelar() {
		if (Popup.confirmar("Se perderan los datos ingresados.\n¿Esta seguro de que desea cancelar la operacion?")) {
			ventana.dispose();
			invocador.mostrar();
		}
	}
/*
	@Override
	public void seleccionarServicio(Servicio servicio) {
		this.servicio = servicio;
		ventana.getCodigo().getTextField().setText(servicio.getCodigo());
		ventana.getNombreServicio().getTextField().setText(servicio.getNombre());
		ventana.getDescripcion().getTextField().setText(servicio.getDescripcion());
		ventana.getImporte().getTextField().setText(servicio.getImporte().toString());
	}
*/

	@Override
	public void seleccionarCliente(Cliente cliente) {
		this.cliente = cliente;
		ventana.getNombreCli().getTextField().setText(cliente.getNombre());
		ventana.getApellidoCli().getTextField().setText(cliente.getApellido());
		ventana.getDNICli().getTextField().setText(cliente.getDNI());
	}

	@Override
	public void mostrar() {
		ventana.mostrar();
	}

	@Override
	public void seleccionarCargo(Cargo cargo) {
		// TODO Auto-generated method stub
		
	}	

}