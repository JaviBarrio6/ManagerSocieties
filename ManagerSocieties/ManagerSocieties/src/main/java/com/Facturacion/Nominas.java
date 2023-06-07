package com.Facturacion;

import com.Agenda.Empleado;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;

@Component
public class Nominas {

    public LinkedHashMap<String, Nomina> nominas = new LinkedHashMap<>();

    Empleado empleado04 = new Empleado("EMP0004","Javier", "Barrio", "53852636E", "608844077", "barriomartinjavier@gmail.com", "Av. Guadarama 21, S.S. de los Reyes", null, "CEO", "02/01/2013", "28/19564596/31");

    Nomina nomina01 = new Nomina(empleado04, "01/06/2023", 30, 44.49, 54.79, 56.25, 1.67, 5.65, 3.71, 4.80, 0.1, 1.55);

    public Nominas () {
        this.nominas.put(nomina01.getRef(), nomina01);
    }

}
