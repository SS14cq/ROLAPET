/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.avanzada.rolapet.vista;

import udistrital.avanzada.rolapet.constructor.GestorRegistroProveedor;
import udistrital.avanzada.rolapet.modelo.Proveedor;

import javax.swing.*;
import java.awt.*;

/**
 * Formulario de inicio de sesión para Proveedores.
 * Extiende GestorRegistroCliente pero utiliza GestorRegistroProveedor para la lógica.
 */
public class FormularioRegistroProveedor extends JFrame {

    private JTextField campoCorreo;
    private JPasswordField campoContrasena;
    private JComboBox<String> comboTipoProveedor;
    private JButton botonLogin;

    // Conexión con el gestor de proveedores
    private GestorRegistroProveedor gestor;

    public FormularioRegistroProveedor(GestorRegistroProveedor gestor) {
        this.gestor = gestor;
        inicializar();
    }

    private void inicializar() {
        setTitle("Inicio de Sesión - Proveedor");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2, 10, 10));

        // Etiquetas y campos
        JLabel lblCorreo = new JLabel("Correo:");
        campoCorreo = new JTextField();

        JLabel lblContrasena = new JLabel("Contraseña:");
        campoContrasena = new JPasswordField();

        JLabel lblTipo = new JLabel("Tipo de Proveedor:");
        comboTipoProveedor = new JComboBox<>(new String[]{"ProveedorServicio", "ProveedorInsumo"});

        botonLogin = new JButton("Iniciar Sesión");

        // Agregar componentes
        add(lblCorreo);
        add(campoCorreo);
        add(lblContrasena);
        add(campoContrasena);
        add(lblTipo);
        add(comboTipoProveedor);
        add(new JLabel()); // celda vacía
        add(botonLogin);

        // Acción del botón
        botonLogin.addActionListener(e -> {
            String correo = campoCorreo.getText();
            String contrasena = new String(campoContrasena.getPassword());
            String tipo = (String) comboTipoProveedor.getSelectedItem();

            Proveedor proveedor = gestor.iniciarSesion(correo, contrasena, tipo);

            if (proveedor != null) {
                JOptionPane.showMessageDialog(this,
                        " Bienvenido " + proveedor.getNombre() + " (" + proveedor.getTipoProveedor() + ")",
                        "Login Exitoso", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this,
                        " Credenciales inválidas o tipo de proveedor incorrecto",
                        "Error de inicio de sesión", JOptionPane.ERROR_MESSAGE);
            }
        });

        setVisible(true);
    }
}
