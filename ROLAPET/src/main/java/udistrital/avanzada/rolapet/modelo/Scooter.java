/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.avanzada.rolapet.modelo;

/**
 *
 * @author sarita
 * @version 1.1
 */
public class Scooter extends Vehiculo {
    private boolean llantasOffRoad;
    private boolean iluminacionAvanzada;

    public Scooter(String marca, String modelo, double autonomiaKm, int potenciaNominalW, double velocidadMaxKmh,
                   boolean llantasOffRoad, boolean iluminacionAvanzada) {
        super(marca, modelo, autonomiaKm, potenciaNominalW, velocidadMaxKmh);
        this.llantasOffRoad = llantasOffRoad;
        this.iluminacionAvanzada = iluminacionAvanzada;
    }

    public boolean isLlantasOffRoad() { return llantasOffRoad; }
    public void setLlantasOffRoad(boolean llantasOffRoad) { this.llantasOffRoad = llantasOffRoad; }

    public boolean isIluminacionAvanzada() { return iluminacionAvanzada; }
    public void setIluminacionAvanzada(boolean iluminacionAvanzada) { this.iluminacionAvanzada = iluminacionAvanzada; }

    @Override
    public String getDescripcion() {
        return super.getDescripcion() +
                ", Llantas off-road: " + (llantasOffRoad ? "Sí" : "No") +
                ", Iluminación avanzada: " + (iluminacionAvanzada ? "Sí" : "No");
    }
}
