package logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ubicaciones {
 
String unidad_boveda;
String mueble_cenizas;
String nicho_cenizas;
String seccion_nichera;
String macizo_nichera;
String par_nichera;
String fila_nichera;
String unidad_nichera;
String nicho_palmeras_ataud;
String fila_palmeras_ataud;
String nicho_palmeras_cen;
String fila_palmeras_cen;
String nicho_palmeras_ro;
String fila_palmeras_ro;
String palmeras_Sepulturas;
String seccion_sepulturas;
String lote_sepulturas;
String unidad_pulturas;
String bis_sepulturas;
String lote_adulto;
String lote_angelito;
String inhumaciuon;
String otrocementerio;
String osario;
String deposito;



public ubicaciones() {

	unidad_boveda="";
	 mueble_cenizas="";
	 nicho_cenizas="";
	 seccion_nichera="";
	 macizo_nichera="";
	 par_nichera="";
	 fila_nichera="";
	 unidad_nichera="";
	 nicho_palmeras_ataud="";
	 fila_palmeras_ataud="";
	 nicho_palmeras_cen="";
	 fila_palmeras_cen="";
	 nicho_palmeras_ro="";
	 fila_palmeras_ro="";
	 palmeras_Sepulturas="";
	 seccion_sepulturas="";
	 lote_sepulturas="";
	 unidad_pulturas="";
	 bis_sepulturas="";
	 lote_adulto="";
	 lote_angelito="";
	 inhumaciuon="";
	 otrocementerio="";
	 osario="";
	 deposito="";
}



public String getUnidad_boveda() {
	return unidad_boveda;
}



public void setUnidad_boveda(String unidad_boveda) {
	this.unidad_boveda = unidad_boveda;
}



public String getMueble_cenizas() {
	return mueble_cenizas;
}



public void setMueble_cenizas(String mueble_cenizas) {
	this.mueble_cenizas = mueble_cenizas;
}



public String getNicho_cenizas() {
	return nicho_cenizas;
}



public void setNicho_cenizas(String nicho_cenizas) {
	this.nicho_cenizas = nicho_cenizas;
}



public String getSeccion_nichera() {
	return seccion_nichera;
}



public void setSeccion_nichera(String seccion_nichera) {
	this.seccion_nichera = seccion_nichera;
}



public String getMacizo_nichera() {
	return macizo_nichera;
}



public void setMacizo_nichera(String macizo_nichera) {
	this.macizo_nichera = macizo_nichera;
}



public String getPar_nichera() {
	return par_nichera;
}



public void setPar_nichera(String par_nichera) {
	this.par_nichera = par_nichera;
}



public String getFila_nichera() {
	return fila_nichera;
}



public void setFila_nichera(String fila_nichera) {
	this.fila_nichera = fila_nichera;
}



public String getUnidad_nichera() {
	return unidad_nichera;
}



public void setUnidad_nichera(String unidad_nichera) {
	this.unidad_nichera = unidad_nichera;
}



public String getNicho_palmeras_ataud() {
	return nicho_palmeras_ataud;
}



public void setNicho_palmeras_ataud(String nicho_palmeras_ataud) {
	this.nicho_palmeras_ataud = nicho_palmeras_ataud;
}



public String getFila_palmeras_ataud() {
	return fila_palmeras_ataud;
}



public void setFila_palmeras_ataud(String fila_palmeras_ataud) {
	this.fila_palmeras_ataud = fila_palmeras_ataud;
}



public String getNicho_palmeras_cen() {
	return nicho_palmeras_cen;
}



public void setNicho_palmeras_cen(String nicho_palmeras_cen) {
	this.nicho_palmeras_cen = nicho_palmeras_cen;
}



public String getFila_palmeras_cen() {
	return fila_palmeras_cen;
}



public void setFila_palmeras_cen(String fila_palmeras_cen) {
	this.fila_palmeras_cen = fila_palmeras_cen;
}



public String getNicho_palmeras_ro() {
	return nicho_palmeras_ro;
}



public void setNicho_palmeras_ro(String nicho_palmeras_ro) {
	this.nicho_palmeras_ro = nicho_palmeras_ro;
}



public String getFila_palmeras_ro() {
	return fila_palmeras_ro;
}



public void setFila_palmeras_ro(String fila_palmeras_ro) {
	this.fila_palmeras_ro = fila_palmeras_ro;
}



public String getPalmeras_Sepulturas() {
	return palmeras_Sepulturas;
}



public void setPalmeras_Sepulturas(String palmeras_Sepulturas) {
	this.palmeras_Sepulturas = palmeras_Sepulturas;
}



public String getSeccion_sepulturas() {
	return seccion_sepulturas;
}



public void setSeccion_sepulturas(String seccion_sepulturas) {
	this.seccion_sepulturas = seccion_sepulturas;
}



public String getLote_sepulturas() {
	return lote_sepulturas;
}



public void setLote_sepulturas(String lote_sepulturas) {
	this.lote_sepulturas = lote_sepulturas;
}



public String getUnidad_pulturas() {
	return unidad_pulturas;
}



public void setUnidad_pulturas(String unidad_pulturas) {
	this.unidad_pulturas = unidad_pulturas;
}



public String getBis_sepulturas() {
	return bis_sepulturas;
}



public void setBis_sepulturas(String bis_sepulturas) {
	this.bis_sepulturas = bis_sepulturas;
}



public String getLote_adulto() {
	return lote_adulto;
}



public void setLote_adulto(String lote_adulto) {
	this.lote_adulto = lote_adulto;
}



public String getLote_angelito() {
	return lote_angelito;
}



public void setLote_angelito(String lote_angelito) {
	this.lote_angelito = lote_angelito;
}



public String getInhumaciuon() {
	return inhumaciuon;
}



public void setInhumaciuon(String inhumaciuon) {
	this.inhumaciuon = inhumaciuon;
}



public String getOtrocementerio() {
	return otrocementerio;
}



public void setOtrocementerio(String otrocementerio) {
	this.otrocementerio = otrocementerio;
}



public String getOsario() {
	return osario;
}



public void setOsario(String osario) {
	this.osario = osario;
}



public String getDeposito() {
	return deposito;
}



public void setDeposito(String deposito) {
	this.deposito = deposito;
}


public String buscarUbicacionporDni( String dni){
   
	
	 String cadena= "";
	 
try {
	
	       
	        
            String url ="jdbc:mysql://sql143.main-hosting.eu:3306/u147800277_cemen";
            String username = "u147800277_ben";
            String password = "Tiburones";
            
            Connection connection = DriverManager.getConnection(url, username, password);

            java.sql.Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("call buscarUbiporDNI("+dni+")");
       
            while (rs.next()) {
     
           	String sid_ubicacion =rs.getString("id_ubicacion");
     
           	
           	if(sid_ubicacion.equals("3")) {
           		
           		String nicho=rs.getString("nicho");
               	String fila =rs.getString("fila");
           		cadena = cadena + "Palmeras Cenizas "+ "nicho: "+nicho+" fila: "+fila;
           	}
           	else if(sid_ubicacion.equals("2")) {
           		String nicho=rs.getString("nicho");
               	String fila =rs.getString("fila");
           		cadena = cadena + "Palmeras Ataud  "+ " nicho: "+nicho+" fila: "+fila;
           	}
           	else if(sid_ubicacion.equals("1")) {
           		String Circ =rs.getString("Circ");
               	String seccion=rs.getString("seccion");
               	String macizo=rs.getString("macizo");
               	String unidad =rs.getString("unidad");
             	String fila =rs.getString("fila");
            	String parcela=rs.getString("parcela");
           		
           		cadena = cadena + "Nichera  "+ "Circ: "+Circ+" seccion: "+seccion+" macizo: "+macizo+" parcela: "+parcela+" fila: "+fila+" unidad: "+unidad;
           	}  
           	else if(sid_ubicacion.equals("4")) {
           		String nicho=rs.getString("nicho");
               	String fila =rs.getString("fila");
               	cadena = cadena + "Palmeras Restos Oseos  "+ " nicho: "+nicho+" fila: "+fila;
           	}
           	else if(sid_ubicacion.equals("5")) {
		  
           		String sepultura=rs.getString("sepultura");
           		cadena = cadena + "Palmeras Sepulturas  "+ "sepultura: "+sepultura;
           		
           	}
           	else if(sid_ubicacion.equals("6")) {
           		
           		String Circ =rs.getString("Circ");
               	String seccion=rs.getString("seccion");
               	String macizo=rs.getString("macizo");
             	String bis =rs.getString("bis");
            	String parcela=rs.getString("parcela");
            	String unidad =rs.getString("unidad");
            	
            	cadena = cadena + "Boveda  "+ "Circ: "+Circ+" seccion: "+seccion+" macizo: "+macizo+" parcela: "+parcela+" bis: "+bis+" unidad: "+unidad;
           		
           		
           	}
           	else if(sid_ubicacion.equals("7")) {
           		
           		
               	String seccion=rs.getString("seccion");
               	String macizo=rs.getString("macizo");
             	String bis =rs.getString("bis");
             	String numero = rs.getString("numero");
            	String unidad =rs.getString("unidad");
            	String bis_macizo =rs.getString("bis_macizo");
            	
            	cadena = cadena + "Sepultura  "+ " seccion: "+seccion+" macizo: "+macizo+" bis_mcizo: "+bis_macizo+" unidad: "+unidad +" numero: "+numero+" bis: "+bis;
           		
           	}
           	else if(sid_ubicacion.equals("8")) {
           		String seccion=rs.getString("seccion");
               	String macizo=rs.getString("macizo");
            	String inhumacion=rs.getString("inhumacion");
           		String sepultura=rs.getString("sepultura");
           		
           		cadena = cadena + "Indigentes  "+ " seccion: "+seccion+" macizo: "+macizo+" sepultura: "+sepultura+"inhumacion: "+inhumacion;
           		
           	}
           	else if(sid_ubicacion.equals("9")) {
           	  String nicho=rs.getString("nicho");
          	String mueble=rs.getString("mueble");
          	
          	cadena = cadena + "Cenizario "+ "nicho: "+nicho+" mueble: "+mueble;
          	
           	}
           	else {
	JOptionPane.showMessageDialog(
			   null,
			   "No se han encontrado datos");
}
           	 	System.out.println( cadena);
           	 	
            	}
         
             rs.close();
             statement.close();
             connection.close();
       } catch (SQLException ex) {
       	System.out.println(ex);
       }

		
		
		
            	
       return cadena;

       }

public String esBis(String bis_sepulturas2) {
	if (bis_sepulturas2 == "1")
	return "no";
	return "si";

}
public String buscarUbicacionporNombre( String nombre, String apellido){
	   
	
	 String cadena= "";
	 
try {
	
	       
	        
           String url ="jdbc:mysql://sql143.main-hosting.eu:3306/u147800277_cemen";
           String username = "u147800277_ben";
           String password = "Tiburones";
           
           Connection connection = DriverManager.getConnection(url, username, password);

           java.sql.Statement statement = connection.createStatement();

           ResultSet rs = statement.executeQuery(" SELECT `unidad_boveda`, `seccion_nichera`, `deposito`, `otrocementerio`,`osario`,`nicho_palmeras_ataud`,`fila_palmeras_ataud`,`seccion_sepulturas`, `lote_sepulturas`,`unidad_sepulturas`, `bis_sepulturas`,`palmeras_sepulturas`,`nicho_palmeras_ro`, `fila_palmeras_ro`,`nicho_palmeras_cen`,`fila_palmeras_cen`,`macizo_nichera`, `par_nichera`,`fila_nichera`,`unidad_nichera`,`mueble_cenizas`,`nicho_cenizas`,`lote_adulto`,`lote_angelito`,`inhumacion` FROM `Clientes` inner join  `ubicacion` on `id_ubicacion` = `ubicacion_id` and `apellido` = '"+apellido+"' and `nombres`= '"+nombre+"'");
           while (rs.next() ) {
           	
           	
          	 		ubicaciones aux = new ubicaciones();
          	 	    
          	 		
          	 		aux.setUnidad_boveda("boveda : "+rs.getString("unidad_boveda"));  
          	 	    aux.setMueble_cenizas(rs.getString("mueble_cenizas")); 
          	 	    aux.setNicho_cenizas(rs.getString("nicho_cenizas"));
          	 	    aux.setSeccion_nichera(rs.getString("seccion_nichera"));
          	 	    aux.setMacizo_nichera(rs.getString("macizo_nichera"));
          	 	    aux.setPar_nichera(rs.getString("par_nichera"));
          	 	    aux.setFila_nichera(rs.getString("fila_nichera"));
          	 	    aux.setUnidad_nichera(rs.getString("unidad_nichera"));
          	 	    aux.setNicho_palmeras_ataud(rs.getString("nicho_palmeras_ataud"));
          	 	    aux.setFila_palmeras_ataud(rs.getString("fila_palmeras_ataud"));
          	 	    aux.setNicho_palmeras_cen(rs.getString("nicho_palmeras_cen"));
          	 	    aux.setFila_palmeras_cen(rs.getString("fila_palmeras_cen"));
          	 	    aux.setNicho_palmeras_ro(rs.getString("nicho_palmeras_ro"));
          	 	    aux.setFila_palmeras_ro(rs.getString("fila_palmeras_ro"));
          	 	    aux.setPalmeras_Sepulturas(rs.getString("palmeras_sepulturas"));
          	 	    aux.setSeccion_sepulturas(rs.getString("seccion_sepulturas"));
           	 	aux.setLote_sepulturas(rs.getString("lote_sepulturas"));
           	 	aux.setUnidad_pulturas(rs.getString("unidad_sepulturas"));
           	 	aux.setBis_sepulturas(rs.getString("bis_sepulturas"));
           	 	aux.setLote_adulto(rs.getString("lote_adulto"));
           	 	aux.setLote_angelito(rs.getString("lote_angelito"));
           	 	aux.setInhumaciuon(rs.getString("inhumacion"));
           	 	aux.setOtrocementerio(rs.getString("otrocementerio"));
           	 	aux.setOsario(rs.getString("osario"));
           	 	aux.setDeposito(rs.getString("deposito"));
          	
          	 		
          		 if ( aux.getUnidad_boveda() != null) {
           		
           		cadena = aux.unidad_boveda;
           		}
           	if ( aux.getMueble_cenizas() != null) {
           		
           		cadena = "Cenizario: mueble: "+ aux.mueble_cenizas + ", nicho:  "+ aux.nicho_cenizas ;
           		}
           	if ( aux.getSeccion_nichera() != null) {
           		
           		cadena = "Nichera: seccion: "+ aux.seccion_nichera + ", macizo :  "+ aux.macizo_nichera+ ", par: "+aux.par_nichera+ ",fila: "+aux.fila_nichera+ ",unidad: "+ aux.unidad_nichera ;
           		}
           	if ( aux.getNicho_palmeras_ataud() != null) {
           		
           		cadena = "Palmeras Ataud: nicho: "+ aux.nicho_palmeras_ataud + ", fila:  "+ aux.fila_palmeras_ataud ;
           		}
           	if ( aux.getNicho_palmeras_cen() != null) {
           		
           		cadena = "Palmeras Cenizas: nicho: "+ aux.nicho_palmeras_cen + ", fila:  "+ aux.fila_palmeras_cen ;
           		}
           	if ( aux.getNicho_palmeras_ro() != null) {
           		
           		cadena = "Palmeras Restos Oseos: nicho: "+ aux.nicho_palmeras_ro + ", fila:  "+ aux.fila_palmeras_ro ;
           		}
           	if ( aux.getPalmeras_Sepulturas() != null) {
           		
           		cadena = "Palmeras: sepultura: "+ aux.palmeras_Sepulturas ; ;
           		}
           	if ( aux.getSeccion_sepulturas() != null) {
           		
           		cadena = "Sepultura: seccion: "+ aux.seccion_sepulturas + ", lote:  "+ aux.lote_sepulturas+", unidad: "+aux.unidad_pulturas+", bis: "+ esBis(aux.bis_sepulturas) ;
           		}
           	if ( aux.lote_adulto != null) {
           		
           		cadena = "Sepultura C4: lote adulto: "+ aux.lote_adulto+ ", inhumacion:  "+ aux.inhumaciuon ;
           		}  
           	if ( aux.lote_angelito != null) {
           		
           		cadena = "Sepultura C4: lote angelito : "+ aux.lote_angelito+ ", inhumacion:  "+ aux.inhumaciuon ;
           		}     
                      
           	}
        
            rs.close();
            statement.close();
            connection.close();
      } catch (SQLException ex) {
      	System.out.println(ex);
      }

		
		
		
           	System.out.println(cadena);
      return cadena;

      }






@Override
public String toString() {
	return "ubicaciones [unidad_boveda=" + unidad_boveda + ", mueble_cenizas=" + mueble_cenizas + ", nicho_cenizas="
			+ nicho_cenizas + ", seccion_nichera=" + seccion_nichera + ", macizo_nichera=" + macizo_nichera
			+ ", par_nichera=" + par_nichera + ", fila_nichera=" + fila_nichera + ", unidad_nichera=" + unidad_nichera
			+ ", nicho_palmeras_ataud=" + nicho_palmeras_ataud + ", fila_palmeras_ataud=" + fila_palmeras_ataud
			+ ", nicho_palmeras_cen=" + nicho_palmeras_cen + ", fila_palmeras_cen=" + fila_palmeras_cen
			+ ", nicho_palmeras_ro=" + nicho_palmeras_ro + ", fila_palmeras_ro=" + fila_palmeras_ro
			+ ", palmeras_Sepulturas=" + palmeras_Sepulturas + ", seccion_sepulturas=" + seccion_sepulturas
			+ ", lote_sepulturas=" + lote_sepulturas + ", unidad_pulturas=" + unidad_pulturas + ", bis_sepulturas="
			+ bis_sepulturas + ", lote_adulto=" + lote_adulto + ", lote_angelito=" + lote_angelito + ", inhumaciuon="
			+ inhumaciuon + ", otrocementerio=" + otrocementerio + ", osario=" + osario + ", deposito=" + deposito
			+ "]";
}










}


