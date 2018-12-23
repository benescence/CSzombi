package com.revivir.cementerio.negocios;

import java.util.ArrayList;
import java.util.List;

import com.revivir.cementerio.negocios.manager.FallecidoManager;
import com.revivir.cementerio.negocios.manager.ResponsableManager;
import com.revivir.cementerio.persistencia.entidades.Cliente;
import com.revivir.cementerio.persistencia.entidades.Fallecido;
import com.revivir.cementerio.persistencia.entidades.Responsable;

public class Vinculador {
	
	public static List<Fallecido> traerFallecidosDeCliente(Cliente cliente) {
		List<Responsable> lista = ResponsableManager.traerPorCliente(cliente);
		List<Fallecido> ret = new ArrayList<>();
		for (Responsable elemento : lista)
			ret.add(FallecidoManager.traerPorID(elemento.getFallecido()));
		
		return ret;
	}

	public static void vincular(Cliente cliente, Fallecido fallecido) {
		ResponsableManager.guardar(cliente, fallecido, "");
	}

	public static boolean estanVinculados(Cliente cliente, Fallecido fallecido) {
		return ResponsableManager.traerPorClienteFallecido(cliente, fallecido) != null;
	}
	
}