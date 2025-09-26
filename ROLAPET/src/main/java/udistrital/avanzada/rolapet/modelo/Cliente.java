package udistrital.avanzada.rolapet.modelo;

/**
 * Clase Cliente que extiende Usuario.
 * Representa un usuario cliente del sistema con sus datos personales y de acceso.
 * Hereda todos los atributos y métodos de la clase Usuario.
 * 
 * @author Sarita
 * @version 1.1, 25-09-2025
 */
public class Cliente extends Usuario {

    /**
     * Constructor que crea un nuevo cliente con la información proporcionada.
     * 
     * @param nombreUsuario nombre de usuario único para autenticación
     * @param contrasena contraseña del cliente
     * @param nombre nombre propio del cliente
     * @param apellido apellido del cliente
     * @param cedula número de cédula o documento de identificación
     * @param correo correo electrónico de contacto
     * @param celular número de teléfono celular
     */
    public Cliente(String nombreUsuario, String contrasena, String nombre, String apellido,
                   String cedula, String correo, String celular) {
        super(nombreUsuario, contrasena, nombre, apellido, cedula, correo, celular);
    }

}
