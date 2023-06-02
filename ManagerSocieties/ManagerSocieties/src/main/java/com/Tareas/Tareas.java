package com.Tareas;

import com.Agenda.Cliente;
import java.util.LinkedHashMap;

public class Tareas {
    public LinkedHashMap <String, Tarea> tareas = new LinkedHashMap<>();


    Cliente cliente01 = new Cliente("Juan José", "Rodríguez", "53852030Z", "674851283",
            "juan@gmail.com", "Av. Guadarama 21, S.S. de los Reyes", true);
    Tarea tarea01 = new Tarea(cliente01, new String[]{"Paco López", "Manuela Gracia"}, "2023-02-01", null, "11:00", 1200, 120, "", 0, new String[]{});
    Tarea tarea02 = new Tarea(cliente01, new String[]{"Paco López", "Manuela Gracia"}, "2023-11-10", "2023-11-12", "09:00", 500, 100, "Hola", 1, new String[]{});

    public Tareas() {
        this.tareas.put(tarea01.getRef(), tarea01);
        this.tareas.put(tarea02.getRef(), tarea02);
    }

    public void editarTarea (String ref, Cliente cliente, String[] empleados, String fechaInicio, String fechaFin, String hora, double precio, double gastoExtra, String info, int estado, String[] inventario){
        this.tareas.put(ref, new Tarea(ref, cliente, empleados, fechaInicio, fechaFin, hora, precio, gastoExtra, info, estado, inventario));
    }
}
