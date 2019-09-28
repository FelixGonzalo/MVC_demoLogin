
package com.demo.model;

import javax.swing.JOptionPane;

/**
 *
 * @author Fekilo
 */
public class Model {
    public static void mensajeError(Exception e){
        JOptionPane.showMessageDialog(null, "Error: " + e);
    }
}
