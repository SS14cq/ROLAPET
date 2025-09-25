package udistrital.avanzada.rolapet.constructor;

import udistrital.avanzada.rolapet.modelo.MotoElectrica;
import udistrital.avanzada.rolapet.modelo.Scooter;
import udistrital.avanzada.rolapet.modelo.Vehiculo;
import udistrital.avanzada.rolapet.vista.VentanaRegistroVehiculo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestorRegistroVehiculo implements ActionListener {
    private VentanaRegistroVehiculo ventana;
    private ControladorVehiculo controladorVehiculo;  // Clase encargada de manejar la lista de vehículos

    public GestorRegistroVehiculo(VentanaRegistroVehiculo ventana, ControladorVehiculo controladorVehiculo) {
        this.ventana = ventana;
        this.controladorVehiculo = controladorVehiculo;

        this.ventana.setVisible(true);
        this.ventana.getBtnRegistrar().addActionListener(this);
        this.ventana.getBtnCancelar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == ventana.getBtnRegistrar()) {
            // Obtener datos generales
            String tipo = ventana.getTipoVehiculo();
            String marca = ventana.getMarca();
            String modelo = ventana.getModelo();
            double autonomia = ventana.getAutonomia();
            int potencia = ventana.getPotencia();
            double velocidad = ventana.getVelocidad();

            // Validar campos obligatorios
            if (marca.isEmpty() || modelo.isEmpty() || autonomia <= 0 || potencia <= 0 || velocidad <= 0) {
                JOptionPane.showMessageDialog(ventana, "Debe completar todos los campos obligatorios con valores válidos", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Vehiculo vehiculo = null;
            if ("Scooter".equals(tipo)) {
                boolean llantasOffRoad = ventana.isLlantasOffRoad();
                boolean iluminacion = ventana.isIluminacionAvanzada();
                vehiculo = new Scooter(marca, modelo, autonomia, potencia, velocidad, llantasOffRoad, iluminacion);
            } else if ("Motoeléctrica".equals(tipo)) {
                boolean frenosDisco = ventana.isFrenosDisco();
                boolean suspension = ventana.isSuspensionAlta();
                boolean lucesLED = ventana.isLucesLED();
                boolean alarma = ventana.isAlarmaAntiRobo();
                vehiculo = new MotoElectrica(marca, modelo, autonomia, potencia, velocidad, frenosDisco, suspension, lucesLED, alarma);
            }

            if (vehiculo != null) {
                if (controladorVehiculo.registrarVehiculo(vehiculo)) {
                    JOptionPane.showMessageDialog(ventana, "Vehículo registrado exitosamente");
                    ventana.limpiarCampos();
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
