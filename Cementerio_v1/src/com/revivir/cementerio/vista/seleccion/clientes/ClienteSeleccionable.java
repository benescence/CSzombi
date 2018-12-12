package com.revivir.cementerio.vista.seleccion.clientes;

import com.revivir.cementerio.persistencia.entidades.Cliente;

public interface ClienteSeleccionable {
	
	public void setCliente(Cliente cliente);

	public void mostrar();

}