package com.revivir.cementerio.vista.clientes.alta;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.revivir.cementerio.negocios.Almanaque;
import com.revivir.cementerio.negocios.Localizador;
import com.revivir.cementerio.persistencia.definidos.Sector;
import com.revivir.cementerio.persistencia.definidos.SubSector;
import com.revivir.cementerio.persistencia.definidos.TipoFallecimiento;
import com.revivir.cementerio.vista.util.PanelHorizontal;
import com.revivir.cementerio.vista.util.PanelVertical;
import com.revivir.cementerio.vista.util.VentanaInterna;
import com.toedter.calendar.JDateChooser;
import java.awt.Rectangle;
import javax.swing.JSeparator;

public class VentanaAltaServicio extends VentanaInterna {
	private static final long serialVersionUID = 1L;
	private JButton btnExistente, btnLimpiarCliente, btnConfirmar, btnLimpiarTodo;
	private Dimension largoLabel = new Dimension(150, 25), largoEntrada = new Dimension(400, 25);

	// DATOS CLIENTE
	private JTextField inDNI, inApellido, inNombre, inTelefono, inEmail;
	
	 // DATOS DEL DIFUNTO
	private JTextField inDNIFallecido, inApellidoFallecido, inNombreFallecido, inCocheria;
	private JDateChooser inFechaFallecimiento;
	private JComboBox<TipoFallecimiento> inTipoFallecimiento;
	
	// DATOS DE UBICACION
	private JTextField inSeccion, inMacizo, inUnidad, inNumeroSepultura, inSepultura, inInhumacion,
	inNicho, inFila, inCirc, inParcela, inMueble;
	private JCheckBox inCheckMacizo, inCheckBis;
	private JComboBox<Sector> inSector;
	private JComboBox<SubSector> inSubSector;
	
	public VentanaAltaServicio() {
		super("Alta de servicio", 450, 300);
		setNormalBounds(new Rectangle(100, 100, 600, 500));
		
		// BOTONES
		btnConfirmar = new JButton("Confirmar alta de servicio");
		btnLimpiarTodo = new JButton("Limpiar todos los campos");
		PanelHorizontal panelBotones = new PanelHorizontal();
		panelBotones.add(btnConfirmar);
		panelBotones.add(btnLimpiarTodo);
		
		// PANELES
		PanelVertical panelPrincipal = new PanelVertical();
		panelPrincipal.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(panelPrincipal);
		
		PanelHorizontal panel1 = new PanelHorizontal();
		panel1.add(crearPanelCliente());
		panel1.add(crearPanelFallecido());
		panelPrincipal.add(panel1);
		panelPrincipal.add(new JSeparator());
		panelPrincipal.add(crearPanelUbicacion());
		panelPrincipal.add(panelBotones);
	}

	private PanelVertical crearPanelCliente() {
		// ENTRADAS
		JLabel lblDNI = new JLabel("DNI");
		JLabel lblApellidos = new JLabel("Apellidos");
		JLabel lblNombres = new JLabel("Nombres");
		JLabel lblTelefono = new JLabel("Telefono");
		JLabel lblEmail = new JLabel("E-Mail");

		lblEmail.setEnabled(false);
		lblDNI.setMinimumSize(largoLabel);
		lblDNI.setPreferredSize(largoLabel);
		lblDNI.setMaximumSize(largoLabel);
		
		lblApellidos.setMinimumSize(largoLabel);
		lblApellidos.setPreferredSize(largoLabel);
		lblApellidos.setMaximumSize(largoLabel);
		
		lblNombres.setMinimumSize(largoLabel);
		lblNombres.setPreferredSize(largoLabel);
		lblNombres.setMaximumSize(largoLabel);
		
		lblTelefono.setMinimumSize(largoLabel);
		lblTelefono.setPreferredSize(largoLabel);
		lblTelefono.setMaximumSize(largoLabel);
		
		lblEmail.setMinimumSize(largoLabel);
		lblEmail.setPreferredSize(largoLabel);
		lblEmail.setMaximumSize(largoLabel);
				
		inDNI = new JTextField();
		inApellido = new JTextField();
		inNombre = new JTextField();
		inTelefono = new JTextField();
		inEmail = new JTextField();
		
		inDNI.setMaximumSize(largoEntrada);
		inApellido.setMaximumSize(largoEntrada);
		inNombre.setMaximumSize(largoEntrada);
		inTelefono.setMaximumSize(largoEntrada);
		inEmail.setMaximumSize(largoEntrada);
		
		// BOTONES
		btnExistente = new JButton("Seleccionar cliente existente");
		btnLimpiarCliente = new JButton("Limpiar campos");
		PanelHorizontal panelBotones = new PanelHorizontal();
		panelBotones.setBorder(new EmptyBorder(10, 10, 10, 10));
		panelBotones.add(btnExistente);
		panelBotones.add(btnLimpiarCliente);
		
		// ORGANIZACION DE PANELES
		PanelHorizontal panelDNI = new PanelHorizontal();
		panelDNI.add(lblDNI);
		panelDNI.add(inDNI);

		PanelHorizontal panelApellido = new PanelHorizontal();
		panelApellido.add(lblApellidos);
		panelApellido.add(inApellido);

		PanelHorizontal panelNombre = new PanelHorizontal();
		panelNombre.add(lblNombres);
		panelNombre.add(inNombre);

		PanelHorizontal panelTelefono = new PanelHorizontal();
		panelTelefono.add(lblTelefono);
		panelTelefono.add(inTelefono);

		PanelHorizontal panelEmail = new PanelHorizontal();
		panelEmail.add(lblEmail);
		panelEmail.add(inEmail);
		
		PanelVertical ret = new PanelVertical();
		ret.setBorder(new EmptyBorder(10, 10, 10, 30));
		ret.add(new JLabel("Datos del cliente"));
		ret.add(panelApellido);
		ret.add(panelNombre);
		ret.add(panelDNI);
		ret.add(panelTelefono);
		ret.add(panelEmail);
		ret.add(panelBotones);
		return ret;
	}
	
	private PanelVertical crearPanelFallecido() {
		JLabel lblDNI = new JLabel("DNI");
		JLabel lblApellidos = new JLabel("Apellidos");
		JLabel lblNombres = new JLabel("Nombres");
		JLabel lblCocheria = new JLabel("Cocheria");
		JLabel lblFecha = new JLabel("Fecha de fallecimiento");
		JLabel lblTipo = new JLabel("Tipo de fallecimiento");

		lblDNI.setMinimumSize(largoLabel);
		lblDNI.setPreferredSize(largoLabel);
		lblDNI.setMaximumSize(largoLabel);
		
		lblApellidos.setMinimumSize(largoLabel);
		lblApellidos.setPreferredSize(largoLabel);
		lblApellidos.setMaximumSize(largoLabel);
		
		lblNombres.setMinimumSize(largoLabel);
		lblNombres.setPreferredSize(largoLabel);
		lblNombres.setMaximumSize(largoLabel);
		
		lblCocheria.setMinimumSize(largoLabel);
		lblCocheria.setPreferredSize(largoLabel);
		lblCocheria.setMaximumSize(largoLabel);
		
		lblFecha.setMinimumSize(largoLabel);
		lblFecha.setPreferredSize(largoLabel);
		lblFecha.setMaximumSize(largoLabel);
		
		lblTipo.setMinimumSize(largoLabel);
		lblTipo.setPreferredSize(largoLabel);
		lblTipo.setMaximumSize(largoLabel);
		
		lblDNI.setPreferredSize(largoLabel);
		lblApellidos.setPreferredSize(largoLabel);
		lblNombres.setPreferredSize(largoLabel);
		lblCocheria.setPreferredSize(largoLabel);
		lblFecha.setPreferredSize(largoLabel);
		lblTipo.setPreferredSize(largoLabel);
		
		inDNIFallecido = new JTextField();
		inApellidoFallecido = new JTextField();
		inNombreFallecido = new JTextField();
		inCocheria = new JTextField();
		inFechaFallecimiento = new JDateChooser(Almanaque.hoy());
		inTipoFallecimiento = new JComboBox<TipoFallecimiento>();
		for (TipoFallecimiento tipoFallecimiento : TipoFallecimiento.values())
			inTipoFallecimiento.addItem(tipoFallecimiento);
		
		
		inDNIFallecido.setMaximumSize(largoEntrada);
		inApellidoFallecido.setMaximumSize(largoEntrada);
		inNombreFallecido.setMaximumSize(largoEntrada);
		inCocheria.setMaximumSize(largoEntrada);
		inTipoFallecimiento.setMaximumSize(largoEntrada);
		inFechaFallecimiento.setMaximumSize(largoEntrada);
		
		// ORGANIZACION DE PANELES
		PanelHorizontal panelDNI = new PanelHorizontal();
		panelDNI.add(lblDNI);
		panelDNI.add(inDNIFallecido);

		PanelHorizontal panelApellido = new PanelHorizontal();
		panelApellido.add(lblApellidos);
		panelApellido.add(inApellidoFallecido);

		PanelHorizontal panelNombre = new PanelHorizontal();
		panelNombre.add(lblNombres);
		panelNombre.add(inNombreFallecido);

		PanelHorizontal panelCocheria = new PanelHorizontal();
		panelCocheria.add(lblCocheria);
		panelCocheria.add(inCocheria);

		PanelHorizontal panelFecha = new PanelHorizontal();
		panelFecha.add(lblFecha);
		panelFecha.add(inFechaFallecimiento);
		
		PanelHorizontal panelTipo = new PanelHorizontal();
		panelTipo.add(lblTipo);
		panelTipo.add(inTipoFallecimiento);
		
		PanelVertical ret = new PanelVertical();
		ret.setBorder(new EmptyBorder(10, 30, 10, 10));
		ret.add(new JLabel("Datos del difunto"));
		ret.add(panelApellido);
		ret.add(panelNombre);
		ret.add(panelDNI);
		ret.add(panelCocheria);
		ret.add(panelTipo);
		ret.add(panelFecha);
		return ret;
	}
	
	private PanelHorizontal crearPanelUbicacion() {
		JLabel lblSector = new JLabel("Sector");
		JLabel lblSubSector = new JLabel("Sub sector");
		JLabel lblSeccion = new JLabel("Seccion");
		JLabel lblMacizo = new JLabel("Macizo");
		JLabel lblUnidad = new JLabel("Unidad");
		JLabel lblNumSepultura = new JLabel("N° Sepultura");
		JLabel lblSepultura = new JLabel("Sepultura");
		JLabel lblInhumacion = new JLabel("Inhumacion");
		JLabel lblNicho = new JLabel("Nicho");
		JLabel lblFila = new JLabel("Fila");
		JLabel lblCirc = new JLabel("Circ");
		JLabel lblParcela = new JLabel("Parcela");
		JLabel lblMueble = new JLabel("Mueble");
		JLabel lblCheckMacizo = new JLabel("Check Macizo");
		JLabel lblCheckBis = new JLabel("Check Bis");

		Dimension largoLabel = new Dimension(100, 25);
		lblSector.setPreferredSize(largoLabel);
		lblSubSector.setPreferredSize(largoLabel);
		lblSeccion.setPreferredSize(largoLabel);
		lblMacizo.setPreferredSize(largoLabel);
		lblUnidad.setPreferredSize(largoLabel);
		lblNumSepultura.setPreferredSize(largoLabel);
		lblSepultura.setPreferredSize(largoLabel);
		lblInhumacion.setPreferredSize(largoLabel);
		lblNicho.setPreferredSize(largoLabel);
		lblFila.setPreferredSize(largoLabel);
		lblCirc.setPreferredSize(largoLabel);
		lblParcela.setPreferredSize(largoLabel);
		lblMueble.setPreferredSize(largoLabel);
		lblCheckMacizo.setPreferredSize(largoLabel);
		lblCheckBis.setPreferredSize(largoLabel);
		
		inSeccion = new JTextField();
		inMacizo = new JTextField();
		inUnidad = new JTextField();
		inNumeroSepultura = new JTextField();
		inSepultura = new JTextField();
		inInhumacion = new JTextField();
		inNicho = new JTextField();
		inFila = new JTextField();
		inCirc = new JTextField();
		inParcela = new JTextField();
		inMueble = new JTextField();
		inCheckBis = new JCheckBox("Bis");
		inCheckMacizo = new JCheckBox("Macizo");
		
		inSector = new JComboBox<>();
		inSubSector = new JComboBox<>();

		for (Sector sector : Localizador.traerSectores())
			inSector.addItem(sector);
		
		// EL SUB SECTOR DEPENDE DEL SECTOR ESCOGIDO
		inSector.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				recargarSubSectores();
			}
		});

		inSector.setSelectedIndex(0);

		
		Dimension largoEntrada = new Dimension(Short.MAX_VALUE, 25);
		inSector.setMaximumSize(largoEntrada);
		inSubSector.setMaximumSize(largoEntrada);
		inSeccion.setMaximumSize(largoEntrada);
		inMacizo.setMaximumSize(largoEntrada);
		inUnidad.setMaximumSize(largoEntrada);
		inNumeroSepultura.setMaximumSize(largoEntrada);
		inSepultura.setMaximumSize(largoEntrada);
		inInhumacion.setMaximumSize(new Dimension(Short.MAX_VALUE, 25));
		inNicho.setMaximumSize(new Dimension(Short.MAX_VALUE, 25));
		inFila.setMaximumSize(new Dimension(Short.MAX_VALUE, 25));
		inCirc.setMaximumSize(new Dimension(Short.MAX_VALUE, 25));
		inParcela.setMaximumSize(new Dimension(Short.MAX_VALUE, 25));
		inMueble.setMaximumSize(new Dimension(Short.MAX_VALUE, 25));
		

		// DEPENDEINDO DEL SUB SECTOR ESCOGIDO ALGUNOS CAMPOS SE INHABILITAN
		inSubSector.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				seleccionarSubSector();
			}
		});
		inSubSector.setSelectedIndex(0);
		
		
		// ORGANIZACION DE PANELES
		PanelHorizontal panelSector = new PanelHorizontal();
		panelSector.add(lblSector);
		panelSector.add(inSector);

		PanelHorizontal panelSubSector = new PanelHorizontal();
		panelSubSector.add(lblSubSector);
		panelSubSector.add(inSubSector);
		
		PanelHorizontal panelSeccion = new PanelHorizontal();
		panelSeccion.add(lblSeccion);
		panelSeccion.add(inSeccion);

		PanelHorizontal panelMacizo = new PanelHorizontal();
		panelMacizo.add(lblMacizo);
		panelMacizo.add(inMacizo);

		PanelHorizontal panelUnidad = new PanelHorizontal();
		panelUnidad.add(lblUnidad);
		panelUnidad.add(inUnidad);

		PanelHorizontal panelNumSepultura = new PanelHorizontal();
		panelNumSepultura.add(lblNumSepultura);
		panelNumSepultura.add(inNumeroSepultura);

		PanelHorizontal panelSepultura = new PanelHorizontal();
		panelSepultura.add(lblSepultura);
		panelSepultura.add(inSepultura);
		
		PanelHorizontal panelInhumacion = new PanelHorizontal();
		panelInhumacion.add(lblInhumacion);
		panelInhumacion.add(inInhumacion);

		PanelHorizontal panelNicho = new PanelHorizontal();
		panelNicho.add(lblNicho);
		panelNicho.add(inNicho);

		PanelHorizontal panelFila = new PanelHorizontal();
		panelFila.add(lblFila);
		panelFila.add(inFila);

		PanelHorizontal panelCirc = new PanelHorizontal();
		panelCirc.add(lblCirc);
		panelCirc.add(inCirc);

		PanelHorizontal panelParcela = new PanelHorizontal();
		panelParcela.add(lblParcela);
		panelParcela.add(inParcela);
		
		PanelHorizontal panelMueble = new PanelHorizontal();
		panelMueble.add(lblMueble);
		panelMueble.add(inMueble);
		
		PanelVertical ret1 = new PanelVertical();
		ret1.add(panelSector);
		ret1.add(panelSeccion);
		ret1.add(panelMacizo);
		ret1.add(panelUnidad);
		ret1.add(panelNumSepultura);
		ret1.add(panelSepultura);
		ret1.add(panelInhumacion);
		
		PanelVertical ret2 = new PanelVertical();
		ret2.add(panelSubSector);
		ret2.add(panelNicho);
		ret2.add(panelFila);
		ret2.add(panelCirc);
		ret2.add(panelParcela);
		ret2.add(panelMueble);
		ret2.add(inCheckBis);
		ret2.add(inCheckMacizo);
		
		PanelHorizontal ret = new PanelHorizontal();
		ret.setName("Ubicacion del difunto");
		ret.add(ret1);
		ret.add(ret2);
		return ret;
	}
	
	private void seleccionarSubSector() {
		SubSector subSector = (SubSector) inSubSector.getSelectedItem();
		
		if (subSector == SubSector.SEPULTURAS) {
			habilitarCamposUbicacion(false);
			inSeccion.setEnabled(true);
			inMacizo.setEnabled(true);
			inUnidad.setEnabled(true);
			inNumeroSepultura.setEnabled(true);
			inCheckMacizo.setEnabled(true);
			inCheckBis.setEnabled(true);

		} else if (subSector == SubSector.INDIGENTES) {
			habilitarCamposUbicacion(false);
			inSeccion.setEnabled(true);
			inMacizo.setEnabled(true);
			inSepultura.setEnabled(true);
			inInhumacion.setEnabled(true);

		} else if (subSector == SubSector.PALMERAS_ATAUD
				|| subSector == SubSector.PALMERAS_CENIZAS
				|| subSector == SubSector.PALMERAS_RESTOS) {
			
			habilitarCamposUbicacion(false);
			inNicho.setEnabled(true);
			inFila.setEnabled(true);
			
		} else if (subSector == SubSector.PALMERAS_SEPULTURAS) {
			habilitarCamposUbicacion(false);
			inSepultura.setEnabled(true);
			
		} else if (subSector == SubSector.NICHERA) {
			habilitarCamposUbicacion(false);
			inCirc.setEnabled(true);
			inSeccion.setEnabled(true);
			inMacizo.setEnabled(true);
			inParcela.setEnabled(true);
			inFila.setEnabled(true);
			inUnidad.setEnabled(true);

		} else if (subSector == SubSector.CENIZARIO) {
			habilitarCamposUbicacion(false);
			inMueble.setEnabled(true);
			inNicho.setEnabled(true);
		
		} else if (subSector == SubSector.BOVEDA) {
			habilitarCamposUbicacion(false);
			inCirc.setEnabled(true);
			inSeccion.setEnabled(true);
			inMacizo.setEnabled(true);
			inParcela.setEnabled(true);
			inUnidad.setEnabled(true);
			inCheckBis.setEnabled(true);
		}
		
	}
	
	private void habilitarCamposUbicacion(boolean habilitado) {
		inSeccion.setEnabled(habilitado);
		inMacizo.setEnabled(habilitado);
		inUnidad.setEnabled(habilitado);
		inNumeroSepultura.setEnabled(habilitado);
		inSepultura.setEnabled(habilitado);
		inInhumacion.setEnabled(habilitado);
		inNicho.setEnabled(habilitado);
		inFila.setEnabled(habilitado);
		inCirc.setEnabled(habilitado);
		inParcela.setEnabled(habilitado);
		inMueble.setEnabled(habilitado);
		inCheckMacizo.setEnabled(habilitado);
		inCheckBis.setEnabled(habilitado);
	}
	
	private void recargarSubSectores() {
		inSubSector.removeAllItems();
		Sector sector = (Sector) inSector.getSelectedItem();
		for (SubSector elemento : Localizador.traerSubSectores(sector))
			inSubSector.addItem(elemento);
	}

	
	
	
	
	//************************************* SOLO GETTERS A PARTIR DE ESTE PUNTO *********************************************
	public JTextField getDNI() {
		return inDNI;
	}

	public JTextField getApellido() {
		return inApellido;
	}

	public JTextField getNombre() {
		return inNombre;
	}

	public JTextField getTelefono() {
		return inTelefono;
	}

	public JTextField getEmail() {
		return inEmail;
	}

	public JTextField getInDNIFallecido() {
		return inDNIFallecido;
	}

	public JTextField getInApellidoFallecido() {
		return inApellidoFallecido;
	}

	public JTextField getInNombreFallecido() {
		return inNombreFallecido;
	}

	public JTextField getInCocheria() {
		return inCocheria;
	}

	public JDateChooser getInFechaFallecimiento() {
		return inFechaFallecimiento;
	}

	public JComboBox<TipoFallecimiento> getInTipoFallecimiento() {
		return inTipoFallecimiento;
	}

	public JTextField getInSeccion() {
		return inSeccion;
	}

	public JTextField getInMacizo() {
		return inMacizo;
	}

	public JTextField getInUnidad() {
		return inUnidad;
	}

	public JTextField getInNumeroSepultura() {
		return inNumeroSepultura;
	}

	public JTextField getInSepultura() {
		return inSepultura;
	}

	public JTextField getInInhumacion() {
		return inInhumacion;
	}

	public JTextField getInNicho() {
		return inNicho;
	}

	public JTextField getInFila() {
		return inFila;
	}

	public JTextField getInCirc() {
		return inCirc;
	}

	public JTextField getInParcela() {
		return inParcela;
	}

	public JTextField getInMueble() {
		return inMueble;
	}

	public JCheckBox getInCheckMacizo() {
		return inCheckMacizo;
	}

	public JCheckBox getInCheckBis() {
		return inCheckBis;
	}

	public JComboBox<Sector> getInSector() {
		return inSector;
	}

	public JComboBox<SubSector> getInSubSector() {
		return inSubSector;
	}

	public JButton botonExistente() {
		return btnExistente;
	}

	public JButton botonLimpiarCliente() {
		return btnLimpiarCliente;
	}

	public JButton botonLimpiarTodo() {
		return btnLimpiarTodo;
	}

	public JButton botonConfirmar() {
		return btnConfirmar;
	}
		
}