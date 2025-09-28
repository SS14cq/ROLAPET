/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.avanzada.rolapet.vista;

import javax.swing.*;
import java.awt.*;

/**
 * Class VentanaSeleccionRegistroProveedor.
 */
/**
 * Class VentanaSeleccionRegistroProveedor.
 */
public class VentanaSeleccionRegistroProveedor extends JFrame {

    private JButton btnRegistrarInsumos;
    private JButton btnRegistrarServicios;

    public VentanaSeleccionRegistroProveedor() {
        Color fondo = Color.decode("#f5f5dc");
        Color encabezadoColor = Color.decode("#b81b2f");

        setTitle("Registrar Proveedor");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(350, 220);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel superior con logo y título
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(fondo);
        headerPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        ImageIcon logo = new ImageIcon(getClass().getResource("/imagenes/rolapet_logo.png"));
        Image img = logo.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        JLabel lblLogo = new JLabel(new ImageIcon(img));

        JLabel lblTitulo = new JLabel("Rolapet - Registro de Proveedor", SwingConstants.LEFT);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblTitulo.setForeground(encabezadoColor);

        headerPanel.add(lblLogo, BorderLayout.WEST);
        headerPanel.add(lblTitulo, BorderLayout.CENTER);
        add(headerPanel, BorderLayout.NORTH);

        // Panel central con pregunta y botones
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));
        panelCentral.setBackground(fondo);

        JLabel lblPregunta = new JLabel("¿Qué tipo de proveedor desea registrar?", SwingConstants.CENTER);
        lblPregunta.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblPregunta.setForeground(encabezadoColor);
        lblPregunta.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnRegistrarInsumos = new JButton("Proveedor de Insumos");
        btnRegistrarServicios = new JButton("Proveedor de Servicios");

        btnRegistrarInsumos.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnRegistrarServicios.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnRegistrarInsumos.setBackground(encabezadoColor);
        btnRegistrarInsumos.setForeground(Color.WHITE);
        btnRegistrarInsumos.setOpaque(true);

        btnRegistrarServicios.setBackground(encabezadoColor);
        btnRegistrarServicios.setForeground(Color.WHITE);
        btnRegistrarServicios.setOpaque(true);

        panelCentral.add(lblPregunta);
        panelCentral.add(Box.createVerticalStrut(15));
        panelCentral.add(btnRegistrarInsumos);
        panelCentral.add(Box.createVerticalStrut(10));
        panelCentral.add(btnRegistrarServicios);

        add(panelCentral, BorderLayout.CENTER);
    }

/**
 * getBtnRegistrarInsumos method.
 * @return result
 */
/**
 * getBtnRegistrarInsumos method.
 * @return result
 */
/**
 * getBtnRegistrarInsumos method.
 * @return result
 */
    public JButton getBtnRegistrarInsumos() {
        return btnRegistrarInsumos;
    }

/**
 * getBtnRegistrarServicios method.
 * @return result
 */
/**
 * getBtnRegistrarServicios method.
 * @return result
 */
/**
 * getBtnRegistrarServicios method.
 * @return result
 */
    public JButton getBtnRegistrarServicios() {
        return btnRegistrarServicios;
    }

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
    public void setControlador(java.awt.event.ActionListener controlador) {
        btnRegistrarInsumos.addActionListener(controlador);
        btnRegistrarServicios.addActionListener(controlador);
    }
}
