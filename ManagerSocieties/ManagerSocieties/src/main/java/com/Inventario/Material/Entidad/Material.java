package com.Inventario.Material.Entidad;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table (name = "materiales")
public class Material implements Serializable {

    // Inicio Variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int generadorId;
    private static final String refMaterial = "MAT";
    @Column(name = "marca")
    private String marca;

    @Column(name = "modelo")
    private String modelo;
    @Column(name = "precio")
    private double precio;
    @Column(name = "cantidad")
    private int cantidad;
    @Column(name = "ref")
    private String ref;
    @Column(name = "unidades")
    private int unidades;

    // Fin Variables

    // Inicio Constructores
    public Material() {
        setMarca("");
        setModelo("");
        setPrecio(0);
        setCantidad(0);
        setRef("");
    }

    public Material(String marca, String modelo, double precio, int cantidad, int unidades, int pos) {
        setMarca(marca);
        setModelo(modelo);
        setPrecio(precio);
        setCantidad(cantidad);
        setUnidades(unidades);

        setRef(generadorRef(++pos, refMaterial));
    }

    public Material(String ref, String marca, String modelo, double precio, int cantidad, int unidades) {
        setMarca(marca);
        setModelo(modelo);
        setPrecio(precio);
        setCantidad(cantidad);
        setRef(ref);
        setUnidades(unidades);
    }

    // Fin Constructores

    // Inicio Setters

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    // Fin Setters

    // Inicio Getters
    public String getMarca() {
        return this.marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public String getRef() {
        return this.ref;
    }

    public double getPrecio() {
        return this.precio;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public int getUnidades() {
        return this.unidades;
    }

    // Fin Getters

    // Inicio Funciones
    public String generadorRef(int num, String ref) {
        int digitos = (int) (Math.log10(num) + 1);
        String refAux = "";
        for (int i = 0; i < (4 - digitos); i++) {
            refAux = refAux.concat("0");
        }
        return (ref + (refAux) + num);
    }
    // Fin Funciones
}