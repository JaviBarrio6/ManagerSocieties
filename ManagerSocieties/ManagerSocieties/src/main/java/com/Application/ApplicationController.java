package com.Application;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

@RestController
public class ApplicationController {

    ModelAndView model = new ModelAndView();
    @RequestMapping("/")
    public ModelAndView login() {
        model.setViewName("pages-login.html");
        return model;
    }

    @RequestMapping("/agenda-clientes")
    public ModelAndView agendaClientes() {
        model.setViewName("agenda-clientes.html");
        return model;
    }

    @RequestMapping("/agenda-empleados")
    public ModelAndView agendaEmpleados() {
        model.setViewName("agenda-empleados.html");
        return model;
    }

    @RequestMapping("/agenda-empresassubcontratadas")
    public ModelAndView agendaEmpresasSubcontratadas() {
        model.setViewName("agenda-empresassubcontratadas.html");
        return model;
    }

    @RequestMapping("/agenda-proveedores")
    public ModelAndView agendaProveedores() {
        model.setViewName("agenda-proveedores.html");
        return model;
    }

    @RequestMapping("/calendario")
    public ModelAndView calendario() {
        model.setViewName("calendario.html");
        return model;
    }

    @RequestMapping("/edit-users-profile")
    public ModelAndView editUsersProfile() {
        model.setViewName("edit-users-profile.html");
        return model;
    }

    @RequestMapping("/facturacion-albaranes")
    public ModelAndView facturacionAlbaranes() {
        model.setViewName("facturacion-albaranes.html");
        return model;
    }

    @RequestMapping("/facturacion-facturas")
    public ModelAndView facturacionFacturas() {
        model.setViewName("facturacion-facturas.html");
        return model;
    }

    @RequestMapping("/facturacion-gastos")
    public ModelAndView facturacionGastos() {
        model.setViewName("facturacion-gastos.html");
        return model;
    }

    @RequestMapping("/facturacion-nominas")
    public ModelAndView facturacionNominas() {
        model.setViewName("facturacion-nominas.html");
        return model;
    }

    @RequestMapping("/finanzas")
    public ModelAndView finanzas() {
        model.setViewName("finanzas.html");
        return model;
    }

    @RequestMapping("/index")
    public ModelAndView index() {
        model.setViewName("index.html");
        return model;
    }

    @RequestMapping("/inventario-herramientas")
    public ModelAndView inventarioHerramientas() {
        model.setViewName("inventario-herramientas.html");
        return model;
    }

    @RequestMapping("/inventario-maquinas")
    public ModelAndView inventarioMaquinas() {
        model.setViewName("inventario-maquinas.html");
        return model;
    }

    @RequestMapping("/inventario-materiales")
    public ModelAndView inventarioMateriales() {
        model.setViewName("inventario-materiales.html");
        return model;
    }

    @RequestMapping("/inventario-productos")
    public ModelAndView inventarioProductos() {
        model.setViewName("inventario-productos.html");
        return model;
    }

    @RequestMapping("/inventario-vehiculos")
    public ModelAndView inventarioVehiculos() {
        model.setViewName("inventario-vehiculos.html");
        return model;
    }

    @RequestMapping("/pages-register")
    public ModelAndView register() {
        model.setViewName("pages-register.html");
        return model;
    }

    @RequestMapping("/tareas")
    public ModelAndView tareas() {
        model.setViewName("tareas.html");
        return model;
    }

    @RequestMapping("/users-profile")
    public ModelAndView usersProfile() {
        model.setViewName("users-profile.html");
        return model;
    }
}
