package udistrital.avanzada.rolapet.constructor;

import udistrital.avanzada.rolapet.modelo.MotoElectrica;
import udistrital.avanzada.rolapet.modelo.Scooter;
import udistrital.avanzada.rolapet.modelo.Vehiculo;
import udistrital.avanzada.rolapet.modelo.Usuario;
import udistrital.avanzada.rolapet.modelo.RepositorioUsuarios;
import udistrital.avanzada.rolapet.vista.VentanaRegistroVehiculo;
import udistrital.avanzada.rolapet.vista.VentanaInicioUsuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class GestorRegistroVehiculo.
 */
/**
 * Class GestorRegistroVehiculo.
 */
public class GestorRegistroVehiculo implements ActionListener {
    private VentanaRegistroVehiculo ventana;
    private ControladorVehiculo controladorVehiculo;
    private RepositorioUsuarios repositorioUsuarios;
    private Usuario usuarioActual;

    /**
     * Constructor original (mantengo para compatibilidad: crea usuario de prueba)
     */
    public GestorRegistroVehiculo(VentanaRegistroVehiculo ventana, ControladorVehiculo controladorVehiculo) {
        this.ventana = ventana;
        this.controladorVehiculo = controladorVehiculo;

        // Usuario de prueba (comportamiento original)
        this.usuarioActual = new Usuario("Sofia", "Sofia14@", "Sofia", "Gomez",
                "1234567890", "sofia@email.com", "3001234567") {};
        this.repositorioUsuarios = new RepositorioUsuarios();
        repositorioUsuarios.agregarUsuario(usuarioActual);

        this.ventana.setVisible(true);
        this.ventana.getBtnRegistrar().addActionListener(this);
        this.ventana.getBtnCancelar().addActionListener(this);
    }

    /**
     * Nueva sobrecarga: recibe el usuario actual y el repositorio para que
     * los vehículos se asocien correctamente al usuario que está logueado.
     */
    public GestorRegistroVehiculo(VentanaRegistroVehiculo ventana,
                                  ControladorVehiculo controladorVehiculo,
                                  Usuario usuarioActual,
                                  RepositorioUsuarios repositorioUsuarios) {
        this.ventana = ventana;
        this.controladorVehiculo = controladorVehiculo;
        this.usuarioActual = usuarioActual;
        this.repositorioUsuarios = (repositorioUsuarios == null) ? new RepositorioUsuarios() : repositorioUsuarios;

        // Asegurarse de que el usuario esté en el repositorio
        if (this.usuarioActual != null && this.repositorioUsuarios.buscarPorNombreUsuario(this.usuarioActual.getNombreUsuario()) == null) {
            this.repositorioUsuarios.agregarUsuario(this.usuarioActual);
        }

        this.ventana.setVisible(true);
        this.ventana.getBtnRegistrar().addActionListener(this);
        this.ventana.getBtnCancelar().addActionListener(this);
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

        if (source == ventana.getBtnRegistrar()) {
            // Obtener datos del formulario
            String tipo = ventana.getTipoVehiculo();
            String marca = ventana.getMarca();
            String modelo = ventana.getModelo();
            String placa = ventana.getPlaca();
            double autonomia = ventana.getAutonomia();
            int potencia = ventana.getPotencia();
            double velocidad = ventana.getVelocidad();

            // Validaciones (idénticas a tu lógica previa)
            if (placa.isEmpty() || !placa.matches("[A-Za-z0-9]{1,6}")) {
                JOptionPane.showMessageDialog(ventana, "La placa debe contener solo letras y números, máximo 6 caracteres.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (marca.isEmpty()) {
                JOptionPane.showMessageDialog(ventana, "La marca no puede estar vacía.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (modelo.isEmpty()) {
                JOptionPane.showMessageDialog(ventana, "El modelo no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (autonomia <= 0 || potencia <= 0 || velocidad <= 0) {
                JOptionPane.showMessageDialog(ventana, "Autonomía, potencia y velocidad deben ser positivos.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Validar placa duplicada
            for (Vehiculo v : controladorVehiculo.obtenerVehiculos()) {
                if (v.getPlaca().equalsIgnoreCase(placa)) {
                    JOptionPane.showMessageDialog(ventana, "Ya existe un vehículo con esa placa.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            // Crear vehículo según tipo
            Vehiculo vehiculo = null;
            if ("Scooter".equals(tipo)) {
                vehiculo = new Scooter(marca, modelo, placa, autonomia, potencia, velocidad,
                        ventana.isLlantasOffRoad(), ventana.isIluminacionAvanzada());
            } else if ("Motoeléctrica".equals(tipo)) {
                vehiculo = new MotoElectrica(marca, modelo, placa, autonomia, potencia, velocidad,
                        ventana.isFrenosDisco(), ventana.isSuspensionAlta(),
                        ventana.isLucesLED(), ventana.isAlarmaAntiRobo());
            }

            if (vehiculo != null) {
                if (controladorVehiculo.registrarVehiculo(vehiculo)) {
                    // --- AÑADIDO: asociar vehículo al usuario actual si existe ---
                    if (usuarioActual != null) {
                        usuarioActual.agregarVehiculo(vehiculo);
                    }
                    // (opcional) asegurar usuario en repositorio
                    if (repositorioUsuarios != null && usuarioActual != null &&
                            repositorioUsuarios.buscarPorNombreUsuario(usuarioActual.getNombreUsuario()) == null) {
                        repositorioUsuarios.agregarUsuario(usuarioActual);
                    }
                    // --------------------------------------------------------

                    JOptionPane.showMessageDialog(ventana, "Vehículo registrado exitosamente");
                    ventana.limpiarCampos();
                    ventana.dispose();

                    // Obtener repositorio de publicaciones (igual que antes)
                    udistrital.avanzada.rolapet.modelo.RepositorioPublicaciones repoPublicacionesGlobal =
                            GestorSeleccionTipoProveedor.getRepoPublicacionesGlobal();
                    if (repoPublicacionesGlobal == null) {
                        repoPublicacionesGlobal = new udistrital.avanzada.rolapet.modelo.RepositorioPublicaciones();
                    }

                    JFrame ventanaPrincipal = null;
                    if (ventana instanceof udistrital.avanzada.rolapet.vista.VentanaRegistroVehiculo) {
                        ventanaPrincipal = ((udistrital.avanzada.rolapet.vista.VentanaRegistroVehiculo) ventana).getOwnerWindow();
                    }
                    VentanaInicioUsuario ventanaInicioUsuario = new VentanaInicioUsuario(usuarioActual, repositorioUsuarios, repoPublicacionesGlobal, ventanaPrincipal);
                    new GestorVentanaInicioUsuario(ventanaInicioUsuario, usuarioActual, repositorioUsuarios, repoPublicacionesGlobal, ventanaPrincipal);
                    ventanaInicioUsuario.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(ventana, "Ya existe un vehículo con esos datos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

        } else if (source == ventana.getBtnCancelar()) {
            ventana.dispose();
        }
    }
}
