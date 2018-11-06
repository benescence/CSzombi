package com.revivir.cementerio.persistencia;

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

}