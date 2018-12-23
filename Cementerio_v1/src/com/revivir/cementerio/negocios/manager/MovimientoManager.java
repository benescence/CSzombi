package com.revivir.cementerio.negocios.manager;

import java.sql.Date;
import java.util.List;

import com.revivir.cementerio.negocios.Validador;
import com.revivir.cementerio.negocios.Verificador;
import com.revivir.cementerio.persistencia.FactoryOBD;
import com.revivir.cementerio.persistencia.definidos.TipoFallecimiento;
import com.revivir.cementerio.persistencia.entidades.Fallecido;
import com.revivir.cementerio.persistencia.entidades.Movimiento;
import com.revivir.cementerio.persistencia.entidades.Ubicacion;
import com.revivir.cementerio.persistencia.interfaces.FallecidoOBD;
import com.revivir.cementerio.persistencia.interfaces.MovimientoOBD;

public class MovimientoManager {
	public static void guardar(Integer fallecido, String ubicacion, String causa, String observaciones , Date fecha ) {
		
		Movimiento movimiento = new Movimiento(-1, fallecido,  ubicacion, causa, observaciones, fecha);
		
		MovimientoOBD obd = FactoryOBD.crearMovimientoOBD();
		obd.insert(movimiento);	
	}

	public static void modificar(Movimiento movimiento) {
		MovimientoOBD obd = FactoryOBD.crearMovimientoOBD();
		obd.update(movimiento);
	}
	
	public static void eliminar(Movimiento movimiento) {
		MovimientoOBD obd = FactoryOBD.crearMovimientoOBD();
		obd.delete(movimiento);
	}
	
	public static List<Movimiento> traerTodo() {
		MovimientoOBD obd = FactoryOBD.crearMovimientoOBD();
		return obd.select();
	}

	/*public static Fallecido traerPorDNI(String DNI) {
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
			mensaje += "\n    -El DNI solo puede estar compuesto de números.";
		
		if (nombres == null && apellido == null && DNI == null)
			mensaje += "\n    -Debe llenar al menos uno de los campos para realizar la busqueda.";
		
		if (!mensaje.equals(""))
			throw new Exception("Se encontraron los siguientes errores:"+mensaje);
		
		FallecidoOBD obd = FactoryOBD.crearFallecidoOBD();
		return obd.selectByNombreApellidoDNI(nombres, apellido, DNI);
	}*/
}
