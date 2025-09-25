/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.avanzada.rolapet.modelo;

/**
 *
 * @author sarit
 */
public abstract class ProveedorServicio extends Proveedor {
    public ProveedorServicio(String nombre, String apellido, String cedula, String correo, String celular){
        super(nombre, apellido, cedula, correo, celular);
    }
    public String getTipoProvvedor(){
        return "Servicio";
    }
}
