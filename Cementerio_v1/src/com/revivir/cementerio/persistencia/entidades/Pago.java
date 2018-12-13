package com.revivir.cementerio.persistencia.entidades;

import java.sql.Date;



public class Pago {

	private Integer ID,  cliente, cargo, importe;
	private String observaciones;
	private Date fecha;

	
	
	public Pago(Integer ID, Integer cargo, Integer cliente, Integer importe, String observaciones, Date fecha) {
		this.ID = ID;
		this.cliente = cliente;
		this.cargo = cargo;
		this.importe = importe;
		this.fecha = fecha;
		this.observaciones = observaciones;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer ID) {
		this.ID = ID;
	}
	
	public Integer getCliente() {
		return cliente;
	}

	public void setCliente(Integer cliente) {
		this.cliente = cliente;
	}

	public Integer getCargo() {
		return cargo;
	}

	public void setCargo(Integer cargo) {
		this.cargo = cargo;
	}

	public Integer getImporte() {
		return importe;
	}

	public void setImporte(Integer importe) {
		this.importe = importe;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	
}
