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
import udistrital.avanzada.rolapet.modelo.RepositorioPublicaciones;
import udistrital.avanzada.rolapet.vista.VentanaCrearPublicacion;

/**
 * Controlador para manejar las acciones de la ventana de proveedor.
 */
import udistrital.avanzada.rolapet.constructor.IGestorProveedor;
import udistrital.avanzada.rolapet.constructor.IGestorPublicacion;

public class GestorVentanaProveedor implements ActionListener, IGestorProveedor, IGestorPublicacion {
    // Implementación de IGestorProveedor
    @Override
    public boolean crearItem(Proveedor proveedor, Item item) {
        if (proveedor != null && item != null) {
            proveedor.agregarItem(item);
            return true;
        }
        return false;
    }

    @Override
    public boolean actualizarItem(Proveedor proveedor, Item item) {
        // Ejemplo simple: busca por id y reemplaza
        for (int i = 0; i < proveedor.getItems().size(); i++) {
            if (proveedor.getItems().get(i).getId().equals(item.getId())) {
                proveedor.getItems().set(i, item);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean eliminarItem(Proveedor proveedor, Item item) {
        return proveedor.getItems().remove(item);
    }

    @Override
    public java.util.List<Item> listarItems(Proveedor proveedor) {
        return proveedor.getItems();
    }

    @Override
    public java.util.List<Proveedor> listarProveedores() {
        // Aquí podrías acceder a un repositorio global de proveedores
        java.util.List<Proveedor> lista = new java.util.ArrayList<>();
        lista.add(proveedor);
        return lista;
    }

    // Implementación de IGestorPublicacion
    @Override
    public boolean crearPublicacion(Proveedor proveedor, udistrital.avanzada.rolapet.modelo.Publicacion publicacion) {
        if (proveedor != null && publicacion != null) {
            proveedor.agregarPublicacion(publicacion);
            repoPublicaciones.agregarPublicacion(publicacion);
            return true;
        }
        return false;
    }

    @Override
    public boolean actualizarPublicacion(Proveedor proveedor, udistrital.avanzada.rolapet.modelo.Publicacion publicacion) {
        // Ejemplo simple: busca por título y reemplaza
        for (int i = 0; i < proveedor.getPublicaciones().size(); i++) {
            if (proveedor.getPublicaciones().get(i).getTitulo().equals(publicacion.getTitulo())) {
                proveedor.getPublicaciones().set(i, publicacion);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean eliminarPublicacion(Proveedor proveedor, udistrital.avanzada.rolapet.modelo.Publicacion publicacion) {
        proveedor.getPublicaciones().remove(publicacion);
        return repoPublicaciones.listarPublicaciones().remove(publicacion);
    }

    @Override
    public java.util.List<udistrital.avanzada.rolapet.modelo.Publicacion> listarPublicaciones(Proveedor proveedor) {
        return proveedor.getPublicaciones();
    }

    @Override
    public java.util.List<udistrital.avanzada.rolapet.modelo.Publicacion> listarTodasPublicaciones() {
        return repoPublicaciones.listarPublicaciones();
    }

    private VentanaProveedor vista;
    private Proveedor proveedor;

    private RepositorioPublicaciones repoPublicaciones;

    public GestorVentanaProveedor(VentanaProveedor vista, Proveedor proveedor, RepositorioPublicaciones repoPublicaciones) {
        this.vista = vista;
        this.proveedor = proveedor;
        this.repoPublicaciones = repoPublicaciones;
        this.vista.setControlador(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == vista.getBtnVerPublicaciones()) {
            udistrital.avanzada.rolapet.vista.VentanaGestionPublicacionesProveedor ventanaPubs = new udistrital.avanzada.rolapet.vista.VentanaGestionPublicacionesProveedor(proveedor.getPublicaciones());
            new GestorGestionPublicacionesProveedor(ventanaPubs, proveedor, this);
            ventanaPubs.setVisible(true);

        
        } else if (source == vista.getBtnCrearPublicacion()) {
            // Abrir ventana para crear publicación
            new VentanaCrearPublicacion(proveedor, repoPublicaciones).setVisible(true);

    } else if (source == vista.getBtnCerrarSesion()) {
        JOptionPane.showMessageDialog(vista,
            "Sesión cerrada correctamente.",
            "Cerrar sesión", JOptionPane.INFORMATION_MESSAGE);
        vista.dispose();
        udistrital.avanzada.rolapet.vista.VentanaInicio ventanaInicio = new udistrital.avanzada.rolapet.vista.VentanaInicio();
        new GestorVentanaInicio(ventanaInicio, new ControladorUsuario());
        ventanaInicio.setVisible(true);
        } else if (source == vista.getBtnAgregarItem()) {
            udistrital.avanzada.rolapet.vista.VentanaGestionItemsProveedor ventanaItems = new udistrital.avanzada.rolapet.vista.VentanaGestionItemsProveedor(proveedor.getItems());
            new GestorGestionItemsProveedor(ventanaItems, proveedor, this);
            ventanaItems.setVisible(true);

    }
}
}