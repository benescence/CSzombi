package com.revivir.cementerio.persistencia.entidades;

import java.sql.Date;

public class Movimiento {
	private Integer ID, fallecido;
	private String antiguaUbicacion, causaTraslado, observaciones;
	private Date ferchaTranslado;
	
	public Movimiento(Integer ID, Integer fallecido, String antiguaUbicacion, String causaTraslado,
			String observaciones, Date fechaTranslado) {
		this.ID = ID;
		this.fallecido = fallecido;
		this.antiguaUbicacion = antiguaUbicacion;
		this.causaTraslado = causaTraslado;
		this.observaciones = observaciones;
		this.ferchaTranslado = fechaTranslado;
	}

	public Date getFerchaTranslado() {
		return ferchaTranslado;
	}

	public void setFerchaTranslado(Date ferchaTranslado) {
		this.ferchaTranslado = ferchaTranslado;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer ID) {
		this.ID = ID;
	}

	public Integer getFallecido() {
		return fallecido;
	}

	public void setFallecido(Integer fallecido) {
		this.fallecido = fallecido;
	}

	public String getAntiguaUbicacion() {
		return antiguaUbicacion;
	}

	public void setAntiguaUbicacion(String antiguaUbicacion) {
		this.antiguaUbicacion = antiguaUbicacion;
	}

	public String getCausaTraslado() {
		return causaTraslado;
	}

	public void setCausaTraslado(String causaTraslado) {
		this.causaTraslado = causaTraslado;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
}