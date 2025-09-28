package udistrital.avanzada.rolapet.vista;

import java.awt.Color;

/**
 * Class FormularioInicioSesionProveedor.
 */
/**
 * Class FormularioInicioSesionProveedor.
 */
public class FormularioInicioSesionProveedor extends FormularioInicioSesion {

    private String tipoProveedor; // "ProveedorServicio" o "ProveedorInsumo"

    public FormularioInicioSesionProveedor(String tipoProveedor) {
        super(); // reutiliza todo el diseño de FormularioInicioSesion
        // Normalizar tipo para compatibilidad con inicio de sesión
        if (tipoProveedor.equalsIgnoreCase("ProveedorServicio")) {
            this.tipoProveedor = "Servicio";
        } else if (tipoProveedor.equalsIgnoreCase("ProveedorInsumo")) {
            this.tipoProveedor = "Insumo";
        } else {
            this.tipoProveedor = tipoProveedor;
        }
        setTitle("Inicio de Sesión - " + this.tipoProveedor);
        btnCancelar.setText("Atrás");
        btnCancelar.setBackground(Color.decode("#b81b2f"));
        btnCancelar.setForeground(Color.WHITE);
    }

/**
 * getTipoProveedor method.
 * @return result
 */
/**
 * getTipoProveedor method.
 * @return result
 */
/**
 * getTipoProveedor method.
 * @return result
 */
    public String getTipoProveedor() {
        return tipoProveedor;
    }
}


