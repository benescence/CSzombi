package com.revivir.cementerio.vista.usuarios;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JInternalFrame;

import com.revivir.cementerio.MainPrincipal;
import com.revivir.cementerio.negocios.manager.UsuarioManager;
import com.revivir.cementerio.persistencia.entidades.Usuario;
import com.revivir.cementerio.vista.ControladorInterno;
import com.revivir.cementerio.vista.usuarios.alta.ControladorUsuarioAM;
import com.revivir.cementerio.vista.util.Popup;

public class ControladorUsuarios implements ControladorInterno {
	private VentanaUsuarios ventana;
	private MainPrincipal invocador;
	
	public ControladorUsuarios(MainPrincipal invocador) {
		this.invocador = invocador;
		ventana = new VentanaUsuarios();
		ventana.botonAgregar().addActionListener(e -> agregar());
		ventana.botonModificar().addActionListener(e -> modificar());
		ventana.botonEliminar().addActionListener(e -> eliminar());
		ventana.botonBuscar().addActionListener(e -> buscar());
		ventana.botonLimpiar().addActionListener(e -> limpiar());
	}
	
	private void agregar() {
		invocador.setEnabled(false);
		new ControladorUsuarioAM(this);
	}
	
	private void modificar() {
		List<Usuario> seleccion = ventana.getTabla().obtenerSeleccion();
		if (seleccion.size() != 1) {
			Popup.mostrar("Debe seleccionar exactamente 1 usuario para poder modificarlo.");
			return;
		}
		
		invocador.setEnabled(false);
		new ControladorUsuarioAM(this, seleccion.get(0));
	}
	
	private void limpiar() {
		ventana.getUsuario().setText("");
	}
	
	private void eliminar() {
		List<Usuario> seleccion = ventana.getTabla().obtenerSeleccion();
		if (seleccion.isEmpty()) {
			Popup.mostrar("Debe seleccionar algun usuario para poder eliminarlo.");
			return;
		}
		
		if (Popup.confirmar("�Esta seguro de que desea eliminar los usuarios seleccionados?")) {
			for (Usuario usuario : seleccion)
				UsuarioManager.eliminar(usuario);
			
			actualizarTabla();
		}
	}
	
	private void buscar() {
		String usuario = ventana.getUsuario().getText();
		
		// BUSCA POR USUARIO
		if (!usuario.equals("")) {
			List<Usuario> lista = new ArrayList<>();
			Usuario ret = UsuarioManager.traerPorUsuario(usuario);
			if (ret != null)
				lista.add(ret);
			
			ventana.getTabla().recargar(lista);
			
		// TRAE TODOS
		} else
			actualizarTabla();
	}
	
	public void actualizarTabla() {
		List<Usuario> lista = UsuarioManager.traerTodo();
		ventana.getTabla().recargar(lista);
	}

	@Override
	public boolean finalizar() {
		return true;
	}

	@Override
	public JInternalFrame getVentana() {
		return ventana;
	}

	public void mostrar() {
		invocador.setVisible(true);
		invocador.setEnabled(true);
	}
	
}