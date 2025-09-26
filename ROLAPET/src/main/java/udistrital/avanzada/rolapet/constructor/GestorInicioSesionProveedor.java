package udistrital.avanzada.rolapet.constructor;

import udistrital.avanzada.rolapet.vista.FormularioInicioSesionProveedor;
import udistrital.avanzada.rolapet.modelo.Proveedor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import udistrital.avanzada.rolapet.vista.VentanaProveedor;

public class GestorInicioSesionProveedor implements ActionListener {

    private FormularioInicioSesionProveedor vista;
    private GestorRegistroProveedor gestorProveedor;

    public GestorInicioSesionProveedor(FormularioInicioSesionProveedor vista,
                                       GestorRegistroProveedor gestorProveedor) {
        this.vista = vista;
        this.gestorProveedor = gestorProveedor;

        // conectar botones al controlador
        this.vista.setControlador(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == vista.getBtnIngresar()) {
            // Usamos los getters correctos de FormularioInicioSesion
            String correo = vista.getUsuario();
            String contrasena = vista.getContrasena();
            String tipo = vista.getTipoProveedor(); // definido en la subclase

            Proveedor proveedor = gestorProveedor.iniciarSesion(correo, contrasena, tipo);

            if (proveedor != null) {
    JOptionPane.showMessageDialog(vista,
            "✅ Bienvenido " + proveedor.getNombre() +
                    " (" + proveedor.getTipoProveedor() + ")",
            "Login exitoso", JOptionPane.INFORMATION_MESSAGE);

    // 👉 Abrir ventana del proveedor con su gestor
    VentanaProveedor ventanaProveedor = new VentanaProveedor(
            proveedor.getNombre(), proveedor.getTipoProveedor()
    );
    new GestorVentanaProveedor(ventanaProveedor, proveedor);
    ventanaProveedor.setVisible(true);

    vista.dispose();
}
 else {
                JOptionPane.showMessageDialog(vista,
                        " Credenciales inválidas.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }

        } else if (source == vista.getBtnCancelar()) {
            vista.dispose();
        }
    }
}
