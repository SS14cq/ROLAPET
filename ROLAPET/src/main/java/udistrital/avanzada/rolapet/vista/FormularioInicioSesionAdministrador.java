/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udistrital.avanzada.rolapet.vista;

public class FormularioInicioSesionAdministrador extends FormularioInicioSesion {

    public FormularioInicioSesionAdministrador() {
        super(); // reutiliza toda la interfaz de FormularioInicioSesion
        setTitle("Inicio de Sesión - Administrador");
        btnCancelar.setBackground(java.awt.Color.GRAY);
        btnCancelar.setForeground(java.awt.Color.WHITE);
        btnCancelar.setOpaque(true);
        btnCancelar.addActionListener(e -> {
            this.dispose();
        });
    }
}
