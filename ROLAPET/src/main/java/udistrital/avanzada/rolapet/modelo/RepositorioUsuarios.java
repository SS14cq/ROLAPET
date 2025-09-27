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
public class RepositorioUsuarios {
    private List<Usuario> usuarios;

    public RepositorioUsuarios() {
        usuarios = new ArrayList<>();
    }

    /**
     * Agrega un usuario al repositorio.
     */
    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    /**
     * Elimina un usuario del repositorio.
     */
    public void eliminarUsuario(Usuario usuario) {
        usuarios.remove(usuario);
    }

    /**
     * Busca un usuario por nombre de usuario (email).
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
    public List<Usuario> listarUsuarios() {
        return new ArrayList<>(usuarios);
    }
}
