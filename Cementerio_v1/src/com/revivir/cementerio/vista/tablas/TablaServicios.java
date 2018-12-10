package com.revivir.cementerio.vista.tablas;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.revivir.cementerio.vista.util.Formato;

public class TablaServicios extends JTable{
	private static final long serialVersionUID = 1L;
	private String[] columnas = { "Codigo", "Nombre", "Importe", "Descripcion"};
	private DefaultTableModel modelo;
	private List<Object> servicios;

	public TablaServicios(List<Object> servicios) {
		modelo = new DefaultTableModel(null, columnas);
		setModel(modelo);
		recargar(servicios);
	}	
	
	public void recargar(List<Object> servicios) {
		this.servicios = servicios;
		modelo.setRowCount(0);
		modelo.setColumnCount(0);
		modelo.setColumnIdentifiers(columnas);

		//for (Object cliente: servicios) {
		for (int i=0; i<5; i++) {
			Object[] fila = {
					"Codigo",
					"Nombre",
					"Importe",
					"Descripcion"
				};
			modelo.addRow(fila);
			
			// seteo la altura de la celda
			int registro = modelo.getRowCount() - 1;
			int altura = Formato.calcularAlturaDeCelda(fila);
			setRowHeight(registro, altura);
		}
	}
	
	public List<Object> obtenerSeleccion() {
		List<Object> registros = new ArrayList<>();
		int[] indices = getSelectedRows();

		for (int indice : indices) {
			int registro = convertRowIndexToModel(indice);
			registros.add(servicios.get(registro));
		}

		return registros;
	}

}