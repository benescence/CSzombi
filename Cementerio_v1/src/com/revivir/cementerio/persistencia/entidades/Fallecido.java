package com.revivir.cementerio.persistencia.entidades;

import java.sql.Date;

import com.revivir.cementerio.persistencia.definidos.TipoFallecimiento;

public class Fallecido {
	private Integer ID,  ubicacion;
	private String dni, apellido, nombre, cocheria;
	private Date fechaFallecimiento, fechaIngreso;
	private TipoFallecimiento tipoFallecimiento;
	
	public Fallecido(Integer ID, Integer ubicacion, TipoFallecimiento tipoFallecimiento, String dni, String apellido, String nombre, String cocheria,
			Date fechaFallecimiento, Date fechaIngreso) {
		this.ID = ID;
		this.ubicacion = ubicacion;
		this.tipoFallecimiento = tipoFallecimiento;
		this.dni = dni;
		this.apellido = apellido;
		this.nombre = nombre;
		this.cocheria = cocheria;
		this.fechaFallecimiento = fechaFallecimiento;
		this.fechaIngreso = fechaIngreso;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer ID) {
		this.ID = ID;
	}
	
	public Integer getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Integer ubicacion) {
		this.ubicacion = ubicacion;
	}

	public TipoFallecimiento getTipoFallecimiento() {
		return tipoFallecimiento;
	}

	public void setTipoFallecimiento(TipoFallecimiento tipoFallecimiento) {
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