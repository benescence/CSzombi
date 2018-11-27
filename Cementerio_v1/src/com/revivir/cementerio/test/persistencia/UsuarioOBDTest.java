package com.revivir.cementerio.test.persistencia;

import java.util.List;

import com.revivir.cementerio.persistencia.FactoryOBD;
import com.revivir.cementerio.persistencia.definidos.Rol;
import com.revivir.cementerio.persistencia.entidades.Usuario;
import com.revivir.cementerio.persistencia.interfaces.UsuarioOBD;

public class UsuarioOBDTest {
	
	public static void insertTest(Usuario elemento) {
		System.out.println("___ Insert test");
		UsuarioOBD obd = FactoryOBD.crearUsuarioOBD();
		obd.insert(elemento);
	}
	
	public static void updateTest(Usuario elemento) {
		System.out.println("___ Update test");
		UsuarioOBD obd = FactoryOBD.crearUsuarioOBD();
		obd.update(elemento);
	}

	public static void deleteTest(Usuario elemento) {
		System.out.println("___ Delete test");
		UsuarioOBD obd = FactoryOBD.crearUsuarioOBD();
		obd.delete(elemento);
	}
	
	public static void selectTest() {
		System.out.println("___ Select test");
		UsuarioOBD obd = FactoryOBD.crearUsuarioOBD();
		List<Usuario> lista = obd.select();
		for (Usuario elemento : lista)
			System.out.println("Usuario: "+elemento.getUsuario());
		System.out.println("Cantidad: "+lista.size());
	}
		
	public static void main(String[] args) {
		Usuario usuario = new Usuario(-1, "Carlos1991", "12344", Rol.ADMINISTRATIVO);
		
		updateTest(usuario);
		selectTest();
		
	

		// Estaria bueno tener un select test tambien 
	}

}