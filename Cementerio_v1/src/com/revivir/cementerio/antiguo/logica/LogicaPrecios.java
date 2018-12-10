package com.revivir.cementerio.antiguo.logica;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class LogicaPrecios {



private float precio;	
private int codigo;
private String descripcion;

public LogicaPrecios() {
	precio= 0;
	codigo=0;
	descripcion="";
}

public LogicaPrecios(float precio1,int codigo2,String  descripcion3) {
	
	this.precio=precio1;
	this.codigo=codigo2;
	this.descripcion=descripcion3; 
	
}
public float getPrecio() {
	return precio;
}

public void setPrecio(float precio) {
	this.precio = precio;
}

public int getCodigo() {
	return codigo;
}

public void setCodigo(int codigo) {
	this.codigo = codigo;
}

public String getDescripcion() {
	return descripcion;
}

public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}
	
public void crearCodigo(){
	
	try {

	    String url ="jdbc:mysql://sql143.main-hosting.eu/u147800277_cemen";
	    String username = "u147800277_ben";
	    String password = "Tiburones";

	    Connection connection = DriverManager.getConnection(url, username, password);

	    java.sql.Statement statement = connection.createStatement();
	    ResultSet rs = statement.executeQuery("CALL insertarCodigo ('"+this.getPrecio()+"','"+this.getCodigo()+"','"+this.getDescripcion()+"')");

	    rs.close();
	    statement.close();
	    connection.close();
	    JOptionPane.showMessageDialog(
				   null,
				   "Se ha insertado un nuevo codigo");
	} catch (SQLException ex) {
	    System.out.println(ex);
	}
	
}

public void ModificarCodigo() {
	try {

	    String url ="jdbc:mysql://sql143.main-hosting.eu/u147800277_cemen";
	    String username = "u147800277_ben";
	    String password = "Tiburones";

	    Connection connection = DriverManager.getConnection(url, username, password);

	    java.sql.Statement statement = connection.createStatement();
	    ResultSet rs = statement.executeQuery("CALL ModificarCodigo ('"+this.getPrecio()+"','"+this.getCodigo()+"','"+this.getDescripcion()+"')");

	    rs.close();
	    statement.close();
	    connection.close();
	    JOptionPane.showMessageDialog(
				   null,
				   "Se ha modificado el codigo");
	} catch (SQLException ex) {
	    System.out.println(ex);
	}
	
	
}

public ArrayList<LogicaPrecios> BuscarCodigo() {
	
	ResultSet rs = null;

	ArrayList<LogicaPrecios> ListaPrecios = new ArrayList<LogicaPrecios>();

	String url = "jdbc:mysql://sql143.main-hosting.eu:3306/u147800277_cemen";

	String username = "u147800277_ben";

	String password = "Tiburones";

	Connection connection = null;

	java.sql.Statement statement = null;
	String query ="";
	try {

		connection = DriverManager.getConnection(url, username, password);

		statement = connection.createStatement();
	
	query = "select * from codigos where codigos.id =  '"+ this.codigo +"' or codigos.descripcion LIKE '"+ this.descripcion +"%"+ "';";

	rs = statement.executeQuery( query);
	
	while (rs.next()) {

		LogicaPrecios aux = new LogicaPrecios();
		int codigo = Integer.parseInt(rs.getString("id"));
		Float precio = Float.parseFloat(rs.getString("importe"));
		aux.setCodigo(codigo);

		aux.setDescripcion(rs.getString("descripcion"));
		aux.setPrecio(precio);

	



		ListaPrecios.add(aux);
		

	}

	rs.close();

	statement.close();

	connection.close();

} catch (SQLException ex) {

	System.out.println(ex);

}



return ListaPrecios;

}




}
