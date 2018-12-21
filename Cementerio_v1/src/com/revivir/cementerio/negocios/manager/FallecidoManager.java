package com.revivir.cementerio.negocios.manager;

import java.sql.Date;
import java.util.List;

import com.revivir.cementerio.negocios.Validador;
import com.revivir.cementerio.negocios.Verificador;
import com.revivir.cementerio.persistencia.FactoryOBD;
import com.revivir.cementerio.persistencia.definidos.TipoFallecimiento;
import com.revivir.cementerio.persistencia.entidades.Fallecido;
import com.revivir.cementerio.persistencia.entidades.Ubicacion;
import com.revivir.cementerio.persistencia.interfaces.FallecidoOBD;

public class FallecidoManager {
	
	public static void guardar(String nombre, String apellido, String dni, String cocheria,  
			TipoFallecimiento tipo, Date fecha, Ubicacion ubicacion, Date fechaIngreso) {
		
		Fallecido fallecido = new Fallecido(-1, ubicacion.getID(), tipo, dni, apellido,
				nombre, cocheria, fecha, fechaIngreso);
		
		FallecidoOBD obd = FactoryOBD.crearFallecidoOBD();
		obd.insert(fallecido);	
	}

	public static void modificar(Fallecido fallecido) {
		FallecidoOBD obd = FactoryOBD.crearFallecidoOBD();
		obd.update(fallecido);
	}
	
	public static void eliminar(Fallecido fallecido) {
		FallecidoOBD obd = FactoryOBD.crearFallecidoOBD();
		obd.delete(fallecido);
	}
	
	public static List<Fallecido> traerTodo() {
		FallecidoOBD obd = FactoryOBD.crearFallecidoOBD();
		return obd.select();
	}

	public static Fallecido traerPorDNI(String DNI) {
		FallecidoOBD obd = FactoryOBD.crearFallecidoOBD();
		return obd.selectByDNI(DNI);
	}

	public static Fallecido traerPorID(Integer ID) {
		FallecidoOBD obd = FactoryOBD.crearFallecidoOBD();
		return obd.selectByID(ID);
	}

	public static Fallecido traerMasReciente() {
		FallecidoOBD obd = FactoryOBD.crearFallecidoOBD();
		return obd.ultimoInsertado();
	}

	public static List<Fallecido> traer(String nombres, String apellido, String DNI) throws Exception {
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
		
		FallecidoOBD obd = FactoryOBD.crearFallecidoOBD();
		return obd.selectByNombreApellidoDNI(nombres, apellido, DNI);
	}
	
}