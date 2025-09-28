package udistrital.avanzada.rolapet.vista;

import udistrital.avanzada.rolapet.modelo.Item;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

/**
 * Ventana para que el proveedor gestione sus ítems (servicios/insumos).
 */
/**
 * Class VentanaGestionItemsProveedor.
 */
/**
 * Class VentanaGestionItemsProveedor.
 */
public class VentanaGestionItemsProveedor extends JFrame {
    private JTable tablaItems;
    private DefaultTableModel modeloTabla;
    private JButton btnCrear;
    private JButton btnEditar;
    private JButton btnEliminar;
    private JButton btnCerrar;

    public VentanaGestionItemsProveedor(List<Item> items) {
        setTitle("Gestión de Ítems del Proveedor");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        modeloTabla = new DefaultTableModel(new Object[]{"ID", "Título", "Descripción", "Precio"}, 0);
        tablaItems = new JTable(modeloTabla);
        JScrollPane scroll = new JScrollPane(tablaItems);
        add(scroll, BorderLayout.CENTER);

        btnCrear = new JButton("Crear ítem");
        btnEditar = new JButton("Editar ítem");
        btnEliminar = new JButton("Eliminar ítem");
        btnCerrar = new JButton("Cerrar");

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnCrear);
        panelBotones.add(btnEditar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnCerrar);
        add(panelBotones, BorderLayout.SOUTH);

        cargarItems(items);
    }

/**
 * cargarItems method.
 * @param items parameter
 * @return result
 */
/**
 * cargarItems method.
 * @param items parameter
 */
/**
 * cargarItems method.
 * @param items parameter
 */
    public void cargarItems(List<Item> items) {
        modeloTabla.setRowCount(0);
        for (Item item : items) {
            modeloTabla.addRow(new Object[]{item.getId(), item.getTitulo(), item.getDescripcion(), item.getPrecio()});
        }
    }

/**
 * getTablaItems method.
 * @return result
 */
/**
 * getTablaItems method.
 * @return result
 */
/**
 * getTablaItems method.
 * @return result
 */
    public JTable getTablaItems() { return tablaItems; }
/**
 * getBtnCrear method.
 * @return result
 */
/**
 * getBtnCrear method.
 * @return result
 */
/**
 * getBtnCrear method.
 * @return result
 */
    public JButton getBtnCrear() { return btnCrear; }
/**
 * getBtnEditar method.
 * @return result
 */
/**
 * getBtnEditar method.
 * @return result
 */
/**
 * getBtnEditar method.
 * @return result
 */
    public JButton getBtnEditar() { return btnEditar; }
/**
 * getBtnEliminar method.
 * @return result
 */
/**
 * getBtnEliminar method.
 * @return result
 */
/**
 * getBtnEliminar method.
 * @return result
 */
    public JButton getBtnEliminar() { return btnEliminar; }
/**
 * getBtnCerrar method.
 * @return result
 */
/**
 * getBtnCerrar method.
 * @return result
 */
/**
 * getBtnCerrar method.
 * @return result
 */
    public JButton getBtnCerrar() { return btnCerrar; }
}
