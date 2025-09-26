package udistrital.avanzada.rolapet.main;

import javax.swing.SwingUtilities;

import udistrital.avanzada.rolapet.constructor.ControladorUsuario;
import udistrital.avanzada.rolapet.constructor.GestorVentanaInicio;
import udistrital.avanzada.rolapet.vista.VentanaInicio;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Crear controlador de usuario
            ControladorUsuario controladorUsuario = new ControladorUsuario();

            // Crear ventana de inicio
            VentanaInicio ventanaInicio = new VentanaInicio();

            // Vincular con el gestor que maneja Usuarios y Proveedores
            new GestorVentanaInicio(ventanaInicio, controladorUsuario);

            // Mostrar ventana
            ventanaInicio.setVisible(true);
        });
    }
}
