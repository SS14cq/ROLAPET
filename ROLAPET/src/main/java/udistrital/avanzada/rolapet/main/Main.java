package udistrital.avanzada.rolapet.main;

import udistrital.avanzada.rolapet.vista.VentanaInicio;
import udistrital.avanzada.rolapet.constructor.*;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ControladorUsuario controladorUsuario = new ControladorUsuario();
            VentanaInicio ventanaInicio = new VentanaInicio();
            GestorVentanaInicio gestorInicio = new GestorVentanaInicio(ventanaInicio, controladorUsuario);
            ventanaInicio.setVisible(true);
        });
    }
}
