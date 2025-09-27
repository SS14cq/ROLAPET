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

    public void registrarProveedorInsumo(String nombre, String apellido, String cedula,
                                         String correo, String celular, String contrasena) {
        ProveedorInsumo proveedor = new ProveedorInsumo(nombre, apellido, cedula, correo, celular, contrasena);
        proveedores.add(proveedor);
        System.out.println("Proveedor de Insumo registrado: " + proveedor.getNombre());
    }

    public void registrarProveedorServicio(String nombre, String apellido, String cedula,
                                           String correo, String celular, String contrasena) {
        ProveedorServicio proveedor = new ProveedorServicio(nombre, apellido, cedula, correo, celular, contrasena);
        proveedores.add(proveedor);
        System.out.println("Proveedor de Servicio registrado: " + proveedor.getNombre());
    }

    public List<Proveedor> getProveedores() {
        return proveedores;
    }
}
