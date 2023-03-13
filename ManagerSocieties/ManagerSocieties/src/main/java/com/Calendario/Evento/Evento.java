package com.Calendario.Evento;

import java.io.Serializable;

public class Evento implements Serializable {

    // Inicio Variables

    private static int generadorId = 0;
    private static final String refEventos = "EVE";
    private String ref;
    private String refTarea;
    private String titulo;
    private String fechaInicio;
    private String fechaFin;
    private String horaInicio;
    private String horaFin;

    // Fin Variables

    // Inicio Constructores
    public Evento (){
        setTitulo("");
        setRefTarea("");
        setRef("");
        setFechaInicio("-");
        setFechaFin("-");
        setHoraInicio("-");
        setHoraFin("-");
    }

    public Evento (String refTarea, String titulo, String fechaInicio, String fechaFin, String horaInicio, String horaFin){
        setTitulo(titulo);
        setRefTarea(refTarea);
        setFechaInicio(fechaInicio);
        setFechaFin(fechaFin);
        setHoraInicio(horaInicio);
        setHoraFin(horaFin);

        generadorId++;
        setRef(generadorRef(generadorId, refEventos));
    }

    public Evento (String refTarea, String ref, String titulo, String fechaInicio, String fechaFin, String horaInicio, String horaFin){
        setTitulo(titulo);
        setRefTarea(refTarea);
        setFechaInicio(fechaInicio);
        setFechaFin(fechaFin);
        setHoraInicio(horaInicio);
        setHoraFin(horaFin);

        setRef(ref);
    }

    // Fin Constructores

    // Inicio Setters

    public void setRefTarea(String refTarea){
        this.refTarea = refTarea;
    }
    public void setRef(String ref){
        this.ref = ref;
    }

    public void setTitulo (String titulo){
        this.titulo = titulo;
    }

    public void setFechaInicio (String fechaInicio){
        if (fechaInicio == null){
            this.fechaInicio = "-";
        } else if (fechaInicio.equals("")){
            this.fechaInicio = "-";
        } else {
            this.fechaInicio = (darFormatoFecha(fechaInicio));

        }
    }

    public void setFechaFin (String fechaFin){
        if (fechaFin == null){
            this.fechaFin = "-";
        } else if (fechaFin.equals("")){
            this.fechaFin = "-";
        } else {
            this.fechaFin = (darFormatoFecha(fechaFin));

        }
    }

    public void setHoraInicio (String horaInicio){
        this.horaInicio = horaInicio;
    }
    public void setHoraFin (String horaFin){
        this.horaFin = horaFin;
    }

    // Fin Setters

    // Inicio Getters
    public String getRef(){
        return this.ref;
    }

    public String getRefTarea(){
        return this.refTarea;
    }

    public String getTitulo(){
        return this.titulo;
    }

    public String getFechaInicio () {
        return this.fechaInicio;
    }

    public String getFechaFin () {
        return this.fechaFin;
    }

    public String getHoraInicio () {
        return this.horaInicio;
    }
    public String getHoraFin () {
        return this.horaFin;
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

    public String darFormatoFecha (String fecha){
        String[] campos = fecha.split("-");
        if (campos.length != 3){
            return fecha;
        } else {
            return campos[2].concat("/".concat(campos[1]).concat("/").concat(campos[0]));
        }
    }

    public String darFormatoFecha (int dia, int mes, int anyo){
        String diaAux;
        String mesAux;

        if (dia < 10){
            diaAux = "0".concat(String.valueOf(dia));
        } else {
            diaAux = String.valueOf(dia);
        }

        if (mes < 10){
            mesAux = "0".concat(String.valueOf(mes));
        } else {
            mesAux = String.valueOf(mes);
        }

        return diaAux.concat("/").concat(mesAux).concat("/").concat(String.valueOf(anyo));
    }

    public String desformatearFecha (String fecha){
        if (fecha.equals("-")){
            return fecha;
        } else {
            String[] campos = fecha.split("/");
            return campos[2].concat("-".concat(campos[1]).concat("-").concat(campos[0]));
        }
    }

    // Fin Funciones
}
