package com.revivir.cementerio.test.seleccionar;

import com.revivir.cementerio.persistencia.entidades.Cliente;
import com.revivir.cementerio.vista.seleccion.clientes.ClienteSeleccionable;
import com.revivir.cementerio.vista.seleccion.clientes.ControladorSeleccionCliente;

public class SeleccionarClienteTest implements ClienteSeleccionable {

	@Override
	public void setCliente(Cliente cliente) {
		System.out.println("Se ha seleccionado el cliente:"+cliente.getNombre()+", "+cliente.getApellido()+", "+cliente.getDNI());
	}

	@Override
	public void mostrar() {
	
	}
	
	public static void main(String[] args) {
		new ControladorSeleccionCliente(new SeleccionarClienteTest());
	}

}