package com.revivir.cementerio.vista.seleccion.cargos;

import com.revivir.cementerio.persistencia.entidades.Cargo;

public interface CargoSeleccionable {
	
	public void seleccionarCargo(Cargo cargo);

	public void mostrar();

}