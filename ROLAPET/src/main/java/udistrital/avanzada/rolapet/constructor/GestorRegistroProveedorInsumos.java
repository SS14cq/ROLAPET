package udistrital.avanzada.rolapet.constructor;

import udistrital.avanzada.rolapet.vista.FormularioRegistroProveedorInsumos;
import udistrital.avanzada.rolapet.vista.VentanaInicio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestorRegistroProveedorInsumos implements ActionListener {

    private FormularioRegistroProveedorInsumos vista;
    private GestorRegistroProveedor gestorProveedor;

    public GestorRegistroProveedorInsumos(FormularioRegistroProveedorInsumos vista, GestorRegistroProveedor gestorProveedor) {
        this.vista = vista;
        this.gestorProveedor = gestorProveedor;
        this.vista.setControlador(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == vista.getBtnRegistrar()) {
            String contrasena = vista.getContrasena();
            String nombre = vista.getNombre();
            String apellido = vista.getApellido();
            String correo = vista.getCorreo();
            String celular = vista.getCelular();
            String cedula = vista.getCedula();

            // Validación de campos vacíos
            if (contrasena.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || cedula.isEmpty() || correo.isEmpty() || celular.isEmpty()) {
                JOptionPane.showMessageDialog(vista, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Validación de correo
            if (!correo.contains("@") || !correo.contains(".")) {
                JOptionPane.showMessageDialog(vista, "El correo debe contener '@' y al menos un punto.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Validación de celular (10 dígitos numéricos)
            if (!celular.matches("\\d{10}")) {
                JOptionPane.showMessageDialog(vista, "El celular debe tener exactamente 10 números.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Validación de cédula (solo números)
            if (!cedula.matches("\\d+")) {
                JOptionPane.showMessageDialog(vista, "La cédula solo debe contener números.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            gestorProveedor.registrarProveedorInsumo(
                    correo, // El usuario ahora es el correo
                    contrasena,
                    nombre,
                    apellido,
                    cedula,
                    correo,
                    celular
            );

            JOptionPane.showMessageDialog(vista,
                "Proveedor de Insumo registrado correctamente.\n" +
                "Usuario asignado: " + correo + "\n" +
                "Contraseña asignada: " + contrasena,
                "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
            vista.dispose();

            VentanaInicio inicio = new VentanaInicio();
            new GestorVentanaInicio(inicio, new ControladorUsuario());
            inicio.setVisible(true);

        } else if (source == vista.getBtnCancelar()) {
            vista.dispose();
            VentanaInicio inicio = new VentanaInicio();
            new GestorVentanaInicio(inicio, new ControladorUsuario());
            inicio.setVisible(true);
        }
    }
}
