package com.revivir.cementerio.persistencia.interfaces;

import java.util.Date;
import java.util.List;

import com.revivir.cementerio.persistencia.entidades.Pago;



public interface PagoOBD {

public void insert(Pago pago);
	
	public void update(Pago pago);
	
	public void delete(Pago pago);

	public List<Pago > select();

	public List<Pago> selectByCliente(Integer cliente);
	
	public Pago selectByFecha(Date fecha);

	public List<Pago> selectByClienteServivcio(Integer cliente, Integer servicio);

	
}
