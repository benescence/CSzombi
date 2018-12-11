package com.revivir.cementerio.vista.tablas;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import com.revivir.cementerio.persistencia.entidades.Precio;

public class TablaPrecios  extends JTable{
		private static final long serialVersionUID = 1L;
		private String[] columnas = { "codigo", "descripcion", "monto", "Observaciones"};
		private DefaultTableModel modelo;
		private List<Precio> precio;

		public TablaPrecios(List<Precio> precios) {
			modelo = new DefaultTableModel(null, columnas);
			setModel(modelo);
			recargar(precios);
		}	
		
	public void recargar(List<Precio> precios) {
			this.precio = precios;
			modelo.setRowCount(0);
			modelo.setColumnCount(0);
			modelo.setColumnIdentifiers(columnas);

			for (Precio precio: precios) {
				Object[] fila = {
						precio.getCodigo(),
						precio.getDescripcion(),
						precio.getMonto(),
						precio.getNombre()
						
				};
				modelo.addRow(fila);
			}
		}
		
		public List<Precio> obtenerSeleccion() {
			List<Precio> codigos = new ArrayList<>();
			int[] indices = getSelectedRows();

			for (int indice : indices) {
				int codigo = convertRowIndexToModel(indice);
				codigos.add(codigos.get(codigo)); // aca es get sobre precio no sobre codigos, esto devuelve siempre vacio TODO
			}

			return codigos;
		}

}
