package com.revivir.cementerio;

import java.util.Properties;

import javax.swing.UIManager;

import com.jtattoo.plaf.acryl.AcrylLookAndFeel;
import com.revivir.cementerio.vista.login.ControladorIniciarSesion;

public class MainLogin {

	public static void main(String[] args) {
		try {
			Properties props = new Properties();
			props.put("logoString", "Revivir");
			
			AcrylLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		new ControladorIniciarSesion();
	}

}