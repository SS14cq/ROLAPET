package udistrital.avanzada.rolapet.modelo;

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

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return titulo + " - " + descripcion + " ($" + precio + ")";
    }
}
