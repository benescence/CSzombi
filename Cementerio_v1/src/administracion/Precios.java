package administracion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Precios extends JInternalFrame {
	private JTextField txt_codprecio;
	private JTextField txt_desc;
	private JTextField txt_precio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Precios frame = new Precios();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Precios() {
		setBounds(100, 100, 538, 367);
		getContentPane().setLayout(null);
		
		JLabel lbl_desc = new JLabel("Descripcion");
		txt_desc = new JTextField();
		JLabel lblCodPrecio = new JLabel("Codigo Precio");
		txt_codprecio = new JTextField();
		JLabel lbl_precio = new JLabel("Precio");
		txt_precio = new JTextField();
		
		txt_codprecio.setBounds(148, 101, 154, 20);
		getContentPane().add(txt_codprecio);
		txt_codprecio.setColumns(10);
		
		lbl_desc.setBounds(47, 132, 91, 14);
		getContentPane().add(lbl_desc);
		
		txt_desc.setColumns(10);
		txt_desc.setBounds(148, 129, 154, 20);
		getContentPane().add(txt_desc);
		
		JButton btn_guardar = new JButton("");
		btn_guardar.setBounds(166, 204, 89, 23);
		getContentPane().add(btn_guardar);
	
		
		JButton btn_alta = new JButton("Nuevo Precio");
		btn_alta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txt_desc.setVisible(true);
				txt_desc.setEnabled(true);
				txt_precio.setVisible(true);
				txt_precio.setEnabled(true);
				txt_codprecio.setVisible(true);
				txt_codprecio.setEnabled(true);
				lbl_desc.setVisible(true);
				lblCodPrecio.setVisible(true);
				btn_guardar.setText("Guardar");
				btn_guardar.setVisible(true);
			}
		});
		btn_alta.setBounds(32, 23, 118, 23);
		getContentPane().add(btn_alta);
		
		
		lblCodPrecio.setBounds(47, 104, 91, 14);
		lblCodPrecio.setVisible(false);
		getContentPane().add(lblCodPrecio);
		
		JButton btnBuscarPrecio = new JButton("Buscar Precio");
		btnBuscarPrecio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_desc.setVisible(true);
				txt_desc.setEnabled(false);
				txt_codprecio.setVisible(true);
				txt_codprecio.setEnabled(false);
				txt_precio.setVisible(true);
				txt_precio.setEnabled(false);
				lbl_desc.setVisible(true);
				lblCodPrecio.setVisible(true);
				
				btn_guardar.setVisible(false);
				
			}
		});
		btnBuscarPrecio.setBounds(160, 23, 118, 23);
		getContentPane().add(btnBuscarPrecio);
		
		JButton btnModificarPrecio = new JButton("Modificar  Precio");
		btnModificarPrecio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_desc.setVisible(true);
				txt_desc.setEnabled(true);
				txt_codprecio.setVisible(true);
				txt_codprecio.setEnabled(true);
				txt_precio.setVisible(true);
				txt_precio.setEnabled(true);
				lbl_desc.setVisible(true);
				lblCodPrecio.setVisible(true);
				btn_guardar.setText("Actualizar");
				btn_guardar.setVisible(false);
				
			}
		});
		btnModificarPrecio.setBounds(292, 23, 118, 23);
		getContentPane().add(btnModificarPrecio);
		
		
		lbl_precio.setBounds(47, 160, 91, 14);
		getContentPane().add(lbl_precio);
	
		txt_precio.setColumns(10);
		txt_precio.setBounds(148, 157, 154, 20);
		getContentPane().add(txt_precio);
		
		
		
		

	}
}
