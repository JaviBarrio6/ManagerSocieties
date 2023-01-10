package com.Inventario;

import java.io.Serializable;

public class Producto extends Objeto implements Serializable {

    // Inicio Variables
    public static int generadorId = 0;
    private static final String refProducto = "PRO";

    private String ref;
    private String modelo;
    private int stock;
    private double precio;

    private String urlFoto;

    // Fin Variables

    // Inicio Constructores
    public Producto (){
        super("","");
        setRef("");
        setModelo("");
        setStock(0);
        setPrecio(0);
        setUrlFoto("");
    }

    public Producto (String modelo, double precio, int stock, String urlFoto){
        super("", modelo);
        setPrecio(precio);
        setStock(stock);
        setUrlFoto(urlFoto);

        generadorId++;
        setRef(generadorRef(generadorId, refProducto));
    }

    public Producto (String ref, String modelo, double precio, int stock, String urlFoto){
        super("", modelo);
        setPrecio(precio);
        setStock(stock);
        setUrlFoto(urlFoto);
        setRef(ref);
    }

    // Fin Constructores

    // Inicio Setters

    public void setRef (String ref){
        this.ref = ref;
    }

    public void setModelo (String modelo){
        this.modelo = modelo;
    }

    public void setPrecio (double precio){
        this.precio = precio;
    }
    public void setStock (int stock){
        this.stock = stock;
    }

    public void setUrlFoto (String urlFoto){
        this.urlFoto = "/img/" + urlFoto;
    }

    // Fin Setters

    // Inicio Getters
    public String getRef () {
        return this.ref;
    }

    public String getModelo(){
        return this.modelo;
    }

    public double getPrecio(){
        return this.precio;
    }

    public String getUrlFoto (){
        return this.urlFoto;
    }

    public int getStock(){
        return this.stock;
    }
}
// Fin Getters

// Inicio Funciones

// Fin Funciones

