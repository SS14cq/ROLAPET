package udistrital.avanzada.rolapet.vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VentanaInicio extends JFrame {
    public JButton btnUsuarios = new JButton("Usuarios");
    public JButton btnAdministradores = new JButton("Administradores");
    public JButton btnProveedores = new JButton("Proveedores");

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
    }

    public void setControlador(ActionListener controlador) {
        btnUsuarios.addActionListener(controlador);
        btnAdministradores.addActionListener(controlador);
        btnProveedores.addActionListener(controlador);
    }
}
