package udistrital.avanzada.rolapet.vista;

import udistrital.avanzada.rolapet.modelo.Proveedor;
import udistrital.avanzada.rolapet.modelo.RepositorioUsuarios;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class VentanaGaleriaProveedores.
 */
/**
 * Class VentanaGaleriaProveedores.
 */
public class VentanaGaleriaProveedores extends JFrame {
    // Método para cargar proveedores desde una lista de Proveedor
/**
 * cargarProveedoresDirecto method.
 * @param proveedores parameter
 * @param tipo parameter
 * @param busqueda parameter
 * @return result
 */
/**
 * cargarProveedoresDirecto method.
 * @param proveedores parameter
 * @param tipo parameter
 * @param busqueda parameter
 */
/**
 * cargarProveedoresDirecto method.
 * @param proveedores parameter
 * @param tipo parameter
 * @param busqueda parameter
 */
    private void cargarProveedoresDirecto(List<Proveedor> proveedores, String tipo, String busqueda) {
        modeloTabla.setRowCount(0);
        List<Proveedor> filtrados = proveedores.stream()
                .filter(p -> tipo.equals("Todos") || p.getTipoProveedor().equalsIgnoreCase(tipo))
                .filter(p -> busqueda.isEmpty() || p.getNombre().toLowerCase().contains(busqueda) || p.getNombreUsuario().toLowerCase().contains(busqueda))
                .collect(java.util.stream.Collectors.toList());
        for (Proveedor p : filtrados) {
            String productos = p.getItems().isEmpty() ? "-" : p.getItems().stream().map(Object::toString).collect(java.util.stream.Collectors.joining(", "));
            modeloTabla.addRow(new Object[]{p.getNombreUsuario(), p.getNombre(), p.getTipoProveedor(), productos});
        }
    }
    // Constructor alternativo que recibe directamente la lista de proveedores
    public VentanaGaleriaProveedores(List<Proveedor> proveedores) {
        setTitle("Galería de Proveedores");
        setSize(700, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        Color fondo = Color.decode("#f5f5dc");
        Color encabezadoColor = Color.decode("#b81b2f");
        Font fuenteTitulo = new Font("Segoe UI", Font.BOLD, 22);

        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(fondo);
        headerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        ImageIcon logo = new ImageIcon(getClass().getResource("/imagenes/rolapet_logo.png"));
        Image img = logo.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        JLabel lblLogo = new JLabel(new ImageIcon(img));
        JLabel lblTitulo = new JLabel("Galería de Proveedores", SwingConstants.LEFT);
        lblTitulo.setFont(fuenteTitulo);
        lblTitulo.setForeground(encabezadoColor);
        headerPanel.add(lblLogo, BorderLayout.WEST);
        headerPanel.add(lblTitulo, BorderLayout.CENTER);
        add(headerPanel, BorderLayout.NORTH);

        // Filtros
        JPanel panelFiltros = new JPanel();
        panelFiltros.setBackground(fondo);
        comboTipo = new JComboBox<>(new String[]{"Todos", "Servicio", "Insumo"});
        campoBusqueda = new JTextField(18);
        btnFiltrar = new JButton("Filtrar");
        panelFiltros.add(new JLabel("Tipo:"));
        panelFiltros.add(comboTipo);
        panelFiltros.add(new JLabel("Buscar:"));
        panelFiltros.add(campoBusqueda);
        panelFiltros.add(btnFiltrar);
        add(panelFiltros, BorderLayout.SOUTH);

        // Tabla
        String[] columnas = {"Usuario", "Nombre", "Tipo", "Productos/Servicios"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        tablaProveedores = new JTable(modeloTabla);
        JScrollPane scrollTabla = new JScrollPane(tablaProveedores);
        add(scrollTabla, BorderLayout.CENTER);

        btnAtras = new JButton("Atrás");
        btnAtras.setBackground(Color.GRAY);
        btnAtras.setForeground(Color.WHITE);
        add(btnAtras, BorderLayout.WEST);

        // Cargar todos los proveedores al inicio
        cargarProveedoresDirecto(proveedores, "Todos", "");

        btnFiltrar.addActionListener(e -> {
            String tipo = (String) comboTipo.getSelectedItem();
            String busqueda = campoBusqueda.getText().trim().toLowerCase();
            cargarProveedoresDirecto(proveedores, tipo, busqueda);
        });
    }
    private JTable tablaProveedores;
    private JComboBox<String> comboTipo;
    private JTextField campoBusqueda;
    private JButton btnFiltrar, btnAtras;
    private DefaultTableModel modeloTabla;

    public VentanaGaleriaProveedores(RepositorioUsuarios repoUsuarios) {
        setTitle("Galería de Proveedores");
        setSize(700, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        Color fondo = Color.decode("#f5f5dc");
        Color encabezadoColor = Color.decode("#b81b2f");
        Font fuenteTitulo = new Font("Segoe UI", Font.BOLD, 22);

        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(fondo);
        headerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        ImageIcon logo = new ImageIcon(getClass().getResource("/imagenes/rolapet_logo.png"));
        Image img = logo.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        JLabel lblLogo = new JLabel(new ImageIcon(img));
        JLabel lblTitulo = new JLabel("Galería de Proveedores", SwingConstants.LEFT);
        lblTitulo.setFont(fuenteTitulo);
        lblTitulo.setForeground(encabezadoColor);
        headerPanel.add(lblLogo, BorderLayout.WEST);
        headerPanel.add(lblTitulo, BorderLayout.CENTER);
        add(headerPanel, BorderLayout.NORTH);

        // Filtros
        JPanel panelFiltros = new JPanel();
        panelFiltros.setBackground(fondo);
        comboTipo = new JComboBox<>(new String[]{"Todos", "Servicio", "Insumo"});
        campoBusqueda = new JTextField(18);
        btnFiltrar = new JButton("Filtrar");
        panelFiltros.add(new JLabel("Tipo:"));
        panelFiltros.add(comboTipo);
        panelFiltros.add(new JLabel("Buscar:"));
        panelFiltros.add(campoBusqueda);
        panelFiltros.add(btnFiltrar);
        add(panelFiltros, BorderLayout.SOUTH);

        // Tabla
        String[] columnas = {"Usuario", "Nombre", "Tipo", "Productos/Servicios"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        tablaProveedores = new JTable(modeloTabla);
        JScrollPane scrollTabla = new JScrollPane(tablaProveedores);
        add(scrollTabla, BorderLayout.CENTER);

        btnAtras = new JButton("Atrás");
        btnAtras.setBackground(Color.GRAY);
        btnAtras.setForeground(Color.WHITE);
        add(btnAtras, BorderLayout.WEST);

        // Cargar todos los proveedores al inicio
        cargarProveedores(repoUsuarios.listarUsuarios(), "Todos", "");

        btnFiltrar.addActionListener(e -> {
            String tipo = (String) comboTipo.getSelectedItem();
            String busqueda = campoBusqueda.getText().trim().toLowerCase();
            cargarProveedores(repoUsuarios.listarUsuarios(), tipo, busqueda);
        });
    }

/**
 * cargarProveedores method.
 * @param usuarios parameter
 * @param tipo parameter
 * @param busqueda parameter
 * @return result
 */
/**
 * cargarProveedores method.
 * @param usuarios parameter
 * @param tipo parameter
 * @param busqueda parameter
 */
/**
 * cargarProveedores method.
 * @param usuarios parameter
 * @param tipo parameter
 * @param busqueda parameter
 */
    private void cargarProveedores(List<udistrital.avanzada.rolapet.modelo.Usuario> usuarios, String tipo, String busqueda) {
        modeloTabla.setRowCount(0);
        List<Proveedor> proveedores = usuarios.stream()
                .filter(u -> u instanceof Proveedor)
                .map(u -> (Proveedor) u)
                .filter(p -> tipo.equals("Todos") || p.getTipoProveedor().equalsIgnoreCase(tipo))
                .filter(p -> busqueda.isEmpty() || p.getNombre().toLowerCase().contains(busqueda) || p.getNombreUsuario().toLowerCase().contains(busqueda))
                .collect(Collectors.toList());
        for (Proveedor p : proveedores) {
            String productos = p.getItems().isEmpty() ? "-" : p.getItems().stream().map(Object::toString).collect(Collectors.joining(", "));
            modeloTabla.addRow(new Object[]{p.getNombreUsuario(), p.getNombre(), p.getTipoProveedor(), productos});
        }
    }

/**
 * setAtrasListener method.
 * @param listener parameter
 * @return result
 */
/**
 * setAtrasListener method.
 * @param listener parameter
 */
/**
 * setAtrasListener method.
 * @param listener parameter
 */
    public void setAtrasListener(java.awt.event.ActionListener listener) {
        btnAtras.addActionListener(listener);
    }
}
