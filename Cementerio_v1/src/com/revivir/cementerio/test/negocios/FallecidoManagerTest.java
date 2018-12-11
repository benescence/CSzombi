package com.revivir.cementerio.test.negocios;

import java.sql.Date;

import com.revivir.cementerio.negocios.Almanaque;
import com.revivir.cementerio.negocios.manager.FallecidoManager;
import com.revivir.cementerio.persistencia.definidos.TipoFallecimiento;

public class FallecidoManagerTest {
	
	public static void guardarFallecidoTest(Integer cliente, Integer ubicacion, TipoFallecimiento tipo,
			String dni, String apellido, String nombre, String cocheria, Date fechaFallecimiento) {
		System.out.println("___ Guardar fallecido test");
		//FallecidoManager.guardar(cliente, ubicacion, tipo, dni, apellido, nombre, cocheria, fechaFallecimiento);
	}
	
	public static void main(String[] args) {
		Integer cliente = 1;
		Integer ubicacion = 1;
		TipoFallecimiento tipo = TipoFallecimiento.TRAUMATICO;
		String dni = "50";
		String apellido = "Hernadez";
		String nombre = "Juan";
		String cocheria = "Valparaiso";
		Date fechaFallecimiento = Almanaque.hoy();
		guardarFallecidoTest(cliente, ubicacion, tipo, dni, apellido, nombre, cocheria, fechaFallecimiento);

	
	}

}