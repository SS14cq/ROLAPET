package udistrital.avanzada.rolapet.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Repositorio genérico para almacenar y gestionar usuarios de cualquier tipo.
 * Permite agregar, buscar, eliminar y listar usuarios.
 * Compatible con Cliente, Proveedor, Administrador, etc.
 * 
 * @author Sarita
 * @version 1.0, 27-09-2025
 */
/**
 * Class RepositorioUsuarios.
 */
/**
 * Class RepositorioUsuarios.
 */
public class RepositorioUsuarios {
    private List<Usuario> usuarios;

    public RepositorioUsuarios() {
        usuarios = new ArrayList<>();
    }

    /**
     * Agrega un usuario al repositorio.
     */
/**
 * agregarUsuario method.
 * @param usuario parameter
 * @return result
 */
/**
 * agregarUsuario method.
 * @param usuario parameter
 */
/**
 * agregarUsuario method.
 * @param usuario parameter
 */
    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    /**
     * Elimina un usuario del repositorio.
     */
/**
 * eliminarUsuario method.
 * @param usuario parameter
 * @return result
 */
/**
 * eliminarUsuario method.
 * @param usuario parameter
 */
/**
 * eliminarUsuario method.
 * @param usuario parameter
 */
    public void eliminarUsuario(Usuario usuario) {
        usuarios.remove(usuario);
    }

    /**
     * Busca un usuario por nombre de usuario (email).
     */
/**
 * buscarPorNombreUsuario method.
 * @param nombreUsuario parameter
 * @return result
 */
/**
 * buscarPorNombreUsuario method.
 * @param nombreUsuario parameter
 * @return result
 */
/**
 * buscarPorNombreUsuario method.
 * @param nombreUsuario parameter
 * @return result
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
     * Devuelve la lista de todos los usuarios.
     */
/**
 * listarUsuarios method.
 * @return result
 */
/**
 * listarUsuarios method.
 * @return result
 */
/**
 * listarUsuarios method.
 * @return result
 */
    public List<Usuario> listarUsuarios() {
        return new ArrayList<>(usuarios);
    }
}
