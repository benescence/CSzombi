package com.revivir.cementerio.negocios;

import com.revivir.cementerio.negocios.manager.ClienteManager;
import com.revivir.cementerio.persistencia.entidades.Cliente;

public class Recepcion {
	

	
	private static void validar(Cliente cliente, String nombre, String apellido, String DNI, String telefono,
			String email, String domicilio) throws Exception {
		
		String mensaje = "";

		if (nombre == null)
			mensaje += "\n    -El NOMBRE no puede estar vac�o.";
		else if (!Validador.nombrePersona(nombre))
			mensaje += "\n    -El NOMBRE solo puede estar compuesto de letras y espacios.";

		if (apellido == null)
			mensaje += "\n    -El APELLIDO no puede estar vacio.";
		else if (!Validador.apellido(apellido))
			mensaje += "\n    -El APELLIDO solo puede estar compuesto de letras y espacios.";
		
		if (DNI == null)
			mensaje += "\n    -El DNI no puede estar vacio.";
		else if (!Validador.DNI(DNI))
			mensaje += "\n    -El DNI solo puede estar compuesto de n�meros.";
		else {
			Cliente clienteBD = ClienteManager.traerPorDNI(DNI);
			if (clienteBD != null && (cliente == null || clienteBD.getID() != cliente.getID()))
				mensaje += "\n    -Ya se encuentra registrado un cliente con el DNI: "+DNI+".";
		}
		
		if (telefono != null && !Validador.telefono(telefono))
			mensaje += "\n    -El TELEFONO solo puede estar compuesto de numeros.";
		
		if (email != null && !Validador.email(email))
			mensaje += "\n    -El EMAIL debe tener un formato de E-Mail apropiado.";
		
		if (!mensaje.equals(""))
			throw new Exception("Se encontraron los siguientes errores en el formulario:"+mensaje);
	}
	
	private static boolean isNull(String texto) {
		return (texto == null || texto.equals(""));
	}

}