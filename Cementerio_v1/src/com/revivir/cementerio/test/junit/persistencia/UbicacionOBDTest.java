package com.revivir.cementerio.test.junit.persistencia;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.revivir.cementerio.persistencia.FactoryOBD;
import com.revivir.cementerio.persistencia.definidos.SubSector;
import com.revivir.cementerio.persistencia.entidades.Ubicacion;
import com.revivir.cementerio.persistencia.interfaces.UbicacionOBD;

public class UbicacionOBDTest {
	private Ubicacion objeto = crearObjetoDePrueba();
	private UbicacionOBD obd = FactoryOBD.crearUbicacionOBD();
	
	private Ubicacion crearObjetoDePrueba() {
		return new Ubicacion(-1, SubSector.BOVEDA, "rr", 3, 4, null, 1, 5, 77, 99,99, 8, 7, 6, 8);
	}

	@Test
	void testInsert() {
		obd.insert(objeto);
		Ubicacion objetoBD = obd.ultimoInsertado();
		iguales(objeto, objetoBD);
		obd.delete(objetoBD);
	}
	
	@Test
	public void testUpdate() {
		obd.insert(objeto);
		Ubicacion objetoBD1 = obd.ultimoInsertado();
		objetoBD1.setSubsector(SubSector.DEPOSITO1);
		obd.update(objetoBD1);
		Ubicacion clienteBD2 = obd.ultimoInsertado();
		iguales(objetoBD1, clienteBD2);
		obd.delete(objetoBD1);
	}
	
	@Test
	public void testDelete() {
		obd.insert(objeto);
		Ubicacion objetoBD = obd.ultimoInsertado();
		obd.delete(objetoBD);
		objetoBD = obd.ultimoInsertado();
		if (objetoBD != null)
			distintos(objeto, objetoBD);
	}

	@Test
	public void testUltimoInsertado() {
		obd.insert(objeto);
		Ubicacion clienteBD = obd.ultimoInsertado();
		iguales(objeto, clienteBD);
		obd.delete(clienteBD);
	}	

	@Test
	void testSelectByID() {
		obd.insert(objeto);
		Ubicacion objetoBD1 = obd.ultimoInsertado();
		Ubicacion objetoBD2 = obd.selectByID(objetoBD1.getID());
		iguales(objetoBD1, objetoBD2);
		obd.delete(objetoBD1);
	}	

	@Test
	void testSelect() {
		obd.insert(objeto);
		Ubicacion objetoBD1 = obd.ultimoInsertado();
		List<Ubicacion> lista = obd.select();
		assertTrue(lista.size() > 0);
		obd.delete(objetoBD1);
	}	
	
	private void iguales(Ubicacion obj1, Ubicacion obj2) {
		
		// Si ambos son null, entonces son iguales
		boolean seccion = (obj1.getSeccion() == null) && (obj2.getSeccion() == null); 
		
		// Si ambos son distintos de null, son iguales si sus atributos son iguales
		if (obj1.getSeccion() != null && obj2.getSeccion() != null)
			seccion = obj1.getSeccion().equals(obj2.getSeccion()); 
		
		// Notar que si uno es null y el otro no, entonces son necesariamente distintos
		assertTrue(seccion);
		
		
		
		assertTrue(obj1.getOtroCementerio().equals(obj2.getOtroCementerio()));
		assertTrue(obj1.getSubsector().equals(obj2.getSubsector()));
		assertTrue(obj1.getMacizo().equals(obj2.getMacizo()));
		assertTrue(obj1.getParcela().equals(obj2.getParcela()));
		assertTrue(obj1.getNicho().equals(obj2.getNicho()));
		assertTrue(obj1.getUnidad().equals(obj2.getUnidad()));
		assertTrue(obj1.getMueble().equals(obj2.getMueble()));
		assertTrue(obj1.getInhumacion().equals(obj2.getInhumacion()));
		assertTrue(obj1.getFila().equals(obj2.getFila()));
		assertTrue(obj1.getCirc().equals(obj2.getCirc()));
		assertTrue(obj1.getBis_macizo().equals(obj2.getBis_macizo()));
		assertTrue(obj1.getBis().equals(obj2.getBis()));
		assertTrue(obj1.getSepultura().equals(obj2.getSepultura()));
	}
	
	private void distintos(Ubicacion obj1, Ubicacion obj2) {
		// Si ambos son null, entonces son iguales
		boolean seccion = obj1.getSeccion() == null && obj2.getSeccion() == null; 
		
		// Si ambos son distintos de null, son iguales si sus atributos son iguales
		if (obj1.getSeccion() != null && obj2.getSeccion() != null)
			seccion = obj1.getSeccion().equals(obj2.getSeccion()); 
		
		
		boolean subsector =obj1.getSubsector().equals(obj2.getSubsector());
		boolean otroCementerio = obj1.getOtroCementerio().equals(obj2.getOtroCementerio());
		boolean macizo = obj1.getMacizo().equals(obj2.getMacizo());
		boolean parcela = obj1.getParcela().equals(obj2.getParcela());
		boolean nicho = obj1.getNicho().equals(obj2.getNicho());
		boolean unidad=  obj1.getUnidad().equals(obj2.getUnidad());
		boolean mueble = obj1.getMueble().equals(obj2.getMueble());
		boolean inhumacion = obj1.getInhumacion().equals(obj2.getInhumacion());
		boolean fila = obj1.getFila().equals(obj2.getFila());
		boolean circ = obj1.getCirc().equals(obj2.getCirc());
		boolean bis_Macizo = obj1.getBis_macizo().equals(obj2.getBis_macizo());
		boolean bis = obj1.getBis().equals(obj2.getBis());
		boolean sepultura = obj1.getSepultura().equals(obj2.getSepultura());
		assertFalse(subsector && otroCementerio && seccion && macizo && parcela && nicho && unidad && mueble && inhumacion && fila && circ && bis_Macizo && bis && sepultura);
	}

}