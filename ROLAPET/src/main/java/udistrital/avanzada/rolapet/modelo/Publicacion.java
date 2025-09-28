package udistrital.avanzada.rolapet.modelo;

import java.time.LocalDate;

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

    public String getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getDescripcion() { return descripcion; }
    public String getTipo() { return tipo; }
    public Usuario getAutor() { return autor; }
    public LocalDate getFecha() { return fecha; }

    @Override
    public String toString() {
        return String.format("[%s] %s (%s) - %s\nAutor: %s | Fecha: %s",
                tipo, titulo, id, descripcion,
                autor != null ? autor.getNombreUsuario() : "", fecha != null ? fecha.toString() : "");
    }
}
