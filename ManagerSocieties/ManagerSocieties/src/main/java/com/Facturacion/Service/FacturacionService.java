package com.Facturacion.Service;

import com.Agenda.Cliente.Entidad.Cliente;
import com.Agenda.Empleado.Entidad.Empleado;
import com.Facturacion.Albaran.Entidad.Albaran;
import com.Facturacion.Factura.Entidad.Factura;
import com.Facturacion.GastosExternos.Entidad.Gasto;
import com.Facturacion.Nomina.Entidad.Nomina;
import com.Inventario.Producto.Entidad.Producto;
import com.Inventario.Producto.Repository.ProductosRepository;
import com.Tareas.Entidad.Tarea;
import com.Tareas.Repository.TareasRepository;
import com.Usuario.Entidad.Usuario;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FacturacionService {
    ModelAndView facturacionModel = new ModelAndView();

    // Inicio Albaranes
    public ModelAndView facturacionAlbaranes (Usuario user, List<Albaran> albaranes, List<Producto> productos,
                                              List<Tarea> tareas, List<Cliente> clientes){
        facturacionModel.setViewName("facturacion-albaranes.html");
        facturacionModel.addObject("albaranes", albaranes);
        facturacionModel.addObject("numAlbaranes", albaranes.size());
        facturacionModel.addObject("productos", productos);
        facturacionModel.addObject("tareas", tareas);
        facturacionModel.addObject("clientes", clientes);
        facturacionModel.addObject("usuario", user);
        return facturacionModel;
    }

    // Fin Albaranes

    // Inicio Facturas

    public ModelAndView facturacionFacturas (Usuario user, List<Factura> facturas, List<Producto> productos,
                                             List<Tarea> tareas, List<Cliente> clientes){
        facturacionModel.setViewName("facturacion-facturas.html");
        facturacionModel.addObject("facturas", facturas);
        facturacionModel.addObject("numFacturas", facturas.size());
        facturacionModel.addObject("productos", productos);
        facturacionModel.addObject("tareas", tareas);
        facturacionModel.addObject("clientes", clientes);
        facturacionModel.addObject("usuario", user);
        return facturacionModel;
    }

    // Fin Facturas


    // Inicio Gastos Externos
    public ModelAndView facturacionGastos (Usuario user, List<Gasto> gastos, List<Empleado> empleados){
        facturacionModel.setViewName("facturacion-gastos.html");
        facturacionModel.addObject("gastos", gastos);
        facturacionModel.addObject("numGastos", gastos.size());
        facturacionModel.addObject("empleados", empleados);
        facturacionModel.addObject("usuario", user);
        return facturacionModel;
    }

    // Fin Gastos Externos

    // Inicio Nominas

    public ModelAndView facturacionNominas (Usuario user, List<Nomina> nominas, List<Empleado> empleados){
        facturacionModel.setViewName("facturacion-nominas.html");
        facturacionModel.addObject("nominas", nominas);
        facturacionModel.addObject("numNominas", nominas.size());
        facturacionModel.addObject("empleados", empleados);
        facturacionModel.addObject("usuario", user);
        return facturacionModel;
    }
    // Fin Nominas
}
