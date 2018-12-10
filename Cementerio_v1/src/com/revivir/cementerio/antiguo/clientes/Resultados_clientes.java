package com.revivir.cementerio.antiguo.clientes;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.revivir.cementerio.antiguo.logica.Clientes;

import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;


public class Resultados_clientes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	Clientes cliente2;
	
	int selected_row;
	
//	ArrayList<Clientes> clientes_row;
	/**
	 * Launch the application.
	 * @param cliente 
	 */
	public static void main(String[] args, ArrayList<Clientes> cliente, int r) {
		try {
			Resultados_clientes dialog = new Resultados_clientes(cliente, r);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @param r 
	 * @param clientes_row2 
	 * @param clientes_row2 
	 */
	public Resultados_clientes(ArrayList<Clientes> clientes_row, int r) {
		setTitle("Resultado de la busqueda");
		setBounds(100, 100, 749, 372);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
	
		table = new JTable();
		table.setBounds(10, 28, 713, 261);

		
		
		// Y REEMPLAZAR ACA PORQUE MUESTRO LO QUE CARGO LO QUE COMPLETÉ EN LA PANTALLA ANTERIOR.
		 DefaultTableModel modelo = new DefaultTableModel();
		 modelo =  (new DefaultTableModel(
				 null, new String [] {
						 "Nombre","Apellido",
						 "DNI",  "Domicilio", "Fecha", 
						 "Domiclio Familiar", "Telefono", 
						 "Email","Cochearia"}){
						 Class[] types = new Class [] {
						 java.lang.String.class,
						 java.lang.String.class,
						 java.lang.String.class,
						 java.lang.String.class,
						 java.lang.String.class,
						 java.lang.String.class,
						 java.lang.String.class,
						 java.lang.String.class,
						 java.lang.String.class,
						 };
		 			});
		 
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Apellido", "DNI", "Domicilio", "Fecha", "Domiclio Familiar", "Telefono", "Email", "Cochearia"
			}
		));
		Object O[]= null;
		modelo.addRow(O);
		for (int i=0;i<clientes_row.size();i++){
		
		table.setValueAt(clientes_row.get(i).getApellidos(), i, 0);
		table.setValueAt(clientes_row.get(i).getNombres(), i, 1);
		table.setValueAt(clientes_row.get(i).getDni(), i, 2);
		table.setValueAt(clientes_row.get(i).getDomicilio(),i, 3);
		table.setValueAt(clientes_row.get(i).getFecha_fallec(),i, 4);
		table.setValueAt(clientes_row.get(i).getDni_ocupante(), i, 5);
		table.setValueAt(clientes_row.get(i).getTelefono(), i, 6);
		table.setValueAt(clientes_row.get(i).getEmail(), i, 7);
		table.setValueAt(clientes_row.get(i).getCocheria(), i, 8);
		modelo.addRow(O);
	}
		
		contentPanel.add(table);
		
//		System.out.println(clientes_row.getApellidos());
		
		JLabel lbl_1 = new JLabel("Se han encontrado los siguientes resultados:");
		lbl_1.setBounds(26, 11, 303, 14);
		
		contentPanel.add(lbl_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int row = table.getSelectedRow();
						Clientes row_cliente = new Clientes();
						row_cliente = clientes_row.get(row);
						System.out.print("fila seleccionada");
//						clientes_row.clear();
//						clientes_row.add(row_cliente);
						
						
						getContentPane().removeAll();
		                getContentPane().repaint();
		                
//						Consulta_resultado cr = new Consulta_resultado();
//						cr.setVisible(true);
		                
//						getContentPane().add(cr);
						
//						getContentPane().removeAll();
//		                getContentPane().repaint();
//						Consulta_resultado cr = new Consulta_resultado(row_cliente);
//						cr.setVisible(true);
//						getContentPane().add(cr);
//						System.out.println(clientes_row.get(row).getDni());
						
						dispose();
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	public void setCliente(ArrayList<Clientes> cliente){
//		cliente2 = new Clientes();
		
//		cliente2.setApellidos(cli.getApellidos());
//		cliente2.setNombres(cli.getNombres());
//		cliente2.setDni(cli.getDni());
		
		//BUSCAR EN LA BASE DE DATOS, CON EL PARAMETRO CLIENTE 
//				Clientes aux = new Clientes();
//				clientes_row = new ArrayList<Clientes>();
//				clientes_row=cliente2.buscarCliente();
//				auxcli.get(0).getApellidos();
				
				
	}
	public void setRow(int r){
		selected_row = r;
	}
	public int getRow(){
		return selected_row;
	}
}
