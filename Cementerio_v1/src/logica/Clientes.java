package logica;

import java.sql.Array;

import java.sql.Connection;

import java.sql.Date;

import java.sql.DriverManager;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;

import java.text.SimpleDateFormat;

import java.util.ArrayList;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicTreeUI.TreeHomeAction;

public class Clientes {

	String nombres;

	String apellidos;

	String dni;

	String domicilio;

	String email;

	String telefono;

	String nombre_familiar;

	String fecha_fallec;

	int tipo_fallec;

	String cocheria;

	String direccion_familiar;

	int ubicacion;

	int id_cuenta;

	public Clientes() {

		apellidos = null;

		nombres = null;

		// fecha_fallec= (Date) new java.util.Date();

		dni = "";

		domicilio = "";

		direccion_familiar = "";

		cocheria = null;

		tipo_fallec = 0;

		ubicacion = 0;

		email = "";

		id_cuenta = 1;

		nombre_familiar = null;

	}

	public String getNombre_familiar() {

		return nombre_familiar;

	}

	public void setNombre_familiar(String nombre_familiar) {

		this.nombre_familiar = nombre_familiar;

	}

	public String getDireccion_familiar() {

		return direccion_familiar;

	}

	public void setDireccion_familiar(String direccion_familiar) {

		this.direccion_familiar = direccion_familiar;

	}

	public int getId_cuenta() {

		return id_cuenta;

	}

	public void setId_cuenta(int id_cuenta) {

		this.id_cuenta = id_cuenta;

	}

	public String getNombres() {

		return nombres;

	}

	public void setNombres(String nombres) {

		this.nombres = nombres;

	}

	public String getApellidos() {

		return apellidos;

	}

	public void setApellidos(String apellidos) {

		this.apellidos = apellidos;

	}
	

	public String getDni() {

		return dni;

	}

	public void setDni(String dni) {

		this.dni = dni;

	}

	public String getDomicilio() {

		return domicilio;

	}

	public void setDomicilio(String domicilio) {

		this.domicilio = domicilio;

	}

	public String getEmail() {

		return email;

	}

	public void setEmail(String email) {

		this.email = email;

	}

	public String getTelefono() {

		return telefono;

	}

	public void setTelefono(String telefono) {

		this.telefono = telefono;

	}

	public String getFecha_fallec() {

		return fecha_fallec;

	}

	public void setFecha_fallec(String date) {

		this.fecha_fallec = date;

	}

	public int getTipo_fallec() {

		return tipo_fallec;

	}

	public void setTipo_fallec(int i) {

		this.tipo_fallec = i;

	}

	public String getCocheria() {

		return cocheria;

	}

	public void setCocheria(String cocheria) {

		this.cocheria = cocheria;

	}

	public int getUbicacion() {

		return ubicacion;

	}

	public void setUbicacion(int ubicacion) {

		this.ubicacion = ubicacion;

	}

	public void altaCliente() {

		try {

			String url = "jdbc:mysql://sql143.main-hosting.eu:3306/u147800277_cemen";

			String username = "u147800277_ben";

			String password = "Tiburones";

			Connection connection = DriverManager.getConnection(url, username, password);

			java.sql.Statement statement = connection.createStatement();

			setUbicacion(ubicar());

			ResultSet rs = statement.executeQuery("CALL AltaCliente ('" + this.getApellidos() + "','"
					+ this.getNombres() + "','" + this.getFecha_fallec() + "','" + this.getDni() + "','"
					+ this.getDomicilio() + "','" + this.getNombre_familiar() + "','" + this.getTelefono() + "','"
					+ this.getCocheria() + "','" + this.getTipo_fallec() + "','" + this.getEmail() + "','"
					+ this.getDireccion_familiar() + "')");

			rs.close();

			statement.close();

			connection.close();
			JOptionPane.showMessageDialog(
					   null,
					   "Se ha guardado con exito");

		} catch (SQLException ex) {

			System.out.println(ex);

		}

	}

	private int ubicar() {
		
		
		int var = 0;

		try {

			String url = "jdbc:mysql://sql143.main-hosting.eu:3306/u147800277_cemen";

			String username = "u147800277_ben";

			String password = "Tiburones";

			Connection connection = DriverManager.getConnection(url, username, password);

			java.sql.Statement statement = connection.createStatement();

			ResultSet rs = statement.executeQuery("select ultima_ubicacion()");

			if (rs.next()) {

				var = rs.getInt(1);

				System.out.println(var + "ubicacion?");

				rs.close();

				statement.close();

				connection.close();

			}

		} catch (SQLException ex) {

			System.out.println(ex);

		}

		return var;

	}

	public boolean verificarIndigentes(String seccion, String macizo, String sepultura, String inhumacion) {

		
		try {

			String url = "jdbc:mysql://sql143.main-hosting.eu:3306/u147800277_cemen";

			String username = "u147800277_ben";

			String password = "Tiburones";

			Connection connection = DriverManager.getConnection(url, username, password);

			java.sql.Statement statement = connection.createStatement();

			ResultSet rs = statement.executeQuery(" select verificarNewIndigentes ('" +seccion+ "','"+macizo+"', '"+sepultura+"','"+inhumacion+"')");


			if (rs.next()) {

				//var = rs.getInt(1);
				return true;
			}
			
			rs.close();

			statement.close();

			connection.close();

		} catch (SQLException ex) {

			System.out.println(ex);
			
		}
		return false;

		
	}

	public boolean verificarSepultura(String seccion, String macizo, String bismacizo, String unidad, String numero ,String bis) {

		try {

			String url = "jdbc:mysql://sql143.main-hosting.eu:3306/u147800277_cemen";

			String username = "u147800277_ben";

			String password = "Tiburones";

			Connection connection = DriverManager.getConnection(url, username, password);

			java.sql.Statement statement = connection.createStatement();

			ResultSet rs = statement.executeQuery(" select verificarNewSepultura ('" + seccion + "','" + macizo + "','" + bismacizo +"','" + unidad + "','" + numero + "', '"+ bis +"')");


			if (rs.next()) {

				//var = rs.getInt(1);
				return true;
			}
			
			rs.close();

			statement.close();

			connection.close();

		} catch (SQLException ex) {

			System.out.println(ex);
			
		}
		return false;

		

	}

	public boolean verificarBovedas(String Circ,String seccion,String macizo
			,String par,String bis, String unidad ) {

		try {

			String url = "jdbc:mysql://sql143.main-hosting.eu:3306/u147800277_cemen";

			String username = "u147800277_ben";

			String password = "Tiburones";

			Connection connection = DriverManager.getConnection(url, username, password);

			java.sql.Statement statement = connection.createStatement();

			ResultSet rs = statement.executeQuery(" select verificarNewBoveda ('" + Circ + "','" + seccion + "','" + macizo + "','" + par + "','" + bis + "','" + unidad + "')");


			if (rs.next()) {

				//var = rs.getInt(1);
				return true;
			}
			
			rs.close();

			statement.close();

			connection.close();

		} catch (SQLException ex) {

			System.out.println(ex);
			
		}
		return false;   
		
		

	}

	public boolean verificarCenizario(String mueble_cenizas, String nicho_cenizas) {

		try {

			String url = "jdbc:mysql://sql143.main-hosting.eu:3306/u147800277_cemen";

			String username = "u147800277_ben";

			String password = "Tiburones";

			Connection connection = DriverManager.getConnection(url, username, password);

			java.sql.Statement statement = connection.createStatement();

			ResultSet rs = statement.executeQuery(" select verificarNewCenizario ('" + mueble_cenizas + "', '" + nicho_cenizas + "');");


			if (rs.next()) {

				//var = rs.getInt(1);
				return true;
			}
			
			rs.close();

			statement.close();

			connection.close();

		} catch (SQLException ex) {

			System.out.println(ex);
			
		}
		return false;

		

	}

	public boolean verificarNichera(String Circ, String seccion, String macizo, String par, String fila, String unidad) {

		try {

			String url = "jdbc:mysql://sql143.main-hosting.eu:3306/u147800277_cemen";

			String username = "u147800277_ben";

			String password = "Tiburones";

			Connection connection = DriverManager.getConnection(url, username, password);

			java.sql.Statement statement = connection.createStatement();

			ResultSet rs = statement.executeQuery(" select verificarNewNichera ('" + Circ + "','" + seccion + "','" + macizo + "','" + par + "','"  + fila + "','" + unidad + "')");


			if (rs.next()) {

				//var = rs.getInt(1);
				return true;
			}
			
			rs.close();

			statement.close();

			connection.close();

		} catch (SQLException ex) {

			System.out.println(ex);
			
		}
		return false;
		
		
		

	}

	public boolean verificarPalmerasS(String sepulturaS) {

		try {

			String url = "jdbc:mysql://sql143.main-hosting.eu:3306/u147800277_cemen";

			String username = "u147800277_ben";

			String password = "Tiburones";

			Connection connection = DriverManager.getConnection(url, username, password);

			java.sql.Statement statement = connection.createStatement();

			ResultSet rs = statement.executeQuery(" select verificarNewPalmerasSep ('" + sepulturaS + "');");


			if (rs.next()) {

				//var = rs.getInt(1);
				return true;
			}
			
			rs.close();

			statement.close();

			connection.close();

		} catch (SQLException ex) {

			System.out.println(ex);
			
		}
		return false;
		
	}

	public boolean verificarPalmerasRo(String nicho_ro, String fila_ro) {

		try {

			String url = "jdbc:mysql://sql143.main-hosting.eu:3306/u147800277_cemen";

			String username = "u147800277_ben";

			String password = "Tiburones";

			Connection connection = DriverManager.getConnection(url, username, password);

			java.sql.Statement statement = connection.createStatement();

			ResultSet rs = statement.executeQuery(" select verificarNewPalmerasRo ('" + nicho_ro + "', '" + fila_ro + "');");


			if (rs.next()) {

				//var = rs.getInt(1);
				return true;
			}
			
			rs.close();

			statement.close();

			connection.close();

		} catch (SQLException ex) {

			System.out.println(ex);
			
		}
		return false;
		

	}

	public boolean insertarPalmerasCe(String nicho_ce, String fila_ce) {

		try {

			String url = "jdbc:mysql://sql143.main-hosting.eu:3306/u147800277_cemen";

			String username = "u147800277_ben";

			String password = "Tiburones";

			Connection connection = DriverManager.getConnection(url, username, password);

			java.sql.Statement statement = connection.createStatement();

			ResultSet rs = statement.executeQuery(" call insertarNewPalmerasC('" + nicho_ce + "','" + fila_ce + "')");

			rs.close();

			statement.close();

			connection.close();
			return true;
		} catch (SQLException ex) {

			System.out.println(ex);
			return false;

		}

	}

	public boolean verificarNewpalmerasA(String nicho_a, String fila_a) {

		try {

			String url = "jdbc:mysql://sql143.main-hosting.eu:3306/u147800277_cemen";

			String username = "u147800277_ben";

			String password = "Tiburones";

			Connection connection = DriverManager.getConnection(url, username, password);

			java.sql.Statement statement = connection.createStatement();

			ResultSet rs = statement.executeQuery(" select verificarNewPalmerasA ('" + nicho_a + "', '" + fila_a + "');");


			if (rs.next()) {

				//var = rs.getInt(1);
				return true;
			}
			
			rs.close();

			statement.close();

			connection.close();

		} catch (SQLException ex) {

			System.out.println(ex);
			
		}
		return false;
		
	}

	public boolean insertarPalmerasA(String nicho_a, String fila_a) {

		try {

			String url = "jdbc:mysql://sql143.main-hosting.eu:3306/u147800277_cemen";

			String username = "u147800277_ben";

			String password = "Tiburones";

			Connection connection = DriverManager.getConnection(url, username, password);

			java.sql.Statement statement = connection.createStatement();

			ResultSet rs = statement.executeQuery(" call insertarNewPalmerasA('" + nicho_a + "','" + fila_a + "')");

			rs.close();

			statement.close();

			connection.close();
			return true;
		} catch (SQLException ex) {

			System.out.println(ex);
			return false;
		}
		
	}

	public boolean VerificarPalmerasCe(String nicho_ce, String fila_ce) {

		try {

			String url = "jdbc:mysql://sql143.main-hosting.eu:3306/u147800277_cemen";

			String username = "u147800277_ben";

			String password = "Tiburones";

			Connection connection = DriverManager.getConnection(url, username, password);

			java.sql.Statement statement = connection.createStatement();

			ResultSet rs = statement.executeQuery(" select verificarNewPalmerasC ('" + nicho_ce + "', '" + fila_ce + "');");


			if (rs.next()) {

				//var = rs.getInt(1);
				return true;
			}
			
			rs.close();

			statement.close();

			connection.close();

		} catch (SQLException ex) {

			System.out.println(ex);
			
		}
		return false;
		
	}
	
	public boolean insertarPalmerasRo(String nicho_ro, String fila_ro) {

		try {

			String url = "jdbc:mysql://sql143.main-hosting.eu:3306/u147800277_cemen";

			String username = "u147800277_ben";

			String password = "Tiburones";

			Connection connection = DriverManager.getConnection(url, username, password);

			java.sql.Statement statement = connection.createStatement();

			ResultSet rs = statement.executeQuery(" call insertarNewPalmerasRo('" + nicho_ro + "','" + fila_ro + "')");

			rs.close();

			statement.close();

			connection.close();
			return true;
		} catch (SQLException ex) {

			System.out.println(ex);
			return false;

		}

	}

	public boolean insertarPalmeras_S(String palmerasS) {


		try {

			String url = "jdbc:mysql://sql143.main-hosting.eu:3306/u147800277_cemen";

			String username = "u147800277_ben";

			String password = "Tiburones";

			Connection connection = DriverManager.getConnection(url, username, password);

			java.sql.Statement statement = connection.createStatement();

			ResultSet rs = statement.executeQuery(" call insertarNewPalmerasSep('"  + palmerasS + "')");

			rs.close();

			statement.close();

			connection.close();
			return true;
		} catch (SQLException ex) {

			System.out.println(ex);
			return false;

		}

	}

	public boolean insertarNichera(String seccion, String macizo, String par, String fila, String unidad) {

		
		try {

			String url = "jdbc:mysql://sql143.main-hosting.eu:3306/u147800277_cemen";

			String username = "u147800277_ben";

			String password = "Tiburones";

			Connection connection = DriverManager.getConnection(url, username, password);

			java.sql.Statement statement = connection.createStatement();

			ResultSet rs = statement.executeQuery(" call insertarNewNichera ('" + seccion + "', '" + macizo + "', '" + par + "', '" + fila + "', '" + unidad + "');");

			rs.close();

			statement.close();

			connection.close();
			return true;
		} catch (SQLException ex) {

			System.out.println(ex);
			return false;

		}

	}
		

	public boolean InsertarCenizario(String mueble, String nicho) {

		try {

			String url = "jdbc:mysql://sql143.main-hosting.eu:3306/u147800277_cemen";

			String username = "u147800277_ben";

			String password = "Tiburones";

			Connection connection = DriverManager.getConnection(url, username, password);

			java.sql.Statement statement = connection.createStatement();

			ResultSet rs = statement.executeQuery(" call insertarNewPalmerasRo('" + mueble + "','" + nicho + "')");

			rs.close();

			statement.close();

			connection.close();
			return true;
		} catch (SQLException ex) {

			System.out.println(ex);
			return false;

		}

	}
	public boolean insertarBovedas(String  Circ, String seccion, String macizo, String parcela, String bis, String unidad) {

		try {

			String url = "jdbc:mysql://sql143.main-hosting.eu:3306/u147800277_cemen";

			String username = "u147800277_ben";

			String password = "Tiburones";

			Connection connection = DriverManager.getConnection(url, username, password);

			java.sql.Statement statement = connection.createStatement();

			ResultSet rs = statement.executeQuery(" call insertarNewBoveda('" + Circ + "', '" + seccion+ "', '" + macizo + "', '" + parcela + "', '" + bis + "', '" + unidad + "');");

			rs.close();

			statement.close();

			connection.close();
			return true;
		} catch (SQLException ex) {

			System.out.println(ex);
			return false;

		}

	}

	public boolean  insertarSepultura(String seccion,String macizo,String bis_macizo,String unidad,String numero,String bis) {

		try {

			String url = "jdbc:mysql://sql143.main-hosting.eu:3306/u147800277_cemen";

			String username = "u147800277_ben";

			String password = "Tiburones";

			Connection connection = DriverManager.getConnection(url, username, password);

			java.sql.Statement statement = connection.createStatement();

			ResultSet rs = statement.executeQuery(" call insertarNewSepultura('" + seccion + "', '" + macizo + "', '" + bis_macizo + "', '" + unidad + "', '" + numero + "', '" + bis + "');");

			rs.close();

			statement.close();

			connection.close();
			return true;
		} catch (SQLException ex) {

			System.out.println(ex);
			return false;

		}

	}


	public boolean insertarIndigentes(String seccion, String macizo, String sepultura , String inhumacion) {

		
		try {

			String url = "jdbc:mysql://sql143.main-hosting.eu:3306/u147800277_cemen";

			String username = "u147800277_ben";

			String password = "Tiburones";

			Connection connection = DriverManager.getConnection(url, username, password);

			java.sql.Statement statement = connection.createStatement();

			ResultSet rs = statement.executeQuery(" call insertarNewBoveda('" + seccion + "', '" + macizo + "', '" + sepultura + "', '" + inhumacion + "');");

			rs.close();

			statement.close();

			connection.close();
			return true;
		} catch (SQLException ex) {

			System.out.println(ex);
			return false;

		}

	}

		
		

	public ArrayList<Clientes> buscarCliente() {

		ResultSet rs = null;

		ArrayList<Clientes> client = new ArrayList<Clientes>();

		String url = "jdbc:mysql://sql143.main-hosting.eu:3306/u147800277_cemen";

		String username = "u147800277_ben";

		String password = "Tiburones";

		Connection connection = null;

		java.sql.Statement statement = null;
		String query ="";
		try {

			connection = DriverManager.getConnection(url, username, password);

			statement = connection.createStatement();
			//por todos los campos
			if (!this.getApellidos().equals("") && !this.getNombres().equals("") &&
					!this.getDni().equals("") &&  !this.getDireccion_familiar().equals("")
						&& !this.getCocheria().equals("") && !this.getTelefono().equals(""))
			{
			query =	" CALL buscarClientes ('"+ this.getApellidos() + "', '"+ this.getNombres() + "' , '" + this.getDni() + "' , '"
							+ this.getDireccion_familiar() + "', '" + this.getCocheria() + "', '"+this.getTelefono()+"')";
			}
			//por apellido
			if (!this.getApellidos().equals("") && this.getNombres().equals("") &&
					this.getDni().equals("") &&  this.getDireccion_familiar().equals("")
						&& this.getCocheria().equals("") && this.getTelefono().equals(""))
			{
				System.out.println("apellido ="+this.getApellidos());
			query =	" CALL buscarporApellido ('"+ this.getApellidos() + "')";
			}
			//por nombre y apellido
			if (!this.getApellidos().equals("") && !this.getNombres().equals("") &&
					this.getDni().equals("") &&  this.getDireccion_familiar().equals("")
						&& this.getCocheria().equals("") && this.getTelefono().equals(""))
			{
			query =	" CALL buscarporApellido ('"+ this.getNombres() + "', '"+ this.getApellidos() + "')";
			}
			//por DNI
			if (this.getApellidos().equals("") && this.getNombres().equals("") &&
					!this.getDni().equals("") &&  this.getDireccion_familiar().equals("")
						&& this.getCocheria().equals("") && this.getTelefono().equals(""))
			{
			query =	" CALL buscarporDNI ('"+ this.getDni() + "')";
			
			
			}
			//por cocheria
			if (this.getApellidos().equals("") && !this.getNombres().equals("") &&
					this.getDni().equals("") &&  this.getDireccion_familiar().equals("")
						&& !this.getCocheria().equals("") && this.getTelefono().equals(""))
			{
			query =	" CALL buscarporCocheria ('"+ this.getCocheria() + "')";
			}
			
//			System.out.println ("apellido"+this.getApellidos());
//			System.out.println ("nombres"+this.getNombres());
//			System.out.println ("dni" +this.getDni());
//			System.out.println ("dire fam" +this.getDireccion_familiar());
			
			rs = statement.executeQuery( query);
			
			while (rs.next()) {

//				System.out.println("RS SIZE" + rs.getFetchSize());

				// En el auxiliar cliente le seteo los datos.

				Clientes aux = new Clientes();

				aux.setApellidos(rs.getString("apellido"));

				aux.setNombres(rs.getString("nombres"));

				aux.setDni(rs.getString("dni"));

				Date ff = rs.getDate("fecha_fallecimiento");

				java.text.SimpleDateFormat sdf =

						new java.text.SimpleDateFormat("yyyy-MM-dd");

				String currentTime = ff.getYear() + "-" + ff.getMonth() + "-" + ff.getDate();// sdf.format(date);

				aux.setFecha_fallec(currentTime);

				aux.setDireccion_familiar(rs.getString("direccion"));

				aux.setNombre_familiar(rs.getString("nombre_familiar"));

				aux.setTelefono(rs.getString("telefono_familiar"));

				aux.setEmail(rs.getString("email_familiar"));

				aux.setEmail(rs.getString("cocheria"));

				client.add(aux);

			}

			rs.close();

			statement.close();

			connection.close();

		} catch (SQLException ex) {

			System.out.println(ex);

		}

		for (int i = 0; i < client.size(); i++) {

//			System.out.print("apellido" + client.get(i).getApellidos());

//			System.out.println(" dni " + client.get(i).getDni());

		}

		return client;

	}

	public String buscarUbicacionporNombre(String apellido, String nombres) {

		String cadena = "";

		try {

			String url = "jdbc:mysql://sql143.main-hosting.eu:3306/u147800277_cemen";

			String username = "u147800277_ben";

			String password = "Tiburones";

			Connection connection = DriverManager.getConnection(url, username, password);

			java.sql.Statement statement = connection.createStatement();

			ResultSet rs = statement.executeQuery(
					" SELECT 'unidad_boveda', 'seccion_nichera', 'deposito', 'otrocementerio','osario','nicho_palmeras_ataud','fila_palmeras_ataud','seccion_sepulturas','lote_sepulturas','unidad_sepulturas','bis_sepulturas','palmeras_sepulturas','nicho_palmeras_ro','fila_palmeras_ro','nicho_palmeras_cen','fila_palmeras_cen','macizo_nichera','par_nichera','fila_nichera','unidad_nichera','mueble_cenizas','nicho_cenizas','lote_adulto','lote_angelito','inhumacion' FROM 'Clientes' inner join  'ubicacion' on 'id_ubicacion' =  'ubicacion_id' and  '"
							+ this.getApellidos() + "' = 'apellido' and '" + this.getNombres() + "' = 'nombres'");

			if (rs.next() == true) {

				cadena = cadena + rs.getString("seccion_nichera") + rs.getString("unidad_boveda")
						+ rs.getString("deposito") + rs.getString("otrocementerio") + rs.getString("osario")
						+ rs.getString("nicho_palmeras_ataud") + rs.getString("fila_palmeras_ataud")
						+ rs.getString("seccion_sepulturas") + rs.getString("seccion_sepulturas")
						+ rs.getString("unidad_sepulturas") + rs.getString("bis_sepulturas")
						+ rs.getString("palmeras_sepulturas") + rs.getString("nicho_palmeras_ro")
						+ rs.getString("fila_palmeras_ro") + rs.getString("nicho_palmera_cen")
						+ rs.getString("fila_palmera_cen") + rs.getString("macizo_nichera")
						+ rs.getString("fila_nichera") + rs.getString("par_nichera") + rs.getString("unidad_nichera")
						+ rs.getString("mueble_cenizas") + rs.getString("nicho_cenizas") + rs.getString("lote_adulto")
						+ rs.getString("lote_angelito") + rs.getString("inhumacion");

				return cadena;

			}

			rs.close();

			statement.close();

			connection.close();

		} catch (SQLException ex) {

			System.out.println(ex);

		}

		return "error";

	}

	public String buscarUbicacionporDni(String dni) {

		String cadena = "";

		try {

			String url = "jdbc:mysql://sql143.main-hosting.eu:3306/u147800277_cemen";

			String username = "u147800277_ben";

			String password = "Tiburones";

			Connection connection = DriverManager.getConnection(url, username, password);

			java.sql.Statement statement = connection.createStatement();

			ResultSet rs = statement.executeQuery(
					" SELECT 'unidad_boveda', 'seccion_nichera', 'deposito', 'otrocementerio','osario','nicho_palmeras_ataud','fila_palmeras_ataud','seccion_sepulturas','lote_sepulturas','unidad_sepulturas','bis_sepulturas','palmeras_sepulturas','nicho_palmeras_ro','fila_palmeras_ro','nicho_palmeras_cen','fila_palmeras_cen','macizo_nichera','par_nichera','fila_nichera','unidad_nichera','mueble_cenizas','nicho_cenizas','lote_adulto','lote_angelito','inhumacion' FROM 'Clientes' inner join  'ubicacion' on 'id_ubicacion' =  'ubicacion_id' and  '"
							+ dni + "' = 'dni'");

			if (rs.next() == true) {

				cadena = cadena + rs.getString("seccion_nichera") + rs.getString("unidad_boveda")
						+ rs.getString("deposito") + rs.getString("otrocementerio") + rs.getString("osario")
						+ rs.getString("nicho_palmeras_ataud") + rs.getString("fila_palmeras_ataud")
						+ rs.getString("seccion_sepulturas") + rs.getString("seccion_sepulturas")
						+ rs.getString("unidad_sepulturas") + rs.getString("bis_sepulturas")
						+ rs.getString("palmeras_sepulturas") + rs.getString("nicho_palmeras_ro")
						+ rs.getString("fila_palmeras_ro") + rs.getString("nicho_palmeras_cen")
						+ rs.getString("fila_palmeras_cen") + rs.getString("macizo_nichera")
						+ rs.getString("fila_nichera") + rs.getString("par_nichera") + rs.getString("unidad_nichera")
						+ rs.getString("mueble_cenizas") + rs.getString("nicho_cenizas") + rs.getString("lote_adulto")
						+ rs.getString("lote_angelito") + rs.getString("inhumacion");

				System.out.println(cadena);

				return cadena;

			}

			rs.close();

			statement.close();

			connection.close();

		} catch (SQLException ex) {

			System.out.println(ex);

		}

		return "error";

	}

	

}