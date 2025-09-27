package udistrital.avanzada.rolapet.vista;

import udistrital.avanzada.rolapet.modelo.Publicacion;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

/**
 * Ventana para que el proveedor gestione sus publicaciones (eventos/promociones).
 */
public class VentanaGestionPublicacionesProveedor extends JFrame {
    private JTable tablaPublicaciones;
    private DefaultTableModel modeloTabla;
    private JButton btnCrear;
    private JButton btnEditar;
    private JButton btnEliminar;
    private JButton btnCerrar;

    public VentanaGestionPublicacionesProveedor(List<Publicacion> publicaciones) {
        setTitle("Gestión de Publicaciones del Proveedor");
        setSize(650, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        modeloTabla = new DefaultTableModel(new Object[]{"Título", "Tipo", "Fecha", "Descripción"}, 0);
        tablaPublicaciones = new JTable(modeloTabla);
        JScrollPane scroll = new JScrollPane(tablaPublicaciones);
        add(scroll, BorderLayout.CENTER);

        btnCrear = new JButton("Crear publicación");
        btnEditar = new JButton("Editar publicación");
        btnEliminar = new JButton("Eliminar publicación");
        btnCerrar = new JButton("Cerrar");

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnCrear);
        panelBotones.add(btnEditar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnCerrar);
        add(panelBotones, BorderLayout.SOUTH);

        cargarPublicaciones(publicaciones);
    }

    public void cargarPublicaciones(List<Publicacion> publicaciones) {
        modeloTabla.setRowCount(0);
        for (Publicacion pub : publicaciones) {
            modeloTabla.addRow(new Object[]{pub.getTitulo(), pub.getTipo(), pub.getFecha(), pub.getDescripcion()});
        }
    }

    public JTable getTablaPublicaciones() { return tablaPublicaciones; }
    public JButton getBtnCrear() { return btnCrear; }
    public JButton getBtnEditar() { return btnEditar; }
    public JButton getBtnEliminar() { return btnEliminar; }
    public JButton getBtnCerrar() { return btnCerrar; }
}
