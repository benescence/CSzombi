package com.revivir.cementerio.antiguo.pantallas;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;

import javax.swing.JMenu;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import com.revivir.cementerio.antiguo.administracion.Precios;
import com.revivir.cementerio.antiguo.clientes.Alta_clientes;
import com.revivir.cementerio.antiguo.clientes.Consulta_cliente;
import com.revivir.cementerio.antiguo.clientes.Ubicacion_cliente;
import com.revivir.cementerio.antiguo.consultas.Buscar_lugares;
import com.revivir.cementerio.antiguo.consultas.Movimientos_dia;
import com.revivir.cementerio.antiguo.consultas.Reporte_clientes;
import com.revivir.cementerio.antiguo.usuarios.Alta_usuario;
import com.revivir.cementerio.antiguo.usuarios.Baja_usuario;
import com.revivir.cementerio.antiguo.usuarios.Buscar_usuarios;
import com.revivir.cementerio.antiguo.usuarios.Modif_usuario;
import com.revivir.cementerio.persistencia.entidades.Servicio;
import com.revivir.cementerio.vista.precio.VentanaPrecio;

import javax.swing.JComboBox;

public class Main_user extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_user frame = new Main_user();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main_user() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Sistema de Consultas - Cementerio ");
		setBounds(0, 0, 1024, 721);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		
		Bienvenido bienvenido = new Bienvenido();
		bienvenido.setLocation(10, 11);
		getContentPane().add(bienvenido);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		setJMenuBar(menuBar);
		
		JMenu mnClientes = new JMenu("Clientes");
		menuBar.add(mnClientes);
		
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
		menuBar.add(mnReportes);
		
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
		
		JMenu mnAdministracin = new JMenu("Administraci\u00F3n");
		menuBar.add(mnAdministracin);
		
		JMenuItem item_Precios = new JMenuItem("Precios");
		item_Precios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		   		    getContentPane().removeAll();
	                getContentPane().repaint();
	                
					VentanaPrecio VentanaPrecios = new VentanaPrecio();
					VentanaPrecios.setVisible(true);
					getContentPane().add(VentanaPrecios);
			}
		});
		mnAdministracin.add(item_Precios);
		
		
		
		
		
		
		JMenuItem item_Vencimientos = new JMenuItem("Vencimientos");
		mnAdministracin.add(item_Vencimientos);
		
		JMenu mnAdmin = new JMenu("Usuarios");
		menuBar.add(mnAdmin);
		
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
}
