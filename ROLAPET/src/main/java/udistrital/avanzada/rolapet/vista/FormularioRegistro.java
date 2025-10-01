package udistrital.avanzada.rolapet.vista;
import javax.swing.*;
import java.awt.*;

/**
 * Formulario para registrar un nuevo usuario.
 * Contiene campos para los datos personales y de acceso.
 * 
 * @author sarita
 * @version 1.0, 21-09-2025
/**
 * Class FormularioRegistro.
 */
/**
 * Class FormularioRegistro.
 */
 public class FormularioRegistro extends JFrame {
    private JTextField txtNombre; 
    private JTextField txtApellido; 
    private JTextField txtCedula;
    private JTextField txtCorreo; 
    private JTextField txtCelular;
    private JTextField txtNombreUsuario;
    private JPasswordField txtContrasena;
    private JButton btnRegistrar;

    public FormularioRegistro() {
        super("Registro de Usuario");

        // Gama de colores para el formulario
        Color fondo = Color.decode("#f5f5dc"); // beige claro
        Color encabezadoColor = Color.decode("#b81b2f"); // rojo 
        Color botonColor = encabezadoColor; 

        Font fuenteCampos = new Font("Segoe UI", Font.PLAIN, 14);
        Font fuenteTitulo = new Font("Segoe UI", Font.BOLD, 24);

        setLayout(new BorderLayout());

        // Encabezado
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(fondo);
        headerPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Logo
        ImageIcon logo = new ImageIcon(getClass().getResource("/imagenes/rolapet_logo.png"));
        Image img = logo.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        JLabel lblLogo = new JLabel(new ImageIcon(img));

        // Nombre del encabezado
        JLabel lblTitulo = new JLabel("Rolapet - Registro de Usuario", SwingConstants.LEFT);
        lblTitulo.setFont(fuenteTitulo);
        lblTitulo.setForeground(encabezadoColor);

        headerPanel.add(lblLogo, BorderLayout.WEST);
        headerPanel.add(lblTitulo, BorderLayout.CENTER);
        add(headerPanel, BorderLayout.NORTH);

        //Panel central con formulario
        JPanel panelFormulario = new JPanel(new GridBagLayout());
        panelFormulario.setBackground(fondo);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Campos de texto
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
        add(panelFormulario, BorderLayout.CENTER);

        // Botón Registrar 
        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBackground(botonColor);
        btnRegistrar.setForeground(Color.WHITE);
        btnRegistrar.setFocusPainted(false);
        btnRegistrar.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnRegistrar.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        JPanel panelBoton = new JPanel();
        panelBoton.setBackground(fondo);
        panelBoton.add(btnRegistrar);
        add(panelBoton, BorderLayout.SOUTH);

        // Configuración ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    // Getters para acceder desde el controlador
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
    public String getNombre() { return txtNombre.getText().trim(); }
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
    public String getApellido() { return txtApellido.getText().trim(); }
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
    public String getCedula() { return txtCedula.getText().trim(); }
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
    public String getCorreo() { return txtCorreo.getText().trim(); }
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
    public String getCelular() { return txtCelular.getText().trim(); }
/**
 * getNombreUsuario method.
 * @return result
 */
/**
 * getNombreUsuario method.
 * @return result
 */
/**
 * getNombreUsuario method.
 * @return result
 */
    public String getNombreUsuario() { return txtNombreUsuario.getText().trim(); }
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
    public String getContrasena() { return new String(txtContrasena.getPassword()); }
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
    public JButton getBtnRegistrar() { return btnRegistrar; }

    /**
     * Limpia todos los campos del formulario.
     */
/**
 * limpiarCampos method.
 * @return result
 */
/**
 * limpiarCampos method.
 */
/**
 * limpiarCampos method.
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
     *
     * @param componente
     * @param mensaje
     */
    public void mostrarJOption(Component componente, String mensaje){
        
    }
}
