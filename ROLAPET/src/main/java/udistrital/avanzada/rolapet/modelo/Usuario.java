/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.avanzada.rolapet.modelo;

/**
 * Representa un usuario que extiende de Persona,
 * agregando los atributos de nombre de usuario y contraseña.
 * 
 * Hereda nombre, apellido, cédula, correo y celular.
 * 
 * @author sarita
 * @version 1.0, 21-09-2025
 */
public class Usuario extends Persona {
    
    private String nombreUsuario;
    private String contrasena;
    
    /**
     * Construye un usuario con toda la información personal y de acceso.
     *
     * @param nombreUsuario Nombre de usuario para el acceso.
     * @param contrasena Contraseña para el acceso.
     * @param nombre Nombre real.
     * @param apellido Apellido real.
     * @param cedula Documento de identidad.
     * @param correo Correo electrónico.
     * @param celular Número de celular.
     */
    public Usuario(String nombreUsuario, String contrasena, String nombre, String apellido, String cedula, String correo, String celular) {
        super(nombre, apellido, cedula, correo, celular);
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }

    /**
     * Getters y setters para nombre de usuario y contraseña.
     * Los demás atributos se heredan de Persona.
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    
}
