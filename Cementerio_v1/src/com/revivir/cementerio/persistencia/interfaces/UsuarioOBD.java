package com.revivir.cementerio.persistencia.interfaces;


import com.revivir.cementerio.persistencia.entidades.Usuario;

public interface UsuarioOBD {

public void insert(Usuario usuario);
	
	public void update(Usuario usuario);
	
	public void delete(Usuario usuario);

	
}
