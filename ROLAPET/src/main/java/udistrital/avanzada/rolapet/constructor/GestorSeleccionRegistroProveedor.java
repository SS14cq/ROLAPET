package udistrital.avanzada.rolapet.constructor;

import udistrital.avanzada.rolapet.vista.FormularioRegistroProveedorInsumos;
import udistrital.avanzada.rolapet.vista.FormularioRegistroProveedorServicios;
import udistrital.avanzada.rolapet.vista.VentanaSeleccionRegistroProveedor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class GestorSeleccionRegistroProveedor.
 */
/**
 * Class GestorSeleccionRegistroProveedor.
 */
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
/**
 * actionPerformed method.
 * @param e parameter
 * @return result
 */
/**
 * actionPerformed method.
 * @param e parameter
 */
/**
 * actionPerformed method.
 * @param e parameter
 */
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == vista.getBtnRegistrarInsumos()) {
            FormularioRegistroProveedorInsumos registroInsumos = new FormularioRegistroProveedorInsumos(vista);
            new GestorRegistroProveedorInsumos(registroInsumos, gestorProveedor);
            registroInsumos.setVisible(true);
            vista.setVisible(false);

        } else if (source == vista.getBtnRegistrarServicios()) {
            FormularioRegistroProveedorServicios registroServicios = new FormularioRegistroProveedorServicios(vista);
            new GestorRegistroProveedorServicios(registroServicios, gestorProveedor);
            registroServicios.setVisible(true);
            vista.setVisible(false);
        }
    }
}
