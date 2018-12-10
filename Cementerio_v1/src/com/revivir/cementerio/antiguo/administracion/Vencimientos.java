package administracion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;

import logica.LogicaVencimientos;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;


@SuppressWarnings("serial")
public class Vencimientos extends JInternalFrame {
	private JDateChooser date;
	private int id;
	
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
		
		JButton btn_guardar = new JButton("Guardar");
		btn_guardar.setBounds(187, 232, 112, 23);
		btn_guardar.setVisible(true);
		getContentPane().add(btn_guardar);
		
		JComboBox<String> cmb_item_sector = new JComboBox<String>();
		JComboBox<String> cmb_sector = new JComboBox<String>();
		
		date= new JDateChooser();
		date.setBounds(203,171, 96, 23);
		getContentPane().add(date);
		
		 id=0;
		
		
		cmb_sector.setVisible(true);
		cmb_sector.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent arg0) {
		

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

				switch (cmb_sector.getSelectedIndex()) {

				case 0:
				
			

					if (cmb_item_sector.getSelectedIndex() == 1) {

						id=8;

					} else {
						
						 id=7;
					}

					break;

				case 1:
					if ( cmb_item_sector.getSelectedIndex() == 3 ){
					
						 id=5;
						
					}else if ( cmb_item_sector.getSelectedIndex() == 2 ){
					
						id =4;
					}
					else if ( cmb_item_sector.getSelectedIndex() == 1 ){
						
						id =3;
					}
					else {
						
						id =2;
					}
					break;

				case 2:

			id= 1;
					
					
					break;

				case 3:

					id=9;
					
					break;

				case 4:

					id = 6;
					
					
				
					break;

				}

			}

		});
		cmb_item_sector.setBounds(126, 88, 176, 20);
		getContentPane().add(cmb_item_sector);
		
		
		btn_guardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogicaVencimientos fecha = new LogicaVencimientos();
				fecha.setId_ubicacion(id);
				fecha.setFecha( date.getDate());
				fecha.guardarFecha();
			}		
		});
		
		
		
		JLabel lblUbicacion = new JLabel("Ubicacion");
		lblUbicacion.setBounds(48, 45, 46, 14);
		getContentPane().add(lblUbicacion);
		
		JLabel lblLugar = new JLabel("Lugar");
		lblLugar.setBounds(48, 91, 46, 14);
		getContentPane().add(lblLugar);
		
		JLabel lblvencimiento = new JLabel("Vencimiento");
		lblvencimiento.setBounds(107, 171, 86, 14);
		getContentPane().add(lblvencimiento);
		
		
		
		
		
		

	}
	}
	

