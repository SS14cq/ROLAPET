package udistrital.avanzada.rolapet.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Repositorio para almacenar y gestionar publicaciones (eventos/promociones).
 * @author Sarita
 * @version 1.0, 27-09-2025
 */
/**
 * Class RepositorioPublicaciones.
 */
/**
 * Class RepositorioPublicaciones.
 */
public class RepositorioPublicaciones {
    private List<Publicacion> publicaciones;

    public RepositorioPublicaciones() {
        publicaciones = new ArrayList<>();
    }

    /**
     * Agrega una publicación al repositorio.
     */
/**
 * agregarPublicacion method.
 * @param publicacion parameter
 * @return result
 */
/**
 * agregarPublicacion method.
 * @param publicacion parameter
 */
/**
 * agregarPublicacion method.
 * @param publicacion parameter
 */
    public void agregarPublicacion(Publicacion publicacion) {
        publicaciones.add(publicacion);
    }

    /**
     * Devuelve la lista de todas las publicaciones.
     */
/**
 * listarPublicaciones method.
 * @return result
 */
/**
 * listarPublicaciones method.
 * @return result
 */
/**
 * listarPublicaciones method.
 * @return result
 */
    public List<Publicacion> listarPublicaciones() {
        return new ArrayList<>(publicaciones);
    }
}
