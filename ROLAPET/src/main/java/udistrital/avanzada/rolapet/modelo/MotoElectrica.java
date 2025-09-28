package udistrital.avanzada.rolapet.modelo;

/**
 * Clase MotoElectrica que extiende Vehiculo.
 * Representa una motocicleta eléctrica con características específicas adicionales
 * como frenos de disco, suspensión de alta calidad, luces LED y alarma antirrobo.
 * 
 * @author Sarita
 * @version 1.1, 25-09-2025
 */
/**
 * Class MotoElectrica.
 */
/**
 * Class MotoElectrica.
 */
public class MotoElectrica extends Vehiculo {
    private boolean frenosDisco;
    private boolean suspensionAltaCalidad;
    private boolean lucesLED;
    private boolean alarmaAntiRobo;

    /**
     * Constructor que crea una moto eléctrica con sus características específicas
     * además de las propiedades comunes a todos los vehículos.
     * 
     * @param marca marca del vehículo
     * @param modelo modelo del vehículo
     * @param autonomiaKm autonomía en kilómetros
     * @param potenciaNominalW potencia nominal en vatios
     * @param velocidadMaxKmh velocidad máxima en km/h
     * @param frenosDisco indica si tiene frenos de disco
     * @param suspensionAltaCalidad indica si tiene suspensión de alta calidad
     * @param lucesLED indica si cuenta con luces LED
     * @param alarmaAntiRobo indica si tiene alarma anti robo
     */
    public MotoElectrica(String marca, String modelo, String placa, double autonomiaKm, int potenciaNominalW, double velocidadMaxKmh,
                         boolean frenosDisco, boolean suspensionAltaCalidad, boolean lucesLED, boolean alarmaAntiRobo) {
        super(marca, modelo, placa, autonomiaKm, potenciaNominalW, velocidadMaxKmh);
        this.frenosDisco = frenosDisco;
        this.suspensionAltaCalidad = suspensionAltaCalidad;
        this.lucesLED = lucesLED;
        this.alarmaAntiRobo = alarmaAntiRobo;
    }

/**
 * isFrenosDisco method.
 * @return result
 */
/**
 * isFrenosDisco method.
 * @return result
 */
/**
 * isFrenosDisco method.
 * @return result
 */
    public boolean isFrenosDisco() { return frenosDisco; }
/**
 * setFrenosDisco method.
 * @param frenosDisco parameter
 * @return result
 */
/**
 * setFrenosDisco method.
 * @param frenosDisco parameter
 */
/**
 * setFrenosDisco method.
 * @param frenosDisco parameter
 */
    public void setFrenosDisco(boolean frenosDisco) { this.frenosDisco = frenosDisco; }

/**
 * isSuspensionAltaCalidad method.
 * @return result
 */
/**
 * isSuspensionAltaCalidad method.
 * @return result
 */
/**
 * isSuspensionAltaCalidad method.
 * @return result
 */
    public boolean isSuspensionAltaCalidad() { return suspensionAltaCalidad; }
/**
 * setSuspensionAltaCalidad method.
 * @param suspensionAltaCalidad parameter
 * @return result
 */
/**
 * setSuspensionAltaCalidad method.
 * @param suspensionAltaCalidad parameter
 */
/**
 * setSuspensionAltaCalidad method.
 * @param suspensionAltaCalidad parameter
 */
    public void setSuspensionAltaCalidad(boolean suspensionAltaCalidad) { this.suspensionAltaCalidad = suspensionAltaCalidad; }

/**
 * isLucesLED method.
 * @return result
 */
/**
 * isLucesLED method.
 * @return result
 */
/**
 * isLucesLED method.
 * @return result
 */
    public boolean isLucesLED() { return lucesLED; }
/**
 * setLucesLED method.
 * @param lucesLED parameter
 * @return result
 */
/**
 * setLucesLED method.
 * @param lucesLED parameter
 */
/**
 * setLucesLED method.
 * @param lucesLED parameter
 */
    public void setLucesLED(boolean lucesLED) { this.lucesLED = lucesLED; }

/**
 * isAlarmaAntiRobo method.
 * @return result
 */
/**
 * isAlarmaAntiRobo method.
 * @return result
 */
/**
 * isAlarmaAntiRobo method.
 * @return result
 */
    public boolean isAlarmaAntiRobo() { return alarmaAntiRobo; }
/**
 * setAlarmaAntiRobo method.
 * @param alarmaAntiRobo parameter
 * @return result
 */
/**
 * setAlarmaAntiRobo method.
 * @param alarmaAntiRobo parameter
 */
/**
 * setAlarmaAntiRobo method.
 * @param alarmaAntiRobo parameter
 */
    public void setAlarmaAntiRobo(boolean alarmaAntiRobo) { this.alarmaAntiRobo = alarmaAntiRobo; }

    /**
     * Retorna la descripción completa del vehículo incluyendo las características propias
     * de la moto eléctrica.
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
                ", Frenos de disco: " + (frenosDisco ? "Sí" : "No") +
                ", Suspensión alta calidad: " + (suspensionAltaCalidad ? "Sí" : "No") +
                ", Luces LED: " + (lucesLED ? "Sí" : "No") +
                ", Alarma anti robo: " + (alarmaAntiRobo ? "Sí" : "No");
    }
}
