package udistrital.avanzada.rolapet.vista;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import udistrital.avanzada.rolapet.modelo.Vehiculo;
import udistrital.avanzada.rolapet.modelo.RepositorioVehiculos;

/**
 * Ventana Swing para la gestión de vehículos: listar, agregar, eliminar.
 * @author Sarita
 * @version 1.0, 27-09-2025
 */
/**
 * Class VentanaGestionVehiculos.
 */
/**
 * Class VentanaGestionVehiculos.
 */
public class VentanaGestionVehiculos extends JFrame {
    private RepositorioVehiculos repositorio;
    private DefaultListModel<String> modeloLista;
    private JList<String> listaVehiculos;

    public VentanaGestionVehiculos(RepositorioVehiculos repositorio) {
        this.repositorio = repositorio;
        setTitle("Gestión de Vehículos");
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
        JLabel lblTitulo = new JLabel("Gestión de Vehículos", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitulo.setForeground(Color.WHITE);
        panelSuperior.add(lblLogo, BorderLayout.NORTH);
        panelSuperior.add(lblTitulo, BorderLayout.CENTER);
        add(panelSuperior, BorderLayout.NORTH);

        // Panel central con lista
        modeloLista = new DefaultListModel<>();
        listaVehiculos = new JList<>(modeloLista);
        listaVehiculos.setFont(new Font("Arial", Font.PLAIN, 16));
        listaVehiculos.setBackground(new Color(230, 240, 255));
        actualizarLista();
        add(new JScrollPane(listaVehiculos), BorderLayout.CENTER);

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

        btnAgregar.addActionListener(e -> agregarVehiculo());
        btnEliminar.addActionListener(e -> eliminarVehiculo());
    }

/**
 * actualizarLista method.
 * @return result
 */
/**
 * actualizarLista method.
 */
/**
 * actualizarLista method.
 */
    private void actualizarLista() {
        modeloLista.clear();
        List<Vehiculo> vehiculos = repositorio.listarVehiculos();
        for (Vehiculo v : vehiculos) {
            modeloLista.addElement(v.getPlaca() + " - " + v.getMarca() + " " + v.getModelo());
        }
    }

/**
 * agregarVehiculo method.
 * @return result
 */
/**
 * agregarVehiculo method.
 */
/**
 * agregarVehiculo method.
 */
    private void agregarVehiculo() {
        String placa = JOptionPane.showInputDialog(this, "Placa del vehículo:");
        if (placa != null && !placa.trim().isEmpty()) {
            // Aquí podrías abrir un formulario completo, por simplicidad solo placa
            Vehiculo nuevo = new Vehiculo("Marca", "Modelo", placa, 50.0, 500, 45.0);
            repositorio.agregarVehiculo(nuevo);
            actualizarLista();
        }
    }

/**
 * eliminarVehiculo method.
 * @return result
 */
/**
 * eliminarVehiculo method.
 */
/**
 * eliminarVehiculo method.
 */
    private void eliminarVehiculo() {
        int idx = listaVehiculos.getSelectedIndex();
        if (idx >= 0) {
            Vehiculo vehiculo = repositorio.listarVehiculos().get(idx);
            repositorio.eliminarVehiculo(vehiculo);
            actualizarLista();
        }
    }
}
