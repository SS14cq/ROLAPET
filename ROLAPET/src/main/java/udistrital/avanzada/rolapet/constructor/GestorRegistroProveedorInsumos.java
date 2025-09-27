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
            gestorProveedor.registrarProveedorInsumo(
                    vista.getNombre(),
                    vista.getApellido(),
                    vista.getCedula(),
                    vista.getCorreo(),
                    vista.getCelular(),
                    vista.getContrasena()
            );

            JOptionPane.showMessageDialog(vista, "Proveedor de Insumo registrado correctamente.");
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
