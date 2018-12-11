package com.revivir.cementerio.persistencia.entidades;

import java.util.Date;

import com.revivir.cementerio.persistencia.definidos.SubSector;

public class Ubicacion {
	private Integer id, deposito;
	private String otroCementerio, osario, nicho, fila, seccion, macizo,
	unidad, bis, bis_macizo, numero, sepultura, parcela, mueble, inhumacion, circ;
	private Date vencimiento;
	private SubSector subsector;
	
	public Ubicacion(Integer id, SubSector subsector, String otroCementerio, String osario,
			String nicho, String fila, String seccion, String macizo, String unidad, String bis, String bis_macizo,
			String numero, String sepultura, String parcela, String mueble, String inhumacion, String circ, Date vencimiento) {
		this.id = id;
		this.subsector = subsector;
		this.otroCementerio = otroCementerio;
		this.osario = osario;
		this.nicho = nicho;
		this.fila = fila;
		this.seccion = seccion;
		this.macizo = macizo;
		this.unidad = unidad;
		this.bis = bis;
		this.bis_macizo = bis_macizo;
		this.numero = numero;
		this.sepultura = sepultura;
		this.parcela = parcela;
		this.mueble = mueble;
		this.inhumacion = inhumacion;
		this.circ = circ;
		this.vencimiento= vencimiento;
	}

	public Date getVencimiento() {
		return vencimiento;
	}

	public void setVencimiento(Date vencimiento) {
		this.vencimiento = vencimiento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public SubSector getSubsector() {
		return subsector;
	}

	public void setSubsector(SubSector subsector) {
		this.subsector = subsector;
	}

	public String getOtroCementerio() {
		return otroCementerio;
	}

	public void setOtroCementerio(String otroCementerio) {
		this.otroCementerio = otroCementerio;
	}

	public String getOsario() {
		return osario;
	}

	public void setOsario(String osario) {
		this.osario = osario;
	}

	public String getNicho() {
		return nicho;
	}

	public void setNicho(String nicho) {
		this.nicho = nicho;
	}

	public String getFila() {
		return fila;
	}

	public void setFila(String fila) {
		this.fila = fila;
	}

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	public String getMacizo() {
		return macizo;
	}

	public void setMacizo(String macizo) {
		this.macizo = macizo;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public String getBis() {
		return bis;
	}

	public void setBis(String bis) {
		this.bis = bis;
	}

	public String getBis_macizo() {
		return bis_macizo;
	}

	public void setBis_macizo(String bis_macizo) {
		this.bis_macizo = bis_macizo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getSepultura() {
		return sepultura;
	}

	public void setSepultura(String sepultura) {
		this.sepultura = sepultura;
	}

	public String getParcela() {
		return parcela;
	}

	public void setParcela(String parcela) {
		this.parcela = parcela;
	}

	public String getMueble() {
		return mueble;
	}

	public void setMueble(String mueble) {
		this.mueble = mueble;
	}

	public String getInhumacion() {
		return inhumacion;
	}

	public void setInhumacion(String inhumacion) {
		this.inhumacion = inhumacion;
	}

	public String getCirc() {
		return circ;
	}

	public void setCirc(String circ) {
		this.circ = circ;
	}

	


}