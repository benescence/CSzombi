package clientes;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.Color;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.toedter.calendar.JCalendar;

import logica.Clientes;
import logica.ubicaciones;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.ScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class Consulta_resultado extends JInternalFrame {
	private JTextField txt_name;
	private JTextField txt_dni;
	private JTextField txt_dom;
	private JTextField txt_domfamiliar;
	private JTextField txt_email;
	private JTextField txt_cocheria;
	private JTextField txt_ubicacion;
	private JTextField txt_tel;
	private JTextField txt_apellido;
	private JTextField txt_tipoFall;
	private JTextField txt_fechafallec;
	
	private Clientes row_cliente;
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
					ArrayList<Clientes> clientes_list = new ArrayList<Clientes>();
					Consulta_resultado frame = new Consulta_resultado(clientes_list);
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
	public Consulta_resultado(ArrayList<Clientes> clientes_row) {
		
		setMaximizable(true);
		
		setBackground(SystemColor.inactiveCaptionBorder);
		setBorder(null);
		setBounds(0, 0, 900, 600);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Apellido");
		lblNewLabel.setBounds(36, 24, 132, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblContrasea = new JLabel("DNI");
		lblContrasea.setBounds(36, 82, 132, 14);
		getContentPane().add(lblContrasea);
		
		txt_name = new JTextField();
		txt_name.setBounds(178, 49, 203, 20);
		txt_name.setEditable(false);
		txt_name.setColumns(10);
		getContentPane().add(txt_name);
		
		JLabel lbl_tipofallec = new JLabel("Tipo de fallecimiento");
		lbl_tipofallec.setVisible(false);
		lbl_tipofallec.setBounds(391, 24, 132, 14);
		getContentPane().add(lbl_tipofallec);
		
		JLabel lblDomicilio = new JLabel("Domicilio");
		lblDomicilio.setBounds(36, 110, 132, 14);
		getContentPane().add(lblDomicilio);
		
		txt_dni = new JTextField();
		txt_dni.setBounds(178, 79, 203, 20);
		txt_dni.setEditable(false);
		txt_dni.setColumns(10);
		getContentPane().add(txt_dni);
		
		txt_dom = new JTextField();
		txt_dom.setBounds(178, 107, 203, 20);
		txt_dom.setEditable(false);
		txt_dom.setColumns(10);

		getContentPane().add(txt_dom);
		
		JLabel lblDomicilioFamiliar = new JLabel("Domicilio Familiar");
		lblDomicilioFamiliar.setBounds(36, 138, 132, 14);
		getContentPane().add(lblDomicilioFamiliar);
		
		txt_domfamiliar = new JTextField();
		txt_domfamiliar.setBounds(178, 135, 203, 20);
		txt_domfamiliar.setEditable(false);
		txt_domfamiliar.setColumns(10);
		getContentPane().add(txt_domfamiliar);
		
		JLabel lblEmailFamiliar = new JLabel("E-mail familiar");
		lblEmailFamiliar.setBounds(36, 168, 132, 14);
		getContentPane().add(lblEmailFamiliar);
		
		txt_email = new JTextField();
		txt_email.setBounds(178, 165, 203, 20);
		txt_email.setEditable(false);
		txt_email.setColumns(10);
		getContentPane().add(txt_email);
		
		JLabel lblCocheria = new JLabel("Cocheria");
		lblCocheria.setBounds(391, 82, 76, 14);
		lblCocheria.setVisible(false);
		getContentPane().add(lblCocheria);
		
		txt_cocheria = new JTextField();
		txt_cocheria.setBounds(477, 79, 208, 20);
		txt_cocheria.setEditable(false);
		txt_cocheria.setColumns(10);
		txt_cocheria.setVisible(false);
		getContentPane().add(txt_cocheria);
		
		JLabel lblFechaFallecimiento = new JLabel("Fecha Fallecimiento");
		lblFechaFallecimiento.setBounds(36, 233, 132, 14);
		getContentPane().add(lblFechaFallecimiento);
	
		setTitle("Resultado");
		
		
		JLabel lblIdUbicacion = new JLabel("Ubicacion");
		lblIdUbicacion.setBounds(391, 52, 91, 14);
		lblIdUbicacion.setVisible(false);
		getContentPane().add(lblIdUbicacion);
		
		txt_ubicacion = new JTextField();
		txt_ubicacion.setBounds(477, 49, 273, 20);
		txt_ubicacion.setEditable(false);
		txt_ubicacion.setColumns(10);
		txt_ubicacion.setVisible(false);
//		txt_ubicacion.setText(row_cliente.getUbicacion()); // ver porque no
		getContentPane().add(txt_ubicacion);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(36, 52, 132, 14);
		getContentPane().add(lblNombre);
		
		JLabel lblTelefonoFamilliar = new JLabel("Telefono familliar");
		lblTelefonoFamilliar.setBounds(36, 199, 132, 14);
		getContentPane().add(lblTelefonoFamilliar);
		
		txt_tel = new JTextField();
		txt_tel.setBounds(178, 196, 203, 20);
		txt_tel.setEditable(false);
		txt_tel.setColumns(10);
//		txt_tel.setText(row_cliente.getTelefono());
		getContentPane().add(txt_tel);
		
		txt_apellido = new JTextField();
		txt_apellido.setBounds(178, 21, 203, 20);
		txt_apellido.setEditable(false);
		txt_apellido.setColumns(10);
//		txt_apellido.setText(row_cliente.getApellidos());
		getContentPane().add(txt_apellido);
		
		txt_tipoFall = new JTextField();
		txt_tipoFall.setEditable(false);
		txt_tipoFall.setColumns(10);
		txt_tipoFall.setVisible(false);
		txt_tipoFall.setBounds(524, 21, 156, 20);

		getContentPane().add(txt_tipoFall);
		
		txt_fechafallec = new JTextField();
		txt_fechafallec.setBounds(178, 230, 203, 20);
		txt_fechafallec.setEditable(false);
		txt_fechafallec.setColumns(10);

		getContentPane().add(txt_fechafallec);
		
		        
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(625, 229, 103, 23);
		btnCerrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
//				getContentPane().removeAll();
//                getContentPane().repaint();
                
                dispose();
				Consulta_cliente cc = new Consulta_cliente();
				cc.setVisible(true);
//				getContentPane().add(cc);
//				 getContentPane().repaint();
				
				
			}
		});
		getContentPane().add(btnCerrar);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int row = table.getSelectedRow();
				txt_apellido.setText(clientes_row.get(row).getApellidos());
				txt_name.setText(clientes_row.get(row).getNombres());
				txt_dni.setText(clientes_row.get(row).getDni());
				txt_dom.setText(clientes_row.get(row).getDomicilio());
				txt_domfamiliar.setText(clientes_row.get(row).getDireccion_familiar());
				txt_email.setText(clientes_row.get(row).getEmail());
				txt_cocheria.setText(clientes_row.get(row).getCocheria());
				
				txt_tel.setText(clientes_row.get(row).getTelefono());
				txt_fechafallec.setText(clientes_row.get(row).getFecha_fallec());
				if(clientes_row.get(row).getTipo_fallec()==0){
					txt_tipoFall.setText("Traumatico");	
				}else{
					txt_tipoFall.setText("No Traumatico");
				}
				
				txt_ubicacion.setVisible(false);
				lblIdUbicacion.setVisible(false);
				txt_cocheria.setVisible(false);
				lblCocheria.setVisible(false);
				txt_cocheria.setVisible(false);
				lbl_tipofallec.setVisible(false);
				txt_tipoFall.setVisible(false);
				
			}
		});
		table.setBounds(24, 294, 750, 155);
		
		
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
//				modelo.addRow(O);
			}
				getContentPane().add(table);
				
				scrollPane = new JScrollPane(table);
				scrollPane.setBounds(36, 315, 750, 156);
				getContentPane().add(scrollPane);
				
				btn_info = new JButton("Mas Info");
				btn_info.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						ubicaciones ubi = new ubicaciones();
						if(!txt_dni.getText().equals(null)){
							ubicacion = ubi.buscarUbicacionporDni(txt_dni.getText());
							txt_ubicacion.setVisible(true);
							lblIdUbicacion.setVisible(true);
							txt_ubicacion.setText(ubicacion);
							txt_cocheria.setVisible(true);
							lblCocheria.setVisible(true);
							txt_cocheria.setVisible(true);
							lbl_tipofallec.setVisible(true);
							txt_tipoFall.setVisible(true);
							
						}else{
							ubicacion = ubi.buscarUbicacionporNombre(txt_name.getText().toString(), txt_apellido.getText().toString());
							txt_ubicacion.setVisible(true);
							lblIdUbicacion.setVisible(true);
							txt_ubicacion.setText(ubicacion);
							txt_cocheria.setVisible(true);
							lblCocheria.setVisible(true);
							txt_cocheria.setVisible(true);
							lbl_tipofallec.setVisible(true);
							txt_tipoFall.setVisible(true);
						}
					}
				});
				btn_info.setBounds(477, 146, 89, 23);
				getContentPane().add(btn_info);
				getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txt_apellido, txt_name, lblNewLabel, lbl_tipofallec, lblDomicilio, lblContrasea, txt_dni, txt_dom, lblDomicilioFamiliar, txt_domfamiliar, lblEmailFamiliar, txt_email, lblCocheria, txt_cocheria, lblFechaFallecimiento, lblIdUbicacion, txt_ubicacion, lblNombre, lblTelefonoFamilliar, txt_tel, txt_tipoFall, txt_fechafallec, btnCerrar, table}));
	}
	
	
}
