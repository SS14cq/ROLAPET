package udistrital.avanzada.rolapet.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Repositorio para almacenar y gestionar publicaciones (eventos/promociones).
 * @author Sarita
 * @version 1.0, 27-09-2025
 */
public class RepositorioPublicaciones {
    private List<Publicacion> publicaciones;

    public RepositorioPublicaciones() {
        publicaciones = new ArrayList<>();
    }

    /**
     * Agrega una publicación al repositorio.
     */
    public void agregarPublicacion(Publicacion publicacion) {
        publicaciones.add(publicacion);
    }

    /**
     * Devuelve la lista de todas las publicaciones.
     */
    public List<Publicacion> listarPublicaciones() {
        return new ArrayList<>(publicaciones);
    }
}
