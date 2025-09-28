/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.avanzada.rolapet.constructor;

import java.util.ArrayList;
import java.util.List;
import udistrital.avanzada.rolapet.modelo.Usuario;

/**
 * Clase responsable de gestionar el registro y almacenamiento de usuarios.
 * Permite registrar usuarios asegurando unicidad de nombre de usuario y cédula,
 * buscar usuarios y obtener la lista completa de usuarios registrados.
 * 
 * @author sarita
 * @version 1.0, 21-09-2025
 */
/**
 * Class GestorUsuario.
 */
/**
 * Class GestorUsuario.
 */
public class GestorUsuario {
    private List<Usuario> usuarios;

    /**
     * Crea un gestor vacío sin usuarios.
     */
    public GestorUsuario() {
        usuarios = new ArrayList<>();
    }

    /**
     * Registra un nuevo usuario si no existe otro con el mismo nombre de usuario o cédula.
     * @param usuario Usuario a registrar
     * @return true si se registró correctamente, false si ya existe
     */
/**
 * registrarUsuario method.
 * @param usuario parameter
 * @return result
 */
/**
 * registrarUsuario method.
 * @param usuario parameter
 * @return result
 */
/**
 * registrarUsuario method.
 * @param usuario parameter
 * @return result
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
     * Busca un usuario por nombre de usuario.
     * @param nombreUsuario Nombre de usuario
     * @return Usuario encontrado o null
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
     * Busca un usuario por cédula.
     * @param cedula Cédula
     * @return Usuario encontrado o null
     */
/**
 * buscarPorCedula method.
 * @param cedula parameter
 * @return result
 */
/**
 * buscarPorCedula method.
 * @param cedula parameter
 * @return result
 */
/**
 * buscarPorCedula method.
 * @param cedula parameter
 * @return result
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
     * Obtiene la lista de usuarios registrados.
     * @return Lista de usuarios
     */
/**
 * obtenerUsuarios method.
 * @return result
 */
/**
 * obtenerUsuarios method.
 * @return result
 */
/**
 * obtenerUsuarios method.
 * @return result
 */
    public List<Usuario> obtenerUsuarios() {
        return usuarios;
    }
}

