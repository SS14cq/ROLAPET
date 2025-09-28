package udistrital.avanzada.rolapet.modelo;

/**
 * Class ProveedorInsumo.
 */
/**
 * Class ProveedorInsumo.
 */
public class ProveedorInsumo extends Proveedor {

    public ProveedorInsumo(String nombreUsuario, String contrasena,
                           String nombre, String apellido, String cedula,
                           String correo, String celular) {
        super(nombreUsuario, contrasena, "Insumo", nombre, apellido, cedula, correo, celular);
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
        return "Insumo";
    }
}
