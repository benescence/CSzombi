package com.revivir.cementerio.vista.precio;


	import java.awt.Dimension;
	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JTextField;
	import javax.swing.border.Border;
	import javax.swing.border.EmptyBorder;

	import com.revivir.cementerio.persistencia.entidades.Precio;
	import com.revivir.cementerio.vista.util.PanelHorizontal;
	import com.revivir.cementerio.vista.util.PanelVertical;
import com.revivir.cementerio.vista.util.Ventana;

	
	public class VentanaAMcargo extends Ventana {
		private static final long serialVersionUID = 1L;
		private JButton btnAceptar, btnCancelar;
		private JTextField inCodigo, inDescripcion, inMonto, inObservacion;
		private Precio precio = null;
		
		// Constructor para un nuevo alumno
		public VentanaAMcargo() {
			super ("ingresar cargo", 500,500);
			setTitle("Ingresar Cargo");
			cargarComponentes();
		}
		
		// Constructor para editar un alumno
		public VentanaAMcargo(Precio precio) {
			super ("ingresar cargo", 500,500);
			setTitle("Editar alumno");
			cargarComponentes();
			this.precio = precio;
			inCodigo.setText(String.valueOf(precio.getCodigo()));
			inDescripcion.setText(precio.getDescripcion());
			inMonto.setText(String.valueOf(precio.getMonto()));
			inObservacion.setText(precio.getObservaciones());
			
		}
		
		private void cargarComponentes() {
			
			
			setLocationRelativeTo(null); // Centrar pantalla
			setResizable(false);
			setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

			// AGREGO LAS ETIQUETAS
			JLabel lblCodigo = new JLabel("Codigo: ");
			JLabel lblDescripcion = new JLabel("Descripcion: ");
			JLabel lblMonto = new JLabel("Monto: ");
			JLabel lblObservacion = new JLabel("Observacion: ");
			
			
			EmptyBorder bordeEtiqueta = new EmptyBorder(5, 0, 5, 50);
			lblCodigo.setBorder(bordeEtiqueta);
			lblDescripcion.setBorder(bordeEtiqueta);
			lblMonto.setBorder(bordeEtiqueta);
		    lblObservacion.setBorder(bordeEtiqueta);
		
			
			PanelVertical panelEtiquetas = new PanelVertical();
			panelEtiquetas.add(lblCodigo);
			panelEtiquetas.add(lblDescripcion);
			panelEtiquetas.add(lblMonto);
			panelEtiquetas.add(lblObservacion);
		

			// AGREGO LAS ENTRADAS
			inCodigo = new JTextField();
			inDescripcion = new JTextField();
			inMonto = new JTextField();
			inObservacion = new JTextField();
			

			Dimension largoEntrada = new Dimension(Short.MAX_VALUE, 25);
			inCodigo.setMaximumSize(largoEntrada);
			inDescripcion.setMaximumSize(largoEntrada);
			inMonto.setMaximumSize(largoEntrada);
			inObservacion.setMaximumSize(largoEntrada);
			
			
			PanelVertical panelEntradas = new PanelVertical();
			panelEntradas.add(inCodigo);
			panelEntradas.add(inDescripcion);
			panelEntradas.add(inMonto);
			panelEntradas.add(inObservacion);
		
			
			// AGREGO LOS BOTONES
			btnAceptar = new JButton("Aceptar");
			btnCancelar = new JButton("Cancelar");
	
			PanelHorizontal panelBotones = new PanelHorizontal();
			panelBotones.add(btnAceptar);
			panelBotones.add(btnCancelar);

			// ORGANIZO LOS PANELES
			PanelVertical panelPrincipal = new PanelVertical();
			setContentPane(panelPrincipal);
			Border bordePrincipal = new EmptyBorder(10, 10, 10, 10);
			panelPrincipal.setBorder(bordePrincipal);

			PanelHorizontal panelH = new PanelHorizontal();
			panelH.add(panelEtiquetas);
			panelH.add(panelEntradas);
			
			Border bordeBotones = new EmptyBorder(50, 0, 50, 0);
			panelBotones.setBorder(bordeBotones);
			
			panelPrincipal.add(panelH);
			panelPrincipal.add(panelBotones);
		}

		public JButton botonAceptar() {
			return btnAceptar;
		}

		public JButton botonCancelar() {
			return btnCancelar;
		}

		public JTextField getInCodigo() {
			return inCodigo;
		}

		public void setInCodigo(JTextField inCodigo) {
			this.inCodigo = inCodigo;
		}

		public JTextField getInDescripcion() {
			return inDescripcion;
		}

		public void setInDescripcion(JTextField inDescripcion) {
			this.inDescripcion = inDescripcion;
		}

		public JTextField getInMonto() {
			return inMonto;
		}

		public void setInMonto(JTextField inMonto) {
			this.inMonto = inMonto;
		}

		public JTextField getInObservacion() {
			return inObservacion;
		}

		public void setInObservacion(JTextField inObservacion) {
			this.inObservacion = inObservacion;
		}

		public Precio getPrecio() {
			return precio;
		}

		
		
		
		
	}
