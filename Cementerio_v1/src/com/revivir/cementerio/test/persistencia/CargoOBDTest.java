package com.revivir.cementerio.test.persistencia;

import java.util.List;


import com.revivir.cementerio.persistencia.FactoryOBD;
import com.revivir.cementerio.persistencia.entidades.Precio;
import com.revivir.cementerio.persistencia.interfaces.PrecioOBD;


public class CargoOBDTest {

	
		
		public static void insertTest(Precio nuevo) {
			System.out.println("___ insert test");
			PrecioOBD obd = FactoryOBD.crearPrecioOBD();
			obd.insert(nuevo);
		}
		
		public static void selectTest() {
			System.out.println("___ select test");
			PrecioOBD obd = FactoryOBD.crearPrecioOBD();
			List<Precio> lista = obd.select();
			System.out.println("Cantidad: "+lista.size());
			for (Precio elemento : lista)
				System.out.println(elemento.getCodigo()+", "+elemento.getNombre());
		}
		
		public static void main(String[] args) {
			Precio nuevo = new Precio(-1,1, "24234", 550.00, "Jose" );
			insertTest(nuevo);
			selectTest();
		}

	}
	
	
	

