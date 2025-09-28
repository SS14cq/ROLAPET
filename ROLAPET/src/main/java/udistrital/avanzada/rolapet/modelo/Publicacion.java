package udistrital.avanzada.rolapet.modelo;

import java.time.LocalDate;

/**
 * Class Publicacion.
 */
/**
 * Class Publicacion.
 */
public class Publicacion {
    private String id;
    private String titulo;
    private String descripcion;
    private String tipo; // "Evento", "Promoción", etc.
    private Usuario autor;
    private LocalDate fecha;

    public Publicacion(String id, String titulo, String descripcion, String tipo, Usuario autor, LocalDate fecha) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.autor = autor;
        this.fecha = fecha;
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
    public String getId() { return id; }
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
    public String getTitulo() { return titulo; }
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
    public String getDescripcion() { return descripcion; }
/**
 * getTipo method.
 * @return result
 */
/**
 * getTipo method.
 * @return result
 */
/**
 * getTipo method.
 * @return result
 */
    public String getTipo() { return tipo; }
/**
 * getAutor method.
 * @return result
 */
/**
 * getAutor method.
 * @return result
 */
/**
 * getAutor method.
 * @return result
 */
    public Usuario getAutor() { return autor; }
/**
 * getFecha method.
 * @return result
 */
/**
 * getFecha method.
 * @return result
 */
/**
 * getFecha method.
 * @return result
 */
    public LocalDate getFecha() { return fecha; }

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
        return String.format("[%s] %s (%s) - %s\nAutor: %s | Fecha: %s",
                tipo, titulo, id, descripcion,
                autor != null ? autor.getNombreUsuario() : "", fecha != null ? fecha.toString() : "");
    }
}
