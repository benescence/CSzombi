package clientes;

import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.Calendar;
import com.toedter.calendar.JCalendar;

import logica.Clientes;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class Consulta_cliente extends JInternalFrame {
	private JTextField txt_apellido;
	private JTextField txt_nombre;
	private JTextField txt_dni;
	private JTextField txt_domicilio;
	private JTextField txt_domfamiliar;
	private JTextField txt_email;
	private JTextField txt_cocheria;
	private JTextField txt_telefono;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Consulta_cliente frame = new Consulta_cliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Consulta_cliente() {
		
		setMaximizable(true);
		
		setBackground(SystemColor.inactiveCaptionBorder);
		setBorder(null);
		setBounds(0, 0, 900, 600);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Apellido");
		lblNewLabel.setBounds(36, 24, 132, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblContrasea = new JLabel("DNI");
		lblContrasea.setBounds(36, 82, 132, 14);
		getContentPane().add(lblContrasea);
		
		txt_apellido = new JTextField();
		txt_apellido.setBounds(178, 21, 203, 20);
		txt_apellido.setColumns(10);
		txt_apellido.setFocusable(true);
		getContentPane().add(txt_apellido);
		
		txt_nombre = new JTextField();
		txt_nombre.setColumns(10);
		txt_nombre.setBounds(178, 49, 203, 20);
		txt_nombre.setFocusable(true);
		getContentPane().add(txt_nombre);
		
		txt_dni = new JTextField();
		txt_dni.setColumns(10);
		txt_dni.setBounds(178, 79, 203, 20);
		txt_dni.setFocusable(true);
		getContentPane().add(txt_dni);
		
		txt_domicilio = new JTextField();
		txt_domicilio.setColumns(10);
		txt_domicilio.setBounds(178, 107, 203, 20);
		getContentPane().add(txt_domicilio);
		
		txt_domfamiliar = new JTextField();
		txt_domfamiliar.setColumns(10);
		txt_domfamiliar.setBounds(178, 135, 203, 20);
		getContentPane().add(txt_domfamiliar);
		
		txt_email = new JTextField();
		txt_email.setColumns(10);
		txt_email.setBounds(178, 165, 203, 20);
		getContentPane().add(txt_email);
		
		txt_telefono = new JTextField();
		txt_telefono.setColumns(10);
		txt_telefono.setBounds(178, 196, 203, 20);
		getContentPane().add(txt_telefono);
		
		JLabel lblNivelDePermisos = new JLabel("Tipo de fallecimiento");
		lblNivelDePermisos.setBounds(391, 24, 132, 14);
		getContentPane().add(lblNivelDePermisos);
		
		JComboBox<String> cmb_tipo_fall = new JComboBox<String>();
		cmb_tipo_fall.setBounds(515, 21, 165, 20);
		cmb_tipo_fall.insertItemAt("Traumatico", 0);
		cmb_tipo_fall.insertItemAt("No traumatico", 1);
		
		getContentPane().add(cmb_tipo_fall);
		
		JButton btn_buscar = new JButton("Buscar");
		btn_buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Clientes clientes = new Clientes();
			    clientes = cargar_cliente_buscar();
			    
			    if (!txt_apellido.getText().equals(null) && !txt_nombre.getText().equals(null)){
				ArrayList<Clientes> clientes_row =  new ArrayList<Clientes>();
				clientes_row = clientes.buscarCliente();
				
				if (clientes_row.size()>0){					
//				Resultados_clientes rc = new Resultados_clientes(clientes_row, r);
//				rc.setVisible(true);
										
					getContentPane().removeAll();
					getContentPane().repaint();
//					Consulta_cliente cc = new Consulta_cliente();
//					cc.setVisible(false);
//					getContentPane().repaint();
					
					Consulta_resultado cr = new Consulta_resultado(clientes_row);
					cr.setVisible(true);
					getContentPane().add(cr);
					getContentPane().repaint();
					
					
					
				
				}else{
					JOptionPane.showMessageDialog(
							   null,
							   "No se han encontrado datos");
				}
				
			    }
			    
			    if (!txt_dni.getText().equals(null)){
			    	System.out.println("porque llego aca ?");//clientes.buscarUbicacionporDni(txt_dni.getText());
			    }
			    
			    

			    
			    
			}
		});
		btn_buscar.setBounds(407, 168, 119, 33);
		getContentPane().add(btn_buscar);
		
		JLabel lblDomicilio = new JLabel("Domicilio");
		lblDomicilio.setBounds(36, 110, 132, 14);
		getContentPane().add(lblDomicilio);
		
		JLabel lblDomicilioFamiliar = new JLabel("Domicilio Familiar");
		lblDomicilioFamiliar.setBounds(36, 138, 132, 14);
		getContentPane().add(lblDomicilioFamiliar);
		
		JLabel lblEmailFamiliar = new JLabel("E-mail familiar");
		lblEmailFamiliar.setBounds(36, 168, 132, 14);
		getContentPane().add(lblEmailFamiliar);
		
		JLabel lblCocheria = new JLabel("Cocheria");
		lblCocheria.setBounds(393, 52, 76, 14);
		getContentPane().add(lblCocheria);
		
		txt_cocheria = new JTextField();
		txt_cocheria.setColumns(10);
		txt_cocheria.setBounds(479, 49, 203, 20);
		getContentPane().add(txt_cocheria);
		
		JLabel lblFechaFallecimiento = new JLabel("Fecha Fallecimiento");
		lblFechaFallecimiento.setBounds(36, 233, 132, 14);
		getContentPane().add(lblFechaFallecimiento);
		setTitle("Consulta Clientes");
		Calendar cal = Calendar.getInstance();
		java.util.Date date=new java.util.Date();
		cal.setTime(date);
		JCalendar jc = new JCalendar();
		jc.setCalendar(cal);
		jc.setBounds(178,233,200,130);
		getContentPane().add(jc);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(36, 52, 132, 14);
		getContentPane().add(lblNombre);
		
		JLabel lblTelefonoFamilliar = new JLabel("Telefono familliar");
		lblTelefonoFamilliar.setBounds(36, 199, 132, 14);
		getContentPane().add(lblTelefonoFamilliar);
		
		JButton btnLimpiarCampos = new JButton("Borrar Campos");
		btnLimpiarCampos.setBounds(536, 168, 141, 33);
		getContentPane().add(btnLimpiarCampos);
		getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txt_apellido, txt_nombre, txt_dni, txt_domicilio, txt_domfamiliar, txt_email, txt_telefono, cmb_tipo_fall, txt_cocheria, btn_buscar, btnLimpiarCampos}));
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txt_apellido, txt_nombre, txt_dni, txt_domicilio, txt_domfamiliar, txt_email, txt_telefono, cmb_tipo_fall, txt_cocheria}));
		
	}
	private Clientes cargar_cliente_buscar() {
				
		Clientes cli = new Clientes();
		cli.setApellidos(txt_apellido.getText());
		cli.setNombres(txt_nombre.getText());
		cli.setDni(txt_dni.getText());
		cli.setDomicilio(txt_domicilio.getText());
		cli.setDireccion_familiar(txt_domfamiliar.getText());
		cli.setEmail(txt_email.getText());
		cli.setCocheria(txt_cocheria.getText());
		cli.setTelefono(txt_telefono.getText());
		
		return cli;
		
	}
	
	
	public Clientes buscarClienteenPalmerasRestosO(String campo1, String campo2) {

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

	public Clientes buscarClienteenPalmerasSepultura(String campo2) {

		Clientes aux = new Clientes();

		try {

			String url = "jdbc:mysql://sql143.main-hosting.eu:3306/u147800277_cemen";

			String username = "u147800277_ben";

			String password = "Tiburones";

			Connection connection = DriverManager.getConnection(url, username, password);

			java.sql.Statement statement = connection.createStatement();

			ResultSet rs = statement.executeQuery(" CALL  buscarPalmerasSep (   '" + campo2 + "')");

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

	public Clientes buscarClienteenSepulturas(String campo1, String campo2, String campo3, String campo4) {

		Clientes aux = new Clientes();

		try {

			String url = "jdbc:mysql://sql143.main-hosting.eu:3306/u147800277_cemen";

			String username = "u147800277_ben";

			String password = "Tiburones";

			Connection connection = DriverManager.getConnection(url, username, password);

			java.sql.Statement statement = connection.createStatement();

			ResultSet rs = statement.executeQuery(" CALL  buscarNichera ( '" + campo1 + "'  ,  '" + campo2 + "',  '"
					+ campo3 + "',  '" + campo4 + "')");

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

	public Clientes buscarClienteenSepulturasSeccionC4(String campo1, String campo2, String campo3) {

		Clientes aux = new Clientes();

		try {

			String url = "jdbc:mysql://sql143.main-hosting.eu:3306/u147800277_cemen";

			String username = "u147800277_ben";

			String password = "Tiburones";

			Connection connection = DriverManager.getConnection(url, username, password);

			java.sql.Statement statement = connection.createStatement();

			ResultSet rs = statement
					.executeQuery(" CALL  buscarNichera ( '" + campo1 + "'  ,  '" + campo2 + "',  '" + campo3 + "')");

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

	public void verificarAngelitoSeccionC4(String adulto, String angelito, String inhumacion) {

		try {

			String url = "jdbc:mysql://sql143.main-hosting.eu:3306/u147800277_cemen";

			String username = "u147800277_ben";

			String password = "Tiburones";

			Connection connection = DriverManager.getConnection(url, username, password);

			java.sql.Statement statement = connection.createStatement();

			ResultSet rs = statement.executeQuery(
					" call verificarAngelitoSeccionC4( '" + adulto + "','" + angelito + "', '" + inhumacion + "' )");

			rs.close();

			statement.close();

			connection.close();

		} catch (SQLException ex) {

			System.out.println(ex);

		}

	}
	
	
	private JInternalFrame getFrame(){
	    return this;
	}
	
	
}
