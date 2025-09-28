package udistrital.avanzada.rolapet.constructor;

import udistrital.avanzada.rolapet.modelo.Vehiculo;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase ControladorVehiculo que gestiona una colección de objetos Vehiculo.
 * Permite registrar nuevos vehículos, buscar vehículos por marca y modelo,
 * y obtener la lista completa de vehículos registrados.
 * <p>
 * Se asegura de no registrar vehículos duplicados basándose en la combinación
 * de marca y modelo.
 * </p>
 * 
 * @author Sarita
 * @version 1.2, 25-09-2025
 */
/**
 * Class ControladorVehiculo.
 */
/**
 * Class ControladorVehiculo.
 */
public class ControladorVehiculo {
    private List<Vehiculo> vehiculos;

    /**
     * Construye un nuevo controlador inicializando la lista interna de vehículos.
     */
    public ControladorVehiculo() {
        vehiculos = new ArrayList<>();
    }

    /**
     * Registra un vehículo si no existe ya en la lista.
     * El criterio de igualdad se basa en la combinación de marca y modelo,
     * sin distinguir mayúsculas o minúsculas.
     * 
     * @param vehiculo vehículo a registrar
     * @return true si se registró exitosamente, false si ya existe un vehículo
     *         con la misma marca y modelo
     */
/**
 * registrarVehiculo method.
 * @param vehiculo parameter
 * @return result
 */
/**
 * registrarVehiculo method.
 * @param vehiculo parameter
 * @return result
 */
/**
 * registrarVehiculo method.
 * @param vehiculo parameter
 * @return result
 */
    public boolean registrarVehiculo(Vehiculo vehiculo) {
        if (buscarVehiculo(vehiculo.getMarca(), vehiculo.getModelo()) != null) {
            return false; // vehículo ya existe
        }
        vehiculos.add(vehiculo);
        return true;
    }

    /**
     * Busca un vehículo por su marca y modelo.
     * La búsqueda no distingue entre mayúsculas y minúsculas.
     * 
     * @param marca  marca del vehículo a buscar
     * @param modelo modelo del vehículo a buscar
     * @return el Vehiculo encontrado o null si no existe ninguno con la marca y modelo indicados
     */
/**
 * buscarVehiculo method.
 * @param marca parameter
 * @param modelo parameter
 * @return result
 */
/**
 * buscarVehiculo method.
 * @param marca parameter
 * @param modelo parameter
 * @return result
 */
/**
 * buscarVehiculo method.
 * @param marca parameter
 * @param modelo parameter
 * @return result
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
     * Obtiene la lista completa de vehículos registrados en el controlador.
     * 
     * @return lista de vehículos registrados
     */
/**
 * obtenerVehiculos method.
 * @return result
 */
/**
 * obtenerVehiculos method.
 * @return result
 */
/**
 * obtenerVehiculos method.
 * @return result
 */
    public List<Vehiculo> obtenerVehiculos() {
        return vehiculos;
    }
}
