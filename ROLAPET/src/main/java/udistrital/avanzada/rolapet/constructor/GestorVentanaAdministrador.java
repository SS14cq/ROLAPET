package udistrital.avanzada.rolapet.constructor;

import udistrital.avanzada.rolapet.modelo.RepositorioPublicaciones;

import udistrital.avanzada.rolapet.vista.VentanaAdministrador;
import udistrital.avanzada.rolapet.vista.VentanaCrearPublicacion;

public class GestorVentanaAdministrador {
    private VentanaAdministrador ventana;

    private RepositorioPublicaciones repoPublicaciones;

    public GestorVentanaAdministrador(RepositorioPublicaciones repoPublicaciones) {
        this.repoPublicaciones = repoPublicaciones;
        ventana = new udistrital.avanzada.rolapet.vista.VentanaAdministrador();
        ventana.setRegistrarProveedorListener(e -> abrirVentanaSeleccionRegistroProveedor());
        ventana.setCrearPublicacionListener(e -> abrirVentanaCrearPublicacion());
        ventana.setCerrarSesionListener(e -> {
            ventana.dispose();
            new udistrital.avanzada.rolapet.vista.VentanaInicio().setVisible(true);
        });
        ventana.setVisible(true);
    }

    private void abrirVentanaSeleccionRegistroProveedor() {
        udistrital.avanzada.rolapet.vista.VentanaSeleccionRegistroProveedor seleccion = new udistrital.avanzada.rolapet.vista.VentanaSeleccionRegistroProveedor();
        new udistrital.avanzada.rolapet.constructor.GestorSeleccionRegistroProveedor(seleccion, udistrital.avanzada.rolapet.constructor.GestorVentanaInicio.gestorProveedores);
        seleccion.setVisible(true);
    }

    private void abrirVentanaCrearPublicacion() {
        new udistrital.avanzada.rolapet.vista.VentanaCrearPublicacion(repoPublicaciones).setVisible(true);
    }
}
