package com.revivir.cementerio.vista;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.revivir.cementerio.vista.menu.cargos.ControladorCargoABM;
import com.revivir.cementerio.vista.menu.cargos.cargoAM.CargoInvocable;
import com.revivir.cementerio.vista.menu.cargos.cargoAM.ControladorCargoAM;
import com.revivir.cementerio.vista.menu.clientes.ControladorClientesABM;
import com.revivir.cementerio.vista.menu.clientes.clienteAM.ClienteInvocable;
import com.revivir.cementerio.vista.menu.clientes.clienteAM.ControladorClientesAM;
import com.revivir.cementerio.vista.menu.fallecidos.ControladorFallecidosABM;
import com.revivir.cementerio.vista.menu.fallecidos.fallecidoAM.ControladorFallecidoAM;
import com.revivir.cementerio.vista.menu.principal.ControladorAltaCompleta;
import com.revivir.cementerio.vista.menu.responsables.ControladorVincular;
import com.revivir.cementerio.vista.menu.responsables.porcliente.ControladorConsultarPorCliente;
import com.revivir.cementerio.vista.menu.servicios.ControladorServiciosABM;
import com.revivir.cementerio.vista.menu.servicios.servicioAM.ControladorServicioAM;
import com.revivir.cementerio.vista.menu.servicios.servicioAM.ServicioInvocable;
import com.revivir.cementerio.vista.menu.usuarios.ControladorUsuariosABM;
import com.revivir.cementerio.vista.menu.usuarios.usuarioAM.ControladorUsuarioAM;
import com.revivir.cementerio.vista.menu.usuarios.usuarioAM.UsuarioInvocable;
import com.revivir.cementerio.vista.util.Popup;
import com.revivir.cementerio.vista.util.contenedores.PanelVertical;

public class ControladorPrincipal implements ClienteInvocable, ServicioInvocable, UsuarioInvocable, CargoInvocable {
	private VentanaPrincipal ventana;
	private ControladorInterno controladorInterno;
	
	public ControladorPrincipal() {
		ventana = new VentanaPrincipal();
		ventana.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				cerrarAplicacion();
			}
		});
		
		// Acciones para las opciones de menu
		ventana.getClienteConsulta().addActionListener(e -> colocarVentanaInterna(new ControladorClientesABM(this)));
		ventana.getFallecidoConsulta().addActionListener(e -> colocarVentanaInterna(new ControladorFallecidosABM(this)));
		ventana.getServicioConsulta().addActionListener(e -> colocarVentanaInterna(new ControladorServiciosABM(this)));
		ventana.getUsuarioConsulta().addActionListener(e -> colocarVentanaInterna(new ControladorUsuariosABM(this)));
		ventana.getPrincipalAlta().addActionListener(e -> colocarVentanaInterna(new ControladorAltaCompleta(this)));
		
		ventana.getResponsableConsultarPorCliente().addActionListener(e -> colocarVentanaInterna(new ControladorConsultarPorCliente(this)));
		ventana.getCobranzaCargosFallecido().addActionListener(e -> colocarVentanaInterna(new ControladorCargoABM(this)));
		
		// Accesos directos
		ventana.getClienteAlta().addActionListener(e -> altaClientes());
		ventana.getFallecidoAlta().addActionListener(e -> altaFallecidos());
		ventana.getServicioAlta().addActionListener(e -> altaServicios());
		ventana.getUsuarioAlta().addActionListener(e -> altaUsuarios());
		ventana.getResponsableVincular().addActionListener(e -> vincular());
		ventana.getCobranzaAltaCargo().addActionListener(e -> altaCargo());
		
		

	}
	
	private void vincular() {
		ventana.deshabilitar();
		new ControladorVincular(this);
	}

	private void altaServicios() {
		ventana.deshabilitar();
		new ControladorServicioAM(this);
	}

	private void altaUsuarios() {
		ventana.deshabilitar();
		new ControladorUsuarioAM(this);
	}

	private void altaCargo() {
		ventana.deshabilitar();
		new ControladorCargoAM(this);
	}
	
	private void altaFallecidos() {
		ventana.deshabilitar();
		new ControladorFallecidoAM(this);
	}

	private void altaClientes() {
		ventana.deshabilitar();
		new ControladorClientesAM(this);
	}
	
	private void colocarVentanaInterna(ControladorInterno controlador) {
		if (controladorInterno == null || controladorInterno.finalizar()) {
	        controladorInterno = controlador;
	        PanelVertical panel = new PanelVertical();
	        panel.add(controladorInterno.getVentana());
			ventana.setContentPane(panel);
		}
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
	public void actualizarCargos() {
		if (controladorInterno instanceof CargoInvocable)
			((CargoInvocable)controladorInterno).actualizarCargos();
	}
	
}