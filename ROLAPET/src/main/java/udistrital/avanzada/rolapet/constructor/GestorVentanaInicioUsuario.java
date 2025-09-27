package udistrital.avanzada.rolapet.constructor;

import udistrital.avanzada.rolapet.vista.VentanaInicioUsuario;
import udistrital.avanzada.rolapet.modelo.Usuario;
import udistrital.avanzada.rolapet.modelo.RepositorioUsuarios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestorVentanaInicioUsuario implements ActionListener {
    // Método para volver a la ventana de inicio
    private void volverAVentanaInicio() {
        ventana.dispose();
        if (ventanaPrincipal != null) {
            ventanaPrincipal.setEnabled(true);
            ventanaPrincipal.setVisible(true);
            ventanaPrincipal.toFront();
            ventanaPrincipal.requestFocus();
            enableComponents(ventanaPrincipal.getContentPane(), true);
        }
    }


    private VentanaInicioUsuario ventana;
    private Usuario usuario;
    private RepositorioUsuarios repositorioUsuarios;
    private udistrital.avanzada.rolapet.modelo.RepositorioPublicaciones repoPublicaciones;
    private JFrame ventanaPrincipal;

    public GestorVentanaInicioUsuario(VentanaInicioUsuario ventana, Usuario usuario, RepositorioUsuarios repositorioUsuarios,
                                      udistrital.avanzada.rolapet.modelo.RepositorioPublicaciones repoPublicaciones,
                                      JFrame ventanaPrincipal) {
        this.ventana = ventana;
        this.usuario = usuario;
        this.repositorioUsuarios = repositorioUsuarios;
        this.repoPublicaciones = repoPublicaciones;
        this.ventanaPrincipal = ventanaPrincipal;

    // Asociar la acción al botón cerrar sesión y agregar amigos
    this.ventana.setCerrarSesionListener(this);
    this.ventana.btnAgregarAmigos.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == ventana.btnCerrarSesion) {
            volverAVentanaInicio();
        } else if (source == ventana.btnAgregarAmigos) {
            String cedulaAmigo = JOptionPane.showInputDialog(ventana, "Ingrese la cédula del amigo a agregar:");
            if (cedulaAmigo != null && !cedulaAmigo.trim().isEmpty()) {
                Usuario amigo = null;
                for (Usuario u : repositorioUsuarios.listarUsuarios()) {
                    if (u.getCedula().equals(cedulaAmigo.trim())) {
                        amigo = u;
                        break;
                    }
                }
                if (amigo == null) {
                    JOptionPane.showMessageDialog(ventana, "No existe un usuario con esa identificación.", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (usuario.getAmigos().contains(amigo)) {
                    JOptionPane.showMessageDialog(ventana, "Ese usuario ya es tu amigo.", "Info", JOptionPane.INFORMATION_MESSAGE);
                } else if (amigo.equals(usuario)) {
                    JOptionPane.showMessageDialog(ventana, "No puedes agregarte a ti mismo como amigo.", "Info", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    usuario.agregarAmigo(amigo);
                    JOptionPane.showMessageDialog(ventana, "¡Amigo agregado exitosamente!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }

    // Método recursivo para habilitar o deshabilitar todos los componentes de un contenedor
    private void enableComponents(Container container, boolean enable) {
        for (Component c : container.getComponents()) {
            c.setEnabled(enable);
            if (c instanceof Container) {
                enableComponents((Container) c, enable);
            }
        }
    }
}
