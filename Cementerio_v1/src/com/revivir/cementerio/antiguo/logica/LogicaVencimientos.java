package logica;





	import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

	public class LogicaVencimientos {

		DateFormat df = new SimpleDateFormat("yyyy/MM/dd");


	private java.util.Date fecha;	
	private int id_ubicacion;
	

	public LogicaVencimientos() {
		fecha = null;
		id_ubicacion=0;
		
	}

	public LogicaVencimientos(Date fecha,int id ) {
		
		this.fecha=fecha;
		this.id_ubicacion=id;
		
		
	}
	
		
	public java.util.Date getFecha() {
		return fecha;
	}

	public void setFecha(java.util.Date date) {
		this.fecha = date;
	}

	public int getId_ubicacion() {
		return id_ubicacion;
	}

	public void setId_ubicacion(int id_ubicacion) {
		this.id_ubicacion = id_ubicacion;
	}

	public void guardarFecha(){
		
		try {

		    String url ="jdbc:mysql://sql143.main-hosting.eu/u147800277_cemen";
		    String username = "u147800277_ben";
		    String password = "Tiburones";

		    Connection connection = DriverManager.getConnection(url, username, password);
		
		    java.sql.Statement statement = connection.createStatement();
		    
		    String a = df.format(getFecha());
		   
		    ResultSet rs = statement.executeQuery("CALL insertarVencimiento ('"+a+"','"+this.getId_ubicacion()+"')");

		    rs.close();
		    statement.close();
		    connection.close();
		    JOptionPane.showMessageDialog(
					   null,
					   "Se guardó el vencimiento");
		} catch (SQLException ex) {
		    System.out.println(ex);
		}
		
	}

	public void ModificarVencimiento() {
		try {

		    String url ="jdbc:mysql://sql143.main-hosting.eu/u147800277_cemen";
		    String username = "u147800277_ben";
		    String password = "Tiburones";

		    Connection connection = DriverManager.getConnection(url, username, password);

		    java.sql.Statement statement = connection.createStatement();
		    String a = df.format(getFecha());
		    ResultSet rs = statement.executeQuery("CALL ModificarVencimiento ('"+a+"','"+this.getId_ubicacion()+"')");

		    rs.close();
		    statement.close();
		    connection.close();
		    JOptionPane.showMessageDialog(
					   null,
					   "Se actualizó el vencimiento");
		} catch (SQLException ex) {
		    System.out.println(ex);
		}
		
		
	}

	

	

	
}
