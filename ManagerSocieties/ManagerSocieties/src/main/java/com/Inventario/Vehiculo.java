package com.Inventario;

import java.io.Serializable;

public class Vehiculo extends Objeto implements Serializable {

    // Inicio Variables
    public static int generadorId = 0;
    private static final String refHerramienta = "VEH";

    private String matricula;
    private String color;

    private String ref;

    // Fin Variables

    // Inicio Constructores
    public Vehiculo (){
        super("","");
        setColor("");
        setRef("");
        setMatricula("");
    }

    public Vehiculo (String marca, String modelo, String matricula, String color){
        super(marca, modelo);
        setMatricula(matricula);
        setColor(color);

        generadorId++;
        setRef(generadorRef(generadorId, refHerramienta));
    }

    public Vehiculo (String ref, String marca, String modelo, String matricula, String color){
        super(marca, modelo);
        setMatricula(matricula);
        setColor(color);
        setRef(ref);
    }

    // Fin Constructores

    // Inicio Setters

    public void setRef (String ref){
        this.ref = ref;
    }

    public void setMatricula (String matricula){
        this.matricula = matricula;
    }
    public void setColor (String color){
        this.color = color;
    }

    // Fin Setters

    // Inicio Getters
    public String getRef () {
        return this.ref;
    }

    public String getMatricula(){
        return this.matricula;
    }

    public String getColor(){
        return this.color;
    }
}
// Fin Getters

// Inicio Funciones

// Fin Funciones
