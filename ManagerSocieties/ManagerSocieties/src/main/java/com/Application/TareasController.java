package com.Application;

import com.Agenda.Cliente;
import com.Agenda.Clientes;
import com.Agenda.Empleado;
import com.Agenda.Empleados;
import com.Inventario.*;
import com.Tareas.Tarea;
import com.Tareas.Tareas;
import com.Usuario.Usuario;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;

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

    public ModelAndView anyadirTarea (Usuario user, String cliente, String[] empleados, String fechaInicio, String fechaFin, String hora, double gastoExtra, String info, int estado, String[] inventario){

        Tarea tarea = new Tarea(clientes.clientes.get(cliente), empleados, fechaInicio, fechaFin, hora, gastoExtra, info, estado, inventario);
        tareas.tareas.put(tarea.getRef(), tarea);

        return tareas(user);
    }

    public ModelAndView borrarTarea (Usuario user, String ref){
        tareas.tareas.remove(ref);

        return tareas(user);
    }

    public ModelAndView editarTarea (Usuario user, String ref, String cliente, String[] empleados, String fechaInicio, String fechaFin, String hora, double gastoExtra, String info, int estado, String[] inventario){
        tareas.editarTarea(ref, clientes.clientes.get(cliente), empleados, fechaInicio, fechaFin, hora, gastoExtra, info, estado, inventario);

        return tareas(user);
    }
}
