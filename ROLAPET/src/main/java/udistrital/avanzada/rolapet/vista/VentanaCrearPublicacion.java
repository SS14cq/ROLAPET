package udistrital.avanzada.rolapet.vista;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import udistrital.avanzada.rolapet.modelo.Publicacion;
import udistrital.avanzada.rolapet.modelo.Usuario;
import udistrital.avanzada.rolapet.modelo.RepositorioPublicaciones;

/**
 * Ventana para que administradores y proveedores creen eventos o promociones.
 * @author Sarita
 * @version 1.0, 27-09-2025
 */
public class VentanaCrearPublicacion extends JFrame {
    private JTextField campoTitulo, campoId;
    private JTextArea campoDescripcion;
    private JComboBox<String> comboTipo;
    private JButton btnPublicar, btnCancelar;

    // Constructor para proveedores y administradores
    public VentanaCrearPublicacion(Usuario autor, RepositorioPublicaciones repoPublicaciones) {
        setTitle("Crear Publicación");
        setSize(400, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        Color fondo = Color.decode("#f5f5dc");
        Color encabezadoColor = Color.decode("#b81b2f");
        Font fuenteLabels = new Font("Segoe UI", Font.PLAIN, 14);
        Font fuenteBotones = new Font("Segoe UI", Font.BOLD, 14);
        Font fuenteTitulo = new Font("Segoe UI", Font.BOLD, 20);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(fondo);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8,8,8,8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblTitulo = new JLabel("Crear Evento/Promoción");
        lblTitulo.setFont(fuenteTitulo);
        lblTitulo.setForeground(encabezadoColor);
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        panel.add(lblTitulo, gbc);

        gbc.gridwidth = 1;
        gbc.gridy++;
        panel.add(new JLabel("ID:"), gbc);
        gbc.gridx = 1;
        campoId = new JTextField(15);
        panel.add(campoId, gbc);

        gbc.gridx = 0; gbc.gridy++;
        panel.add(new JLabel("Título:"), gbc);
        gbc.gridx = 1;
        campoTitulo = new JTextField(15);
        panel.add(campoTitulo, gbc);

        gbc.gridx = 0; gbc.gridy++;
        panel.add(new JLabel("Descripción:"), gbc);
        gbc.gridx = 1;
        campoDescripcion = new JTextArea(4, 15);
        campoDescripcion.setLineWrap(true);
        campoDescripcion.setWrapStyleWord(true);
        JScrollPane scrollDesc = new JScrollPane(campoDescripcion);
        panel.add(scrollDesc, gbc);

        gbc.gridx = 0; gbc.gridy++;
        panel.add(new JLabel("Tipo:"), gbc);
        gbc.gridx = 1;
        comboTipo = new JComboBox<>(new String[]{"Evento", "Promoción"});
        panel.add(comboTipo, gbc);

        gbc.gridx = 0; gbc.gridy++;
        btnPublicar = new JButton("Publicar");
        btnPublicar.setBackground(encabezadoColor);
        btnPublicar.setForeground(Color.WHITE);
        btnPublicar.setFont(fuenteBotones);
        panel.add(btnPublicar, gbc);
        gbc.gridx = 1;
        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBackground(Color.GRAY);
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setFont(fuenteBotones);
        panel.add(btnCancelar, gbc);

        add(panel, BorderLayout.CENTER);

        btnPublicar.addActionListener(e -> {
            String id = campoId.getText().trim();
            String titulo = campoTitulo.getText().trim();
            String descripcion = campoDescripcion.getText().trim();
            String tipo = (String) comboTipo.getSelectedItem();
            if (id.isEmpty() || titulo.isEmpty() || descripcion.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Publicacion pub = new Publicacion(id, titulo, descripcion, tipo, autor, java.time.LocalDate.now());
            repoPublicaciones.agregarPublicacion(pub);
            if (autor instanceof udistrital.avanzada.rolapet.modelo.Proveedor) {
                ((udistrital.avanzada.rolapet.modelo.Proveedor)autor).agregarPublicacion(pub);
            }
            JOptionPane.showMessageDialog(this, "¡Publicación creada exitosamente!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        });
        btnCancelar.addActionListener(e -> dispose());
    }

    // Constructor alternativo para administrador (sin usuario, solo repositorio)
    public VentanaCrearPublicacion(RepositorioPublicaciones repoPublicaciones) {
        this(null, repoPublicaciones) ;
    }

    // (eliminado: inicialización duplicada fuera de los constructores)
}
