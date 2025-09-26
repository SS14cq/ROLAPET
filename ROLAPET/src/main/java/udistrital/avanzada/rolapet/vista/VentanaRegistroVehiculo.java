package udistrital.avanzada.rolapet.vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;

/**
 * Clase VentanaRegistroVehiculo que representa la ventana para registrar vehículos.
 * Permite seleccionar el tipo de vehículo (Scooter o Motoeléctrica), ingresar atributos generales
 * y específicos según el tipo seleccionado, y cuenta con botones para registrar o cancelar.
 * Los campos específicos se muestran u ocultan dinámicamente según el tipo seleccionado.
 * 
 * @author Sarita
 * @version 1.3
 */
public class VentanaRegistroVehiculo extends JFrame {
    private JComboBox<String> comboTipoVehiculo;
    private JTextField campoMarca, campoModelo, campoAutonomia, campoPotencia, campoVelocidad;
    private JCheckBox chkLlantasOffRoad, chkIluminacionAvanzada;
    private JCheckBox chkFrenosDisco, chkSuspensionAlta, chkLucesLED, chkAlarmaAntiRobo;

    private JButton btnRegistrar, btnCancelar;

    /**
     * Constructor que inicializa la ventana y sus componentes con diseño personalizado
     * y comportamiento dinámico para mostrar u ocultar campos específicos según el tipo de vehículo.
     */
    public VentanaRegistroVehiculo() {
        super("Registro de Vehículo");

        Color fondo = Color.decode("#f5f5dc");
        Color encabezadoColor = Color.decode("#b81b2f");
        Font fuenteLabels = new Font("Segoe UI", Font.PLAIN, 14);
        Font fuenteBotones = new Font("Segoe UI", Font.BOLD, 14);
        Font fuenteTitulo = new Font("Segoe UI", Font.BOLD, 24);

        setSize(500, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel header con logo
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(fondo);
        headerPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        ImageIcon logo = new ImageIcon(getClass().getResource("/imagenes/rolapet_logo.png"));
        Image img = logo.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        JLabel lblLogo = new JLabel(new ImageIcon(img));
        headerPanel.add(lblLogo, BorderLayout.WEST);

        JLabel lblTitulo = new JLabel("Rolapet - Registro de Vehículo");
        lblTitulo.setFont(fuenteTitulo);
        lblTitulo.setForeground(encabezadoColor);
        headerPanel.add(lblTitulo, BorderLayout.CENTER);

        add(headerPanel, BorderLayout.NORTH);

        // Panel con formulario
        JPanel panelFormulario = new JPanel(new GridBagLayout());
        panelFormulario.setBackground(fondo);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5,5,5,5);

        // Combo tipo vehículo
        gbc.gridx = 0; gbc.gridy = 0;
        JLabel lblTipo = new JLabel("Tipo de vehículo:");
        lblTipo.setFont(fuenteLabels);
        panelFormulario.add(lblTipo, gbc);

        comboTipoVehiculo = new JComboBox<>(new String[]{"Scooter", "Motoeléctrica"});
        gbc.gridx = 1;
        panelFormulario.add(comboTipoVehiculo, gbc);

        // Marca
        gbc.gridy++;
        gbc.gridx = 0;
        JLabel lblMarca = new JLabel("Marca:");
        lblMarca.setFont(fuenteLabels);
        panelFormulario.add(lblMarca, gbc);
        gbc.gridx = 1;
        campoMarca = new JTextField(20);
        panelFormulario.add(campoMarca, gbc);

        // Modelo
        gbc.gridy++;
        gbc.gridx = 0;
        JLabel lblModelo = new JLabel("Modelo:");
        lblModelo.setFont(fuenteLabels);
        panelFormulario.add(lblModelo, gbc);
        gbc.gridx = 1;
        campoModelo = new JTextField(20);
        panelFormulario.add(campoModelo, gbc);

        // Autonomía
        gbc.gridy++;
        gbc.gridx = 0;
        JLabel lblAutonomia = new JLabel("Autonomía (km):");
        lblAutonomia.setFont(fuenteLabels);
        panelFormulario.add(lblAutonomia, gbc);
        gbc.gridx = 1;
        campoAutonomia = new JTextField(20);
        panelFormulario.add(campoAutonomia, gbc);

        // Potencia nominal
        gbc.gridy++;
        gbc.gridx = 0;
        JLabel lblPotencia = new JLabel("Potencia nominal (W):");
        lblPotencia.setFont(fuenteLabels);
        panelFormulario.add(lblPotencia, gbc);
        gbc.gridx = 1;
        campoPotencia = new JTextField(20);
        panelFormulario.add(campoPotencia, gbc);

        // Velocidad máxima
        gbc.gridy++;
        gbc.gridx = 0;
        JLabel lblVelocidad = new JLabel("Velocidad máxima (km/h):");
        lblVelocidad.setFont(fuenteLabels);
        panelFormulario.add(lblVelocidad, gbc);
        gbc.gridx = 1;
        campoVelocidad = new JTextField(20);
        panelFormulario.add(campoVelocidad, gbc);

        // Campos específicos scooter
        gbc.gridy++;
        gbc.gridx = 0;
        chkLlantasOffRoad = new JCheckBox("Llantas off-road");
        chkLlantasOffRoad.setFont(fuenteLabels);
        chkLlantasOffRoad.setBackground(fondo);
        panelFormulario.add(chkLlantasOffRoad, gbc);

        gbc.gridx = 1;
        chkIluminacionAvanzada = new JCheckBox("Iluminación avanzada");
        chkIluminacionAvanzada.setFont(fuenteLabels);
        chkIluminacionAvanzada.setBackground(fondo);
        panelFormulario.add(chkIluminacionAvanzada, gbc);

        // Campos específicos moto eléctrica
        gbc.gridy++;
        gbc.gridx = 0;
        chkFrenosDisco = new JCheckBox("Frenos de disco");
        chkFrenosDisco.setFont(fuenteLabels);
        chkFrenosDisco.setBackground(fondo);
        panelFormulario.add(chkFrenosDisco, gbc);

        gbc.gridx = 1;
        chkSuspensionAlta = new JCheckBox("Suspensión alta calidad");
        chkSuspensionAlta.setFont(fuenteLabels);
        chkSuspensionAlta.setBackground(fondo);
        panelFormulario.add(chkSuspensionAlta, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        chkLucesLED = new JCheckBox("Luces LED");
        chkLucesLED.setFont(fuenteLabels);
        chkLucesLED.setBackground(fondo);
        panelFormulario.add(chkLucesLED, gbc);

        gbc.gridx = 1;
        chkAlarmaAntiRobo = new JCheckBox("Alarma anti robo");
        chkAlarmaAntiRobo.setFont(fuenteLabels);
        chkAlarmaAntiRobo.setBackground(fondo);
        panelFormulario.add(chkAlarmaAntiRobo, gbc);

        // Botones
        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBackground(encabezadoColor);
        btnRegistrar.setForeground(Color.WHITE);
        btnRegistrar.setFocusPainted(false);
        btnRegistrar.setFont(fuenteBotones);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBackground(Color.GRAY);
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setFocusPainted(false);
        btnCancelar.setFont(fuenteBotones);

        JPanel panelBotones = new JPanel();
        panelBotones.setBackground(fondo);
        panelBotones.add(btnRegistrar);
        panelBotones.add(btnCancelar);

        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        panelFormulario.add(panelBotones, gbc);

        add(panelFormulario, BorderLayout.CENTER);

        // Mostrar solo campos scooter inicialmente
        mostrarCamposEspecificos("Scooter");

        comboTipoVehiculo.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                mostrarCamposEspecificos((String) e.getItem());
            }
        });
    }

    /**
     * Muestra u oculta los campos específicos según el tipo de vehículo seleccionado.
     * 
     * @param tipo Tipo de vehículo seleccionado ("Scooter" o "Motoeléctrica").
     */
    private void mostrarCamposEspecificos(String tipo) {
        boolean esScooter = "Scooter".equals(tipo);

        chkLlantasOffRoad.setVisible(esScooter);
        chkIluminacionAvanzada.setVisible(esScooter);

        chkFrenosDisco.setVisible(!esScooter);
        chkSuspensionAlta.setVisible(!esScooter);
        chkLucesLED.setVisible(!esScooter);
        chkAlarmaAntiRobo.setVisible(!esScooter);
    }

    // Getters públicos para obtener datos
    public String getTipoVehiculo() { return (String) comboTipoVehiculo.getSelectedItem(); }
    public String getMarca() { return campoMarca.getText().trim(); }
    public String getModelo() { return campoModelo.getText().trim(); }

    public double getAutonomia() {
        try { return Double.parseDouble(campoAutonomia.getText().trim()); }
        catch (NumberFormatException e) { return 0; }
    }
    public int getPotencia() {
        try { return Integer.parseInt(campoPotencia.getText().trim()); }
        catch (NumberFormatException e) { return 0; }
    }
    public double getVelocidad() {
        try { return Double.parseDouble(campoVelocidad.getText().trim()); }
        catch (NumberFormatException e) { return 0; }
    }

    public boolean isLlantasOffRoad() { return chkLlantasOffRoad.isSelected(); }
    public boolean isIluminacionAvanzada() { return chkIluminacionAvanzada.isSelected(); }
    public boolean isFrenosDisco() { return chkFrenosDisco.isSelected(); }
    public boolean isSuspensionAlta() { return chkSuspensionAlta.isSelected(); }
    public boolean isLucesLED() { return chkLucesLED.isSelected(); }
    public boolean isAlarmaAntiRobo() { return chkAlarmaAntiRobo.isSelected(); }

    public JButton getBtnRegistrar() { return btnRegistrar; }
    public JButton getBtnCancelar() { return btnCancelar; }

    /**
     * Limpia todos los campos y desmarca todos los checkboxes dejando el formulario vacío.
     */
    public void limpiarCampos() {
        campoMarca.setText("");
        campoModelo.setText("");
        campoAutonomia.setText("");
        campoPotencia.setText("");
        campoVelocidad.setText("");
        chkLlantasOffRoad.setSelected(false);
        chkIluminacionAvanzada.setSelected(false);
        chkFrenosDisco.setSelected(false);
        chkSuspensionAlta.setSelected(false);
        chkLucesLED.setSelected(false);
        chkAlarmaAntiRobo.setSelected(false);
    }
}
