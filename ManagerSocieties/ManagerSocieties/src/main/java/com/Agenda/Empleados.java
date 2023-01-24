package com.Agenda;

import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;

@Component
public class Empleados {
    public LinkedHashMap <String, Empleado> empleados = new LinkedHashMap<>();

    Empleado empleado01 = new Empleado("EMP0001", "Javier", "Ramirez", "53852030Z", "674851283", "juan@gmail.com", "Av. Guadarama 21, S.S. de los Reyes", "jramirez", "RRHH", 2);
    Empleado empleado02 = new Empleado("EMP0002","Paco", "López", "53852030Z", "674851283", "plopez@gmail.com", "Av. Guadarama 21, S.S. de los Reyes", "plopez", "Repartidor", 0);
    Empleado empleado03 = new Empleado("EMP0003","Manuela", "Gracia", "53852030Z", "674851283", "mgracia@gmail.com", "Av. Guadarama 21, S.S. de los Reyes", "mgracia", "RRHH", 9);
    Empleado empleado04 = new Empleado("EMP0004","Javier", "Barrio", "53852636E", "608844077", "barriomartinjavier@gmail.com", "Av. Guadarama 21, S.S. de los Reyes", "jbarrio", "CEO", 10);
    Empleado empleado05 = new Empleado("EMP0005","María del Mar", "Martín", "53852636E", "607849292", "superlux@superlux.com", "C. Enriq Prat de la Riba", "mmar", "CEO", 30);

    public Empleados () {
        this.empleados.put(empleado01.getRef(), empleado01);
        this.empleados.put(empleado02.getRef(), empleado02);
        this.empleados.put(empleado03.getRef(), empleado03);
        this.empleados.put(empleado04.getRef(), empleado04);
        this.empleados.put(empleado05.getRef(), empleado05);
    }

    public void editarEmpleado (String ref, String nombre, String apellidos, String id, String telefono, String email, String direccion, String usuario, String puesto, int antiguedad){
        this.empleados.put(ref, new Empleado(ref, nombre, apellidos, id, telefono, email, direccion, usuario, puesto, antiguedad));
    }

}
