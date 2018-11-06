package com.revivir.cementerio.vista.tablas;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.revivir.cementerio.persistencia.entidades.Fallecido;

public class TablaFallecidos extends JTable{
	private static final long serialVersionUID = 1L;
	private String[] columnas = { "DNI", "Nombre", "Apellido", "Fecha de fallecimiento", "Tipo de fallecimiento", "Cocheria"};
	private DefaultTableModel modelo;
	private List<Fallecido> fallecidos;

	public TablaFallecidos(List<Fallecido> fallecidos) {
		modelo = new DefaultTableModel(null, columnas);
		setModel(modelo);
		recargar(fallecidos);
	}	
	
	public void recargar(List<Fallecido> lista) {
		this.fallecidos = lista;
		modelo.setRowCount(0);
		modelo.setColumnCount(0);
		modelo.setColumnIdentifiers(columnas);

		for (Fallecido elemento: lista) {
			Object[] fila = {
					elemento.getDni(),
					elemento.getNombre(),
					elemento.getApellido(),
					elemento.getFechaFallecimiento(),
					elemento.getTipoFallecimiento(),
					elemento.getCocheria()
			};
			modelo.addRow(fila);
		}
	}
	
	public List<Fallecido> obtenerSeleccion() {
		List<Fallecido> registros = new ArrayList<>();
		int[] indices = getSelectedRows();

		for (int indice : indices) {
			int registro = convertRowIndexToModel(indice);
			registros.add(fallecidos.get(registro));
		}

		return registros;
	}

}