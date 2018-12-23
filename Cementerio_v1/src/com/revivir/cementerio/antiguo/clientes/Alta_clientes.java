package com.revivir.cementerio.antiguo.clientes;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.revivir.cementerio.antiguo.logica.Clientes;
import com.revivir.cementerio.antiguo.org.eclipse.wb.swing.FocusTraversalOnArray;
import com.toedter.calendar.JCalendar;


@SuppressWarnings("serial")
public class Alta_clientes extends JInternalFrame {

	private JTextField txt_apellidos =  new JTextField();;
	private JTextField txt_nombres;
	private JTextField txt_dni;
	private JTextField txt_domicilio;
	private JTextField txt_dni_ocupante;
	private JTextField txt_email_familiar;
	private JTextField txt_cocheria;
	private JTextField txt_tel_familiar;
	private JTextField txt_dato1;
	private JTextField txt_dato2;
	private JTextField txt_dato3;
	private JTextField txt_dato4;
	private JTextField txt_dato5;
	private JTextField txt_dato6;
	private JTextField txt_nombre_familiar;
	private JComboBox cmb_tipo_fall;
	private Calendar cal;
	
	Clientes resultado = new Clientes();

	/**
	 * 
	 * Launch the application.
	 * 
	 */

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {

				try {

					Alta_clientes frame = new Alta_clientes();

					frame.setVisible(true);

				} catch (Exception e) {

					e.printStackTrace();

				}

			}

		});

	}

	/**
	 * 
	 * Create the frame.
	 * 
	 */

	public Alta_clientes() {

		setMaximizable(true);
		setBackground(SystemColor.inactiveCaptionBorder);
		setBorder(null);
		setBounds(0, 0, 734, 478);
		getContentPane().setLayout(null);
		
		JButton btn_guardar = new JButton("Guardar Cliente Nuevo");
		

		JLabel lbl_resultado = new JLabel("");
		lbl_resultado.setBounds(178, 416, 203, 14);
		getContentPane().add(lbl_resultado);
		
		JLabel lblNewLabel = new JLabel("Apellido");
		lblNewLabel.setBounds(36, 24, 132, 14);
		getContentPane().add(lblNewLabel);

		JLabel lblContrasea = new JLabel("DNI Cliente");
		lblContrasea.setBounds(36, 171, 132, 14);
		getContentPane().add(lblContrasea);

		
		txt_apellidos.setBounds(178, 21, 203, 20);
		getContentPane().add(txt_apellidos);
		txt_apellidos.setColumns(10);
		
		txt_nombres = new JTextField();
		txt_nombres.setColumns(10);
		txt_nombres.setBounds(178, 49, 203, 20);

		getContentPane().add(txt_nombres);
		
		JButton nuevaUbicacionBoton = new JButton("Nueva Ubicacion");
		nuevaUbicacionBoton.setBounds(609, 347, 115, 23);
		getContentPane().add(nuevaUbicacionBoton);
		
		JLabel lblNivelDePermisos = new JLabel("Tipo de fallecimiento");
		lblNivelDePermisos.setBounds(409, 24, 132, 14);
		getContentPane().add(lblNivelDePermisos);

		cmb_tipo_fall = new JComboBox();
		cmb_tipo_fall.setBounds(533, 21, 165, 20);
		cmb_tipo_fall.insertItemAt("Traumatico", 0);
		cmb_tipo_fall.insertItemAt("No traumatico", 1);
		getContentPane().add(cmb_tipo_fall);
		

		JLabel lblDomicilio = new JLabel("Domicilio");
		lblDomicilio.setBounds(36, 110, 132, 14);
		getContentPane().add(lblDomicilio);

		txt_dni = new JTextField();
		txt_dni.setColumns(10);
		txt_dni.setBounds(178, 168, 203, 20);
		getContentPane().add(txt_dni);

		txt_domicilio = new JTextField();
		txt_domicilio.setColumns(10);
		txt_domicilio.setBounds(178, 107, 203, 20);

		getContentPane().add(txt_domicilio);
		JLabel lblDomicilioFamiliar = new JLabel("Dni ocupante");
		lblDomicilioFamiliar.setBounds(36, 82, 132, 14);
		getContentPane().add(lblDomicilioFamiliar);

		txt_dni_ocupante = new JTextField();
		txt_dni_ocupante.setColumns(10);
		txt_dni_ocupante.setBounds(178, 79, 203, 20);
		getContentPane().add(txt_dni_ocupante);
		
		JLabel lblEmailFamiliar = new JLabel("E-mail familiar");
		lblEmailFamiliar.setBounds(36, 201, 132, 14);
		getContentPane().add(lblEmailFamiliar);

		txt_email_familiar = new JTextField();
		txt_email_familiar.setColumns(10);
		txt_email_familiar.setBounds(178, 198, 203, 20);
		getContentPane().add(txt_email_familiar);

		JLabel lblCocheria = new JLabel("Cocheria");
		lblCocheria.setBounds(409, 54, 76, 14);
		getContentPane().add(lblCocheria);

		txt_cocheria = new JTextField();
		txt_cocheria.setColumns(10);
		txt_cocheria.setBounds(495, 52, 203, 20);
		getContentPane().add(txt_cocheria);

		JLabel lblFechaFallecimiento = new JLabel("Fecha Fallecimiento");
		lblFechaFallecimiento.setBounds(39, 264, 132, 14);
		getContentPane().add(lblFechaFallecimiento);
		setTitle("Alta Clientes");

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(36, 52, 132, 14);
		getContentPane().add(lblNombre);

		JLabel lblTelefonoFamilliar = new JLabel("Telefono familliar");
		lblTelefonoFamilliar.setBounds(36, 232, 132, 14);
		getContentPane().add(lblTelefonoFamilliar);

		txt_tel_familiar = new JTextField();
		txt_tel_familiar.setColumns(10);
		txt_tel_familiar.setBounds(178, 229, 203, 20);
		getContentPane().add(txt_tel_familiar);
		
		JLabel lbl_dato1 = new JLabel("");
		lbl_dato1.setBounds(409, 201, 72, 14);
		lbl_dato1.setVisible(true);
		getContentPane().add(lbl_dato1);

		JLabel lbl_dato2 = new JLabel("");
		lbl_dato2.setBounds(512, 201, 75, 14);
		lbl_dato2.setVisible(true);
		getContentPane().add(lbl_dato2);

		JLabel lbl_dato3 = new JLabel("");

		lbl_dato3.setBounds(409, 247, 72, 14);
		lbl_dato3.setVisible(true);
		getContentPane().add(lbl_dato3);
		
		JLabel lbl_dato4 = new JLabel("");
		lbl_dato4.setBounds(512, 247, 96, 14);
		lbl_dato4.setVisible(true);
		getContentPane().add(lbl_dato4);

		JLabel lbl_dato5 = new JLabel("");
		lbl_dato5.setBounds(409, 292, 69, 14);
		lbl_dato5.setVisible(true);
		getContentPane().add(lbl_dato5);
		
		JLabel lbl_dato6 = new JLabel("");
		lbl_dato6.setBounds(512, 292, 69, 14);
		lbl_dato6.setVisible(true);
		getContentPane().add(lbl_dato6);
		
		JCheckBox chckbxBisBoveda = new JCheckBox("Bis");
		chckbxBisBoveda.setBackground(SystemColor.inactiveCaptionBorder);
		chckbxBisBoveda.setBounds(579, 255, 52, 23);
		chckbxBisBoveda.setVisible(false);
		getContentPane().add(chckbxBisBoveda);
		
		JCheckBox chckbxBisMasizo = new JCheckBox("maciz bis");
		chckbxBisMasizo.setBackground(SystemColor.inactiveCaptionBorder);
		chckbxBisMasizo.setBounds(579, 223, 76, 23);
		chckbxBisMasizo.setVisible(false);
		getContentPane().add(chckbxBisMasizo);
		

		JButton btnModif = new JButton("Modificar ");
		btnModif.setBounds(609, 307, 115, 23);
		getContentPane().add(btnModif);
		
		
		JButton botonLimpiar = new JButton("Limpiar");
		botonLimpiar.setBounds(635, 416, 89, 23);
		getContentPane().add(botonLimpiar);
		

		JComboBox<String> cmb_sector = new JComboBox<String>();
		cmb_sector.setVisible(true);
		cmb_sector.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent arg0) {

				txt_dato1.setVisible(false);
				txt_dato2.setVisible(false);
				txt_dato3.setVisible(false);
				txt_dato4.setVisible(false);
				txt_dato5.setVisible(false);
				txt_dato6.setVisible(false);
				lbl_dato1.setVisible(false);
				lbl_dato2.setVisible(false);
				lbl_dato3.setVisible(false);
				lbl_dato4.setVisible(false);
				lbl_dato5.setVisible(false);
				lbl_dato6.setVisible(false);
				chckbxBisBoveda.setVisible(false);
				chckbxBisMasizo.setVisible(false);
			}

		});

		JComboBox<String> cmb_item_sector = new JComboBox<String>();
		cmb_item_sector.setVisible(true);
		cmb_item_sector.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				switch (cmb_sector.getSelectedIndex()) {

				case 0:
					txt_dato1.setVisible(true);
					txt_dato2.setVisible(true);
					txt_dato3.setVisible(true);
					
					lbl_dato1.setVisible(true);
					lbl_dato2.setVisible(true);
					lbl_dato3.setVisible(true);


					if (cmb_item_sector.getSelectedIndex() == 1) {
						chckbxBisBoveda.setVisible(false);
						chckbxBisMasizo.setVisible(false);
						lbl_dato4.setVisible(true);
						txt_dato4.setVisible(true);
						lbl_dato1.setText("Seccion");
						lbl_dato2.setText("Macizo");
						lbl_dato3.setText("Sepultura");
						lbl_dato4.setText("Inhumacion");
					

					} else {
						
						lbl_dato4.setVisible(true);
						lbl_dato5.setVisible(false);
						txt_dato4.setVisible(true);
						txt_dato5.setVisible(false);
						lbl_dato1.setText("Seccion");
						lbl_dato2.setText("Macizo");
						chckbxBisBoveda.setVisible(true);
						
						
						chckbxBisMasizo.setVisible(true);
						
						
						lbl_dato3.setText("Unidad");
						lbl_dato4.setText("N° de Sepultura");
						lbl_dato5.setText("Bis");

					}

					break;

				case 1:
					if ( cmb_item_sector.getSelectedIndex() == 3 ){
						txt_dato1.setVisible(true);
						lbl_dato1.setVisible(true);
						lbl_dato1.setText("Sepulturas");
						txt_dato2.setVisible(false);
						lbl_dato2.setVisible(false);
					}else{
						txt_dato1.setVisible(true);
						txt_dato2.setVisible(true);
						lbl_dato1.setVisible(true);
						lbl_dato2.setVisible(true);
						lbl_dato1.setText("Nicho");
						lbl_dato2.setText("Fila");
					}
					
					break;

				case 2:

					txt_dato1.setVisible(true);
					txt_dato2.setVisible(true);
					txt_dato3.setVisible(true);
					txt_dato4.setVisible(true);
					txt_dato5.setVisible(true);
					txt_dato6.setVisible(true);
					lbl_dato1.setVisible(true);
					lbl_dato2.setVisible(true);
					lbl_dato3.setVisible(true);
					lbl_dato4.setVisible(true);
					lbl_dato5.setVisible(true);
					lbl_dato6.setVisible(true);
					lbl_dato1.setText("Circ.");
					lbl_dato2.setText("Seccion");
					lbl_dato3.setText("MaCizo");
					lbl_dato4.setText("Parcela");
					lbl_dato5.setText("Fila");
					lbl_dato6.setText("Unidad");
					
					break;

				case 3:

					txt_dato1.setVisible(true);
					txt_dato2.setVisible(true);
					lbl_dato1.setVisible(true);
					lbl_dato2.setVisible(true);
					lbl_dato1.setText("Mueble");
					lbl_dato2.setText("Nicho");

					break;

				case 4:

					txt_dato1.setVisible(true);
					txt_dato2.setVisible(true);
					txt_dato3.setVisible(true);
					txt_dato4.setVisible(true);
					txt_dato5.setVisible(true);

					lbl_dato1.setVisible(true);
					lbl_dato2.setVisible(true);
					lbl_dato3.setVisible(true);
					lbl_dato4.setVisible(true);
					lbl_dato5.setVisible(true);

					lbl_dato1.setText("Circ.");
					lbl_dato2.setText("Seccion");
					lbl_dato3.setText("Masizo");
					lbl_dato4.setText("Parcela");
					lbl_dato5.setText("Unidad");
					chckbxBisBoveda.setVisible(true);
					
					break;

				}

			}

		});
		cmb_item_sector.setBounds(409, 168, 152, 20);
		getContentPane().add(cmb_item_sector);
		
		cmb_sector.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				cmb_item_sector.removeAllItems();

				switch (cmb_sector.getSelectedIndex()) {
				case 0:
					cmb_item_sector.insertItemAt("Sepultura", 0);
					cmb_item_sector.insertItemAt("Indigentes", 1);
					cmb_item_sector.setSelectedIndex(0);
					break;
				case 1:
					cmb_item_sector.insertItemAt("Palmeras Ataud", 0);
					cmb_item_sector.insertItemAt("Palmeras Cenizas", 1);
					cmb_item_sector.insertItemAt("Palmeras Restos O", 2);
					cmb_item_sector.insertItemAt("Palmeras Sep", 3);
					cmb_item_sector.setSelectedIndex(0);

					break;

				case 2:
					cmb_item_sector.insertItemAt("Nichos", 0);
					cmb_item_sector.setSelectedIndex(0);
					break;

				case 3:
					cmb_item_sector.insertItemAt("Cenizario", 0);
					cmb_item_sector.setSelectedIndex(0);
					break;
				case 4:
					cmb_item_sector.insertItemAt("Bóvedas", 0);
					cmb_item_sector.setSelectedIndex(0);
					break;

				}

			}

		});

		cmb_sector.setBounds(409, 107, 152, 20);
		cmb_sector.insertItemAt("Sepulturas", 0);
		cmb_sector.insertItemAt("Palmeras", 1);
		cmb_sector.insertItemAt("Nichera", 2);
		cmb_sector.insertItemAt("Cenizario", 3);
		cmb_sector.insertItemAt("Boveda", 4);

		getContentPane().add(cmb_sector);
		
		txt_dato1 = new JTextField();
		txt_dato1.setBounds(409, 217, 52, 20);
		txt_dato1.setVisible(true);
		txt_dato1.setColumns(10);
		getContentPane().add(txt_dato1);
		
		JLabel lbl_ubicacion = new JLabel("Ubicaci\u00F3n:");
		lbl_ubicacion.setBounds(409, 82, 109, 14);
		lbl_ubicacion.setVisible(true);
		getContentPane().add(lbl_ubicacion);
		
		JLabel lblLugar = new JLabel("Lugar:");
		lblLugar.setBounds(409, 138, 46, 14);
		lblLugar.setVisible(true);
		getContentPane().add(lblLugar);
		
		txt_dato2 = new JTextField();
		txt_dato2.setColumns(10);
		txt_dato2.setBounds(512, 217, 52, 20);
		txt_dato2.setVisible(true);
		getContentPane().add(txt_dato2);


		txt_dato3 = new JTextField();
		txt_dato3.setColumns(10);
		txt_dato3.setBounds(409, 261, 52, 20);
		txt_dato3.setVisible(true);
		getContentPane().add(txt_dato3);

		txt_dato4 = new JTextField();
		txt_dato4.setColumns(10);
		txt_dato4.setBounds(512, 261, 52, 20);
		txt_dato4.setVisible(true);
		getContentPane().add(txt_dato4);

		txt_dato5 = new JTextField();
		txt_dato5.setColumns(10);
		txt_dato5.setBounds(409, 308, 52, 20);
		txt_dato5.setVisible(true);
		getContentPane().add(txt_dato5);
		
		txt_dato6 = new JTextField();
		txt_dato6.setColumns(10);
		txt_dato6.setBounds(512, 308, 52, 20);
		txt_dato6.setVisible(true);
		getContentPane().add(txt_dato6);
		
		cal = Calendar.getInstance();
		cal.set(Calendar.ERA, GregorianCalendar.AD);
		java.util.Date date = new java.util.Date();
		cal.setTime(date);
		JCalendar jc = new JCalendar();		
		jc.setDecorationBackgroundVisible(false);
		jc.setCalendar(cal);
		jc.setBounds(178, 264, 216, 176);
		getContentPane().add(jc);
		
		JButton actualizarBoton = new JButton("Actualizar Cliente");
		actualizarBoton.setBounds(579, 150, 145, 23);
		getContentPane().add(actualizarBoton);
		

		nuevaUbicacionBoton.setEnabled(false);
		btnModif.setEnabled(false);
		actualizarBoton.setEnabled(false);
		
		
		botonLimpiar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				
				  txt_nombres.setText(""); 				 
				  txt_domicilio.setText("");
				  txt_dni_ocupante.setText("");
				  txt_email_familiar.setText("");
			      txt_cocheria.setText("");
				  txt_tel_familiar.setText("");
			      txt_dato1.setText("");
			      txt_dato2.setText("");
				  txt_dato3.setText("");
				  txt_dato4.setText("");
				  txt_dato5.setText("");
				 txt_dato6.setText("");
				 txt_nombre_familiar.setText("");
				 txt_dni.setText("");
				 txt_apellidos.setText("");
				 btnModif.setEnabled(false);
					cmb_sector.setVisible(true);
					cmb_item_sector.setVisible(true);
					lbl_ubicacion.setVisible(true);
					lblLugar.setVisible(true);
					//nuevaUbicacionBoton.setEnabled(true);
					btn_guardar.setEnabled(true);

					
					txt_dni_ocupante.setEnabled(true);
					txt_dni.setEnabled(true);
					
					Clientes cliente = new Clientes();
					cliente.setApellidos(txt_apellidos.getText());
					cliente.setNombres(txt_nombres.getText());
					
					cliente.setDni(txt_dni.getText());
					cliente.setDomicilio(txt_domicilio.getText());
					cliente.setNombre_familiar(txt_nombre_familiar.getText());
					cliente.setTelefono(txt_tel_familiar.getText());
					cliente.setCocheria(txt_cocheria.getText());
					cliente.setTipo_fallec(cmb_tipo_fall.getSelectedIndex());
					cliente.setEmail(txt_email_familiar.getText());
					
					
				/*	
					boolean nn = chckbxNn.isSelected();
					if(nn = true ) {
						txt_dni_ocupante.setEnabled(false);
						cliente.setDni_ocupante(cliente.colocardni());
					}
					else {
						cliente.setDni_ocupante(txt_dni_ocupante.getText());
					}
					*/
					cliente.setDni_ocupante(txt_dni_ocupante.getText());
					
					int day = jc.getDayChooser().getDay();
					int month = jc.getMonthChooser().getMonth();
					int year = jc.getYearChooser().getYear();
					date.setDate(day); date.setMonth(month); date.setYear(year);
					
								
					java.text.SimpleDateFormat sdf =
					     new java.text.SimpleDateFormat("yyyy-MM-dd");
					String currentTime =  date.getYear()+"-"+date.getMonth()+"-"+date.getDate();// sdf.format(date);
					
					cliente.setFecha_fallec(currentTime);
				 
				 
			}
			});  
			
		
		
		
		actualizarBoton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				
				btnModif.setEnabled(true);
				cmb_sector.setVisible(false);
				cmb_item_sector.setVisible(false);
				lbl_ubicacion.setVisible(false);
				lblLugar.setVisible(false);
				nuevaUbicacionBoton.setEnabled(false);
				

				
				txt_dni_ocupante.setEnabled(false);
				txt_dni.setEnabled(false);
				
				txt_dato1.setVisible(false);
				txt_dato2.setVisible(false);
				txt_dato3.setVisible(false);
				txt_dato4.setVisible(false);
				txt_dato5.setVisible(false);
				txt_dato6.setVisible(false);
				
				
			}

		});
		
		
		
		btn_guardar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				guardiarObciso();

				
				
				
				 Clientes cliente = new Clientes();
				cliente.setApellidos(txt_apellidos.getText());
				cliente.setNombres(txt_nombres.getText());
				
				cliente.setDni(txt_dni.getText());
				cliente.setDomicilio(txt_domicilio.getText());
				cliente.setNombre_familiar(txt_nombre_familiar.getText());
				cliente.setTelefono(txt_tel_familiar.getText());
				cliente.setCocheria(txt_cocheria.getText());
				cliente.setTipo_fallec(cmb_tipo_fall.getSelectedIndex());
				cliente.setEmail(txt_email_familiar.getText());
				
				
					cliente.setDni_ocupante(txt_dni_ocupante.getText());
				
				
				
				int day = jc.getDayChooser().getDay();
				int month = jc.getMonthChooser().getMonth();
				int year = jc.getYearChooser().getYear();
				date.setDate(day); date.setMonth(month); date.setYear(year);
				
							
				java.text.SimpleDateFormat sdf =
				     new java.text.SimpleDateFormat("yyyy-MM-dd");
				String currentTime =  date.getYear()+"-"+date.getMonth()+"-"+date.getDate();// sdf.format(date);
				
				cliente.setFecha_fallec(currentTime);

				

				switch (cmb_sector.getSelectedIndex()) {
				case 0:
					if (cmb_item_sector.getSelectedIndex() == 1) { // indigentes

						Clientes cliente2 = new Clientes();
						String seccion = txt_dato1.getText();
						String macizo = txt_dato2.getText();
						String sepultura= txt_dato3.getText();
						String inhumacion= txt_dato4.getText();
						String dni = cliente.getDni();
						boolean clienterep = cliente.existeCliente(dni);
						boolean ok = cliente2.verificarIndigentes(seccion, macizo,sepultura,  inhumacion);
						if (ok != true){
									if(clienterep != true){
							
						cliente.altaCliente();						
						cliente2.insertarIndigentes(seccion, macizo, sepultura, inhumacion);
						
						
							
							
						
						}
					
							else
								JOptionPane.showMessageDialog(
										   null,
										   "El cliente ya existe");
						
					}else
						JOptionPane.showMessageDialog(
								   null,
								   "Lugar ocupado");
					}
					
					if (cmb_item_sector.getSelectedIndex() == 0) {// Sepultura
						
						Clientes sepultura = new Clientes();
						String seccion = txt_dato1.getText();
						String macizo = txt_dato2.getText();
						boolean bismacizoi = chckbxBisMasizo.isSelected() ;
						String unidad = txt_dato3.getText();
						String numero = txt_dato4.getText();  //mal
						boolean bisi = chckbxBisBoveda.isSelected();
						String dni = cliente.getDni();
						String bis="";
						String bismacizo="";
						if(bisi == true)
							bis = "1";
						else
							bis = "0";
						if(bismacizoi == true)
							bismacizo = "1";
						else
							bismacizo = "0";
						
						
					  System.out.println(bis + bismacizo);
						
						boolean clienterep = cliente.existeCliente(dni);
						boolean ok = sepultura.verificarSepultura(seccion, macizo, bismacizo, unidad, numero, bis);
						if (ok != true){
							if(clienterep != true){
					
				cliente.altaCliente();						
				sepultura.insertarSepultura(seccion, macizo, bismacizo, unidad, numero, bis);
				
				}
			
					else
						JOptionPane.showMessageDialog(
								   null,
								   "El cliente ya existe");
				
			}else
				JOptionPane.showMessageDialog(
						   null,
						   "Lugar ocupado");
			}
					break;
				case 1:
					if (cmb_item_sector.getSelectedIndex() == 0) { // Palmeras A
						
						Clientes palmerasA = new Clientes();
						String nicho_a = txt_dato1.getText();
						String fila_a = txt_dato2.getText();
						boolean ok = palmerasA.verificarNewpalmerasA(nicho_a,fila_a);
						String dni = cliente.getDni();
						boolean clienterep = cliente.existeCliente(dni);
						
						if (ok != true){
							if(clienterep != true){
					
				cliente.altaCliente();						
				palmerasA.insertarPalmerasA(nicho_a, fila_a);
								}
			
					else
						JOptionPane.showMessageDialog(
								   null,
								   "El cliente ya existe");
				
			}else
				JOptionPane.showMessageDialog(
						   null,
						   "Lugar ocupado");
			}

					if (cmb_item_sector.getSelectedIndex() == 1) {// Palmeras C
						
						Clientes palmerasCe = new Clientes();
						String nicho_ce = txt_dato1.getText();
						String fila_ce = txt_dato2.getText();
						boolean ok = palmerasCe.VerificarPalmerasCe(nicho_ce,fila_ce);
						String dni = cliente.getDni();
						boolean clienterep = cliente.existeCliente(dni);
						
						if (ok != true){
							if(clienterep != true){
					
				cliente.altaCliente();						
				palmerasCe.insertarPalmerasCe(nicho_ce, fila_ce);
				
				}
			
					else
						JOptionPane.showMessageDialog(
								   null,
								   "El cliente ya existe");
				
			}else
				JOptionPane.showMessageDialog(
						   null,
						   "Lugar ocupado");
			}

					if (cmb_item_sector.getSelectedIndex() == 2) { // Palmeras
															// ro

						Clientes palmerasRo = new Clientes();
						String nicho_ro = txt_dato1.getText();
						String fila_ro = txt_dato2.getText();
						boolean ok = palmerasRo.verificarPalmerasRo(nicho_ro,fila_ro);
						String dni = cliente.getDni();
						boolean clienterep = cliente.existeCliente(dni);
						
						if (ok != true){
							if(clienterep != true){
					
				cliente.altaCliente();						
				palmerasRo.insertarPalmerasRo(nicho_ro, fila_ro);
				
				}
			
					else
						JOptionPane.showMessageDialog(
								   null,
								   "El cliente ya existe");
				
			}else
				JOptionPane.showMessageDialog(
						   null,
						   "Lugar ocupado");
			}


					if (cmb_item_sector.getSelectedIndex() == 3) {// Palmeras S

						Clientes palmerasS = new Clientes();						
						String sepulturaS = txt_dato1.getText();
						String dni = cliente.getDni();
						boolean ok =palmerasS.verificarPalmerasS(sepulturaS);
						boolean clienterep = cliente.existeCliente(dni);
			
						if (ok != true) {
							if(clienterep != true)
							{
								btn_guardar.setEnabled(true);
								cliente.altaCliente();
								palmerasS.insertarPalmeras_S(sepulturaS);
								
							}
							else {

								JOptionPane.showMessageDialog(
										   null,
										   "El cliente ya existe");
							}
						}
						else
							JOptionPane.showMessageDialog(
									   null,
									   "Lugar ocupado");
					
					}
					break;

				case 2:
					
					Clientes nichera = new Clientes();
					String Circ = txt_dato1.getText();
					String seccion = txt_dato2.getText();
					String macizo = txt_dato3.getText();
					String parcela = txt_dato4.getText();
					String fila = txt_dato5.getText();
					String unidad = txt_dato6.getText();
					String dni = nichera.getDni();
					boolean ok = nichera.verificarNichera(Circ,seccion, macizo, parcela,fila, unidad);
					boolean clienterep = cliente.existeCliente(dni);
					
					if (ok != true){
						if(clienterep != true){
				
			cliente.altaCliente();						
			nichera.insertarNichera(dni,Circ,seccion, macizo, parcela,fila, unidad);
			
			}
		
				else
					JOptionPane.showMessageDialog(
							   null,
							   "El cliente ya existe");
			
		}else
			JOptionPane.showMessageDialog(
					   null,
					   "Lugar ocupado");
		
					break;

				case 3:
					Clientes cenizario = new Clientes();
					String mueble = txt_dato1.getText();
					String nicho = txt_dato2.getText();
					boolean ok3 = cenizario.verificarCenizario(mueble, nicho);
					String dni2 = cliente.getDni();
					boolean clienterep1 = cliente.existeCliente(dni2);
					if (ok3 != true){
						if(clienterep1 != true){
				
			cliente.altaCliente();						
			cenizario.InsertarCenizario(mueble, nicho);
			
			}
		
				else
					JOptionPane.showMessageDialog(
							   null,
							   "El cliente ya existe");
			
		}else
			JOptionPane.showMessageDialog(
					   null,
					   "Lugar ocupado");

				case 4:
					
					Clientes boveda = new Clientes();
					String Circ_boveda = txt_dato1.getText();	
					String seccion_boveda = txt_dato2.getText();	
					String macizo_boveda = txt_dato3.getText();	
					String parcela_boveda = txt_dato4.getText();	
					boolean bisi = chckbxBisBoveda.isSelected();
					String unidad_boveda = txt_dato5.getText();	
					String dni4 = cliente.getDni();
					String bis="";
					if(bisi == true)
						bis = "1";
					else
						bis = "0";
					boolean clienterep2 = cliente.existeCliente(dni4);					
					boolean ok4 = boveda.verificarBovedas(Circ_boveda, seccion_boveda, macizo_boveda, parcela_boveda, bis, unidad_boveda);
					if (ok4 != true){
						if(clienterep2 != true){
				
			cliente.altaCliente();						
			boveda.insertarBovedas(Circ_boveda, seccion_boveda, macizo_boveda, parcela_boveda, bis, unidad_boveda);
			
			}
		
				else
					JOptionPane.showMessageDialog(
							   null,
							   "El cliente ya existe");
			
		}else
			JOptionPane.showMessageDialog(
					   null,
					   "Lugar ocupado");
				}
				
				 	
			
			}

		});

		// boton guardar ubicacion de cliente existentes
	
		nuevaUbicacionBoton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				
				
				 Clientes cliente = new Clientes();
				cliente.setApellidos(txt_apellidos.getText());
				cliente.setNombres(txt_nombres.getText());
				
				cliente.setDni(txt_dni.getText());
				cliente.setDomicilio(txt_domicilio.getText());
				cliente.setNombre_familiar(txt_nombre_familiar.getText());
				cliente.setTelefono(txt_tel_familiar.getText());
				cliente.setCocheria(txt_cocheria.getText());
				cliente.setTipo_fallec(cmb_tipo_fall.getSelectedIndex());
				cliente.setEmail(txt_email_familiar.getText());
				
				
					cliente.setDni_ocupante(txt_dni_ocupante.getText());
								
				
				
				int day = jc.getDayChooser().getDay();
				int month = jc.getMonthChooser().getMonth();
				int year = jc.getYearChooser().getYear();
				date.setDate(day); date.setMonth(month); date.setYear(year);
				
							
				java.text.SimpleDateFormat sdf =
				     new java.text.SimpleDateFormat("yyyy-MM-dd");
				String currentTime =  date.getYear()+"-"+date.getMonth()+"-"+date.getDate();// sdf.format(date);
				
				cliente.setFecha_fallec(currentTime);

				
				
				
				

				switch (cmb_sector.getSelectedIndex()) {
				case 0:
					if (cmb_item_sector.getSelectedIndex() == 1) { // indigentes

						
						
						Clientes cliente2 = new Clientes();
						String seccion = txt_dato1.getText();
						String macizo = txt_dato2.getText();
						String sepultura= txt_dato3.getText();
						String inhumacion= txt_dato4.getText();
						String dni =cliente.getDni();
						boolean ok = cliente2.verificarIndigentes(seccion, macizo,sepultura,  inhumacion);
						boolean mismodni = cliente.existeCliente(dni);
						if (ok == true && mismodni== true)
						{					
							
							JOptionPane.showMessageDialog(
									   null,
									 "no se puede cargar mismo dni con la misma ubicacion");
								
											
						}
					
							else {
								JOptionPane.showMessageDialog(
										   null,
										 "se cargo la ubicacion");
						cliente2.insertarIndigentesREP(dni, seccion, macizo, sepultura, inhumacion);	
						
						
					}}

					if (cmb_item_sector.getSelectedIndex() == 0) {// Sepultura
						
						Clientes sepultura = new Clientes();
						String seccion = txt_dato1.getText();
						String macizo = txt_dato2.getText();
						String bismacizo = chckbxBisMasizo.getActionCommand() ;
						String unidad = txt_dato3.getText();
						String numero = txt_dato4.getText();  //mal
						String bis = chckbxBisBoveda.getActionCommand() ;
						String dni =cliente.getDni();
						boolean mismodni = cliente.existeCliente(dni);
						boolean ok = sepultura.verificarSepultura(seccion, macizo, bismacizo, unidad, numero, bis);
						if (ok == true && mismodni== true){
						
							JOptionPane.showMessageDialog(
									   null,
									 "no se puede cargar mismo dni con la misma ubicacion");
								
			
							
						}
						else {
							JOptionPane.showMessageDialog(
									   null,
									 "se cargo la ubicacion");
					
						sepultura.insertarSepulturaREP(dni,seccion, macizo, bismacizo, unidad, numero, bis);
						
					}}
					break;
				case 1:
					if (cmb_item_sector.getSelectedIndex() == 0) { // Palmeras A

						Clientes palmerasA = new Clientes();
						String nicho_a = txt_dato1.getText();
						String fila_a = txt_dato2.getText();
						boolean ok = palmerasA.verificarNewpalmerasA(nicho_a,fila_a);
						String dni =cliente.getDni();
						boolean mismodni = cliente.existeCliente(dni);
						if (ok == true && mismodni== true) {
							JOptionPane.showMessageDialog(
									   null,
									 "no se puede cargar mismo dni con la misma ubicacion");
							
						}
						else {
						JOptionPane.showMessageDialog(
								   null,
								 "Carga ubicacion a cliente exixtente");
						
							palmerasA.insertarPalmerasARE(dni,nicho_a, fila_a);
							
					}}
					if (cmb_item_sector.getSelectedIndex() == 1) {// Palmeras C

						Clientes palmerasCe = new Clientes();
						String nicho_ce = txt_dato1.getText();
						String fila_ce = txt_dato2.getText();
						boolean ok = palmerasCe.VerificarPalmerasCe(nicho_ce,fila_ce);
						String dni =cliente.getDni();
						boolean mismodni = cliente.existeCliente(dni);
						if (ok == true && mismodni== true) {
							JOptionPane.showMessageDialog(
									   null,
									 "no se puede cargar mismo dni con la misma ubicacion");
							
						}
						else {
						JOptionPane.showMessageDialog(
								   null,
								 "Carga ubicacion a cliente exixtente");
						
							palmerasCe.insertarPalmerasCeRE(dni,nicho_ce, fila_ce);
							
					}}

					if (cmb_item_sector.getSelectedIndex() == 2) { // Palmeras
																	// ro

						Clientes palmerasRo = new Clientes();
						String nicho_ro = txt_dato1.getText();
						String fila_ro = txt_dato2.getText();
						boolean ok = palmerasRo.verificarPalmerasRo(nicho_ro,fila_ro);
						String dni =cliente.getDni();
						boolean mismodni = cliente.existeCliente(dni);
						if (ok == true && mismodni== true) {
							JOptionPane.showMessageDialog(
									   null,
									 "no se puede cargar mismo dni con la misma ubicacion");
							
						}
						else {
						JOptionPane.showMessageDialog(
								   null,
								 "Carga ubicacion a cliente exixtente");
						
							palmerasRo.insertarPalmerasRoRE(dni,nicho_ro, fila_ro);
							
					}
					}
					if (cmb_item_sector.getSelectedIndex() == 3) {// Palmeras S

						Clientes palmerasS = new Clientes();						
						String sepulturaS = txt_dato1.getText();
						boolean ok =palmerasS.verificarPalmerasS(sepulturaS);
						String dni =cliente.getDni();
						boolean mismodni = cliente.existeCliente(dni);
						System.out.println(ok );
						System.out.println(mismodni );
						
						if (ok == true && mismodni== true)
						{					
							JOptionPane.showMessageDialog(
									   null,
									 "no se puede cargar mismo dni con la misma ubicacion");
					System.out.println("ce inserto 2");
					
								
						}
					
							else {
								JOptionPane.showMessageDialog(
										   null,
										 "Carga ubicacion a cliente exixtente");
								
								palmerasS.insertarPalmeras_Srep(dni,sepulturaS);
								
					}}

					break;

				case 2:
					
					Clientes nichera = new Clientes();
					String Circ = txt_dato1.getText();
					String seccion = txt_dato1.getText();
					String macizo = txt_dato2.getText();
					String parcela = txt_dato3.getText();
					String fila = txt_dato4.getText();
					String unidad = txt_dato5.getText();
					boolean ok2 = nichera.verificarNichera(Circ,seccion, macizo, parcela,fila, unidad);
					String dni2 =cliente.getDni();
					boolean mismodni = cliente.existeCliente(dni2);
					if (ok2 == true && mismodni== true) {
					
						JOptionPane.showMessageDialog(
								   null,
								 "no se puede cargar mismo dni con la misma ubicacion");
					}
						else {
							nichera.insertarNicheraRE(dni2,Circ,seccion, macizo, parcela,fila, unidad);
							JOptionPane.showMessageDialog(
									   null,
									 "Carga ubicacion a cliente exixtente");
							
						}
							

					break;

				case 3:
					Clientes cenizario = new Clientes();
					String mueble = txt_dato1.getText();
					String nicho = txt_dato2.getText();
					boolean ok3 = cenizario.verificarCenizario(mueble, nicho);
					String dni3 =cliente.getDni();
					String dni32 =cliente.getDni_ocupante();
					boolean mismodni12 = cliente.existeCliente(dni32);
					boolean mismodni1 = cliente.existeCliente(dni3);
				       if(mismodni12 == true) {

						JOptionPane.showMessageDialog(
								   null,
								 "no se puede cargar dos ocupantes con el mismo dnir");
					}
						
						else {
							JOptionPane.showMessageDialog(
									   null,
									 "Carga ubicacion a cliente exixtente");
						cenizario.InsertarCenizarioRE(dni3,mueble, nicho);
						
						}
					break;

				case 4:

					Clientes boveda = new Clientes();
					String Circ_boveda = txt_dato1.getText();	
					String seccion_boveda = txt_dato2.getText();	
					String macizo_boveda = txt_dato3.getText();	
					String parcela_boveda = txt_dato4.getText();	
					String bis_boveda = txt_dato6.getText();	//bis, cambiar
					String unidad_boveda = txt_dato5.getText();	
					String dni4 =cliente.getDni();
					boolean mismodni2 = cliente.existeCliente(dni4);
					boolean ok4 = boveda.verificarBovedas(Circ_boveda, seccion_boveda, macizo_boveda, parcela_boveda, bis_boveda, unidad_boveda);
					if (ok4 == true && mismodni2== true) {
						
						JOptionPane.showMessageDialog(
								   null,
								 "no se puede cargar mismo dni con la misma ubicacion");
					}
			
					else {
						JOptionPane.showMessageDialog(
								   null,
								 "Carga ubicacion a cliente exixtente");
					boveda.insertarBovedasRE(dni4,Circ_boveda, seccion_boveda, macizo_boveda, parcela_boveda, bis_boveda, unidad_boveda);
					
					break;
					}
				}
				
				 	
			
			}

		});
		// boton modificar
		
		btnModif.addActionListener(new ActionListener() {

	
			public void actionPerformed(ActionEvent e) {

				
			 Clientes cliente = new Clientes();
			cliente.setApellidos(txt_apellidos.getText());
			cliente.setNombres(txt_nombres.getText());
			
			cliente.setDni(txt_dni.getText());
			cliente.setDomicilio(txt_domicilio.getText());
			cliente.setNombre_familiar(txt_nombre_familiar.getText());
			cliente.setTelefono(txt_tel_familiar.getText());
			cliente.setCocheria(txt_cocheria.getText());
			cliente.setTipo_fallec(cmb_tipo_fall.getSelectedIndex());
			cliente.setEmail(txt_email_familiar.getText());
			cliente.setDni_ocupante(txt_dni_ocupante.getText());
			
			int day = jc.getDayChooser().getDay();
			int month = jc.getMonthChooser().getMonth();
			int year = jc.getYearChooser().getYear();
			date.setDate(day); date.setMonth(month); date.setYear(year);
			
						
			java.text.SimpleDateFormat sdf =
			     new java.text.SimpleDateFormat("yyyy-MM-dd");
			String currentTime =  date.getYear()+"-"+date.getMonth()+"-"+date.getDate();// sdf.format(date);
			
			cliente.setFecha_fallec(currentTime);
			cliente.modificarCliente();
			

	/*		switch (cmb_sector.getSelectedIndex()) {
			case 0:
				if (cmb_item_sector.getSelectedIndex() == 1) { // indigentes
					
					Clientes cliente2 = new Clientes();
					String seccion = txt_dato1.getText();
					String macizo = txt_dato2.getText();
					String sepultura= txt_dato3.getText();
					String inhumacion= txt_dato4.getText();
					String dni = cliente.getDni();
					boolean clienterep = cliente.existeCliente(dni);
					boolean ok = cliente2.verificarIndigentes(seccion, macizo,sepultura,  inhumacion);
					if (ok != true){
								if(clienterep == true){
						
					cliente.modificarCliente();						
					cliente2.insertarIndigentes(seccion, macizo, sepultura, inhumacion);						
					}
				
						else
							JOptionPane.showMessageDialog(
									   null,
									   "El cliente no existe");
					
				}else
					JOptionPane.showMessageDialog(
							   null,
							   "Lugar ocupado");
				}
				
				if (cmb_item_sector.getSelectedIndex() == 0) {// Sepultura
					
					Clientes sepultura = new Clientes();
					String seccion = txt_dato1.getText();
					String macizo = txt_dato2.getText();
					String bismacizo = chckbxBisMasizo.getActionCommand() ;
					String unidad = txt_dato3.getText();
					String numero = txt_dato4.getText();  //mal
					String bis = chckbxBisBoveda.getActionCommand() ;
					String dni = cliente.getDni();
					boolean clienterep = cliente.existeCliente(dni);
					boolean ok = sepultura.verificarSepultura(seccion, macizo, bismacizo, unidad, numero, bis);
					if (ok != true){
						if(clienterep == true){
				
			cliente.modificarCliente();						
			sepultura.insertarSepultura(seccion, macizo, bismacizo, unidad, numero, bis);
			}
		
				else
					JOptionPane.showMessageDialog(
							   null,
							   "El cliente no existe");
			
		}else
			JOptionPane.showMessageDialog(
					   null,
					   "Lugar ocupado");
		}
				break;
			case 1:
				if (cmb_item_sector.getSelectedIndex() == 0) { // Palmeras A
					
					Clientes palmerasA = new Clientes();
					String nicho_a = txt_dato1.getText();
					String fila_a = txt_dato2.getText();
					boolean ok = palmerasA.verificarNewpalmerasA(nicho_a,fila_a);
					String dni = cliente.getDni();
					boolean clienterep = cliente.existeCliente(dni);
					
					if (ok != true){
						
				
			cliente.modificarCliente();						
			palmerasA.insertarPalmerasARE(dni, nicho_a, fila_a);
		
			
		}else
			JOptionPane.showMessageDialog(
					   null,
					   "Lugar ocupado");
		}

				if (cmb_item_sector.getSelectedIndex() == 1) {// Palmeras C
					
					Clientes palmerasCe = new Clientes();
					String nicho_ce = txt_dato1.getText();
					String fila_ce = txt_dato2.getText();
					boolean ok = palmerasCe.VerificarPalmerasCe(nicho_ce,fila_ce);
					String dni = cliente.getDni();
					boolean clienterep = cliente.existeCliente(dni);
					
					if (ok != true){
						if(clienterep == true){
				
			cliente.modificarCliente();							
			palmerasCe.insertarPalmerasCe(nicho_ce, fila_ce);
			}
		
				else
					JOptionPane.showMessageDialog(
							   null,
							   "El cliente no existe");
			
		}else
			JOptionPane.showMessageDialog(
					   null,
					   "Lugar ocupado");
		}

				if (cmb_item_sector.getSelectedIndex() == 2) { // Palmeras
														// ro

					Clientes palmerasRo = new Clientes();
					String nicho_ro = txt_dato1.getText();
					String fila_ro = txt_dato2.getText();
					boolean ok = palmerasRo.verificarPalmerasRo(nicho_ro,fila_ro);
					String dni = cliente.getDni();
					boolean clienterep = cliente.existeCliente(dni);
					
					if (ok != true){
						if(clienterep == true){
				
			cliente.modificarCliente();						
			palmerasRo.insertarPalmerasRo(nicho_ro, fila_ro);
			}
		
				else
					JOptionPane.showMessageDialog(
							   null,
							   "El cliente no existe");
			
		}else
			JOptionPane.showMessageDialog(
					   null,
					   "Lugar ocupado");
		}


				if (cmb_item_sector.getSelectedIndex() == 3) {// Palmeras S

					Clientes palmerasS = new Clientes();						
					String sepulturaS = txt_dato1.getText();
					String dni = cliente.getDni();
					boolean ok =palmerasS.verificarPalmerasS(sepulturaS);
					boolean clienterep = cliente.existeCliente(dni);
		
					if (ok != true) {
						if(clienterep == true)
						{
							
							cliente.modificarCliente();	
							palmerasS.insertarPalmeras_S(sepulturaS);
						}
						else {

							JOptionPane.showMessageDialog(
									   null,
									   "El cliente no existe");
						}
					}
					else
						JOptionPane.showMessageDialog(
								   null,
								   "Lugar ocupado");
				
				}
				break;

			case 2:
				
				Clientes nichera = new Clientes();
				String Circ = txt_dato1.getText();
				String seccion = txt_dato2.getText();
				String macizo = txt_dato3.getText();
				String parcela = txt_dato3.getText();
				String fila = txt_dato4.getText();
				String unidad = txt_dato5.getText();
				String dni = nichera.getDni();
				boolean ok = nichera.verificarNichera(Circ,seccion, macizo, parcela,fila, unidad);
				boolean clienterep = cliente.existeCliente(dni);
				
				if (ok != true){
					if(clienterep == true){
			
		cliente.modificarCliente();						
		nichera.insertarNichera(dni,Circ,seccion, macizo, parcela,fila, unidad);
		}
	
			else
				JOptionPane.showMessageDialog(
						   null,
						   "El cliente no existe");
		
	}else
		JOptionPane.showMessageDialog(
				   null,
				   "Lugar ocupado");
	
				break;

			case 3:
				Clientes cenizario = new Clientes();
				String mueble = txt_dato1.getText();
				String nicho = txt_dato2.getText();
				boolean ok3 = cenizario.verificarCenizario(mueble, nicho);
				String dni2 = cliente.getDni();
				boolean clienterep1 = cliente.existeCliente(dni2);
				if (ok3 != true){
					
			
						cliente.modificarCliente();							
						cenizario.InsertarCenizario(mueble, nicho);
		
		
				}else
					JOptionPane.showMessageDialog(
							null,
							"Lugar ocupado");

			case 4:
				
				Clientes boveda = new Clientes();
				String Circ_boveda = txt_dato1.getText();	
				String seccion_boveda = txt_dato2.getText();	
				String macizo_boveda = txt_dato3.getText();	
				String parcela_boveda = txt_dato4.getText();	
				String bis_boveda = txt_dato6.getText();	//bis, cambiar
				String unidad_boveda = txt_dato5.getText();	
				String dni4 = cliente.getDni();
				boolean clienterep2 = cliente.existeCliente(dni4);
				
				boolean ok4 = boveda.verificarBovedas(Circ_boveda, seccion_boveda, macizo_boveda, parcela_boveda, bis_boveda, unidad_boveda);
				if (ok4 != true){
					if(clienterep2 == true){
			
		cliente.modificarCliente();							
		boveda.insertarBovedas(Circ_boveda, seccion_boveda, macizo_boveda, parcela_boveda, bis_boveda, unidad_boveda);
		}
	
			else
				JOptionPane.showMessageDialog(
						   null,
						   "El cliente no existe");
		
	}else
		JOptionPane.showMessageDialog(
				   null,
				   "Lugar ocupado");
			}
			
			 	
		*/
		}

	});
		
		
		
		
		
		
		
		
		
		
		
		btn_guardar.setBounds(409, 346, 162, 24);

		getContentPane().add(btn_guardar);
		
		JLabel lbl_nombrefam = new JLabel("Nombre Familiar");
		lbl_nombrefam.setBounds(36, 143, 132, 14);
		getContentPane().add(lbl_nombrefam);
		
		txt_nombre_familiar = new JTextField();
		txt_nombre_familiar.setColumns(10);
		txt_nombre_familiar.setBounds(178, 140, 203, 20);
		getContentPane().add(txt_nombre_familiar);
		
		
		Buscar_cliente bc = new Buscar_cliente(this, true);
		JButton btnBuscarCliente = new JButton("ClientesExistentes");
		btnBuscarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			
				
				btn_guardar.setEnabled(false);
				bc.showCliente();
				
				bc.setFocusableWindowState(true);
				
				bc.addWindowListener(null); 
				
				resultado = bc.getCliente();
												
				if (!resultado.equals(null)){
					cmb_sector.setVisible(true);
					cmb_item_sector.setVisible(true);
					lblLugar.setVisible(true);
					lbl_ubicacion.setVisible(true);
					//nuevaUbicacionBoton.setEnabled(true);
					//btnModif.setEnabled(true);
					actualizarBoton.setEnabled(true);
				}
			}
		});
		btnBuscarCliente.setBounds(579, 105, 145, 24);
		getContentPane().add(btnBuscarCliente);
		
		

		
		
		
		
		
		
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txt_apellidos, txt_nombres, txt_dni, txt_domicilio, txt_nombre_familiar, txt_dni_ocupante, txt_email_familiar, txt_tel_familiar, jc, cmb_tipo_fall, txt_cocheria, jc.getMonthChooser(), jc.getMonthChooser().getSpinner(), jc.getMonthChooser().getComboBox(), jc.getYearChooser(), txt_dato1, txt_dato2, txt_dato3, txt_dato4, txt_dato5, txt_dato6}));
		
		
		
	}
	
	public void setClient(Clientes cli){
		
		txt_apellidos.setText(cli.getApellidos());
		txt_nombres.setText(cli.getNombres());
		txt_dni.setText(cli.getDni());
		txt_domicilio.setText(cli.getDomicilio());
		txt_dni_ocupante.setText(cli.getDni_ocupante());
		txt_email_familiar.setText(cli.getEmail());
		txt_cocheria.setText(cli.getCocheria());
		txt_tel_familiar.setText(cli.getTelefono());
		txt_nombre_familiar.setText(cli.getNombre_familiar());
		
		this.repaint();
		
	}


	public void guardiarObciso() {
		String nombre = txt_nombres.getText();
		String apellido = "Apellido harcodeado";
		String cocheria = txt_cocheria.getText();
		String dni = txt_dni.getText();
		Integer tipoFallecimiento = cmb_tipo_fall.getSelectedIndex(); 
		Date fechaFallecimiento = new Date(cal.getTime().getTime()); 		

		//Recepcion.guardarObciso(tipoFallecimiento, dni, nombre, apellido, cocheria, fechaFallecimiento);
		
	}







}