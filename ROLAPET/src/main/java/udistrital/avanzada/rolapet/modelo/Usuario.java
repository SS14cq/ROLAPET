package udistrital.avanzada.rolapet.modelo;

/**
 * Clase abstracta Usuario que extiende Persona.
 * Representa un usuario del sistema que tiene credenciales para autenticación,
 * incluyendo nombre de usuario y contraseña.
 * Esta clase debe ser extendida por tipos concretos de usuarios, como Cliente.
 * 
 * @author Sarita
 * @version 1.1, 25-09-2025
 */
import java.util.ArrayList;
import java.util.List;

/**
 * Class Usuario.
 */
/**
 * Class Usuario.
 */
public abstract class Usuario extends Persona {
    private List<Vehiculo> vehiculos = new ArrayList<>();

    /**
     * Devuelve la lista de vehículos registrados por el usuario.
     */
/**
 * getVehiculos method.
 * @return result
 */
/**
 * getVehiculos method.
 * @return result
 */
/**
 * getVehiculos method.
 * @return result
 */
    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    /**
     * Agrega un vehículo al usuario.
     */
/**
 * agregarVehiculo method.
 * @param vehiculo parameter
 * @return result
 */
/**
 * agregarVehiculo method.
 * @param vehiculo parameter
 */
/**
 * agregarVehiculo method.
 * @param vehiculo parameter
 */
    public void agregarVehiculo(Vehiculo vehiculo) {
        if (vehiculo != null && !vehiculos.contains(vehiculo)) {
            vehiculos.add(vehiculo);
        }
    }
    private String nombreUsuario;
    private String contrasena;
    private List<Usuario> amigos = new ArrayList<>();
    /**
     * Devuelve la lista de amigos del usuario.
     */
/**
 * getAmigos method.
 * @return result
 */
/**
 * getAmigos method.
 * @return result
 */
/**
 * getAmigos method.
 * @return result
 */
    public List<Usuario> getAmigos() {
        return amigos;
    }

    /**
     * Agrega un amigo al usuario si no está ya en la lista.
     */
/**
 * agregarAmigo method.
 * @param amigo parameter
 * @return result
 */
/**
 * agregarAmigo method.
 * @param amigo parameter
 * @return result
 */
/**
 * agregarAmigo method.
 * @param amigo parameter
 * @return result
 */
    public boolean agregarAmigo(Usuario amigo) {
        if (amigo != null && !amigos.contains(amigo) && !amigo.equals(this)) {
            amigos.add(amigo);
            return true;
        }
        return false;
    }

    /**
     * Constructor que crea un usuario con sus credenciales y datos personales.
     * 
     * @param nombreUsuario nombre de usuario para autenticación
     * @param contrasena contraseña del usuario
     * @param nombre nombre de la persona
     * @param apellido apellido de la persona
     * @param cedula número de cédula o identificación
     * @param correo correo electrónico
     * @param celular número de celular
     */
    public Usuario(String nombreUsuario, String contrasena, String nombre, String apellido, String cedula, String correo, String celular) {
        super(nombre, apellido, cedula, correo, celular);
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }

    /**
     * Devuelve el nombre de usuario.
     * @return nombre de usuario
     */
/**
 * getNombreUsuario method.
 * @return result
 */
/**
 * getNombreUsuario method.
 * @return result
 */
/**
 * getNombreUsuario method.
 * @return result
 */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * Establece el nombre de usuario.
     * @param nombreUsuario nombre de usuario a asignar
     */
/**
 * setNombreUsuario method.
 * @param nombreUsuario parameter
 * @return result
 */
/**
 * setNombreUsuario method.
 * @param nombreUsuario parameter
 */
/**
 * setNombreUsuario method.
 * @param nombreUsuario parameter
 */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * Devuelve la contraseña del usuario.
     * @return contraseña
     */
/**
 * getContrasena method.
 * @return result
 */
/**
 * getContrasena method.
 * @return result
 */
/**
 * getContrasena method.
 * @return result
 */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Establece la contraseña del usuario.
     * @param contrasena contraseña a asignar
     */
/**
 * setContrasena method.
 * @param contrasena parameter
 * @return result
 */
/**
 * setContrasena method.
 * @param contrasena parameter
 */
/**
 * setContrasena method.
 * @param contrasena parameter
 */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
