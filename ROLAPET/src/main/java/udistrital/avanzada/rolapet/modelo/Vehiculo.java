/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.avanzada.rolapet.modelo;
/**
 * Clase que representa un vehículo genérico.
 * Contiene los atributos básicos comunes a todos los vehículos eléctricos de baja potencia.
 * 
 * @author sarita
 * @version 1.1
 * @since 2025-09-25 
 */
public class Vehiculo {
    private String marca;
    private String modelo;
    private double autonomiaKm;          // autonomía en kilómetros
    private int potenciaNominalW;        // potencia nominal en vatios
    private double velocidadMaxKmh;      // velocidad máxima en km/h

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

    // Método representativo
    public String getDescripcion() {
        return String.format("Marca: %s, Modelo: %s, Autonomía: %.1f km, Potencia: %d W, Velocidad máxima: %.1f km/h",
                marca, modelo, autonomiaKm, potenciaNominalW, velocidadMaxKmh);
    }
}

