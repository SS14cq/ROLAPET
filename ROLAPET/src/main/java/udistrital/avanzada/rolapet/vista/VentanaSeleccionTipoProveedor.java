package udistrital.avanzada.rolapet.vista;

import javax.swing.*;
import java.awt.*;

public class VentanaSeleccionTipoProveedor extends JFrame {

    private JButton btnServicio;
    private JButton btnInsumo;

    public VentanaSeleccionTipoProveedor() {
        setTitle("Seleccionar tipo de Proveedor");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 1, 10, 10));

        JLabel lblPregunta = new JLabel("¿Qué tipo de proveedor eres?", SwingConstants.CENTER);
        btnServicio = new JButton("Proveedor de Servicios");
        btnInsumo = new JButton("Proveedor de Insumos");

        add(lblPregunta);
        add(btnServicio);
        add(btnInsumo);
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
