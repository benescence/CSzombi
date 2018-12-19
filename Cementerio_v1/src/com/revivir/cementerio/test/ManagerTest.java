package com.revivir.cementerio.test;

import java.sql.Date;

import com.revivir.cementerio.negocios.Almanaque;
import com.revivir.cementerio.negocios.manager.CargoManager;
import com.revivir.cementerio.negocios.manager.FallecidoManager;
import com.revivir.cementerio.negocios.manager.ServicioManager;
import com.revivir.cementerio.negocios.manager.UbicacionManager;
import com.revivir.cementerio.persistencia.definidos.TipoFallecimiento;
import com.revivir.cementerio.persistencia.entidades.Fallecido;
import com.revivir.cementerio.persistencia.entidades.Servicio;
import com.revivir.cementerio.persistencia.entidades.Ubicacion;

public class ManagerTest {
	
	public static void crearUnFallecido() {
		Ubicacion ubicacion = UbicacionManager.traerMasReciente();
		String nombre = "Carlos";
		String apellido = "Caballero";
		String dni = "123";
		Date fecha = Almanaque.hoy();		
		FallecidoManager.guardar(nombre, apellido, dni, "123", TipoFallecimiento.NO_TRAUMATICO, fecha, ubicacion, fecha);
	}
	
	public static void crearUnServicio() {
		String codigo = "Codigo1";
		String nombre = "Servicio1";
		double importe = 99.9;
		String descripcion = "Descripcion1";
		boolean historico = false;
		ServicioManager.guardar(codigo, nombre, importe, descripcion, historico);
	}	
	
	public static void crearUnCargo() {
		Fallecido fallecido = FallecidoManager.traerMasReciente();
		Servicio servicio = ServicioManager.traerMasReciente();
		String observaciones = "Observaciones1";
		boolean pagado = false;
		CargoManager.guardar(fallecido, servicio, observaciones, pagado);
	}	
	
	public static void main(String[] args) {
		//crearUnFallecido();
		//crearUnServicio();
		crearUnCargo();
	}

}
