package com.Calendario;

import java.util.Calendar;

public class Calendario {

    // Inicio Variables
    private int dia;
    private int[] fechaActual = new int[3];
    private int mes;
    private int mesActual;
    private int anyo;
    private Mes[] meses;

    private int[][][] semanasMes;

    // Fin Variables

    // Inicio Constructores
    public Calendario (){
        setFechaActual();
        setDia(getFechaActual()[0]);
        setMes(getFechaActual()[1]);
        setAnyo(getFechaActual()[2]);
        setMeses(getFechaActual()[2]);
        setSemanasMes(getMes(), getAnyo());
    }

    public Calendario (int dia, int mes, int anyo){
        setFechaActual();
        setDia(dia);
        setMes(mes);
        setAnyo(anyo);
        setMeses(getAnyo());
        setSemanasMes(getMes(), getAnyo());
    }

    // Fin Constructores

    // Inicio Setters
    public void setFechaActual (){
        Calendar calendar = Calendar.getInstance();
        this.fechaActual[0] = calendar.get(Calendar.DATE);
        this.fechaActual[1] = calendar.get(Calendar.MONTH) + 1;
        this.fechaActual[2] = calendar.get(Calendar.YEAR);
    }

    public void setDia (int dia){
        this.dia = dia;
    }

    public void setMes (int mes){
        this.mes = mes;
    }

    public void setAnyo (int anyo){
        this.anyo = anyo;
    }

    public void setSemanasMes(int mes, int anyo){
        Calendar calendar = Calendar.getInstance();
        calendar.set(anyo, (mes - 1), 1);
        int primerDia;
        if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
            primerDia = 7;
        } else {
            primerDia = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        }
        int[] fecha = new int[]{1, mes, anyo};
        int dias;
        if (mes == 0){
            dias = primerDia + this.meses[12].getDias() - 1;
        } else {
            dias = primerDia + this.meses[mes-1].getDias() - 1;
        }
        for (int contador = primerDia; contador != 1; contador--){
            fecha = antDia(fecha[0], fecha[1], fecha[2]);
        }

        int semanas = (int) Math.ceil(dias / 7.0);

        int[][][] semanasMes = new int[semanas][7][3];

        for (int i = 0; i < semanas; i++){
            for (int j = 0; j <= 6; j++){
                semanasMes[i][j] = new int[]{fecha[0], fecha[1], fecha[2]};
                fecha = sigDia(fecha[0], fecha[1], fecha[2]);
            }
        }
        this.semanasMes = semanasMes;
    }

    public void setMeses (int anyo) {
        Mes febrero = new Mes("Febrero", 28);

        if ((anyo % 4 == 0) && (anyo % 100 != 0) || (anyo % 400 == 0)){
            febrero = new Mes("Febrero", 29);
        }

        this.meses = new Mes[]{new Mes("Enero", 31), febrero, new Mes("Marzo", 31), new Mes("Abril", 30),
                new Mes("Mayo", 31), new Mes("Junio", 30), new Mes("Julio", 31), new Mes("Agosto", 31),
                new Mes("Septiembre", 30), new Mes("Octubre", 31), new Mes("Noviembre", 30), new Mes("Diciembre", 31)};
    }
    // Fin Setters

    // Inicio Getters
    public int[] getFechaActual(){
        return this.fechaActual;
    }
    public int getDia(){
        return this.dia;
    }

    public int getMes(){
        return this.mes;
    }

    public String getMesEscrito(){
        return this.meses[getMes()-1].getMes();
    }

    public int getAnyo(){
        return this.anyo;
    }

    public int[][][] getSemanasMes(){
        return this.semanasMes;
    }
    // Fin Getters

    // Inicio Funciones Auxiliares
    public int[] sigDia (int dia, int mes, int anyo){
        Calendar calendar = Calendar.getInstance();
        calendar.set(anyo, mes, dia);

        int ultimoDiaMes;
        if (mes == 0){
            ultimoDiaMes = this.meses[11].getDias();
        } else {
            ultimoDiaMes = this.meses[mes-1].getDias();
        }

        if (dia == ultimoDiaMes){
            if (mes == 12){
                return new int[]{1, 1, ++anyo};
            } else {
                return new int[]{1, ++mes, anyo};
            }
        } else {
            return new int[]{++dia, mes, anyo};
        }
    }

    public int[] antDia (int dia, int mes, int anyo){
        Calendar calendar = Calendar.getInstance();
        calendar.set(anyo, mes, dia);

        if (dia == 1){
            if (mes == 1){
                return new int[]{31, 12, (anyo - 1)};
            } else {
                return new int[]{this.meses[(mes - 2)].getDias(), (mes - 1), anyo};
            }
        } else {
            return new int[]{(dia - 1), mes, anyo};
        }
    }
}
