package com.revivir.cementerio.persistencia.interfaces;

import java.util.List;
import com.revivir.cementerio.persistencia.entidades.ObcisoCliente;

public interface ObcisoClienteOBD {
	
	public void insert(ObcisoCliente obcisoCliente);
	
	public void delete(ObcisoCliente obcisoCliente);

	public List<ObcisoCliente> select();

}