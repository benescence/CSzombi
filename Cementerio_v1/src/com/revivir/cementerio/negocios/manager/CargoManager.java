package com.revivir.cementerio.negocios.manager;

import java.util.List;

import com.revivir.cementerio.persistencia.FactoryOBD;
import com.revivir.cementerio.persistencia.entidades.Precio;
import com.revivir.cementerio.persistencia.interfaces.PrecioOBD;

public class CargoManager {

	public static void crearCargo(int codigo, String nombre, Double monto, String descripcion, Integer historico) {
		Precio precio = new Precio(-1, codigo, descripcion, monto, nombre, historico);
		PrecioOBD obd = FactoryOBD.crearPrecioOBD();
		obd.insert(precio);
	}

	public static void modificar(Precio precio) {
			
	}
		
	public static void eliminar(Precio precio) {
		
	}
	
	public static List<Precio> traerTodo() {
		PrecioOBD obd = FactoryOBD.crearPrecioOBD();
		return obd.select();
	}
	
	public static Precio traerPorID(int ID) {
		return null;
	}
	
	public static Precio traerPorCodigo(int codigo) {
		PrecioOBD obd = FactoryOBD.crearPrecioOBD();		
		return obd.selectBycodigo(codigo);
	}
}
