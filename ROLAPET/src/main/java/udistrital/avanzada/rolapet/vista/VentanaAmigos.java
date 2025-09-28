package udistrital.avanzada.rolapet.vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 *
 * @author juanr
 */
public class VentanaAmigos extends JFrame {
    private JButton btnAgregarAmigo;
    private JButton btnCerrar;
    private JList<String> listaAmigos;
    private DefaultListModel<String> modeloAmigos;

    /**
     *
     */
    public VentanaAmigos() {
        setTitle("Gestión de Amigos");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        modeloAmigos = new DefaultListModel<>();
        listaAmigos = new JList<>(modeloAmigos);
        add(new JScrollPane(listaAmigos), BorderLayout.CENTER);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        btnAgregarAmigo = new JButton("Agregar Amigo (por cédula)");
        btnCerrar = new JButton("Cerrar");
        panelBotones.add(btnAgregarAmigo);
        panelBotones.add(btnCerrar);
        add(panelBotones, BorderLayout.SOUTH);
    }

    /**
     *
     * @param listener
     */
    public void setAgregarAmigoListener(ActionListener listener) { btnAgregarAmigo.addActionListener(listener); }

    /**
     *
     * @param listener
     */
    public void setCerrarListener(ActionListener listener) { btnCerrar.addActionListener(listener); }

    /**
     *
     * @param amigos
     */
    public void mostrarAmigos(java.util.List<String> amigos) {
        modeloAmigos.clear();
        for (String a : amigos) modeloAmigos.addElement(a);
    }

    /**
     *
     * @return
     */
    public String pedirCedulaAmigo() { return JOptionPane.showInputDialog(this, "Ingrese cédula del amigo:"); }
}

