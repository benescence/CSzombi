package com.revivir.cementerio.vista.precio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

import com.revivir.cementerio.MainPrincipal;
import com.revivir.cementerio.negocios.Busqueda;
import com.revivir.cementerio.negocios.Validador;
import com.revivir.cementerio.negocios.manager.ServicioManager;
import com.revivir.cementerio.persistencia.entidades.Servicio;
import com.revivir.cementerio.vista.ControladorInterno;
import com.revivir.cementerio.vista.util.Popup;

public class ControladorPrecio implements ActionListener, ControladorInterno{
	private VentanaPrecio ventana;
	private VentanaAMcargo ventanaAM;
	private MainPrincipal invocador;
	
	
	public ControladorPrecio(MainPrincipal invocador) {
		ventana = new VentanaPrecio();
		
		ventana.botonBuscar().addActionListener(this);
		ventana.botonLimpiar().addActionListener(this);
		ventana.botonEliminar().addActionListener(this);
		ventana.botonAgregar().addActionListener(this);
		ventana.botonModificar().addActionListener(this);
		this.invocador = invocador;
		
		//ventana.mostrar();
	}

	public void actionPerformed(ActionEvent e) {
		// BOTON BUSCAR
		if (e.getSource() == ventana.botonBuscar())
			buscar();
	
		// BOTON LIMPIAR CAMPOS
		else if (e.getSource() == ventana.botonLimpiar())
			limpiar();
		else if (e.getSource() == ventana.botonAgregar())
			agregar();
		else if (e.getSource() == ventana.botonModificar())
			modificar();
		else if (e.getSource() == ventana.botonEliminar())
			eliminar();
	}
	
	private void eliminar() {
		// TODO Auto-generated method stub
		
	}

	private void modificar() {
		// TODO Auto-generated method stub.
		
	}

	private void agregar() {
		ventanaAM = new VentanaAMcargo();
		ventanaAM.botonAceptar().addActionListener(e -> aceptarAM());
		ventanaAM.botonCancelar().addActionListener(s -> cancelarAM());

		ventanaAM.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				cancelarAM();
			}
		});
	
		//controlador.getVentana().setEnabled(false);
		invocador.setEnabled(false);
	}

	private void limpiar() {
		ventana.getCodigo().setText("");
		ventana.getDescripcion().setText("");		
	}

	private void buscar() {
		String codigo = (ventana.getCodigo().getText().equals("") ? null : ventana.getCodigo().getText());
		String descripcion = (ventana.getDescripcion().getText().equals("") ? null : ventana.getDescripcion().getText());
		List<Servicio> precios = Busqueda.precios(codigo, descripcion);
		ventana.getTabla().recargar(precios);
		if (precios.size() == 0)
			Popup.mostrar("No se ha encontrado ningun resultado con los criterios ingresados.");
	}

	
	
private void aceptarAM() {
		
		if (validarCampos()) {
			Servicio precio = ventanaAM.getPrecio();
			String Descripcion = ventanaAM.getInDescripcion().getText();
			int codigo = Integer.valueOf(ventanaAM.getInCodigo().getText());
			Double Monto = Double.valueOf(ventanaAM.getInMonto().getText());
			String nombre= ventanaAM.getInNombre().getText();
			int historico= -1;

			// Crear un nuevo alumno
			if (precio == null) {
			
				//ServicioManager.crearServicio(codigo, Descripcion, Monto, nombre, historico);

			// Editar un alumno existente
			} else {
				//precio.setCodigo(codigo);;
				//precio.setDescripcion(Descripcion);;
				//precio.setMonto(Monto);;
				precio.setNombre(nombre);;
			
				ServicioManager.modificar(precio);
			}

			//llenarTabla();
			ventanaAM.dispose();
			ventanaAM = null;
			//controlador.getVentana().setEnabled(true);
			//controlador.getVentana().toFront();
		}
	}

	/*private void llenarTabla() {
		ventanaAM.getMo  getModeloAlumnos().setRowCount(0);
		ventanaAM.getModeloAlumnos().setColumnCount(0);
		ventanaAM.getModeloAlumnos().setColumnIdentifiers(ventanaABM.getNombreColumnas());

		alumnos = AlumnoManager.traerAlumnos();
		for (Alumno alumno : alumnos) {
			Object[] fila = {
					alumno.getApellido(),
					alumno.getNombre(),
					alumno.getDNI(),
					alumno.getEmail(),
					alumno.getTelefono()
					};
			ventanaABM.getModeloAlumnos().addRow(fila);

			// seteo la altura de la celda
			int registro = ventanaABM.getModeloAlumnos().getRowCount() - 1;
			int altura = Formato.calcularAlturaDeCelda(fila);
			ventanaABM.getTablaAlumnos().setRowHeight(registro, altura);
		}
}*/

	private void cancelarAM() {
		int confirm = JOptionPane.showOptionDialog(null, "¿¡Esta seguro de salir sin guardar!?", "Confirmacion",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
		if (confirm == 0) {
			//Concurrencia.desbloquear(ventanaAM.getAlumno());
			ventanaAM.dispose();
			ventanaAM = null;
			//controlador.getVentana().setEnabled(true);
			//controlador.getVentana().toFront();
			invocador.setEnabled(true);
			invocador.toFront();
		}
	}
	
	private boolean validarCampos() {
		
		String codigo = ventanaAM.getInCodigo().getText();
		String descripcion = ventanaAM.getInDescripcion().getText();
		String monto = ventanaAM.getInMonto().getText();
		


		boolean isOk = true;
		String mensaje = "Se encontraron los siguientes errores:\n";

		if (descripcion == null) {
			isOk = false;
			mensaje += "    -Por favor ingrese el APELLIDO.\n";

		}

		if (codigo == null) {
			isOk = false;
			mensaje += "    -Por favor ingrese el CODIGO.\n";

		} else if (!Validador.validarCodigo(codigo)) {
			isOk = false;
			mensaje += "    -El Codigo solo puede consistir de numeros.\n";
		} 
		if (monto == null) {
			isOk = false;
			mensaje += "    -Por favor ingrese el MONTO.\n";
			
		}else if (!Validador.validarCodigo(monto)) {
			isOk = false;
			mensaje += "    -El Monto solo puede consistir de numeros.\n";
		} 
		if (isOk == false)
			JOptionPane.showMessageDialog(null, mensaje);

		return isOk;
		}
	
	@Override
	public boolean finalizar() {
		ventana.dispose();
		ventana = null;
		return true;
	}

	@Override
	public JInternalFrame getVentana() {
		return ventana;
	}
	

}
