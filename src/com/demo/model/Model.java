
package com.demo.model;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Fekilo
 */
public class Model {
    private static String user = "root";
    private static String password = "";
    private static String url = "jdbc:mysql://localhost:3306/demologin";

    public static Connection getConexion() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Conexión fallida: " + e);
        }
        return con;
    }
 
    public static void mensajeError(Exception e) {
       JOptionPane.showMessageDialog(null, "Error: " + e);
       
    }
    
    
    
}
