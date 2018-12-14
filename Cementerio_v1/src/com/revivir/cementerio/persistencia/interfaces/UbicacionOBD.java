package com.revivir.cementerio.persistencia.interfaces;

import java.util.List;

import com.revivir.cementerio.persistencia.entidades.Fallecido;
import com.revivir.cementerio.persistencia.entidades.Ubicacion;

public interface UbicacionOBD {
	
	public void insert(Ubicacion ubicacion);

	public void update(Ubicacion ubicacion);
	
	public void delete(Ubicacion ubicacion);
		
	public Ubicacion selectByID(Integer ID);

	public Ubicacion ultimoInsertado();
		
	public List<Ubicacion> select();
	
	public Ubicacion selectByFallecido(Fallecido fallecido);
	
}