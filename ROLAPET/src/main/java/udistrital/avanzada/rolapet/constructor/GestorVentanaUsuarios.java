package udistrital.avanzada.rolapet.constructor;

import udistrital.avanzada.rolapet.vista.*;
import udistrital.avanzada.rolapet.modelo.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase GestorVentanaUsuarios.
 * Maneja los eventos y la lógica de la interacción entre la ventana de usuarios y la ventana de inicio.
 * Controla la navegación entre formularios de inicio de sesión, registro y la ventana principal.
 * 
 * @author Sarita
 * @version 1.4, 27-09-2025
 */
/**
 * Class GestorVentanaUsuarios.
 */
/**
 * Class GestorVentanaUsuarios.
 */
public class GestorVentanaUsuarios implements ActionListener {

    private VentanaUsuarios ventanaUsuarios;
    private VentanaInicio ventanaInicio;
    private ControladorUsuario controladorUsuario;
    private FormularioInicioSesion formularioInicioSesion;

    public GestorVentanaUsuarios(VentanaUsuarios ventanaUsuarios, VentanaInicio ventanaInicio, ControladorUsuario controladorUsuario) {
        this.ventanaUsuarios = ventanaUsuarios;
        this.ventanaInicio = ventanaInicio;
        this.controladorUsuario = controladorUsuario;

        this.ventanaUsuarios.setControlador(this);
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

        // --- Cerrar sesión: cualquier ventana que tenga este botón ---
        if (source instanceof JButton && ((JButton) source).getText().equals("Cerrar sesión")) {
            JButton btn = (JButton) source;
            Window win = SwingUtilities.getWindowAncestor(btn);
            if (win != null) {
                win.dispose();              // Cierra la ventana actual
            }
            ventanaInicio.setVisible(true); // Muestra la ventana de inicio
            return;
        }

        // --- Botón "Atrás" de formulario de inicio de sesión ---
        if (formularioInicioSesion != null && source == formularioInicioSesion.getBtnAtras()) {
            formularioInicioSesion.dispose();
            ventanaUsuarios.setVisible(true);
            return;
        }

        // --- Botón "Iniciar sesión" de ventanaUsuarios ---
        if (source == ventanaUsuarios.btnIniciarSesion) {
            formularioInicioSesion = new FormularioInicioSesion();
            formularioInicioSesion.setControlador(this);
            formularioInicioSesion.setVisible(true);
            ventanaUsuarios.setVisible(false);
            return;
        }

        // --- Botón "Ingresar" de formulario de inicio de sesión ---
        if (formularioInicioSesion != null && source == formularioInicioSesion.getBtnIngresar()) {
            String usuario = formularioInicioSesion.getUsuario();
            String contrasena = formularioInicioSesion.getContrasena();

            Usuario u = controladorUsuario.buscarPorNombreUsuario(usuario);
            if (u != null && u.getContrasena().equals(contrasena)) {
                JOptionPane.showMessageDialog(formularioInicioSesion, "Inicio de sesión exitoso");
                formularioInicioSesion.dispose();
                ventanaUsuarios.dispose();
                ventanaInicio.dispose();

                VentanaRegistroVehiculo ventanaRegistro = new VentanaRegistroVehiculo();
                ControladorVehiculo controladorVehiculo = new ControladorVehiculo();
                new GestorRegistroVehiculo(ventanaRegistro, controladorVehiculo);

            } else {
                JOptionPane.showMessageDialog(formularioInicioSesion, "Usuario o contraseña incorrectos");
            }
            return;
        }

        // --- Botón "Cancelar" del formulario de inicio de sesión ---
        if (formularioInicioSesion != null && source == formularioInicioSesion.getBtnCancelar()) {
            formularioInicioSesion.dispose();
            ventanaUsuarios.setVisible(true);
            return;
        }

        // --- Botón "Registrarse" de ventanaUsuarios ---
        if (source == ventanaUsuarios.btnRegistrarse) {
            FormularioRegistroCliente formularioRegistroCliente = new FormularioRegistroCliente();
            new GestorRegistroCliente(formularioRegistroCliente, ventanaUsuarios, controladorUsuario);
            formularioRegistroCliente.setVisible(true);
            ventanaUsuarios.setVisible(false);
            return;
        }

        // --- Botón "Atrás" de ventanaUsuarios ---
        if (source == ventanaUsuarios.btnAtras) {
            ventanaUsuarios.dispose();
            ventanaInicio.setVisible(true);
        }
    }
}
