package com.revivir.cementerio;

import java.util.Properties;

import javax.swing.UIManager;

import com.jtattoo.plaf.acryl.AcrylLookAndFeel;
import com.revivir.cementerio.vista.ControladorPrincipal;

public class Main {

	public static void main(String[] args) {
		try {
			Properties props = new Properties();
			props.put("logoString", "Revivir");
			
			AcrylLookAndFeel.setCurrentTheme(props);
			//ESTOS 2 LOOK AND FEEL ME GUSTAN MAS 
			//UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
			//UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
			UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		new ControladorPrincipal();		
	}

}