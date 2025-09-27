package udistrital.avanzada.rolapet.modelo;

public class ProveedorServicio extends Proveedor {

    private String contrasena;

    public ProveedorServicio(String nombre, String apellido, String cedula,
                             String correo, String celular, String contrasena) {
        super(nombre, apellido, cedula, correo, celular);
        this.contrasena = contrasena;
    }

    public String getContrasena() {
        return contrasena;
    }

    @Override
    public String getTipoProveedor() {
        return "Servicio";
    }
}
