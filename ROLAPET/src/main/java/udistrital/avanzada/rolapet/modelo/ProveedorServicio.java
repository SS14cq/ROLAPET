package udistrital.avanzada.rolapet.modelo;

public class ProveedorServicio extends Proveedor {

    public ProveedorServicio(String nombreUsuario, String contrasena,
                             String nombre, String apellido, String cedula,
                             String correo, String celular) {
        super(nombreUsuario, contrasena, "Servicio", nombre, apellido, cedula, correo, celular);
    }

    @Override
    public String getTipoProveedor() {
        return "Servicio";
    }
}
