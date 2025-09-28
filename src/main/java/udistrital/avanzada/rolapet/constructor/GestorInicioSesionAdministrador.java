/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.avanzada.rolapet.constructor;

import udistrital.avanzada.rolapet.vista.FormularioInicioSesionAdministrador;
import udistrital.avanzada.rolapet.vista.VentanaSeleccionRegistroProveedor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class GestorInicioSesionAdministrador.
 */
/**
 * Class GestorInicioSesionAdministrador.
 */
public class GestorInicioSesionAdministrador implements ActionListener {

    private FormularioInicioSesionAdministrador vista;
    private GestorRegistroProveedor gestorProveedor;
    private udistrital.avanzada.rolapet.modelo.RepositorioPublicaciones repoPublicaciones;

    public GestorInicioSesionAdministrador(FormularioInicioSesionAdministrador vista,
                                           GestorRegistroProveedor gestorProveedor) {
        this(vista, gestorProveedor, new udistrital.avanzada.rolapet.modelo.RepositorioPublicaciones());
    }

    public GestorInicioSesionAdministrador(FormularioInicioSesionAdministrador vista,
                                           GestorRegistroProveedor gestorProveedor,
                                           udistrital.avanzada.rolapet.modelo.RepositorioPublicaciones repoPublicaciones) {
        this.vista = vista;
        this.gestorProveedor = gestorProveedor;
        this.repoPublicaciones = repoPublicaciones;
        this.vista.setControlador(this);
    }

    @Override
/**
 * actionPerformed method.
 * @param e parameter
 * @return result
 */
/**
 * actionPerformed method.
 * @param e parameter
 */
/**
 * actionPerformed method.
 * @param e parameter
 */
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == vista.getBtnIngresar()) {
            String usuario = vista.getUsuario();
            String contrasena = vista.getContrasena();

        if (usuario.equals("administrador") && contrasena.equals("12345678")) {
        JOptionPane.showMessageDialog(vista,
            " Bienvenido Administrador",
            "Login exitoso", JOptionPane.INFORMATION_MESSAGE);

        // Abrir panel de administrador con botón para crear publicación
        new GestorVentanaAdministrador(repoPublicaciones);
        vista.dispose();
            } else {
                JOptionPane.showMessageDialog(vista,
                        " Usuario o contraseña inválidos.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }

        } else if (source == vista.getBtnCancelar()) {
            vista.dispose();
        }
    }
}
