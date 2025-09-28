package udistrital.avanzada.rolapet.modelo;

/**
 * Class Item.
 */
/**
 * Class Item.
 */
public class Item {
    private String id;
    private String titulo;
    private String descripcion;
    private double precio;

    public Item(String id, String titulo, String descripcion, double precio) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.precio = precio;
    }

/**
 * getId method.
 * @return result
 */
/**
 * getId method.
 * @return result
 */
/**
 * getId method.
 * @return result
 */
    public String getId() {
        return id;
    }

/**
 * getTitulo method.
 * @return result
 */
/**
 * getTitulo method.
 * @return result
 */
/**
 * getTitulo method.
 * @return result
 */
    public String getTitulo() {
        return titulo;
    }

/**
 * getDescripcion method.
 * @return result
 */
/**
 * getDescripcion method.
 * @return result
 */
/**
 * getDescripcion method.
 * @return result
 */
    public String getDescripcion() {
        return descripcion;
    }

/**
 * getPrecio method.
 * @return result
 */
/**
 * getPrecio method.
 * @return result
 */
/**
 * getPrecio method.
 * @return result
 */
    public double getPrecio() {
        return precio;
    }

    @Override
/**
 * toString method.
 * @return result
 */
/**
 * toString method.
 * @return result
 */
/**
 * toString method.
 * @return result
 */
    public String toString() {
        return titulo + " - " + descripcion + " ($" + precio + ")";
    }
}
