package com.revivir.cementerio.test.persistencia;

import java.util.List;

import com.revivir.cementerio.negocios.Almanaque;
import com.revivir.cementerio.persistencia.FactoryOBD;
import com.revivir.cementerio.persistencia.definidos.TipoFallecimiento;
import com.revivir.cementerio.persistencia.entidades.Fallecido;
import com.revivir.cementerio.persistencia.interfaces.FallecidoOBD;


public class FallecidoOBDTest {
	
	public static void insertTest(Fallecido nuevo) {
		System.out.println("___ insert test");
		FallecidoOBD obd = FactoryOBD.crearFallecidoOBD();
		obd.insert(nuevo);
	}
	
	public static void selectTest() {
		System.out.println("___ select test");
		FallecidoOBD obd = FactoryOBD.crearFallecidoOBD();
		List<Fallecido> lista = obd.select();
		System.out.println("Cantidad: "+lista.size());
		for (Fallecido elemento : lista)
			System.out.println(elemento.getApellido()+", "+elemento.getNombre());
	}
	
	
	
	public static void main(String[] args) {
		Fallecido nuevo = new Fallecido(1, 1,
				TipoFallecimiento.TRAUMATICO, "2", "Benitez", "Jose", "La parca", Almanaque.hoy(), Almanaque.hoy());
		insertTest(nuevo);
		selectTest();
		
	}

}