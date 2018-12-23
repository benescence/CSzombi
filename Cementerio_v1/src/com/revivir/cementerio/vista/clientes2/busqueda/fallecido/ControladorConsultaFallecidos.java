package com.revivir.cementerio.vista.clientes2.busqueda.fallecido;

import javax.swing.JInternalFrame;

import com.revivir.cementerio.vista.ControladorInterno;
import com.revivir.cementerio.vista.util.Popup;

public class ControladorConsultaFallecidos implements ControladorInterno{
	private VentanaConsultaFallecidos ventana;
	
	public ControladorConsultaFallecidos() {
		ventana = new VentanaConsultaFallecidos();
		ventana.botonBuscar().addActionListener(e -> buscar());
		ventana.botonLimpiar().addActionListener(e -> limpiar());
	}

	private void limpiar() {
		ventana.getDNI().setText("");
		ventana.getNombre().setText("");
		ventana.getApellido().setText("");		
	}

	private void buscar() {
		String DNI = ventana.getDNI().getText();
		String nombres = ventana.getNombre().getText();
		String apellido = ventana.getApellido().getText();
	
		if (DNI.equals("") && nombres.equals("") && apellido.equals("")) {
			Popup.mostrar("Debe ingresar al menos un criterio de búsqueda.\n    -Nombres\n    -Apellido\n    -DNI");
			return;
		}
	
		//List<Fallecido> lista = Busqueda.fallecidos(DNI, nombres, apellido);
		//ventana.getTabla().recargar(lista);
		//if (lista.size() == 0)
			Popup.mostrar("No se ha encontrado ningun resultado con los criterios ingresados.");
	}
	

	@Override
	public boolean finalizar() {
		ventana.dispose();
		ventana = null;
		return true;
	}

	@Override
	public JInternalFrame getVentana() {
		return ventana;
	}
	
}