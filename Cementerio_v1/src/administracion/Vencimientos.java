package administracion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;


public class Vencimientos extends JInternalFrame {

	private JTextField txt_dato1;
	private JTextField txt_dato2;
	private JTextField txt_dato3;
	private JTextField txt_dato4;
	private JTextField txt_dato5;
	private JTextField txt_dato6;
	private JTextField textField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vencimientos frame = new Vencimientos();
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
	public Vencimientos() {
		
		
		setBorder(null);
		setBackground(SystemColor.inactiveCaptionBorder);
		setBounds(0, 0, 536, 448);
		getContentPane().setLayout(null);
		
		JLabel lbl_dato1 = new JLabel("");
		lbl_dato1.setBounds(132, 119, 72, 14);
		lbl_dato1.setVisible(false);
		getContentPane().add(lbl_dato1);

		JLabel lbl_dato2 = new JLabel("");
		lbl_dato2.setBounds(224, 119, 75, 14);
		lbl_dato2.setVisible(false);
		getContentPane().add(lbl_dato2);

		JLabel lbl_dato3 = new JLabel("");

		lbl_dato3.setBounds(132, 171, 72, 14);
		lbl_dato3.setVisible(false);
		getContentPane().add(lbl_dato3);
		
		JLabel lbl_dato4 = new JLabel("");
		lbl_dato4.setBounds(222, 171, 96, 14);
		lbl_dato4.setVisible(false);
		getContentPane().add(lbl_dato4);

		JLabel lbl_dato5 = new JLabel("");
		lbl_dato5.setBounds(135, 220, 69, 14);
		lbl_dato5.setVisible(false);
		getContentPane().add(lbl_dato5);
		
		JLabel lbl_dato6 = new JLabel("");
		lbl_dato6.setBounds(224, 220, 69, 14);
		lbl_dato6.setVisible(false);
		getContentPane().add(lbl_dato6);
		
		JButton btn_guardar = new JButton("");
		btn_guardar.setBounds(132, 337, 112, 23);
		btn_guardar.setVisible(false);
		getContentPane().add(btn_guardar);
	
		txt_dato1 = new JTextField();
		txt_dato1.setBounds(132, 140, 76, 20);
		txt_dato1.setVisible(false);
		txt_dato1.setColumns(10);
		getContentPane().add(txt_dato1);
		txt_dato2 = new JTextField();
		txt_dato2.setBounds(224, 140, 76, 20);
		txt_dato2.setVisible(false);
		txt_dato2.setColumns(10);
		getContentPane().add(txt_dato2);
		
		txt_dato3 = new JTextField();
		txt_dato3.setBounds(132, 189, 76, 20);
		txt_dato3.setVisible(false);
		txt_dato3.setColumns(10);
		getContentPane().add(txt_dato3);
		
		txt_dato4 = new JTextField();
		txt_dato4.setBounds(223, 189, 76, 20);
		txt_dato4.setVisible(false);
		txt_dato4.setColumns(10);
		getContentPane().add(txt_dato4);
		
		txt_dato5 = new JTextField();
		txt_dato5.setBounds(132, 238, 76, 20);
		txt_dato5.setVisible(false);
		txt_dato5.setColumns(10);
		getContentPane().add(txt_dato5);
		
		txt_dato6 = new JTextField();
		txt_dato6.setBounds(223, 238, 76, 20);
		txt_dato6.setVisible(false);
		txt_dato6.setColumns(10);
		getContentPane().add(txt_dato6);
		
		
		JCheckBox chckbxBisBoveda = new JCheckBox("Bis");
		chckbxBisBoveda.setBackground(SystemColor.inactiveCaptionBorder);
		chckbxBisBoveda.setBounds(318, 188, 52, 23);
		chckbxBisBoveda.setVisible(false);
		getContentPane().add(chckbxBisBoveda);
		
		JComboBox<String> cmb_item_sector = new JComboBox<String>();
		JComboBox<String> cmb_sector = new JComboBox<String>();
		
		
		cmb_sector.setVisible(true);
		cmb_sector.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent arg0) {

				txt_dato1.setVisible(false);
				txt_dato2.setVisible(false);
				txt_dato3.setVisible(false);
				txt_dato4.setVisible(false);
				txt_dato5.setVisible(false);
				txt_dato6.setVisible(false);
				lbl_dato1.setVisible(false);
				lbl_dato2.setVisible(false);
				lbl_dato3.setVisible(false);
				lbl_dato4.setVisible(false);
				lbl_dato5.setVisible(false);
				lbl_dato6.setVisible(false);
				chckbxBisBoveda.setVisible(false);

			}

		});
	
		
		cmb_sector.setVisible(true);
		cmb_sector.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				cmb_item_sector.removeAllItems();

				switch (cmb_sector.getSelectedIndex()) {
				case 0:
					cmb_item_sector.insertItemAt("Sepultura", 0);
					cmb_item_sector.insertItemAt("Indigentes", 1);
					cmb_item_sector.setSelectedIndex(0);
					break;
				case 1:
					cmb_item_sector.insertItemAt("Palmeras A", 0);
					cmb_item_sector.insertItemAt("Palmeras C", 1);
					cmb_item_sector.insertItemAt("Palmeras RO", 2);
					cmb_item_sector.insertItemAt("Palmeras S", 3);
					cmb_item_sector.setSelectedIndex(0);

					break;

				case 2:
					cmb_item_sector.insertItemAt("Nichos", 0);
					cmb_item_sector.setSelectedIndex(0);
					break;

				case 3:
					cmb_item_sector.insertItemAt("Cenizario", 0);
					cmb_item_sector.setSelectedIndex(0);
					break;
				case 4:
					cmb_item_sector.insertItemAt("Bóvedas", 0);
					cmb_item_sector.setSelectedIndex(0);
					break;

				}

			}

		});

		cmb_sector.setBounds(126, 45, 176, 20);
		cmb_sector.insertItemAt("Sepulturas", 0);
		cmb_sector.insertItemAt("Palmeras", 1);
		cmb_sector.insertItemAt("Nichera", 2);
		cmb_sector.insertItemAt("Cenizario", 3);
		cmb_sector.insertItemAt("Boveda", 4);

		getContentPane().add(cmb_sector);
		
		
		cmb_item_sector.setVisible(true);
		cmb_item_sector.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
//				cmb_item_sector.removeAll();
				switch (cmb_sector.getSelectedIndex()) {

				case 0:
					txt_dato1.setVisible(true);
					txt_dato2.setVisible(true);
					txt_dato3.setVisible(true);
					
					lbl_dato1.setVisible(true);
					lbl_dato2.setVisible(true);
					lbl_dato3.setVisible(true);


					if (cmb_item_sector.getSelectedIndex() == 1) {

						lbl_dato4.setVisible(true);
						txt_dato4.setVisible(true);
						lbl_dato1.setText("Seccion");
						lbl_dato2.setText("Masizo");
						lbl_dato3.setText("Sepultura");
						lbl_dato4.setText("Lote");
						System.out.println("sepultura C4"+cmb_item_sector.getSelectedIndex());

					} else {
						System.out.println("sepultura"+cmb_item_sector.getSelectedIndex());
						lbl_dato4.setVisible(true);
						lbl_dato5.setVisible(true);
						txt_dato4.setVisible(true);
						txt_dato5.setVisible(true);
						lbl_dato1.setText("Seccion");
						lbl_dato2.setText("Macizo");
						chckbxBisBoveda.setVisible(true);
						chckbxBisBoveda.setBounds(654, 255, 52, 23);
						
						lbl_dato3.setText("Unidad");
						lbl_dato4.setText("N° de Sepultura");
						lbl_dato5.setText("Bis");

					}

					break;

				case 1:
					if ( cmb_item_sector.getSelectedIndex() == 3 ){
						txt_dato1.setVisible(true);
						lbl_dato1.setVisible(true);
						lbl_dato1.setText("Sepulturas");
						txt_dato2.setVisible(false);
						lbl_dato2.setVisible(false);
					}else{
						txt_dato1.setVisible(true);
						txt_dato2.setVisible(true);
						lbl_dato1.setVisible(true);
						lbl_dato2.setVisible(true);
						lbl_dato1.setText("Nicho");
						lbl_dato2.setText("Fila");
					}
					
					break;

				case 2:

					txt_dato1.setVisible(true);
					txt_dato2.setVisible(true);
					txt_dato3.setVisible(true);
					txt_dato4.setVisible(true);
					txt_dato5.setVisible(true);
					txt_dato6.setVisible(true);
					lbl_dato1.setVisible(true);
					lbl_dato2.setVisible(true);
					lbl_dato3.setVisible(true);
					lbl_dato4.setVisible(true);
					lbl_dato5.setVisible(true);
					lbl_dato6.setVisible(true);
					lbl_dato1.setText("Sirc.");
					lbl_dato2.setText("Seccion");
					lbl_dato3.setText("Masizo");
					lbl_dato4.setText("Parcela");
					lbl_dato5.setText("Fila");
					lbl_dato6.setText("Unidad");
					
					break;

				case 3:

					txt_dato1.setVisible(true);
					txt_dato2.setVisible(true);
					lbl_dato1.setVisible(true);
					lbl_dato2.setVisible(true);
					lbl_dato1.setText("Mueble");
					lbl_dato2.setText("Nicho");

					break;

				case 4:

//					txt_dato1.setVisible(true);
//					lbl_dato1.setVisible(true);
//					lbl_dato1.setText("Unidad");
					txt_dato1.setVisible(true);
					txt_dato2.setVisible(true);
					txt_dato3.setVisible(true);
					txt_dato4.setVisible(true);
					txt_dato5.setVisible(true);

					lbl_dato1.setVisible(true);
					lbl_dato2.setVisible(true);
					lbl_dato3.setVisible(true);
					lbl_dato4.setVisible(true);
					lbl_dato5.setVisible(true);

					lbl_dato1.setText("Sirc.");
					lbl_dato2.setText("Seccion");
					lbl_dato3.setText("Masizo");
					lbl_dato4.setText("Parcela");
					lbl_dato5.setText("Unidad");
					chckbxBisBoveda.setVisible(true);
					chckbxBisBoveda.setBounds(654, 305, 52, 23);
					break;

				}

			}

		});
		cmb_item_sector.setBounds(126, 88, 176, 20);
		getContentPane().add(cmb_item_sector);
		
		
		
		
		JLabel lblUbicacion = new JLabel("Ubicacion");
		lblUbicacion.setBounds(48, 45, 46, 14);
		getContentPane().add(lblUbicacion);
		
		JLabel lblLugar = new JLabel("Lugar");
		lblLugar.setBounds(48, 91, 46, 14);
		getContentPane().add(lblLugar);
		
		JLabel lblvencimiento = new JLabel("Vencimiento");
		lblvencimiento.setBounds(48, 304, 86, 14);
		getContentPane().add(lblvencimiento);
		
		textField = new JTextField();
		textField.setBounds(132, 301, 112, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		
		
		
		
		

	}
}
