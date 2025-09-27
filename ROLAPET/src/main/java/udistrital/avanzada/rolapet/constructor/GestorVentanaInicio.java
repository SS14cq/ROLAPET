package udistrital.avanzada.rolapet.constructor;

import udistrital.avanzada.rolapet.vista.VentanaInicio;
import udistrital.avanzada.rolapet.vista.VentanaUsuarios;
import udistrital.avanzada.rolapet.vista.VentanaSeleccionTipoProveedor;
import udistrital.avanzada.rolapet.vista.FormularioInicioSesionAdministrador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestorVentanaInicio implements ActionListener {

    private VentanaInicio ventanaInicio;
    private ControladorUsuario controladorUsuario;

    // instancia compartida de proveedores (para que admin y login compartan la misma lista)
    private static GestorRegistroProveedor gestorProveedores = new GestorRegistroProveedor();

    public GestorVentanaInicio(VentanaInicio ventanaInicio, ControladorUsuario controladorUsuario) {
        this.ventanaInicio = ventanaInicio;
        this.controladorUsuario = controladorUsuario;
        this.ventanaInicio.setControlador(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        // --- Usuarios: abrimos la ventana de usuarios (flujo que ya tenías) ---
        if (source == ventanaInicio.btnUsuarios) {
            VentanaUsuarios ventanaUsuarios = new VentanaUsuarios();
            new GestorVentanaUsuarios(ventanaUsuarios, ventanaInicio, controladorUsuario);
            ventanaUsuarios.setVisible(true);
            ventanaInicio.dispose();

        // --- Proveedores: abrimos la ventana de selección de tipo (no instanciamos el login directo) ---
        } else if (source == ventanaInicio.btnProveedores) {
            // Si no hay proveedores registrados, mostramos advertencia
            if (gestorProveedores.getProveedores() == null || gestorProveedores.getProveedores().isEmpty()) {
                JOptionPane.showMessageDialog(ventanaInicio,
                        "️ No hay proveedores registrados. Debe registrarlos el administrador.",
                        "Sin proveedores", JOptionPane.WARNING_MESSAGE);
                return;
            }

            VentanaSeleccionTipoProveedor seleccion = new VentanaSeleccionTipoProveedor();
            new GestorSeleccionTipoProveedor(seleccion, gestorProveedores);
            seleccion.setVisible(true);
            ventanaInicio.dispose();

        // --- Administradores: abrimos el login de administrador y le pasamos la misma instancia de gestores ---
        } else if (source == ventanaInicio.btnAdministradores) {
            FormularioInicioSesionAdministrador loginAdmin = new FormularioInicioSesionAdministrador();
            new GestorInicioSesionAdministrador(loginAdmin, gestorProveedores);
            loginAdmin.setVisible(true);
            ventanaInicio.dispose();

        } else {
            JOptionPane.showMessageDialog(ventanaInicio, "Acción no reconocida");
        }
    }
}
