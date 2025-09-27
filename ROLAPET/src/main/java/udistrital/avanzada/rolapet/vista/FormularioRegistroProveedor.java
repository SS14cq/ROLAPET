package udistrital.avanzada.rolapet.vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class FormularioRegistroProveedor extends JFrame {

    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtCedula;
    private JTextField txtCorreo;
    private JTextField txtCelular;
    private JPasswordField txtContrasena;
    private JButton btnRegistrar;
    private JButton btnCancelar;

    public FormularioRegistroProveedor() {
        setTitle("Registro de Proveedor");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        Color fondo = Color.decode("#f5f5dc");
        Color encabezadoColor = Color.decode("#b81b2f");

        JLabel lblTitulo = new JLabel("Formulario de Registro", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblTitulo.setForeground(encabezadoColor);

        JPanel panelTitulo = new JPanel(new BorderLayout());
        panelTitulo.setBackground(fondo);
        panelTitulo.add(lblTitulo, BorderLayout.CENTER);
        add(panelTitulo, BorderLayout.NORTH);

        JPanel panelFormulario = new JPanel(new GridLayout(6, 2, 10, 10));
        panelFormulario.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        panelFormulario.setBackground(fondo);

        panelFormulario.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelFormulario.add(txtNombre);

        panelFormulario.add(new JLabel("Apellido:"));
        txtApellido = new JTextField();
        panelFormulario.add(txtApellido);

        panelFormulario.add(new JLabel("Cédula:"));
        txtCedula = new JTextField();
        panelFormulario.add(txtCedula);

        panelFormulario.add(new JLabel("Correo:"));
        txtCorreo = new JTextField();
        panelFormulario.add(txtCorreo);

        panelFormulario.add(new JLabel("Celular:"));
        txtCelular = new JTextField();
        panelFormulario.add(txtCelular);

        panelFormulario.add(new JLabel("Contraseña:"));
        txtContrasena = new JPasswordField();
        panelFormulario.add(txtContrasena);

        add(panelFormulario, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        btnRegistrar = new JButton("Registrar");
        btnCancelar = new JButton("Cancelar");
        panelBotones.add(btnRegistrar);
        panelBotones.add(btnCancelar);

        add(panelBotones, BorderLayout.SOUTH);
    }

    public String getNombre() { return txtNombre.getText().trim(); }
    public String getApellido() { return txtApellido.getText().trim(); }
    public String getCedula() { return txtCedula.getText().trim(); }
    public String getCorreo() { return txtCorreo.getText().trim(); }
    public String getCelular() { return txtCelular.getText().trim(); }
    public String getContrasena() { return new String(txtContrasena.getPassword()).trim(); }

    public JButton getBtnRegistrar() { return btnRegistrar; }
    public JButton getBtnCancelar() { return btnCancelar; }

    public void setControlador(ActionListener controlador) {
        btnRegistrar.addActionListener(controlador);
        btnCancelar.addActionListener(controlador);
    }
}
