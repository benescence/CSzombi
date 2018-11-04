package com.revivir.cementerio.persistencia.interfaces;

import java.util.List;

import com.revivir.cementerio.persistencia.entidades.Obciso;

public interface ObcisoOBD {
	
	public void insert(Obciso obciso);
	
	public void update(Obciso obciso);
	
	public void delete(Obciso obciso);

	public List<Obciso> select();

}