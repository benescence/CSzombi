package com.revivir.cementerio.vista.menu.movimientos;




import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.revivir.cementerio.negocios.Localizador;
import com.revivir.cementerio.persistencia.definidos.Sector;
import com.revivir.cementerio.persistencia.definidos.SubSector;

import com.revivir.cementerio.persistencia.entidades.Movimiento;
import com.revivir.cementerio.persistencia.entidades.Ubicacion;
import com.revivir.cementerio.vista.seleccion.fallecidos.ControladorSeleccionarFallecido;
import com.revivir.cementerio.vista.util.Boton;
import com.revivir.cementerio.vista.util.contenedores.PanelHorizontal;
import com.revivir.cementerio.vista.util.contenedores.PanelVertical;
import com.revivir.cementerio.vista.util.contenedores.Ventana;
import com.revivir.cementerio.vista.util.entradas.EntradaFecha;
import com.revivir.cementerio.vista.util.entradas.EntradaLista;
import com.revivir.cementerio.vista.util.entradas.EntradaTexto;
import com.toedter.calendar.JDateChooser;

import javax.swing.AbstractButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class VentanaTranslado extends Ventana {
	
	private static final long serialVersionUID = 1L;
	EntradaTexto inCausa;
	private EntradaTexto inObservaciones, inFallecido;
	private EntradaFecha inFechaTranslado;
	private EntradaTexto inUbicacion;
	private Boton btnAceptar, btnCancelar, btnSelFallecido;;
	
	public EntradaTexto getInFallecido() {
		return inFallecido;
	}

		// DATOS DE UBICACION
		private EntradaTexto inSeccion, inMacizo, inUnidad, inNumeroSepultura, inSepultura, inInhumacion,
		inNicho, inFila, inCirc, inParcela, inMueble;
		private JCheckBox inCheckMacizo, inCheckBis;
		private EntradaLista<Sector> inSector;
		private EntradaLista<SubSector> inSubSector;
	
	
	public VentanaTranslado() {
		super("Translado", 200, 200);
		inicializar();
	}
	
	public VentanaTranslado(Movimiento movimiento) {
		super("realizar translados", 200, 200);
		inicializar();
		inCausa.getTextField().setText(movimiento.getCausaTraslado());
		inObservaciones.getTextField().setText(movimiento.getObservaciones());

	}

	public void inicializar() {
		
		

		
		Dimension dimBoton = new Dimension(100, 25);
		
		btnAceptar = new Boton("Aceptar", dimBoton);
		btnAceptar.setText("Guardar");
		btnCancelar = new Boton("Cancelar", dimBoton);
		PanelHorizontal panelBotones = new PanelHorizontal();
		panelBotones.setBorder(new EmptyBorder(10, 0, 0, 0));
		JLabel lblSeleccionarUbicacion = new JLabel("Nueva Ubicacion : ");
		panelBotones.add(lblSeleccionarUbicacion);
		panelBotones.add(btnAceptar);
		panelBotones.add(btnCancelar);
		PanelVertical panelPrincipal = new PanelVertical();
		panelPrincipal.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(panelPrincipal);

		panelPrincipal.add(panelBotones);
		
		
		
		panelPrincipal.add(crearPanelMovimiento());
		btnSelFallecido = new Boton("Seleccionar", dimBoton);
		PanelHorizontal panelBotones_1 = new PanelHorizontal();
		panelPrincipal.add(panelBotones_1);
		panelBotones_1.setBorder(new EmptyBorder(10, 0, 0, 0));
		JLabel lblSeleccionarFallecido = new JLabel("Seleccionar Fallecido : ");
		panelBotones_1.add(lblSeleccionarFallecido);
		panelBotones_1.add(btnSelFallecido);
		JSeparator separator = new JSeparator();
		separator.setToolTipText("");
		panelPrincipal.add(separator);
		panelPrincipal.add(crearPanelUbicacion());
		panelPrincipal.add(panelBotones);
		
		compactar();
	}



	private PanelVertical crearPanelMovimiento() {

		Dimension dimTexto = new Dimension(100, 25);
		Dimension dimEntrada = new Dimension(300, 25);
		inCausa= new EntradaTexto("Causa Translado", dimTexto, dimEntrada);
		inUbicacion = new EntradaTexto("Ubicacion Anterior", dimTexto, dimEntrada);
		inFallecido = new EntradaTexto("Fallecido", dimTexto, dimEntrada);
		inUbicacion.habilitado(false);
		inFallecido.habilitado(false);
		
		PanelVertical ret = new PanelVertical();
		inObservaciones = new EntradaTexto("Observaciones", dimTexto, dimEntrada);
		ret.add(inObservaciones);
		ret.add(inCausa);
		ret.add(inUbicacion);
		ret.add(inFallecido);
		return ret;
		
	}

	private PanelHorizontal crearPanelUbicacion() {
		Dimension largoLabel1 = new Dimension(100, 25);
		Dimension largoLabel2 = new Dimension(100, 25);
		Dimension largoTextfield = new Dimension(150, 25);

		inSeccion = new EntradaTexto("Seccion", largoLabel1, largoTextfield);
		inMacizo = new EntradaTexto("Macizo", largoLabel1, largoTextfield);
		inUnidad = new EntradaTexto("Unidad", largoLabel1, largoTextfield);
		inNumeroSepultura = new EntradaTexto("N° Sepultura", largoLabel1, largoTextfield);
		inSepultura = new EntradaTexto("Sepultura", largoLabel1, largoTextfield);
		inInhumacion = new EntradaTexto("Inhumacion", largoLabel1, largoTextfield);
		inNicho = new EntradaTexto("Nicho", largoLabel2, largoTextfield);
		inFila = new EntradaTexto("Fila", largoLabel2, largoTextfield);
		inCirc = new EntradaTexto("Circ", largoLabel2, largoTextfield);
		inParcela = new EntradaTexto("Parcela", largoLabel2, largoTextfield);
		inMueble = new EntradaTexto("Mueble", largoLabel2, largoTextfield);

		inCheckBis = new JCheckBox("Bis");
		inCheckMacizo = new JCheckBox("Macizo1");
		PanelHorizontal panelCheck = new PanelHorizontal();
		panelCheck.add(inCheckBis);
		panelCheck.add(inCheckMacizo);
		
		inSector = new EntradaLista<>("Sector", largoLabel1, largoTextfield);
		inSubSector = new EntradaLista<>("Sub Sector", largoLabel2, largoTextfield);

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
	


	public JTextField getInCausa() {
		return inCausa.getTextField();
	}

	public JTextField getInObservacions() {
		return inObservaciones.getTextField();
	}

	public JDateChooser getInFechaTranslado() {
		return inFechaTranslado.getDataChooser();
	}

	public EntradaTexto getInUbicacion() {
		return inUbicacion;
	}
	public Boton botonSeleccionar() {
	
		return btnSelFallecido;
	}
	public Boton botonAceptar() {
		return btnAceptar;
	}

	public Boton botonCancelar() {
		return btnCancelar;
	}


}
