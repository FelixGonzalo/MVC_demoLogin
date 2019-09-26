/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.model;

import com.demo.model.entity.Usuario;
import java.io.*;

/**
 *
 * @author whiston
 */
public class ModeloUsuario extends Model {

    public static File archivo = new File("src/archivoTxt/archivo.txt");

    public static long logUp(Usuario user) {//logUp
        long band = 0;
        String linea;
        try {

            FileReader lectorArchivo = new FileReader(archivo);
            BufferedReader almacenamiento = new BufferedReader(lectorArchivo);
            String[] parts;
            System.out.println("LlEGO HASTA ACA");
            while ((linea = almacenamiento.readLine()) != null) {
                parts = linea.split(";");//separo los datos por cada linea
                if (Long.parseLong(parts[0]) == user.getId()) {
                    return 1;
                } else if (parts[1].equals(user.getEmail()) || user.getEmail().equals("")) {
                    return 2;
                } else if (user.getClave().equals("")) {
                    return 3;
                }
            }

            FileWriter escritorArchivo = new FileWriter(archivo, true);//si tiene true, escribe al final del texto
            PrintWriter escribir = new PrintWriter(escritorArchivo);
            String lineaTexto = user.getId() + ";" + user.getEmail() + ";" + user.getClave() + ";" + user.getApellidos() + ";" + user.getNombres() + ";" + user.getTipo();

            escribir.println(lineaTexto);

            escribir.close();
            escritorArchivo.close();
            almacenamiento.close();
            lectorArchivo.close();
        } catch (Exception e) {
            System.out.println("Error al escribir: " + e);
        }
        return band;
    }//añadimos texto al final del archivo

    public static boolean logIn(Usuario user) {//log in
        boolean band = false;
        try {
            FileReader lectorArchivo = new FileReader(archivo);
            BufferedReader almacenamiento = new BufferedReader(lectorArchivo);
            String linea;
            String[] parts;
            while ((linea = almacenamiento.readLine()) != null) {
                parts = linea.split(";");//separo los datos por cada linea
                if (parts[1].compareTo(user.getEmail()) == 0 && parts[2].compareTo(user.getClave()) == 0) {
                    band = true;
                }
            }
            almacenamiento.close();
            lectorArchivo.close();
        } catch (Exception e) {
            System.out.println("Error al leer: " + e);
        }
        return band;
    }

    public static long recuperarClave(Usuario user) {//recuperar contraseña
        long band = 2;
        String texto = "";
        int condicion = 0;//para ver si es necesario rescribir
        try {
            FileReader lectorArchivo = new FileReader(archivo);
            BufferedReader almacenamiento = new BufferedReader(lectorArchivo);

            String linea;
            String[] parts;
            while ((linea = almacenamiento.readLine()) != null) {
                parts = linea.split(";");//separo los datos por cada linea
                if (parts[1].equals(user.getEmail())) {
                    if (user.getClave().equals("")) {
                        return 1;
                    } else {
                        linea = user.getId() + ";" + user.getEmail() + ";" + user.getClave() + ";" + user.getApellidos() + ";" + user.getNombres() + ";" + user.getTipo() + "\n";
                        texto = texto + linea;
                        condicion = 1;
                    }
                } else {
                    texto = texto + linea + "\n";
                }
            }
            if (condicion == 1) {
                PrintWriter escribir = new PrintWriter(archivo);
                escribir.println(texto);
                band = 0;
                escribir.close();
            }
        } catch (Exception e) {
            System.out.println("Error al rescribir : " + e);
        }
        return band;

    }//se cambia el texto del archivo 
}
