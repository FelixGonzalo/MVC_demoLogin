/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.model;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author whiston
 */
public class Model {
    private static String user = "root";
    private static String password = "";
    private static String url = "jdbc:mysql://localhost:3306/demologin";
    protected static Connection con = null;

    public static Connection getConexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(url, user, password);
            JOptionPane.showMessageDialog(null, "Conexión correcta");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Conexión fallida");
        }
        return con;
    }
 
    public static void main(String[] args) {
        Model prueba = new Model();
        prueba.getConexion();
    }
    
}
