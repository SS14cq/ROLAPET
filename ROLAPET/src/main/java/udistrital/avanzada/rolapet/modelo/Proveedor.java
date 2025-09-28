package udistrital.avanzada.rolapet.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Proveedor.
 */
/**
 * Class Proveedor.
 */
public class Proveedor extends Usuario {
    private String tipoProveedor;

    private List<Publicacion> publicaciones;
    private List<Item> items;

    public Proveedor(String nombreUsuario, String contrasena, String tipoProveedor,
                     String nombre, String apellido, String cedula,
                     String correo, String celular) {
        super(nombreUsuario, contrasena, nombre, apellido, cedula, correo, celular);
        this.tipoProveedor = tipoProveedor;
        this.publicaciones = new ArrayList<>();
        this.items = new ArrayList<>();
    }

/**
 * getTipoProveedor method.
 * @return result
 */
/**
 * getTipoProveedor method.
 * @return result
 */
/**
 * getTipoProveedor method.
 * @return result
 */
    public String getTipoProveedor() {
        return tipoProveedor;
    }

/**
 * getPublicaciones method.
 * @return result
 */
/**
 * getPublicaciones method.
 * @return result
 */
/**
 * getPublicaciones method.
 * @return result
 */
    public List<Publicacion> getPublicaciones() {
        return publicaciones;
    }

/**
 * getItems method.
 * @return result
 */
/**
 * getItems method.
 * @return result
 */
/**
 * getItems method.
 * @return result
 */
    public List<Item> getItems() {
        return items;
    }

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
 * agregarItem method.
 * @param item parameter
 * @return result
 */
/**
 * agregarItem method.
 * @param item parameter
 */
/**
 * agregarItem method.
 * @param item parameter
 */
    public void agregarItem(Item item) {
        items.add(item);
    }
}
