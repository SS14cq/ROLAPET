package udistrital.avanzada.rolapet.modelo;

/**
 * Clase que representa un vehículo genérico.
 * Contiene los atributos básicos comunes a todos los vehículos eléctricos de baja potencia.
 * Proporciona métodos para acceder y modificar estos atributos, así como una descripción del vehículo.
 * 
 * @author Sarita
 * @version 1.1, 25-09-2025
 */
/**
 * Class Vehiculo.
 */
/**
 * Class Vehiculo.
 */
public class Vehiculo {
    private String marca;
    private String modelo;
    private String placa;                // placa del vehículo
    private double autonomiaKm;          // autonomía en kilómetros
    private int potenciaNominalW;        // potencia nominal en vatios
    private double velocidadMaxKmh;      // velocidad máxima en km/h

    /**
     * Constructor que inicializa un vehículo con los atributos especificados.
     * 
     * @param marca marca del vehículo
     * @param modelo modelo del vehículo
     * @param autonomiaKm autonomía en kilómetros
     * @param potenciaNominalW potencia nominal en vatios
     * @param velocidadMaxKmh velocidad máxima en km/h
     */
    public Vehiculo(String marca, String modelo, String placa, double autonomiaKm, int potenciaNominalW, double velocidadMaxKmh) {
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.autonomiaKm = autonomiaKm;
        this.potenciaNominalW = potenciaNominalW;
        this.velocidadMaxKmh = velocidadMaxKmh;
    }

    // Getters y Setters

/**
 * getMarca method.
 * @return result
 */
/**
 * getMarca method.
 * @return result
 */
/**
 * getMarca method.
 * @return result
 */
    public String getMarca() { return marca; }
/**
 * setMarca method.
 * @param marca parameter
 * @return result
 */
/**
 * setMarca method.
 * @param marca parameter
 */
/**
 * setMarca method.
 * @param marca parameter
 */
    public void setMarca(String marca) { this.marca = marca; }

/**
 * getModelo method.
 * @return result
 */
/**
 * getModelo method.
 * @return result
 */
/**
 * getModelo method.
 * @return result
 */
    public String getModelo() { return modelo; }
/**
 * setModelo method.
 * @param modelo parameter
 * @return result
 */
/**
 * setModelo method.
 * @param modelo parameter
 */
/**
 * setModelo method.
 * @param modelo parameter
 */
    public void setModelo(String modelo) { this.modelo = modelo; }

/**
 * getPlaca method.
 * @return result
 */
/**
 * getPlaca method.
 * @return result
 */
/**
 * getPlaca method.
 * @return result
 */
    public String getPlaca() { return placa; }
/**
 * setPlaca method.
 * @param placa parameter
 * @return result
 */
/**
 * setPlaca method.
 * @param placa parameter
 */
/**
 * setPlaca method.
 * @param placa parameter
 */
    public void setPlaca(String placa) { this.placa = placa; }

/**
 * getAutonomiaKm method.
 * @return result
 */
/**
 * getAutonomiaKm method.
 * @return result
 */
/**
 * getAutonomiaKm method.
 * @return result
 */
    public double getAutonomiaKm() { return autonomiaKm; }
/**
 * setAutonomiaKm method.
 * @param autonomiaKm parameter
 * @return result
 */
/**
 * setAutonomiaKm method.
 * @param autonomiaKm parameter
 */
/**
 * setAutonomiaKm method.
 * @param autonomiaKm parameter
 */
    public void setAutonomiaKm(double autonomiaKm) { this.autonomiaKm = autonomiaKm; }

/**
 * getPotenciaNominalW method.
 * @return result
 */
/**
 * getPotenciaNominalW method.
 * @return result
 */
/**
 * getPotenciaNominalW method.
 * @return result
 */
    public int getPotenciaNominalW() { return potenciaNominalW; }
/**
 * setPotenciaNominalW method.
 * @param potenciaNominalW parameter
 * @return result
 */
/**
 * setPotenciaNominalW method.
 * @param potenciaNominalW parameter
 */
/**
 * setPotenciaNominalW method.
 * @param potenciaNominalW parameter
 */
    public void setPotenciaNominalW(int potenciaNominalW) { this.potenciaNominalW = potenciaNominalW; }

/**
 * getVelocidadMaxKmh method.
 * @return result
 */
/**
 * getVelocidadMaxKmh method.
 * @return result
 */
/**
 * getVelocidadMaxKmh method.
 * @return result
 */
    public double getVelocidadMaxKmh() { return velocidadMaxKmh; }
/**
 * setVelocidadMaxKmh method.
 * @param velocidadMaxKmh parameter
 * @return result
 */
/**
 * setVelocidadMaxKmh method.
 * @param velocidadMaxKmh parameter
 */
/**
 * setVelocidadMaxKmh method.
 * @param velocidadMaxKmh parameter
 */
    public void setVelocidadMaxKmh(double velocidadMaxKmh) { this.velocidadMaxKmh = velocidadMaxKmh; }

    /**
     * Método que retorna una descripción completa del vehículo con sus características principales.
     * 
     * @return descripción formateada del vehículo
     */
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
        return String.format("Marca: %s, Modelo: %s, Placa: %s, Autonomía: %.1f km, Potencia: %d W, Velocidad máxima: %.1f km/h",
                marca, modelo, placa, autonomiaKm, potenciaNominalW, velocidadMaxKmh);
    }
}
