/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.avanzada.rolapet.modelo;

import java.util.List;

/**
 *
 * @author sarit
 */
public class Administrador extends Persona {
    public Administrador(String nombre, String apellido, String cedula, String correo, String celular){
        super(nombre, apellido, cedula, correo, celular);
               
    }
    public void registrarProveedor(Proveedor proveedor, List<Proveedor> listaProveedores){
        if (proveedor !=null && listaProveedores != null){
            listaProveedores.add(proveedor);
        }
    }
}
