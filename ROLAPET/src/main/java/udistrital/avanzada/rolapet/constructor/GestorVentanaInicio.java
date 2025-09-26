package udistrital.avanzada.rolapet.constructor;

import udistrital.avanzada.rolapet.vista.VentanaInicio;
import udistrital.avanzada.rolapet.vista.VentanaUsuarios;
import udistrital.avanzada.rolapet.vista.VentanaSeleccionTipoProveedor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestorVentanaInicio implements ActionListener {

    private VentanaInicio ventanaInicio;
    private ControladorUsuario controladorUsuario;
    private GestorRegistroProveedor gestorProveedor;

    public GestorVentanaInicio(VentanaInicio ventanaInicio, ControladorUsuario controladorUsuario) {
        this.ventanaInicio = ventanaInicio;
        this.controladorUsuario = controladorUsuario;
        this.gestorProveedor = new GestorRegistroProveedor();

        // --- Proveedores precargados para pruebas ---
        gestorProveedor.registrarProveedorServicio(
                "Juan", "Lopez", "1234", "juan@servicio.com", "3101111111");
        gestorProveedor.registrarProveedorInsumo(
                "Ana", "Martinez", "5678", "ana@insumo.com", "3202222222");

        this.ventanaInicio.setControlador(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == ventanaInicio.btnUsuarios) {
            VentanaUsuarios ventanaUsuarios = new VentanaUsuarios();
            new GestorVentanaUsuarios(ventanaUsuarios, ventanaInicio, controladorUsuario);
            ventanaUsuarios.setVisible(true);
            ventanaInicio.setVisible(false);

        } else if (source == ventanaInicio.btnAdministradores) {
            JOptionPane.showMessageDialog(ventanaInicio,
                    "Funcionalidad Administradores no implementada aún.");

        } else if (source == ventanaInicio.btnProveedores) {
            // 👉 Nuevo flujo: primero seleccionar tipo de proveedor
            VentanaSeleccionTipoProveedor seleccion = new VentanaSeleccionTipoProveedor();
            new GestorSeleccionTipoProveedor(seleccion, gestorProveedor);
            seleccion.setVisible(true);
            ventanaInicio.setVisible(false);
        }
    }
}

