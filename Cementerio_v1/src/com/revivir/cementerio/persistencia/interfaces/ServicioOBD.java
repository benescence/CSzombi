package com.revivir.cementerio.persistencia.interfaces;

import java.util.List;


import com.revivir.cementerio.persistencia.entidades.Servicio;

public interface ServicioOBD {
	
	public void insert(Servicio precio);
	
	public void update(Servicio precio);
	
	public void delete(Servicio precio);

	public List<Servicio> select();
	
	public List<Servicio> selectByDescripcion(String descripcion);

	public List<Servicio> selectByNombre(String nombre);
	
	public Servicio selectBycodigo(Integer codigo);

	public Servicio selectByID2(Integer iD);

	
}
