package udistrital.avanzada.rolapet.constructor;

import udistrital.avanzada.rolapet.modelo.Cliente;
import udistrital.avanzada.rolapet.vista.FormularioRegistroCliente;
import udistrital.avanzada.rolapet.vista.VentanaUsuarios;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Clase GestorRegistroCliente que controla la lógica de registro de clientes
 * a partir de un formulario visual. Valida la contraseña y gestiona la comunicación
 * con un controlador de usuarios para registrar nuevos clientes.
 * <p>
 * Maneja eventos de los botones de registrar y regresar en el formulario.
 * </p>
 * 
 * @author Sarita
 * @version 1.1, 26-09-2025
 */
public class GestorRegistroCliente implements ActionListener {
    private FormularioRegistroCliente formulario;
    private VentanaUsuarios ventanaUsuarios;
    private ControladorUsuario controladorUsuario;

    /**
     * Constructor que inicializa los componentes y asigna el controlador al formulario.
     * 
     * @param formulario instancia del formulario de registro cliente
     * @param ventanaUsuarios instancia de la ventana de gestión de usuarios
     * @param controladorUsuario controlador que maneja la lógica de usuarios
     */
    public GestorRegistroCliente(FormularioRegistroCliente formulario, VentanaUsuarios ventanaUsuarios, ControladorUsuario controladorUsuario) {
        this.formulario = formulario;
        this.ventanaUsuarios = ventanaUsuarios;
        this.controladorUsuario = controladorUsuario;

        this.formulario.setControlador(this);
    }

    /**
     * Valida que la contraseña cumpla con el patrón definido:
     * mínimo 8 caracteres, al menos una letra mayúscula, un número y un carácter especial.
     * 
     * @param contrasena contraseña a validar
     * @return true si la contraseña es válida, false en caso contrario
     */
    private boolean validarContrasena(String contrasena) {
        String pattern = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        return contrasena.matches(pattern);
    }

    /**
     * Método que responde a los eventos generados en el formulario.
     * Gestiona la lógica del botón de registro y el botón de retroceso.
     * 
     * @param e evento de acción disparado
     */
/**
 * Responde a los eventos generados en el formulario de registro.
 * MODIFICACIÓN: Se agregaron capturas de excepción IllegalArgumentException para validar
 * cedula, correo y celular usando los setters validados de Persona/Cliente.
 * Si algún dato no es válido, se muestra mensaje de error adecuado.
 * 
 * @param e evento de acción disparado
 */
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

            try {
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
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(formulario,
                        ex.getMessage(),
                        "Error de validación",
                        JOptionPane.ERROR_MESSAGE);
            }

        } else if (e.getSource() == formulario.getBtnAtras()) {
            formulario.dispose();
            ventanaUsuarios.setVisible(true);
        }
    }
}