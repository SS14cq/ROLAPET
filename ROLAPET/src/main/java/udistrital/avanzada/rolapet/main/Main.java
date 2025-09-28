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
/**
 * Class Main.
 */
/**
 * Class Main.
 */
public class Main {
/**
 * main method.
 * @param args parameter
 * @return result
 */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ControladorUsuario controladorUsuario = new ControladorUsuario();
            VentanaInicio ventanaInicio = new VentanaInicio();
            GestorVentanaInicio gestorInicio = new GestorVentanaInicio(ventanaInicio, controladorUsuario);
            ventanaInicio.setVisible(true);
        });
    }
}
