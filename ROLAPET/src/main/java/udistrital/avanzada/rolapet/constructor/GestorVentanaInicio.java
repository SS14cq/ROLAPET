package udistrital.avanzada.rolapet.constructor;

import udistrital.avanzada.rolapet.vista.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase GestorVentanaInicio que controla la ventana inicial de la aplicación.
 * Maneja la navegación hacia diferentes secciones según la opción seleccionada
 * por el usuario en la ventana de inicio.
 * <p>
 * Actualmente soporta la apertura de la ventana de usuarios y proveedores,
 * y notifica funcionalidades no implementadas para administradores.
 * </p>
 * 
 * @author Sarita
 * @version 1.2, 25-09-2025
 */
public class GestorVentanaInicio implements ActionListener {

    private VentanaInicio ventanaInicio;
    private ControladorUsuario controladorUsuario;
    private GestorRegistroProveedor gestorProveedor;

    /**
     * Constructor que inicializa la ventana de inicio y el controlador de usuarios.
     * Además, precarga proveedores de prueba para facilitar las pruebas iniciales.
     *
     * @param ventanaInicio instancia de la ventana inicial
     * @param controladorUsuario controlador que maneja la lógica de usuarios
     */
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

    /**
     * Maneja los eventos generados en la ventana de inicio,
     * respondiendo a los botones de navegación.
     *
     * @param e evento de acción disparado
     */
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
