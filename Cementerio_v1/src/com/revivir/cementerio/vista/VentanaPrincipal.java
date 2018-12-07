package com.revivir.cementerio.vista;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.revivir.cementerio.vista.util.Ventana;

public class VentanaPrincipal extends Ventana {
	private static final long serialVersionUID = 1L;
	JMenuItem principalAlta, principalCambiarPassword, principalCerrarSesion;
	JMenuItem clienteAlta, clienteConsulta; 
	JMenuItem fallecidoAlta, fallecidoConsulta;
	JMenuItem vinculoVincular, vinculoConsultarCliente, vinculoConsultarFallecido;
	JMenuItem cobranzaAltaCargo, cobranzaCargosFallecido, cobranzaCargosClientes, cobranzaRegistrarPagos; 
	JMenuItem movimientoTrasladar, movimientoConsultar; 
	
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

		JMenu menuCliente = new JMenu("Clientes");
		menuCliente.add(clienteAlta = new JMenuItem("Alta cliente"));
		menuCliente.add(clienteConsulta = new JMenuItem("Consultar clientes"));
		barra.add(menuCliente);

		JMenu menuFallecido = new JMenu("Fallecidos");
		menuFallecido.add(clienteAlta = new JMenuItem("Alta fallecido"));
		menuFallecido.add(clienteConsulta = new JMenuItem("Consultar fallecidos"));
		barra.add(menuFallecido);
		
		JMenu menuVinculos = new JMenu("Vinculos");
		menuVinculos.add(vinculoVincular = new JMenuItem("Vincular"));
		menuVinculos.add(vinculoConsultarCliente = new JMenuItem("Consultar clientes"));
		menuVinculos.add(vinculoConsultarFallecido = new JMenuItem("Consultar fallecidos"));
		barra.add(menuVinculos);
		
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
		
		return barra;
	}

}