package udistrital.avanzada.rolapet.constructor;

import udistrital.avanzada.rolapet.vista.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestorVentanaInicio implements ActionListener {

    private VentanaInicio ventanaInicio;
    private ControladorUsuario controladorUsuario;

    public GestorVentanaInicio(VentanaInicio ventanaInicio, ControladorUsuario controladorUsuario) {
        this.ventanaInicio = ventanaInicio;
        this.controladorUsuario = controladorUsuario;

        this.ventanaInicio.setControlador(this);
    }

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
