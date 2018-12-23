package com.revivir.cementerio.vista.menu.movimientos;

import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import com.revivir.cementerio.persistencia.entidades.Movimiento;
import com.revivir.cementerio.vista.tablas.TablaMovimientos;
import com.revivir.cementerio.vista.util.contenedores.PanelHorizontal;
import com.revivir.cementerio.vista.util.contenedores.PanelVertical;
import com.revivir.cementerio.vista.util.contenedores.VentanaInterna;
import com.revivir.cementerio.vista.util.entradas.EntradaTexto;

public class VentanaConsultaMovimiento extends VentanaInterna{
	
		private static final long serialVersionUID = 1L;
		private TablaMovimientos tabla;
		private EntradaTexto inFallecidoNombre, inFallecidoApellido;
		private JButton btnBuscar, btnLimpiar;
		
		public VentanaConsultaMovimiento() {
			super("Consulta de movimientoss", 450, 300);
			

			tabla = new TablaMovimientos(new ArrayList<Movimiento>());
			JScrollPane spTabla = new JScrollPane(tabla);
			PanelHorizontal panelTabla = new PanelHorizontal();
			panelTabla.setBorder(new EmptyBorder(10, 10, 10, 10));
			panelTabla.add(spTabla);

			Dimension largoTextfield = new Dimension(Short.MAX_VALUE, 25);
			Dimension largoLabel = new Dimension(100, 25);

			inFallecidoNombre = new EntradaTexto("Nombre Fallecido", largoLabel, largoTextfield);
			inFallecidoApellido = new EntradaTexto("Apellido Fallecido", largoLabel, largoTextfield);
			
			btnBuscar = new JButton("Buscar");
			btnLimpiar = new JButton("Limpiar campos");
			PanelHorizontal panelBotones = new PanelHorizontal();
			panelBotones.add(btnBuscar);
			panelBotones.add(btnLimpiar);

			PanelVertical panelPrincipal = new PanelVertical();
			panelPrincipal.setBorder(new EmptyBorder(10, 10, 10, 10));
			setContentPane(panelPrincipal);
			
			panelPrincipal.add(inFallecidoNombre);
			panelPrincipal.add(inFallecidoApellido);
			panelPrincipal.add(panelTabla);
			panelPrincipal.add(panelBotones);
		}

		public JTextField getInFallecidoNombre() {
			return inFallecidoNombre.getTextField();
		}

		public JTextField getInFallecidoApellido() {
			return inFallecidoApellido.getTextField();
		}
		
		public TablaMovimientos getTabla() {
			return tabla;
		}


		public JButton botonBuscar() {
			return btnBuscar;
		}

		public JButton botonLimpiar() {
			return btnLimpiar;
		}

	}