package udistrital.avanzada.rolapet.constructor;

import udistrital.avanzada.rolapet.vista.FormularioInicioSesionProveedor;
import udistrital.avanzada.rolapet.vista.VentanaSeleccionTipoProveedor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestorSeleccionTipoProveedor implements ActionListener {

    private VentanaSeleccionTipoProveedor vista;
    private GestorRegistroProveedor gestorProveedor;

    public GestorSeleccionTipoProveedor(VentanaSeleccionTipoProveedor vista,
                                        GestorRegistroProveedor gestorProveedor) {
        this.vista = vista;
        this.gestorProveedor = gestorProveedor;

        this.vista.setControlador(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == vista.getBtnServicio()) {
            abrirLogin("ProveedorServicio");
        } else if (source == vista.getBtnInsumo()) {
            abrirLogin("ProveedorInsumo");
        }
    }

    private void abrirLogin(String tipo) {
        FormularioInicioSesionProveedor login = new FormularioInicioSesionProveedor(tipo);
        new GestorInicioSesionProveedor(login, gestorProveedor);
        login.setVisible(true);
        vista.dispose();
    }
}
