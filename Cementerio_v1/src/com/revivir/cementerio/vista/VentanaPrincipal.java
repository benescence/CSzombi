package com.revivir.cementerio.vista;

import java.awt.Event;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import com.revivir.cementerio.vista.util.contenedores.Ventana;

public class VentanaPrincipal extends Ventana {
	private static final long serialVersionUID = 1L;
	private JMenuItem principalAlta, principalCambiarPassword, principalCerrarSesion;
	private JMenuItem clienteAlta, clienteConsulta; 
	private JMenuItem fallecidoAlta, fallecidoConsulta;
	private JMenuItem responsableVincular, responsableConsultarPorCliente, responsableConsultarPorFallecido;
	private JMenuItem cobranzaAltaCargo, cobranzaCargosFallecido, cobranzaCargosClientes, cobranzaRegistrarPagos; 
	JMenuItem movimientoTrasladar, movimientoConsultar; 
	private JMenuItem servicioAlta, servicioConsulta;
	private JMenuItem usuarioAlta, usuarioConsulta;
	
	public VentanaPrincipal() {
		super("Ventana principal", 1000, 700);
		setJMenuBar(crearBarra());
		repaint();
		pack();
		setBounds(0, 0, 1000, 700);
		setLocationRelativeTo(null);		
	}
	
	private JMenuBar crearBarra() {
		JMenuBar barra = new JMenuBar();
		barra.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {}
		});
		
				
		JMenu menuPrincipal = new JMenu("Principal");
		menuPrincipal.add(principalAlta = new JMenuItem("Alta completa"));
		menuPrincipal.add(principalCambiarPassword = new JMenuItem("Cambiar contraseña"));
		menuPrincipal.add(principalCerrarSesion = new JMenuItem("Cerrar sesion"));
		barra.add(menuPrincipal);

		//********************** MENU USUARIOS ***************************
		JMenu menuCliente = new JMenu("Clientes");
		menuCliente.setMnemonic('c');
		menuCliente.add(clienteAlta = new JMenuItem("Alta cliente", 'a'));
		menuCliente.add(clienteConsulta = new JMenuItem("Consultar clientes", 'c'));
		clienteAlta.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, Event.CTRL_MASK | Event.ALT_MASK));
		barra.add(menuCliente);

		JMenu menuFallecido = new JMenu("Fallecidos");
		menuFallecido.add(fallecidoAlta = new JMenuItem("Alta fallecido"));
		menuFallecido.add(fallecidoConsulta = new JMenuItem("Consultar fallecidos"));
		barra.add(menuFallecido);
		
		JMenu menuResponsables = new JMenu("Responsables");
		menuResponsables.add(responsableVincular = new JMenuItem("Vincular"));
		menuResponsables.add(responsableConsultarPorCliente = new JMenuItem("Consultar por cliente"));
		menuResponsables.add(responsableConsultarPorFallecido = new JMenuItem("Consultar por fallecido"));
		barra.add(menuResponsables);
		
		JMenu menuCobranza = new JMenu("Cobranzas");
		menuCobranza.add(cobranzaAltaCargo = new JMenuItem("Alta cargo"));
		menuCobranza.add(cobranzaCargosClientes = new JMenuItem("Cargos de cliente"));
		menuCobranza.add(cobranzaCargosFallecido = new JMenuItem("Cargos de fallecido"));
		menuCobranza.add(cobranzaRegistrarPagos = new JMenuItem("Registrar pago"));
		barra.add(menuCobranza);
		
		JMenu menuMovimientos = new JMenu("Movimientos");
		menuMovimientos.add(movimientoTrasladar = new JMenuItem("Trasladar"));
		menuMovimientos.add(movimientoConsultar = new JMenuItem("Consultar movimientos"));
		barra.add(menuMovimientos);

		JMenu menuSevicio = new JMenu("Servicios");
		menuSevicio.add(servicioAlta = new JMenuItem("Alta de servicio"));
		menuSevicio.add(servicioConsulta = new JMenuItem("Consultar servicios"));
		barra.add(menuSevicio);

		//********************** MENU USUARIOS ***************************
		JMenu menuUsuario = new JMenu("Usuarios");
		menuUsuario.setMnemonic('u');
		menuUsuario.add(usuarioAlta = new JMenuItem("Alta de usuario", 'a'));
		menuUsuario.add(usuarioConsulta = new JMenuItem("Consultar usuarios", 'c'));
		usuarioAlta.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, Event.CTRL_MASK | Event.ALT_MASK));
		barra.add(menuUsuario);
		
		return barra;
	}
	
	public JMenuItem getServicioAlta() {
		return servicioAlta;
	}
	
	public JMenuItem getServicioConsulta() {
		return servicioConsulta;
	}

	public JMenuItem getClienteAlta() {
		return clienteAlta;
	}

	public JMenuItem getClienteConsulta() {
		return clienteConsulta;
	}

	public JMenuItem getFallecidoAlta() {
		return fallecidoAlta;
	}

	public JMenuItem getFallecidoConsulta() {
		return fallecidoConsulta;
	}

	public JMenuItem getUsuarioAlta() {
		return usuarioAlta;
	}

	public JMenuItem getUsuarioConsulta() {
		return usuarioConsulta;
	}

	public JMenuItem getResponsableVincular() {
		return responsableVincular;
	}

	public JMenuItem getResponsableConsultarPorCliente() {
		return responsableConsultarPorCliente;
	}

	public JMenuItem getResponsableConsultarPorFallecido() {
		return responsableConsultarPorFallecido;
	}

	public JMenuItem getCobranzaAltaCargo() {
		return cobranzaAltaCargo;
	}

	public JMenuItem getCobranzaCargosFallecido() {
		return cobranzaCargosFallecido;
	}

	public JMenuItem getCobranzaCargosClientes() {
		return cobranzaCargosClientes;
	}

	public JMenuItem getCobranzaRegistrarPagos() {
		return cobranzaRegistrarPagos;
	}

	public JMenuItem getPrincipalAlta() {
		return principalAlta;
	}

	public JMenuItem getPrincipalCambiarPassword() {
		return principalCambiarPassword;
	}

	public JMenuItem getPrincipalCerrarSesion() {
		return principalCerrarSesion;
	}
	
}