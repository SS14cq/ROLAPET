package udistrital.avanzada.rolapet.constructor;

import udistrital.avanzada.rolapet.modelo.Proveedor;
import udistrital.avanzada.rolapet.modelo.ProveedorInsumo;
import udistrital.avanzada.rolapet.modelo.ProveedorServicio;
import udistrital.avanzada.rolapet.vista.FormularioInicioSesionProveedor;
import udistrital.avanzada.rolapet.vista.VentanaProveedor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Controlador para manejo del inicio de sesión de proveedores.
 */
public class GestorInicioSesionProveedor implements ActionListener {

    private FormularioInicioSesionProveedor vista;
    private GestorRegistroProveedor gestorProveedor;

    public GestorInicioSesionProveedor(FormularioInicioSesionProveedor vista,
                                       GestorRegistroProveedor gestorProveedor) {
        this.vista = vista;
        this.gestorProveedor = gestorProveedor;
        this.vista.setControlador(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == vista.getBtnIngresar()) {
            String correo = vista.getUsuario().trim();
            String contrasena = vista.getContrasena().trim();
            String tipoSeleccionado = vista.getTipoProveedor(); // ej. "ProveedorServicio" o "Servicio" o "Insumo"

            if (correo.isEmpty() || contrasena.isEmpty()) {
                JOptionPane.showMessageDialog(vista, "Ingrese correo y contraseña.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Buscar proveedor que coincida en tipo, correo y contraseña
            Proveedor encontrado = buscarProveedor(correo, contrasena, tipoSeleccionado);

            if (encontrado != null) {
                JOptionPane.showMessageDialog(vista,
                        " Bienvenido " + encontrado.getNombre() + " (" + encontrado.getTipoProveedor() + ")",
                        "Login exitoso", JOptionPane.INFORMATION_MESSAGE);

                // Abrir ventana del proveedor y su gestor
                VentanaProveedor ventanaProveedor = new VentanaProveedor(encontrado.getNombre(), encontrado.getTipoProveedor());
                new GestorVentanaProveedor(ventanaProveedor, encontrado);
                ventanaProveedor.setVisible(true);

                vista.dispose();
            } else {
                JOptionPane.showMessageDialog(vista,
                        " Credenciales inválidas o tipo incorrecto.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }

        } else if (source == vista.getBtnCancelar()) {
            vista.dispose();
        }
    }

    /**
     * Busca en la lista de proveedores uno que coincida con correo, contraseña y tipo.
     * Acepta distintos formatos en {@code tipoSeleccionado} ("ProveedorServicio", "Servicio", "ProveedorInsumo", "Insumo").
     */
    private Proveedor buscarProveedor(String correo, String contrasena, String tipoSeleccionado) {
        if (gestorProveedor == null) return null;
        List<Proveedor> lista = gestorProveedor.getProveedores();
        if (lista == null) return null;

        // Normalizar tipo: "servicio" o "insumo"
        String tipoNorm = tipoSeleccionado == null ? "" : tipoSeleccionado.toLowerCase();
        boolean buscarServicio = tipoNorm.contains("servicio");
        boolean buscarInsumo  = tipoNorm.contains("insumo");

        for (Proveedor p : lista) {
            // comprobar tipo por instancia o por getTipoProveedor()
            boolean tipoCoincide = (buscarServicio && p instanceof ProveedorServicio)
                                || (buscarInsumo  && p instanceof ProveedorInsumo)
                                || (buscarServicio && "servicio".equalsIgnoreCase(p.getTipoProveedor()))
                                || (buscarInsumo  && "insumo".equalsIgnoreCase(p.getTipoProveedor()));

            if (!tipoCoincide) continue;

            // Obtener correo y contraseña almacenados
            String correoProv = null;
            String passProv = null;

            // Asumimos que Persona/Proveedor tiene getCorreo(); los proveedores concretos tienen getContrasena()
            try {
                correoProv = p.getCorreo(); // si Persona define getCorreo()
            } catch (Throwable ex) {
                // si no existe getCorreo(), tu clase Persona podría usar otro nombre — ajusta aquí si es necesario
            }

            if (p instanceof ProveedorInsumo) {
                passProv = ((ProveedorInsumo) p).getContrasena();
            } else if (p instanceof ProveedorServicio) {
                passProv = ((ProveedorServicio) p).getContrasena();
            }

            if (correoProv == null) {
                // intento alternativo: si tienes getUsuario() o getEmail() cambia esta línea
                // correoProv = p.getUsuario(); // <-- ajusta si tu modelo usa otro getter
            }

            if (correoProv != null && correoProv.equalsIgnoreCase(correo)
                    && passProv != null && passProv.equals(contrasena)) {
                return p;
            }
        }
        return null;
    }
}
