package com.revivir.cementerio.test.persistencia;

import java.util.List;


import com.revivir.cementerio.persistencia.FactoryOBD;
import com.revivir.cementerio.persistencia.entidades.Cargo;
import com.revivir.cementerio.persistencia.entidades.Servicio;
import com.revivir.cementerio.persistencia.interfaces.CargoOBD;
import com.revivir.cementerio.persistencia.interfaces.ServicioOBD;


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
	
	public static void updateTest(Cargo precio) {
		System.out.println("___ Update test");
		CargoOBD obd = FactoryOBD.crearCargoOBD();
		obd.update(precio);
	}
	
	public static void deleteTest(Cargo precio) {
		System.out.println("___ Delete test");
		CargoOBD obd = FactoryOBD.crearCargoOBD();
		obd.delete(precio);
	}
	
	public static void main(String[] args) {
		
		Cargo nuevo = new Cargo(-1, 2,2,"rrryy",1);
		insertTest(nuevo);
		selectTest();
		deleteTest(nuevo);
	}

}
