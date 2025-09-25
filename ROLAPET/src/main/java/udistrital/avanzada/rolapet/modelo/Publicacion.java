/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.avanzada.rolapet.modelo;

import java.time.LocalDate;

/**
 *
 * @author juanr
 */
public class Publicacion {
    private String id;
    private String titulo;
    private String descripcion;
    private LocalDate fecha;
    public Publicacion(String id, String titulo, String descripcion, LocalDate fecha){
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }
}
