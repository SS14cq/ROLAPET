package udistrital.avanzada.rolapet.constructor;

import udistrital.avanzada.rolapet.vista.*;
import udistrital.avanzada.rolapet.modelo.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == ventanaUsuarios.btnIniciarSesion) {
            formularioInicioSesion = new FormularioInicioSesion();
            formularioInicioSesion.setControlador(this);
            formularioInicioSesion.setVisible(true);
            ventanaUsuarios.setVisible(false);

        } else if (formularioInicioSesion != null && source == formularioInicioSesion.getBtnIngresar()) {
            String usuario = formularioInicioSesion.getUsuario();
            String contrasena = formularioInicioSesion.getContrasena();

            Usuario u = controladorUsuario.buscarPorNombreUsuario(usuario);
            if (u != null && u.getContrasena().equals(contrasena)) {
                JOptionPane.showMessageDialog(formularioInicioSesion, "Inicio de sesión exitoso");
                formularioInicioSesion.dispose();
                ventanaUsuarios.dispose();
                ventanaInicio.dispose();

                // Abrir ventana de registro de vehículo
                VentanaRegistroVehiculo ventanaRegistro = new VentanaRegistroVehiculo();
                ControladorVehiculo controladorVehiculo = new ControladorVehiculo();
                GestorRegistroVehiculo gestorRegistro = new GestorRegistroVehiculo(ventanaRegistro, controladorVehiculo);

            } else {
                JOptionPane.showMessageDialog(formularioInicioSesion, "Usuario o contraseña incorrectos");
            }

        } else if (formularioInicioSesion != null && source == formularioInicioSesion.getBtnCancelar()) {
            formularioInicioSesion.dispose();
            ventanaUsuarios.setVisible(true);

        } else if (source == ventanaUsuarios.btnRegistrarse) {
            FormularioRegistro formularioRegistro = new FormularioRegistro();
            GestorRegistro gestorRegistro = new GestorRegistro(formularioRegistro, ventanaUsuarios, controladorUsuario);
            formularioRegistro.setVisible(true);
            ventanaUsuarios.setVisible(false);

        } else if (source == ventanaUsuarios.btnAtras) {
            ventanaUsuarios.dispose();
            ventanaInicio.setVisible(true);
        }
    }
}
