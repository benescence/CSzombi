package logica;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;




public class Users {

	private String id;
	private String pwd;
	private Integer tipo;
	
	public Users (){
		id = "";
		pwd = "";
		tipo = 1;
	}
	public Users (String u, String p, Integer t){
		id = u;
		pwd = p;
		tipo = t;
	}
	
	public void setId (String i){
		id = i;
	}
	public void setpwd (String p){
		pwd = p;
	}
	public void settype (Integer t){
		tipo = t;
	}
	public String getId (){
		return id;
	}
	public String getPwd (){
		return pwd;
	}
	public Integer getType (){
		return tipo;
	}
	public boolean ValidateUser(Users datos){
//		Connect cn = new Connect();

		 try {
			  String url ="jdbc:mysql://sql143.main-hosting.eu/u147800277_cemen";
			    String username = "u147800277_ben";
			    String password = "Tiburones";
			    Connection connection = DriverManager.getConnection(url, username, password);

			    java.sql.Statement statement = connection.createStatement();
			    ResultSet rs = statement.executeQuery("Select * from `login` where u_name ='"+datos.getId()+"' and u_pass ='"+datos.getPwd()+"'");
			
			if (rs.next()){	
			return true;
			}else{
				return false;
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public void crearUsuario(){
		
		try {

		    String url ="jdbc:mysql://sql143.main-hosting.eu/u147800277_cemen";
		    String username = "u147800277_ben";
		    String password = "Tiburones";

		    Connection connection = DriverManager.getConnection(url, username, password);

		    java.sql.Statement statement = connection.createStatement();
		    ResultSet rs = statement.executeQuery("CALL crearusuario ('"+this.getId()+"','"+this.getPwd()+"','"+this.getType()+"')");

		    rs.close();
		    statement.close();
		    connection.close();
		    JOptionPane.showMessageDialog(
					   null,
					   "Se ha creado el nuevo usuario");
		} catch (SQLException ex) {
		    System.out.println(ex);
		}
		
	}
	
public void buscarUsuario(ArrayList<Users> u){
		
		try {

		    String url ="jdbc:mysql://sql143.main-hosting.eu/u147800277_cemen";
		    String username = "u147800277_ben";
		    String password = "Tiburones";

		    Connection connection = DriverManager.getConnection(url, username, password);

		    java.sql.Statement statement = connection.createStatement();
		  //  ResultSet rs = statement.executeQuery("CALL ('"+this.getId()+"','"+this.getPwd()+")");
		    ResultSet rs = statement.executeQuery("Select * from login where u_name ='"+this.getId()+"' or u_tipo ="+this.getType());
		    
		    while (rs.next()) {
		    	
		    	String name = rs.getString("u_name");
		    	String pwd = rs.getString("u_pass");
		    	Integer tipo = rs.getInt("u_tipo");
                
               	Users aux = new Users(name, pwd, tipo);
                u.add(aux);
            }
		    
		    rs.close();
		    statement.close();
		    connection.close();

		} catch (SQLException ex) {
		    System.out.println(ex);
		}
		
	}

public void buscarUnUsuario(Users u){
	
	try {

	    String url ="jdbc:mysql://sql143.main-hosting.eu/u147800277_cemen";
	    String username = "u147800277_ben";
	    String password = "Tiburones";

	    Connection connection = DriverManager.getConnection(url, username, password);

	    java.sql.Statement statement = connection.createStatement();
	  //  ResultSet rs = statement.executeQuery("CALL ('"+this.getId()+"','"+this.getPwd()+")");
	    ResultSet rs = statement.executeQuery("Select * from login where u_name ='"+this.getId()+"' and u_tipo ='"+this.getType()+"';");
	   
	    if ( rs!=null){	
		    	String name = rs.getString("u_name");
		    	String pwd = rs.getString("u_pass");
		    	Integer tipo = rs.getInt("u_tipo");
	            
	           	Users aux = new Users(name, pwd, tipo);	       
		    
		    rs.close();
		    statement.close();
		    connection.close();
	    }

	} catch (SQLException ex) {
	    System.out.println(ex);
	}
	
}


	  public static void main(String[] args) {
		  Users u = new Users();
		  u.setId("Gabyta");
		  u.setpwd("123");
		  u.settype(0);
		  u.crearUsuario();
	  }
	  
}
