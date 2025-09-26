package udistrital.avanzada.rolapet.vista;

public class FormularioInicioSesionProveedor extends FormularioInicioSesion {

    private String tipoProveedor; // "ProveedorServicio" o "ProveedorInsumo"

    public FormularioInicioSesionProveedor(String tipoProveedor) {
        super(); // reutiliza todo el diseño de FormularioInicioSesion
        this.tipoProveedor = tipoProveedor;
        setTitle("Inicio de Sesión - " + tipoProveedor);
    }

    public String getTipoProveedor() {
        return tipoProveedor;
    }
}


