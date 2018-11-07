package src.administracion;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import logica.LogicaPrecios;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

@SuppressWarnings("serial")
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
		
	
		
		setBorder(null);
		setBackground(SystemColor.inactiveCaptionBorder);
		setBounds(0, 0, 538, 367);
		getContentPane().setLayout(null);
		
		JLabel lbl_desc = new JLabel("Descripcion");
		lbl_desc.setVisible(false);
		txt_desc = new JTextField();
		txt_desc.setVisible(false);
		JLabel lblCodPrecio = new JLabel("Codigo Precio");
		lblCodPrecio.setVisible(false);
		txt_codprecio = new JTextField();
		txt_codprecio.setVisible(false);
		JLabel lbl_precio = new JLabel("Precio");
		lbl_precio.setVisible(false);
		txt_precio = new JTextField();
		txt_precio.setVisible(false);
		
		txt_codprecio.setBounds(148, 101, 154, 20);
		getContentPane().add(txt_codprecio);
		txt_codprecio.setColumns(10);
		
		lbl_desc.setBounds(47, 132, 91, 14);
		getContentPane().add(lbl_desc);
		
		txt_desc.setColumns(10);
		txt_desc.setBounds(148, 129, 154, 20);
		getContentPane().add(txt_desc);
		
		JButton btn_guardar = new JButton("");
		//btn_guardar.setAction(action);
		btn_guardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btn_guardar.getText().equals("Actualizar")) {
					int codigo = Integer.parseInt(txt_codprecio.getText());
					float precioDouble = Float.parseFloat(txt_precio.getText());
					LogicaPrecios precio = new LogicaPrecios();
					precio.setCodigo(codigo);
					precio.setPrecio(precioDouble);
					precio.setDescripcion(txt_desc.getText());
					precio.ModificarCodigo();
			
				}
				else if (btn_guardar.getText().equals("Buscar")) {
					
			
					
					LogicaPrecios precios= new LogicaPrecios();
				    precios = cargar_precio();
				    
				    if (!txt_codprecio.getText().equals(null) || !txt_desc.getText().equals(null)){
					ArrayList<LogicaPrecios> precios_row =  new ArrayList<LogicaPrecios>();
					precios_row = precios.BuscarCodigo();
					
					if (precios_row.size()>0){					

						getContentPane().removeAll();
						getContentPane().repaint();

						Resultado_precios rp = new Resultado_precios(precios_row);
						rp.setVisible(true);
						getContentPane().add(rp);
						getContentPane().repaint();
						
						
						
					
					}else{
						JOptionPane.showMessageDialog(
								   null,
								   "No se han encontrado datos");
					}
					
				    }

				    
				    
				}
		
					
				else{
				int codigo = Integer.parseInt(txt_codprecio.getText());
				float precioDouble = Float.parseFloat(txt_precio.getText());
				LogicaPrecios precio = new LogicaPrecios();
				precio.setCodigo(codigo);
				precio.setPrecio(precioDouble);
				precio.setDescripcion(txt_desc.getText());
				precio.crearCodigo();
			}}
		});
		
		btn_guardar.setBounds(166, 204, 112, 23);
		btn_guardar.setVisible(false);
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
				lbl_precio.setVisible(true);
				lblCodPrecio.setVisible(true);
				btn_guardar.setText("Guardar");
				btn_guardar.setVisible(true);
				
			
				
			}
		});
		btn_alta.setBounds(32, 23, 118, 23);
		getContentPane().add(btn_alta);
		
		
		lblCodPrecio.setBounds(47, 104, 91, 14);
		
		getContentPane().add(lblCodPrecio);
		
		JButton btnBuscarPrecio = new JButton("Buscar Precio");
		btnBuscarPrecio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_desc.setVisible(true);
				txt_desc.setEnabled(true);
				txt_codprecio.setVisible(true);
				txt_codprecio.setEnabled(true);
				txt_precio.setVisible(true);
				txt_precio.setEnabled(false);
				lbl_desc.setVisible(true);
				lbl_precio.setVisible(true);
				lblCodPrecio.setVisible(true);
				
				btn_guardar.setVisible(true);
				btn_guardar.setText("Buscar");
				
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
				lbl_precio.setVisible(true);
				lblCodPrecio.setVisible(true);
				btn_guardar.setText("Actualizar");
				btn_guardar.setVisible(true);
				
				
				
			}
		});
		btnModificarPrecio.setBounds(292, 23, 146, 23);
		getContentPane().add(btnModificarPrecio);
		
		
		lbl_precio.setBounds(47, 160, 91, 14);
		getContentPane().add(lbl_precio);
	
		txt_precio.setColumns(10);
		txt_precio.setBounds(148, 157, 154, 20);
		getContentPane().add(txt_precio);
		
		
		
		

	}

	private LogicaPrecios cargar_precio() {
		
		
		if(!txt_codprecio.getText().equals("")) {
		
		LogicaPrecios cli = new LogicaPrecios();
		int codigo = Integer.parseInt(txt_codprecio.getText());
		cli.setCodigo(codigo);
		cli.setDescripcion(txt_desc.getText());
		
		return cli;
	}
	else {
		LogicaPrecios cli = new LogicaPrecios();
		cli.setDescripcion(txt_desc.getText());
		return cli;
	}
}
}