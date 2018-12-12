package com.revivir.cementerio.test.persistencia;

import java.util.List;


import com.revivir.cementerio.persistencia.FactoryOBD;
import com.revivir.cementerio.persistencia.entidades.Cliente;
import com.revivir.cementerio.persistencia.entidades.Servicio;
import com.revivir.cementerio.persistencia.interfaces.ClienteOBD;
import com.revivir.cementerio.persistencia.interfaces.ServicioOBD;


public class ServicioOBDTest {

	
		
		public static void insertTest(Servicio nuevo) {
			System.out.println("___ insert test");
			ServicioOBD obd = FactoryOBD.crearPrecioOBD();
			obd.insert(nuevo);
		}
		
		public static void updateTest(Servicio precio) {
			System.out.println("___ Update test");
			ServicioOBD obd = FactoryOBD.crearPrecioOBD();
			obd.update(precio);
		}

		public static void deleteTest(Servicio precio) {
			System.out.println("___ Delete test");
			ServicioOBD obd = FactoryOBD.crearPrecioOBD();
			obd.delete(precio);
		}
		
		public static void selectTest() {
			System.out.println("___ select test");
			ServicioOBD obd = FactoryOBD.crearPrecioOBD();
			List<Servicio> lista = obd.select();
			System.out.println("Cantidad: "+lista.size());
			for (Servicio elemento : lista)
				System.out.println(elemento.getCodigo()+", "+elemento.getNombre());
		}
		public static Servicio selectByIDTest(Integer ID) {
			System.out.println("____ Select by ID Test");
			ServicioOBD obd = FactoryOBD.crearPrecioOBD();
			Servicio precio = obd.selectByID2(ID);
			System.out.println("Servicio: "+precio.getCodigo()+", "+precio.getDescripcion());
			return precio;
		}
		
		
		public static void main(String[] args) {
			Servicio nuevo = new Servicio(-1, 1, "24rrr", 5501.00, "Josefa", 1);
			
			insertTest(nuevo);
			selectTest();
			Servicio precioBd = selectByIDTest(3);
			precioBd.setCodigo(999);
			updateTest(precioBd);
			selectTest();
			//deleteTest(precioBd);
			//selectTest();
		}

	}
	
	
	

