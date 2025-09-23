package udistrital.avanzada.rolapet.constructor;

import java.util.ArrayList;
import java.util.List;
import udistrital.avanzada.rolapet.modelo.Usuario;

public class ControladorUsuario {
    private List<Usuario> usuarios;

    public ControladorUsuario() {
        usuarios = new ArrayList<>();
    }

    public boolean registrarUsuario(Usuario usuario) {
        if (buscarPorNombreUsuario(usuario.getNombreUsuario()) != null) {
            return false;
        }
        if (buscarPorCedula(usuario.getCedula()) != null) {
            return false;
        }
        usuarios.add(usuario);
        return true;
    }

    public Usuario buscarPorNombreUsuario(String nombreUsuario) {
        for (Usuario u : usuarios) {
            if (u.getNombreUsuario().equalsIgnoreCase(nombreUsuario)) {
                return u;
            }
        }
        return null;
    }

    public Usuario buscarPorCedula(String cedula) {
        for (Usuario u : usuarios) {
            if (u.getCedula().equalsIgnoreCase(cedula)) {
                return u;
            }
        }
        return null;
    }

    public List<Usuario> obtenerUsuarios() {
        return usuarios;
    }
}
