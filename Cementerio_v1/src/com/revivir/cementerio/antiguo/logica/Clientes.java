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

	String fecha_fallecimiento;

	int tipo_fallec;

	String cocheria;

	String dni_ocupante;

	int ubicacion;

	int id_cuenta;

	
	

	public Clientes() {

		this.apellidos = null;

		this.nombres = null;

		 this.fecha_fallecimiento ="0000/00/00";
		this.dni = null;

		this.domicilio = null;

		dni_ocupante = "";

		cocheria = null;
		this.telefono=null;

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

	public String getDni_ocupante() {

		return dni_ocupante;

	}

	public void setDni_ocupante(String dni_ocupante) {

		this.dni_ocupante = dni_ocupante;

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

		return fecha_fallecimiento;

	}

	public void setFecha_fallec(String date) {

		this.fecha_fallecimiento = date;

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
      String query="";
		try {

			String url = "jdbc:mysql://sql143.main-hosting.eu:3306/u147800277_cemen";

			String username = "u147800277_ben";

			String password = "Tiburones";

			Connection connection = DriverManager.getConnection(url, username, password);

			java.sql.Statement statement = connection.createStatement();

			setUbicacion(ubicar());
			query="CALL AltaCliente ('" + this.getApellidos() + "','"
					+ this.getNombres() + "','" + this.getFecha_fallec() + "','" + this.getDni() + "','"
					+ this.getDomicilio() + "','" + this.getNombre_familiar() + "','" + this.getTelefono() + "','"
					+ this.getCocheria() + "','" + this.getTipo_fallec() + "','" + this.getEmail() + "','"
					+ this.getDni_ocupante() + "')";
			query= query.replaceAll("''", "null");
			
			ResultSet rs = statement.executeQuery(query);

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
	public void modificarCliente() {
		try {

			String url = "jdbc:mysql://sql143.main-hosting.eu:3306/u147800277_cemen";

			String username = "u147800277_ben";

			String password = "Tiburones";

			Connection connection = DriverManager.getConnection(url, username, password);

			java.sql.Statement statement = connection.createStatement();

			setUbicacion(ubicar());

			ResultSet rs = statement.executeQuery("CALL ModifCliente ('" + this.getApellidos() + "','"
					+ this.getNombres() + "','" + this.getFecha_fallec() + "','" + this.getDni() + "','"
					+ this.getDomicilio() + "','" + this.getNombre_familiar() + "','" + this.getTelefono() + "','"
					+ this.getCocheria() + "','" + this.getTipo_fallec() + "','" + this.getEmail()  + "')");

			rs.close();

			statement.close();

			connection.close();
			JOptionPane.showMessageDialog(
					   null,
					   "Se ha Modificado con exito");

		} catch (SQLException ex) {

			System.out.println(ex);

		}

	}

	
	public boolean verificarIndigentes(String seccion, String macizo, String sepultura, String inhumacion) {

		
		try {

			String url = "jdbc:mysql://sql143.main-hosting.eu:3306/u147800277_cemen";

			String username = "u147800277_ben";

			String password = "Tiburones";

			Connection connection = DriverManager.getConnection(url, username, password);

			java.sql.Statement statement = connection.createStatement();

			ResultSet rs = statement.executeQuery(" call verificarNewIndigentes ('" +seccion+ "','"+macizo+"', '"+sepultura+"','"+inhumacion+"')");


			while (rs.next()) {
				
				
				String sep= rs.getString("sepultura");
				String mac= rs.getString("macizo");
				String inu= rs.getString("inhumacion");
				String sec= rs.getString("seccion");
				
				if(sep.equals(sepultura) && mac.equals(macizo) && inu.equals(inhumacion) && sec.equals(seccion) ) {
					
					return true;

				}
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

			ResultSet rs = statement.executeQuery("call verificarNewSepultura ('" + seccion + "','" + macizo + "','" + bismacizo +"','" + unidad + "','" + numero + "', '"+ bis +"')");


			while (rs.next()) {
				
				
				String sec= rs.getString("seccion");
				String mac= rs.getString("macizo");
				String bisa= rs.getString("bis");
				String bism= rs.getString("bis_macizo");
				String uni= rs.getString("unidad");
				String num= rs.getString("numero");
				
				if(sec.equals(seccion) && mac.equals(macizo) && uni.equals(unidad) && bisa.equals(bis) && num.equals(numero) && bism.equals(bismacizo)) {
					
					return true;

				}
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

			ResultSet rs = statement.executeQuery(" call verificarNewBoveda ('" + Circ + "','" + seccion + "','" + macizo + "','" + par + "','" + bis + "','" + unidad + "')");


			while (rs.next()) {
				
				
				String sec= rs.getString("seccion");
				String mac= rs.getString("macizo");
				String bisa= rs.getString("bis");
				String circ= rs.getString("Circ");
				String uni= rs.getString("unidad");
				String parc= rs.getString("parcela");
				
				if(sec.equals(seccion) && mac.equals(macizo) && uni.equals(unidad) && bisa.equals(bis) && parc.equals(par) && circ.equals(Circ)) {
					
					return true;

				}
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

			ResultSet rs = statement.executeQuery(" call verificarNewCenizario ('" + mueble_cenizas + "', '" + nicho_cenizas + "');");

				while (rs.next()) {
				
				
				
				String mue= rs.getString("mueble");
				String nich= rs.getString("nicho");
				
				if(mue.equals(mueble_cenizas) && nich.equals(nicho_cenizas)) {
					
					return true;

				}
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

			ResultSet rs = statement.executeQuery(" call verificarNewNichera ('" + Circ + "','" + seccion + "','" + macizo + "','" + par + "','"  + fila + "','" + unidad + "')");


			while (rs.next()) {
				
				
				String sec= rs.getString("seccion");
				String mac= rs.getString("macizo");
				String circ= rs.getString("Circ");
				String uni= rs.getString("unidad");
				String parc= rs.getString("parcela");
				String fil= rs.getString("fila");
				
				if(sec.equals(seccion) && mac.equals(macizo) && uni.equals(unidad) && fil.equals(fila) && parc.equals(par) && circ.equals(Circ)) {
					
					return true;

				}
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

			ResultSet rs = statement.executeQuery(" call verificarPalmerasS('" + sepulturaS + "');");


			while (rs.next()) {
				
			
				String sep= rs.getString("sepultura");
				System.out.println(sepulturaS + sep+ "mismo?");
				if(sepulturaS.equals(sep)) {
					System.out.println(sepulturaS + sep+ "si msmo ");
					return true;

				}
					

			}
			rs.close();

			statement.close();

			connection.close();

		} catch (SQLException ex) {

			System.out.println(ex);
			
		}
		System.out.println(sepulturaS + "no msmo ");
		return false;
		
	}

	public boolean verificarPalmerasRo(String nicho_ro, String fila_ro) {

		try {

			String url = "jdbc:mysql://sql143.main-hosting.eu:3306/u147800277_cemen";

			String username = "u147800277_ben";

			String password = "Tiburones";

			Connection connection = DriverManager.getConnection(url, username, password);

			java.sql.Statement statement = connection.createStatement();

			ResultSet rs = statement.executeQuery(" call verificarNewPalmerasRo ('" + nicho_ro + "', '" + fila_ro + "');");


			while (rs.next()) {
				

				String fil= rs.getString("fila");
				String nich= rs.getString("nicho");
				
				if(fil.equals(fila_ro) && nich.equals(nicho_ro)) {
					
					return true;

				}
					

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
	public void insertarPalmerasCeRE(String dni2, String nicho_ce, String fila_ce) {
		try {

			String url = "jdbc:mysql://sql143.main-hosting.eu:3306/u147800277_cemen";

			String username = "u147800277_ben";

			String password = "Tiburones";

			Connection connection = DriverManager.getConnection(url, username, password);

			java.sql.Statement statement = connection.createStatement();

			ResultSet rs = statement.executeQuery(" call insertarNewPalmerasCRE('" + dni2 + "','" + nicho_ce + "','" + fila_ce + "')");

			rs.close();

			statement.close();

			connection.close();
		
		} catch (SQLException ex) {

			System.out.println(ex);
		
		}
		
	}
	public boolean verificarNewpalmerasA(String nicho_a, String fila_a) {

		try {

			String url = "jdbc:mysql://sql143.main-hosting.eu:3306/u147800277_cemen";

			String username = "u147800277_ben";

			String password = "Tiburones";

			Connection connection = DriverManager.getConnection(url, username, password);

			java.sql.Statement statement = connection.createStatement();

			ResultSet rs = statement.executeQuery(" call verificarNewPalmerasA ('" + nicho_a + "', '" + fila_a + "');");


			while (rs.next()) {
				

				String fil= rs.getString("fila");
				String nich= rs.getString("nicho");
				
				if(fil.equals(fila_a) && nich.equals(nicho_a)) {
					
					return true;

				}
					

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

	public void insertarPalmerasARE(String dni2, String nicho_a, String fila_a) {
		try {

			String url = "jdbc:mysql://sql143.main-hosting.eu:3306/u147800277_cemen";

			String username = "u147800277_ben";

			String password = "Tiburones";

			Connection connection = DriverManager.getConnection(url, username, password);

			java.sql.Statement statement = connection.createStatement();

			ResultSet rs = statement.executeQuery(" call insertarNewPalmerasARE('" + dni2 + "','" + nicho_a + "','" + fila_a + "')");

			rs.close();

			statement.close();

			connection.close();
			
		} catch (SQLException ex) {

			System.out.println(ex);
			
		}
		
	}

	
	public boolean VerificarPalmerasCe(String nicho_ce, String fila_ce) {

		try {

			String url = "jdbc:mysql://sql143.main-hosting.eu:3306/u147800277_cemen";

			String username = "u147800277_ben";

			String password = "Tiburones";

			Connection connection = DriverManager.getConnection(url, username, password);

			java.sql.Statement statement = connection.createStatement();

			ResultSet rs = statement.executeQuery(" call verificarNewPalmerasC ('" + nicho_ce + "', '" + fila_ce + "');");


			while (rs.next()) {
				

				String fil= rs.getString("fila");
				String nich= rs.getString("nicho");
				
				if(fil.equals(fila_ce) && nich.equals(nicho_ce)) {
					
					return true;

				}
					

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
	public void insertarPalmerasRoRE(String dni2, String nicho_ro, String fila_ro) {
		try {

			String url = "jdbc:mysql://sql143.main-hosting.eu:3306/u147800277_cemen";

			String username = "u147800277_ben";

			String password = "Tiburones";

			Connection connection = DriverManager.getConnection(url, username, password);

			java.sql.Statement statement = connection.createStatement();

			ResultSet rs = statement.executeQuery(" call insertarNewPalmerasRoRE('" + dni2 + "','" + nicho_ro + "','" + fila_ro + "')");

			rs.close();

			statement.close();

			connection.close();
			
		} catch (SQLException ex) {

			System.out.println(ex);
			

		}
		
	}
	public boolean insertarPalmeras_S(String palmerasS) {


		try {

			String url = "jdbc:mysql://sql143.main-hosting.eu:3306/u147800277_cemen";

			String username = "u147800277_ben";

			String password = "Tiburones";

			Connection connection = DriverManager.getConnection(url, username, password);

			java.sql.Statement statement = connection.createStatement();
                  System.out.println(dni);
			ResultSet rs = statement.executeQuery(" call insertarNewPalmerasSep('" + palmerasS + "')");

			rs.close();

			statement.close();

			connection.close();
			return true;
		} catch (SQLException ex) {

			System.out.println(ex);
			return false;

		}

	}

	public void insertarPalmeras_Srep(String dni2, String sepulturaS) {

		try {

			String url = "jdbc:mysql://sql143.main-hosting.eu:3306/u147800277_cemen";

			String username = "u147800277_ben";

			String password = "Tiburones";

			Connection connection = DriverManager.getConnection(url, username, password);

			java.sql.Statement statement = connection.createStatement();
                  System.out.println(dni2);
			ResultSet rs = statement.executeQuery(" call insertarPalmerasSepREP('" + dni2 + "','" + sepulturaS + "')");

			rs.close();

			statement.close();

			connection.close();
			
		} catch (SQLException ex) {

			System.out.println(ex);
			

		}
	}
	
	public boolean insertarNichera(String dni,String Circ, String seccion, String macizo, String par, String fila, String unidad) {

		
		try {

			String url = "jdbc:mysql://sql143.main-hosting.eu:3306/u147800277_cemen";

			String username = "u147800277_ben";

			String password = "Tiburones";

			Connection connection = DriverManager.getConnection(url, username, password);

			java.sql.Statement statement = connection.createStatement();

			ResultSet rs = statement.executeQuery(" call insertarNewNichera ('" + Circ + "','" + seccion + "', '" + macizo + "', '" + par + "', '" + fila + "', '" + unidad + "');");

			rs.close();

			statement.close();

			connection.close();
			return true;
		} catch (SQLException ex) {

			System.out.println(ex);
			return false;

		}

	}
		

	public void insertarNicheraRE(String dni2, String circ, String seccion, String macizo, String parcela, String fila,
			String unidad) {try {

				String url = "jdbc:mysql://sql143.main-hosting.eu:3306/u147800277_cemen";

				String username = "u147800277_ben";

				String password = "Tiburones";

				Connection connection = DriverManager.getConnection(url, username, password);

				java.sql.Statement statement = connection.createStatement();

				ResultSet rs = statement.executeQuery(" call insertarNewNicheraRE ('" + dni2 + "','" + circ + "','" + seccion + "', '" + macizo + "', '" + parcela + "', '" + fila + "', '" + unidad + "');");

				rs.close();

				statement.close();

				connection.close();
				
			} catch (SQLException ex) {

				System.out.println(ex);
			
			}
	}
	
	public boolean InsertarCenizario(String mueble, String nicho) {

		try {

			String url = "jdbc:mysql://sql143.main-hosting.eu:3306/u147800277_cemen";

			String username = "u147800277_ben";

			String password = "Tiburones";

			Connection connection = DriverManager.getConnection(url, username, password);

			java.sql.Statement statement = connection.createStatement();

			ResultSet rs = statement.executeQuery(" call insertarNewCenizario('" + mueble + "','" + nicho + "')");

			rs.close();

			statement.close();

			connection.close();
			return true;
		} catch (SQLException ex) {

			System.out.println(ex);
			return false;

		}

	}
	
	public void InsertarCenizarioRE(String dni3, String mueble, String nicho) {
		try {

			String url = "jdbc:mysql://sql143.main-hosting.eu:3306/u147800277_cemen";

			String username = "u147800277_ben";

			String password = "Tiburones";

			Connection connection = DriverManager.getConnection(url, username, password);

			java.sql.Statement statement = connection.createStatement();

			ResultSet rs = statement.executeQuery(" call insertarNewCenizarioRE('" + dni3 + "','" + mueble + "','" + nicho + "')");

			rs.close();

			statement.close();

			connection.close();
			
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(
					   null,
					   "ya existe este dni para esta ubicacion ");

			System.out.println(ex);
			

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

	public boolean insertarBovedasRE(String dni4, String  Circ, String seccion, String macizo, String parcela, String bis, String unidad) {

		try {

			String url = "jdbc:mysql://sql143.main-hosting.eu:3306/u147800277_cemen";

			String username = "u147800277_ben";

			String password = "Tiburones";

			Connection connection = DriverManager.getConnection(url, username, password);

			java.sql.Statement statement = connection.createStatement();

			ResultSet rs = statement.executeQuery(" call insertarNewBovedaRE('" + dni4 + "','" + Circ + "', '" + seccion+ "', '" + macizo + "', '" + parcela + "', '" + bis + "', '" + unidad + "');");

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
	public void insertarSepulturaREP(String dni2, String seccion, String macizo, String bismacizo, String unidad,
			String numero, String bis) {
		try {

			String url = "jdbc:mysql://sql143.main-hosting.eu:3306/u147800277_cemen";

			String username = "u147800277_ben";

			String password = "Tiburones";

			Connection connection = DriverManager.getConnection(url, username, password);

			java.sql.Statement statement = connection.createStatement();

			ResultSet rs = statement.executeQuery(" call insertarNewSepulturaREP('" + dni2 + "', '" + seccion + "', '" + macizo + "', '" + bismacizo + "', '" + unidad + "', '" + numero + "', '" + bis + "');");

			rs.close();

			statement.close();

			connection.close();
			
		} catch (SQLException ex) {

			System.out.println(ex);
			

		}
		
	}


	public boolean insertarIndigentes(String seccion, String macizo, String sepultura , String inhumacion) {

		
		try {

			String url = "jdbc:mysql://sql143.main-hosting.eu:3306/u147800277_cemen";

			String username = "u147800277_ben";

			String password = "Tiburones";

			Connection connection = DriverManager.getConnection(url, username, password);

			java.sql.Statement statement = connection.createStatement();

			ResultSet rs = statement.executeQuery(" call insertarNewIndigente('" + seccion + "', '" + macizo + "', '" + sepultura + "', '" + inhumacion + "');");

			rs.close();

			statement.close();

			connection.close();
			return true;
		} catch (SQLException ex) {

			System.out.println(ex);
			return false;

		}

	}

	public void insertarIndigentesREP(String dni,String seccion, String macizo, String sepultura, String inhumacion) {
		// TODO Auto-generated method stub
		try {

			String url = "jdbc:mysql://sql143.main-hosting.eu:3306/u147800277_cemen";

			String username = "u147800277_ben";

			String password = "Tiburones";

			Connection connection = DriverManager.getConnection(url, username, password);

			java.sql.Statement statement = connection.createStatement();

			ResultSet rs = statement.executeQuery(" call insertarNewIndigenteREP('"+ dni + "', '"  + seccion + "', '" + macizo + "', '" + sepultura + "', '" + inhumacion + "');");

			rs.close();

			statement.close();

			connection.close();
			
		} catch (SQLException ex) {

			System.out.println(ex);
			

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

			System.out.println(this.fecha_fallecimiento);
			
			query =	" CALL buscarNewClientes('"+ this.apellidos +"' ,'"+ this.nombres + "',  '" + this.dni + "' , '"
					+ this.dni_ocupante + "', '"+this.telefono+"', '"+this.fecha_fallecimiento+"')";
			query= query.replaceAll("''", "null");
			rs = statement.executeQuery( query);
			System.out.println(query);
			while (rs.next()) {



				Clientes aux = new Clientes();

				aux.setApellidos(rs.getString("apellido"));

				aux.setNombres(rs.getString("nombres"));

				aux.setDni(rs.getString("dni"));

				Date ff = rs.getDate("fecha_fallecimiento");

				java.text.SimpleDateFormat sdf =

						new java.text.SimpleDateFormat("yyyy-MM-dd");

				String currentTime = ff.getYear() + "-" + ff.getMonth() + "-" + ff.getDate();// sdf.format(date);

				aux.setFecha_fallec(currentTime);

				aux.setDni_ocupante(rs.getString("dni_ocupante"));

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
					" call buscar('" + apellido + "', '" + nombres + "');");

		
			
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

	public Clientes BuscarPorUbicacion(String sepulturaS) {
		ResultSet rs = null;

		Clientes client = new Clientes();

		String url = "jdbc:mysql://sql143.main-hosting.eu:3306/u147800277_cemen";

		String username = "u147800277_ben";

		String password = "Tiburones";

		Connection connection = null;

		java.sql.Statement statement = null;
		String query ="";
		try {

			connection = DriverManager.getConnection(url, username, password);

			statement = connection.createStatement();
			query =	" CALL buscarClientesPalmerasS('"+ sepulturaS+"')";
					
			rs = statement.executeQuery( query);
			
			while (rs.next()) {


				this.setApellidos(rs.getString("apellido"));

				this.setNombres(rs.getString("nombres"));

				this.setDni(rs.getString("dni"));

				Date ff = rs.getDate("fecha_fallecimiento");

				java.text.SimpleDateFormat sdf =

						new java.text.SimpleDateFormat("yyyy-MM-dd");

				String currentTime = ff.getYear() + "-" + ff.getMonth() + "-" + ff.getDate();// sdf.format(date);

				this.setFecha_fallec(currentTime);

				this.setDni_ocupante(rs.getString("direccion"));

				this.setNombre_familiar(rs.getString("nombre_familiar"));

				this.setTelefono(rs.getString("telefono_familiar"));

				this.setEmail(rs.getString("email_familiar"));

				this.setEmail(rs.getString("cocheria"));


			}

			rs.close();

			statement.close();

			connection.close();

		} catch (SQLException ex) {

			System.out.println(ex);

		}



		return this;

	}
			
	public Clientes buscarClienteenSepulturasSeccionC4(String campo1,String campo2, String campo3, String campo4){

		Clientes aux = new Clientes();
		try {
		  String url ="jdbc:mysql://sql143.main-hosting.eu:3306/u147800277_cemen";
		  String username = "u147800277_ben";
		  String password = "Tiburones";
		 
		  Connection connection = DriverManager.getConnection(url, username, password);
		  
		  java.sql.Statement statement = connection.createStatement();

		  ResultSet rs = statement.executeQuery(" CALL  buscarClienteIndigentesporUbi ( '"+campo1+"'  ,  '"+campo2+"'  ,  '"+campo3+"','"+campo4+"')");

		  while (rs.next()) {


				this.setApellidos(rs.getString("apellido"));

				this.setNombres(rs.getString("nombres"));

				this.setDni(rs.getString("dni"));

				Date ff = rs.getDate("fecha_fallecimiento");

				java.text.SimpleDateFormat sdf =

						new java.text.SimpleDateFormat("yyyy-MM-dd");

				String currentTime = ff.getYear() + "-" + ff.getMonth() + "-" + ff.getDate();// sdf.format(date);

				this.setFecha_fallec(currentTime);

				this.setDni_ocupante(rs.getString("direccion"));

				this.setNombre_familiar(rs.getString("nombre_familiar"));

				this.setTelefono(rs.getString("telefono_familiar"));

				this.setEmail(rs.getString("email_familiar"));

				this.setEmail(rs.getString("cocheria"));


			}

			rs.close();

			statement.close();

			connection.close();

		} catch (SQLException ex) {

			System.out.println(ex);

		}



		return this;

	}

	public Clientes buscarClienteenSepultura(String seccion, String macizo, String bis_macizo, String unidad,
			String numero, String bis) {
		
		Clientes aux = new Clientes();
		try {
		  String url ="jdbc:mysql://sql143.main-hosting.eu:3306/u147800277_cemen";
		  String username = "u147800277_ben";
		  String password = "Tiburones";
		 
		  Connection connection = DriverManager.getConnection(url, username, password);
		  
		  java.sql.Statement statement = connection.createStatement();

		  ResultSet rs = statement.executeQuery(" CALL  buscarClienteIndigentesporUbi ( '"+seccion+"'  ,  '"+macizo+"'  ,  '"+bis_macizo+"'  ,  '"+unidad+"','"+numero+"'  ,  '"+bis+"')");

		  while (rs.next()) {


				this.setApellidos(rs.getString("apellido"));

				this.setNombres(rs.getString("nombres"));

				this.setDni(rs.getString("dni"));

				Date ff = rs.getDate("fecha_fallecimiento");

				java.text.SimpleDateFormat sdf =

						new java.text.SimpleDateFormat("yyyy-MM-dd");

				String currentTime = ff.getYear() + "-" + ff.getMonth() + "-" + ff.getDate();// sdf.format(date);

				this.setFecha_fallec(currentTime);

				this.setDni_ocupante(rs.getString("direccion"));

				this.setNombre_familiar(rs.getString("nombre_familiar"));

				this.setTelefono(rs.getString("telefono_familiar"));

				this.setEmail(rs.getString("email_familiar"));

				this.setEmail(rs.getString("cocheria"));


			}

			rs.close();

			statement.close();

			connection.close();

		} catch (SQLException ex) {

			System.out.println(ex);

		}



		return this;

	}

	public Clientes BuscarPalmerasaA(String nicho_a, String fila_a) {
		
		try {
		  String url ="jdbc:mysql://sql143.main-hosting.eu:3306/u147800277_cemen";
		  String username = "u147800277_ben";
		  String password = "Tiburones";
		 
		  Connection connection = DriverManager.getConnection(url, username, password);
		  
		  java.sql.Statement statement = connection.createStatement();

		  ResultSet rs = statement.executeQuery(" CALL  buscarPalmerasAporUbi( '"+nicho_a+"'  ,  '"+fila_a+"')");

		  while (rs.next()) {


				this.setApellidos(rs.getString("apellido"));

				this.setNombres(rs.getString("nombres"));

				this.setDni(rs.getString("dni"));

				Date ff = rs.getDate("fecha_fallecimiento");

				java.text.SimpleDateFormat sdf =

						new java.text.SimpleDateFormat("yyyy-MM-dd");

				String currentTime = ff.getYear() + "-" + ff.getMonth() + "-" + ff.getDate();// sdf.format(date);

				this.setFecha_fallec(currentTime);

				this.setDni_ocupante(rs.getString("direccion"));

				this.setNombre_familiar(rs.getString("nombre_familiar"));

				this.setTelefono(rs.getString("telefono_familiar"));

				this.setEmail(rs.getString("email_familiar"));

				this.setEmail(rs.getString("cocheria"));


			}

			rs.close();

			statement.close();

			connection.close();

		} catch (SQLException ex) {

			System.out.println(ex);

		}



		return this;

	}

	public Clientes buscarClienteenPalmerasCenizas(String nicho_ce, String fila_ce) {
		try {
			  String url ="jdbc:mysql://sql143.main-hosting.eu:3306/u147800277_cemen";
			  String username = "u147800277_ben";
			  String password = "Tiburones";
			 
			  Connection connection = DriverManager.getConnection(url, username, password);
			  
			  java.sql.Statement statement = connection.createStatement();

			  ResultSet rs = statement.executeQuery(" CALL  buscarPalmerasCporUbi( '"+nicho_ce+"'  ,  '"+fila_ce+"')");

			  while (rs.next()) {


					this.setApellidos(rs.getString("apellido"));

					this.setNombres(rs.getString("nombres"));

					this.setDni(rs.getString("dni"));

					Date ff = rs.getDate("fecha_fallecimiento");

					java.text.SimpleDateFormat sdf =

							new java.text.SimpleDateFormat("yyyy-MM-dd");

					String currentTime = ff.getYear() + "-" + ff.getMonth() + "-" + ff.getDate();// sdf.format(date);

					this.setFecha_fallec(currentTime);

					this.setDni_ocupante(rs.getString("direccion"));

					this.setNombre_familiar(rs.getString("nombre_familiar"));

					this.setTelefono(rs.getString("telefono_familiar"));

					this.setEmail(rs.getString("email_familiar"));

					this.setEmail(rs.getString("cocheria"));


				}

				rs.close();

				statement.close();

				connection.close();

			} catch (SQLException ex) {

				System.out.println(ex);

			}



			return this;
	}

	public Clientes buscarPalmerasRo(String nicho_ro, String fila_ro) {
		try {
			  String url ="jdbc:mysql://sql143.main-hosting.eu:3306/u147800277_cemen";
			  String username = "u147800277_ben";
			  String password = "Tiburones";
			 
			  Connection connection = DriverManager.getConnection(url, username, password);
			  
			  java.sql.Statement statement = connection.createStatement();

			  ResultSet rs = statement.executeQuery(" CALL  buscarPalmerasRoporUbi( '"+nicho_ro+"'  ,  '"+fila_ro+"')");

			  while (rs.next()) {


					this.setApellidos(rs.getString("apellido"));

					this.setNombres(rs.getString("nombres"));

					this.setDni(rs.getString("dni"));

					Date ff = rs.getDate("fecha_fallecimiento");

					java.text.SimpleDateFormat sdf =

							new java.text.SimpleDateFormat("yyyy-MM-dd");

					String currentTime = ff.getYear() + "-" + ff.getMonth() + "-" + ff.getDate();// sdf.format(date);

					this.setFecha_fallec(currentTime);

					this.setDni_ocupante(rs.getString("direccion"));

					this.setNombre_familiar(rs.getString("nombre_familiar"));

					this.setTelefono(rs.getString("telefono_familiar"));

					this.setEmail(rs.getString("email_familiar"));

					this.setEmail(rs.getString("cocheria"));


				}

				rs.close();

				statement.close();

				connection.close();

			} catch (SQLException ex) {

				System.out.println(ex);

			}



			return this;
	}

	public Clientes buscarNicheraporUbi(String circ, String seccion, String macizo, String par, String fila,
			String unidad) {
		try {
			  String url ="jdbc:mysql://sql143.main-hosting.eu:3306/u147800277_cemen";
			  String username = "u147800277_ben";
			  String password = "Tiburones";
			 
			  Connection connection = DriverManager.getConnection(url, username, password);
			  
			  java.sql.Statement statement = connection.createStatement();

			  ResultSet rs = statement.executeQuery(" CALL  buscarNicheraporUbi( '" + circ + "','" + seccion + "','" + macizo + "','" + par + "','"  + fila + "','" + unidad + "')");

			  while (rs.next()) {


					this.setApellidos(rs.getString("apellido"));

					this.setNombres(rs.getString("nombres"));

					this.setDni(rs.getString("dni"));

					Date ff = rs.getDate("fecha_fallecimiento");

					java.text.SimpleDateFormat sdf =

							new java.text.SimpleDateFormat("yyyy-MM-dd");

					String currentTime = ff.getYear() + "-" + ff.getMonth() + "-" + ff.getDate();// sdf.format(date);

					this.setFecha_fallec(currentTime);

					this.setDni_ocupante(rs.getString("direccion"));

					this.setNombre_familiar(rs.getString("nombre_familiar"));

					this.setTelefono(rs.getString("telefono_familiar"));

					this.setEmail(rs.getString("email_familiar"));

					this.setEmail(rs.getString("cocheria"));


				}

				rs.close();

				statement.close();

				connection.close();

			} catch (SQLException ex) {

				System.out.println(ex);

			}



			return this;
		
	}

	public Clientes buscarCenizarioporUbi(String mueble, String nicho) {
		try {
			  String url ="jdbc:mysql://sql143.main-hosting.eu:3306/u147800277_cemen";
			  String username = "u147800277_ben";
			  String password = "Tiburones";
			 
			  Connection connection = DriverManager.getConnection(url, username, password);
			  
			  java.sql.Statement statement = connection.createStatement();

			  ResultSet rs = statement.executeQuery(" CALL  buscarCenizarioporUbi( '" + mueble +"','" + nicho + "')");

			  while (rs.next()) {


					this.setApellidos(rs.getString("apellido"));

					this.setNombres(rs.getString("nombres"));

					this.setDni(rs.getString("dni"));

					Date ff = rs.getDate("fecha_fallecimiento");

					java.text.SimpleDateFormat sdf =

							new java.text.SimpleDateFormat("yyyy-MM-dd");

					String currentTime = ff.getYear() + "-" + ff.getMonth() + "-" + ff.getDate();// sdf.format(date);

					this.setFecha_fallec(currentTime);

					this.setDni_ocupante(rs.getString("direccion"));

					this.setNombre_familiar(rs.getString("nombre_familiar"));

					this.setTelefono(rs.getString("telefono_familiar"));

					this.setEmail(rs.getString("email_familiar"));

					this.setEmail(rs.getString("cocheria"));


				}

				rs.close();

				statement.close();

				connection.close();

			} catch (SQLException ex) {

				System.out.println(ex);

			}



			return this;
	}

	public Clientes buscarBovedasporUbi(String circ_boveda, String seccion_boveda, String macizo_boveda,
			String parcela_boveda, String bis_boveda, String unidad_boveda) {
		try {
			  String url ="jdbc:mysql://sql143.main-hosting.eu:3306/u147800277_cemen";
			  String username = "u147800277_ben";
			  String password = "Tiburones";
			 
			  Connection connection = DriverManager.getConnection(url, username, password);
			  
			  java.sql.Statement statement = connection.createStatement();

			  ResultSet rs = statement.executeQuery(" CALL  buscarBovedaporUbi( '" + circ_boveda + "','" + seccion_boveda + "','" + macizo_boveda + "','" + parcela_boveda + "','" + bis_boveda + "','" + unidad_boveda + "')");

			  while (rs.next()) {


					this.setApellidos(rs.getString("apellido"));

					this.setNombres(rs.getString("nombres"));

					this.setDni(rs.getString("dni"));

					Date ff = rs.getDate("fecha_fallecimiento");

					java.text.SimpleDateFormat sdf =

							new java.text.SimpleDateFormat("yyyy-MM-dd");

					String currentTime = ff.getYear() + "-" + ff.getMonth() + "-" + ff.getDate();// sdf.format(date);

					this.setFecha_fallec(currentTime);

					this.setDni_ocupante(rs.getString("direccion"));

					this.setNombre_familiar(rs.getString("nombre_familiar"));

					this.setTelefono(rs.getString("telefono_familiar"));

					this.setEmail(rs.getString("email_familiar"));

					this.setEmail(rs.getString("cocheria"));


				}

				rs.close();

				statement.close();

				connection.close();

			} catch (SQLException ex) {

				System.out.println(ex);

			}



			return this;
	}

	public boolean existeCliente(String dni) {
		String query ="";
		try {
			  String url ="jdbc:mysql://sql143.main-hosting.eu:3306/u147800277_cemen";
			  String username = "u147800277_ben";
			  String password = "Tiburones";
			 
			  Connection connection = DriverManager.getConnection(url, username, password);
			  
			  java.sql.Statement statement = connection.createStatement();
			  
			  query=" CALL  buscarporDni( '"+dni+"')";
			  System.out.println( dni+ "osso");
			  query= query.replaceAll("''", "null");
			  ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				  System.out.println( rs.getString("dni")+ "eeesso");
				String dni2= rs.getString("dni");
				
				if(dni2.equals(dni)) {
					System.out.println(dni2 + dni+ "osso");
					return true;

				}
					

				}

				rs.close();

				statement.close();

				connection.close();

			} catch (SQLException ex) {

				System.out.println(ex);

			}

	
		return false;
	}

	public boolean existeCliente2(String dni) {
		String query ="";
		try {
			  String url ="jdbc:mysql://sql143.main-hosting.eu:3306/u147800277_cemen";
			  String username = "u147800277_ben";
			  String password = "Tiburones";
			 
			  Connection connection = DriverManager.getConnection(url, username, password);
			  
			  java.sql.Statement statement = connection.createStatement();
			  
			  query=" CALL  buscarporDni2( '"+dni+"')";
			  System.out.println( dni+ "osso");
			  query= query.replaceAll("''", "null");
			  ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				  System.out.println( rs.getString("dni")+ "eeesso");
				String dni2= rs.getString("dni_ocupante");
				
				if(dni2.equals(dni)) {
					System.out.println(dni2 + dni+ "osso");
					return true;

				}
					

				}

				rs.close();

				statement.close();

				connection.close();

			} catch (SQLException ex) {

				System.out.println(ex);

			}

	
		return false;
	}
	
	/*public String colocardni() {
		
			String query ="";
			int acum=1;
			String num="";
			try {
				  String url ="jdbc:mysql://sql143.main-hosting.eu:3306/u147800277_cemen";
				  String username = "u147800277_ben";
				  String password = "Tiburones";
				 
				  Connection connection = DriverManager.getConnection(url, username, password);
				  
				  java.sql.Statement statement = connection.createStatement();
				  
				  query=" insert into Acumulador (acum_id,acum) values('"+acum+"')";
				  System.out.println( acum+ "otttt");
				  query= query.replaceAll("''", "null");
				  ResultSet rs = statement.executeQuery(query);
				while (rs.next()) {
					 
					 num= rs.getString("cliente_id");
					
				
						
					}

					rs.close();

					statement.close();

					connection.close();

				} catch (SQLException ex) {

					System.out.println(ex);

				}
			return num;

		
		
	}*/



	

	










}

