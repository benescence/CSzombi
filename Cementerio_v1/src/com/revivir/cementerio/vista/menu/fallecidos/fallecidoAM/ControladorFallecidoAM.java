package com.revivir.cementerio.vista.menu.fallecidos.fallecidoAM;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;

import com.revivir.cementerio.negocios.Almanaque;
import com.revivir.cementerio.negocios.Localizador;
import com.revivir.cementerio.negocios.manager.FallecidoManager;
import com.revivir.cementerio.persistencia.definidos.SubSector;
import com.revivir.cementerio.persistencia.definidos.TipoFallecimiento;
import com.revivir.cementerio.persistencia.entidades.Fallecido;
import com.revivir.cementerio.vista.ControladorPrincipal;
import com.revivir.cementerio.vista.menu.fallecidos.ControladorFallecidosABM;
import com.revivir.cementerio.vista.util.Popup;

public class ControladorFallecidoAM {
	private VentanaFallecidoAM ventana;
	private ControladorFallecidosABM invocador;
	private ControladorPrincipal principal;
	private Fallecido fallecido;
	
	public ControladorFallecidoAM(ControladorFallecidosABM invocador, Fallecido fallecido) {
		this.invocador = invocador;
		this.fallecido = fallecido;
		ventana = new VentanaFallecidoAM(fallecido);
		inicializar();
	}
	
	public ControladorFallecidoAM(ControladorFallecidosABM invocador) {
		this.invocador = invocador;
		ventana = new VentanaFallecidoAM();
		inicializar();
	}
	
	public ControladorFallecidoAM(ControladorPrincipal principal) {
		this.principal = principal;
		ventana = new VentanaFallecidoAM();
		inicializar();
	}
	
	private void inicializar() {
		ventana.botonAceptar().addActionListener(e -> aceptar());
		ventana.botonCancelar().addActionListener(e -> cancelar());
		ventana.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				volver();
			}
		});
	} 
	
	private void aceptar() {
		TipoFallecimiento tipo = (TipoFallecimiento) ventana.getInTipoFallecimiento().getSelectedItem();
		String dni = (!ventana.getInDNIFallecido().getText().equals("") ? ventana.getInDNIFallecido().getText() : null);
		String apellido= ventana.getInApellidoFallecido().getText();;
		String nombre= ventana.getInNombreFallecido().getText();;
		String cocheria= (!ventana.getInCocheria().getText().equals("") ? ventana.getInCocheria().getText() : null);
		Date fechaFallecimiento = new Date(ventana.getInFechaFallecimiento().getDate().getTime());
		
		// Es un alta
		if (fallecido == null) {
			guardarUbicacion();
			Integer ubicacion = Localizador.traerUltimaUbicacionGuardada();
			FallecidoManager.guardar(nombre, apellido, dni, cocheria, tipo, fechaFallecimiento, ubicacion);			
		}
		
		// Es una modificacion
		else {
			fallecido.setNombre(nombre);
			fallecido.setApellido(apellido);
			fallecido.setDni(dni);
			fallecido.setTipoFallecimiento(tipo);
			fallecido.setCocheria(cocheria);
			fallecido.setFechaFallecimiento(fechaFallecimiento);
			FallecidoManager.modificar(fallecido);
		}
		
		if (invocador != null)
			invocador.actualizar();
		volver();
	}
	
	private void guardarUbicacion() {
		SubSector subsector = (SubSector) ventana.getInSubSector().getSelectedItem();
		String otroCementerio = null;
		String osario = null;
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

		Localizador.guardarUbicacion(subsector, otroCementerio, osario, nicho, fila, seccion,
				macizo, unidad, bis, bis_macizo, numero, sepultura, parcela, mueble, inhumacion, circ, Almanaque.hoy());
	}	
	
	private void cancelar() {
		if (Popup.confirmar("Se perderan los datos ingresados.\n¿Esta seguro de que desea cancelar la operacion?"))
			volver();
	}

	private void volver() {
		ventana.dispose();
		ventana = null;
		if (invocador != null)
			invocador.mostrar();
		else
			principal.getVentana().mostrar();
	}
	
}