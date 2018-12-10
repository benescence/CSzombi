package com.revivir.cementerio.antiguo.pantallas;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.revivir.cementerio.MainPrincipal;
import com.revivir.cementerio.antiguo.logica.Users;

import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Login extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txt_usuario;
	private JPasswordField txt_password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Login dialog = new Login();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			
			/*try {
				 for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				        if ("Motif".equals(info.getName())) {
				            UIManager.setLookAndFeel(info.getClassName());
				            break;
				        }
				    }
				} catch(Exception e) {
				  System.out.println("Error setting native LAF: " + e);
				}*/
			try{
				  
				  dialog.setDefaultLookAndFeelDecorated(true);
				  JDialog.setDefaultLookAndFeelDecorated(true);
				  //UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
				  //UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
				  UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				  //UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
				}
				catch (Exception e)
				 {
				  e.printStackTrace();
				 }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Login() {
		setBounds(100, 100, 290, 196);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		txt_usuario = new JTextField();
		txt_usuario.setBounds(97, 33, 133, 20);
		contentPanel.add(txt_usuario);
		txt_usuario.setColumns(10);
		
		txt_password = new JPasswordField();
		txt_password.setBounds(97, 64, 133, 20);
		contentPanel.add(txt_password);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Arial", Font.PLAIN, 12));
		lblUsuario.setBounds(10, 36, 46, 14);
		contentPanel.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Arial", Font.PLAIN, 12));
		lblContrasea.setBounds(10, 67, 71, 14);
		contentPanel.add(lblContrasea);
		
		JLabel lbl_error = new JLabel("");
		lbl_error.setBounds(10, 95, 198, 21);
		contentPanel.add(lbl_error);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Users login = new Users();
						login.setId(txt_usuario.getText());
						login.setpwd(txt_password.getText());
						
						if (!login.ValidateUser(login)){
							lbl_error.setText("Error en usuario o contraseña");
							txt_password.setText("");
						}else{
							lbl_error.setText("Bienvenido");
							MainPrincipal main = new MainPrincipal();
							main.setVisible(true);
							
						}
						
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
