package com.revivir.cementerio.persistencia.interfaces;

import java.util.List;
import com.revivir.cementerio.persistencia.entidades.Cliente;

public interface ClienteOBD {
	
	// METODOS COMUNES DE PERSISTENCIA
	
	public void insert(Cliente cliente);
	
	public void update(Cliente cliente);
	
	public void delete(Cliente cliente);

	public List<Cliente> select();
	
	public Cliente selectByID(Integer iD);
	
	public Cliente ultimoInsertado();
	
	// CONSULTAS ESPECIFICAS
	
	

	public Cliente selectByDNI(String DNI);

	public List<Cliente> selectByNombreApellidoDNI(String nombre, String apellido, String DNI);

}