package com.revivir.cementerio.vista.tablas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.revivir.cementerio.persistencia.entidades.Cliente;

public class TablaUsuarios extends JTable{
	// hacer cuando este listo el backend para usuarios
	private static final long serialVersionUID = 1L;
	private String[] columnas = { "Usuario", "Password", "Permisos"};
	private DefaultTableModel modelo;
	//private List<Cliente> clientes;

	public TablaUsuarios(List<Cliente> clientes) {
		modelo = new DefaultTableModel(null, columnas);
		setModel(modelo);
		//recargar(clientes);
	}	
	
	public void recargar(List<Cliente> clientes) {
		//this.clientes = clientes;
		modelo.setRowCount(0);
		modelo.setColumnCount(0);
		modelo.setColumnIdentifiers(columnas);

		for (Cliente cliente: clientes) {
			Object[] fila = {
					cliente.getDni(),
					cliente.getNombre(),
					cliente.getApellido(),
					cliente.getTelefono(),
					cliente.getEmail()
			};
			modelo.addRow(fila);
		}
	}
	
	public List<Cliente> obtenerSeleccion() {
		List<Cliente> registros = new ArrayList<>();
		int[] indices = getSelectedRows();

		for (int indice : indices) {
			int registro = convertRowIndexToModel(indice);
			//registros.add(clientes.get(registro));
		}

		//return registros;
		return null;
	}

}