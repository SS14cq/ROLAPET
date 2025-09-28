package udistrital.avanzada.rolapet.vista;

import javax.swing.*;
import java.awt.*;

/**
 * Class FormularioRegistroProveedorServicios.
 */
/**
 * Class FormularioRegistroProveedorServicios.
 */
public class FormularioRegistroProveedorServicios extends FormularioRegistroProveedor {
    private JFrame ventanaAnterior;

    public FormularioRegistroProveedorServicios(JFrame ventanaAnterior) {
        super();
        this.ventanaAnterior = ventanaAnterior;
        setTitle("Registro - Proveedor de Servicios");

        Color fondo = Color.decode("#f5f5dc");
        Color encabezadoColor = Color.decode("#b81b2f");

        setLayout(new BorderLayout());

        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(fondo);
        headerPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        ImageIcon logo = new ImageIcon(getClass().getResource("/imagenes/rolapet_logo.png"));
        Image img = logo.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        JLabel lblLogo = new JLabel(new ImageIcon(img));

        JLabel lblTitulo = new JLabel("Rolapet - Registro Proveedor Servicios", SwingConstants.LEFT);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblTitulo.setForeground(encabezadoColor);

        headerPanel.add(lblLogo, BorderLayout.WEST);
        headerPanel.add(lblTitulo, BorderLayout.CENTER);
        add(headerPanel, BorderLayout.NORTH);

        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));
        panelCentral.setBackground(fondo);

        // Agregar los campos del formulario
        panelCentral.add(new JLabel("Nombre"));
        panelCentral.add(txtNombre);
        panelCentral.add(new JLabel("Apellido"));
        panelCentral.add(txtApellido);
        panelCentral.add(new JLabel("Cédula"));
        panelCentral.add(txtCedula);
        panelCentral.add(new JLabel("Correo (será su usuario)"));
        panelCentral.add(txtCorreo);
        panelCentral.add(new JLabel("Celular"));
        panelCentral.add(txtCelular);
        panelCentral.add(new JLabel("Contraseña"));
        panelCentral.add(txtContrasena);

        // Botones
        JPanel panelBotones = new JPanel();
        panelBotones.setBackground(fondo);
        btnRegistrar.setBackground(encabezadoColor);
        btnRegistrar.setForeground(Color.WHITE);
        btnRegistrar.setOpaque(true);
        btnCancelar.setBackground(Color.GRAY);
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setOpaque(true);
        btnCancelar.addActionListener(e -> {
            this.dispose();
        });
        panelBotones.add(btnRegistrar);
        panelBotones.add(btnCancelar);

        panelCentral.add(Box.createVerticalStrut(10));
        panelCentral.add(panelBotones);

        add(panelCentral, BorderLayout.CENTER);
        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}