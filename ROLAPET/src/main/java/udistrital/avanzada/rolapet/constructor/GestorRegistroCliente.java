package udistrital.avanzada.rolapet.constructor;

import udistrital.avanzada.rolapet.modelo.Cliente;
import udistrital.avanzada.rolapet.vista.FormularioRegistroCliente; // Cambiado
import udistrital.avanzada.rolapet.vista.VentanaUsuarios;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestorRegistroCliente implements ActionListener {
    private FormularioRegistroCliente formulario; // Cambiado
    private VentanaUsuarios ventanaUsuarios;
    private ControladorUsuario controladorUsuario;

    public GestorRegistroCliente(FormularioRegistroCliente formulario, VentanaUsuarios ventanaUsuarios, ControladorUsuario controladorUsuario) { // Cambiado
        this.formulario = formulario;
        this.ventanaUsuarios = ventanaUsuarios;
        this.controladorUsuario = controladorUsuario;

        this.formulario.setControlador(this);
    }

    private boolean validarContrasena(String contrasena) {
        String pattern = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        return contrasena.matches(pattern);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == formulario.getBtnRegistrar()) {
            String pass = formulario.getContrasena();
            if (!validarContrasena(pass)) {
                JOptionPane.showMessageDialog(formulario,
                        "La contraseña debe tener mínimo 8 caracteres, al menos una letra mayúscula, un número y un carácter especial.",
                        "Error de validación",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            Cliente nuevoCliente = new Cliente(
                    formulario.getNombreUsuario(),
                    formulario.getContrasena(),
                    formulario.getNombre(),
                    formulario.getApellido(),
                    formulario.getCedula(),
                    formulario.getCorreo(),
                    formulario.getCelular()
            );

            if (controladorUsuario.registrarUsuario(nuevoCliente)) {
                JOptionPane.showMessageDialog(formulario, "Registro exitoso");
                formulario.limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(formulario, "Nombre de usuario o cédula ya existentes");
            }
        } else if (e.getSource() == formulario.getBtnAtras()) {
            formulario.dispose();
            ventanaUsuarios.setVisible(true);
        }
    }
}
