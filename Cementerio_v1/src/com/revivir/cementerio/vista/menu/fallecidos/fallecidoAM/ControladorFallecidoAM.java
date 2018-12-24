package com.revivir.cementerio.vista.menu.fallecidos.fallecidoAM;

import java.sql.Date;

import com.revivir.cementerio.negocios.manager.FallecidoManager;
import com.revivir.cementerio.negocios.manager.UbicacionManager;
import com.revivir.cementerio.persistencia.definidos.SubSector;
import com.revivir.cementerio.persistencia.definidos.TipoFallecimiento;
import com.revivir.cementerio.persistencia.entidades.Fallecido;
import com.revivir.cementerio.persistencia.entidades.Ubicacion;
import com.revivir.cementerio.vista.ControladorExterno;
import com.revivir.cementerio.vista.util.AccionCerrarVentana;
import com.revivir.cementerio.vista.util.Popup;

public class ControladorFallecidoAM implements ControladorExterno{
	private VentanaFallecidoAM ventana;
	private FallecidoInvocable invocador;
	private Fallecido fallecido;
	
	public ControladorFallecidoAM(FallecidoInvocable invocador, Fallecido fallecido) {
		this.invocador = invocador;
		this.fallecido = fallecido;
		ventana = new VentanaFallecidoAM(fallecido);
		inicializar();
	}
	
	public ControladorFallecidoAM(FallecidoInvocable invocador) {
		this.invocador = invocador;
		ventana = new VentanaFallecidoAM();
		inicializar();
	}
	
	private void inicializar() {
		ventana.botonAceptar().setAccion(e -> aceptar());
		ventana.botonCancelar().setAccion(e -> cancelar());
		ventana.addWindowListener(new AccionCerrarVentana(e -> cancelar()));
	} 
	
	private void aceptar() {
		ventana.requestFocusInWindow();
		
		try {
			String nombre= ventana.getInNombreFallecido().getText();;
			String apellido= ventana.getInApellidoFallecido().getText();;
			String DNI = (!ventana.getInDNIFallecido().getText().equals("") ? ventana.getInDNIFallecido().getText() : null);
			String cocheria= (!ventana.getInCocheria().getText().equals("") ? ventana.getInCocheria().getText() : null);
			TipoFallecimiento tipo = (TipoFallecimiento) ventana.getInTipoFallecimiento().getSelectedItem();
			Date fechaFallecimiento = new Date(ventana.getInFechaFallecimiento().getDate().getTime());
			Date fechaIngreso = new Date(ventana.getInFechaIngreso().getDate().getTime());
			

			// Es un alta
			if (fallecido == null) {
				guardarUbicacion();
				Ubicacion ubicacion = UbicacionManager.traerMasReciente();
				Fallecido nuevo = new Fallecido(-1, ubicacion.getID(), tipo, DNI, apellido, nombre, cocheria, fechaFallecimiento, fechaIngreso);
				FallecidoManager.guardar(nuevo);			
			}
			
			// Es una modificacion
			else {
				Fallecido nuevo = new Fallecido(fallecido.getID(), fallecido.getUbicacion(), tipo, DNI, apellido, nombre, cocheria, fechaFallecimiento, fechaIngreso);
				FallecidoManager.modificar(nuevo);
			}
			
			ventana.dispose();
			invocador.actualizarFallecidos();
			invocador.mostrar();
		
		} catch (Exception e) {
			Popup.mostrar(e.getMessage());
		}
		
	}
	
	private void guardarUbicacion() {
		SubSector subsector = (SubSector) ventana.getInSubSector().getSelectedItem();
		String otroCementerio = null;
		String bis = null;
		if (ventana.getInCheckBis().isEnabled()) 
			bis = (ventana.getInCheckBis().isSelected())?"S":"N";
		String bis_macizo = null;
		if (ventana.getInCheckMacizo().isEnabled()) 
			bis = (ventana.getInCheckMacizo().isSelected())?"S":"N";
		String nicho = (ventana.getInNicho().isEnabled() ? ventana.getInNicho().getText() : null);
		String fila = (ventana.getInFila().isEnabled() ? ventana.getInFila().getText() : null);
		String seccion = (ventana.getInSeccion().isEnabled() ? ventana.getInFila().getText() : null);
		String macizo= (ventana.getInMacizo().isEnabled() ? ventana.getInMacizo().getText() : null);
		String unidad = (ventana.getInUnidad().isEnabled() ? ventana.getInUnidad().getText() : null);
		String numero= (ventana.getInNumeroSepultura().isEnabled() ? ventana.getInNumeroSepultura().getText() : null);
		String sepultura = (ventana.getInSepultura().isEnabled() ? ventana.getInSepultura().getText() : null);
		String parcela= (ventana.getInParcela().isEnabled() ? ventana.getInParcela().getText() : null);
		String mueble= (ventana.getInMueble().isEnabled() ? ventana.getInMueble().getText() : null);
		String inhumacion = (ventana.getInInhumacion().isEnabled() ? ventana.getInInhumacion().getText() : null);
		String circ = (ventana.getInCirc().isEnabled() ? ventana.getInCirc().getText() : null);
		//UbicacionManager.guardar(subsector, otroCementerio, nicho, fila, seccion, macizo, unidad, bis, bis_macizo, numero, sepultura, parcela, mueble, inhumacion, circ);
	}	
	
	private void cancelar() {
		if (Popup.confirmar("Se perderan los datos ingresados.\n¿Esta seguro de que desea cancelar la operacion?")) {
			ventana.dispose();
			invocador.mostrar();
		}
	}
	
}