package com.Controllers;

import com.Agenda.Cliente;
import com.Agenda.Empleado;
import com.Agenda.Empleados;
import com.Facturacion.*;
import com.Inventario.Producto;
import com.Inventario.Productos;
import com.Tareas.Tarea;
import com.Tareas.Tareas;
import com.Usuario.Usuario;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

public class FacturacionController {

    Albaranes albaranes = new Albaranes();
    Gastos gastos = new Gastos();
    Nominas nominas = new Nominas();
    Productos productos = new Productos();
    Tareas tareas = new Tareas();
    Empleados empleados = new Empleados();
    ModelAndView facturacionModel = new ModelAndView();

    // Inicio Albaranes
    public ModelAndView facturacionAlbaranes (Usuario user){
        facturacionModel.setViewName("facturacion-albaranes.html");
        facturacionModel.addObject("albaranes", albaranes.albaranes.values());
        facturacionModel.addObject("numAlbaranes", albaranes.albaranes.values().size());
        facturacionModel.addObject("productos", productos.productos.values());
        facturacionModel.addObject("tareas", tareas.tareas.values());
        facturacionModel.addObject("usuario", user);
        return facturacionModel;
    }

    public ModelAndView anyadirAlbaran (Usuario user, Cliente cliente, String fecha, ArrayList<Producto> productos, ArrayList<Tarea> tareas, double IVA) {
        Albaran albaran = new Albaran(cliente, fecha, productos, tareas, IVA);

        albaranes.albaranes.put(albaran.getRef(), albaran);
        return facturacionGastos(user);
    }

    public ModelAndView editarAlbaran (Usuario user, String ref, Cliente cliente, String fecha, ArrayList<Producto> productos, ArrayList<Tarea> tareas, double IVA) {
        albaranes.editarAlbaran(ref, cliente, fecha, productos, tareas, IVA);

        return facturacionAlbaranes(user);
    }

    public ModelAndView borrarAlbaran (Usuario user, String ref){
        albaranes.albaranes.remove(ref);

        return facturacionGastos(user);
    }

    // Fin Gastos Externos


    // Inicio Gastos Externos
    public ModelAndView facturacionGastos (Usuario user){
        facturacionModel.setViewName("facturacion-gastos.html");
        facturacionModel.addObject("gastos", gastos.gastos.values());
        facturacionModel.addObject("numGastos", gastos.gastos.values().size());
        facturacionModel.addObject("empleados", empleados.empleados.values());
        facturacionModel.addObject("usuario", user);
        return facturacionModel;
    }

    public ModelAndView anyadirGasto (Usuario user, Empleado empleado, String motivo, String fecha, double gasto) {
        Gasto gastoAux = new Gasto(empleado, motivo, fecha, gasto);

        gastos.gastos.put(gastoAux.getRef(), gastoAux);
        return facturacionGastos(user);
    }

    public ModelAndView borrarGasto (Usuario user, String ref){
        gastos.gastos.remove(ref);

        return facturacionGastos(user);
    }

    // Fin Gastos Externos

    // Inicio Nominas

    public ModelAndView facturacionNominas (Usuario user){
        facturacionModel.setViewName("facturacion-nominas.html");
        facturacionModel.addObject("nominas", nominas.nominas.values());
        facturacionModel.addObject("numNominas", nominas.nominas.values().size());
        facturacionModel.addObject("empleados", empleados.empleados.values());
        facturacionModel.addObject("usuario", user);
        return facturacionModel;
    }

    public ModelAndView anyadirNomina (Usuario user, Empleado empleado, String fecha, int dias, double salarioConvenio, double prestacionAccidente,
                                       double complementoSalarial, double teletrabajo, double productividad, double pagasExtra,
                                       double contingencias, double formacionP, double desempleo){

        Nomina nomina = new Nomina(empleado, fecha, dias, salarioConvenio, prestacionAccidente, complementoSalarial,
                                    teletrabajo, productividad, pagasExtra, contingencias, formacionP, desempleo);
        nominas.nominas.put(nomina.getRef(), nomina);

        return facturacionNominas(user);
    }

    public ModelAndView borrarNomina (Usuario user, String ref){
        nominas.nominas.remove(ref);

        return facturacionNominas(user);
    }
    // Fin Nominas
}
