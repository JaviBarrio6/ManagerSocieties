package com.Facturacion;

import com.Agenda.Empleado.Entidad.Empleado;

import java.util.LinkedHashMap;

public class Gastos {

    public LinkedHashMap<String, Gasto> gastos = new LinkedHashMap<>();

    Empleado empleado04 = new Empleado("EMP0004","Javier", "Barrio", "53852636E", "608844077", "barriomartinjavier@gmail.com", "Av. Guadarama 21, S.S. de los Reyes", null, "CEO", "02/01/2013", "28/19564596/31");

    Gasto gasto = new Gasto(empleado04, "Combustible", "17/03/2023", 100);

    public Gastos (){
        this.gastos.put(gasto.getRef(), gasto);
    }

}
