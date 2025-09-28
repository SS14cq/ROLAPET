package udistrital.avanzada.rolapet.vista;

import javax.swing.*;

/**
 * Class FormularioRegistroProveedor.
 */
/**
 * Class FormularioRegistroProveedor.
 */
public class FormularioRegistroProveedor extends JFrame {

	protected JTextField txtNombre;
	protected JTextField txtApellido;
	protected JTextField txtCedula;
	protected JTextField txtCorreo;
	protected JTextField txtCelular;
	protected JPasswordField txtContrasena;
	protected JButton btnRegistrar;
	protected JButton btnCancelar;

	public FormularioRegistroProveedor() {
		// Inicialización de componentes
		txtNombre = new JTextField(20);
		txtApellido = new JTextField(20);
		txtCedula = new JTextField(20);
		txtCorreo = new JTextField(20);
		txtCelular = new JTextField(20);
		txtContrasena = new JPasswordField(20);

		btnRegistrar = new JButton("Registrar");
		btnCancelar = new JButton("Cancelar");

		// Diseño simple con BoxLayout vertical
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		add(new JLabel("Nombre"));
		add(txtNombre);
		add(new JLabel("Apellido"));
		add(txtApellido);
		add(new JLabel("Cédula"));
		add(txtCedula);
		add(new JLabel("Correo (será su usuario)"));
		add(txtCorreo);
		add(new JLabel("Celular"));
		add(txtCelular);
		add(new JLabel("Contraseña"));
		add(txtContrasena);
		add(btnRegistrar);
		add(btnCancelar);

		pack();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

/**
 * getNombre method.
 * @return result
 */
/**
 * getNombre method.
 * @return result
 */
/**
 * getNombre method.
 * @return result
 */
	public String getNombre() {
		return txtNombre.getText().trim();
	}

/**
 * getApellido method.
 * @return result
 */
/**
 * getApellido method.
 * @return result
 */
/**
 * getApellido method.
 * @return result
 */
	public String getApellido() {
		return txtApellido.getText().trim();
	}

/**
 * getCedula method.
 * @return result
 */
/**
 * getCedula method.
 * @return result
 */
/**
 * getCedula method.
 * @return result
 */
	public String getCedula() {
		return txtCedula.getText().trim();
	}

/**
 * getCorreo method.
 * @return result
 */
/**
 * getCorreo method.
 * @return result
 */
/**
 * getCorreo method.
 * @return result
 */
	public String getCorreo() {
		return txtCorreo.getText().trim();
	}

/**
 * getCelular method.
 * @return result
 */
/**
 * getCelular method.
 * @return result
 */
/**
 * getCelular method.
 * @return result
 */
	public String getCelular() {
		return txtCelular.getText().trim();
	}

/**
 * getContrasena method.
 * @return result
 */
/**
 * getContrasena method.
 * @return result
 */
/**
 * getContrasena method.
 * @return result
 */
	public String getContrasena() {
		return new String(txtContrasena.getPassword());
	}

/**
 * getBtnRegistrar method.
 * @return result
 */
/**
 * getBtnRegistrar method.
 * @return result
 */
/**
 * getBtnRegistrar method.
 * @return result
 */
	public JButton getBtnRegistrar() {
		return btnRegistrar;
	}

/**
 * getBtnCancelar method.
 * @return result
 */
/**
 * getBtnCancelar method.
 * @return result
 */
/**
 * getBtnCancelar method.
 * @return result
 */
	public JButton getBtnCancelar() {
		return btnCancelar;
	}

/**
 * setControlador method.
 * @param controlador parameter
 * @return result
 */
/**
 * setControlador method.
 * @param controlador parameter
 */
/**
 * setControlador method.
 * @param controlador parameter
 */
	public void setControlador(java.awt.event.ActionListener controlador) {
		btnRegistrar.addActionListener(controlador);
		btnCancelar.addActionListener(controlador);
	}
}
