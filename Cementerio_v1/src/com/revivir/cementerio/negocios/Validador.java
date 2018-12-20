package com.revivir.cementerio.negocios;

public class Validador {
	
	public static boolean nombrePersona(String nombre) {
		return formatoLetraEspacio(nombre);
	}

	public static boolean apellido(String apellido) {
		return formatoLetraEspacio(apellido);
	}

	public static boolean DNI(String DNI) {
		return formatoNumero(DNI);
	}
	
	public static boolean telefono(String telefono) {
		return formatoNumero(telefono);
	}
		
	
	
	
	
	
	
	
	
	
	

	// METODOS INTERNOS DEL VALIDADOR
	private static boolean formatoNumero(String texto) {
		return texto.matches("[0-9]+");
	}

	private static boolean formatoLetra(String texto) {
		return texto.matches("[a-zA-ZÀ-ÿ\\u00f1\\u00d1]+");
	}

	private static boolean formatoLetraEspacio(String texto) {
		return texto.matches("[a-zA-ZÀ-ÿ\\u00f1\\u00d1\\s]+");
	}
	
	private static boolean formatoNumeroLetraEspacio(String texto) {
		return texto.matches("[a-zA-ZÀ-ÿ0-9\\u00f1\\u00d1\\s]+");
	}
	
	private static boolean formatoNumeroLetra(String texto) {
		return texto.matches("[a-zA-ZÀ-ÿ0-9\\u00f1\\u00d1]+");
	}
	
	
	// METODOS QUE USAN LOS DEMAS PARA VALIDAR CAMPOS
	public static boolean validarExamen(String nombre) {
		return (formatoNumeroLetraEspacio(nombre));
	}
	
	public static boolean validarEmail(String texto) {
		return texto.matches("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@" + "[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$");
	}
	
	
	public static boolean validarNumero(String texto) {
		return (formatoNumero(texto));
	}
	
	public static boolean validarUsuario(String texto) {
		return (formatoNumeroLetra(texto));
	}
	
	public static boolean validarPassword(String texto) {
		return (formatoNumeroLetra(texto));
	}
	
	public static void main(String[] args) {
		System.out.println(formatoLetra("TamóÑ"));
		System.out.println(formatoNumeroLetraEspacio("45 XCarlós Ñ ñ"));
		
	}

	public static boolean validarCodigo(String codigo) {
		
	return (formatoNumero(codigo));
	}
			
}