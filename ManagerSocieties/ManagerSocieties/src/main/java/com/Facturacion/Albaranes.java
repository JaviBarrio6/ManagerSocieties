package com.Facturacion;

import com.Agenda.Cliente.Entidad.Cliente;
import com.Inventario.Producto.Entidad.Producto;
import com.Tareas.Entidad.Tarea;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Albaranes {

    public LinkedHashMap<String, Albaran> albaranes = new LinkedHashMap<>();

    Cliente cliente01 = new Cliente("Juan José", "Rodríguez", "53852030Z", "674851283",
            "juan@gmail.com", "Av. Guadarama 21, S.S. de los Reyes", true, 2);
    Tarea tarea01 = new Tarea(cliente01, null, "2023-02-01", "", "11:00", 1200, 120, "", 0, null, null, null, null, null, 5);

    ArrayList<Tarea> tareas = new ArrayList<>();

    public Albaranes () {
        tareas.add(tarea01);
        Albaran albaran = new Albaran(cliente01, "2023-02-01", null, tareas, 21);
        this.albaranes.put(albaran.getRef(), albaran);
    }

    public void editarAlbaran (String ref, Cliente cliente, String fecha, HashMap<Producto, Integer> productos, ArrayList<Tarea> tareas, double IVA) {
        this.albaranes.put(ref, new Albaran(ref, cliente, fecha, productos, tareas, IVA));
    }

}
