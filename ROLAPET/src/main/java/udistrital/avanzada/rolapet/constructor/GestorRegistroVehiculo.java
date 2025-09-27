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
 * Clase GestorRegistroVehiculo que controla la lógica para registrar vehículos
 * a través de una interfaz gráfica. Gestiona la interacción con la ventana de registro
 * y usa un controlador para manejar la colección de vehículos.
 * <p>
 * Soporta el registro de vehículos tipo Scooter y Motoeléctrica, validando los campos
 * necesarios y evitando duplicados.
 * </p>
 * 
 * @author Sarita
 * @version 1.2, 25-09-2025
 */
public class GestorRegistroVehiculo implements ActionListener {
    private VentanaRegistroVehiculo ventana;
    private ControladorVehiculo controladorVehiculo;  // Clase encargada de manejar la lista de vehículos
    private RepositorioUsuarios repositorioUsuarios;
    private Usuario usuarioActual;

    /**
     * Constructor que inicializa la ventana y controlador,
     * además configura los listeners para los botones de la ventana.
     * 
     * @param ventana instancia de la ventana de registro de vehículos
     * @param controladorVehiculo instancia del controlador de vehículos
     */
    public GestorRegistroVehiculo(VentanaRegistroVehiculo ventana, ControladorVehiculo controladorVehiculo) {
        this.ventana = ventana;
        this.controladorVehiculo = controladorVehiculo;
        // Crear usuario Sofia y repositorio
        this.usuarioActual = new Usuario("Sofia", "Sofia14@", "Sofia", "Gomez", "1234567890", "sofia@email.com", "3001234567") {};
        this.repositorioUsuarios = new RepositorioUsuarios();
        repositorioUsuarios.agregarUsuario(usuarioActual);

        this.ventana.setVisible(true);
        this.ventana.getBtnRegistrar().addActionListener(this);
        this.ventana.getBtnCancelar().addActionListener(this);
    }

    /**
     * Maneja los eventos de acción generados por los botones de registro y cancelación.
     * Valida los datos ingresados, crea el vehículo correspondiente y lo registra si no está duplicado.
     * 
     * @param e evento de acción disparado
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == ventana.getBtnRegistrar()) {
            // Obtener datos generales
            String tipo = ventana.getTipoVehiculo();
            String marca = ventana.getMarca();
            String modelo = ventana.getModelo();
            String placa = ventana.getPlaca();
            double autonomia = ventana.getAutonomia();
            int potencia = ventana.getPotencia();
            double velocidad = ventana.getVelocidad();

            // Validaciones
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
            if (autonomia <= 0) {
                JOptionPane.showMessageDialog(ventana, "La autonomía debe ser un valor positivo.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (potencia <= 0) {
                JOptionPane.showMessageDialog(ventana, "La potencia debe ser un valor positivo.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (velocidad <= 0) {
                JOptionPane.showMessageDialog(ventana, "La velocidad debe ser un valor positivo.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            // Validar placa duplicada
            for (Vehiculo v : controladorVehiculo.obtenerVehiculos()) {
                if (v.getPlaca().equalsIgnoreCase(placa)) {
                    JOptionPane.showMessageDialog(ventana, "Ya existe un vehículo con esa placa.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            // ...ya definido y validado placa arriba, eliminar duplicados...
            // Validar placa duplicada
            for (Vehiculo v : controladorVehiculo.obtenerVehiculos()) {
                if (v.getPlaca().equalsIgnoreCase(placa)) {
                    JOptionPane.showMessageDialog(ventana, "Ya existe un vehículo con esa placa.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            Vehiculo vehiculo = null;
            if ("Scooter".equals(tipo)) {
                boolean llantasOffRoad = ventana.isLlantasOffRoad();
                boolean iluminacion = ventana.isIluminacionAvanzada();
                vehiculo = new Scooter(marca, modelo, placa, autonomia, potencia, velocidad, llantasOffRoad, iluminacion);
            } else if ("Motoeléctrica".equals(tipo)) {
                boolean frenosDisco = ventana.isFrenosDisco();
                boolean suspension = ventana.isSuspensionAlta();
                boolean lucesLED = ventana.isLucesLED();
                boolean alarma = ventana.isAlarmaAntiRobo();
                vehiculo = new MotoElectrica(marca, modelo, placa, autonomia, potencia, velocidad, frenosDisco, suspension, lucesLED, alarma);
            }

            if (vehiculo != null) {
                if (controladorVehiculo.registrarVehiculo(vehiculo)) {
                    JOptionPane.showMessageDialog(ventana, "Vehículo registrado exitosamente");
                    ventana.limpiarCampos();
                    ventana.dispose();
                    // Mostrar ventana de inicio usuario con publicaciones reales y pasar ventana principal
                    udistrital.avanzada.rolapet.modelo.RepositorioPublicaciones repoPublicacionesGlobal = udistrital.avanzada.rolapet.constructor.GestorSeleccionTipoProveedor.getRepoPublicacionesGlobal();
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
            // Aquí puedes abrir ventana anterior si aplica
        }
    }
}
