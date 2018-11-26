package com.revivir.cementerio.persistencia;

import com.revivir.cementerio.persistencia.definidos.Roles;
import com.revivir.cementerio.persistencia.definidos.SubSector;
import com.revivir.cementerio.persistencia.definidos.TipoFallecimiento;

public class Definido {
	
	public static Integer tipoFallecimiento(TipoFallecimiento tipo) {
		Integer ret = null;
		if (tipo == TipoFallecimiento.TRAUMATICO)
			ret = 1;
		else if (tipo == TipoFallecimiento.NO_TRAUMATICO)
			ret = 2;
		return ret;
	}

	public static TipoFallecimiento tipoFallecimiento(Integer tipo) {
		TipoFallecimiento ret = null;
		if (tipo == 1)
			ret = TipoFallecimiento.TRAUMATICO;
		else if (tipo == 2)
			ret = TipoFallecimiento.NO_TRAUMATICO;
		return ret;
	}

	public static Integer subsector(SubSector subsector) {
		Integer ret = null;
		
		if (subsector == SubSector.SEPULTURAS)
			ret = 1;
		else if (subsector == SubSector.INDIGENTES)
			ret = 2;
		else if (subsector == SubSector.PALMERAS_ATAUD)
			ret = 3;
		else if (subsector == SubSector.PALMERAS_CENIZAS)
			ret = 4;
		else if (subsector == SubSector.PALMERAS_RESTOS)
			ret = 5;
		else if (subsector == SubSector.PALMERAS_SEPULTURAS)
			ret = 6;
		else if (subsector == SubSector.NICHERA)
			ret = 7;
		else if (subsector == SubSector.CENIZARIO)
			ret = 8;
		else if (subsector == SubSector.BOVEDA)
			ret = 9;
		
		return ret;
	}
	
	public static SubSector subsector(Integer subsector) {
		SubSector ret = null;
		
		if (subsector == 1)
			ret = SubSector.SEPULTURAS;
		else if (subsector == 2)
			ret = SubSector.INDIGENTES;
		else if (subsector == 3)
			ret = SubSector.PALMERAS_ATAUD;
		else if (subsector == 4)
			ret = SubSector.PALMERAS_CENIZAS;
		else if (subsector == 5)
			ret = SubSector.PALMERAS_RESTOS;
		else if (subsector == 6)
			ret = SubSector.PALMERAS_SEPULTURAS;
		else if (subsector == 7)
			ret = SubSector.NICHERA;
		else if (subsector == 8)
			ret = SubSector.CENIZARIO;
		else if (subsector == 9)
			ret = SubSector.BOVEDA;
			
		return ret;
	}
	public static Integer roles(Roles tipo) {
		Integer ret = null;
		if (tipo == Roles.Administrativo)
			ret = 1;
		else if (tipo == Roles.Supervisor)
			ret = 2;
		return ret;
	}

	public static Roles roles(Integer tipo) {
		Roles ret = null;
		if (tipo == 1)
			ret = Roles.Administrativo;
		else if (tipo == 2)
			ret = Roles.Supervisor;
		return ret;
	}
}