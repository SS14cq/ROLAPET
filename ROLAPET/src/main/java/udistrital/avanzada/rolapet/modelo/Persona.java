/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.avanzada.rolapet.modelo;

/**
 * Representa una persona con datos básicos de identificación y contacto.
 * Contiene los atributos nombre, apellido, cédula, correo y celular.
 * @author sarita
 * @version 1.0, 21-09-2025
 */
public class Persona {
    private String nombre;
    private String apellido;
    private String cedula;
    private String correo;
    private String celular;
/**
 * Constructor que inicializa una persona con todos sus atributos.
 * @param nombre Nombre de la persona.
 * @param apellido Apellido de la persona.
 * @param cedula Número de cédula.
 * @param correo Correo electrónico.
 * @param celular Número de celular.
 */    
    public Persona(String nombre, String apellido, String cedula, String correo, String celular) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.correo = correo;
        this.celular = celular;
    }
/**
 * Métodos getters y setters para acceder y modificar los atributos privados de la clase.
 * Cada getter devuelve el valor de un atributo y cada setter permite modificarlo.
 */

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    
       
}
