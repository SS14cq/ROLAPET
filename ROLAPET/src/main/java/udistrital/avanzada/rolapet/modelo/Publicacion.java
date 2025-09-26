package udistrital.avanzada.rolapet.modelo;

public class Publicacion {
    private String id;
    private String titulo;
    private String descripcion;

    public Publicacion(String id, String titulo, String descripcion) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return titulo + " - " + descripcion;
    }
}

