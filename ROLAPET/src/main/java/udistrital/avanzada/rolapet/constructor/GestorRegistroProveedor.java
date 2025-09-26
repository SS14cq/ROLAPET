/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package udistrital.avanzada.rolapet.constructor;

import udistrital.avanzada.rolapet.modelo.Proveedor;
import udistrital.avanzada.rolapet.modelo.ProveedorInsumo;
import udistrital.avanzada.rolapet.modelo.ProveedorServicio;

import java.util.ArrayList;
import java.util.List;

/**
 * Gestor encargado de manejar el registro e inicio de sesión de proveedores.
 */
public class GestorRegistroProveedor {

    private List<Proveedor> proveedores;

    public GestorRegistroProveedor() {
        this.proveedores = new ArrayList<>();
    }

    // --- Registro de proveedores ---
    public void registrarProveedorServicio(String nombre, String apellido, String cedula, String correo, String celular) {
        ProveedorServicio proveedor = new ProveedorServicio(nombre, apellido, cedula, correo, celular) {};
        proveedores.add(proveedor);
    }

    public void registrarProveedorInsumo(String nombre, String apellido, String cedula, String correo, String celular) {
        ProveedorInsumo proveedor = new ProveedorInsumo(nombre, apellido, cedula, correo, celular);
        proveedores.add(proveedor);
    }

    // --- Inicio de sesión ---
    public Proveedor iniciarSesion(String correo, String contrasena, String tipo) {
        for (Proveedor p : proveedores) {
            if (p.getCorreo().equals(correo) && p.getCedula().equals(contrasena)) { 
                // aquí uso cedula como contraseña simulada
                if (tipo.equalsIgnoreCase("ProveedorServicio") && p instanceof ProveedorServicio) {
                    return p;
                } else if (tipo.equalsIgnoreCase("ProveedorInsumo") && p instanceof ProveedorInsumo) {
                    return p;
                }
            }
        }
        return null; // no encontrado
    }

    public List<Proveedor> getProveedores() {
        return proveedores;
    }
}


