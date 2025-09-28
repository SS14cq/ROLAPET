package udistrital.avanzada.rolapet.vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import udistrital.avanzada.rolapet.modelo.Publicacion;
import udistrital.avanzada.rolapet.modelo.RepositorioPublicaciones;
import udistrital.avanzada.rolapet.modelo.Usuario;
import udistrital.avanzada.rolapet.modelo.RepositorioUsuarios;

/**
 * Ventana principal del usuario: muestra perfil, amigos, vehículos, publicaciones y búsqueda.
 * @author Sarita
 * @version 1.0, 27-09-2025
 */
/**
 * Class VentanaInicioUsuario.
 */
/**
 * Class VentanaInicioUsuario.
 */
public class VentanaInicioUsuario extends JFrame {
    private Usuario usuario;
    private RepositorioUsuarios repositorioUsuarios;
    private RepositorioPublicaciones repoPublicaciones;
    private JFrame ventanaPrincipal;

    // Botones públicos para que el gestor pueda añadirles ActionListener
    public JButton btnCerrarSesion;
    public JButton btnAgregarAmigos;
    public JButton btnVerProveedores;
    public JButton btnMostrarVehiculos;

    private JList<String> listaPublicaciones;
    private DefaultListModel<String> modeloLista;

    public VentanaInicioUsuario(Usuario usuario, RepositorioUsuarios repositorioUsuarios,
                                RepositorioPublicaciones repoPublicaciones, JFrame ventanaPrincipal) {
        // Asignar atributos
        this.usuario = usuario;
        this.repositorioUsuarios = repositorioUsuarios;
        this.repoPublicaciones = repoPublicaciones;
        this.ventanaPrincipal = ventanaPrincipal;

        // Configuración de la ventana
        setTitle("Inicio Usuario");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        Color fondo = Color.decode("#f5f5dc");
        Color encabezadoColor = Color.decode("#b81b2f");
        Font fuenteTitulo = new Font("Segoe UI", Font.BOLD, 24);
        Font fuenteBotones = new Font("Segoe UI", Font.BOLD, 15);

        // Modelo para publicaciones
        modeloLista = new DefaultListModel<>();
        listaPublicaciones = new JList<>(modeloLista);
        add(new JScrollPane(listaPublicaciones), BorderLayout.CENTER);

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

        // Crear los botones
        btnCerrarSesion = new JButton("Cerrar sesión");
        btnAgregarAmigos = new JButton("Agregar Amigos");
        btnMostrarVehiculos = new JButton("Mis Vehículos");
        btnVerProveedores = new JButton("Ver Proveedores");

        // Panel izquierdo: opciones
        JPanel panelIzquierdo = new JPanel();
        panelIzquierdo.setLayout(new BoxLayout(panelIzquierdo, BoxLayout.Y_AXIS));
        panelIzquierdo.setBackground(fondo);

        // Alinear botones
        btnAgregarAmigos.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnMostrarVehiculos.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnVerProveedores.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnCerrarSesion.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Colores
        btnAgregarAmigos.setBackground(encabezadoColor);
        btnAgregarAmigos.setForeground(Color.WHITE);

        btnMostrarVehiculos.setBackground(encabezadoColor);
        btnMostrarVehiculos.setForeground(Color.WHITE);

        btnVerProveedores.setBackground(encabezadoColor);
        btnVerProveedores.setForeground(Color.WHITE);

        btnCerrarSesion.setBackground(Color.GRAY);
        btnCerrarSesion.setForeground(Color.WHITE);

        // Fuentes
        btnAgregarAmigos.setFont(fuenteBotones);
        btnMostrarVehiculos.setFont(fuenteBotones);
        btnVerProveedores.setFont(fuenteBotones);
        btnCerrarSesion.setFont(fuenteBotones);

        // Añadir botones al panel
        panelIzquierdo.add(Box.createVerticalStrut(30));
        panelIzquierdo.add(btnAgregarAmigos);
        panelIzquierdo.add(Box.createVerticalStrut(20));
        panelIzquierdo.add(btnMostrarVehiculos);
        panelIzquierdo.add(Box.createVerticalStrut(30));
        panelIzquierdo.add(btnVerProveedores);
        panelIzquierdo.add(Box.createVerticalStrut(20));
        panelIzquierdo.add(btnCerrarSesion);
        add(panelIzquierdo, BorderLayout.WEST);

        // Cargar publicaciones iniciales
        cargarPublicaciones();
    }

/**
 * cargarPublicaciones method.
 * @return result
 */
/**
 * cargarPublicaciones method.
 */
/**
 * cargarPublicaciones method.
 */
    public void cargarPublicaciones() {
        modeloLista.clear();
        if (repoPublicaciones != null) {
            for (Publicacion pub : repoPublicaciones.listarPublicaciones()) {
                modeloLista.addElement(pub.getTitulo() + " - " + pub.getDescripcion());
            }
        }
    }

    /**
     * Asigna un ActionListener al botón Cerrar sesión para que el gestor pueda controlar el evento
     */
/**
 * setCerrarSesionListener method.
 * @param listener parameter
 * @return result
 */
/**
 * setCerrarSesionListener method.
 * @param listener parameter
 */
/**
 * setCerrarSesionListener method.
 * @param listener parameter
 */
    public void setCerrarSesionListener(ActionListener listener) {
        btnCerrarSesion.addActionListener(listener);
    }
}
