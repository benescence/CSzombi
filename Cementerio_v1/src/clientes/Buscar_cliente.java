package clientes;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logica.Clientes;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Buscar_cliente extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField txt_apellido;
	private JTextField txt_nombres;
	private JTable table;
	int row;
	ArrayList<Clientes> clientes_row =  new ArrayList<Clientes>();
	Clientes clientes = new Clientes();
	Clientes result = new Clientes();
	private JScrollPane scrollPane;
	
	private Alta_clientes father;
	private JTextField txt_dni;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			buscar_cliente dialog = new buscar_cliente();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	
	 Buscar_cliente(Alta_clientes father ){
		 this.father = father;
	 }
	/**
	 * @wbp.parser.constructor
	 */
	public Buscar_cliente( Alta_clientes father, boolean modal) {
		
		setBounds(100, 100, 641, 433);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			txt_apellido = new JTextField();
			txt_apellido.setBounds(87, 24, 190, 20);
			contentPanel.add(txt_apellido);
			txt_apellido.setColumns(10);
		}
		{
			JLabel lbl_apellido = new JLabel("Apellido");
			lbl_apellido.setBounds(10, 27, 67, 14);
			contentPanel.add(lbl_apellido);
		}
		{
			txt_nombres = new JTextField();
			txt_nombres.setBounds(87, 54, 190, 20);
			txt_nombres.setColumns(10);
			contentPanel.add(txt_nombres);
		}
		{
			JLabel lblNombres = new JLabel("Nombres");
			lblNombres.setBounds(10, 57, 70, 14);
			contentPanel.add(lblNombres);
		}
		{
			table = new JTable();
			table.setBounds(10, 125, 605, 208);
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					row = table.getSelectedRow();
					System.out.println(row);
					
					result.setApellidos(clientes_row.get(row).getApellidos());
					result.setNombres(clientes_row.get(row).getNombres());
					result.setDni(clientes_row.get(row).getDni());
					result.setDomicilio(clientes_row.get(row).getDomicilio());
					result.setNombre_familiar(clientes_row.get(row).getNombre_familiar());
					result.setEmail(clientes_row.get(row).getEmail());
					result.setTelefono(clientes_row.get(row).getTelefono());
					
				}
			});
			contentPanel.add(table);
			
			scrollPane = new JScrollPane(table);
			scrollPane.setBounds(10, 125, 605, 208);
			contentPanel.add(scrollPane);
			
			JButton btnNewButton = new JButton("Buscar");
			btnNewButton.setBounds(405, 26, 111, 21);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					Clientes clientes = new Clientes();
				    clientes = cargar_cliente_buscar();
				    
				    if (!txt_apellido.getText().equals("") && !txt_nombres.getText().equals("") && !txt_dni.getText().equals("")){
				    	clientes_row =  new ArrayList<Clientes>();
				    	clientes_row = clientes.buscarCliente();
				    	
				    	if (clientes_row.size()!=0 ){

							 DefaultTableModel modelo = new DefaultTableModel();
							 modelo =  (new DefaultTableModel(
									 null, new String [] {
											 "Apellido", "Nombre",
											 "DNI",  "Domicilio", "Fecha", 
											 "Domiclio Familiar", "Telefono", 
											 "Email","Cocheria"}){
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
							Object O[]= null;
							modelo.addRow(O);
							table.setModel(modelo);
							for (int i=0;i<clientes_row.size();i++){
							
							table.setValueAt(clientes_row.get(i).getApellidos(), i, 0);
							table.setValueAt(clientes_row.get(i).getNombres(), i, 1);
							table.setValueAt(clientes_row.get(i).getDni(), i, 2);
							table.setValueAt(clientes_row.get(i).getDomicilio(),i, 3);
							table.setValueAt(clientes_row.get(i).getFecha_fallec(),i, 4);
							table.setValueAt(clientes_row.get(i).getDireccion_familiar(), i, 5);
							table.setValueAt(clientes_row.get(i).getTelefono(), i, 6);
							table.setValueAt(clientes_row.get(i).getEmail(), i, 7);
							table.setValueAt(clientes_row.get(i).getCocheria(), i, 8);
//							modelo.addRow(O);
						}
						}
				    	
				    }else{
				    	JOptionPane.showMessageDialog(
								   null,
								   "No hay criterio de busquedas");
				    }
				    System.out.println("encontro "+clientes_row.get(0).getNombres());
				}
			});
			contentPanel.add(btnNewButton);
		}
		
		
		
		
		txt_dni = new JTextField();
		txt_dni.setBounds(87, 84, 190, 20);
		txt_dni.setColumns(10);
		contentPanel.add(txt_dni);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setBounds(10, 87, 46, 14);
		contentPanel.add(lblDni);
		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						row = table.getSelectedRow();
						if (row != -1){
						result.setApellidos(clientes_row.get(row).getApellidos());
						result.setNombres(clientes_row.get(row).getNombres());
						result.setDni(clientes_row.get(row).getDni());
						result.setDomicilio(clientes_row.get(row).getDomicilio());
						result.setNombre_familiar(clientes_row.get(row).getNombre_familiar());
						result.setEmail(clientes_row.get(row).getEmail());
						result.setTelefono(clientes_row.get(row).getTelefono());
						father.setClient(result);
						
						setVisible(false);
						dispose();
						}else{
							JOptionPane.showMessageDialog(
									   null,
									   "No ha seleccionado un cliente");
						}
						
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
		
		public Clientes cargarClientes(String nombre, String apellido, String dni,String tel){
			Clientes clientes = new Clientes();
			clientes.setApellidos(apellido);
			clientes.setNombres(nombre);
			clientes.setDni(dni);
			clientes.setTelefono(tel);
			return clientes;
		}
		
		public void showCliente(){
			setVisible(true);
//			return result;
		}
		
		public Clientes getCliente(){
			
			System.out.println("return"+result.getApellidos());
			return result;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			row = table.getSelectedRow();
			
			result.setApellidos(clientes_row.get(row).getApellidos());
			result.setNombres(clientes_row.get(row).getNombres());
			result.setDni(clientes_row.get(row).getDni());
			result.setDomicilio(clientes_row.get(row).getDomicilio());
			result.setNombre_familiar(clientes_row.get(row).getNombre_familiar());
			result.setEmail(clientes_row.get(row).getEmail());
			result.setTelefono(clientes_row.get(row).getTelefono());
			
			
			father.setClient(result);
		}
		
		private Clientes cargar_cliente_buscar() {
			
			Clientes cli = new Clientes();
			cli.setApellidos(txt_apellido.getText());
			cli.setNombres(txt_nombres.getText());
			cli.setDni(txt_dni.getText());
			cli.setTelefono("");
			cli.setDireccion_familiar("");
			cli.setDomicilio("");
			cli.setCocheria("");
			cli.setTelefono("");
			
			
			return cli;
			
		}
}
