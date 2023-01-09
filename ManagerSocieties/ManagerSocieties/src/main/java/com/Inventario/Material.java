package com.Inventario;

import java.io.Serializable;

public class Material extends Objeto implements Serializable {

    // Inicio Variables
    public static int generadorId = 0;
    private static final String refHerramienta = "MAT";
    private double precio;
    private int cantidad;

    private int unidades;

    private String ref;

    // Fin Variables

    // Inicio Constructores
    public Material (){
        super("","");
        setPrecio(0);
        setCantidad(0);
        setRef("");
    }

    public Material (String marca, String modelo, double precio, int cantidad, int unidades){
        super(marca, modelo);
        setPrecio(precio);
        setCantidad(cantidad);
        setUnidades(unidades);

        generadorId++;
        setRef(generadorRef(generadorId, refHerramienta));
    }

    public Material (String ref, String marca, String modelo, double precio, int cantidad, int unidades){
        super(marca, modelo);
        setPrecio(precio);
        setCantidad(cantidad);
        setRef(ref);
        setUnidades(unidades);
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

    public void setUnidades (int unidades){
        this.unidades = unidades;
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

    public int getUnidades(){
        return this.unidades;
    }
}
// Fin Getters

// Inicio Funciones

// Fin Funciones