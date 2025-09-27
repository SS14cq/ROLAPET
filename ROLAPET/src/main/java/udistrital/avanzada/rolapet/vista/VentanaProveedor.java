package udistrital.avanzada.rolapet.vista;

import javax.swing.*;
import java.awt.*;

public class VentanaProveedor extends JFrame {

    private JButton btnVerPublicaciones;
    private JButton btnAgregarItem;
    private JButton btnCrearPublicacion;
    private JButton btnCerrarSesion;

    public VentanaProveedor(String nombreProveedor, String tipoProveedor) {
        Color fondo = Color.decode("#f5f5dc");
        Color encabezadoColor = Color.decode("#b81b2f");

        setTitle("Panel Proveedor - " + tipoProveedor);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel superior con logo y título
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(fondo);
        headerPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        ImageIcon logo = new ImageIcon(getClass().getResource("/imagenes/rolapet_logo.png"));
        Image img = logo.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        JLabel lblLogo = new JLabel(new ImageIcon(img));

        JLabel lblTitulo = new JLabel("Rolapet - Proveedor", SwingConstants.LEFT);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblTitulo.setForeground(encabezadoColor);

        headerPanel.add(lblLogo, BorderLayout.WEST);
        headerPanel.add(lblTitulo, BorderLayout.CENTER);
        add(headerPanel, BorderLayout.NORTH);

        // Panel de bienvenida reducido
        JLabel lblBienvenida = new JLabel("Bienvenido " + nombreProveedor + " (" + tipoProveedor + ")", SwingConstants.CENTER);
        lblBienvenida.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        lblBienvenida.setForeground(encabezadoColor);
        lblBienvenida.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));

        // Panel de botones más grande
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));
        panelBotones.setBackground(fondo);
        panelBotones.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        btnVerPublicaciones = new JButton("Ver mis publicaciones");
        btnAgregarItem = new JButton("Agregar nuevo ítem");
        btnCrearPublicacion = new JButton("Crear publicación");
        btnCerrarSesion = new JButton("Cerrar sesión");

        btnVerPublicaciones.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnAgregarItem.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnCrearPublicacion.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnCerrarSesion.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnVerPublicaciones.setBackground(encabezadoColor);
        btnVerPublicaciones.setForeground(Color.WHITE);
        btnVerPublicaciones.setOpaque(true);
        btnVerPublicaciones.setFont(new Font("Segoe UI", Font.BOLD, 15));
        btnVerPublicaciones.setMaximumSize(new Dimension(220, 40));

        btnAgregarItem.setBackground(encabezadoColor);
        btnAgregarItem.setForeground(Color.WHITE);
        btnAgregarItem.setOpaque(true);
        btnAgregarItem.setFont(new Font("Segoe UI", Font.BOLD, 15));
        btnAgregarItem.setMaximumSize(new Dimension(220, 40));

        btnCrearPublicacion.setBackground(encabezadoColor);
        btnCrearPublicacion.setForeground(Color.WHITE);
        btnCrearPublicacion.setOpaque(true);
        btnCrearPublicacion.setFont(new Font("Segoe UI", Font.BOLD, 15));
        btnCrearPublicacion.setMaximumSize(new Dimension(220, 40));

        btnCerrarSesion.setBackground(encabezadoColor);
        btnCerrarSesion.setForeground(Color.WHITE);
        btnCerrarSesion.setOpaque(true);
        btnCerrarSesion.setFont(new Font("Segoe UI", Font.BOLD, 15));
        btnCerrarSesion.setMaximumSize(new Dimension(220, 40));

        panelBotones.add(Box.createVerticalStrut(10));
        panelBotones.add(btnVerPublicaciones);
        panelBotones.add(Box.createVerticalStrut(15));
        panelBotones.add(btnAgregarItem);
        panelBotones.add(Box.createVerticalStrut(15));
        panelBotones.add(btnCrearPublicacion);
        panelBotones.add(Box.createVerticalStrut(15));
        panelBotones.add(btnCerrarSesion);
        panelBotones.add(Box.createVerticalStrut(10));

        JPanel centro = new JPanel(new BorderLayout());
        centro.setBackground(fondo);
        centro.add(lblBienvenida, BorderLayout.NORTH);
        centro.add(panelBotones, BorderLayout.CENTER);
        add(centro, BorderLayout.CENTER);
    }

    public JButton getBtnVerPublicaciones() {
        return btnVerPublicaciones;
    }

    public JButton getBtnAgregarItem() {
        return btnAgregarItem;
    }


    public JButton getBtnCrearPublicacion() {
        return btnCrearPublicacion;
    }
    public JButton getBtnCerrarSesion() {
        return btnCerrarSesion;
    }

    public void setControlador(java.awt.event.ActionListener controlador) {
        btnVerPublicaciones.addActionListener(controlador);
        btnAgregarItem.addActionListener(controlador);
        btnCrearPublicacion.addActionListener(controlador);
        btnCerrarSesion.addActionListener(controlador);
    }
}
