package com.Agenda;

import java.io.Serializable;

public class Empresa extends Persona implements Serializable {

    // Inicio Variables

    public static int generadorId = 0;

    private static final String refEmpresa = "EMS";
    private String ref;

    // Fin Variables

    // Inicio Constructores

    public Empresa () {
        super("", "", "", "", "", "");
        setRef("");
    }

    public Empresa (String nombre, String tipo, String id, String telefono, String email, String direccion){
        super (nombre, tipo, id, telefono, email, direccion);
        generadorId++;
        setRef(generadorRef(generadorId, refEmpresa));
    }

    public Empresa (String ref, String nombre, String tipo, String id, String telefono, String email, String direccion){
        super (nombre, tipo, id, telefono, email, direccion);
        setRef(ref);
    }

    // Fin Constructores

    // Inicio Setters

    private void setRef (String ref){
        this.ref = ref;
    }

    // Fin Setters

    // Inicio Getters

    public String getRef (){
        return this.ref;
    }

    public String getTipo() {
        return getApellidos();
    } // No borrar, necesario para Thymeleaf

    // Fin Funciones
}
