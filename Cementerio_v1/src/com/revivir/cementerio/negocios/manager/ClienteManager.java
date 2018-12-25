package com.revivir.cementerio.negocios.manager;

import java.util.List;

import com.revivir.cementerio.negocios.Validador;
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

	public static List<Cliente> traer(String nombres, String apellido, String DNI) throws Exception {
		nombres = Verificador.anular(nombres);
		apellido = Verificador.anular(apellido);
		DNI = Verificador.anular(DNI);
		String mensaje = "";

		if (nombres != null && !Validador.nombrePersona(nombres))
			mensaje += "\n    -El NOMBRE solo puede estar compuesto de letras y espacios.";

		if (apellido != null && !Validador.apellido(apellido))
			mensaje += "\n    -El APELLIDO solo puede estar compuesto de letras y espacios.";
		
		if (DNI != null && !Validador.DNI(DNI))
			mensaje += "\n    -El DNI solo puede estar compuesto de n�meros.";
		
		if (nombres == null && apellido == null && DNI == null)
			mensaje += "\n    -Debe llenar al menos uno de los campos para realizar la busqueda.";
		
		if (!mensaje.equals(""))
			throw new Exception("Se encontraron los siguientes errores:"+mensaje);
		
		ClienteOBD obd = FactoryOBD.crearClienteOBD();
		return obd.selectByNombreApellidoDNI(nombres, apellido, DNI);
	}

}