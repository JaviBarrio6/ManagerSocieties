package com.Inventario;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

public class Objeto implements Serializable {

    // Inicio Variables

    private String marca;
    private String modelo;
    private ArrayList <File> facturas;

    // Fin Variables

    // Inicio Constructores
    public Objeto (String marca, String modelo){
        setMarca(marca);
        setModelo(modelo);
        this.facturas = new ArrayList<>();
    }

    // Fin Constructores

    // Inicio Setters

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    // Fin Setters

    // Inicio Getters

    public String getMarca() {
        return this.marca;
    }

    public String getModelo() {
        return this.modelo;
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
