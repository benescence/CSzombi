package administracion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.util.ArrayList;
import logica.LogicaPrecios;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

@SuppressWarnings("serial")
public class Resultado_precios extends JInternalFrame {
	private JTextField txt_codigo;
	private JTextField txt_precio;
	private JTextField txt_descripcion;

	
	private LogicaPrecios row_precios;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btn_info;
	private String ubicacion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ArrayList<LogicaPrecios> codigos_list = new ArrayList<LogicaPrecios>();
					Resultado_precios frame = new Resultado_precios(codigos_list);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param clientes_row 
	 */
	public Resultado_precios(ArrayList<LogicaPrecios> precios_row) {
		
		setMaximizable(true);
		
		setBackground(SystemColor.inactiveCaptionBorder);
		setBorder(null);
		setBounds(0, 0, 715, 418);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Descripcion");
		lblNewLabel.setBounds(36, 24, 132, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblContrasea = new JLabel("Precio");
		lblContrasea.setBounds(36, 82, 132, 14);
		getContentPane().add(lblContrasea);
		
		txt_codigo = new JTextField();
		txt_codigo.setBounds(178, 49, 203, 20);
		txt_codigo.setEditable(false);
		txt_codigo.setColumns(10);
		getContentPane().add(txt_codigo);
		
		
			txt_precio = new JTextField();
		txt_precio.setBounds(178, 79, 203, 20);
		txt_precio.setEditable(false);
		txt_precio.setColumns(10);
		getContentPane().add(txt_precio);
		
		
		txt_descripcion = new JTextField();
		txt_descripcion.setBounds(178, 21, 203, 20);
		txt_descripcion.setEditable(false);
		txt_descripcion.setColumns(10);
		getContentPane().add(txt_descripcion);
		
		
		
		
	
		setTitle("Resultado");
		
		
		
		
		JLabel lblNombre = new JLabel("Codigo");
		lblNombre.setBounds(36, 52, 132, 14);
		getContentPane().add(lblNombre);
		
		

		
		        
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(186, 346, 103, 23);
		btnCerrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

                dispose();
				Precios pantalla = new Precios();
				pantalla.setVisible(true);


				
			}
		});
		getContentPane().add(btnCerrar);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int row = table.getSelectedRow();
				
		
				
				String cadena = Integer.toString(precios_row.get(row).getCodigo());
				String cadena2 = Float.toString(precios_row.get(row).getPrecio());
				
				txt_descripcion.setText(precios_row.get(row).getDescripcion());
				txt_codigo.setText(cadena);
				txt_precio.setText(cadena2);
		
				
			}
		});
		table.setBounds(24, 294, 750, 155);
		
		
				 DefaultTableModel modelo = new DefaultTableModel();
				 modelo =  (new DefaultTableModel(
						 null, new String [] {
								 "Descripcion", "codigo",
								 "precio"}){
								 @SuppressWarnings("rawtypes")
								Class[] types = new Class [] {
								 java.lang.String.class,
								 java.lang.String.class,
								 java.lang.String.class,
								 };
				 			});
				Object O[]= null;
				modelo.addRow(O);
				table.setModel(modelo);
				for (int i=0;i<precios_row.size();i++){
					System.out.println(precios_row);
				precios_row.toString();
				table.setValueAt(precios_row.get(i).getDescripcion(), i, 0);
				table.setValueAt(precios_row.get(i).getCodigo(), i, 1);
				table.setValueAt(precios_row.get(i).getPrecio(), i, 2);
				
			modelo.addRow(O);
			}
				getContentPane().add(table);
				
				scrollPane = new JScrollPane(table);
				scrollPane.setBounds(36, 152, 560, 156);
				getContentPane().add(scrollPane);
				
			
				getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txt_descripcion, txt_codigo, lblNewLabel, lblContrasea, txt_precio, lblNombre, btnCerrar, table}));
	}
	
	
}
