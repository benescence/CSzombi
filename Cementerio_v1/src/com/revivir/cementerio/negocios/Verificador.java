package com.revivir.cementerio.negocios;

import com.revivir.cementerio.negocios.manager.ClienteManager;
import com.revivir.cementerio.negocios.manager.ServicioManager;
import com.revivir.cementerio.persistencia.entidades.Cliente;
import com.revivir.cementerio.persistencia.entidades.Servicio;

public class Verificador {

	public static Cliente cliente(Cliente nuevo, Cliente anterior) throws Exception {
		String nombre = anular(nuevo.getNombre());
		String apellido = anular(nuevo.getApellido());
		String DNI = anular(nuevo.getDNI());
		String telefono = anular(nuevo.getTelefono());
		String email = anular(nuevo.getEmail());
		String domicilio = anular(nuevo.getDomicilio());
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
			Cliente clienteDNI = ClienteManager.traerPorDNI(DNI);
			if (clienteDNI != null && (anterior == null || anterior.getID() != clienteDNI.getID()))
				mensaje += "\n    -Ya se encuentra registrado un cliente con el DNI: "+DNI+".";
		}
		
		if (telefono != null && !Validador.telefono(telefono))
			mensaje += "\n    -El TELEFONO solo puede estar compuesto de numeros.";
		
		if (email != null && !Validador.email(email))
			mensaje += "\n    -El EMAIL debe tener un formato de E-Mail apropiado.";
		
		if (!mensaje.equals(""))
			throw new Exception("Se encontraron los siguientes errores en el formulario:"+mensaje);
		
		// Debo setearlos porque pudieron ser anulados
		if (anterior != null)
			nuevo.setID(anterior.getID());
		nuevo.setNombre(nombre);
		nuevo.setApellido(apellido);
		nuevo.setDNI(DNI);
		nuevo.setTelefono(telefono);
		nuevo.setEmail(email);
		nuevo.setDomicilio(domicilio);

		return nuevo;
	}
	
	public static Servicio servicio(Servicio nuevo, Servicio anterior) throws Exception {
		String codigo = anular(nuevo.getCodigo());
		String nombre = anular(nuevo.getNombre());
		String descripcion = anular(nuevo.getDescripcion());
		String mensaje = "";

		if (codigo == null)
			mensaje += "\n    -El CODIGO no puede estar vacio.";
		else if (!Validador.codigo(codigo))
			mensaje += "\n    -El CODIGO solo puede estar compuesto de numeros.";
		else {
			Servicio objetoCodigo = ServicioManager.traerActivoPorCodigo(codigo);
			if (objetoCodigo != null && (anterior == null || anterior.getID() != objetoCodigo.getID()))
				mensaje += "\n    -Ya se encuentra registrado un servicio con el CODIGO: "+codigo+".";
		}
		
		if (nombre == null)
			mensaje += "\n    -El NOMBRE no puede estar vac�o.";
		else if (!Validador.nombreServicio(nombre))
			mensaje += "\n    -El NOMBRE solo puede estar compuesto de letras, numeros y espacios.";
		
		
		if (!mensaje.equals(""))
			throw new Exception("Se encontraron los siguientes errores en el formulario:"+mensaje);
		
		// Debo setearlos porque pudieron ser anulados
		if (anterior != null)
			nuevo.setID(anterior.getID());
		nuevo.setCodigo(codigo);
		nuevo.setNombre(nombre);
		nuevo.setDescripcion(descripcion);
		return nuevo;
	}

	private static String anular(String texto) {
		if (texto == null || texto.equals(""))
			return null;
		else
			return texto;
	}

}