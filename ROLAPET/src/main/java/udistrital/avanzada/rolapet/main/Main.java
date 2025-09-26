package udistrital.avanzada.rolapet.main;

import javax.swing.SwingUtilities;
import udistrital.avanzada.rolapet.constructor.ControladorUsuario;
import udistrital.avanzada.rolapet.constructor.GestorVentanaInicio;
import udistrital.avanzada.rolapet.vista.VentanaInicio;

/**
 * Clase Main que contiene el método principal para iniciar la aplicación.
 * Inicializa el controlador de usuarios, la ventana inicial y su gestor,
 * y muestra la ventana inicial al usuario.
 * 
 * @author Sarita
 * @version 1.1, 21-09-2025
 */
public class Main {
    /**
     * Punto de entrada de la aplicación Java Swing.
     * Ejecuta el hilo de interfaz gráfica para crear y mostrar la ventana inicial.
     *
     * @param args argumentos de línea de comandos (no usados)
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Crear controlador de usuario
            ControladorUsuario controladorUsuario = new ControladorUsuario();

            // Crear ventana de inicio
            VentanaInicio ventanaInicio = new VentanaInicio();

            // Vincular con el gestor que maneja Usuarios y Proveedores
            new GestorVentanaInicio(ventanaInicio, controladorUsuario);

            // Mostrar ventana inicial
            ventanaInicio.setVisible(true);
        });
    }
}
