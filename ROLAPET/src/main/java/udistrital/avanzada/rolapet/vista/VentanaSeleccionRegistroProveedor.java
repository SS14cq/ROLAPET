/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.avanzada.rolapet.vista;

import javax.swing.*;
import java.awt.*;

public class VentanaSeleccionRegistroProveedor extends JFrame {

    private JButton btnRegistrarInsumos;
    private JButton btnRegistrarServicios;

    public VentanaSeleccionRegistroProveedor() {
        setTitle("Registrar Proveedor");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(350, 150);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 1, 10, 10));

        JLabel lblPregunta = new JLabel("¿Qué tipo de proveedor desea registrar?", SwingConstants.CENTER);
        btnRegistrarInsumos = new JButton("Proveedor de Insumos");
        btnRegistrarServicios = new JButton("Proveedor de Servicios");

        add(lblPregunta);
        add(btnRegistrarInsumos);
        add(btnRegistrarServicios);
    }

    public JButton getBtnRegistrarInsumos() {
        return btnRegistrarInsumos;
    }

    public JButton getBtnRegistrarServicios() {
        return btnRegistrarServicios;
    }

    public void setControlador(java.awt.event.ActionListener controlador) {
        btnRegistrarInsumos.addActionListener(controlador);
        btnRegistrarServicios.addActionListener(controlador);
    }
}
