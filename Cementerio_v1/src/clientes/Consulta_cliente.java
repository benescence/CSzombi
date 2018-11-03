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
import com.toedter.calendar.JDateChooser;

import logica.Clientes;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class Consulta_cliente extends JInternalFrame {
	private JTextField txt_apellido;
	private JTextField txt_nombre;
	private JTextField txt_dni;
	private JTextField txt_domicilio;
	private JTextField txt_telefono;
	private JDateChooser date;
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
		
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	
		
		setBackground(SystemColor.inactiveCaptionBorder);
		setBorder(null);
		setBounds(0, 0, 900, 600);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Apellido");
		lblNewLabel.setBounds(54, 24, 132, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblContrasea = new JLabel("DNI");
		lblContrasea.setBounds(54, 82, 132, 14);
		getContentPane().add(lblContrasea);
		
		date= new JDateChooser();
		date.setBounds(203,171, 96, 23);
		getContentPane().add(date);
		
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
		
		txt_telefono = new JTextField();
		txt_telefono.setColumns(10);
		txt_telefono.setBounds(178, 138, 203, 20);
		getContentPane().add(txt_telefono);
		
		JButton btn_buscar = new JButton("Buscar");
		btn_buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Clientes clientes = new Clientes();
			    clientes = cargar_cliente_buscar();
			    if (date.getDate() != null) {
			    	String fecha_fallecimiento = df.format(date.getDate());
			    }
			    else {}
			    	String fecha_fallecimiento="";
			    
			    if (!txt_apellido.getText().equals(null) &&  !txt_nombre.getText().equals(null) && !txt_dni.getText().equals(null) && !fecha_fallecimiento.equals(null) & !txt_telefono.getText().equals(null) && !txt_domicilio.getText().equals(null)){
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
		
		JLabel lblDomicilioFamiliar = new JLabel("dni ocupante");
		lblDomicilioFamiliar.setBounds(54, 110, 132, 14);
		getContentPane().add(lblDomicilioFamiliar);
		
		
		setTitle("Consulta Clientes");
		
		/*JLabel lblFechaFallecimiento = new JLabel("Fecha Fallecimiento");
		lblFechaFallecimiento.setBounds(54, 233, 111, 14);
		getContentPane().add(lblFechaFallecimiento);
		
		Calendar cal = Calendar.getInstance();
		java.util.Date date=new java.util.Date();
		cal.setTime(date);
		JCalendar jc = new JCalendar();
		jc.setCalendar(cal);
		jc.setBounds(178,233,200,130);
		getContentPane().add(jc);*/
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(54, 49, 132, 14);
		getContentPane().add(lblNombre);
		
		JLabel lblTelefonoFamilliar = new JLabel("Telefono familliar");
		lblTelefonoFamilliar.setBounds(54, 138, 132, 14);
		getContentPane().add(lblTelefonoFamilliar);
		
		JButton btnLimpiarCampos = new JButton("Borrar Campos");
		btnLimpiarCampos.setBounds(536, 168, 141, 33);
		getContentPane().add(btnLimpiarCampos);
		getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txt_apellido, txt_nombre, txt_dni, txt_domicilio, txt_telefono, btn_buscar, btnLimpiarCampos}));
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txt_apellido, txt_nombre, txt_dni, txt_domicilio, txt_telefono}));
		
	}
	private Clientes cargar_cliente_buscar() {
				
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		
		Clientes cli = new Clientes();
		cli.setApellidos(txt_apellido.getText());
		cli.setNombres(txt_nombre.getText());
		cli.setDni(txt_dni.getText());
		cli.setDomicilio(txt_domicilio.getText());
		cli.setTelefono(txt_telefono.getText());
		if(date.getDate() !=null) {
			cli.setFecha_fallec(df.format(date.getDate()));
		}
		
		//String a = df.format(date.getDate());
		System.out.println(date.getDate());
		
		
		//System.out.println(a + "fechaaa");
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

					aux.setDni_ocupante(rs.getString("direccion"));

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

					aux.setDni_ocupante(rs.getString("direccion"));

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

					aux.setDni_ocupante(rs.getString("direccion"));

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

					aux.setDni_ocupante(rs.getString("direccion"));

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
