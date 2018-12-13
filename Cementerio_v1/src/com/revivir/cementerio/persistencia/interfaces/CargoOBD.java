package com.revivir.cementerio.persistencia.interfaces;

import java.util.List;

import com.revivir.cementerio.persistencia.entidades.Cargo;

public interface CargoOBD {
	
	public void insert(Cargo cargo);
	
	public void update(Cargo cargo);
	
	public void delete(Cargo cargo);

	public List<Cargo> select();

	public Cargo selectByID(Integer ID);

	public Cargo ultimoInsertado();

}