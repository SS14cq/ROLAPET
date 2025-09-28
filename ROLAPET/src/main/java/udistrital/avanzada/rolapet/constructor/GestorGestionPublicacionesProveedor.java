package udistrital.avanzada.rolapet.constructor;

import udistrital.avanzada.rolapet.modelo.Publicacion;
import udistrital.avanzada.rolapet.modelo.Proveedor;
import udistrital.avanzada.rolapet.vista.VentanaGestionPublicacionesProveedor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

/**
 * Gestor para la ventana de gestión de publicaciones del proveedor.
 */
public class GestorGestionPublicacionesProveedor implements ActionListener {
    private VentanaGestionPublicacionesProveedor vista;
    private Proveedor proveedor;
    private IGestorPublicacion gestorPublicacion;

    public GestorGestionPublicacionesProveedor(VentanaGestionPublicacionesProveedor vista, Proveedor proveedor, IGestorPublicacion gestorPublicacion) {
        this.vista = vista;
        this.proveedor = proveedor;
        this.gestorPublicacion = gestorPublicacion;
        vista.getBtnCrear().addActionListener(this);
        vista.getBtnEditar().addActionListener(this);
        vista.getBtnEliminar().addActionListener(this);
        vista.getBtnCerrar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == vista.getBtnCrear()) {
            String titulo = JOptionPane.showInputDialog(vista, "Título de la publicación:");
            if (titulo == null || titulo.trim().isEmpty()) return;
            String tipo = JOptionPane.showInputDialog(vista, "Tipo (Evento/Promoción/Descuento):");
            if (tipo == null || tipo.trim().isEmpty()) return;
            String descripcion = JOptionPane.showInputDialog(vista, "Descripción:");
            if (descripcion == null || descripcion.trim().isEmpty()) return;
            String id = "PUB-" + (proveedor.getPublicaciones().size() + 1);
            LocalDate fecha = LocalDate.now();
            Publicacion nueva = new Publicacion(id, titulo, descripcion, tipo, proveedor, fecha);
            gestorPublicacion.crearPublicacion(proveedor, nueva);
            vista.cargarPublicaciones(proveedor.getPublicaciones());
        } else if (source == vista.getBtnEditar()) {
            int row = vista.getTablaPublicaciones().getSelectedRow();
            if (row == -1) return;
            Publicacion pub = proveedor.getPublicaciones().get(row);
            String titulo = JOptionPane.showInputDialog(vista, "Nuevo título:", pub.getTitulo());
            if (titulo == null || titulo.trim().isEmpty()) return;
            String tipo = JOptionPane.showInputDialog(vista, "Nuevo tipo:", pub.getTipo());
            if (tipo == null || tipo.trim().isEmpty()) return;
            String descripcion = JOptionPane.showInputDialog(vista, "Nueva descripción:", pub.getDescripcion());
            if (descripcion == null || descripcion.trim().isEmpty()) return;
            String id = pub.getId();
            LocalDate fecha = pub.getFecha();
            Publicacion editada = new Publicacion(id, titulo, descripcion, tipo, proveedor, fecha);
            gestorPublicacion.actualizarPublicacion(proveedor, editada);
            vista.cargarPublicaciones(proveedor.getPublicaciones());
        } else if (source == vista.getBtnEliminar()) {
            int row = vista.getTablaPublicaciones().getSelectedRow();
            if (row == -1) return;
            Publicacion pub = proveedor.getPublicaciones().get(row);
            gestorPublicacion.eliminarPublicacion(proveedor, pub);
            vista.cargarPublicaciones(proveedor.getPublicaciones());
        } else if (source == vista.getBtnCerrar()) {
            vista.dispose();
        }
    }
}
