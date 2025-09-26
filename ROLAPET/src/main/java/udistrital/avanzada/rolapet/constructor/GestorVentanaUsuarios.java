package udistrital.avanzada.rolapet.constructor;

import udistrital.avanzada.rolapet.vista.*;
import udistrital.avanzada.rolapet.modelo.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase GestorVentanaUsuarios.
 * Maneja los eventos y la lógica de la interacción entre la ventana de usuarios y la ventana de inicio.
 * Controla la navegación entre formularios de inicio de sesión, registro y la ventana principal.
 * 
 * @author Sarita
 * @version 1.3
 */
public class GestorVentanaUsuarios implements ActionListener {

    /**
     * Ventana principal que muestra las opciones para usuarios.
     */
    private VentanaUsuarios ventanaUsuarios;

    /**
     * Ventana inicial de la aplicación.
     */
    private VentanaInicio ventanaInicio;

    /**
     * Controlador responsable de la gestión de usuarios.
     */
    private ControladorUsuario controladorUsuario;

    /**
     * Formulario de inicio de sesión que puede estar activo.
     */
    private FormularioInicioSesion formularioInicioSesion;

    /**
     * Constructor de GestorVentanaUsuarios.
     * Inicializa las ventanas y el controlador, y registra al gestor como controlador de eventos para la ventana de usuarios.
     * 
     * @param ventanaUsuarios La ventana que muestra opciones relacionadas con usuarios (iniciar sesión, registrarse).
     * @param ventanaInicio La ventana inicial de la aplicación.
     * @param controladorUsuario Controlador para manejar la lógica de usuarios (búsqueda, validación).
     */
    public GestorVentanaUsuarios(VentanaUsuarios ventanaUsuarios, VentanaInicio ventanaInicio, ControladorUsuario controladorUsuario) {
        this.ventanaUsuarios = ventanaUsuarios;
        this.ventanaInicio = ventanaInicio;
        this.controladorUsuario = controladorUsuario;

        this.ventanaUsuarios.setControlador(this);
    }

    /**
     * Método que maneja los eventos de acción generados por botones en las ventanas de usuarios.
     * Define la reacción para los botones de iniciar sesión, registrarse, cancelar, e ir hacia atrás.
     * 
     * @param e Evento de acción generado por el usuario.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == ventanaUsuarios.btnIniciarSesion) {
            // Mostrar formulario de inicio de sesión y ocultar ventana de usuarios
            formularioInicioSesion = new FormularioInicioSesion();
            formularioInicioSesion.setControlador(this);
            formularioInicioSesion.setVisible(true);
            ventanaUsuarios.setVisible(false);

        } else if (formularioInicioSesion != null && source == formularioInicioSesion.getBtnIngresar()) {
            // Proceso de autenticación de usuario
            String usuario = formularioInicioSesion.getUsuario();
            String contrasena = formularioInicioSesion.getContrasena();

            Usuario u = controladorUsuario.buscarPorNombreUsuario(usuario);
            if (u != null && u.getContrasena().equals(contrasena)) {
                JOptionPane.showMessageDialog(formularioInicioSesion, "Inicio de sesión exitoso");
                formularioInicioSesion.dispose();
                ventanaUsuarios.dispose();
                ventanaInicio.dispose();

                // Abrir ventana de registro de vehículo para usuario autenticado
                VentanaRegistroVehiculo ventanaRegistro = new VentanaRegistroVehiculo();
                ControladorVehiculo controladorVehiculo = new ControladorVehiculo();
                GestorRegistroVehiculo gestorRegistro = new GestorRegistroVehiculo(ventanaRegistro, controladorVehiculo);

            } else {
                JOptionPane.showMessageDialog(formularioInicioSesion, "Usuario o contraseña incorrectos");
            }

        } else if (formularioInicioSesion != null && source == formularioInicioSesion.getBtnCancelar()) {
            // Cancelar inicio de sesión, cerrar el formulario y mostrar ventana de usuarios
            formularioInicioSesion.dispose();
            ventanaUsuarios.setVisible(true);

        } else if (source == ventanaUsuarios.btnRegistrarse) {
            // Mostrar formulario de registro de cliente y ocultar ventana de usuarios
            FormularioRegistroCliente formularioRegistroCliente = new FormularioRegistroCliente();
            GestorRegistroCliente gestorRegistroCliente = new GestorRegistroCliente(formularioRegistroCliente, ventanaUsuarios, controladorUsuario);
            formularioRegistroCliente.setVisible(true);
            ventanaUsuarios.setVisible(false);

        } else if (source == ventanaUsuarios.btnAtras) {
            // Volver a la ventana inicial cerrando la ventana de usuarios
            ventanaUsuarios.dispose();
            ventanaInicio.setVisible(true);
        }
    }
}
