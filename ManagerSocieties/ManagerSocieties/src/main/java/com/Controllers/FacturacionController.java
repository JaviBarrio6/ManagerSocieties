package com.Controllers;

import com.Agenda.Cliente.Entidad.Cliente;
import com.Agenda.Empleado.Entidad.Empleado;
import com.Facturacion.*;
import com.Inventario.Producto.Entidad.Producto;
import com.Inventario.Producto.Repository.ProductosRepository;
import com.Tareas.Entidad.Tarea;
import com.Tareas.Repository.TareasRepository;
import com.Usuario.Entidad.Usuario;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FacturacionController {

    Albaranes albaranes = new Albaranes();
    Gastos gastos = new Gastos();
    Nominas nominas = new Nominas();

    private ProductosRepository productosRepository;

    private TareasRepository tareasRepository;
    ModelAndView facturacionModel = new ModelAndView();

    // Inicio Albaranes
    public ModelAndView facturacionAlbaranes (Usuario user){
        facturacionModel.setViewName("facturacion-albaranes.html");
        facturacionModel.addObject("albaranes", albaranes.albaranes.values());
        facturacionModel.addObject("numAlbaranes", albaranes.albaranes.values().size());
        facturacionModel.addObject("productos", productosRepository.findAll());
        facturacionModel.addObject("tareas", tareasRepository.findAll());
        //facturacionModel.addObject("clientes", clientes.clientes.values());
        facturacionModel.addObject("usuario", user);
        return facturacionModel;
    }

    public ModelAndView anyadirAlbaran (Usuario user, Cliente cliente, String fecha, HashMap<Producto, Integer> productos, List<Tarea> tareas, double IVA) {
        Albaran albaran = new Albaran(cliente, fecha, productos, tareas, IVA);

        albaranes.albaranes.put(albaran.getRef(), albaran);
        return facturacionAlbaranes(user);
    }

    public ModelAndView editarAlbaran (Usuario user, String ref, Cliente cliente, String fecha, HashMap<Producto, Integer> productos, ArrayList<Tarea> tareas, double IVA) {
        albaranes.editarAlbaran(ref, cliente, fecha, productos, tareas, IVA);

        return facturacionAlbaranes(user);
    }

    public ModelAndView borrarAlbaran (Usuario user, String ref){
        albaranes.albaranes.remove(ref);

        return facturacionGastos(user, null);
    }

    // Fin Gastos Externos


    // Inicio Gastos Externos
    public ModelAndView facturacionGastos (Usuario user, List<Empleado> empleados){
        facturacionModel.setViewName("facturacion-gastos.html");
        facturacionModel.addObject("gastos", gastos.gastos.values());
        facturacionModel.addObject("numGastos", gastos.gastos.values().size());
        facturacionModel.addObject("empleados", empleados);
        facturacionModel.addObject("usuario", user);
        return facturacionModel;
    }

    public ModelAndView anyadirGasto (Usuario user, Empleado empleado, String motivo, String fecha, double gasto) {
        Gasto gastoAux = new Gasto(empleado, motivo, fecha, gasto);

        gastos.gastos.put(gastoAux.getRef(), gastoAux);
        return facturacionGastos(user, null);
    }

    public ModelAndView borrarGasto (Usuario user, String ref){
        gastos.gastos.remove(ref);

        return facturacionGastos(user, null);
    }

    // Fin Gastos Externos

    // Inicio Nominas

    public ModelAndView facturacionNominas (Usuario user, List<Empleado> empleados){
        facturacionModel.setViewName("facturacion-nominas.html");
        facturacionModel.addObject("nominas", nominas.nominas.values());
        facturacionModel.addObject("numNominas", nominas.nominas.values().size());
        facturacionModel.addObject("empleados", empleados);
        facturacionModel.addObject("usuario", user);
        return facturacionModel;
    }

    public ModelAndView anyadirNomina (Usuario user, Empleado empleado, String fecha, int dias, double salarioConvenio, double prestacionAccidente,
                                       double complementoSalarial, double teletrabajo, double productividad, double pagasExtra,
                                       double contingencias, double formacionP, double desempleo){

        Nomina nomina = new Nomina(empleado, fecha, dias, salarioConvenio, prestacionAccidente, complementoSalarial,
                                    teletrabajo, productividad, pagasExtra, contingencias, formacionP, desempleo);
        nominas.nominas.put(nomina.getRef(), nomina);

        return facturacionNominas(user, null);
    }

    public ModelAndView borrarNomina (Usuario user, String ref){
        nominas.nominas.remove(ref);

        return facturacionNominas(user, null);
    }
    // Fin Nominas
}
