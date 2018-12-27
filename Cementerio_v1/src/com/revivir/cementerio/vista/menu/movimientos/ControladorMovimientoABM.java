package com.revivir.cementerio.vista.menu.movimientos;

import java.util.List;
import javax.swing.JInternalFrame;
import com.revivir.cementerio.negocios.Busqueda;
import com.revivir.cementerio.persistencia.entidades.Movimiento;
import com.revivir.cementerio.vista.ControladorInterno;
import com.revivir.cementerio.vista.ControladorPrincipal;
import com.revivir.cementerio.vista.util.Popup;

public class ControladorMovimientoABM implements  ControladorInterno{
	private VentanaMovimientoABM ventana;
	
	public ControladorMovimientoABM(ControladorPrincipal invocador) {
		ventana = new VentanaMovimientoABM();
		//ventana.botonBuscar().addActionListener(e -> buscar());
		//ventana.botonLimpiar().addActionListener(e -> limpiar());
	}

	private void limpiar() {
		//ventana.getInFallecidoNombre().setText("");
		//ventana.getInFallecidoApellido().setText("");
	}

	private void buscar() {
		/*String nombreFallecido = ventana.getInFallecidoNombre().getText();
		String apellidoFallecido = ventana.getInFallecidoApellido().getText();
		if (nombreFallecido.equals("") && apellidoFallecido.equals("")) {
			Popup.mostrar("Debe ingresar al menos un criterio de búsqueda.\n    -Nombres\n ");
			return;
		}
	
		List<Movimiento> lista = Busqueda.movimientos(nombreFallecido, apellidoFallecido);
		ventana.getTabla().recargar(lista);
		if (lista.size() == 0)
			Popup.mostrar("No se ha encontrado ningun resultado con los criterios ingresados.");*/
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