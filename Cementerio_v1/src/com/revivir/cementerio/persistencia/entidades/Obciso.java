package com.revivir.cementerio.persistencia.entidades;

import java.sql.Date;

public class Obciso {
	private Integer ID, tipoFallecimiento;
	private String dni, apellido, nombre, cocheria;
	private Date fechaFallecimiento;
	
	public Obciso(Integer ID, Integer tipoFallecimiento, String dni, String apellido, String nombre, String cocheria,
			Date fechaFallecimiento) {
		this.ID = ID;
		this.tipoFallecimiento = tipoFallecimiento;
		this.dni = dni;
		this.apellido = apellido;
		this.nombre = nombre;
		this.cocheria = cocheria;
		this.fechaFallecimiento = fechaFallecimiento;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer ID) {
		this.ID = ID;
	}

	public Integer getTipoFallecimiento() {
		return tipoFallecimiento;
	}

	public void setTipoFallecimiento(Integer tipoFallecimiento) {
		this.tipoFallecimiento = tipoFallecimiento;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCocheria() {
		return cocheria;
	}

	public void setCocheria(String cocheria) {
		this.cocheria = cocheria;
	}

	public Date getFechaFallecimiento() {
		return fechaFallecimiento;
	}

	public void setFechaFallecimiento(Date fechaFallecimiento) {
		this.fechaFallecimiento = fechaFallecimiento;
	}
	
}