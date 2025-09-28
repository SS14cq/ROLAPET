package udistrital.avanzada.rolapet.constructor;

import udistrital.avanzada.rolapet.modelo.Item;
import udistrital.avanzada.rolapet.modelo.Proveedor;
import java.util.List;

/**
 * Contrato para la gestión de proveedores y sus ítems.
 */
/**
 * Interface IGestorProveedor.
 */
/**
 * Interface IGestorProveedor.
 */
public interface IGestorProveedor {
    boolean crearItem(Proveedor proveedor, Item item);
    boolean actualizarItem(Proveedor proveedor, Item item);
    boolean eliminarItem(Proveedor proveedor, Item item);
    List<Item> listarItems(Proveedor proveedor);
    List<Proveedor> listarProveedores();
}
