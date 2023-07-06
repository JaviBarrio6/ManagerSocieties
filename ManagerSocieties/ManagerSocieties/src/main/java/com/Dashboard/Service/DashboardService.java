package com.Dashboard.Service;

import com.Agenda.Empleado.Entidad.Empleado;
import com.Facturacion.Factura.Entidad.Factura;
import com.Facturacion.Nomina.Entidad.Nomina;
import com.Tareas.Entidad.Tarea;
import com.Usuario.Entidad.Usuario;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.text.DecimalFormat;
import java.util.List;

@Service
public class DashboardService {

    ModelAndView dashboardModel = new ModelAndView();
    DecimalFormat df = new DecimalFormat("###.##");

    public ModelAndView dashboard (Usuario user, int numVentas, String periodoVentas, double ingresos,
                                   String periodoIngresos, int clientes, List<Factura> facturas, String[][] masVendidos,
                                   List<Tarea> tareasHoy, String[][] actividades, List<Nomina> nominas,
                                   List<Empleado> empleados){

        dashboardModel.addObject("usuario", user);
        dashboardModel.addObject("numVentas", numVentas);
        dashboardModel.addObject("periodoVentas", periodoVentas);
        dashboardModel.addObject("ingresos", df.format(ingresos));
        dashboardModel.addObject("periodoIngresos", periodoIngresos);
        dashboardModel.addObject("clientes", clientes);
        dashboardModel.addObject("facturas", facturas);
        dashboardModel.addObject("masVendidos", masVendidos);
        dashboardModel.addObject("tareasHoy", tareasHoy);
        dashboardModel.addObject("actividades", actividades);
        dashboardModel.addObject("nominas", nominas);
        dashboardModel.addObject("empleados", empleados);
        dashboardModel.setViewName("index.html");
        return dashboardModel;
    }
}
