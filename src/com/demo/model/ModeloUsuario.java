/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.model;

import com.demo.model.entity.Usuario;
import java.io.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author whiston
 */
public class ModeloUsuario extends Model {

    public static long logUp(Usuario user) {//logUp
        long band = 0;
        try {
            PreparedStatement ps = con.prepareStatement("insert into usuario values(?,?,?,?,?,?)");
            ps.setInt(1, user.getId());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getClave());
            ps.setString(4, user.getApellidos());
            ps.setString(5, user.getNombres());
            ps.setInt(1, user.getTipo());
            ps.executeUpdate();
        } catch (Exception e) {
             return band =1;
        }
        return band;
    }
        
    public static boolean logIn(Usuario user) {//log in
        boolean band = false;
        try {
            ResultSet rs = null;
            PreparedStatement ps = con.prepareStatement("SELECT email, clave FROM email = "+user.getEmail());
            rs = ps.executeQuery();
            if (rs.getString(1).equals(user.getEmail()) && rs.getString(2).equals(user.getClave()) ) {
                band=true;
            }
        } catch (Exception e) {
            return band;
        }
        return band;
    }

    public static long recuperarClave(Usuario user) {//recuperar contraseña
        long band = 0;
        String texto = "";
       try {
            PreparedStatement ps = con.prepareStatement("UPDATE usuario SET clave='"+user.getClave()+" WHERE email=" + user.getEmail());
            ps.executeUpdate();
        } catch (Exception e) {
             return band =1;
        }
        return band;
    }//se cambia el texto del archivo 
        
}
