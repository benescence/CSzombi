package com.revivir.cementerio.vista.tablas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.revivir.cementerio.persistencia.entidades.Cliente;
import com.revivir.cementerio.vista.util.Formato;

public class TablaClientes extends JTable{
	private static final long serialVersionUID = 1L;
	private String[] columnas = { "DNI", "Nombre", "Apellido", "Telefono", "E-Mail", "Difuntos asociados"};
	private DefaultTableModel modelo;
	private List<Cliente> clientes;

	public TablaClientes(List<Cliente> clientes) {
		modelo = new DefaultTableModel(null, columnas);
		setModel(modelo);
		recargar(clientes);
	}	
	
	public void recargar(List<Cliente> clientes) {
		this.clientes = clientes;
		modelo.setRowCount(0);
		modelo.setColumnCount(0);
		modelo.setColumnIdentifiers(columnas);

		for (Cliente cliente: clientes) {
			Object[] fila = {
					cliente.getDni(),
					cliente.getNombre(),
					cliente.getApellido(),
					cliente.getTelefono(),
					cliente.getEmail(),
					Formato.fallecidos(cliente)
			};
			modelo.addRow(fila);
			
			// seteo la altura de la celda
			int registro = modelo.getRowCount() - 1;
			int altura = Formato.calcularAlturaDeCelda(fila);
			setRowHeight(registro, altura);
		}
	}
	
	public List<Cliente> obtenerSeleccion() {
		List<Cliente> registros = new ArrayList<>();
		int[] indices = getSelectedRows();

		for (int indice : indices) {
			int registro = convertRowIndexToModel(indice);
			registros.add(clientes.get(registro));
		}

		return registros;
	}

}