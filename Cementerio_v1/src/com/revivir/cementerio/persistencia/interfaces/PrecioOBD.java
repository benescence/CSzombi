package com.revivir.cementerio.persistencia.interfaces;

import java.util.List;


import com.revivir.cementerio.persistencia.entidades.Precio;

public interface PrecioOBD {
	
	public void insert(Precio precio);
	
	public void update(Precio precio);
	
	public void delete(Precio precio);

	public List<Precio> select();
	
	public List<Precio> selectByDescripcion(String descripcion);

	public List<Precio> selectByNombre(String nombre);
	
	public Precio selectBycodigo(Integer codigo);
}
