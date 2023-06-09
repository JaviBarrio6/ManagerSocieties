package com.Inventario.Vehiculo.Entidad;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "vehiculos")
public class Vehiculo implements Serializable {

    // Inicio Variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int generadorId;
    private static final String refVehiculo = "VEH";

    @Column(name = "marca")
    private String marca;

    @Column(name = "modelo")
    private String modelo;
    @Column(name = "matricula")
    private String matricula;
    @Column(name = "color")
    private String color;

    @Column(name = "ref")
    private String ref;

    // Fin Variables

    // Inicio Constructores
    public Vehiculo() {
        setMarca("");
        setModelo("");
        setColor("");
        setRef("");
        setMatricula("");
    }

    public Vehiculo(String marca, String modelo, String matricula, String colorm, int pos) {
        setMarca(marca);
        setModelo(modelo);
        setMatricula(matricula);
        setColor(color);

        setRef(generadorRef(++pos, refVehiculo));
    }

    public Vehiculo(String ref, String marca, String modelo, String matricula, String color) {
        setMarca(marca);
        setModelo(modelo);
        setMatricula(matricula);
        setColor(color);
        setRef(ref);
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

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setColor(String color) {
        this.color = color;
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

    public String getMatricula() {
        return this.matricula;
    }

    public String getColor() {
        return this.color;
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