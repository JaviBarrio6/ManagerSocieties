package com.Agenda;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

public class Persona implements Serializable {
    private String nombre;
    private String apellidos;
    private String id;
    private String telefono;
    private String email;
    private String direccion;
    private ArrayList <File> documentos;

    public Persona (String nombre, String apellidos, String id, String telefono, String email, String direccion){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.id = id;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
        this.documentos = new ArrayList<>();
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<File> getDocumentos() {
        return this.documentos;
    }

    public void setDocumentos(ArrayList<File> documentos) {
        this.documentos = documentos;
    }
}
