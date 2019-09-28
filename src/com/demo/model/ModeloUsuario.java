package com.demo.model;

import com.demo.model.entity.Usuario;
import java.io.*;

/**
 *
 * @author Fekilo
 */
public class ModeloUsuario extends Model {

    public static File archivo = new File("src/archivoTxt/archivo.txt");

    public static long logUp(Usuario user) {
        long band = 0;
        try {
            BufferedReader almacenamiento = new BufferedReader(new FileReader(archivo));
            String linea;
            String[] parts;
            while ((linea = almacenamiento.readLine()) != null) {
                parts = linea.split(";");
                if (Integer.parseInt(parts[0]) == user.getId()) {
                    return band = 2;
                } else if (parts[1].equals(user.getEmail())) {
                    return band = 3;
                }
            }
            PrintWriter escribir = new PrintWriter(new FileWriter(archivo, true));
            String lineaTexto = user.getId() + ";" + user.getEmail() + ";" + user.getClave() + ";" + user.getApellidos() + ";" + user.getNombres() + ";" + user.getTipo();
            escribir.println(lineaTexto);
            escribir.close();
            almacenamiento.close();
        } catch (Exception e) {
            mensajeError(e);
            band = 1;
        }
        return band;
    }//añadimos texto al final del archivo

    public static boolean logIn(Usuario user) {
        boolean band = false;
        try {
            BufferedReader almacenamiento = new BufferedReader(new FileReader(archivo));
            String linea;
            String[] parts;
            while ((linea = almacenamiento.readLine()) != null) {
                parts = linea.split(";");
                if (parts[1].compareTo(user.getEmail()) == 0 && parts[2].compareTo(user.getClave()) == 0) {
                    band = true;
                }
            }
            almacenamiento.close();
        } catch (Exception e) {
            mensajeError(e);
        }
        return band;
    }

    public static long recuperarClave(Usuario user) {
        long band = 0;
        int condicion = 0;//es necesario rescribir??
        try {
            BufferedReader almacenamiento = new BufferedReader(new FileReader(archivo));
            String texto = "";
            String lineaNueva = "";
            String linea;
            String[] parts;
            while ((linea = almacenamiento.readLine()) != null) {
                parts = linea.split(";");
                if (parts[1].equals(user.getEmail())) {
                    lineaNueva = parts[0] + ";" + parts[1] + ";" + user.getClave() + ";" + parts[3] + ";" + parts[4] + ";" + parts[5];
                    condicion = 1;
                } else {
                    texto = texto + linea + "\n";
                }
            }
            if (condicion == 1) {
                PrintWriter escribir = new PrintWriter(new FileWriter(archivo));
                texto = texto + lineaNueva;
                escribir.println(texto);
                escribir.close();
            }
            almacenamiento.close();
        } catch (Exception e) {
            mensajeError(e);
        }finally {
            if (condicion == 0) {
                band = 1;
            }
        }
        return band;

    }//se cambia el texto del archivo 
}
