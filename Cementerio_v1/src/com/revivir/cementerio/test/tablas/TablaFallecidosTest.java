package com.revivir.cementerio.test.tablas;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import com.revivir.cementerio.negocios.manager.FallecidoManager;
import com.revivir.cementerio.vista.tablas.TablaFallecidos;
import com.revivir.cementerio.vista.util.contenedores.PanelVertical;
import com.revivir.cementerio.vista.util.contenedores.Ventana;

public class TablaFallecidosTest extends Ventana{
	private static final long serialVersionUID = 1L;

	public TablaFallecidosTest() {
		super("Prueba tabla de fallecidos", 500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		TablaFallecidos tabla = new TablaFallecidos(FallecidoManager.traerTodo());
		JScrollPane panelTabla = new JScrollPane(tabla);
		
		PanelVertical panel = new PanelVertical();
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(panel);
		
		panel.add(panelTabla);
		pack();
	}
	
	public static void main(String[] args) {
		new TablaFallecidosTest();
	}

}