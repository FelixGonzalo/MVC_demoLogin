/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.model;

import com.demo.model.entity.Usuario;
import java.util.ArrayList;

/**
 *
 * @author whiston
 */
public class ModeloUsuario extends Model {
    
    public static ArrayList<Usuario> usuarios = new ArrayList<>();
    
    static public boolean logIn(Usuario user){
        boolean band= false;
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().compareTo(user.getEmail()) == 0 && usuario.getClave().compareTo(user.getClave())==0) {
                band=true;
            }
        }
        return band;
    }
    
    public static long logUp(Usuario user){
        long band=0;
        if (usuarios.size() == 0) {
            if (user.getId() == 0) {
                return 1;
            }else if ( user.getEmail().equals("")
                    || !(user.getEmail().endsWith("@hotmail.com") || user.getEmail().endsWith("@gmail.com") || user.getEmail().endsWith("@outlook.com"))) {
                return 2;
            }else if ( user.getClave().equals("")) {
                return 3;
            }
        }else{
            for (Usuario usuario : usuarios) {
            if (usuario.getId() == user.getId() || user.getId() == 0) {
                return 1;
            }else if ( usuario.getEmail().equals(user.getEmail()) || user.getEmail().equals("")
                    || !(user.getEmail().endsWith("@hotmail.com") || user.getEmail().endsWith("@gmail.com") || user.getEmail().endsWith("@outlook.com"))) {
                return 2;
            }else if ( user.getClave().equals("")) {
                return 3;
            }
            }
        }

        usuarios.add(user);
        listarUsuario();
        return band;
    }
    
    public static long recuperarClave(Usuario user){
        long band=0;
        for (Usuario usuario : usuarios) {
            if ( usuario.getEmail().equals(user.getEmail())) {
                if (user.getClave().equals("")) {
                    return 1;
                }else{
                    usuario.setClave(user.getClave());
                    listarUsuario();
                    return band;
                }
            }
        }
        return 2;
        
    }
    
    public static void listarUsuario(){
        System.out.println("---------------------");
        for (Usuario usuario : usuarios) {
            System.out.println("usuario: " + usuario.getId() + " email: " + usuario.getEmail() + " clave: "+usuario.getClave()+" tipo: " + usuario.getTipo());
        }
    }
    
    
    
}
