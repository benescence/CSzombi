package com.revivir.cementerio.persistencia.interfaces;

import java.util.List;
import com.revivir.cementerio.persistencia.entidades.Fallecido;

public interface FallecidoOBD {
	
	public void insert(Fallecido obciso);
	
	public void update(Fallecido obciso);
	
	public void delete(Fallecido obciso);

	public List<Fallecido> select();

	public Fallecido selectByDNI(String DNI);

	public List<Fallecido> selectByNombreApellidoDNI(String nombre, String apellido, String DNI);

}