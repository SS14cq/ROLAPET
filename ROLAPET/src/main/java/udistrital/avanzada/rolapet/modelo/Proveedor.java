package udistrital.avanzada.rolapet.modelo;

import java.util.List;
import java.util.ArrayList;

/**
 * Clase abstracta que representa a un proveedor dentro del sistema ROLAPET.
 */
public abstract class Proveedor extends Persona {

    private List<Item> items;
    private List<Publicacion> publicaciones;

    public Proveedor(String nombre, String apellido, String cedula, String correo, String celular) {
        super(nombre, apellido, cedula, correo, celular);
        this.items = new ArrayList<>();
        this.publicaciones = new ArrayList<>();
    }

    // --- Métodos de gestión de Items ---
    public void agregarItem(Item item) {
        if (item != null) {
            items.add(item);
        }
    }

    public void eliminarItem(String itemId) {
        if (itemId != null) {
            items.removeIf(i -> i.getId().equals(itemId));
        }
    }

    public List<Item> getItems() {
        return new ArrayList<>(items);
    }

    // --- Métodos de gestión de Publicaciones ---
    public void publicar(Publicacion pub) {
        if (pub != null) {
            publicaciones.add(pub);
        }
    }

    public List<Publicacion> getPublicaciones() {
        return new ArrayList<>(publicaciones);
    }

    // --- Método abstracto para subclases ---
    public abstract String getTipoProveedor();
}
