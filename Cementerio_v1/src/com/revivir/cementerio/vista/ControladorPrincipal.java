package com.revivir.cementerio.vista;

import com.revivir.cementerio.vista.menu.cargos.ControladorCargoABM;
import com.revivir.cementerio.vista.menu.cargos.cargoAM.CargoInvocable;
import com.revivir.cementerio.vista.menu.cargos.cargoAM.ControladorCargoAM;
import com.revivir.cementerio.vista.menu.clientes.ControladorClientesABM;
import com.revivir.cementerio.vista.menu.clientes.clienteAM.ClienteInvocable;
import com.revivir.cementerio.vista.menu.clientes.clienteAM.ControladorClientesAM;
import com.revivir.cementerio.vista.menu.fallecidos.ControladorFallecidosABM;
import com.revivir.cementerio.vista.menu.fallecidos.fallecidoAM.ControladorFallecidoAM;
import com.revivir.cementerio.vista.menu.fallecidos.fallecidoAM.FallecidoInvocable;
import com.revivir.cementerio.vista.menu.movimientos.ControladorMovimiento;
import com.revivir.cementerio.vista.menu.movimientos.ControladorTranslado;
import com.revivir.cementerio.vista.menu.movimientos.translado.MovimientoInvocable;
import com.revivir.cementerio.vista.menu.pagos.ControladorPagoABM;
import com.revivir.cementerio.vista.menu.pagos.pagoAM.ControladorPagoAM;
import com.revivir.cementerio.vista.menu.pagos.pagoAM.PagoInvocable;
import com.revivir.cementerio.vista.menu.principal.ControladorAltaCompleta;
import com.revivir.cementerio.vista.menu.responsables.ControladorVincular;
import com.revivir.cementerio.vista.menu.servicios.ControladorServiciosABM;
import com.revivir.cementerio.vista.menu.servicios.servicioAM.ControladorServicioAM;
import com.revivir.cementerio.vista.menu.servicios.servicioAM.ServicioInvocable;
import com.revivir.cementerio.vista.menu.usuarios.ControladorUsuariosABM;
import com.revivir.cementerio.vista.menu.usuarios.usuarioAM.ControladorUsuarioAM;
import com.revivir.cementerio.vista.menu.usuarios.usuarioAM.UsuarioInvocable;
import com.revivir.cementerio.vista.util.AccionCerrarVentana;
import com.revivir.cementerio.vista.util.Popup;
import com.revivir.cementerio.vista.util.contenedores.PanelVertical;

public class ControladorPrincipal implements ClienteInvocable, ServicioInvocable, UsuarioInvocable ,
		CargoInvocable,MovimientoInvocable, FallecidoInvocable, PagoInvocable {
	private VentanaPrincipal ventana;
	private ControladorInterno controladorInterno;
	
	public ControladorPrincipal() {
		ventana = new VentanaPrincipal();
		ventana.addWindowListener(new AccionCerrarVentana(e -> cerrarAplicacion()));
		
		// ALTA DIRECTA
		ventana.getClienteAlta().addActionListener(e -> colocarVentanaExterna(new ControladorClientesAM(this)));
		ventana.getFallecidoAlta().addActionListener(e -> colocarVentanaExterna(new ControladorFallecidoAM(this)));
		ventana.getServicioAlta().addActionListener(e -> colocarVentanaExterna(new ControladorServicioAM(this)));
		ventana.getUsuarioAlta().addActionListener(e -> colocarVentanaExterna(new ControladorUsuarioAM(this)));
		ventana.getCargoAlta().addActionListener(e -> colocarVentanaExterna(new ControladorCargoAM(this)));
		ventana.getPagoAlta().addActionListener(e -> colocarVentanaExterna(new ControladorPagoAM(this)));
		
		ventana.getResponsableVincular().addActionListener(e -> vincular());
		ventana.getMovimientoTrasladar().addActionListener(e -> transladar());
	
		
		
		// CONSULTAS
		ventana.getClienteConsulta().addActionListener(e -> colocarVentanaInterna(new ControladorClientesABM(this)));
		ventana.getFallecidoConsulta().addActionListener(e -> colocarVentanaInterna(new ControladorFallecidosABM(this)));
		ventana.getServicioConsulta().addActionListener(e -> colocarVentanaInterna(new ControladorServiciosABM(this)));
		ventana.getUsuarioConsulta().addActionListener(e -> colocarVentanaInterna(new ControladorUsuariosABM(this)));
		ventana.getCargoConsultar().addActionListener(e -> colocarVentanaInterna(new ControladorCargoABM(this)));
		ventana.getPagoConsultar().addActionListener(e -> colocarVentanaInterna(new ControladorPagoABM(this)));
		
		
		ventana.getMovimientoConsultar().addActionListener(e -> colocarVentanaInterna(new ControladorMovimiento(this)));
		ventana.getPrincipalAlta().addActionListener(e -> colocarVentanaInterna(new ControladorAltaCompleta(this)));
		ventana.getPrincipalAlta().addActionListener(e -> colocarVentanaInterna(new ControladorAltaCompleta(this)));
	}

	private void colocarVentanaExterna(ControladorExterno controlador) {
		ventana.deshabilitar();
	}
	
	private void colocarVentanaInterna(ControladorInterno controlador) {
		if (controladorInterno == null || controladorInterno.finalizar()) {
	        controladorInterno = controlador;
	        PanelVertical panel = new PanelVertical();
	        panel.add(controladorInterno.getVentana());
			ventana.setContentPane(panel);
		}
	}

	private void vincular() {
		ventana.deshabilitar();
		new ControladorVincular(this);
	}
	private void transladar() {
		ventana.deshabilitar();
		new ControladorTranslado(this);
	}

	private void cerrarAplicacion() {
		if (Popup.confirmar("¿Está seguro de que desea cerrar la aplicación?")) {
			ventana.dispose();
			ventana = null;
		}
	}
	
	public VentanaPrincipal getVentana() {
		return ventana;
	}
	
	public ControladorInterno getControladorInterno() {
		return controladorInterno;
	}

	@Override
	public void mostrar() {
		ventana.mostrar();
	}

	@Override
	public void actualizarClientes() {
		if (controladorInterno instanceof ClienteInvocable)
			((ClienteInvocable)controladorInterno).actualizarClientes();
	}

	@Override
	public void actualizarUsuarios() {
		if (controladorInterno instanceof UsuarioInvocable)
			((UsuarioInvocable)controladorInterno).actualizarUsuarios();
	}

	@Override
	public void actualizarServicios() {
		if (controladorInterno instanceof ServicioInvocable)
			((ServicioInvocable)controladorInterno).actualizarServicios();
	}

	@Override
	public void actualizarMovimientos() {
		if (controladorInterno instanceof MovimientoInvocable)
			((MovimientoInvocable)controladorInterno).actualizarMovimientos();
	}

	@Override
	public void actualizarCargos() {
		if (controladorInterno instanceof CargoInvocable)
			((CargoInvocable)controladorInterno).actualizarCargos();
	}

	@Override
	public void actualizarFallecidos() {
		if (controladorInterno instanceof FallecidoInvocable)
			((FallecidoInvocable)controladorInterno).actualizarFallecidos();
	}	

	@Override
	public void actualizarPagos() {
		if (controladorInterno instanceof PagoInvocable)
			((PagoInvocable)controladorInterno).actualizarPagos();
	}	

}