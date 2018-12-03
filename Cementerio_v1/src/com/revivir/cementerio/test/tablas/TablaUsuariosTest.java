package com.revivir.cementerio.test.tablas;

import java.util.List;

import javax.swing.JScrollPane;

import com.revivir.cementerio.persistencia.FactoryOBD;
import com.revivir.cementerio.persistencia.entidades.Usuario;
import com.revivir.cementerio.persistencia.interfaces.UsuarioOBD;
import com.revivir.cementerio.vista.tablas.TablaUsuarios;
import com.revivir.cementerio.vista.util.Ventana;

public class TablaUsuariosTest extends Ventana{
	private static final long serialVersionUID = 1L;

	public TablaUsuariosTest() {
		super("Prueba tabla de usuarios", 500, 500);
		UsuarioOBD obd = FactoryOBD.crearUsuarioOBD();
		List<Usuario> usuarios = obd.select();
		TablaUsuarios tabla = new TablaUsuarios(usuarios);
		JScrollPane panelTabla = new JScrollPane(tabla);
		getContentPane().add(panelTabla);
	}
	
	public static void main(String[] args) {
		new TablaUsuariosTest();
	}

}