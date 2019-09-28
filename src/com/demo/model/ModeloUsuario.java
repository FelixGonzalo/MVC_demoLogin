package com.demo.model;

import com.demo.model.entity.Usuario;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Fekilo
 */
public class ModeloUsuario extends Model {

    public static long logUp(Usuario user) {
        Connection con = Model.getConexion();
        long band = 0;
        try {
            ResultSet rs = null;
            PreparedStatement ps = con.prepareStatement("SELECT * FROM usuario WHERE email = '" + user.getEmail() + "'");
            rs = ps.executeQuery();
            if (rs.first()) {
                band = 2;
            }else{
                ps = con.prepareStatement("insert into usuario values(?,?,?,?,?,?)");
                ps.setInt(1, user.getId());
                ps.setString(2, user.getEmail());
                ps.setString(3, user.getClave());
                ps.setString(4, user.getApellidos());
                ps.setString(5, user.getNombres());
                ps.setInt(6, user.getTipo());
                ps.executeUpdate();
            }// evitamos repetición de correo
            con.close();
        } catch (Exception e) {
            mensajeError(e);
            band = 1;
        }
        return band;
    }

    public static boolean logIn(Usuario user) {
        Connection con = Model.getConexion();
        boolean band = false;
        try {
            ResultSet rs = null;
            PreparedStatement ps = con.prepareStatement("SELECT * FROM usuario WHERE email = '" + user.getEmail() + "'");
            rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getString(2).equals(user.getEmail()) && rs.getString(3).equals(user.getClave())) {
                    band = true;
                }
            }
            con.close();
        } catch (Exception e) {
            mensajeError(e);
        }

        return band;
    }

    public static long recuperarClave(Usuario user) {
        Connection con = Model.getConexion();
        long band = 0;
        String texto = "";
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE usuario SET clave='" + user.getClave() + "' WHERE email='" + user.getEmail() + "'");
            int i = ps.executeUpdate();
            if (i == 0) {
                band = 1;
            }
            con.close();
        } catch (Exception e) {
            return band = 1;
        }

        return band;
    }

}
