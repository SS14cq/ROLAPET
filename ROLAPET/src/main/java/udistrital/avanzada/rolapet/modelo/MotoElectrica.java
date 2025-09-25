/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.avanzada.rolapet.modelo;

/**
 *
 * @author sarit
 */
public class MotoElectrica extends Vehiculo {
    private boolean frenosDisco;
    private boolean suspensionAltaCalidad;
    private boolean lucesLED;
    private boolean alarmaAntiRobo;

    public MotoElectrica(String marca, String modelo, double autonomiaKm, int potenciaNominalW, double velocidadMaxKmh,
                         boolean frenosDisco, boolean suspensionAltaCalidad, boolean lucesLED, boolean alarmaAntiRobo) {
        super(marca, modelo, autonomiaKm, potenciaNominalW, velocidadMaxKmh);
        this.frenosDisco = frenosDisco;
        this.suspensionAltaCalidad = suspensionAltaCalidad;
        this.lucesLED = lucesLED;
        this.alarmaAntiRobo = alarmaAntiRobo;
    }

    public boolean isFrenosDisco() { return frenosDisco; }
    public void setFrenosDisco(boolean frenosDisco) { this.frenosDisco = frenosDisco; }

    public boolean isSuspensionAltaCalidad() { return suspensionAltaCalidad; }
    public void setSuspensionAltaCalidad(boolean suspensionAltaCalidad) { this.suspensionAltaCalidad = suspensionAltaCalidad; }

    public boolean isLucesLED() { return lucesLED; }
    public void setLucesLED(boolean lucesLED) { this.lucesLED = lucesLED; }

    public boolean isAlarmaAntiRobo() { return alarmaAntiRobo; }
    public void setAlarmaAntiRobo(boolean alarmaAntiRobo) { this.alarmaAntiRobo = alarmaAntiRobo; }

    @Override
    public String getDescripcion() {
        return super.getDescripcion() +
                ", Frenos de disco: " + (frenosDisco ? "Sí" : "No") +
                ", Suspensión alta calidad: " + (suspensionAltaCalidad ? "Sí" : "No") +
                ", Luces LED: " + (lucesLED ? "Sí" : "No") +
                ", Alarma anti robo: " + (alarmaAntiRobo ? "Sí" : "No");
    }
}
