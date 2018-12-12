package com.revivir.cementerio.persistencia.entidades;

public class Precio {
	private Integer ID, codigo, historico;
	private String nombre, descripcion;
	private Double  monto;

	public Precio(Integer ID, Integer codigo, String descripcion, Double monto, String nombre, Integer historico) {
		this.ID = ID;
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.nombre = nombre;
		this.monto = monto;
		this.historico = historico;
	}

	

	public int getHistorico() {
		return historico;
	}

	public void setHistorico(int historico) {
		this.historico = historico;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	
	
	
}
