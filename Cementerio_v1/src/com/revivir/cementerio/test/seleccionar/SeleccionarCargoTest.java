package com.revivir.cementerio.test.seleccionar;

import com.revivir.cementerio.persistencia.entidades.Cargo;
import com.revivir.cementerio.vista.seleccion.cargos.CargoSeleccionable;
import com.revivir.cementerio.vista.seleccion.cargos.ControladorSeleccionCargo;

public class SeleccionarCargoTest implements CargoSeleccionable {

	@Override
	public void seleccionarCargo(Cargo cargo) {
		System.out.println("Se ha seleccionado el cargo:"+cargo.getObservaciones());
	}

	@Override
	public void mostrar() {
	
	}
	
	public static void main(String[] args) {
		new ControladorSeleccionCargo(new SeleccionarCargoTest());
	}

}