package udistrital.avanzada.rolapet.constructor;

import udistrital.avanzada.rolapet.vista.FormularioInicioSesionProveedor;
import udistrital.avanzada.rolapet.vista.VentanaSeleccionTipoProveedor;
import udistrital.avanzada.rolapet.modelo.RepositorioPublicaciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestorSeleccionTipoProveedor implements ActionListener {
    public static RepositorioPublicaciones getRepoPublicacionesGlobal() {
        return repoPublicacionesGlobal;
    }

    private VentanaSeleccionTipoProveedor vista;
    private GestorRegistroProveedor gestorProveedor;
    private static RepositorioPublicaciones repoPublicacionesGlobal = null;

    public GestorSeleccionTipoProveedor(VentanaSeleccionTipoProveedor vista,
                                        GestorRegistroProveedor gestorProveedor) {
        this.vista = vista;
        this.gestorProveedor = gestorProveedor;
        if (repoPublicacionesGlobal == null) {
            repoPublicacionesGlobal = new RepositorioPublicaciones();
        }
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
    new GestorInicioSesionProveedor(login, gestorProveedor, repoPublicacionesGlobal);
    login.setVisible(true);
    vista.dispose();
    }
}
