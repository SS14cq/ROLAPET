package udistrital.avanzada.rolapet.vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class FormularioInicioSesion extends JFrame {
    private JTextField txtUsuario;
    private JPasswordField txtContrasena;
    private JButton btnIngresar;
    private JButton btnCancelar;

    public FormularioInicioSesion() {
        super("Iniciar Sesión");
        Color fondo = Color.decode("#f5f5dc");
        Color encabezadoColor = Color.decode("#b81b2f");

        Font fuenteTitulo = new Font("Segoe UI", Font.BOLD, 24);
        Font fuenteCampos = new Font("Segoe UI", Font.PLAIN, 14);

        setLayout(new BorderLayout());

        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(fondo);
        headerPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel lblTitulo = new JLabel("Inicio de Sesión", SwingConstants.CENTER);
        lblTitulo.setFont(fuenteTitulo);
        lblTitulo.setForeground(encabezadoColor);

        headerPanel.add(lblTitulo, BorderLayout.CENTER);
        add(headerPanel, BorderLayout.NORTH);

        JPanel panelFormulario = new JPanel(new GridBagLayout());
        panelFormulario.setBackground(fondo);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        txtUsuario = new JTextField(20);
        txtContrasena = new JPasswordField(20);

        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setFont(fuenteCampos);
        JLabel lblContrasena = new JLabel("Contraseña:");
        lblContrasena.setFont(fuenteCampos);

        gbc.gridx = 0; gbc.gridy = 0;
        panelFormulario.add(lblUsuario, gbc);
        gbc.gridx = 1;
        panelFormulario.add(txtUsuario, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        panelFormulario.add(lblContrasena, gbc);
        gbc.gridx = 1;
        panelFormulario.add(txtContrasena, gbc);

        btnIngresar = new JButton("Ingresar");
        btnCancelar = new JButton("Cancelar");

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnIngresar);
        panelBotones.add(btnCancelar);

        add(panelFormulario, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    public String getUsuario() { return txtUsuario.getText().trim(); }
    public String getContrasena() { return new String(txtContrasena.getPassword()); }
    public JButton getBtnIngresar() { return btnIngresar; }
    public JButton getBtnCancelar() { return btnCancelar; }

    public void setControlador(ActionListener controlador) {
        btnIngresar.addActionListener(controlador);
        btnCancelar.addActionListener(controlador);
    }
}
