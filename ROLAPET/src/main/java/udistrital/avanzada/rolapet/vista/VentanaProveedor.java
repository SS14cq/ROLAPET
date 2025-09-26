package udistrital.avanzada.rolapet.vista;

import javax.swing.*;
import java.awt.*;

public class VentanaProveedor extends JFrame {

    private JButton btnVerPublicaciones;
    private JButton btnAgregarItem;
    private JButton btnCerrarSesion;

    public VentanaProveedor(String nombreProveedor, String tipoProveedor) {
        setTitle("Panel Proveedor - " + tipoProveedor);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // --- Panel superior (título) ---
        JLabel lblBienvenida = new JLabel("Bienvenido " + nombreProveedor + " (" + tipoProveedor + ")", SwingConstants.CENTER);
        lblBienvenida.setFont(new Font("Segoe UI", Font.BOLD, 18));
        add(lblBienvenida, BorderLayout.NORTH);

        // --- Panel central con botones ---
        JPanel panelCentral = new JPanel(new GridLayout(3, 1, 10, 10));
        btnVerPublicaciones = new JButton("Ver mis publicaciones");
        btnAgregarItem = new JButton("Agregar nuevo ítem");
        btnCerrarSesion = new JButton("Cerrar sesión");

        panelCentral.add(btnVerPublicaciones);
        panelCentral.add(btnAgregarItem);
        panelCentral.add(btnCerrarSesion);

        add(panelCentral, BorderLayout.CENTER);
    }

    public JButton getBtnVerPublicaciones() {
        return btnVerPublicaciones;
    }

    public JButton getBtnAgregarItem() {
        return btnAgregarItem;
    }

    public JButton getBtnCerrarSesion() {
        return btnCerrarSesion;
    }

    public void setControlador(java.awt.event.ActionListener controlador) {
        btnVerPublicaciones.addActionListener(controlador);
        btnAgregarItem.addActionListener(controlador);
        btnCerrarSesion.addActionListener(controlador);
    }
}
