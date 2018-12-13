package com.revivir.cementerio.persistencia.interfaces;

import java.util.List;

import com.revivir.cementerio.persistencia.entidades.Responsable;



public interface ResponsableOBD {

	public void insert(Responsable responsable);
	
	public void update(Responsable responsable);
	
	public void delete(Responsable responsable);

	public List<Responsable> select();


	public List<Responsable> selectByCliente(Integer cliente);

	public List<Responsable> selectByFallecido(Integer fallecido);

	
}
