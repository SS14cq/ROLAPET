package udistrital.avanzada.rolapet.vista;

import javax.swing.*;
import java.awt.*;

public class VentanaSeleccionTipoProveedor extends JFrame {

    private JButton btnServicio;
    private JButton btnInsumo;

    public VentanaSeleccionTipoProveedor() {
        Color fondo = Color.decode("#f5f5dc");
        Color encabezadoColor = Color.decode("#b81b2f");

        setTitle("Seleccionar tipo de Proveedor");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setSize(420, 320);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel superior con logo y título
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(fondo);
        headerPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        ImageIcon logo = new ImageIcon(getClass().getResource("/imagenes/rolapet_logo.png"));
        Image img = logo.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        JLabel lblLogo = new JLabel(new ImageIcon(img));

        JLabel lblTitulo = new JLabel("Rolapet - Selección de Proveedor", SwingConstants.LEFT);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblTitulo.setForeground(encabezadoColor);

        headerPanel.add(lblLogo, BorderLayout.WEST);
        headerPanel.add(lblTitulo, BorderLayout.CENTER);
        add(headerPanel, BorderLayout.NORTH);

        // Panel central con pregunta y botones
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));
        panelCentral.setBackground(fondo);

        JLabel lblPregunta = new JLabel("¿Qué tipo de proveedor eres?", SwingConstants.CENTER);
        lblPregunta.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblPregunta.setForeground(encabezadoColor);
        lblPregunta.setAlignmentX(Component.CENTER_ALIGNMENT);

    btnServicio = new JButton("Proveedor de Servicios");
    btnInsumo = new JButton("Proveedor de Insumos");

    btnServicio.setFont(new Font("Segoe UI", Font.PLAIN, 15));
    btnServicio.setBackground(encabezadoColor);
    btnServicio.setForeground(Color.WHITE);
    btnServicio.setFocusPainted(false);
    btnServicio.setAlignmentX(Component.CENTER_ALIGNMENT);
    btnServicio.setMaximumSize(new Dimension(220, 40));

    btnInsumo.setFont(new Font("Segoe UI", Font.PLAIN, 15));
    btnInsumo.setBackground(encabezadoColor);
    btnInsumo.setForeground(Color.WHITE);
    btnInsumo.setFocusPainted(false);
    btnInsumo.setAlignmentX(Component.CENTER_ALIGNMENT);
    btnInsumo.setMaximumSize(new Dimension(220, 40));

    panelCentral.add(Box.createVerticalStrut(20));
    panelCentral.add(lblPregunta);
    panelCentral.add(Box.createVerticalStrut(25));
    panelCentral.add(btnServicio);
    panelCentral.add(Box.createVerticalStrut(15));
    panelCentral.add(btnInsumo);
    panelCentral.add(Box.createVerticalStrut(20));

    add(panelCentral, BorderLayout.CENTER);
    }

    public JButton getBtnServicio() {
        return btnServicio;
    }

    public JButton getBtnInsumo() {
        return btnInsumo;
    }

    public void setControlador(java.awt.event.ActionListener controlador) {
        btnServicio.addActionListener(controlador);
        btnInsumo.addActionListener(controlador);
    }
}
