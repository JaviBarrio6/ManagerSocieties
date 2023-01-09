package com.Inventario;

import java.io.Serializable;

public class Herramienta extends Objeto implements Serializable {

    // Inicio Variables
    public static int generadorId = 0;
    private static final String refHerramienta = "HER";
    private double precio;
    private int cantidad;
    private String ref;

    // Fin Variables

    // Inicio Constructores
    public Herramienta (){
        super("","");
        setPrecio(0);
        setCantidad(0);
        setRef("");
    }

    public Herramienta (String marca, String modelo, double precio, int cantidad){
        super(marca, modelo);
        setPrecio(precio);
        setCantidad(cantidad);

        generadorId++;
        setRef(generadorRef(generadorId, refHerramienta));
    }

    public Herramienta (String ref, String marca, String modelo, double precio, int cantidad){
        super(marca, modelo);
        setPrecio(precio);
        setCantidad(cantidad);
        setRef(ref);
    }

    // Fin Constructores

    // Inicio Setters

    public void setRef (String ref){
        this.ref = ref;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    // Fin Setters

    // Inicio Getters
    public String getRef () {
        return this.ref;
    }

    public double getPrecio() {
        return this.precio;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    // Fin Getters

    // Inicio Funciones

    // Fin Funciones

    //-------------------

    // Inicio Variables

    // Fin Variables

    // Inicio Constructores

    // Fin Constructores

    // Inicio Setters

    // Fin Setters

    // Inicio Getters

    // Fin Getters

    // Inicio Funciones

    // Fin Funciones
}
