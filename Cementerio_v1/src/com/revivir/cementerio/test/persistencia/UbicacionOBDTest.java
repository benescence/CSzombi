package com.revivir.cementerio.test.persistencia;

import java.util.List;

import com.revivir.cementerio.persistencia.Definido;
import com.revivir.cementerio.persistencia.FactoryOBD;
import com.revivir.cementerio.persistencia.entidades.Cliente;
import com.revivir.cementerio.persistencia.entidades.Ubicacion;
import com.revivir.cementerio.persistencia.interfaces.ClienteOBD;
import com.revivir.cementerio.persistencia.interfaces.UbicacionOBD;

public class UbicacionOBDTest {
	
	public static void insertTest(Ubicacion ubicacion) {
		System.out.println("___ Insert test");
		UbicacionOBD obd = FactoryOBD.crearUbicacionOBD();;
		obd.insert(ubicacion);
	}
	
	public static void updateTest(Ubicacion ubicacion) {
		System.out.println("___ Update test");
		UbicacionOBD obd = FactoryOBD.crearUbicacionOBD();
		obd.update(ubicacion);
	}
	
	public static Ubicacion selectByIDTest(Integer ID) {
		System.out.println("____ Select by ID Test");
		UbicacionOBD obd = FactoryOBD.crearUbicacionOBD();
		Ubicacion ubicacion = obd.selectByID(ID);
		System.out.println("Cliente: "+ubicacion.getSubsector()+", "+ubicacion.getMacizo());
		return ubicacion;
	}
	
	public static void selectTest() {
		System.out.println("___ select test");
		UbicacionOBD obd = FactoryOBD.crearUbicacionOBD();
		List<Ubicacion> lista = obd.select();
		System.out.println("Cantidad: "+lista.size());
		for (Ubicacion elemento : lista)
			System.out.println(elemento.getSubsector());
	}
	
	public static void main(String[] args) {
		Ubicacion ubicacion = new Ubicacion(-1, Definido.subsector(2), null, null, 2, "3", null, 1, null, null, null, null, null, null, null);
		insertTest(ubicacion);
		selectTest();
		Ubicacion uberBD = selectByIDTest(1);
		System.out.println("  "+ uberBD.getMacizo() + "macizo"+ uberBD.getMacizo());
		uberBD.setMacizo(5);
		updateTest(uberBD);
		selectTest();
	}

}