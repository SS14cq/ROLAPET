/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.avanzada.rolapet.constructor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import udistrital.avanzada.rolapet.modelo.Usuario;
import udistrital.avanzada.rolapet.vista.FormularioRegistro;


/**
 * Controlador que gestiona las interacciones entre la vista del formulario de registro
 * y el gestor de usuarios. Maneja eventos del formulario para registrar usuarios nuevos.
 * 
 * @author sarita
 * @version 1.0, 21-09-2025
 */
/**
 * Class ControladorRegistro.
 */
/**
 * Class ControladorRegistro.
 */
public class ControladorRegistro implements ActionListener {

    private FormularioRegistro vista;
    private GestorUsuario gestor;
    
    /**
     * Crea un controlador vinculado a una vista y un gestor de usuarios específicos.
     * Asocia el listener al botón Registrar del formulario.
     * 
     * @param vista Vista del formulario de registro.
     * @param gestor Gestor que administra el registro de usuarios.
     */
    public ControladorRegistro(FormularioRegistro vista, GestorUsuario gestor) {
        this.vista = vista;
        this.gestor = gestor;
        this.vista.getBtnRegistrar().addActionListener(this);
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
        if (e.getSource() == vista.getBtnRegistrar()) {
            registrarUsuario();
        }
    }

    /**
     * Recopila los datos del formulario, valida campos obligatorios,
     * intenta registrar un nuevo usuario y muestra mensajes al usuario.
     */
/**
 * registrarUsuario method.
 * @return result
 */
/**
 * registrarUsuario method.
 */
/**
 * registrarUsuario method.
 */
    private void registrarUsuario() {
        String nombre = vista.getNombre();
        String apellido = vista.getApellido();
        String cedula = vista.getCedula();
        String correo = vista.getCorreo();
        String celular = vista.getCelular();
        String nombreUsuario = vista.getNombreUsuario();
        String contrasena = vista.getContrasena();

        if (nombre.isEmpty() || apellido.isEmpty() || cedula.isEmpty() || correo.isEmpty() ||
            celular.isEmpty() || nombreUsuario.isEmpty() || contrasena.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Usuario usuario = new Usuario(nombre, apellido, cedula, correo, celular, nombreUsuario, contrasena) {};

        boolean registrado = gestor.registrarUsuario(usuario);
        if (registrado) {
            JOptionPane.showMessageDialog(vista, "Usuario registrado exitosamente.");
            vista.limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(vista, "El nombre de usuario o la cédula ya están registrados.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

