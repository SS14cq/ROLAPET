package udistrital.avanzada.rolapet.modelo;

/**
 * Clase que representa un vehículo genérico.
 * Contiene los atributos básicos comunes a todos los vehículos eléctricos de baja potencia.
 * Proporciona métodos para acceder y modificar estos atributos, así como una descripción del vehículo.
 * 
 * @author Sarita
 * @version 1.1, 25-09-2025
 */
public class Vehiculo {
    private String marca;
    private String modelo;
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
    public Vehiculo(String marca, String modelo, double autonomiaKm, int potenciaNominalW, double velocidadMaxKmh) {
        this.marca = marca;
        this.modelo = modelo;
        this.autonomiaKm = autonomiaKm;
        this.potenciaNominalW = potenciaNominalW;
        this.velocidadMaxKmh = velocidadMaxKmh;
    }

    // Getters y Setters

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public double getAutonomiaKm() { return autonomiaKm; }
    public void setAutonomiaKm(double autonomiaKm) { this.autonomiaKm = autonomiaKm; }

    public int getPotenciaNominalW() { return potenciaNominalW; }
    public void setPotenciaNominalW(int potenciaNominalW) { this.potenciaNominalW = potenciaNominalW; }

    public double getVelocidadMaxKmh() { return velocidadMaxKmh; }
    public void setVelocidadMaxKmh(double velocidadMaxKmh) { this.velocidadMaxKmh = velocidadMaxKmh; }

    /**
     * Método que retorna una descripción completa del vehículo con sus características principales.
     * 
     * @return descripción formateada del vehículo
     */
    public String getDescripcion() {
        return String.format("Marca: %s, Modelo: %s, Autonomía: %.1f km, Potencia: %d W, Velocidad máxima: %.1f km/h",
                marca, modelo, autonomiaKm, potenciaNominalW, velocidadMaxKmh);
    }
}
