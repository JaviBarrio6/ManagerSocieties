package com.Inventario.Maquina.Entidad;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table (name = "maquinas")
public class Maquina implements Serializable {

    // Inicio Variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int generadorId;
    private static final String refMaquina = "MAQ";

    @Column (name = "marca")
    private String marca;

    @Column (name = "modelo")
    private String modelo;
    @Column (name = "ref")
    private String ref;
    @Column (name = "precio")
    private double precio;
    @Column (name = "cantidad")
    private int cantidad;

    // Fin Variables

    // Inicio Constructores
    public Maquina (){
        setMarca("");
        setModelo("");
        setPrecio(0);
        setCantidad(0);
        setRef("");
    }

    public Maquina (String marca, String modelo, double precio, int cantidad, int pos){
        setMarca(marca);
        setModelo(modelo);
        setPrecio(precio);
        setCantidad(cantidad);
        setRef(generadorRef(++pos, refMaquina));
    }

    public Maquina (String ref, String marca, String modelo, double precio, int cantidad){
        setRef(ref);
        setPrecio(precio);
        setCantidad(cantidad);
        setRef(ref);
    }
    // Fin Constructores

    // Inicio Setters
    public void setMarca (String marca){
        this.marca = marca;
    }

    public void setModelo (String modelo){
        this.modelo = modelo;
    }
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
    public String getMarca () {
        return this.marca;
    }

    public String getModelo () {
        return this.modelo;
    }
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
