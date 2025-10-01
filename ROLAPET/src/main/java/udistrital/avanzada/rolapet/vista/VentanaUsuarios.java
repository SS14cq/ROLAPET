package udistrital.avanzada.rolapet.vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Clase VentanaUsuarios que representa la ventana con opciones para usuarios.
 * Cuenta con botones para iniciar sesión, registrarse y regresar,
 * y presenta un diseño con logo, título y colores personalizados.
 * 
 * @author Sarita
 * @version 1.3, 25-09-2025
 */
/**
 * Class VentanaUsuarios.
 */
/**
 * Class VentanaUsuarios.
 */
public class VentanaUsuarios extends JFrame {
/**
 * JButton method.
 * @param sesión" parameter
 */
    public JButton btnIniciarSesion = new JButton("Iniciar sesión");
/**
 * JButton method.
 * @param "Registrarse" parameter
 */
    public JButton btnRegistrarse = new JButton("Registrarse");
/**
 * JButton method.
 * @param "Atrás" parameter
 */
    public JButton btnAtras = new JButton("Atrás");

    /**
     * Constructor que inicializa la ventana con sus componentes, diseño y layout.
     */
    public VentanaUsuarios() {
        Color fondo = Color.decode("#f5f5dc");
        Color encabezadoColor = Color.decode("#b81b2f");

        Font fuenteTitulo = new Font("Segoe UI", Font.BOLD, 24);

        setLayout(new BorderLayout());

        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(fondo);
        headerPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        ImageIcon logo = new ImageIcon(getClass().getResource("/imagenes/rolapet_logo.png"));
        Image img = logo.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        JLabel lblLogo = new JLabel(new ImageIcon(img));

        JLabel lblTitulo = new JLabel("Rolapet - Usuarios", SwingConstants.LEFT);
        lblTitulo.setFont(fuenteTitulo);
        lblTitulo.setForeground(encabezadoColor);

        headerPanel.add(lblLogo, BorderLayout.WEST);
        headerPanel.add(lblTitulo, BorderLayout.CENTER);
        add(headerPanel, BorderLayout.NORTH);

        setTitle("Ventana Usuarios");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));
        panelBotones.setBackground(fondo);

        btnIniciarSesion.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnRegistrarse.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnAtras.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnIniciarSesion.setBackground(encabezadoColor);
        btnIniciarSesion.setForeground(Color.WHITE);

        btnRegistrarse.setBackground(encabezadoColor);
        btnRegistrarse.setForeground(Color.WHITE);

        btnAtras.setBackground(Color.GRAY);
        btnAtras.setForeground(Color.WHITE);

        panelBotones.add(Box.createVerticalGlue());
        panelBotones.add(btnIniciarSesion);
        panelBotones.add(Box.createRigidArea(new Dimension(0, 10)));
        panelBotones.add(btnRegistrarse);
        panelBotones.add(Box.createRigidArea(new Dimension(0, 10)));
        panelBotones.add(btnAtras);
        panelBotones.add(Box.createVerticalGlue());

        getContentPane().add(panelBotones);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    /**
     * Asigna el mismo ActionListener controlador a los botones de la ventana.
     * 
     * @param controlador ActionListener que manejará los eventos de los botones
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
        btnIniciarSesion.addActionListener(controlador);
        btnRegistrarse.addActionListener(controlador);
        btnAtras.addActionListener(controlador);
    }
}
