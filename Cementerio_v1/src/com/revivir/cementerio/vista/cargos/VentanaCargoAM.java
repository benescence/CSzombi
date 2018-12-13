package com.revivir.cementerio.vista.cargos;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

import com.revivir.cementerio.vista.util.Boton;
import com.revivir.cementerio.vista.util.EntradaTexto;
import com.revivir.cementerio.vista.util.PanelHorizontal;
import com.revivir.cementerio.vista.util.PanelVertical;
import com.revivir.cementerio.vista.util.Ventana;

public class VentanaCargoAM extends Ventana {
	private static final long serialVersionUID = 1L;
	private Boton btnAceptar, btnCancelar, btnFallecido, btnServicio;
	private EntradaTexto inNombre, inApellido, inDNI;
	private EntradaTexto inCodigo, inNombreServicio, inDescripcion, inImporte;
	private EntradaTexto inObservaciones;
	
	public VentanaCargoAM() {
		super("Alta de cargo", 500, 500);
		
		Dimension dimLabel = new Dimension(100, 25);
		Dimension dimTextfield = new Dimension(300, 25);
		Dimension dimBoton = new Dimension(150, 25);
		
		inObservaciones = new EntradaTexto("Observaciones", dimLabel, dimTextfield);
		
		btnAceptar = new Boton("Aceptar", dimBoton);
		btnCancelar = new Boton("Cancelar", dimBoton);		
		btnFallecido = new Boton("Seleccionar fallecido", dimBoton);		
		btnServicio = new Boton("Seleccionar servicio", dimBoton);		
		PanelHorizontal panelBotones = new PanelHorizontal();
		panelBotones.setBorder(new EmptyBorder(10, 0, 0, 0));
		panelBotones.add(btnAceptar);
		panelBotones.add(btnCancelar);
		panelBotones.add(btnFallecido);
		panelBotones.add(btnServicio);
		
		PanelVertical panelPrincipal = new PanelVertical();
		panelPrincipal.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(panelPrincipal);
		
		panelPrincipal.add(panelFallecido());
		panelPrincipal.add(panelServicio());
		panelPrincipal.add(inObservaciones);
		panelPrincipal.add(panelBotones);
		pack();
		setLocationRelativeTo(null);
	}
	
	private PanelVertical panelFallecido() {
		Dimension dimLabel = new Dimension(100, 25);
		Dimension dimTextfield = new Dimension(300, 25);

		inNombre = new EntradaTexto("Nombres", dimLabel, dimTextfield);
		inApellido = new EntradaTexto("Apellidos", dimLabel, dimTextfield);
		inDNI = new EntradaTexto("DNI", dimLabel, dimTextfield);
		
		inNombre.habilitado(false);
		inApellido.habilitado(false);
		inDNI.habilitado(false);
		
		PanelVertical ret = new PanelVertical();
		ret.add(new JLabel("Datos del fallecido"));
		ret.add(inNombre);
		ret.add(inApellido);
		ret.add(inDNI);
		return ret;
	}

	private PanelVertical panelServicio() {
		Dimension dimLabel = new Dimension(100, 25);
		Dimension dimTextfield = new Dimension(300, 25);
		
		inCodigo = new EntradaTexto("Codigo", dimLabel, dimTextfield);
		inNombreServicio = new EntradaTexto("Nombre", dimLabel, dimTextfield);
		inDescripcion = new EntradaTexto("Descripcion", dimLabel, dimTextfield);
		inImporte = new EntradaTexto("Importe", dimLabel, dimTextfield);
		
		inCodigo.habilitado(false);
		inNombreServicio.habilitado(false);
		inDescripcion.habilitado(false);
		inImporte.habilitado(false);
		
		PanelVertical ret = new PanelVertical();
		ret.add(new JLabel("Datos del servicio"));
		ret.add(inCodigo);
		ret.add(inNombreServicio);
		ret.add(inDescripcion);
		ret.add(inImporte);
		return ret;
	}

	
	public Boton botonAceptar() {
		return btnAceptar;
	}
	

	public Boton botonCancelar() {
		return btnCancelar;
	}
	

	public Boton botonFallecido() {
		return btnFallecido;
	}
	

	public Boton botonServicio() {
		return btnServicio;
	}
	

	public EntradaTexto getNombre() {
		return inNombre;
	}
	

	public EntradaTexto getApellido() {
		return inApellido;
	}
	

	public EntradaTexto getDNI() {
		return inDNI;
	}
	

	public EntradaTexto getCodigo() {
		return inCodigo;
	}
	

	public EntradaTexto getNombreServicio() {
		return inNombreServicio;
	}
	

	public EntradaTexto getDescripcion() {
		return inDescripcion;
	}
	

	public EntradaTexto getImporte() {
		return inImporte;
	}
	

	public EntradaTexto getObservaciones() {
		return inObservaciones;
	}
	
}