package com.revivir.cementerio.test.persistencia;

import java.util.List;

import com.revivir.cementerio.persistencia.FactoryOBD;
import com.revivir.cementerio.persistencia.entidades.Responsable;
import com.revivir.cementerio.persistencia.interfaces.ResponsableOBD;


public class ResponsableOBDTest {

	
	public static void insertTest(Responsable nuevo) {
		System.out.println("___ insert test");
		ResponsableOBD obd = FactoryOBD.crearResponsableOBD();
		obd.insert(nuevo);
	}
	
	public static void selectTest() {
		System.out.println("___ select test");
		ResponsableOBD obd = FactoryOBD.crearResponsableOBD();
		List<Responsable> lista = obd.select();
		System.out.println("Cantidad: "+lista.size());
		for (Responsable elemento : lista)
			System.out.println(elemento.getCliente()+", "+elemento.getFallecido());
	}
	
	public static void main(String[] args) {
		Responsable nuevo = new Responsable(-1, 2, 2, "ff");
		insertTest(nuevo);
		selectTest();
	}
	

}
