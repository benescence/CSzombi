package com.revivir.cementerio.persistencia.interfaces;

import java.util.List;

import com.revivir.cementerio.persistencia.definidos.Rol;
import com.revivir.cementerio.persistencia.entidades.Usuario;

public interface UsuarioOBD {

	public void insert(Usuario usuario);
	
	public void update(Usuario usuario);
	
	public void delete(Usuario usuario);
	
	public Usuario selectByUsuario(String usuario);

	public List<Usuario> select();

	public List<Usuario> selectByRol(Rol rol);
	
}