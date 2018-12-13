package com.revivir.cementerio.test.persistencia;

import java.util.List;

import com.revivir.cementerio.negocios.Almanaque;
import com.revivir.cementerio.persistencia.FactoryOBD;
import com.revivir.cementerio.persistencia.entidades.Pago;
import com.revivir.cementerio.persistencia.interfaces.PagoOBD;

public class PagoOBDTest {

	public static void insertTest(Pago nuevo) {
		System.out.println("___ insert test");
		PagoOBD obd = FactoryOBD.crearPagoOBD();
		obd.insert(nuevo);
	}
	
	public static void selectTest() {
		System.out.println("___ select test");
		PagoOBD obd = FactoryOBD.crearPagoOBD();
		List<Pago> lista = obd.select();
		System.out.println("Cantidad: "+lista.size());
		for (Pago elemento : lista)
			System.out.println(elemento.getCargo()+", "+elemento.getCliente());
	}
	
	public static void main(String[] args) {
		Pago nuevo = new Pago(-1,1,3,550, "ff", Almanaque.hoy());
		insertTest(nuevo);
		selectTest();
	}
	
}
