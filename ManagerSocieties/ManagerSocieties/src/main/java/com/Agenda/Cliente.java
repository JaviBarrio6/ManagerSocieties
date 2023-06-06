package com.Agenda;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "CLIENTES")
public class Cliente extends Persona implements Serializable {

    // Inicio Variables

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public static int generadorId;
    private static final String refCliente = "CLI";
    private boolean premium;

    private String ref;

    // Fin Variables

    // Inicio Constructores

    public Cliente () {
        super ("", "", "", "", "", "");
        setRef("");
        setPremium(false);

    }
    public Cliente(String nombre, String apellidos, String id, String telefono, String email, String direccion, boolean premium) {
        super(nombre, apellidos, id, telefono, email, direccion);

        generadorId++;
        setRef (generadorRef(generadorId, refCliente));
        setPremium(premium);
    }

    public Cliente(String ref, String nombre, String apellidos, String id, String telefono, String email, String direccion, boolean premium) {
        super(nombre, apellidos, id, telefono, email, direccion);

        setRef(ref);
        setPremium(premium);
    }

    // Fin Constructores

    // Inicio Setters

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    private void setRef (String ref){
        this.ref = ref;
    }

    // Fin Setters

    // Inicio Getters

    public String getRef() {
        return this.ref;
    }

    public boolean getPremium() {
        return this.premium;
    }

    // Fin Getters

    // Inicio Funciones

    public boolean isPremium() {
        return premium;
    }

    // Fin Funciones
}
