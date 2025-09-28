package udistrital.avanzada.rolapet.vista;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import udistrital.avanzada.rolapet.modelo.Usuario;
import udistrital.avanzada.rolapet.modelo.RepositorioUsuarios;

/**
 * Ventana Swing para la gestión de usuarios: listar, agregar, eliminar.
 * @author Sarita
 * @version 1.0, 27-09-2025
 */
public class VentanaGestionUsuarios extends JFrame {
    private RepositorioUsuarios repositorio;
    private DefaultListModel<String> modeloLista;
    private JList<String> listaUsuarios;

    public VentanaGestionUsuarios(RepositorioUsuarios repositorio) {
        this.repositorio = repositorio;
        setTitle("Gestión de Usuarios");
        setSize(420, 420);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel superior con logo y título
        JPanel panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.setBackground(new Color(30, 60, 150));
        JLabel lblLogo = new JLabel();
        lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
        try {
            ImageIcon icon = new ImageIcon(getClass().getResource("/imagenes/rolapet_logo.png"));
            lblLogo.setIcon(new ImageIcon(icon.getImage().getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH)));
        } catch (Exception e) {
            lblLogo.setText("ROLAPET");
            lblLogo.setFont(new Font("Arial", Font.BOLD, 28));
            lblLogo.setForeground(Color.WHITE);
        }
        JLabel lblTitulo = new JLabel("Gestión de Usuarios", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitulo.setForeground(Color.WHITE);
        panelSuperior.add(lblLogo, BorderLayout.NORTH);
        panelSuperior.add(lblTitulo, BorderLayout.CENTER);
        add(panelSuperior, BorderLayout.NORTH);

        // Panel central con lista
        modeloLista = new DefaultListModel<>();
        listaUsuarios = new JList<>(modeloLista);
        listaUsuarios.setFont(new Font("Arial", Font.PLAIN, 16));
        listaUsuarios.setBackground(new Color(230, 240, 255));
        actualizarLista();
        add(new JScrollPane(listaUsuarios), BorderLayout.CENTER);

        // Panel de botones inferior
        JPanel panelBotones = new JPanel();
        panelBotones.setBackground(new Color(30, 60, 150));
        JButton btnAgregar = new JButton("Agregar");
        JButton btnEliminar = new JButton("Eliminar");
        btnAgregar.setBackground(new Color(0, 120, 215));
        btnAgregar.setForeground(Color.WHITE);
        btnEliminar.setBackground(new Color(200, 0, 0));
        btnEliminar.setForeground(Color.WHITE);
        btnAgregar.setFont(new Font("Arial", Font.BOLD, 15));
        btnEliminar.setFont(new Font("Arial", Font.BOLD, 15));
        panelBotones.add(btnAgregar);
        panelBotones.add(btnEliminar);
        add(panelBotones, BorderLayout.SOUTH);

        btnAgregar.addActionListener(e -> agregarUsuario());
        btnEliminar.addActionListener(e -> eliminarUsuario());
    }

    private void actualizarLista() {
        modeloLista.clear();
        List<Usuario> usuarios = repositorio.listarUsuarios();
        for (Usuario u : usuarios) {
            modeloLista.addElement(u.getNombreUsuario() + " - " + u.getCorreo());
        }
    }

    private void agregarUsuario() {
        String nombreUsuario = JOptionPane.showInputDialog(this, "Correo del usuario:");
        if (nombreUsuario != null && !nombreUsuario.trim().isEmpty()) {
            // Aquí podrías abrir un formulario completo, por simplicidad solo correo
            Usuario nuevo = new Usuario(nombreUsuario, "1234", "Nombre", "Apellido", "1234567890", nombreUsuario, "3001234567") {
            };
            repositorio.agregarUsuario(nuevo);
            actualizarLista();
        }
    }

    private void eliminarUsuario() {
        int idx = listaUsuarios.getSelectedIndex();
        if (idx >= 0) {
            Usuario usuario = repositorio.listarUsuarios().get(idx);
            repositorio.eliminarUsuario(usuario);
            actualizarLista();
        }
    }
}
