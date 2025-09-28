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
/**
 * Class FormularioInicioSesion.
 */
/**
 * Class FormularioInicioSesion.
 */
public class FormularioInicioSesion extends JFrame {
    // Si el botón 'Atrás' no existe, devolver null para compatibilidad con el controlador
/**
 * getBtnAtras method.
 * @return result
 */
/**
 * getBtnAtras method.
 * @return result
 */
/**
 * getBtnAtras method.
 * @return result
 */
    public JButton getBtnAtras() {
        return null;
    }
    private JTextField txtUsuario;
    private JPasswordField txtContrasena;
    private JButton btnIngresar;
    protected JButton btnCancelar;

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
        panelBotones.setBackground(fondo);
        btnIngresar.setBackground(encabezadoColor);
        btnIngresar.setForeground(Color.WHITE);
        btnIngresar.setOpaque(true);
        btnCancelar.setBackground(grisAtras);
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setOpaque(true);
        panelBotones.add(btnIngresar);
        panelBotones.add(Box.createHorizontalStrut(10));
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
/**
 * getUsuario method.
 * @return result
 */
/**
 * getUsuario method.
 * @return result
 */
/**
 * getUsuario method.
 * @return result
 */
    public String getUsuario() {
        return txtUsuario.getText().trim();
    }

    /**
     * Devuelve el texto ingresado en el campo de contraseña.
     * @return contraseña ingresada
     */
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
            btnCancelar.addActionListener(e -> {
                this.dispose();
            });
            btnCancelar.addActionListener(controlador);
     * @return botón ingresar
     */
/**
 * getBtnIngresar method.
 * @return result
 */
/**
 * getBtnIngresar method.
 * @return result
 */
/**
 * getBtnIngresar method.
 * @return result
 */
    public JButton getBtnIngresar() {
        return btnIngresar;
    }

    /**
     * Retorna el botón para cancelar, para agregar listeners de eventos.
     * @return botón cancelar
     */
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
     * Asigna el mismo ActionListener controlador a ambos botones de la ventana.
     * @param controlador ActionListener que manejará los eventos
     */
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
    public void setControlador(ActionListener controlador) {
        btnIngresar.addActionListener(controlador);
        btnCancelar.addActionListener(e -> {
            this.dispose();
        });
        btnCancelar.addActionListener(controlador);
    }
}
