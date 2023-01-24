package com.Usuario;

import java.util.ArrayList;

public class Empresa {

    // Inicio Variables
    private String logo;
    private String nombre;
    private String cif;
    private String telefono;
    private String email;
    private String direccion;
    private String iban;

    // Fin Variables

    // Inicio Constructores

    public Empresa (String logo, String nombre, String cif, String telefono, String email, String direccion, String iban){
        setLogo(logo);
        setNombre(nombre);
        setCif(cif);
        setTelefono(telefono);
        setEmail(email);
        setDireccion(direccion);
        setIban(iban);
    }

    // Fin Constructores

    // Inicio Setters

    public void setLogo(String logo){
        if (logo == null){
            this.logo = "/img/not-logo.jpg";
        } else {
            this.logo = "/img/".concat(logo);
        }
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setCif(String cif) {
        if (esCIFCorrecto(cif)){
            this.cif = cif;
        } else {
            throw new RuntimeException("El CIF no es correcto");
        }
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

    public void setIban (String iban){
        if (iban.length() == 24){
            char letra = iban.charAt(0);
            if ((((int)letra >= 65) && ((int)letra < 73)) || ((int)letra >= 75) && ((int)letra < 83)){
                letra = iban.charAt(1);
                if ((((int)letra >= 65) && ((int)letra < 91)) || ((int)letra >= 97) && ((int)letra <= 123)){
                    this.iban = iban;
                } else {
                    throw new RuntimeException("El IBAN no es correcto");
                }
            } else {
                throw new RuntimeException("El IBAN no es correcto");
            }
        } else {
            throw new RuntimeException("El IBAN no es correcto");
        }
    }

    // Fin Setters

    // Inicio Getters

    public String getNombre() {
        return this.nombre;
    }

    public String getLogo() {
        return this.logo;
    }

    public String getCif() {
        return this.cif;
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

    public String getIban(){
        return this.iban;
    }

    // Fin Getters

    // Inicio Funciones

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

    public void editarEmpresa (String nombre, String cif, String telefono, String email, String direccion, String iban){
        setNombre(nombre);
        setCif(cif);
        setTelefono(telefono);
        setEmail(email);
        setDireccion(direccion);
        setIban(iban);
    }
}
