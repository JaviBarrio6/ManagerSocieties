package com.Agenda;

import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;

@Component
public class Empleados {
    public LinkedHashMap <String, Empleado> empleados = new LinkedHashMap<>();

    Empleado empleado01 = new Empleado("Javier", "Ramirez", "53852030Z", "674851283", "juan@gmail.com", "Av. Guadarama 21, S.S. de los Reyes", "jramirez", "RRHH", 2);
    Empleado empleado02 = new Empleado("Paco", "López", "53852030Z", "674851283", "plopez@gmail.com", "Av. Guadarama 21, S.S. de los Reyes", "plopez", "Repartidor", 0);
    Empleado empleado03 = new Empleado("Manuela", "Gracia", "53852030Z", "674851283", "mgracia@gmail.com", "Av. Guadarama 21, S.S. de los Reyes", "mgracia", "CEO", 10);

    public Empleados () {
        this.empleados.put(empleado01.getRef(), empleado01);
        this.empleados.put(empleado02.getRef(), empleado02);
        this.empleados.put(empleado03.getRef(), empleado03);
    }

    public void editarEmpleado (String ref, String nombre, String apellidos, String id, String telefono, String email, String direccion, String usuario, String puesto, int antiguedad){
        this.empleados.put(ref, new Empleado(ref, nombre, apellidos, id, telefono, email, direccion, usuario, puesto, antiguedad));
    }

}
