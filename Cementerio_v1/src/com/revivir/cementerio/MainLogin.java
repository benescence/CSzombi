package com.revivir.cementerio;

import java.util.Properties;

import javax.swing.UIManager;

<<<<<<< HEAD
//import com.jtattoo.plaf.acryl.AcrylLookAndFeel;//1
import com.revivir.cementerio.vista.login.ControladorIniciarSesion;
=======
import com.jtattoo.plaf.acryl.AcrylLookAndFeel;
import com.revivir.cementerio.vista.sesion.ControladorIniciarSesion;
>>>>>>> refs/remotes/origin/BenDesarrollo

public class MainLogin {

	public static void configurarApariencia() {
		try {
			Properties props = new Properties();
			props.put("logoString", "Revivir");
			
			//AcrylLookAndFeel.setCurrentTheme(props);
			//UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		//configurarApariencia();
		new ControladorIniciarSesion();
	}

}