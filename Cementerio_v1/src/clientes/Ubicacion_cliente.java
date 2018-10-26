package clientes;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import javax.swing.JLabel;

import java.awt.BorderLayout;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.SystemColor;


import java.util.Calendar;
import java.util.GregorianCalendar;
import com.toedter.calendar.JCalendar;

import logica.Clientes;

import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;

import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ItemEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;


public class Ubicacion_cliente extends JInternalFrame {
	private JTextField txt_dato1;
	private JTextField txt_dato2;
	private JTextField txt_dato3;
	private JTextField txt_dato4;
	private JTextField txt_dato5;
	private JTextField txt_dato6;
	private JTable table;
	private JScrollPane scrollPane;
	private DefaultTableModel modelo;
	private Clientes cliente; 
	
	
	
	/**
	 * 
	 * Launch the application.
	 * 
	 */

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {

				try {

					Ubicacion_cliente frame = new Ubicacion_cliente();

					frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
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

	public Ubicacion_cliente() {
		getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		setBorder(null);

		
		setBounds(0, 0, 900, 600);
		getContentPane().setLayout(null);
		setTitle("Ubicacion");
		
		JLabel lbl_dato1 = new JLabel("");
		lbl_dato1.setBounds(21, 81, 72, 14);
		lbl_dato1.setVisible(false);
		getContentPane().add(lbl_dato1);

		JLabel lbl_dato2 = new JLabel("");
		lbl_dato2.setBounds(122, 81, 75, 14);
		lbl_dato2.setVisible(false);
		getContentPane().add(lbl_dato2);

		JLabel lbl_dato3 = new JLabel("");

		lbl_dato3.setBounds(21, 129, 72, 14);
		lbl_dato3.setVisible(false);
		getContentPane().add(lbl_dato3);
		
		JLabel lbl_dato4 = new JLabel("");
		lbl_dato4.setBounds(122, 129, 75, 14);
		lbl_dato4.setVisible(false);
		getContentPane().add(lbl_dato4);

		JLabel lbl_dato5 = new JLabel("");
		lbl_dato5.setBounds(24, 177, 69, 14);
		lbl_dato5.setVisible(false);
		getContentPane().add(lbl_dato5);

		JLabel lbl_dato6 = new JLabel("");
		lbl_dato6.setBounds(570, 333, 69, 14);
		lbl_dato6.setVisible(false);
		getContentPane().add(lbl_dato6);
		
		JCheckBox chckbxBisBoveda = new JCheckBox("Bis");
		chckbxBisBoveda.setBackground(SystemColor.inactiveCaptionBorder);
		chckbxBisBoveda.setBounds(203, 101, 52, 23);
		chckbxBisBoveda.setVisible(false);
		getContentPane().add(chckbxBisBoveda);
		
		table = new JTable();
		table.setBounds(33, 247, 663, 121);
		getContentPane().add(table);
		
		 modelo = new DefaultTableModel();
		 modelo =  (new DefaultTableModel(
				 null, new String [] {
						 "Apellido", "Nombre",
						 "DNI",  "Domicilio", "Fecha", 
						 "Domiclio Familiar", "Telefono", 
						 "Email","Cocheria"}){
						 Class[] types = new Class [] {
						 java.lang.String.class,
						 java.lang.String.class,
						 java.lang.String.class,
						 java.lang.String.class,
						 java.lang.String.class,
						 java.lang.String.class,
						 java.lang.String.class,
						 java.lang.String.class,
						 java.lang.String.class,
						 };
		 			});
		Object O[]= null;
		modelo.addRow(O);
		table.setModel(modelo);
		
		
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(36, 315, 854, 156);
		getContentPane().add(scrollPane);
		
		
		JComboBox<String> cmb_sector = new JComboBox<String>();
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

						lbl_dato4.setVisible(false);
						txt_dato4.setVisible(false);
						lbl_dato1.setText("Adulto");
						lbl_dato2.setText("Angelito");
						lbl_dato3.setText("Inhumacion");
//						lbl_dato4.setText("Lote");
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
						chckbxBisBoveda.setBounds(203, 101, 52, 23);
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
					chckbxBisBoveda.setBounds(202, 149, 52, 23);
					
					break;

				}

			}

		});
		cmb_item_sector.setBounds(241, 53, 176, 20);
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

		cmb_sector.setBounds(23, 50, 176, 20);
		cmb_sector.insertItemAt("Sepulturas", 0);
		cmb_sector.insertItemAt("Palmeras", 1);
		cmb_sector.insertItemAt("Nichera", 2);
		cmb_sector.insertItemAt("Cenizario", 3);
		cmb_sector.insertItemAt("Boveda", 4);

		getContentPane().add(cmb_sector);
		txt_dato1 = new JTextField();
		txt_dato1.setBounds(23, 102, 76, 20);
		txt_dato1.setVisible(false);
		getContentPane().add(txt_dato1);

		txt_dato1.setColumns(10);
		JLabel lbl_ubicacion = new JLabel("Ubicaci\u00F3n:");
		lbl_ubicacion.setBounds(23, 28, 109, 14);
		getContentPane().add(lbl_ubicacion);
		
		JLabel lblLugar = new JLabel("Lugar:");
		lblLugar.setBounds(241, 28, 46, 14);
		getContentPane().add(lblLugar);
		
		txt_dato2 = new JTextField();
		txt_dato2.setColumns(10);
		txt_dato2.setBounds(121, 102, 76, 20);
		txt_dato2.setVisible(false);
		getContentPane().add(txt_dato2);
			
		
		JButton btn_add = new JButton("Buscar");
		btn_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (cmb_sector.getSelectedIndex()) {
				case 0:
					

					if (cmb_item_sector.getSelectedIndex() == 0) {// Sepultura

						
						cliente = new Clientes();
						Clientes Indigente = new Clientes();
						String seccion = txt_dato1.getText();
						String macizo = txt_dato2.getText();
						String sepultura = txt_dato3.getText();
						String inhumacion = txt_dato4.getText();
						
						cliente = Indigente.buscarClienteenSepulturasSeccionC4(seccion, macizo, sepultura,inhumacion);  
						
					}
					if (cmb_item_sector.getSelectedIndex() == 1) { // seccion 4
						
						
						Clientes sepultura = new Clientes();
						String seccion = txt_dato1.getText();
						String macizo = txt_dato2.getText();
						String bis_macizo= txt_dato3.getText();
						String unidad= txt_dato4.getText();
						String numero= txt_dato5.getText();						
						String bis= txt_dato6.getText();
//						cliente.verificarSepulturaSeccionC4(adulto, angelito, inhumacion);
						cliente =sepultura.buscarClienteenSepultura(seccion,macizo,bis_macizo,unidad,numero,bis);
						
						
					}
					
					break;
				case 1:
					if (cmb_item_sector.getSelectedIndex() == 0) { // Palmeras A

						Clientes palmerasA = new Clientes();
						cliente = new Clientes();
						String nicho_a = txt_dato1.getText();
						String fila_a = txt_dato2.getText();
						cliente = palmerasA.BuscarPalmerasaA(nicho_a,fila_a);

					}

					if (cmb_item_sector.getSelectedIndex() == 1) {// Palmeras C
						
						
						Clientes palmerasCe = new Clientes();
						String nicho_ce = txt_dato1.getText();
						String fila_ce = txt_dato2.getText();
						palmerasCe.VerificarPalmerasCe(nicho_ce,fila_ce);
						cliente = palmerasCe.buscarClienteenPalmerasCenizas(nicho_ce, fila_ce);

					}

					if (cmb_item_sector.getSelectedIndex() == 2) { // Palmeras
																	// ro
						//cliente = new Clientes();
						Clientes palmerasRo = new Clientes();
						String nicho_ro = txt_dato1.getText();
						String fila_ro = txt_dato2.getText();
						cliente = palmerasRo.buscarPalmerasRo(nicho_ro,fila_ro);
					

					}

					if (cmb_item_sector.getSelectedIndex() == 3) {// Palmeras S

						Clientes palmerasS = new Clientes();						
						String sepulturaS = txt_dato1.getText();
						System.out.println("llego aca");
						cliente= palmerasS.BuscarPorUbicacion(sepulturaS);
						

					}

					break;

				case 2:
					
					Clientes nichera = new Clientes();
					String Circ = txt_dato1.getText();
					String seccion = txt_dato2.getText();
					String macizo = txt_dato3.getText();
					String par = txt_dato4.getText();
					String fila = txt_dato5.getText();
					String unidad = txt_dato6.getText();
					cliente = nichera.buscarNicheraporUbi(Circ, seccion, macizo, par,fila, unidad);
					

					break;

				case 3:
					Clientes cenizario = new Clientes();
					String mueble = txt_dato1.getText();
					String nicho = txt_dato2.getText();
					cliente = cenizario.buscarCenizarioporUbi(mueble, nicho);
					break;

				case 4:

					Clientes boveda = new Clientes();
					String Circ_boveda = txt_dato1.getText();	
					String seccion_boveda = txt_dato2.getText();	
					String macizo_boveda = txt_dato3.getText();	
					String parcela_boveda = txt_dato4.getText();	
					String bis_boveda = txt_dato6.getText();	//cambiar bis
					String unidad_boveda = txt_dato5.getText();	
					
					
					cliente = boveda.buscarBovedasporUbi(Circ_boveda, seccion_boveda, macizo_boveda, parcela_boveda, bis_boveda, unidad_boveda);
					break;

				}
				
			
				
				 
				int i = 0;
				System.out.println(cliente.getApellidos());
				table.setValueAt(cliente.getApellidos(), i, 0);
				table.setValueAt(cliente.getNombres(), i, 1);
				table.setValueAt(cliente.getDni(), i, 2);
				table.setValueAt(cliente.getDomicilio(),i, 3);
				table.setValueAt(cliente.getFecha_fallec(),i, 4);
				table.setValueAt(cliente.getDireccion_familiar(), i, 5);
				table.setValueAt(cliente.getTelefono(), i, 6);
				table.setValueAt(cliente.getEmail(), i, 7);
				table.setValueAt(cliente.getCocheria(), i, 8);
				modelo.addRow(O);
				
				
			}

		});

		btn_add.setBounds(332, 145, 161, 31);

		getContentPane().add(btn_add);

		txt_dato3 = new JTextField();
		txt_dato3.setColumns(10);
		txt_dato3.setBounds(23, 150, 76, 20);
		txt_dato3.setVisible(false);
		getContentPane().add(txt_dato3);

		txt_dato4 = new JTextField();
		txt_dato4.setColumns(10);
		txt_dato4.setBounds(121, 150, 76, 20);
		txt_dato4.setVisible(false);
		getContentPane().add(txt_dato4);

		txt_dato5 = new JTextField();
		txt_dato5.setColumns(10);
		txt_dato5.setBounds(23, 198, 76, 20);
		txt_dato5.setVisible(false);
		getContentPane().add(txt_dato5);
		
		txt_dato6 = new JTextField();
		txt_dato6.setColumns(10);
		txt_dato6.setBounds(121, 198, 76, 20);
		txt_dato6.setVisible(false);
		getContentPane().add(txt_dato6);
		

	
	}
	






public Clientes buscarClienteenNichera(String campo1, String campo2, String campo3, String campo4, String campo5) {

	Clientes aux = new Clientes();

	try {

		String url = "jdbc:mysql://sql143.main-hosting.eu:3306/u147800277_cemen";

		String username = "u147800277_ben";

		String password = "Tiburones";

		Connection connection = DriverManager.getConnection(url, username, password);

		java.sql.Statement statement = connection.createStatement();

		ResultSet rs = statement.executeQuery(" CALL  buscarNichera ( '" + campo1 + "'  ,  '" + campo2 + "' ,'"
				+ campo3 + "' ,'" + campo4 + "' ,'" + campo5 + "')");

		if (!rs.equals(null)) {

			if (rs.next() == true) {

				System.out.println(rs.getString("fecha_fallecimiento"));

				aux.setApellidos(rs.getString("apellido"));

				aux.setNombres(rs.getString("nombres"));

				aux.setDni(rs.getString("dni"));

				aux.setFecha_fallec(rs.getString("fecha_fallecimiento"));

				aux.setDireccion_familiar(rs.getString("direccion"));

				aux.setNombre_familiar(rs.getString("nombre_familiar"));

				aux.setTelefono(rs.getString("telefono_familiar"));

			}

		}

		rs.close();

		statement.close();

		connection.close();

	} catch (SQLException ex) {

		System.out.println(ex);

	}

	return aux;

}

public Clientes buscarClienteenBoveda(String campo1) {

	Clientes aux = new Clientes();

	try {

		String url = "jdbc:mysql://sql143.main-hosting.eu:3306/u147800277_cemen";

		String username = "u147800277_ben";

		String password = "Tiburones";

		Connection connection = DriverManager.getConnection(url, username, password);

		java.sql.Statement statement = connection.createStatement();

		ResultSet rs = statement.executeQuery(" CALL  buscarNichera ( '" + campo1 + "')");

		if (!rs.equals(null)) {

			if (rs.next() == true) {

				System.out.println(rs.getString("fecha_fallecimiento"));

				aux.setApellidos(rs.getString("apellido"));

				aux.setNombres(rs.getString("nombres"));

				aux.setDni(rs.getString("dni"));

				aux.setFecha_fallec(rs.getString("fecha_fallecimiento"));

				aux.setDireccion_familiar(rs.getString("direccion"));

				aux.setNombre_familiar(rs.getString("nombre_familiar"));

				aux.setTelefono(rs.getString("telefono_familiar"));

			}

		}

		rs.close();

		statement.close();

		connection.close();

	} catch (SQLException ex) {

		System.out.println(ex);

	}

	return aux;

}

public Clientes buscarClienteenCenizario(String campo1, String campo2) {

	Clientes aux = new Clientes();

	try {

		String url = "jdbc:mysql://sql143.main-hosting.eu:3306/u147800277_cemen";

		String username = "u147800277_ben";

		String password = "Tiburones";

		Connection connection = DriverManager.getConnection(url, username, password);

		java.sql.Statement statement = connection.createStatement();

		ResultSet rs = statement.executeQuery(" CALL  buscarNichera ( '" + campo1 + "'  ,  '" + campo2 + "')");

		if (!rs.equals(null)) {

			if (rs.next() == true) {

				System.out.println(rs.getString("fecha_fallecimiento"));

				aux.setApellidos(rs.getString("apellido"));

				aux.setNombres(rs.getString("nombres"));

				aux.setDni(rs.getString("dni"));

				aux.setFecha_fallec(rs.getString("fecha_fallecimiento"));

				aux.setDireccion_familiar(rs.getString("direccion"));

				aux.setNombre_familiar(rs.getString("nombre_familiar"));

				aux.setTelefono(rs.getString("telefono_familiar"));

			}

		}

		rs.close();

		statement.close();

		connection.close();

	} catch (SQLException ex) {

		System.out.println(ex);

	}

	return aux;

}

public Clientes buscarClienteenPalmerasAtaud(String campo1, String campo2) {

	Clientes aux = new Clientes();

	try {

		String url = "jdbc:mysql://sql143.main-hosting.eu:3306/u147800277_cemen";

		String username = "u147800277_ben";

		String password = "Tiburones";

		Connection connection = DriverManager.getConnection(url, username, password);

		java.sql.Statement statement = connection.createStatement();

		ResultSet rs = statement.executeQuery(" CALL  buscarNichera ( '" + campo1 + "'  ,  '" + campo2 + "')");

		if (!rs.equals(null)) {

			if (rs.next() == true) {

				System.out.println(rs.getString("fecha_fallecimiento"));

				aux.setApellidos(rs.getString("apellido"));

				aux.setNombres(rs.getString("nombres"));

				aux.setDni(rs.getString("dni"));

				aux.setFecha_fallec(rs.getString("fecha_fallecimiento"));

				aux.setDireccion_familiar(rs.getString("direccion"));

				aux.setNombre_familiar(rs.getString("nombre_familiar"));

				aux.setTelefono(rs.getString("telefono_familiar"));

			}

		}

		rs.close();

		statement.close();

		connection.close();

	} catch (SQLException ex) {

		System.out.println(ex);

	}

	return aux;

}

public Clientes buscarClienteenPalmerasCenizas(String campo1, String campo2) {

	Clientes aux = new Clientes();

	try {

		String url = "jdbc:mysql://sql143.main-hosting.eu:3306/u147800277_cemen";

		String username = "u147800277_ben";

		String password = "Tiburones";

		Connection connection = DriverManager.getConnection(url, username, password);

		java.sql.Statement statement = connection.createStatement();

		ResultSet rs = statement.executeQuery(" CALL  buscarNichera ( '" + campo1 + "'  ,  '" + campo2 + "')");

		if (!rs.equals(null)) {

			if (rs.next() == true) {

				System.out.println(rs.getString("fecha_fallecimiento"));

				aux.setApellidos(rs.getString("apellido"));

				aux.setNombres(rs.getString("nombres"));

				aux.setDni(rs.getString("dni"));

				aux.setFecha_fallec(rs.getString("fecha_fallecimiento"));

				aux.setDireccion_familiar(rs.getString("direccion"));

				aux.setNombre_familiar(rs.getString("nombre_familiar"));

				aux.setTelefono(rs.getString("telefono_familiar"));

			}

		}

		rs.close();

		statement.close();

		connection.close();

	} catch (SQLException ex) {

		System.out.println(ex);

	}

	return aux;

}
}