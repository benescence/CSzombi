package com.revivir.cementerio.persistencia.entidades;

public class Cliente {
	private Integer ID;
	private String dni, apellido, nombre, telefono, email;

	public Cliente(Integer ID, String dni, String apellido, String nombre, String telefono, String email) {
		this.ID = ID;
		this.dni = dni;
		this.apellido = apellido;
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer ID) {
		this.ID = ID;
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}