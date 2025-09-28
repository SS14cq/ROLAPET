package udistrital.avanzada.rolapet.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Repositorio genérico para almacenar y gestionar vehículos de cualquier tipo.
 * Permite agregar, buscar, eliminar y listar vehículos.
 * Compatible con Vehiculo, Scooter, MotoElectrica, etc.
 * 
 * @author Sarita
 * @version 1.0, 27-09-2025
 */
public class RepositorioVehiculos {
    private List<Vehiculo> vehiculos;

    public RepositorioVehiculos() {
        vehiculos = new ArrayList<>();
    }

    /**
     * Agrega un vehículo al repositorio.
     */
    public void agregarVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }

    /**
     * Elimina un vehículo del repositorio.
     */
    public void eliminarVehiculo(Vehiculo vehiculo) {
        vehiculos.remove(vehiculo);
    }

    /**
     * Busca un vehículo por su placa.
     */
    public Vehiculo buscarPorPlaca(String placa) {
        for (Vehiculo v : vehiculos) {
            if (v.getPlaca().equalsIgnoreCase(placa)) {
                return v;
            }
        }
        return null;
    }

    /**
     * Devuelve la lista de todos los vehículos.
     */
    public List<Vehiculo> listarVehiculos() {
        return new ArrayList<>(vehiculos);
    }
}
