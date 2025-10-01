
package udistrital.avanzada.rolapet.modelo;

import java.time.LocalDateTime;

/**
 * Representa la relación (apuntador) de amistad entre un usuario (origen) y otro usuario (destino).
 * 
 * Según los requerimientos del taller, agregar un amigo NO implica duplicar
 * el objeto {@link Usuario}, sino guardar una referencia a través de la identificación
 * (cedulaUsuario). Esto garantiza que cada usuario exista de forma única en el sistema.
 * 
 * La clase contiene:
 * 
 * El id del usuario que envía la solicitud de amistad (cedulaUsuario).
 * El id del usuario agregado como amigo (cedulaAmigo).
 * La fecha y hora en que se creó la relación de amistad.
 * 
 * @author Steban
 * @version 1.0, 01/10/2025
 * 
 * Class Amigo
 */
public class Amigo {

    /* Identificador del usuario dueño de la lista de amigos */
    private String cedulaUsuario;

    /* Identificador del usuario agregado como amigo (referencia por cedula) */
    private String cedulaAmigo;


    /**
     * Constructor básico para crear una relación de amistad aceptada por defecto.
     *
     * @param cedulaUsuario  ID del usuario que agrega el amigo
     * @param cedulaAmigo ID del usuario agregado como amigo
     */
    public Amigo(String cedulaUsuario, String cedulaAmigo) {
        this.cedulaUsuario = cedulaUsuario;
        this.cedulaAmigo = cedulaAmigo;
    }

    public String getcedulaUsuario() {
        return cedulaUsuario;
    }

    public String getcedulaAmigo() {
        return cedulaAmigo;
    }
}

