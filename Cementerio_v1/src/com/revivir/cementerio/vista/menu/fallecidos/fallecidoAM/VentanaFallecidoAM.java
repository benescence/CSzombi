package com.revivir.cementerio.vista.menu.fallecidos.fallecidoAM;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.revivir.cementerio.negocios.Almanaque;
import com.revivir.cementerio.negocios.Localizador;
import com.revivir.cementerio.persistencia.definidos.Sector;
import com.revivir.cementerio.persistencia.definidos.SubSector;
import com.revivir.cementerio.persistencia.definidos.TipoFallecimiento;
import com.revivir.cementerio.persistencia.entidades.Fallecido;
import com.revivir.cementerio.vista.util.Boton;
import com.revivir.cementerio.vista.util.EntradaFecha;
import com.revivir.cementerio.vista.util.EntradaTexto;
import com.revivir.cementerio.vista.util.ListaDesplegable;
import com.revivir.cementerio.vista.util.PanelHorizontal;
import com.revivir.cementerio.vista.util.PanelVertical;
import com.revivir.cementerio.vista.util.Ventana;
import com.toedter.calendar.JDateChooser;

public class VentanaFallecidoAM extends Ventana {
	private static final long serialVersionUID = 1L;
	private Boton btnAceptar, btnCancelar;
	
	// DATOS DEL DIFUNTO
	private EntradaTexto inNombre, inApellido, inDNI, inCocheria;
	private EntradaFecha inFechaFallecimiento;
	private ListaDesplegable<TipoFallecimiento> inTipoDeFallecimiento;
	
	// DATOS DE UBICACION
	private EntradaTexto inSeccion, inMacizo, inUnidad, inNumeroSepultura, inSepultura, inInhumacion,
	inNicho, inFila, inCirc, inParcela, inMueble;
	private JCheckBox inCheckMacizo, inCheckBis;
	private ListaDesplegable<Sector> inSector;
	private ListaDesplegable<SubSector> inSubSector;
	
	public VentanaFallecidoAM() {
		super("Alta de fallecido", 450, 300);
		inicializar();
	}
	
	public VentanaFallecidoAM(Fallecido fallecido) {
		super("Alta de fallecido", 450, 300);
		inicializar();
		inNombre.getTextField().setText(fallecido.getNombre());
		inApellido.getTextField().setText(fallecido.getApellido());
		inDNI.getTextField().setText(fallecido.getDni());
		inCocheria.getTextField().setText(fallecido.getCocheria());
		inTipoDeFallecimiento.getComboBox().setSelectedItem(fallecido.getTipoFallecimiento());
	}
	
	public void inicializar() {
		Dimension dimBoton = new Dimension(100, 25);

		btnAceptar = new Boton("Aceptar", dimBoton);
		btnCancelar = new Boton("Cancelar", dimBoton);		
		PanelHorizontal panelBotones = new PanelHorizontal();
		panelBotones.setBorder(new EmptyBorder(10, 0, 0, 0));
		panelBotones.add(btnAceptar);
		panelBotones.add(btnCancelar);
		
		// PANELES
		PanelVertical panelPrincipal = new PanelVertical();
		panelPrincipal.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(panelPrincipal);
		
		panelPrincipal.add(crearPanelFallecido());
		panelPrincipal.add(new JSeparator());
		panelPrincipal.add(crearPanelUbicacion());
		panelPrincipal.add(panelBotones);
		pack();
		setLocationRelativeTo(null);
	}
	
	private PanelVertical crearPanelFallecido() {
		Dimension dimLabel = new Dimension(150, 25);
		Dimension dimTextfield = new Dimension(380, 25);
		
		inNombre = new EntradaTexto("Nombres", dimLabel, dimTextfield);
		inApellido = new EntradaTexto("Apellidos", dimLabel, dimTextfield);
		inDNI = new EntradaTexto("DNI", dimLabel, dimTextfield);
		inCocheria = new EntradaTexto("Cocheria", dimLabel, dimTextfield);
		inFechaFallecimiento = new EntradaFecha(Almanaque.hoy(), "Fecha de fallecimiento", dimLabel, dimTextfield);
		
		inTipoDeFallecimiento = new ListaDesplegable<>("Tipode fallecimiento", dimLabel, dimTextfield);
		for (TipoFallecimiento tipoFallecimiento : TipoFallecimiento.values())
			inTipoDeFallecimiento.getComboBox().addItem(tipoFallecimiento);
		inTipoDeFallecimiento.getComboBox().setSelectedItem(TipoFallecimiento.NO_TRAUMATICO);
		
		// ORGANIZACION DE PANELES
		PanelVertical panelFallecido = new PanelVertical();
		panelFallecido.add(new JLabel("Datos del difunto"));
		panelFallecido.add(inApellido);
		panelFallecido.add(inNombre);
		panelFallecido.add(inDNI);
		panelFallecido.add(inCocheria);
		panelFallecido.add(inTipoDeFallecimiento);
		panelFallecido.add(inFechaFallecimiento);
		return panelFallecido;
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
		
		inSector = new ListaDesplegable<>("Sector", largoLabel1, largoTextfield);
		inSubSector = new ListaDesplegable<>("Sub Sector", largoLabel2, largoTextfield);

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
		
		if (subSector == SubSector.SEPULTURAS) {
			inSeccion.bloquear(true);
			inMacizo.bloquear(true);
			inUnidad.bloquear(true);
			inNumeroSepultura.bloquear(true);
			inCheckMacizo.setEnabled(true);
			inCheckBis.setEnabled(true);

		} else if (subSector == SubSector.INDIGENTES) {
			inSeccion.bloquear(true);
			inMacizo.bloquear(true);
			inSepultura.bloquear(true);
			inInhumacion.bloquear(true);

		} else if (subSector == SubSector.PALMERAS_ATAUD
				|| subSector == SubSector.PALMERAS_CENIZAS
				|| subSector == SubSector.PALMERAS_RESTOS) {
			
			inNicho.bloquear(true);
			inFila.bloquear(true);
			
		} else if (subSector == SubSector.PALMERAS_SEPULTURAS) {
			inSepultura.bloquear(true);
			
		} else if (subSector == SubSector.NICHERA) {
			inCirc.bloquear(true);
			inSeccion.bloquear(false);
			inMacizo.bloquear(true);
			inParcela.bloquear(true);
			inFila.bloquear(true);
			inUnidad.bloquear(true);

		} else if (subSector == SubSector.CENIZARIO) {
			inMueble.bloquear(true);
			inNicho.bloquear(true);
		
		} else if (subSector == SubSector.BOVEDA) {
			inCirc.bloquear(true);
			inSeccion.bloquear(true);
			inMacizo.bloquear(true);
			inParcela.bloquear(true);
			inUnidad.bloquear(true);
			inCheckBis.setEnabled(true);
		}
		
	}
	
	private void habilitarCamposUbicacion(boolean habilitado) {
		inSeccion.bloquear(habilitado);
		inMacizo.bloquear(habilitado);
		inUnidad.bloquear(habilitado);
		inNumeroSepultura.bloquear(habilitado);
		inSepultura.bloquear(habilitado);
		inInhumacion.bloquear(habilitado);
		inNicho.bloquear(habilitado);
		inFila.bloquear(habilitado);
		inCirc.bloquear(habilitado);
		inParcela.bloquear(habilitado);
		inMueble.bloquear(habilitado);
		inCheckMacizo.setEnabled(habilitado);
		inCheckBis.setEnabled(habilitado);
	}
	
	private void recargarSubSectores() {
		inSubSector.getComboBox().removeAllItems();
		Sector sector = (Sector) inSector.getComboBox().getSelectedItem();
		for (SubSector elemento : Localizador.traerSubSectores(sector))
			inSubSector.getComboBox().addItem(elemento);
	}

	public JTextField getInDNIFallecido() {
		return inDNI.getTextField();
	}

	public JTextField getInApellidoFallecido() {
		return inApellido.getTextField();
	}

	public JTextField getInNombreFallecido() {
		return inNombre.getTextField();
	}

	public JTextField getInCocheria() {
		return inCocheria.getTextField();
	}

	public JDateChooser getInFechaFallecimiento() {
		return inFechaFallecimiento.getDataChooser();
	}

	public JComboBox<TipoFallecimiento> getInTipoFallecimiento() {
		return inTipoDeFallecimiento.getComboBox();
	}

	public JTextField getInSeccion() {
		return inSeccion.getTextField();
	}

	public JTextField getInMacizo() {
		return inMacizo.getTextField();
	}

	public JTextField getInUnidad() {
		return inUnidad.getTextField();
	}

	public JTextField getInNumeroSepultura() {
		return inNumeroSepultura.getTextField();
	}

	public JTextField getInSepultura() {
		return inSepultura.getTextField();
	}

	public JTextField getInInhumacion() {
		return inInhumacion.getTextField();
	}

	public JTextField getInNicho() {
		return inNicho.getTextField();
	}

	public JTextField getInFila() {
		return inFila.getTextField();
	}

	public JTextField getInCirc() {
		return inCirc.getTextField();
	}

	public JTextField getInParcela() {
		return inParcela.getTextField();
	}

	public JTextField getInMueble() {
		return inMueble.getTextField();
	}

	public JCheckBox getInCheckMacizo() {
		return inCheckMacizo;
	}

	public JCheckBox getInCheckBis() {
		return inCheckBis;
	}

	public JComboBox<Sector> getInSector() {
		return inSector.getComboBox();
	}

	public JComboBox<SubSector> getInSubSector() {
		return inSubSector.getComboBox();
	}

	public JButton botonAceptar() {
		return btnAceptar;
	}

	public JButton botonCancelar() {
		return btnCancelar;
	}
		
}