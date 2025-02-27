
package com.demo.model.entity;

/**
 *
 * @author Fekilo
 */
public class Usuario {
    
    private int id;
    private String email;
    private String clave;
    private String apellidos;
    private String nombres;
    private int tipo;

    public Usuario() {
    }

    public Usuario(int id, String email, String clave, String apellidos, String nombres, int tipo) {
        this.id = id;
        this.email = email;
        this.clave = clave;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.tipo = tipo;
    }

    public Usuario(String email, String clave) {
        this.email = email;
        this.clave = clave;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    
    
}
