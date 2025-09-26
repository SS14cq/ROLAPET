package udistrital.avanzada.rolapet.vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Clase FormularioInicioSesion que representa la ventana de inicio de sesión.
 * Contiene campos para que el usuario ingrese su nombre de usuario y contraseña,
 * así como botones para ingresar o cancelar la operación.
 * La interfaz utiliza un diseño con colores y fuentes personalizados.
 * 
 * @author Sarita
 * @version 1.1, 25-09-2025
 */
public class FormularioInicioSesion extends JFrame {
    private JTextField txtUsuario;
    private JPasswordField txtContrasena;
    private JButton btnIngresar;
    private JButton btnCancelar;

    /**
     * Constructor que inicializa la ventana con sus componentes,
     * configurando el diseño, colores y fuentes.
     */
    public FormularioInicioSesion() {
        super("Iniciar Sesión");
        Color fondo = Color.decode("#f5f5dc");
        Color encabezadoColor = Color.decode("#b81b2f");
        Color grisAtras = Color.GRAY;

        Font fuenteTitulo = new Font("Segoe UI", Font.BOLD, 24);
        Font fuenteCampos = new Font("Segoe UI", Font.PLAIN, 14);

        setLayout(new BorderLayout());

        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(fondo);
        headerPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel lblTitulo = new JLabel("Inicio de Sesión", SwingConstants.CENTER);
        lblTitulo.setFont(fuenteTitulo);
        lblTitulo.setForeground(encabezadoColor);

        headerPanel.add(lblTitulo, BorderLayout.CENTER);
        add(headerPanel, BorderLayout.NORTH);

        JPanel panelFormulario = new JPanel(new GridBagLayout());
        panelFormulario.setBackground(fondo);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        txtUsuario = new JTextField(20);
        txtContrasena = new JPasswordField(20);

        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setFont(fuenteCampos);
        JLabel lblContrasena = new JLabel("Contraseña:");
        lblContrasena.setFont(fuenteCampos);

        gbc.gridx = 0; gbc.gridy = 0;
        panelFormulario.add(lblUsuario, gbc);
        gbc.gridx = 1;
        panelFormulario.add(txtUsuario, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        panelFormulario.add(lblContrasena, gbc);
        gbc.gridx = 1;
        panelFormulario.add(txtContrasena, gbc);

        btnIngresar = new JButton("Ingresar");
        btnIngresar.setBackground(encabezadoColor);
        btnIngresar.setForeground(Color.WHITE);
        btnIngresar.setFocusPainted(false);
        btnIngresar.setFont(new Font("Segoe UI", Font.BOLD, 14));

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBackground(grisAtras);
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setFocusPainted(false);
        btnCancelar.setFont(new Font("Segoe UI", Font.BOLD, 14));

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnIngresar);
        panelBotones.add(btnCancelar);

        add(panelFormulario, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    /**
     * Devuelve el texto ingresado en el campo de usuario.
     * @return nombre de usuario ingresado
     */
    public String getUsuario() {
        return txtUsuario.getText().trim();
    }

    /**
     * Devuelve el texto ingresado en el campo de contraseña.
     * @return contraseña ingresada
     */
    public String getContrasena() {
        return new String(txtContrasena.getPassword());
    }

    /**
     * Retorna el botón para ingresar, para agregar listeners de eventos.
     * @return botón ingresar
     */
    public JButton getBtnIngresar() {
        return btnIngresar;
    }

    /**
     * Retorna el botón para cancelar, para agregar listeners de eventos.
     * @return botón cancelar
     */
    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    /**
     * Asigna el mismo ActionListener controlador a ambos botones de la ventana.
     * @param controlador ActionListener que manejará los eventos
     */
    public void setControlador(ActionListener controlador) {
        btnIngresar.addActionListener(controlador);
        btnCancelar.addActionListener(controlador);
    }
    
}
