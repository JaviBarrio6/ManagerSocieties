package com.Calendario.Entidad;

public class Mes {

    // Inicio Variables
    private String mes;
    private int dias;

    // Fin Variables

    // Inicio Constructores

    public Mes (String mes, int dias){
        setMes(mes);
        setDias(dias);
    }

    // Fin Constructores

    // Inicio Setters
    public void setMes (String mes){
        this.mes = mes;
    }

    public void setDias (int dias){
        this.dias = dias;
    }

    // Fin Setters

    // Inicio Getters
    public String getMes (){
        return this.mes;
    }

    public int getDias (){
        return this.dias;
    }

    // Fin Getters

}
