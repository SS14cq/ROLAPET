package udistrital.avanzada.rolapet.constructor;

import udistrital.avanzada.rolapet.modelo.Item;
import udistrital.avanzada.rolapet.modelo.Proveedor;
import udistrital.avanzada.rolapet.vista.VentanaGestionItemsProveedor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Gestor para la ventana de gestión de ítems del proveedor.
 */
/**
 * Class GestorGestionItemsProveedor.
 */
/**
 * Class GestorGestionItemsProveedor.
 */
public class GestorGestionItemsProveedor implements ActionListener {
    private VentanaGestionItemsProveedor vista;
    private Proveedor proveedor;
    private IGestorProveedor gestorProveedor;

    public GestorGestionItemsProveedor(VentanaGestionItemsProveedor vista, Proveedor proveedor, IGestorProveedor gestorProveedor) {
        this.vista = vista;
        this.proveedor = proveedor;
        this.gestorProveedor = gestorProveedor;
        vista.getBtnCrear().addActionListener(this);
        vista.getBtnEditar().addActionListener(this);
        vista.getBtnEliminar().addActionListener(this);
        vista.getBtnCerrar().addActionListener(this);
    }

    @Override
/**
 * actionPerformed method.
 * @param e parameter
 * @return result
 */
/**
 * actionPerformed method.
 * @param e parameter
 */
/**
 * actionPerformed method.
 * @param e parameter
 */
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == vista.getBtnCrear()) {
            String titulo = JOptionPane.showInputDialog(vista, "Título del ítem:");
            if (titulo == null || titulo.trim().isEmpty()) return;
            String descripcion = JOptionPane.showInputDialog(vista, "Descripción del ítem:");
            if (descripcion == null || descripcion.trim().isEmpty()) return;
            String precioStr = JOptionPane.showInputDialog(vista, "Precio del ítem:");
            double precio;
            try { precio = Double.parseDouble(precioStr); } catch (Exception ex) { return; }
            String idItem = "ITM-" + (proveedor.getItems().size() + 1);
            Item nuevo = new Item(idItem, titulo, descripcion, precio);
            gestorProveedor.crearItem(proveedor, nuevo);
            vista.cargarItems(proveedor.getItems());
        } else if (source == vista.getBtnEditar()) {
            int row = vista.getTablaItems().getSelectedRow();
            if (row == -1) return;
            Item item = proveedor.getItems().get(row);
            String titulo = JOptionPane.showInputDialog(vista, "Nuevo título:", item.getTitulo());
            if (titulo == null || titulo.trim().isEmpty()) return;
            String descripcion = JOptionPane.showInputDialog(vista, "Nueva descripción:", item.getDescripcion());
            if (descripcion == null || descripcion.trim().isEmpty()) return;
            String precioStr = JOptionPane.showInputDialog(vista, "Nuevo precio:", String.valueOf(item.getPrecio()));
            double precio;
            try { precio = Double.parseDouble(precioStr); } catch (Exception ex) { return; }
            Item editado = new Item(item.getId(), titulo, descripcion, precio);
            gestorProveedor.actualizarItem(proveedor, editado);
            vista.cargarItems(proveedor.getItems());
        } else if (source == vista.getBtnEliminar()) {
            int row = vista.getTablaItems().getSelectedRow();
            if (row == -1) return;
            Item item = proveedor.getItems().get(row);
            gestorProveedor.eliminarItem(proveedor, item);
            vista.cargarItems(proveedor.getItems());
        } else if (source == vista.getBtnCerrar()) {
            vista.dispose();
        }
    }
}
