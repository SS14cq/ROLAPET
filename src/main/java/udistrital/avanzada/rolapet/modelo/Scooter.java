package udistrital.avanzada.rolapet.modelo;

/**
 * Clase Scooter que extiende Vehiculo.
 * Representa un scooter eléctrico con características específicas adicionales
 * como llantas off-road e iluminación avanzada.
 * 
 * @author Sarita
 * @version 1.1, 25-09-2025
 */
/**
 * Class Scooter.
 */
/**
 * Class Scooter.
 */
public class Scooter extends Vehiculo {
    private boolean llantasOffRoad;
    private boolean iluminacionAvanzada;

    /**
     * Constructor que crea un scooter con sus características específicas
     * además de las propiedades comunes a todos los vehículos.
     * 
     * @param marca marca del vehículo
     * @param modelo modelo del vehículo
     * @param autonomiaKm autonomía en kilómetros
     * @param potenciaNominalW potencia nominal en vatios
     * @param velocidadMaxKmh velocidad máxima en km/h
     * @param llantasOffRoad indica si tiene llantas off-road
     * @param iluminacionAvanzada indica si cuenta con iluminación avanzada
     */
    public Scooter(String marca, String modelo, String placa, double autonomiaKm, int potenciaNominalW, double velocidadMaxKmh,
                   boolean llantasOffRoad, boolean iluminacionAvanzada) {
        super(marca, modelo, placa, autonomiaKm, potenciaNominalW, velocidadMaxKmh);
        this.llantasOffRoad = llantasOffRoad;
        this.iluminacionAvanzada = iluminacionAvanzada;
    }

/**
 * isLlantasOffRoad method.
 * @return result
 */
/**
 * isLlantasOffRoad method.
 * @return result
 */
/**
 * isLlantasOffRoad method.
 * @return result
 */
    public boolean isLlantasOffRoad() { return llantasOffRoad; }
/**
 * setLlantasOffRoad method.
 * @param llantasOffRoad parameter
 * @return result
 */
/**
 * setLlantasOffRoad method.
 * @param llantasOffRoad parameter
 */
/**
 * setLlantasOffRoad method.
 * @param llantasOffRoad parameter
 */
    public void setLlantasOffRoad(boolean llantasOffRoad) { this.llantasOffRoad = llantasOffRoad; }

/**
 * isIluminacionAvanzada method.
 * @return result
 */
/**
 * isIluminacionAvanzada method.
 * @return result
 */
/**
 * isIluminacionAvanzada method.
 * @return result
 */
    public boolean isIluminacionAvanzada() { return iluminacionAvanzada; }
/**
 * setIluminacionAvanzada method.
 * @param iluminacionAvanzada parameter
 * @return result
 */
/**
 * setIluminacionAvanzada method.
 * @param iluminacionAvanzada parameter
 */
/**
 * setIluminacionAvanzada method.
 * @param iluminacionAvanzada parameter
 */
    public void setIluminacionAvanzada(boolean iluminacionAvanzada) { this.iluminacionAvanzada = iluminacionAvanzada; }

    /**
     * Retorna la descripción completa del vehículo incluyendo las características propias
     * del scooter eléctrico.
     * 
     * @return descripción detallada del vehículo
     */
    @Override
/**
 * getDescripcion method.
 * @return result
 */
/**
 * getDescripcion method.
 * @return result
 */
/**
 * getDescripcion method.
 * @return result
 */
    public String getDescripcion() {
        return super.getDescripcion() +
                ", Llantas off-road: " + (llantasOffRoad ? "Sí" : "No") +
                ", Iluminación avanzada: " + (iluminacionAvanzada ? "Sí" : "No");
    }
}
