package com.Dashboard.Entidad;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Calendar;

@Entity
@Table(name = "actividades")
public class Actividad implements Serializable {

    // Inicio Variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int generadorId;

    @Column (name = "mensaje")
    private String mensaje;

    @Column (name = "hora")
    private int hora;

    @Column (name = "minutos")
    private int minutos;

    @Column (name = "fecha")
    private String fecha;


    // Fin Variables

    // Inicio Constructores
    public Actividad(){

    }

    public Actividad(String mensaje, int hora, int minutos, String fecha){
        setMensaje(mensaje);
        setHora(hora);
        setMinutos(minutos);
        setFecha(fecha);
    }

    // Inicio Setters
    public void setMensaje(String mensaje){
        this.mensaje = mensaje;
    }

    public void setHora (int hora){
        this.hora = hora;
    }

    public void setMinutos (int minutos){
        this.minutos = minutos;
    }

    public void setFecha (String fecha){
        this.fecha = fecha;
    }

    // Fin Setters

    // Inicio Getters
    public String getMensaje(){
        return this.mensaje;
    }

    public int getHora() {
        return this.hora;
    }

    public int getMinutos(){
        return this.minutos;
    }

    public String getFecha(){
        return this.fecha;
    }

    // Fin Getters
}
