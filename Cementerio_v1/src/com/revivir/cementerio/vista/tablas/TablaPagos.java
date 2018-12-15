package com.revivir.cementerio.vista.tablas;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.revivir.cementerio.persistencia.entidades.Pago;
import com.revivir.cementerio.vista.util.Formato;

public class TablaPagos extends JTable{
	private static final long serialVersionUID = 1L;
	private String[] columnas = { "Cliente", "Cargo", "Importe", "Fecha"};
	private DefaultTableModel modelo;
	private List<Pago> pagos;	
	
	public TablaPagos(List<Pago> pagos) {
		modelo = new DefaultTableModel(null, columnas);
		setModel(modelo);
		recargar(pagos);
	}	
	
	public void recargar(List<Pago> lista) {
		this.pagos = lista;
		modelo.setRowCount(0);
		modelo.setColumnCount(0);
		modelo.setColumnIdentifiers(columnas);

		for (Pago elemento: lista) {
			Object[] fila = {
					Formato.cliente(elemento),
					Formato.cargo(elemento),
					elemento.getImporte().toString(),
					elemento.getFecha()
			};
			modelo.addRow(fila);
		}		
	}
	
	public List<Pago> obtenerSeleccion() {
		List<Pago> registros = new ArrayList<>();
		int[] indices = getSelectedRows();

		for (int indice : indices) {
			int registro = convertRowIndexToModel(indice);
			registros.add(pagos.get(registro));
		}

		return registros;
	}

}