package com.revivir.cementerio.vista.menu.pagos.pagoAM;

import java.awt.Dimension;

import javax.swing.border.EmptyBorder;

import com.revivir.cementerio.negocios.Almanaque;
import com.revivir.cementerio.persistencia.entidades.Pago;
import com.revivir.cementerio.vista.util.Boton;
import com.revivir.cementerio.vista.util.TextoCentrado;
import com.revivir.cementerio.vista.util.contenedores.PanelHorizontal;
import com.revivir.cementerio.vista.util.contenedores.PanelVertical;
import com.revivir.cementerio.vista.util.contenedores.Ventana;
import com.revivir.cementerio.vista.util.entradas.EntradaFecha;
import com.revivir.cementerio.vista.util.entradas.EntradaTexto;

public class VentanaPagoAM extends Ventana {
	private static final long serialVersionUID = 1L;
	private Boton btnAceptar, btnCancelar, btnSelCliente, btnCargarCliente, btnSelCargo, btnCargarCargo;
	private EntradaTexto inNombreCli, inApellidoCli, inDNICli;
	private EntradaTexto inNombreFal, inApellidoFal, inDNIFal;
	private EntradaTexto inCodigo, inNombreSer;
	private EntradaTexto inImporte, inObservaciones;
	private EntradaFecha inFecha;

	public VentanaPagoAM() {
		super("Alta de pago");
		inicializar();
	}

	public VentanaPagoAM(Pago pago) {
		super("Modificacion de pago");
		inicializar();
		inImporte.getTextField().setText(pago.getImporte().toString());
		inObservaciones.getTextField().setText(pago.getObservaciones());
		inFecha.getDataChooser().setDate(pago.getFecha());
	}
	
	public void inicializar() {
		Dimension dimTexto = new Dimension(100, 25);
		Dimension dimEntrada = new Dimension(300, 25);
		Dimension dimBoton = new Dimension(150, 25);
		
		inFecha = new EntradaFecha(Almanaque.hoy(), "Fecha", dimTexto, dimEntrada);
		inImporte = new EntradaTexto("Importe", dimTexto, dimEntrada);
		inObservaciones = new EntradaTexto("Observaciones", dimTexto, dimEntrada);
		
		btnAceptar = new Boton("Aceptar", dimBoton);
		btnCancelar = new Boton("Cancelar", dimBoton);		
		PanelHorizontal panelBotones = new PanelHorizontal();
		panelBotones.setBorder(new EmptyBorder(10, 0, 0, 0));
		panelBotones.add(btnAceptar);
		panelBotones.add(btnCancelar);
		
		PanelVertical panelPrincipal = new PanelVertical();
		panelPrincipal.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(panelPrincipal);
		
		panelPrincipal.add(panelCliente());
		panelPrincipal.add(panelCargo());
		panelPrincipal.add(inFecha);
		panelPrincipal.add(inImporte);
		panelPrincipal.add(inObservaciones);
		panelPrincipal.add(panelBotones);
		compactar();
	}
	
	private PanelVertical panelCliente() {
		Dimension dimTexto = new Dimension(100, 25);
		Dimension dimEntrada = new Dimension(300, 25);
		Dimension dimBoton = new Dimension(150, 25);
		
		inNombreCli = new EntradaTexto("Nombres", dimTexto, dimEntrada);
		inApellidoCli = new EntradaTexto("Apellidos", dimTexto, dimEntrada);
		inDNICli = new EntradaTexto("DNI", dimTexto, dimEntrada);
		inNombreCli.habilitado(false);
		inApellidoCli.habilitado(false);
		
		btnCargarCliente = new Boton("Cargar", dimBoton);
		btnSelCliente = new Boton("Seleccionar", dimBoton);
		PanelHorizontal panelBotones = new PanelHorizontal();
		panelBotones.setBorder(new EmptyBorder(10, 0, 10, 0));
		panelBotones.add(btnCargarCliente);
		panelBotones.add(btnSelCliente);
		
		PanelVertical ret = new PanelVertical();
		ret.add(new TextoCentrado("Datos del cliente"));
		ret.add(inNombreCli);
		ret.add(inApellidoCli);
		ret.add(inDNICli);
		ret.add(panelBotones);
		return ret;
	}
	
	private PanelVertical panelCargo() {
		Dimension dimTexto = new Dimension(100, 25);
		Dimension dimEntrada = new Dimension(300, 25);
		Dimension dimBoton = new Dimension(150, 25);
		
		inNombreFal = new EntradaTexto("Nombres fallecido", dimTexto, dimEntrada);
		inApellidoFal = new EntradaTexto("Apellidos fallecido", dimTexto, dimEntrada);
		inDNIFal = new EntradaTexto("DNI fallecido", dimTexto, dimEntrada);
		inNombreSer = new EntradaTexto("Servicio", dimTexto, dimEntrada);
		inCodigo = new EntradaTexto("Codigo servicio", dimTexto, dimEntrada);
		inNombreFal.habilitado(false);
		inApellidoFal.habilitado(false);
		inNombreSer.habilitado(false);
		
		btnCargarCargo = new Boton("Cargar", dimBoton);
		btnSelCargo = new Boton("Seleccionar", dimBoton);
		PanelHorizontal panelBotones = new PanelHorizontal();
		panelBotones.setBorder(new EmptyBorder(10, 0, 10, 0));
		panelBotones.add(btnCargarCargo);
		panelBotones.add(btnSelCargo);
		
		PanelVertical ret = new PanelVertical();
		ret.add(new TextoCentrado("Datos del cargo"));
		ret.add(inNombreFal);
		ret.add(inApellidoFal);
		ret.add(inDNIFal);
		ret.add(inNombreSer);
		ret.add(inCodigo);
		ret.add(panelBotones);
		return ret;
	}

	
	public Boton botonAceptar() {
		return btnAceptar;
	}
	

	public Boton botonCancelar() {
		return btnCancelar;
	}
	

	public Boton botonSelCliente() {
		return btnSelCliente;
	}
	

	public Boton botonCargarCliente() {
		return btnCargarCliente;
	}
	

	public Boton botonSelCargo() {
		return btnSelCargo;
	}
	

	public Boton botonCargarCargo() {
		return btnCargarCargo;
	}
	

	public EntradaTexto getNombreCli() {
		return inNombreCli;
	}
	

	public EntradaTexto getApellidoCli() {
		return inApellidoCli;
	}
	

	public EntradaTexto getDNICli() {
		return inDNICli;
	}
	

	public EntradaTexto getNombreFal() {
		return inNombreFal;
	}
	

	public EntradaTexto getApellidoFal() {
		return inApellidoFal;
	}
	

	public EntradaTexto getDNIFal() {
		return inDNIFal;
	}
	

	public EntradaTexto getCodigo() {
		return inCodigo;
	}
	

	public EntradaTexto getNombreSer() {
		return inNombreSer;
	}
	

	public EntradaTexto getImporte() {
		return inImporte;
	}
	

	public EntradaTexto getObservaciones() {
		return inObservaciones;
	}
	

	public EntradaFecha getFecha() {
		return inFecha;
	}

}