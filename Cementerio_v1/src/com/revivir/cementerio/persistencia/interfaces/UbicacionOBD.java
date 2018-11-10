package com.revivir.cementerio.persistencia.interfaces;

import java.util.List;
import com.revivir.cementerio.persistencia.entidades.Fallecido;
import com.revivir.cementerio.persistencia.entidades.Ubicacion;

public interface UbicacionOBD {
	
	public void insert(Ubicacion ubicacion);
	
	public List<Ubicacion> select();

	public Ubicacion selectByFallecido(Fallecido fallecido);
	
	public Integer selectLastID();
	
}