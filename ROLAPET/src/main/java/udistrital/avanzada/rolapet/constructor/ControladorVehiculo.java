package udistrital.avanzada.rolapet.constructor;

import udistrital.avanzada.rolapet.modelo.Vehiculo;

import java.util.ArrayList;
import java.util.List;

public class ControladorVehiculo {
    private List<Vehiculo> vehiculos;

    public ControladorVehiculo() {
        vehiculos = new ArrayList<>();
    }

    /**
     * Registra un vehículo si no existe ya en la lista.
     * Se puede personalizar el criterio de igualdad, aquí se usa marca + modelo como ejemplo.
     * 
     * @param vehiculo vehículo a registrar
     * @return true si se registró exitosamente, false si ya existe
     */
    public boolean registrarVehiculo(Vehiculo vehiculo) {
        if (buscarVehiculo(vehiculo.getMarca(), vehiculo.getModelo()) != null) {
            return false; // vehículo ya existe
        }
        vehiculos.add(vehiculo);
        return true;
    }

    /**
     * Busca un vehículo por marca y modelo.
     * 
     * @param marca marca del vehículo
     * @param modelo modelo del vehículo
     * @return Vehiculo encontrado o null si no existe
     */
    public Vehiculo buscarVehiculo(String marca, String modelo) {
        for (Vehiculo v : vehiculos) {
            if (v.getMarca().equalsIgnoreCase(marca) && v.getModelo().equalsIgnoreCase(modelo)) {
                return v;
            }
        }
        return null;
    }

    /**
     * Obtiene la lista de vehículos registrados.
     * 
     * @return lista de vehículos
     */
    public List<Vehiculo> obtenerVehiculos() {
        return vehiculos;
    }
}
