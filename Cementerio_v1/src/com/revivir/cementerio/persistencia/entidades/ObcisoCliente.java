package com.revivir.cementerio.persistencia.entidades;

public class ObcisoCliente {
	private Integer cliente, obciso;

	public ObcisoCliente(Integer cliente, Integer obciso) {
		this.cliente = cliente;
		this.obciso = obciso;
	}

	public Integer getCliente() {
		return cliente;
	}

	public void setCliente(Integer cliente) {
		this.cliente = cliente;
	}

	public Integer getObciso() {
		return obciso;
	}

	public void setObciso(Integer obciso) {
		this.obciso = obciso;
	}
	
}