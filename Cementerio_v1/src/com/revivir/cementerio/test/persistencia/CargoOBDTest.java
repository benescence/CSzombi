package com.revivir.cementerio.test.persistencia;

import java.util.List;


import com.revivir.cementerio.persistencia.FactoryOBD;
import com.revivir.cementerio.persistencia.entidades.Cargo;
import com.revivir.cementerio.persistencia.interfaces.CargoOBD;


public class CargoOBDTest {
	
	public static void insertTest(Cargo nuevo) {
		System.out.println("___ insert test");
		CargoOBD obd = FactoryOBD.crearCargoOBD();
		obd.insert(nuevo);
	}
	
	public static void selectTest() {
		System.out.println("___ select test");
		CargoOBD obd = FactoryOBD.crearCargoOBD();
		List<Cargo> lista = obd.select();
		System.out.println("Cantidad: "+lista.size());
		for (Cargo elemento : lista)
			System.out.println(elemento.getFallecido()+", "+elemento.getServicio());
	}
	
	public static void main(String[] args) {
		
		Cargo nuevo = new Cargo(-1, 1,1,"rrr",1);
		insertTest(nuevo);
		selectTest();
	}

}
