package com.demo.model;

import com.demo.model.entity.Usuario;
import java.util.ArrayList;

/**
 *
 * @author Fekilo
 */
public class ModeloUsuario extends Model {

    public static ArrayList<Usuario> usuarios = new ArrayList<>();

    static public boolean logIn(Usuario user) {
        boolean band = false;
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().compareTo(user.getEmail()) == 0 && usuario.getClave().compareTo(user.getClave()) == 0) {
                band = true;
            }
        }
        return band;
    }

    public static long logUp(Usuario user) {
        long band = 0;
        try {
            for (Usuario usuario : usuarios) {
                if (usuario.getId() == user.getId()) {
                    return band = 2;
                } else if (usuario.getEmail().equals(user.getEmail())) {
                    return band = 3;
                }
            }
            usuarios.add(user);
        } catch (Exception e) {
            mensajeError(e);
            band = 1;
        }
        return band;
    }

    public static long recuperarClave(Usuario user) {
        long band = 0;
        try {
            for (Usuario usuario : usuarios) {
                if (usuario.getEmail().equals(user.getEmail())) {
                    usuario.setClave(user.getClave());
                    return band;
                }
            }
        } catch (Exception e) {
            mensajeError(e);
        }finally{
            band = 1;
        }
        return band;
    }

}
