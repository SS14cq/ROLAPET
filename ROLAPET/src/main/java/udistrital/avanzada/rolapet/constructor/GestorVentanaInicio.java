package udistrital.avanzada.rolapet.constructor;

import udistrital.avanzada.rolapet.vista.VentanaInicio;
import udistrital.avanzada.rolapet.vista.VentanaUsuarios;
import udistrital.avanzada.rolapet.vista.VentanaSeleccionTipoProveedor;
import udistrital.avanzada.rolapet.vista.FormularioInicioSesionAdministrador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Clase que gestiona los eventos de la ventana de inicio de la aplicación.
 * 
 * <p>Permite la navegación hacia las diferentes secciones según el botón seleccionado:
 * usuarios, proveedores o administradores. Mantiene una instancia compartida
 * de proveedores para que la información sea consistente en toda la aplicación.</p>
 * 
 * <p><b>Historial de cambios:</b></p>
 * <ul>
 *   <li>2025-09-25 - Versión 1.2 - Modificada por Sarita: implementación inicial de flujo.</li>
 *   <li>2025-09-26 - Versión 1.3 - Modificada por Juan: agregado manejo de acción manejo de proveedores.</li>
 *   <li>2025-09-27 - Versión 1.3 - Modificada por Sarita: documentación.</li>
 * </ul>
 * 
 * @author Sarita
 * @version 1.3
 */

public class GestorVentanaInicio implements ActionListener {

    /** Ventana de inicio que se va a controlar */
    private VentanaInicio ventanaInicio;

    /** Controlador de usuarios asociado */
    private ControladorUsuario controladorUsuario;

    /** Instancia compartida de registro de proveedores */
    public static GestorRegistroProveedor gestorProveedores = null;
    // Usar la lista de proveedores real del gestor
    /**
     * Constructor que inicializa el gestor con la ventana de inicio y el controlador de usuarios.
     * 
     * @param ventanaInicio ventana principal de la aplicación
     * @param controladorUsuario controlador que maneja la lógica de usuarios
     */
    public GestorVentanaInicio(VentanaInicio ventanaInicio, ControladorUsuario controladorUsuario) {
        this.ventanaInicio = ventanaInicio;
        this.controladorUsuario = controladorUsuario;
        if (gestorProveedores == null) {
            gestorProveedores = new GestorRegistroProveedor();
        }
        this.ventanaInicio.setControlador(this);
    }
/**
     * Maneja los eventos de los botones en la ventana de inicio.
     * <p>
     * Dependiendo del botón presionado:
     * <ul>
     *     <li><b>Usuarios:</b> abre la ventana de gestión de usuarios.</li>
     *     <li><b>Proveedores:</b> abre la ventana de selección de tipo de proveedor,
     *     verificando que existan proveedores registrados.</li>
     *     <li><b>Administradores:</b> abre el formulario de inicio de sesión de administradores
     *     usando la misma instancia de registro de proveedores.</li>
     *     <li><b>Otros:</b> muestra un mensaje de acción no reconocida.</li>
     * </ul>
     * </p>
     * 
     * @param e evento generado al presionar un botón
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        // Usuarios
        if (source == ventanaInicio.btnUsuarios) {
            VentanaUsuarios ventanaUsuarios = new VentanaUsuarios();
            new GestorVentanaUsuarios(ventanaUsuarios, ventanaInicio, controladorUsuario);
            ventanaUsuarios.setVisible(true);
            ventanaInicio.setVisible(false);

        // Proveedores
        } else if (source == ventanaInicio.btnProveedores) {
            if (gestorProveedores.getProveedores() == null || gestorProveedores.getProveedores().isEmpty()) {
                JOptionPane.showMessageDialog(ventanaInicio,
                        "️ No hay proveedores registrados. Debe registrarlos el administrador.",
                        "Sin proveedores", JOptionPane.WARNING_MESSAGE);
                return;
            }
            VentanaSeleccionTipoProveedor seleccion = new VentanaSeleccionTipoProveedor();
            new GestorSeleccionTipoProveedor(seleccion, gestorProveedores);
            seleccion.setVisible(true);
            ventanaInicio.setVisible(false);

        // Administradores
        } else if (source == ventanaInicio.btnAdministradores) {
            FormularioInicioSesionAdministrador loginAdmin = new FormularioInicioSesionAdministrador();
            new GestorInicioSesionAdministrador(loginAdmin, gestorProveedores);
            loginAdmin.setVisible(true);
            ventanaInicio.setVisible(false);

        // Acción no reconocida
        } else {
            JOptionPane.showMessageDialog(ventanaInicio, "Acción no reconocida");
        }
    }
}
