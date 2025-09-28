package udistrital.avanzada.rolapet.modelo;

import java.util.ArrayList;
import java.util.List;

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

    public String getTipoProveedor() {
        return tipoProveedor;
    }

    public List<Publicacion> getPublicaciones() {
        return publicaciones;
    }

    public List<Item> getItems() {
        return items;
    }

    public void agregarPublicacion(Publicacion publicacion) {
        publicaciones.add(publicacion);
    }

    public void agregarItem(Item item) {
        items.add(item);
    }
}
