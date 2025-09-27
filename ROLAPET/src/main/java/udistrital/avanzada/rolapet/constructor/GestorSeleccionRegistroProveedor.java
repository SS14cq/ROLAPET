package udistrital.avanzada.rolapet.constructor;

import udistrital.avanzada.rolapet.vista.FormularioRegistroProveedorInsumos;
import udistrital.avanzada.rolapet.vista.FormularioRegistroProveedorServicios;
import udistrital.avanzada.rolapet.vista.VentanaSeleccionRegistroProveedor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestorSeleccionRegistroProveedor implements ActionListener {

    private VentanaSeleccionRegistroProveedor vista;
    private GestorRegistroProveedor gestorProveedor;

    public GestorSeleccionRegistroProveedor(VentanaSeleccionRegistroProveedor vista,
                                            GestorRegistroProveedor gestorProveedor) {
        this.vista = vista;
        this.gestorProveedor = gestorProveedor;
        this.vista.setControlador(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == vista.getBtnRegistrarInsumos()) {
            FormularioRegistroProveedorInsumos registroInsumos = new FormularioRegistroProveedorInsumos();
            new GestorRegistroProveedorInsumos(registroInsumos, gestorProveedor);
            registroInsumos.setVisible(true);
            vista.dispose();

        } else if (source == vista.getBtnRegistrarServicios()) {
            FormularioRegistroProveedorServicios registroServicios = new FormularioRegistroProveedorServicios();
            new GestorRegistroProveedorServicios(registroServicios, gestorProveedor);
            registroServicios.setVisible(true);
            vista.dispose();
        }
    }
}
