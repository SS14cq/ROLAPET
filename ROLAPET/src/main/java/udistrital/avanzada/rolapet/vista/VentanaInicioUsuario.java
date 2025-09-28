package udistrital.avanzada.rolapet.vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import udistrital.avanzada.rolapet.modelo.Usuario;
import udistrital.avanzada.rolapet.modelo.RepositorioUsuarios;

/**
 * Ventana principal del usuario: muestra perfil, amigos, vehículos, publicaciones y búsqueda.
 * @author Sarita
 * @version 1.0, 27-09-2025
 */
public class VentanaInicioUsuario extends JFrame {
    private Usuario usuario;
    private RepositorioUsuarios repositorioUsuarios;
    private udistrital.avanzada.rolapet.modelo.RepositorioPublicaciones repoPublicaciones;
    private JFrame ventanaPrincipal;

    // Hacer públicos los botones para que el gestor pueda añadirles ActionListener
    public JButton btnCerrarSesion;
    public JButton btnAgregarAmigos;

    public VentanaInicioUsuario(Usuario usuario, RepositorioUsuarios repositorioUsuarios,
                               udistrital.avanzada.rolapet.modelo.RepositorioPublicaciones repoPublicaciones,
                               JFrame ventanaPrincipal) {
        this.usuario = usuario;
        this.repositorioUsuarios = repositorioUsuarios;
        this.repoPublicaciones = repoPublicaciones;
        this.ventanaPrincipal = ventanaPrincipal;

        setTitle("Inicio Usuario");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        Color fondo = Color.decode("#f5f5dc");
        Color encabezadoColor = Color.decode("#b81b2f");
        Font fuenteTitulo = new Font("Segoe UI", Font.BOLD, 24);
        Font fuenteBotones = new Font("Segoe UI", Font.BOLD, 15);

        // Crear los botones
        btnCerrarSesion = new JButton("Cerrar sesión");
        btnAgregarAmigos = new JButton("Agregar Amigos");

        // Panel superior: perfil y logo
        JPanel panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.setBackground(fondo);
        panelSuperior.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        ImageIcon logo = new ImageIcon(getClass().getResource("/imagenes/rolapet_logo.png"));
        Image img = logo.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        JLabel lblLogo = new JLabel(new ImageIcon(img));
        JLabel lblTitulo = new JLabel("Rolapet - Inicio Usuario", SwingConstants.LEFT);
        lblTitulo.setFont(fuenteTitulo);
        lblTitulo.setForeground(encabezadoColor);
        panelSuperior.add(lblLogo, BorderLayout.WEST);
        panelSuperior.add(lblTitulo, BorderLayout.CENTER);
        add(panelSuperior, BorderLayout.NORTH);

        // Panel izquierdo: opciones
        JPanel panelIzquierdo = new JPanel();
        panelIzquierdo.setLayout(new BoxLayout(panelIzquierdo, BoxLayout.Y_AXIS));
        panelIzquierdo.setBackground(fondo);

    JButton btnMostrarVehiculos = new JButton("Mostrar Vehículos");
    btnAgregarAmigos.setAlignmentX(Component.CENTER_ALIGNMENT);
    btnMostrarVehiculos.setAlignmentX(Component.CENTER_ALIGNMENT);
    btnCerrarSesion.setAlignmentX(Component.CENTER_ALIGNMENT);

    btnAgregarAmigos.setBackground(encabezadoColor);
    btnAgregarAmigos.setForeground(Color.WHITE);

    btnMostrarVehiculos.setBackground(encabezadoColor);
    btnMostrarVehiculos.setForeground(Color.WHITE);

    btnCerrarSesion.setBackground(Color.GRAY);
    btnCerrarSesion.setForeground(Color.WHITE);

    btnAgregarAmigos.setFont(fuenteBotones);
    btnMostrarVehiculos.setFont(fuenteBotones);
    btnCerrarSesion.setFont(fuenteBotones);

    panelIzquierdo.add(Box.createVerticalStrut(30));
    panelIzquierdo.add(btnAgregarAmigos);
    panelIzquierdo.add(Box.createVerticalStrut(20));
    panelIzquierdo.add(btnMostrarVehiculos);
    panelIzquierdo.add(Box.createVerticalStrut(20));
    panelIzquierdo.add(btnCerrarSesion);
    add(panelIzquierdo, BorderLayout.WEST);

        // Listeners se asignan desde el gestor, no aquí
        // El resto de la construcción de la ventana (panel publicaciones, busqueda, etc) igual que antes...
        // omito esa parte aquí por brevedad pero la incluyes como ya tienes
    }

    /**
     * Asigna un ActionListener al botón Cerrar sesión para que el gestor pueda controlar el evento
     */
    public void setCerrarSesionListener(ActionListener listener) {
        btnCerrarSesion.addActionListener(listener);
    }
}
