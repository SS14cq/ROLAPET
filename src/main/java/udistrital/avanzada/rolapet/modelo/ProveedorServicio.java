package udistrital.avanzada.rolapet.modelo;

/**
 * Class ProveedorServicio.
 */
/**
 * Class ProveedorServicio.
 */
public class ProveedorServicio extends Proveedor {

    public ProveedorServicio(String nombreUsuario, String contrasena,
                             String nombre, String apellido, String cedula,
                             String correo, String celular) {
        super(nombreUsuario, contrasena, "Servicio", nombre, apellido, cedula, correo, celular);
    }

    @Override
/**
 * getTipoProveedor method.
 * @return result
 */
/**
 * getTipoProveedor method.
 * @return result
 */
/**
 * getTipoProveedor method.
 * @return result
 */
    public String getTipoProveedor() {
        return "Servicio";
    }
}
