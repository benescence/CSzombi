package clientes;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;

import javax.swing.JTextField;

import javax.swing.JComboBox;

import javax.swing.JButton;

import java.awt.SystemColor;


import java.util.Calendar;
import java.util.GregorianCalendar;
import com.toedter.calendar.JCalendar;

import logica.Clientes;

import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;

import java.awt.event.ItemListener;

import java.awt.event.ItemEvent;
import javax.swing.JCheckBox;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;


public class Alta_clientes extends JInternalFrame {

	private JTextField txt_apellidos =  new JTextField();;
	private JTextField txt_nombres;
	private JTextField txt_dni;
	private JTextField txt_domicilio;
	private JTextField txt_dom_familiar;
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

		JLabel lblContrasea = new JLabel("DNI");
		lblContrasea.setBounds(36, 82, 132, 14);
		getContentPane().add(lblContrasea);

		
		txt_apellidos.setBounds(178, 21, 203, 20);
		getContentPane().add(txt_apellidos);
		txt_apellidos.setColumns(10);
		
		txt_nombres = new JTextField();
		txt_nombres.setColumns(10);
		txt_nombres.setBounds(178, 49, 203, 20);

		getContentPane().add(txt_nombres);
		
		JLabel lblNivelDePermisos = new JLabel("Tipo de fallecimiento");
		lblNivelDePermisos.setBounds(409, 24, 132, 14);
		getContentPane().add(lblNivelDePermisos);

		JComboBox cmb_tipo_fall = new JComboBox();
		cmb_tipo_fall.setBounds(533, 21, 165, 20);
		cmb_tipo_fall.insertItemAt("Traumatico", 0);
		cmb_tipo_fall.insertItemAt("No traumatico", 1);
		getContentPane().add(cmb_tipo_fall);
		

		JLabel lblDomicilio = new JLabel("Domicilio");
		lblDomicilio.setBounds(36, 110, 132, 14);
		getContentPane().add(lblDomicilio);

		txt_dni = new JTextField();
		txt_dni.setColumns(10);
		txt_dni.setBounds(178, 79, 203, 20);
		getContentPane().add(txt_dni);

		txt_domicilio = new JTextField();
		txt_domicilio.setColumns(10);
		txt_domicilio.setBounds(178, 107, 203, 20);

		getContentPane().add(txt_domicilio);
		JLabel lblDomicilioFamiliar = new JLabel("Domicilio Familiar");
		lblDomicilioFamiliar.setBounds(36, 171, 132, 14);
		getContentPane().add(lblDomicilioFamiliar);

		txt_dom_familiar = new JTextField();
		txt_dom_familiar.setColumns(10);
		txt_dom_familiar.setBounds(178, 168, 203, 20);
		getContentPane().add(txt_dom_familiar);
		
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
		lbl_dato1.setBounds(448, 260, 72, 14);
		lbl_dato1.setVisible(false);
		getContentPane().add(lbl_dato1);

		JLabel lbl_dato2 = new JLabel("");
		lbl_dato2.setBounds(549, 260, 75, 14);
		lbl_dato2.setVisible(false);
		getContentPane().add(lbl_dato2);

		JLabel lbl_dato3 = new JLabel("");

		lbl_dato3.setBounds(448, 308, 72, 14);
		lbl_dato3.setVisible(false);
		getContentPane().add(lbl_dato3);
		
		JLabel lbl_dato4 = new JLabel("");
		lbl_dato4.setBounds(549, 308, 96, 14);
		lbl_dato4.setVisible(false);
		getContentPane().add(lbl_dato4);

		JLabel lbl_dato5 = new JLabel("");
		lbl_dato5.setBounds(451, 356, 69, 14);
		lbl_dato5.setVisible(false);
		getContentPane().add(lbl_dato5);
		
		JLabel lbl_dato6 = new JLabel("");
		lbl_dato6.setBounds(549, 356, 69, 14);
		lbl_dato6.setVisible(false);
		getContentPane().add(lbl_dato6);
		
		JCheckBox chckbxBisBoveda = new JCheckBox("Bis");
		chckbxBisBoveda.setBackground(SystemColor.inactiveCaptionBorder);
		chckbxBisBoveda.setBounds(633, 328, 52, 23);
		chckbxBisBoveda.setVisible(false);
		getContentPane().add(chckbxBisBoveda);
		
//		JCheckBox chckbxBisMasizo = new JCheckBox("Bis");
//		chckbxBisMasizo.setBackground(SystemColor.inactiveCaptionBorder);
//		chckbxBisMasizo.setBounds(654, 255, 52, 23);
//		chckbxBisMasizo.setVisible(false);
//		getContentPane().add(chckbxBisMasizo);
//		

		JComboBox<String> cmb_sector = new JComboBox<String>();
		cmb_sector.setVisible(false);
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

			}

		});

		JComboBox<String> cmb_item_sector = new JComboBox<String>();
		cmb_item_sector.setVisible(false);
		cmb_item_sector.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
//				cmb_item_sector.removeAll();
				switch (cmb_sector.getSelectedIndex()) {

				case 0:
					txt_dato1.setVisible(true);
					txt_dato2.setVisible(true);
					txt_dato3.setVisible(true);
					
					lbl_dato1.setVisible(true);
					lbl_dato2.setVisible(true);
					lbl_dato3.setVisible(true);


					if (cmb_item_sector.getSelectedIndex() == 1) {

						lbl_dato4.setVisible(true);
						txt_dato4.setVisible(true);
						lbl_dato1.setText("Seccion");
						lbl_dato2.setText("Masizo");
						lbl_dato3.setText("Sepultura");
						lbl_dato4.setText("Lote");
						System.out.println("sepultura C4"+cmb_item_sector.getSelectedIndex());

					} else {
						System.out.println("sepultura"+cmb_item_sector.getSelectedIndex());
						lbl_dato4.setVisible(true);
						lbl_dato5.setVisible(true);
						txt_dato4.setVisible(true);
						txt_dato5.setVisible(true);
						lbl_dato1.setText("Seccion");
						lbl_dato2.setText("Macizo");
						chckbxBisBoveda.setVisible(true);
						chckbxBisBoveda.setBounds(654, 255, 52, 23);
						
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
					lbl_dato1.setText("Sirc.");
					lbl_dato2.setText("Seccion");
					lbl_dato3.setText("Masizo");
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

//					txt_dato1.setVisible(true);
//					lbl_dato1.setVisible(true);
//					lbl_dato1.setText("Unidad");
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

					lbl_dato1.setText("Sirc.");
					lbl_dato2.setText("Seccion");
					lbl_dato3.setText("Masizo");
					lbl_dato4.setText("Parcela");
					lbl_dato5.setText("Unidad");
					chckbxBisBoveda.setVisible(true);
					chckbxBisBoveda.setBounds(654, 305, 52, 23);
					break;

				}

			}

		});
		cmb_item_sector.setBounds(448, 229, 176, 20);
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
					cmb_item_sector.insertItemAt("Palmeras A", 0);
					cmb_item_sector.insertItemAt("Palmeras C", 1);
					cmb_item_sector.insertItemAt("Palmeras RO", 2);
					cmb_item_sector.insertItemAt("Palmeras S", 3);
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

		cmb_sector.setBounds(448, 168, 176, 20);
		cmb_sector.insertItemAt("Sepulturas", 0);
		cmb_sector.insertItemAt("Palmeras", 1);
		cmb_sector.insertItemAt("Nichera", 2);
		cmb_sector.insertItemAt("Cenizario", 3);
		cmb_sector.insertItemAt("Boveda", 4);

		getContentPane().add(cmb_sector);
		txt_dato1 = new JTextField();
		txt_dato1.setBounds(450, 281, 76, 20);
		txt_dato1.setVisible(false);
		txt_dato1.setColumns(10);
		
		getContentPane().add(txt_dato1);
		
		JLabel lbl_ubicacion = new JLabel("Ubicaci\u00F3n:");
		lbl_ubicacion.setBounds(448, 146, 109, 14);
		lbl_ubicacion.setVisible(false);
		getContentPane().add(lbl_ubicacion);
		
		JLabel lblLugar = new JLabel("Lugar:");
		lblLugar.setBounds(448, 204, 46, 14);
		lblLugar.setVisible(false);
		getContentPane().add(lblLugar);
		
		txt_dato2 = new JTextField();
		txt_dato2.setColumns(10);
		txt_dato2.setBounds(548, 281, 76, 20);
		txt_dato2.setVisible(false);
		getContentPane().add(txt_dato2);

		JButton btn_verificar = new JButton("Guardar Ubicacion");
		btn_verificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (cmb_sector.getSelectedIndex()) {
				case 0:
					if (cmb_item_sector.getSelectedIndex() == 1) { // seccion 4

						Clientes cliente = new Clientes();
						String adulto = txt_dato1.getText();
						String angelito = txt_dato2.getText();
						String inhumacion= txt_dato3.getText();
						boolean ok = cliente.verificarAdultoSeccionC4(adulto, angelito, inhumacion);
						if (ok == true)
							btn_guardar.setEnabled(true);
							else
								JOptionPane.showMessageDialog(
										   null,
										   "Lugar ocupado");
							
						
					}

					if (cmb_item_sector.getSelectedIndex() == 0) {// Sepultura

						
						Clientes sepultura = new Clientes();
						String seccion = txt_dato1.getText();
						String masizo = txt_dato2.getText();
						String lote = txt_dato3.getText();
						String unidad = txt_dato4.getText();
						String bis = txt_dato5.getText();
						
						boolean ok = sepultura.verificarSepultura(seccion, masizo, lote, unidad,bis);
						if (ok == true)
							btn_guardar.setEnabled(true);
							else
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
						boolean ok = palmerasA.verificarPalmerasA(nicho_a,fila_a);
						if (ok == true)
							btn_guardar.setEnabled(true);
							else
								JOptionPane.showMessageDialog(
										   null,
										   "Lugar ocupado");

					}

					if (cmb_item_sector.getSelectedIndex() == 1) {// Palmeras C

						Clientes palmerasCe = new Clientes();
						String nicho_ce = txt_dato1.getText();
						String fila_ce = txt_dato2.getText();
						boolean ok = palmerasCe.verificarPalmerasCe(nicho_ce,fila_ce);
						if (ok == true)
							btn_guardar.setEnabled(true);
							else
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
						if (ok == true)
							btn_guardar.setEnabled(true);
							else
								JOptionPane.showMessageDialog(
										   null,
										   "Lugar ocupado");
						

					}

					if (cmb_item_sector.getSelectedIndex() == 3) {// Palmeras S

						Clientes palmerasS = new Clientes();						
						String sepulturaS = txt_dato1.getText();
						boolean ok =palmerasS.verificarPalmerasS(sepulturaS);
						if (ok == true)
						btn_guardar.setEnabled(true);
						else
							JOptionPane.showMessageDialog(
									   null,
									   "Lugar ocupado");
					}

					break;

				case 2:
					
					Clientes nichera = new Clientes();
					String seccion = txt_dato1.getText();
					String macizo = txt_dato2.getText();
					String par = txt_dato3.getText();
					String fila = txt_dato4.getText();
					String unidad = txt_dato5.getText();
					
					boolean ok2 = nichera.verificarNichera(seccion, macizo, par,fila, unidad);
					if (ok2 == true)
						btn_guardar.setEnabled(true);
						else
							JOptionPane.showMessageDialog(
									   null,
									   "Lugar ocupado");

					break;

				case 3:
					Clientes cenizario = new Clientes();
					String mueble = txt_dato1.getText();
					String nicho = txt_dato2.getText();
					boolean ok3 = cenizario.verificarCenizario(mueble, nicho);
					if (ok3 == true)
						btn_guardar.setEnabled(true);
						else
							JOptionPane.showMessageDialog(
									   null,
									   "Lugar ocupado");
					
					break;

				case 4:

					Clientes boveda = new Clientes();
					String unidad_boveda = txt_dato1.getText();					
					boolean ok4 = boveda.verificarBovedas(unidad_boveda);
					if (ok4 == true)
					btn_guardar.setEnabled(true);
					else
						JOptionPane.showMessageDialog(
								   null,
								   "Lugar ocupado");
					break;

				}

			}

		});

		btn_verificar.setBounds(538, 407, 160, 23);

		getContentPane().add(btn_verificar);

		txt_dato3 = new JTextField();
		txt_dato3.setColumns(10);
		txt_dato3.setBounds(450, 329, 76, 20);
		txt_dato3.setVisible(false);
		getContentPane().add(txt_dato3);

		txt_dato4 = new JTextField();
		txt_dato4.setColumns(10);
		txt_dato4.setBounds(548, 329, 76, 20);
		txt_dato4.setVisible(false);
		getContentPane().add(txt_dato4);

		txt_dato5 = new JTextField();
		txt_dato5.setColumns(10);
		txt_dato5.setBounds(450, 377, 76, 20);
		txt_dato5.setVisible(false);
		getContentPane().add(txt_dato5);
		
		txt_dato6 = new JTextField();
		txt_dato6.setColumns(10);
		txt_dato6.setBounds(548, 377, 76, 20);
		txt_dato6.setVisible(false);
		getContentPane().add(txt_dato6);
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.ERA, GregorianCalendar.AD);
		java.util.Date date = new java.util.Date();
		cal.setTime(date);
		JCalendar jc = new JCalendar();		
		jc.setDecorationBackgroundVisible(false);
		jc.setCalendar(cal);
		jc.setBounds(178, 264, 216, 176);
		getContentPane().add(jc);

		btn_guardar.addActionListener(new ActionListener() {

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
				cliente.setDireccion_familiar(txt_dom_familiar.getText());
				
				int day = jc.getDayChooser().getDay();
				int month = jc.getMonthChooser().getMonth();
				int year = jc.getYearChooser().getYear();
				date.setDate(day); date.setMonth(month); date.setYear(year);
				
							
				System.out.println("date time" +date.getYear());
				System.out.println("date time month" +date.getMonth());
				System.out.println("date time year" +date.getYear());
				java.text.SimpleDateFormat sdf =
				     new java.text.SimpleDateFormat("yyyy-MM-dd");
				String currentTime =  date.getYear()+"-"+date.getMonth()+"-"+date.getDate();// sdf.format(date);
				
				cliente.setFecha_fallec(currentTime);

				cliente.altaCliente();			

			}

		});

		btn_guardar.setBounds(409, 105, 162, 24);

		getContentPane().add(btn_guardar);
		
		JLabel lbl_nombrefam = new JLabel("Nombre Familiar");
		lbl_nombrefam.setBounds(36, 143, 132, 14);
		getContentPane().add(lbl_nombrefam);
		
		txt_nombre_familiar = new JTextField();
		txt_nombre_familiar.setColumns(10);
		txt_nombre_familiar.setBounds(178, 140, 203, 20);
		getContentPane().add(txt_nombre_familiar);
		
		
		Buscar_cliente bc = new Buscar_cliente(this, true);
		JButton btnBuscarCliente = new JButton("Buscar Cliente");
		btnBuscarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				bc.showCliente();
//				Buscar_cliente bc = new Buscar_cliente();
				
				bc.setFocusableWindowState(true);
				
				bc.addWindowListener(null); 
				
				resultado = bc.getCliente();
												
				if (!resultado.equals(null)){
					System.out.println("--->"+resultado.getApellidos()+"result");
					System.out.println("telefono es "+resultado.getTelefono());
					cmb_sector.setVisible(true);
					cmb_item_sector.setVisible(true);
					lblLugar.setVisible(true);
					lbl_ubicacion.setVisible(true);
				}
			}
		});
		btnBuscarCliente.setBounds(581, 105, 117, 24);
		getContentPane().add(btnBuscarCliente);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txt_apellidos, txt_nombres, txt_dni, txt_domicilio, txt_nombre_familiar, txt_dom_familiar, txt_email_familiar, txt_tel_familiar, jc, cmb_tipo_fall, txt_cocheria, jc.getMonthChooser(), jc.getMonthChooser().getSpinner(), jc.getMonthChooser().getComboBox(), jc.getYearChooser(), txt_dato1, txt_dato2, txt_dato3, txt_dato4, txt_dato5, txt_dato6}));
		
		
		
	}
	
	public void setClient(Clientes cli){
		
		txt_apellidos.setText(cli.getApellidos());
		txt_nombres.setText(cli.getNombres());
		txt_dni.setText(cli.getDni());
		txt_domicilio.setText(cli.getDomicilio());
		txt_dom_familiar.setText(cli.getDireccion_familiar());
		txt_email_familiar.setText(cli.getEmail());
		txt_cocheria.setText(cli.getCocheria());
		txt_tel_familiar.setText(cli.getTelefono());
		txt_nombre_familiar.setText(cli.getNombre_familiar());
		
		this.repaint();
		
	}
	
}