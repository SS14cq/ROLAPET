package udistrital.avanzada.rolapet.constructor;

import udistrital.avanzada.rolapet.vista.FormularioInicioSesionProveedor;
import udistrital.avanzada.rolapet.modelo.Proveedor;
import udistrital.avanzada.rolapet.vista.VentanaProveedor;
import udistrital.avanzada.rolapet.modelo.RepositorioPublicaciones;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestorInicioSesionProveedor implements ActionListener {

    private FormularioInicioSesionProveedor vista;
    private GestorRegistroProveedor gestorProveedor;
    private RepositorioPublicaciones repoPublicaciones;

    public GestorInicioSesionProveedor(FormularioInicioSesionProveedor vista,
                                       GestorRegistroProveedor gestorProveedor,
                                       RepositorioPublicaciones repoPublicaciones) {
        this.vista = vista;
        this.gestorProveedor = gestorProveedor;
        this.repoPublicaciones = repoPublicaciones;
        this.vista.setControlador(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

    if (source == vista.getBtnIngresar()) {
        String correo = vista.getUsuario();
        String contrasena = vista.getContrasena();
        String tipo = vista.getTipoProveedor();

        // Validación básica de campos
        if (correo == null || correo.trim().isEmpty() || contrasena == null || contrasena.trim().isEmpty()) {
        JOptionPane.showMessageDialog(vista,
            "Por favor ingrese correo y contraseña.",
            "Campos requeridos", JOptionPane.WARNING_MESSAGE);
        return;
        }

        Proveedor proveedor = gestorProveedor.iniciarSesion(correo, contrasena, tipo);

        if (proveedor != null) {
        JOptionPane.showMessageDialog(vista,
            "✅ Bienvenido " + proveedor.getNombre() +
                " (" + proveedor.getTipoProveedor() + ")",
            "Login exitoso", JOptionPane.INFORMATION_MESSAGE);

        VentanaProveedor ventanaProveedor = new VentanaProveedor(
            proveedor.getNombre(), proveedor.getTipoProveedor()
        );
        new GestorVentanaProveedor(ventanaProveedor, proveedor, repoPublicaciones);
        ventanaProveedor.setVisible(true);

        vista.dispose();
        } else {
        // Mensaje de error más claro
        JOptionPane.showMessageDialog(vista,
            "Correo, contraseña o tipo de proveedor incorrectos.",
            "Error de autenticación", JOptionPane.ERROR_MESSAGE);
        }
    } else if (source == vista.getBtnCancelar()) {
        vista.dispose();
        // Volver a la ventana de selección de tipo de proveedor
        udistrital.avanzada.rolapet.vista.VentanaSeleccionTipoProveedor seleccionTipo = new udistrital.avanzada.rolapet.vista.VentanaSeleccionTipoProveedor();
        new GestorSeleccionTipoProveedor(seleccionTipo, gestorProveedor);
        seleccionTipo.setVisible(true);
    }
    }
}
