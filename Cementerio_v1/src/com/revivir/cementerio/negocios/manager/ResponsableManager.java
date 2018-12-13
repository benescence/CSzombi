package com.revivir.cementerio.negocios.manager;

import java.util.List;

import com.revivir.cementerio.persistencia.FactoryOBD;
import com.revivir.cementerio.persistencia.entidades.Cliente;
import com.revivir.cementerio.persistencia.entidades.Fallecido;
import com.revivir.cementerio.persistencia.entidades.Responsable;
import com.revivir.cementerio.persistencia.interfaces.ResponsableOBD;

public class ResponsableManager {
	
	public static void guardar(Cliente cliente, Fallecido fallecido, String observaciones) {
		Responsable nuevo = new Responsable(-1, cliente.getID(), fallecido.getID(), observaciones);
		ResponsableOBD obd = FactoryOBD.crearResponsableOBD();
		obd.insert(nuevo);
	}

	public static void modificar(Responsable modificar) {
		ResponsableOBD obd = FactoryOBD.crearResponsableOBD();
		obd.update(modificar);
	}
		
	public static void eliminar(Responsable eliminar) {
		ResponsableOBD obd = FactoryOBD.crearResponsableOBD();
		obd.delete(eliminar);
	}
	
	public static List<Responsable> traerTodo() {
		ResponsableOBD obd = FactoryOBD.crearResponsableOBD();
		return obd.select();
	}
	
	public static Responsable traerPorID(Integer ID) {
		ResponsableOBD obd = FactoryOBD.crearResponsableOBD();
		return obd.selectByID(ID);
	}
	
	public static List<Responsable> traerPorCliente(Cliente cliente) {
		ResponsableOBD obd = FactoryOBD.crearResponsableOBD();
		return obd.selectByCliente(cliente.getID());
	}
	
}