package com.revivir.cementerio.test.persistencia;

import java.util.List;


import com.revivir.cementerio.persistencia.FactoryOBD;
import com.revivir.cementerio.persistencia.entidades.Cliente;
import com.revivir.cementerio.persistencia.entidades.Precio;
import com.revivir.cementerio.persistencia.interfaces.ClienteOBD;
import com.revivir.cementerio.persistencia.interfaces.PrecioOBD;


public class CargoOBDTest {

	
		
		public static void insertTest(Precio nuevo) {
			System.out.println("___ insert test");
			PrecioOBD obd = FactoryOBD.crearPrecioOBD();
			obd.insert(nuevo);
		}
		
		public static void updateTest(Precio precio) {
			System.out.println("___ Update test");
			PrecioOBD obd = FactoryOBD.crearPrecioOBD();
			obd.update(precio);
		}

		public static void deleteTest(Precio precio) {
			System.out.println("___ Delete test");
			PrecioOBD obd = FactoryOBD.crearPrecioOBD();
			obd.delete(precio);
		}
		
		public static void selectTest() {
			System.out.println("___ select test");
			PrecioOBD obd = FactoryOBD.crearPrecioOBD();
			List<Precio> lista = obd.select();
			System.out.println("Cantidad: "+lista.size());
			for (Precio elemento : lista)
				System.out.println(elemento.getCodigo()+", "+elemento.getNombre());
		}
		public static Precio selectByIDTest(Integer ID) {
			System.out.println("____ Select by ID Test");
			PrecioOBD obd = FactoryOBD.crearPrecioOBD();
			Precio precio = obd.selectByID2(ID);
			System.out.println("Cargo: "+precio.getCodigo()+", "+precio.getDescripcion());
			return precio;
		}
		
		
		public static void main(String[] args) {
			Precio nuevo = new Precio(-1, 1, "24rrr", 5501.00, "Josefa", 1);
			
			insertTest(nuevo);
			selectTest();
			Precio precioBd = selectByIDTest(3);
			precioBd.setCodigo(999);
			updateTest(precioBd);
			selectTest();
			//deleteTest(precioBd);
			//selectTest();
		}

	}
	
	
	

