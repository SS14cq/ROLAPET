package udistrital.avanzada.rolapet.constructor;

import udistrital.avanzada.rolapet.modelo.Publicacion;
import udistrital.avanzada.rolapet.modelo.Proveedor;
import java.util.List;

/**
 * Contrato para la gestión de publicaciones (eventos, promociones, etc.).
 */
public interface IGestorPublicacion {
    boolean crearPublicacion(Proveedor proveedor, Publicacion publicacion);
    boolean actualizarPublicacion(Proveedor proveedor, Publicacion publicacion);
    boolean eliminarPublicacion(Proveedor proveedor, Publicacion publicacion);
    List<Publicacion> listarPublicaciones(Proveedor proveedor);
    List<Publicacion> listarTodasPublicaciones();
}
