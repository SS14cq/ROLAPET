package udistrital.avanzada.rolapet.modelo;

/**
 * Clase Cliente que extiende Usuario.
 * Representa un usuario cliente del sistema.
 */
public class Cliente extends Usuario {

    public Cliente(String nombreUsuario, String contrasena, String nombre, String apellido,
                   String cedula, String correo, String celular) {
        super(nombreUsuario, contrasena, nombre, apellido, cedula, correo, celular);
    }

}
