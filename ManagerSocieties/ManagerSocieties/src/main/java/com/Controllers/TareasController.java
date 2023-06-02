package com.Controllers;

import com.Agenda.Clientes;
import com.Agenda.Empleados;
import com.Inventario.*;
import com.Tareas.Tarea;
import com.Tareas.Tareas;
import com.Usuario.Usuario;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

public class TareasController {

    Tareas tareas = new Tareas();
    Empleados empleadosAux = new Empleados();
    Clientes clientes = new Clientes();
    Herramientas herramientas = new Herramientas();
    Maquinas maquinas = new Maquinas();
    Materiales materiales = new Materiales();
    Productos productos = new Productos();
    Vehiculos vehiculos = new Vehiculos();
    ModelAndView tareasModel = new ModelAndView();

    public ModelAndView tareas(Usuario user){
        tareasModel.setViewName("tareas.html");
        tareasModel.addObject("tareas", tareas.tareas.values());
        tareasModel.addObject("clientes", clientes.clientes.values());
        tareasModel.addObject("empleados", empleadosAux.empleados.values());
        tareasModel.addObject("herramientas", herramientas.herramientas.values());
        tareasModel.addObject("maquinas", maquinas.maquinas.values());
        tareasModel.addObject("materiales", materiales.materiales.values());
        tareasModel.addObject("productos", productos.productos.values());
        tareasModel.addObject("vehiculos", vehiculos.vehiculos.values());
        tareasModel.addObject("numTareas", tareas.tareas.values().size());
        tareasModel.addObject("usuario", user);
        return tareasModel;
    }

    public ModelAndView anyadirTarea (Usuario user, Tarea tarea){
        tareas.tareas.put(tarea.getRef(), tarea);

        return tareas(user);
    }

    public ModelAndView borrarTarea (Usuario user, String ref){
        tareas.tareas.remove(ref);

        return tareas(user);
    }

    public ModelAndView editarTarea (Usuario user, String ref, String cliente, String[] empleados, String fechaInicio, String fechaFin, String hora, double precio, double gastoExtra, String info, int estado, String[] inventario){
        tareas.editarTarea(ref, clientes.clientes.get(cliente), empleados, fechaInicio, fechaFin, hora, precio, gastoExtra, info, estado, inventario);

        return tareas(user);
    }

    // Funciones

    public ArrayList<Tarea> dameTareas (String[] refs){
        ArrayList<Tarea> tareasAux = new ArrayList<>();

        for (int i = 0; i < refs.length; i++) {
            for (Tarea tarea : tareasAux) {
                if (refs[i].equals(tarea.getRef())){
                    tareasAux.add(tarea);
                }
            }
        }

        return tareasAux;
    }

}
