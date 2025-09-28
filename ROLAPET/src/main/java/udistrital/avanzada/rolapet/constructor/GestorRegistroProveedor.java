package udistrital.avanzada.rolapet.constructor;

import udistrital.avanzada.rolapet.modelo.Proveedor;
import udistrital.avanzada.rolapet.modelo.ProveedorInsumo;
import udistrital.avanzada.rolapet.modelo.ProveedorServicio;

import java.util.ArrayList;
import java.util.List;

public class GestorRegistroProveedor {

    private List<Proveedor> proveedores;

    public GestorRegistroProveedor() {
        this.proveedores = new ArrayList<>();
    }

    public void registrarProveedorInsumo(String nombreUsuario, String contrasena,
                                         String nombre, String apellido, String cedula,
                                         String correo, String celular) {
        ProveedorInsumo proveedor = new ProveedorInsumo(nombreUsuario, contrasena, nombre,
                apellido, cedula, correo, celular);
        proveedores.add(proveedor);
        System.out.println("Proveedor de Insumo registrado: " + proveedor.getNombre());
    }

    public void registrarProveedorServicio(String nombreUsuario, String contrasena,
                                           String nombre, String apellido, String cedula,
                                           String correo, String celular) {
        ProveedorServicio proveedor = new ProveedorServicio(nombreUsuario, contrasena, nombre,
                apellido, cedula, correo, celular);
        proveedores.add(proveedor);
        System.out.println("Proveedor de Servicio registrado: " + proveedor.getNombre());
    }

    /**
     * Busca y retorna un proveedor que coincida con el correo, la contraseña y el tipo provistos.
     * 
     * @param correo correo electrónico del proveedor
     * @param contrasena contraseña del proveedor
     * @param tipo tipo de proveedor ("Servicio", "Insumo", etc.)
     * @return el proveedor encontrado o null si no existe coincidencia
     */
    public Proveedor iniciarSesion(String correo, String contrasena, String tipo) {
        for (Proveedor proveedor : proveedores) {
            if (proveedor.getCorreo().equalsIgnoreCase(correo)
                    && proveedor.getContrasena().equals(contrasena)
                    && proveedor.getTipoProveedor().equalsIgnoreCase(tipo)) {
                return proveedor;
            }
        }
        return null;
    }

    public List<Proveedor> getProveedores() {
        return proveedores;
    }
}
