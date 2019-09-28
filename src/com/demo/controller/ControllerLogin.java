
package com.demo.controller;

import com.demo.model.ModeloUsuario;
import com.demo.model.entity.Usuario;

/**
 *
 * @author Fekilo
 */
public class ControllerLogin extends Controller {

    public ControllerLogin() {

    }

    public boolean logIn(String usuario, String clave) {
        boolean band = false;
        Usuario user = new Usuario(usuario, clave);
        band = ModeloUsuario.logIn(user);
        return band;
    }

    public long logUp(String id, String email, String clave, String apellidos, String nombres, String tipo) {
        long status = 0;
        if (id.equals("") && email.equals("") && clave.equals("") && apellidos.equals("")&& nombres.equals("") && tipo.equals("0") ) {
            status = 4;
        }else if (!(email.endsWith("@hotmail.com") || email.endsWith("@gmail.com") || email.endsWith("@outlook.es")) || email.equals("")) {
            status = 5;
        } else if (clave.equals("")) {
            status = 6;
        } else if (nombres.equals("") || apellidos.equals("")) {
            status = 7;
        } else {
            try {
                Usuario user = new Usuario(Integer.parseInt(id), email, clave, apellidos, nombres, Integer.parseInt(tipo));
                status = ModeloUsuario.logUp(user);
            } catch (Exception e) {
                status = 8;
            }
        }
        return status;
    }

    public long RecuperarClave(String email, String clave) {
        long status = 0;
        if (clave.equals("")) {
            status = 2;
        } else if (email.equals("")) {
            status = 3;
        } else {
            Usuario user = new Usuario(email, clave);
            status = ModeloUsuario.recuperarClave(user);
        }
        return status;
    }

}
