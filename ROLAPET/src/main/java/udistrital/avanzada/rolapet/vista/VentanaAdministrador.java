package udistrital.avanzada.rolapet.vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Class VentanaAdministrador.
 */
/**
 * Class VentanaAdministrador.
 */
public class VentanaAdministrador extends JFrame {
    private JButton btnRegistrarProveedor;
    private JButton btnCrearPublicacion;
    private JButton btnCerrarSesion;

    public VentanaAdministrador() {
        Color fondo = Color.decode("#f5f5dc");
        Color encabezadoColor = Color.decode("#b81b2f");
        Font fuenteTitulo = new Font("Segoe UI", Font.BOLD, 24);

        setTitle("Panel de Administrador");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Header con logo y título
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(fondo);
        headerPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        ImageIcon logo = new ImageIcon(getClass().getResource("/imagenes/rolapet_logo.png"));
        Image img = logo.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        JLabel lblLogo = new JLabel(new ImageIcon(img));
        JLabel lblTitulo = new JLabel("Rolapet - Administrador", SwingConstants.LEFT);
        lblTitulo.setFont(fuenteTitulo);
        lblTitulo.setForeground(encabezadoColor);
        headerPanel.add(lblLogo, BorderLayout.WEST);
        headerPanel.add(lblTitulo, BorderLayout.CENTER);
        add(headerPanel, BorderLayout.NORTH);

        // Botones
        btnRegistrarProveedor = new JButton("Registrar proveedor");
        btnRegistrarProveedor.setBackground(encabezadoColor);
        btnRegistrarProveedor.setForeground(Color.WHITE);
        btnRegistrarProveedor.setOpaque(true);

        btnCrearPublicacion = new JButton("Crear publicación");
        btnCrearPublicacion.setBackground(encabezadoColor);
        btnCrearPublicacion.setForeground(Color.WHITE);
        btnCrearPublicacion.setOpaque(true);

        btnCerrarSesion = new JButton("Cerrar sesión");
        btnCerrarSesion.setBackground(Color.GRAY);
        btnCerrarSesion.setForeground(Color.WHITE);
        btnCerrarSesion.setOpaque(true);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));
        panelBotones.setBackground(fondo);

        btnRegistrarProveedor.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnCrearPublicacion.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnCerrarSesion.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelBotones.add(Box.createVerticalGlue());
        panelBotones.add(btnRegistrarProveedor);
        panelBotones.add(Box.createRigidArea(new Dimension(0, 15)));
        panelBotones.add(btnCrearPublicacion);
        panelBotones.add(Box.createRigidArea(new Dimension(0, 15)));
        panelBotones.add(btnCerrarSesion);
        panelBotones.add(Box.createVerticalGlue());

        add(panelBotones, BorderLayout.CENTER);
        setLocationRelativeTo(null);
    }

/**
 * setRegistrarProveedorListener method.
 * @param listener parameter
 * @return result
 */
/**
 * setRegistrarProveedorListener method.
 * @param listener parameter
 */
/**
 * setRegistrarProveedorListener method.
 * @param listener parameter
 */
    public void setRegistrarProveedorListener(ActionListener listener) {
        btnRegistrarProveedor.addActionListener(listener);
    }
/**
 * setCrearPublicacionListener method.
 * @param listener parameter
 * @return result
 */
/**
 * setCrearPublicacionListener method.
 * @param listener parameter
 */
/**
 * setCrearPublicacionListener method.
 * @param listener parameter
 */
    public void setCrearPublicacionListener(ActionListener listener) {
        btnCrearPublicacion.addActionListener(listener);
    }
/**
 * setCerrarSesionListener method.
 * @param listener parameter
 * @return result
 */
/**
 * setCerrarSesionListener method.
 * @param listener parameter
 */
/**
 * setCerrarSesionListener method.
 * @param listener parameter
 */
    public void setCerrarSesionListener(ActionListener listener) {
        btnCerrarSesion.addActionListener(listener);
    }
}
