package udistrital.avanzada.rolapet.modelo;

import java.util.Objects;

/**
 * Clase Proveedor que representa a un proveedor dentro del sistema.
 * Puede ser de tipo servicio o insumo, y contiene la información básica
 * de identificación y contacto.
 * 
 * @author Sarita
 * @version 1.0, 25-09-2025
 */
public class Proveedor {

    private String nombre;
    private String apellido;
    private String cedula;
    private String correo;
    private String celular;
    private TipoProveedor tipo;

    /**
     * Enumeración que define los tipos de proveedor.
     */
    public enum TipoProveedor {
        SERVICIO,
        INSUMO
    }

    /**
     * Constructor para crear un proveedor con todos los datos.
     * 
     * @param nombre nombre del proveedor
     * @param apellido apellido del proveedor
     * @param cedula cédula única del proveedor
     * @param correo correo electrónico del proveedor
     * @param celular número de celular del proveedor
     * @param tipo tipo de proveedor (servicio o insumo)
     */
    public Proveedor(String nombre, String apellido, String cedula,
                     String correo, String celular, TipoProveedor tipo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.correo = correo;
        this.celular = celular;
        this.tipo = tipo;
    }

    // --- Getters y Setters ---
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public TipoProveedor getTipo() {
        return tipo;
    }

    public void setTipo(TipoProveedor tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido + " (" + tipo + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Proveedor)) return false;
        Proveedor that = (Proveedor) o;
        return Objects.equals(cedula, that.cedula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cedula);
    }
}
