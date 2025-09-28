package udistrital.avanzada.rolapet.vista;

import javax.swing.*;

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

	public String getNombre() {
		return txtNombre.getText().trim();
	}

	public String getApellido() {
		return txtApellido.getText().trim();
	}

	public String getCedula() {
		return txtCedula.getText().trim();
	}

	public String getCorreo() {
		return txtCorreo.getText().trim();
	}

	public String getCelular() {
		return txtCelular.getText().trim();
	}

	public String getContrasena() {
		return new String(txtContrasena.getPassword());
	}

	public JButton getBtnRegistrar() {
		return btnRegistrar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public void setControlador(java.awt.event.ActionListener controlador) {
		btnRegistrar.addActionListener(controlador);
		btnCancelar.addActionListener(controlador);
	}
}
