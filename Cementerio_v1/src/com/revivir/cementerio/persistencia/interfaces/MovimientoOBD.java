package com.revivir.cementerio.persistencia.interfaces;

import java.util.List;


import com.revivir.cementerio.persistencia.entidades.Movimiento;



public interface MovimientoOBD {
	
	
public void insert(Movimiento movimiento);
	
	public void update(Movimiento movimieento );
	
	public void delete(Movimiento movimieento );

	public List<Movimiento> select();

	public Movimiento ultimoInsertado();
	
	public Movimiento selectByDNI(String DNI);

	public Movimiento  selectByID(Integer ID);
	
	public List<Movimiento> selectByFallecido(Integer fallecido);

	public List<Movimiento> selectByFallecidoNombre(String nombre, String apellido);

}
