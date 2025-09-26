package udistrital.avanzada.rolapet.constructor;

import java.util.ArrayList;
import java.util.List;
import udistrital.avanzada.rolapet.modelo.Usuario;

/**
 * Clase ControladorUsuario.
 * Gestiona el registro y la búsqueda de usuarios en una lista interna.
 * Permite registrar nuevos usuarios evitando duplicados por nombre de usuario o cédula,
 * así como buscar usuarios por nombre de usuario o cédula.
 * 
 * @author sarita
 * @version 1.3, 25-09-2025
 */
public class ControladorUsuario {

    /**
     * Lista que almacena los usuarios registrados.
     */
    private List<Usuario> usuarios;

    /**
     * Constructor de ControladorUsuario.
     * Inicializa la lista interna de usuarios.
     */
    public ControladorUsuario() {
        usuarios = new ArrayList<>();
    }

    /**
     * Registra un nuevo usuario si no existe otro con el mismo nombre de usuario o cédula.
     * 
     * @param usuario Usuario a registrar.
     * @return true si el usuario se registró correctamente; false si ya existe por nombre o cédula.
     */
    public boolean registrarUsuario(Usuario usuario) {
        if (buscarPorNombreUsuario(usuario.getNombreUsuario()) != null) {
            return false; // Ya existe usuario con ese nombre
        }
        if (buscarPorCedula(usuario.getCedula()) != null) {
            return false; // Ya existe usuario con esa cédula
        }
        usuarios.add(usuario);
        return true;
    }

    /**
     * Busca un usuario por su nombre de usuario (ignorando mayúsculas/minúsculas).
     * 
     * @param nombreUsuario Nombre de usuario a buscar.
     * @return Usuario encontrado o null si no existe.
     */
    public Usuario buscarPorNombreUsuario(String nombreUsuario) {
        for (Usuario u : usuarios) {
            if (u.getNombreUsuario().equalsIgnoreCase(nombreUsuario)) {
                return u;
            }
        }
        return null;
    }

    /**
     * Busca un usuario por su cédula (ignorando mayúsculas/minúsculas).
     * 
     * @param cedula Cédula a buscar.
     * @return Usuario encontrado o null si no existe.
     */
    public Usuario buscarPorCedula(String cedula) {
        for (Usuario u : usuarios) {
            if (u.getCedula().equalsIgnoreCase(cedula)) {
                return u;
            }
        }
        return null;
    }

    /**
     * Obtiene la lista completa de usuarios registrados.
     * 
     * @return Lista de usuarios.
     */
    public List<Usuario> obtenerUsuarios() {
        return usuarios;
    }
}
