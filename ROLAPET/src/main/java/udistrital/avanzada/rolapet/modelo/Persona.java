package udistrital.avanzada.rolapet.modelo;

/**
 * Representa una persona con datos básicos de identificación y contacto.
 * Contiene los atributos nombre, apellido, cédula, correo y celular.
 * 
 * @author Sarita
 * @version 1.0, 21-09-2025
 */
public class Persona {
    private String nombre;
    private String apellido;
    private String cedula;
    private String correo;
    private String celular;

    /**
     * Constructor que inicializa una persona con todos sus atributos.
     * 
     * @param nombre Nombre de la persona.
     * @param apellido Apellido de la persona.
     * @param cedula Número de cédula.
     * @param correo Correo electrónico.
     * @param celular Número de celular.
     */
    public Persona(String nombre, String apellido, String cedula, String correo, String celular) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.correo = correo;
        this.celular = celular;
    }

    /**
     * Devuelve el nombre de la persona.
     * @return nombre de la persona
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la persona.
     * @param nombre nombre a asignar
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el apellido de la persona.
     * @return apellido de la persona
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Establece el apellido de la persona.
     * @param apellido apellido a asignar
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Devuelve el número de cédula.
     * @return número de cédula
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * Establece el número de cédula.
     * @param cedula cédula a asignar
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * Devuelve el correo electrónico.
     * @return correo electrónico
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo electrónico.
     * @param correo correo a asignar
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Devuelve el número de celular.
     * @return número de celular
     */
    public String getCelular() {
        return celular;
    }

    /**
     * Establece el número de celular.
     * @param celular número de celular a asignar
     */
    public void setCelular(String celular) {
        this.celular = celular;
    }
}
