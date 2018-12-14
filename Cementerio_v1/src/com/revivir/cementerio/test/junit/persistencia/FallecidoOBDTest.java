package com.revivir.cementerio.test.junit.persistencia;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.revivir.cementerio.negocios.Almanaque;
import com.revivir.cementerio.negocios.Localizador;
import com.revivir.cementerio.persistencia.FactoryOBD;
import com.revivir.cementerio.persistencia.definidos.TipoFallecimiento;
import com.revivir.cementerio.persistencia.entidades.Cargo;
import com.revivir.cementerio.persistencia.entidades.Fallecido;
import com.revivir.cementerio.persistencia.entidades.Servicio;
import com.revivir.cementerio.persistencia.entidades.Ubicacion;
import com.revivir.cementerio.persistencia.interfaces.CargoOBD;
import com.revivir.cementerio.persistencia.interfaces.FallecidoOBD;

class FallecidoOBDTest {
	private Fallecido objeto = crearObjetoDePrueba();
	private FallecidoOBD obd = FactoryOBD.crearFallecidoOBD();
	
	private Fallecido crearObjetoDePrueba() {
		//Ubicacion ubicacion = Localizador.
		return null;//new Fallecido(-1, ubicacion, TipoFallecimiento.TRAUMATICO, "999", "apellido", "nombre", "cocheria", Almanaque.hoy());
	}

	@Test
	void testInsert() {
		obd.insert(objeto);
		Fallecido objetoBD = obd.ultimoInsertado();
		iguales(objeto, objetoBD);
		obd.delete(objetoBD);
	}
	
	@Test
	void testUpdate() {
		obd.insert(objeto);
		Fallecido objetoBD1 = obd.ultimoInsertado();
		//objetoBD1.setObservaciones("Prueba1");
		obd.update(objetoBD1);
		Fallecido clienteBD2 = obd.ultimoInsertado();
		iguales(objetoBD1, clienteBD2);
		obd.delete(objetoBD1);
	}
	
	@Test
	void testDelete() {
		obd.insert(objeto);
		Fallecido objetoBD = obd.ultimoInsertado();
		obd.delete(objetoBD);
		objetoBD = obd.ultimoInsertado();
		if (objetoBD != null)
			distintos(objeto, objetoBD);
	}

	@Test
	void testUltimoInsertado() {
		obd.insert(objeto);
		Fallecido clienteBD = obd.ultimoInsertado();
		iguales(objeto, clienteBD);
		obd.delete(clienteBD);
	}	

	private void iguales(Fallecido c1, Fallecido c2) {
		//assertTrue(c1.getServicio().equals(c2.getServicio()));
		
	}
	
	private void distintos(Fallecido c1, Fallecido c2) {
		//boolean servicio = c1.getServicio().equals(c2.getServicio());
		//assertFalse(servicio && fallecido && observaciones && pagado);
	}

}