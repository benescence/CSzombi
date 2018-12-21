package com.revivir.cementerio.negocios.manager;

import java.util.List;

import com.revivir.cementerio.negocios.Verificador;
import com.revivir.cementerio.persistencia.FactoryOBD;
import com.revivir.cementerio.persistencia.entidades.Cliente;
import com.revivir.cementerio.persistencia.interfaces.ClienteOBD;

public class ClienteManager {
	
	public static void guardar(Cliente nuevo) throws Exception {
		Cliente cliente = Verificador.cliente(nuevo, null);
		ClienteOBD obd = FactoryOBD.crearClienteOBD();
		obd.insert(cliente);
	}

	public static void modificar(Cliente nuevo, Cliente anterior) throws Exception {
		Cliente cliente = Verificador.cliente(nuevo, anterior);
		ClienteOBD obd = FactoryOBD.crearClienteOBD();
		obd.update(cliente);
	}
		
	public static void eliminar(Cliente cliente) {
		//List<Fallecido> fallecidos = Vinculador.traerFallecidosDeCliente(cliente);
		//if (fallecidos.size() > 0)
		
		
		
		ClienteOBD obd = FactoryOBD.crearClienteOBD();
		obd.delete(cliente);
	}
	
	public static List<Cliente> traerTodo() {
		ClienteOBD obd = FactoryOBD.crearClienteOBD();
		return obd.select();
	}
	
	public static Cliente traerPorID(Integer ID) {
		ClienteOBD obd = FactoryOBD.crearClienteOBD();
		return obd.selectByID(ID);
	}
	
	public static Cliente traerPorDNI(String DNI) {
		ClienteOBD obd = FactoryOBD.crearClienteOBD();		
		return obd.selectByDNI(DNI);
	}

	public static Cliente traerMasReciente() {
		ClienteOBD obd = FactoryOBD.crearClienteOBD();		
		return obd.ultimoInsertado();
	}
	

}