package udistrital.avanzada.rolapet.constructor;

import udistrital.avanzada.rolapet.vista.FormularioRegistro;
import udistrital.avanzada.rolapet.vista.VentanaUsuarios;
import udistrital.avanzada.rolapet.modelo.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestorRegistro implements ActionListener {
    private FormularioRegistro formulario;
    private VentanaUsuarios ventanaUsuarios;
    private ControladorUsuario controladorUsuario;

    public GestorRegistro(FormularioRegistro formulario, VentanaUsuarios ventanaUsuarios, ControladorUsuario controladorUsuario) {
        this.formulario = formulario;
        this.ventanaUsuarios = ventanaUsuarios;
        this.controladorUsuario = controladorUsuario;

        this.formulario.setControlador(this);
    }

    private boolean validarContrasena(String contrasena) {
        // Al menos 8 caracteres, 1 mayúscula, 1 número, 1 carácter especial
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

            Usuario nuevo = new Usuario(
                    formulario.getNombre(),
                    formulario.getApellido(),
                    formulario.getCedula(),
                    formulario.getCorreo(),
                    formulario.getCelular(),
                    formulario.getNombreUsuario(),
                    formulario.getContrasena()
            );
            if (controladorUsuario.registrarUsuario(nuevo)) {
                JOptionPane.showMessageDialog(formulario, "Registro exitoso");
                formulario.limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(formulario, "Nombre de usuario o cédula ya existentes");
            }
        }
        else if (e.getSource() == formulario.getBtnAtras()) {
            formulario.dispose();
            ventanaUsuarios.setVisible(true);
        }
    }
}
