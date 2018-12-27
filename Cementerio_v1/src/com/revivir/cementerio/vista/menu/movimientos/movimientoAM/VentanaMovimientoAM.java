package com.revivir.cementerio.vista.menu.movimientos.movimientoAM;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.border.EmptyBorder;

import com.revivir.cementerio.negocios.Almanaque;
import com.revivir.cementerio.negocios.Localizador;
import com.revivir.cementerio.persistencia.definidos.Sector;
import com.revivir.cementerio.persistencia.definidos.SubSector;
import com.revivir.cementerio.persistencia.entidades.Movimiento;
import com.revivir.cementerio.vista.util.Boton;
import com.revivir.cementerio.vista.util.TextoCentrado;
import com.revivir.cementerio.vista.util.contenedores.PanelHorizontal;
import com.revivir.cementerio.vista.util.contenedores.PanelVertical;
import com.revivir.cementerio.vista.util.contenedores.Ventana;
import com.revivir.cementerio.vista.util.entradas.EntradaFecha;
import com.revivir.cementerio.vista.util.entradas.EntradaLista;
import com.revivir.cementerio.vista.util.entradas.EntradaTexto;

public class VentanaMovimientoAM extends Ventana {
	private static final long serialVersionUID = 1L;
	private Boton btnAceptar, btnCancelar;
	private EntradaTexto inObservaciones, inCausa;
	private EntradaFecha inFecha;
	private EntradaTexto inNombreFal, inApellidoFal, inDNIFal;
	private Boton btnCargarFallecido, btnSelFallecido;
	
	// DATOS DE UBICACION
	private EntradaTexto inSeccion, inMacizo, inUnidad, inNumeroSepultura, inSepultura, inInhumacion,
	inNicho, inFila, inCirc, inParcela, inMueble;
	private JCheckBox inCheckMacizo, inCheckBis;
	private EntradaLista<Sector> inSector;
	private EntradaLista<SubSector> inSubSector;
	
	public VentanaMovimientoAM() {
		super("Alta de translado de un fallecido", 500, 500);
		inicializar();
	}
	
	public VentanaMovimientoAM(Movimiento movimiento) {
		super("Modificacion de translado de un fallecido", 200, 200);
		inicializar();
		inCausa.getTextField().setText(movimiento.getCausaTraslado());
		inObservaciones.getTextField().setText(movimiento.getObservaciones());
		inFecha.getDataChooser().setDate(movimiento.getFecha());
	}

	public void inicializar() {
		Dimension dimBoton = new Dimension(100, 25);
		
		btnAceptar = new Boton("Aceptar", dimBoton);
		btnCancelar = new Boton("Cancelar", dimBoton);
		PanelHorizontal panelBotones = new PanelHorizontal();
		panelBotones.setBorder(new EmptyBorder(10, 0, 0, 0));
		panelBotones.add(btnAceptar);
		panelBotones.add(btnCancelar);

		PanelVertical panelPrincipal = new PanelVertical();
		panelPrincipal.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(panelPrincipal);

		panelPrincipal.add(panelFallecido());
		panelPrincipal.add(new TextoCentrado("Datos de la ubicacion"));
		panelPrincipal.add(panelUbicacion());
		panelPrincipal.add(new TextoCentrado("Datos del traslado"));
		panelPrincipal.add(panelMovimiento());
		panelPrincipal.add(panelBotones);
		compactar();
	}

	private PanelVertical panelMovimiento() {
		Dimension dimTexto = new Dimension(100, 25);
		Dimension dimEntrada = new Dimension(300, 25);
		inCausa= new EntradaTexto("Causa Translado", dimTexto, dimEntrada);
		inObservaciones = new EntradaTexto("Observaciones", dimTexto, dimEntrada);
		inFecha = new EntradaFecha(Almanaque.hoy(), "Fecha", dimTexto, dimEntrada);
		
		PanelVertical ret = new PanelVertical();
		ret.add(inObservaciones);
		ret.add(inCausa);
		ret.add(inFecha);
		return ret;		
	}

	private PanelVertical panelFallecido() {
		Dimension dimTexto = new Dimension(100, 25);
		Dimension dimEntrada = new Dimension(300, 25);
		Dimension dimBoton = new Dimension(150, 25);
		
		inNombreFal = new EntradaTexto("Nombres", dimTexto, dimEntrada);
		inApellidoFal = new EntradaTexto("Apellidos", dimTexto, dimEntrada);
		inDNIFal = new EntradaTexto("DNI", dimTexto, dimEntrada);
		inNombreFal.habilitado(false);
		inApellidoFal.habilitado(false);
		
		btnCargarFallecido = new Boton("Cargar", dimBoton);
		btnSelFallecido = new Boton("Seleccionar", dimBoton);
		PanelHorizontal panelBotones = new PanelHorizontal();
		panelBotones.setBorder(new EmptyBorder(10, 0, 0, 0));
		panelBotones.add(btnCargarFallecido);
		panelBotones.add(btnSelFallecido);
		
		PanelVertical ret = new PanelVertical();
		ret.setBorder(new EmptyBorder(0, 0, 10, 10));
		ret.add(new TextoCentrado("Datos del fallecido"));
		ret.add(inNombreFal);
		ret.add(inApellidoFal);
		ret.add(inDNIFal);
		ret.add(panelBotones);
		return ret;
	}

	private PanelHorizontal panelUbicacion() {
		Dimension dimTexto1 = new Dimension(100, 25);
		Dimension dimTexto2 = new Dimension(100, 25);
		Dimension dimEntrada = new Dimension(150, 25);

		inSeccion = new EntradaTexto("Seccion", dimTexto1, dimEntrada);
		inMacizo = new EntradaTexto("Macizo", dimTexto1, dimEntrada);
		inUnidad = new EntradaTexto("Unidad", dimTexto1, dimEntrada);
		inNumeroSepultura = new EntradaTexto("N� Sepultura", dimTexto1, dimEntrada);
		inSepultura = new EntradaTexto("Sepultura", dimTexto1, dimEntrada);
		inInhumacion = new EntradaTexto("Inhumacion", dimTexto1, dimEntrada);
		inNicho = new EntradaTexto("Nicho", dimTexto2, dimEntrada);
		inFila = new EntradaTexto("Fila", dimTexto2, dimEntrada);
		inCirc = new EntradaTexto("Circ", dimTexto2, dimEntrada);
		inParcela = new EntradaTexto("Parcela", dimTexto2, dimEntrada);
		inMueble = new EntradaTexto("Mueble", dimTexto2, dimEntrada);

		inCheckBis = new JCheckBox("Bis");
		inCheckMacizo = new JCheckBox("Macizo1");
		PanelHorizontal panelCheck = new PanelHorizontal();
		panelCheck.add(inCheckBis);
		panelCheck.add(inCheckMacizo);
		
		inSector = new EntradaLista<>("Sector", dimTexto1, dimEntrada);
		inSubSector = new EntradaLista<>("Sub Sector", dimTexto2, dimEntrada);

		for (Sector sector : Localizador.traerSectores())
			inSector.getComboBox().addItem(sector);
		
		// EL SUB SECTOR DEPENDE DEL SECTOR ESCOGIDO
		inSector.getComboBox().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				recargarSubSectores();
			}
		});

		inSector.getComboBox().setSelectedIndex(0);

		// DEPENDEINDO DEL SUB SECTOR ESCOGIDO ALGUNOS CAMPOS SE INHABILITAN
		inSubSector.getComboBox().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				seleccionarSubSector();
			}
		});
		inSubSector.getComboBox().setSelectedIndex(0);
		
		// ORGANIZACION DE PANELES
		PanelVertical ret1 = new PanelVertical();
		ret1.setBorder(new EmptyBorder(10, 0, 0, 0));
		ret1.add(inSector);
		ret1.add(inSeccion);
		ret1.add(inMacizo);
		ret1.add(inUnidad);
		ret1.add(inNumeroSepultura);
		ret1.add(inSepultura);
		ret1.add(inInhumacion);
		
		PanelVertical ret2 = new PanelVertical();
		ret2.setBorder(new EmptyBorder(10, 30, 0, 0));
		ret2.add(inSubSector);
		ret2.add(inNicho);
		ret2.add(inFila);
		ret2.add(inCirc);
		ret2.add(inParcela);
		ret2.add(inMueble);
		ret2.add(panelCheck);
		
		PanelHorizontal ret = new PanelHorizontal();
		ret.add(ret1);
		ret.add(ret2);
		return ret;
	}
	
	private void seleccionarSubSector() {
		SubSector subSector = (SubSector) inSubSector.getComboBox().getSelectedItem();
		habilitarCamposUbicacion(false);
		
		if (subSector == SubSector.ADULTOS) {
			inSeccion.habilitado(true);
			inMacizo.habilitado(true);
			inUnidad.habilitado(true);
			inSepultura.habilitado(true);
			inCheckMacizo.setEnabled(true);
			inCheckBis.setEnabled(true);

		}else if (subSector == SubSector.ANGELITOS) {
			inSeccion.habilitado(true);
			inMacizo.habilitado(true);
			inUnidad.habilitado(true);
			inSepultura.habilitado(true);
			inCheckMacizo.setEnabled(true);
			inCheckBis.setEnabled(true); 
			
		}else if (subSector == SubSector.COMPRADA) {
			inSeccion.habilitado(true);
			inMacizo.habilitado(true);
			inUnidad.habilitado(true);
			inSepultura.habilitado(true);
			inCheckMacizo.setEnabled(true);
			inCheckBis.setEnabled(true);
			inParcela.habilitado(true);
			
		}else if (subSector == SubSector.INDIGENTES) {
			inSeccion.habilitado(true);
			inMacizo.habilitado(true);
			inSepultura.habilitado(true);
			inInhumacion.habilitado(true);

		} else if (subSector == SubSector.PALMERAS_ATAUD
				|| subSector == SubSector.PALMERAS_CENIZAS
				|| subSector == SubSector.PALMERAS_RESTOS) {
			
			inNicho.habilitado(true);
			inFila.habilitado(true);
			
		} else if (subSector == SubSector.PALMERAS_SEPULTURAS) {
			inSepultura.habilitado(true);
			
		} else if (subSector == SubSector.NICHERA) {
			inCirc.habilitado(true);
			inSeccion.habilitado(false);
			inMacizo.habilitado(true);
			inParcela.habilitado(true);
			inFila.habilitado(true);
			inUnidad.habilitado(true);

		} else if (subSector == SubSector.CENIZARIO) {
			inMueble.habilitado(true);
			inNicho.habilitado(true);
		
		} else if (subSector == SubSector.BOVEDA) {
			inCirc.habilitado(true);
			inSeccion.habilitado(true);
			inMacizo.habilitado(true);
			inParcela.habilitado(true);
			inUnidad.habilitado(true);
			inCheckBis.setEnabled(true);
		}
		
	}
	
	private void habilitarCamposUbicacion(boolean habilitado) {
		inSeccion.habilitado(habilitado);
		inMacizo.habilitado(habilitado);
		inUnidad.habilitado(habilitado);
		inNumeroSepultura.habilitado(habilitado);
		inSepultura.habilitado(habilitado);
		inInhumacion.habilitado(habilitado);
		inNicho.habilitado(habilitado);
		inFila.habilitado(habilitado);
		inCirc.habilitado(habilitado);
		inParcela.habilitado(habilitado);
		inMueble.habilitado(habilitado);
		inCheckMacizo.setEnabled(habilitado);
		inCheckBis.setEnabled(habilitado);
	}
	
	private void recargarSubSectores() {
		inSubSector.getComboBox().removeAllItems();
		Sector sector = (Sector) inSector.getComboBox().getSelectedItem();
		for (SubSector elemento : Localizador.traerSubSectores(sector))
			inSubSector.getComboBox().addItem(elemento);
	}

	
	public Boton botonAceptar() {
		return btnAceptar;
	}

	
	public Boton botonCancelar() {
		return btnCancelar;
	}

	
	public EntradaTexto getObservaciones() {
		return inObservaciones;
	}

	
	public EntradaTexto getCausa() {
		return inCausa;
	}

	
	public EntradaFecha getFecha() {
		return inFecha;
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

	
	public Boton botonCargarFallecido() {
		return btnCargarFallecido;
	}

	
	public Boton botonSelFallecido() {
		return btnSelFallecido;
	}

	
	public EntradaTexto getSeccion() {
		return inSeccion;
	}

	
	public EntradaTexto getMacizo() {
		return inMacizo;
	}

	
	public EntradaTexto getUnidad() {
		return inUnidad;
	}

	
	public EntradaTexto getNumeroSepultura() {
		return inNumeroSepultura;
	}

	
	public EntradaTexto getSepultura() {
		return inSepultura;
	}

	
	public EntradaTexto getInhumacion() {
		return inInhumacion;
	}

	
	public EntradaTexto getNicho() {
		return inNicho;
	}

	
	public EntradaTexto getFila() {
		return inFila;
	}

	
	public EntradaTexto getCirc() {
		return inCirc;
	}

	
	public EntradaTexto getParcela() {
		return inParcela;
	}

	
	public EntradaTexto getMueble() {
		return inMueble;
	}

	
	public JCheckBox getCheckMacizo() {
		return inCheckMacizo;
	}

	
	public JCheckBox getCheckBis() {
		return inCheckBis;
	}

	
	public EntradaLista<Sector> getSector() {
		return inSector;
	}


	public EntradaLista<SubSector> getSubSector() {
		return inSubSector;
	}
	
}