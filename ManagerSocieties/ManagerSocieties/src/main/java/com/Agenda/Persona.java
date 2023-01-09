package com.Agenda;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

public class Persona implements Serializable {

    // Inicio Variables
    private String nombre;
    private String apellidos;
    private String id;
    private String telefono;
    private String email;
    private String direccion;
    private ArrayList <File> documentos;

    public final char[] letrasDNI = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};

    // Fin Variables

    // Inicio Constructores

    public Persona (String nombre, String apellidos, String id, String telefono, String email, String direccion){
        setNombre(nombre);
        setApellidos(apellidos);
        setId(id);
        setTelefono(telefono);
        setEmail(email);
        setDireccion(direccion);
        this.documentos = new ArrayList<>();
    }

    // Fin Constructores

    // Inicio Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public void setId(String id) {
        this.id = id;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    // Fin Setters

    // Inicio Getters

    public String getNombre() {
        return this.nombre;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public String getId() {
        return this.id;
    }

    public String getTelefono() {
        return this.telefono;
    }
    public String getEmail() {
        return this.email;
    }

    public String getDireccion() {
        return this.direccion;
    }

    // Fin Getters

    // Inicio Funciones
    public boolean esDni (String id){
        return ((int)id.charAt(0) >= 48 && (int)id.charAt(0) <= 57);
    }

    public boolean esDNICorrecto (String dni){
        if (dni.length() != 9){
            return false;
        } else {
            int numero = Integer.parseInt(dni.substring(0, 8));
            char letra = dni.charAt(8);

            return (letrasDNI[(numero % 23)] == letra);
        }
    }

    public boolean esCIFCorrecto (String cif){
        if (cif.length() != 9){
            return false;
        } else {
            char tipoOrganizacion = cif.charAt(0);
            int codigoProvincia = Integer.parseInt(cif.substring(1, 2));
            int numProvincia = Integer.parseInt(cif.substring(3, 7));
            char digitoLetra = cif.charAt(8);

            return  ((((int)tipoOrganizacion >= 65) && ((int)tipoOrganizacion < 73)) || ((int)tipoOrganizacion >= 75) && ((int)tipoOrganizacion < 83));
        }
    }

    public String generadorRef (int num, String ref){
        int digitos = (int)(Math.log10(num)+ 1);
        String refAux = "";
        for (int i = 0; i < (4-digitos); i++){
            refAux = refAux.concat("0");
        }
        return (ref + (refAux) + num);
    }

    // Fin Funciones
}
