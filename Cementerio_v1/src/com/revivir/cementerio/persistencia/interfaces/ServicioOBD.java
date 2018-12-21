package com.revivir.cementerio.persistencia.interfaces;

import java.util.List;


import com.revivir.cementerio.persistencia.entidades.Servicio;

public interface ServicioOBD {
	
	// METODOS GENERALES
	
	public void insert(Servicio servicio);
	
	public void update(Servicio servicio);
	
	public void delete(Servicio servicio);

	public List<Servicio> select();
	
	public Servicio selectByID(Integer iD);

	public Servicio ultimoInsertado();
	
	// METODOS ESPECIFICOS DE CONSULTA

	public Servicio selectActivoBycodigo(String codigo);

	public List<Servicio> selectByNombre(String nombre);
		
}