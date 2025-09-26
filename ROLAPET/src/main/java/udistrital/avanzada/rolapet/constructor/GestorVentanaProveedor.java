/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.avanzada.rolapet.constructor;

import udistrital.avanzada.rolapet.vista.VentanaProveedor;
import udistrital.avanzada.rolapet.modelo.Proveedor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import udistrital.avanzada.rolapet.modelo.Item;

/**
 * Controlador para manejar las acciones de la ventana de proveedor.
 */
public class GestorVentanaProveedor implements ActionListener {

    private VentanaProveedor vista;
    private Proveedor proveedor;

    public GestorVentanaProveedor(VentanaProveedor vista, Proveedor proveedor) {
        this.vista = vista;
        this.proveedor = proveedor;

        this.vista.setControlador(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == vista.getBtnVerPublicaciones()) {
            // Mostrar publicaciones del proveedor
            StringBuilder sb = new StringBuilder(" Publicaciones de " + proveedor.getNombre() + ":\n\n");
            if (proveedor.getPublicaciones().isEmpty()) {
                sb.append("️ No tienes publicaciones todavía.");
            } else {
                proveedor.getPublicaciones().forEach(pub ->
                        sb.append("- ").append(pub.getTitulo()).append("\n")
                );
            }
            JOptionPane.showMessageDialog(vista, sb.toString(),
                    "Mis publicaciones", JOptionPane.INFORMATION_MESSAGE);

        
        } else if (source == vista.getBtnCerrarSesion()) {
            JOptionPane.showMessageDialog(vista,
                    "Sesión cerrada correctamente.",
                    "Cerrar sesión", JOptionPane.INFORMATION_MESSAGE);
            vista.dispose();
        }else if (source == vista.getBtnAgregarItem()) {
    String titulo = JOptionPane.showInputDialog(vista, "Ingrese el título del ítem:");
    if (titulo == null || titulo.trim().isEmpty()) return;

    String descripcion = JOptionPane.showInputDialog(vista, "Ingrese la descripción del ítem:");
    if (descripcion == null || descripcion.trim().isEmpty()) return;

    String precioStr = JOptionPane.showInputDialog(vista, "Ingrese el precio del ítem:");
    double precio = 0.0;
    try {
        precio = Double.parseDouble(precioStr);
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(vista,
                "⚠️ Precio inválido. El ítem no se agregó.",
                "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    String idItem = "ITM-" + (proveedor.getItems().size() + 1);
    Item nuevoItem = new Item(idItem, titulo, descripcion, precio);
    proveedor.agregarItem(nuevoItem);

    JOptionPane.showMessageDialog(vista,
            "✅ Ítem agregado: " + nuevoItem,
            "Nuevo ítem", JOptionPane.INFORMATION_MESSAGE);
}

    }
}
