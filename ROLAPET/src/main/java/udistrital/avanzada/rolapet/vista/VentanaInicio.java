package udistrital.avanzada.rolapet.vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Clase VentanaInicio que representa la pantalla principal de inicio de la aplicación.
 * Contiene botones para navegar a las secciones de Usuarios, Administradores y Proveedores.
 * Presenta un diseño con colores personalizados, logo y título.
 * 
 * @author Sarita
 * @version 1.1, 21-09-2025
 */
/**
 * Class VentanaInicio.
 */
/**
 * Class VentanaInicio.
 */
public class VentanaInicio extends JFrame {
/**
 * JButton method.
 * @param "Usuarios" parameter
 */
    public JButton btnUsuarios = new JButton("Usuarios");
/**
 * JButton method.
 * @param "Administradores" parameter
 */
    public JButton btnAdministradores = new JButton("Administradores");
/**
 * JButton method.
 * @param "Proveedores" parameter
 */
    public JButton btnProveedores = new JButton("Proveedores");

    /**
     * Constructor que inicializa la ventana con su diseño y componentes.
     * Configura colores, fuentes, logo, título y el layout de los botones.
     */
    public VentanaInicio() {
        Color fondo = Color.decode("#f5f5dc");
        Color encabezadoColor = Color.decode("#b81b2f");

        btnUsuarios.setBackground(encabezadoColor);
        btnUsuarios.setForeground(Color.WHITE);
        btnUsuarios.setOpaque(true);

        btnAdministradores.setBackground(encabezadoColor);
        btnAdministradores.setForeground(Color.WHITE);
        btnAdministradores.setOpaque(true);

        btnProveedores.setBackground(encabezadoColor);
        btnProveedores.setForeground(Color.WHITE);
        btnProveedores.setOpaque(true);

        Font fuenteTitulo = new Font("Segoe UI", Font.BOLD, 24);

        setLayout(new BorderLayout());

        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(fondo);
        headerPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        ImageIcon logo = new ImageIcon(getClass().getResource("/imagenes/rolapet_logo.png"));
        Image img = logo.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        JLabel lblLogo = new JLabel(new ImageIcon(img));

        JLabel lblTitulo = new JLabel("Rolapet", SwingConstants.LEFT);
        lblTitulo.setFont(fuenteTitulo);
        lblTitulo.setForeground(encabezadoColor);

        headerPanel.add(lblLogo, BorderLayout.WEST);
        headerPanel.add(lblTitulo, BorderLayout.CENTER);
        add(headerPanel, BorderLayout.NORTH);

        setTitle("Ventana Inicio");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));
        panelBotones.setBackground(fondo);

        btnUsuarios.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnAdministradores.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnProveedores.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelBotones.add(Box.createVerticalGlue());
        panelBotones.add(btnUsuarios);
        panelBotones.add(Box.createRigidArea(new Dimension(0, 15)));
        panelBotones.add(btnAdministradores);
        panelBotones.add(Box.createRigidArea(new Dimension(0, 15)));
        panelBotones.add(btnProveedores);
        panelBotones.add(Box.createVerticalGlue());

        getContentPane().add(panelBotones);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        btnUsuarios.addActionListener(controlador);
        btnAdministradores.addActionListener(controlador);
        btnProveedores.addActionListener(controlador);
    }
    
    public void mostrarJOption(Component Componente, String mensaje){
        JOptionPane.showMessageDialog(Componente, mensaje);
    }
    public void mostrarJOption2(Component Componente, String mensaje, String titulo){
        JOptionPane.showMessageDialog(Componente, mensaje, titulo, JOptionPane.WARNING_MESSAGE);
    }
}
