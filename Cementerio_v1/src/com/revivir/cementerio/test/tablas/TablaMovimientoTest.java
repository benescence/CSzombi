package com.revivir.cementerio.test.tablas;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import com.revivir.cementerio.negocios.manager.MovimientoManager;
import com.revivir.cementerio.vista.tablas.TablaMovimientos;
import com.revivir.cementerio.vista.util.contenedores.PanelVertical;
import com.revivir.cementerio.vista.util.contenedores.Ventana;

public class TablaMovimientoTest extends Ventana{
	private static final long serialVersionUID = 1L;

	public TablaMovimientoTest() {
		super("Prueba tabla de movimientos", 500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		TablaMovimientos tabla = new TablaMovimientos(MovimientoManager.traerTodo());
		JScrollPane panelTabla = new JScrollPane(tabla);
		
		PanelVertical panel = new PanelVertical();
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(panel);
		
		panel.add(panelTabla);
		compactar();
	}
	
	public static void main(String[] args) {
		new TablaMovimientoTest();
	}

}