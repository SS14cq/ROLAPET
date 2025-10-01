package udistrital.avanzada.rolapet.constructor;

import udistrital.avanzada.rolapet.vista.VentanaInicioUsuario;
import udistrital.avanzada.rolapet.vista.VentanaRegistroVehiculo;
import udistrital.avanzada.rolapet.vista.VentanaInicio;
import udistrital.avanzada.rolapet.modelo.Publicacion;
import udistrital.avanzada.rolapet.modelo.Usuario;
import udistrital.avanzada.rolapet.modelo.RepositorioUsuarios;
import udistrital.avanzada.rolapet.modelo.RepositorioPublicaciones;
import udistrital.avanzada.rolapet.modelo.Vehiculo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Gestor de la ventana inicio de usuario. Corrige fallback al cerrar sesión y
 * muestra correctamente publicaciones de proveedores.
 */
/**
 * Class GestorVentanaInicioUsuario.
 */
/**
 * Class GestorVentanaInicioUsuario.
 */
public class GestorVentanaInicioUsuario implements ActionListener {

    private VentanaInicioUsuario ventana;
    private Usuario usuarioActual;
    private RepositorioUsuarios repositorioUsuarios;
    private RepositorioPublicaciones repoPublicaciones;
    private JFrame ventanaPrincipal;
    private ControladorUsuario controladorUsuario = new ControladorUsuario();

    public GestorVentanaInicioUsuario(VentanaInicioUsuario ventana,
            Usuario usuarioActual,
            RepositorioUsuarios repositorioUsuarios,
            RepositorioPublicaciones repoPublicaciones,
            JFrame ventanaPrincipal) {
        this.ventana = ventana;
        this.usuarioActual = usuarioActual;
        this.repositorioUsuarios = repositorioUsuarios;
        this.repoPublicaciones = repoPublicaciones;
        this.ventanaPrincipal = ventanaPrincipal;

        // listeners
        ventana.setCerrarSesionListener(this);
        ventana.btnAgregarAmigos.addActionListener(this);
        ventana.btnVerProveedores.addActionListener(this);
        ventana.btnMostrarVehiculos.addActionListener(this);
    }

    @Override
    /**
     * actionPerformed method.
     *
     * @param e parameter
     * @return result
     */
    /**
     * actionPerformed method.
     *
     * @param e parameter
     */
    /**
     * actionPerformed method.
     *
     * @param e parameter
     */
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == ventana.btnCerrarSesion) {
            // Cerrar solo la ventana de usuario y volver a la ventana inicial
            ventana.mostrarJOption(ventana, "Has cerrado sesión.");
            ventana.dispose();

            if (ventanaPrincipal != null) {
                // si la ventanaPrincipal fue pasada, la mostramos
                ventanaPrincipal.setVisible(true);
            } else {
                // fallback seguro: reabrir la ventana de inicio principal
                VentanaInicio ventanaInicio = new VentanaInicio();

                new GestorVentanaInicio(ventanaInicio, controladorUsuario);
                ventanaInicio.setVisible(true);
            }
        } else if (source == ventana.btnAgregarAmigos) {
            amigoAgregado(controladorUsuario.agregarAmigo(usuarioActual.getCedula(), LeerAmigo()));
        } else if (source == ventana.btnVerProveedores) {
            mostrarPublicacionesProveedores();
        } else if (source == ventana.btnMostrarVehiculos) {
            mostrarVehiculosUsuario();
        }
    }

    public String LeerAmigo() {
        return ventana.leerCedulaAmigo();
    }

    /**
     *
     * @param flag
     */
    public void amigoAgregado(boolean flag) {
        if (flag) {
            ventana.mostrarJOption(ventana, "!Se ha encontrado a la persona y ha sido añadida a su lista de amigos¡");
        } else {
            ventana.mostrarJOption(ventana, "No se ha encontrado ningun usuario con ese numero de identificacion");
        }
    }

    /**
     * mostrarPublicacionesProveedores method.
     *
     * @return result
     */
    /**
     * mostrarPublicacionesProveedores method.
     */
    /**
     * mostrarPublicacionesProveedores method.
     */
    private void mostrarPublicacionesProveedores() {
        if (repoPublicaciones == null || repoPublicaciones.listarPublicaciones().isEmpty()) {
            ventana.mostrarJOption(ventana, "No hay publicaciones de proveedores todavía.");
            return;
        }

        StringBuilder sb = new StringBuilder("📦 Publicaciones de proveedores:\n\n");
        for (Publicacion pub : repoPublicaciones.listarPublicaciones()) {
            // Publicacion.toString() ya formatea título, tipo, autor y fecha
            sb.append(pub.toString()).append("\n");
        }
        ventana.mostrarStringObjeto(ventana, sb, "Proveedores", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * mostrarVehiculosUsuario method.
     *
     * @return result
     */
    /**
     * mostrarVehiculosUsuario method.
     */
    /**
     * mostrarVehiculosUsuario method.
     */
    private void mostrarVehiculosUsuario() {
        StringBuilder sb = new StringBuilder();
        if (usuarioActual == null || usuarioActual.getVehiculos().isEmpty()) {
            sb.append("No tienes vehículos registrados.\n");
        } else {
            sb.append("🚗 Tus vehículos:\n\n");
            for (Vehiculo v : usuarioActual.getVehiculos()) {
                sb.append("- ").append(v.getMarca())
                        .append(" ").append(v.getModelo())
                        .append(" | Placa: ").append(v.getPlaca()).append("\n");
            }
        }
        JOptionPane.showMessageDialog(ventana, sb.toString(), "Mis Vehículos", JOptionPane.INFORMATION_MESSAGE);

        // Opciones: Agregar / Eliminar / Cerrar
        String[] opciones = {"Agregar vehículo", "Eliminar vehículo", "Cerrar"};
        int eleccion = JOptionPane.showOptionDialog(
                ventana,
                "¿Qué acción deseas realizar?",
                "Gestión de Vehículos",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]
        );

        if (eleccion == 0) { // Agregar
            abrirVentanaRegistroVehiculo();
        } else if (eleccion == 1) { // Eliminar
            eliminarVehiculo();
        }
    }

    /**
     * abrirVentanaRegistroVehiculo method.
     *
     * @return result
     */
    /**
     * abrirVentanaRegistroVehiculo method.
     */
    /**
     * abrirVentanaRegistroVehiculo method.
     */
    private void abrirVentanaRegistroVehiculo() {
        // Usar el constructor existente en el proyecto
        VentanaRegistroVehiculo ventanaRegistro = new VentanaRegistroVehiculo();
        ControladorVehiculo controladorVehiculo = new ControladorVehiculo();
        // Si ya aplicaste la sobrecarga del GestorRegistroVehiculo para pasar usuarioActual,
        // cámbialo aquí a la versión con usuarioActual; mientras tanto usamos la versión existente.
        new GestorRegistroVehiculo(ventanaRegistro, controladorVehiculo);
        ventana.setVisible(false); // ocultar temporalmente la ventana de inicio
    }

    /**
     * eliminarVehiculo method.
     *
     * @return result
     */
    /**
     * eliminarVehiculo method.
     */
    /**
     * eliminarVehiculo method.
     */
    private void eliminarVehiculo() {
        if (usuarioActual == null || usuarioActual.getVehiculos().isEmpty()) {
            JOptionPane.showMessageDialog(ventana, "No hay vehículos para eliminar.");
            return;
        }

        String[] placas = usuarioActual.getVehiculos().stream()
                .map(Vehiculo::getPlaca)
                .toArray(String[]::new);

        String seleccion = (String) JOptionPane.showInputDialog(
                ventana,
                "Selecciona el vehículo a eliminar:",
                "Eliminar Vehículo",
                JOptionPane.PLAIN_MESSAGE,
                null,
                placas,
                placas[0]
        );

        if (seleccion != null) {
            usuarioActual.getVehiculos().removeIf(v -> v.getPlaca().equalsIgnoreCase(seleccion));
            JOptionPane.showMessageDialog(ventana, "Vehículo eliminado: " + seleccion);
        }
    }
}
