package udistrital.avanzada.rolapet.modelo;

public class ProveedorInsumo extends Proveedor {

    public ProveedorInsumo(String nombreUsuario, String contrasena,
                           String nombre, String apellido, String cedula,
                           String correo, String celular) {
        super(nombreUsuario, contrasena, "Insumo", nombre, apellido, cedula, correo, celular);
    }

    @Override
    public String getTipoProveedor() {
        return "Insumo";
    }
}
