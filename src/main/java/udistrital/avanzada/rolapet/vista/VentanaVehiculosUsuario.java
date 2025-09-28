package udistrital.avanzada.rolapet.vista;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import udistrital.avanzada.rolapet.modelo.Vehiculo;

/**
 * Ventana para mostrar y gestionar los vehículos registrados por el usuario.
 */
/**
 * Class VentanaVehiculosUsuario.
 */
/**
 * Class VentanaVehiculosUsuario.
 */
public class VentanaVehiculosUsuario extends JFrame {
    private JTable tablaVehiculos;
    private JButton btnAgregarVehiculo;
    private JButton btnEditarVehiculo;
    private JButton btnEliminarVehiculo;
    private JButton btnCerrar;

    public VentanaVehiculosUsuario(List<Vehiculo> vehiculos) {
        setTitle("Mis Vehículos");
        setSize(700, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Tabla de vehículos
        String[] columnas = {"Marca", "Modelo", "Placa", "Autonomía", "Potencia", "Velocidad"};
        Object[][] datos = new Object[vehiculos.size()][columnas.length];
        for (int i = 0; i < vehiculos.size(); i++) {
            Vehiculo v = vehiculos.get(i);
            datos[i][0] = v.getMarca();
            datos[i][1] = v.getModelo();
            datos[i][2] = v.getPlaca();
            datos[i][3] = v.getAutonomiaKm();
            datos[i][4] = v.getPotenciaNominalW();
            datos[i][5] = v.getVelocidadMaxKmh();
        }
        tablaVehiculos = new JTable(datos, columnas);
        JScrollPane scroll = new JScrollPane(tablaVehiculos);
        add(scroll, BorderLayout.CENTER);

        // Panel de botones
        JPanel panelBotones = new JPanel();
        btnAgregarVehiculo = new JButton("Agregar Vehículo");
        btnEditarVehiculo = new JButton("Editar Vehículo");
        btnEliminarVehiculo = new JButton("Eliminar Vehículo");
        btnCerrar = new JButton("Cerrar");
        panelBotones.add(btnAgregarVehiculo);
        panelBotones.add(btnEditarVehiculo);
        panelBotones.add(btnEliminarVehiculo);
        panelBotones.add(btnCerrar);
        add(panelBotones, BorderLayout.SOUTH);
    }

/**
 * getBtnAgregarVehiculo method.
 * @return result
 */
/**
 * getBtnAgregarVehiculo method.
 * @return result
 */
/**
 * getBtnAgregarVehiculo method.
 * @return result
 */
    public JButton getBtnAgregarVehiculo() { return btnAgregarVehiculo; }
/**
 * getBtnEditarVehiculo method.
 * @return result
 */
/**
 * getBtnEditarVehiculo method.
 * @return result
 */
/**
 * getBtnEditarVehiculo method.
 * @return result
 */
    public JButton getBtnEditarVehiculo() { return btnEditarVehiculo; }
/**
 * getBtnEliminarVehiculo method.
 * @return result
 */
/**
 * getBtnEliminarVehiculo method.
 * @return result
 */
/**
 * getBtnEliminarVehiculo method.
 * @return result
 */
    public JButton getBtnEliminarVehiculo() { return btnEliminarVehiculo; }
/**
 * getBtnCerrar method.
 * @return result
 */
/**
 * getBtnCerrar method.
 * @return result
 */
/**
 * getBtnCerrar method.
 * @return result
 */
    public JButton getBtnCerrar() { return btnCerrar; }
/**
 * getTablaVehiculos method.
 * @return result
 */
/**
 * getTablaVehiculos method.
 * @return result
 */
/**
 * getTablaVehiculos method.
 * @return result
 */
    public JTable getTablaVehiculos() { return tablaVehiculos; }
}
