package udistrital.avanzada.rolapet.modelo;

/**
 * Representa una persona con datos básicos de identificación y contacto.
 * Contiene los atributos nombre, apellido, cédula, correo y celular.
 * <p>
 * MODIFICACIÓN: Se agregaron validaciones en los setters de cédula, correo y celular
 * para asegurar formatos correctos y lanzar IllegalArgumentException en caso de datos inválidos.
 * </p>
 * 
 * @author Sarita
 * @version 1.2, 26-09-2025
 */
/**
 * Class Persona.
 */
/**
 * Class Persona.
 */
public class Persona {
    private String nombre;
    private String apellido;
    private String cedula;
    private String correo;
    private String celular;

    /**
     * Constructor que inicializa una persona con todos sus atributos.
     * La cédula, correo y celular se asignan usando setters validados.
     * 
     * @param nombre Nombre de la persona.
     * @param apellido Apellido de la persona.
     * @param cedula Número de cédula (solo dígitos).
     * @param correo Correo electrónico válido.
     * @param celular Número de celular (10 dígitos).
     */
    public Persona(String nombre, String apellido, String cedula, String correo, String celular) {
        this.nombre = nombre;
        this.apellido = apellido;
        setCedula(cedula);
        setCorreo(correo);
        setCelular(celular);
    }

/**
 * getNombre method.
 * @return result
 */
/**
 * getNombre method.
 * @return result
 */
/**
 * getNombre method.
 * @return result
 */
    public String getNombre() {
        return nombre;
    }
/**
 * setNombre method.
 * @param nombre parameter
 * @return result
 */
/**
 * setNombre method.
 * @param nombre parameter
 */
/**
 * setNombre method.
 * @param nombre parameter
 */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

/**
 * getApellido method.
 * @return result
 */
/**
 * getApellido method.
 * @return result
 */
/**
 * getApellido method.
 * @return result
 */
    public String getApellido() {
        return apellido;
    }
/**
 * setApellido method.
 * @param apellido parameter
 * @return result
 */
/**
 * setApellido method.
 * @param apellido parameter
 */
/**
 * setApellido method.
 * @param apellido parameter
 */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

/**
 * getCedula method.
 * @return result
 */
/**
 * getCedula method.
 * @return result
 */
/**
 * getCedula method.
 * @return result
 */
    public String getCedula() {
        return cedula;
    }

    /**
     * Establece el número de cédula.
     * MODIFICACIÓN: Valida que la cédula contenga solo dígitos.
     * 
     * @param cedula cédula a asignar (solo números enteros)
     * @throws IllegalArgumentException si la cédula no contiene solo números
     */
/**
 * setCedula method.
 * @param cedula parameter
 * @return result
 */
/**
 * setCedula method.
 * @param cedula parameter
 */
/**
 * setCedula method.
 * @param cedula parameter
 */
    public void setCedula(String cedula) {
        if (cedula != null && cedula.matches("\\d+")) {
            this.cedula = cedula;
        } else {
            throw new IllegalArgumentException("Cédula debe contener solo números enteros.");
        }
    }

/**
 * getCorreo method.
 * @return result
 */
/**
 * getCorreo method.
 * @return result
 */
/**
 * getCorreo method.
 * @return result
 */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo electrónico.
     * MODIFICACIÓN: Valida que el correo contenga '@' y al menos un '.' después.
     * 
     * @param correo correo a asignar (valido)
     * @throws IllegalArgumentException si el correo no es válido
     */
/**
 * setCorreo method.
 * @param correo parameter
 * @return result
 */
/**
 * setCorreo method.
 * @param correo parameter
 */
/**
 * setCorreo method.
 * @param correo parameter
 */
    public void setCorreo(String correo) {
        if (correo != null && correo.matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$")) {
            this.correo = correo;
        } else {
            throw new IllegalArgumentException("Correo inválido. Debe contener '@' y un '.' después.");
        }
    }

/**
 * getCelular method.
 * @return result
 */
/**
 * getCelular method.
 * @return result
 */
/**
 * getCelular method.
 * @return result
 */
    public String getCelular() {
        return celular;
    }

    /**
     * Establece el número de celular.
     * MODIFICACIÓN: Valida que celular contenga exactamente 10 dígitos numéricos.
     * 
     * @param celular número de celular a asignar (exactamente 10 dígitos)
     * @throws IllegalArgumentException si celular no tiene 10 números
     */
/**
 * setCelular method.
 * @param celular parameter
 * @return result
 */
/**
 * setCelular method.
 * @param celular parameter
 */
/**
 * setCelular method.
 * @param celular parameter
 */
    public void setCelular(String celular) {
        if (celular != null && celular.matches("\\d{10}")) {
            this.celular = celular;
        } else {
            throw new IllegalArgumentException("Celular debe contener exactamente 10 números.");
        }
    }
}
