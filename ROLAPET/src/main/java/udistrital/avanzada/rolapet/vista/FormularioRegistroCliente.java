package udistrital.avanzada.rolapet.vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Clase FormularioRegistroCliente que representa la ventana para registrar un nuevo cliente.
 * Contiene campos para ingresar datos personales, credenciales y botones para registrar o regresar.
 * Incluye una lista gráfica con los requisitos para la contraseña.
 * 
 * @author Sarita
 * @version 1.3
 */
public class FormularioRegistroCliente extends JFrame {
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtCedula;
    private JTextField txtCorreo;
    private JTextField txtCelular;
    private JTextField txtNombreUsuario;
    private JPasswordField txtContrasena;
    private JButton btnRegistrar;
    private JButton btnAtras;

    /**
     * Constructor que inicializa la ventana con sus componentes y diseño.
     * Configura etiquetas, campos de texto, botón registrar y botón atrás,
     * así como los requisitos visibles para la contraseña.
     */
    public FormularioRegistroCliente() {
        super("Registro de Cliente");

        Color fondo = Color.decode("#f5f5dc");
        Color encabezadoColor = Color.decode("#b81b2f");

        Font fuenteCampos = new Font("Segoe UI", Font.PLAIN, 14);
        Font fuenteTitulo = new Font("Segoe UI", Font.BOLD, 24);

        setLayout(new BorderLayout());

        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(fondo);
        headerPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        ImageIcon logo = new ImageIcon(getClass().getResource("/imagenes/rolapet_logo.png"));
        Image img = logo.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        JLabel lblLogo = new JLabel(new ImageIcon(img));

        JLabel lblTitulo = new JLabel("Rolapet - Registro de Cliente", SwingConstants.LEFT);
        lblTitulo.setFont(fuenteTitulo);
        lblTitulo.setForeground(encabezadoColor);

        headerPanel.add(lblLogo, BorderLayout.WEST);
        headerPanel.add(lblTitulo, BorderLayout.CENTER);
        add(headerPanel, BorderLayout.NORTH);

        JPanel panelFormulario = new JPanel(new GridBagLayout());
        panelFormulario.setBackground(fondo);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        txtNombre = new JTextField(20);
        txtApellido = new JTextField(20);
        txtCedula = new JTextField(20);
        txtCorreo = new JTextField(20);
        txtCelular = new JTextField(20);
        txtNombreUsuario = new JTextField(20);
        txtContrasena = new JPasswordField(20);

        String[] etiquetas = {"Nombre:", "Apellido:", "Cédula:", "Correo:", "Celular:", "Nombre de usuario:", "Contraseña:"};
        JComponent[] campos = {txtNombre, txtApellido, txtCedula, txtCorreo, txtCelular, txtNombreUsuario, txtContrasena};

        gbc.gridx = 0;
        gbc.gridy = 0;
        for (int i = 0; i < etiquetas.length; i++) {
            JLabel lbl = new JLabel(etiquetas[i]);
            lbl.setFont(fuenteCampos);
            gbc.gridx = 0;
            gbc.anchor = GridBagConstraints.WEST;
            panelFormulario.add(lbl, gbc);
            gbc.gridx = 1;
            panelFormulario.add(campos[i], gbc);
            gbc.gridy++;
        }

        // Agregar JLabel con los requisitos de contraseña
        String textoRequisitos = "<html><ul>"
                + "<li>Mínimo 8 caracteres</li>"
                + "<li>Al menos una letra mayúscula</li>"
                + "<li>Al menos un número</li>"
                + "<li>Al menos un carácter especial (@, $, !, %, *, ?, &)</li>"
                + "</ul></html>";

        JLabel lblRequisitos = new JLabel(textoRequisitos);
        lblRequisitos.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblRequisitos.setForeground(Color.DARK_GRAY);

        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridy++;
        gbc.insets = new Insets(5, 8, 10, 8);
        panelFormulario.add(lblRequisitos, gbc);

        add(panelFormulario, BorderLayout.CENTER);

        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBackground(encabezadoColor);
        btnRegistrar.setForeground(Color.WHITE);
        btnRegistrar.setFocusPainted(false);
        btnRegistrar.setFont(new Font("Segoe UI", Font.BOLD, 14));

        btnAtras = new JButton("Atrás");
        btnAtras.setBackground(Color.GRAY);
        btnAtras.setForeground(Color.WHITE);
        btnAtras.setFocusPainted(false);
        btnAtras.setFont(new Font("Segoe UI", Font.BOLD, 14));

        JPanel panelBotones = new JPanel();
        panelBotones.setBackground(fondo);
        panelBotones.add(btnRegistrar);
        panelBotones.add(btnAtras);

        add(panelBotones, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    public String getNombre() { return txtNombre.getText().trim(); }
    public String getApellido() { return txtApellido.getText().trim(); }
    public String getCedula() { return txtCedula.getText().trim(); }
    public String getCorreo() { return txtCorreo.getText().trim(); }
    public String getCelular() { return txtCelular.getText().trim(); }
    public String getNombreUsuario() { return txtNombreUsuario.getText().trim(); }
    public String getContrasena() { return new String(txtContrasena.getPassword()); }

    public JButton getBtnRegistrar() { return btnRegistrar; }
    public JButton getBtnAtras() { return btnAtras; }

    /**
     * Limpia todos los campos del formulario dejando los textos vacíos.
     */
    public void limpiarCampos() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtCedula.setText("");
        txtCorreo.setText("");
        txtCelular.setText("");
        txtNombreUsuario.setText("");
        txtContrasena.setText("");
    }

    /**
     * Asigna el mismo ActionListener controlador a los botones Registrar y Atrás.
     * 
     * @param controlador ActionListener que gestionará los eventos de los botones
     */
    public void setControlador(ActionListener controlador) {
        btnRegistrar.addActionListener(controlador);
        btnAtras.addActionListener(controlador);
    }
}
