package com.revivir.cementerio.antiguo;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.revivir.cementerio.antiguo.administracion.Vencimientos;
import com.revivir.cementerio.antiguo.clientes.Alta_clientes;
import com.revivir.cementerio.antiguo.clientes.Consulta_cliente;
import com.revivir.cementerio.antiguo.clientes.Ubicacion_cliente;
import com.revivir.cementerio.antiguo.consultas.Buscar_lugares;
import com.revivir.cementerio.antiguo.consultas.Movimientos_dia;
import com.revivir.cementerio.antiguo.consultas.Reporte_clientes;
import com.revivir.cementerio.antiguo.pantallas.Bienvenido;
import com.revivir.cementerio.antiguo.usuarios.Alta_usuario;
import com.revivir.cementerio.antiguo.usuarios.Baja_usuario;
import com.revivir.cementerio.antiguo.usuarios.Buscar_usuarios;
import com.revivir.cementerio.antiguo.usuarios.Modif_usuario;
import com.revivir.cementerio.negocios.Sesion;
import com.revivir.cementerio.vista.ControladorInterno;
import com.revivir.cementerio.vista.clientes2.busqueda.cliente.ControladorConsultaCliente;
import com.revivir.cementerio.vista.clientes2.busqueda.fallecido.ControladorConsultaFallecidos;
import com.revivir.cementerio.vista.menu.principal.ControladorAltaCompleta;
import com.revivir.cementerio.vista.menu.usuarios.ControladorUsuariosABM;
import com.revivir.cementerio.vista.precio.ControladorPrecio;
import com.revivir.cementerio.vista.sesion.ControladorIniciarSesion;
import com.revivir.cementerio.vista.util.contenedores.PanelVertical;

@SuppressWarnings("serial")
public class MainPrincipal extends JFrame {
	private ControladorInterno controladorInterno = null;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPrincipal frame = new MainPrincipal();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainPrincipal() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Sistema de Consultas - Cementerio ");
		setBounds(0, 0, 1000, 700);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
		
		Bienvenido bienvenido = new Bienvenido();
		bienvenido.setLocation(10, 11);
		getContentPane().add(bienvenido);
		
		JMenuBar menuBarra = new JMenuBar();
		menuBarra.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {}
		});
		setJMenuBar(menuBarra);
		
		
		
		
		//************************* MODULOS NUEVOS
		JMenu menuClientes2 = new JMenu("Clientes");
		menuBarra.add(menuClientes2);

		JMenuItem itemAltaCliente = new JMenuItem("Alta de clientes");
		menuClientes2.add(itemAltaCliente);
		itemAltaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostrarAltaCliente();
			}
		});

		JMenuItem itemConsultaCliente = new JMenuItem("Consulta de clientes");
		menuClientes2.add(itemConsultaCliente);
		itemConsultaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostrarConsultaCliente();
			}
		});

		JMenuItem itemConsultaFallecidos = new JMenuItem("Consulta de fallecidos");
		menuClientes2.add(itemConsultaFallecidos);
		itemConsultaFallecidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostrarConsultaFallecidos();
			}
		});

		JMenu mnAdministracin = new JMenu("Administraci\u00F3n");
		menuBarra.add(mnAdministracin);
		
		
		JMenuItem itemAltaCargo = new JMenuItem("Alta_Cargo");
		mnAdministracin.add(itemAltaCargo);
		itemAltaCargo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostrarVentanaPrecio();
			}
		});
		
		
		
		
		
		
		
		
		
		
		
		
		
		JMenu mnClientes = new JMenu("Clientes");
		//menuBarra.add(mnClientes);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Alta Clientes");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getContentPane().removeAll();
                getContentPane().repaint();

				Alta_clientes alta_cliente = new Alta_clientes();
				
				alta_cliente.setVisible(true);
				getContentPane().add(alta_cliente);
			}
		});
		mnClientes.add(mntmNewMenuItem);
		
		
		JMenuItem mntmConsultaClientes = new JMenuItem("Consulta de Clientes");
		mntmConsultaClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
                getContentPane().repaint();

				Consulta_cliente consulta_cliente = new Consulta_cliente();
				consulta_cliente.setVisible(true);
				getContentPane().add(consulta_cliente);
			}
		});
		mnClientes.add(mntmConsultaClientes);
		
		JMenuItem mntmConsultaUbicacion = new JMenuItem("Consulta por Ubicacion");
		mntmConsultaUbicacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getContentPane().removeAll();
                getContentPane().repaint();

				Ubicacion_cliente cliente_x_ubicacion = new Ubicacion_cliente();
				cliente_x_ubicacion.setVisible(true);
				getContentPane().add(cliente_x_ubicacion);
			}
		});
		mnClientes.add(mntmConsultaUbicacion);
		
		JMenu mnReportes = new JMenu("Reportes");
		menuBarra.add(mnReportes);
		
		JMenuItem item_Movimientos = new JMenuItem("Movimientos");
		item_Movimientos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
            getContentPane().repaint();
            
			Movimientos_dia movimientos = new Movimientos_dia();
			movimientos.setVisible(true);
			getContentPane().add(movimientos);
			}
		});
		
		mnReportes.add(item_Movimientos);
		
		JMenuItem mntmClientes = new JMenuItem("Clientes");
		mntmClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
                getContentPane().repaint();
                
				Reporte_clientes rep_clientes = new Reporte_clientes();
				rep_clientes.setVisible(true);
				getContentPane().add(rep_clientes);
				
			}
		});
		mnReportes.add(mntmClientes);
		
		JMenuItem mntmLugares = new JMenuItem("Lugares");
		mntmLugares.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
                getContentPane().repaint();
                
				Buscar_lugares rep_lugares = new Buscar_lugares();
				rep_lugares.setVisible(true);
				getContentPane().add(rep_lugares);
			}
		});
		mnReportes.add(mntmLugares);
		
		
		
		/*JMenuItem item_Precios = new JMenuItem("Precios");
		item_Precios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		   		    getContentPane().removeAll();
	                getContentPane().repaint();
	                
					Precios precios = new Precios();
					precios.setVisible(true);
					getContentPane().add(precios);
			}
		});*/
		//mnAdministracin.add(item_Precios);
		
		JMenuItem item_Vencimientos = new JMenuItem("Vencimientos");
		item_Vencimientos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    getContentPane().removeAll();
                getContentPane().repaint();
                
				Vencimientos vencimientos = new Vencimientos();
				vencimientos.setVisible(true);
				getContentPane().add(vencimientos);
			}
		});
		mnAdministracin.add(item_Vencimientos);
		
		JMenu mnAdmin = new JMenu("Usuarios");
		menuBarra.add(mnAdmin);

		JMenuItem mntmAlta = new JMenuItem("Alta Usuario");
		mntmAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
                getContentPane().removeAll();
                getContentPane().repaint();
                
				Alta_usuario alta_usuario = new Alta_usuario();
				alta_usuario.setVisible(true);
				getContentPane().add(alta_usuario);
				
				
			}
		});
		mnAdmin.add(mntmAlta);

		
		
		JMenuItem usuariosConsultar = new JMenuItem("Consultar usuarios");
		usuariosConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarConsultaUsuarios();
    		}
		});
		mnAdmin.add(usuariosConsultar);

		
		
		JMenuItem usuariosCerrarSesion = new JMenuItem("Cerrar sesion");
		usuariosCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cerrarSesion();
    		}
		});
		mnAdmin.add(usuariosCerrarSesion);
		
		JMenuItem mntmBajas = new JMenuItem("Baja Usuario");
		mntmBajas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				getContentPane().removeAll();
                getContentPane().repaint();

				Baja_usuario baja_usuario = new Baja_usuario();
				baja_usuario.setVisible(true);
				getContentPane().add(baja_usuario);
				
				
				
			}
		});
		mnAdmin.add(mntmBajas);
		
		JMenuItem mntmBuscar = new JMenuItem("Buscar Usuarios");
		mntmBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getContentPane().removeAll();
                getContentPane().repaint();

				Buscar_usuarios buscar_user = new Buscar_usuarios();
				buscar_user.setVisible(true);
				getContentPane().add(buscar_user);
			}
		});
		mnAdmin.add(mntmBuscar);
		
		JMenuItem mntmModificaciones = new JMenuItem("Modificaciones");
		mntmModificaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
                getContentPane().repaint();

				Modif_usuario modif_user = new Modif_usuario();
				modif_user.setVisible(true);
				getContentPane().add(modif_user);
			}
		});
		mnAdmin.add(mntmModificaciones);
		
		
	}
	

	public void cerrarSesion() {
		Sesion.cerrarSesion();
		new ControladorIniciarSesion();
		dispose();
	}

	private void mostrarConsultaCliente() {
		cerrarAnterior();        
        controladorInterno = new ControladorConsultaCliente();
        PanelVertical panel = new PanelVertical();
        panel.add(controladorInterno.getVentana());
		setContentPane(panel);
	}

	private void mostrarConsultaUsuarios() {
		cerrarAnterior();        
        //controladorInterno = new ControladorUsuariosABM(this);
        PanelVertical panel = new PanelVertical();
        //panel.add(controladorInterno.getVentana());
		setContentPane(panel);
	}
	
	private void mostrarConsultaFallecidos() {
		cerrarAnterior();        
        controladorInterno = new ControladorConsultaFallecidos();
        PanelVertical panel = new PanelVertical();
        panel.add(controladorInterno.getVentana());
		setContentPane(panel);
	}

	private void cerrarAnterior() {
		if (controladorInterno != null)
			controladorInterno.finalizar();
		getContentPane().removeAll();
		getContentPane().repaint();
	}
	
	private void mostrarAltaCliente() {
		cerrarAnterior();        
        controladorInterno = new ControladorAltaCompleta(null);
        PanelVertical panel = new PanelVertical();
        panel.add(controladorInterno.getVentana());
		setContentPane(panel);
	}
	private void mostrarVentanaPrecio() {
		cerrarAnterior();        
        controladorInterno = new ControladorPrecio(this);
        PanelVertical panel = new PanelVertical();
        panel.add(controladorInterno.getVentana());
		setContentPane(panel);
	}

	
}