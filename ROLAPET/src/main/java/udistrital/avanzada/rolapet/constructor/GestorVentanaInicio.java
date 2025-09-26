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
 * Actualmente soporta la apertura de la ventana de usuarios y notifica funcionalidades
 * no implementadas para administradores y proveedores.
 * </p>
 * 
 * @author Sarita
 * @version 1.2, 25-09-2025
 */
public class GestorVentanaInicio implements ActionListener {

    private VentanaInicio ventanaInicio;
    private ControladorUsuario controladorUsuario;

    /**
     * Constructor que inicializa la ventana de inicio y el controlador de usuarios,
     * y asigna el controlador de eventos a la ventana.
     * 
     * @param ventanaInicio instancia de la ventana inicial
     * @param controladorUsuario controlador que maneja la lógica de usuarios
     */
    public GestorVentanaInicio(VentanaInicio ventanaInicio, ControladorUsuario controladorUsuario) {
        this.ventanaInicio = ventanaInicio;
        this.controladorUsuario = controladorUsuario;

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
            GestorVentanaUsuarios gestorUsuarios = new GestorVentanaUsuarios(ventanaUsuarios, ventanaInicio, controladorUsuario);
            ventanaUsuarios.setVisible(true);
            ventanaInicio.setVisible(false);

        } else if (source == ventanaInicio.btnAdministradores) {
            JOptionPane.showMessageDialog(ventanaInicio, "Funcionalidad Administradores no implementada aún.");
        } else if (source == ventanaInicio.btnProveedores) {
            JOptionPane.showMessageDialog(ventanaInicio, "Funcionalidad Proveedores no implementada aún.");
        }
    }
}
