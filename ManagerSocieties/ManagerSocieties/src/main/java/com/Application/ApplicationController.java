package com.Application;

import com.Agenda.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ApplicationController {

    Clientes clientes = new Clientes();

    ModelAndView model = new ModelAndView();
    @RequestMapping("/")
    public ModelAndView login() {
        model.setViewName("pages-login.html");
        return model;
    }

    @RequestMapping("/agenda-clientes")
    public ModelAndView agendaClientes() {
        model.setViewName("agenda-clientes.html");
        model.addObject("clientes", clientes.clientes);
        model.addObject("numClientes", clientes.getClientesEmpresas()[0]);
        model.addObject("numEmpresas", clientes.getClientesEmpresas()[1]);
        return model;
    }

    @PostMapping("/anyadirCliente")
    public ModelAndView anayadirCliente(String nombre, String apellidos, String id, String telefono, String correo, String dir, boolean premium) {
        Cliente cliente = new Cliente(nombre, apellidos, id, telefono, correo, dir, premium);
        clientes.clientes.add(cliente);

        return agendaClientes();
    }

    @PostMapping("/borrarCliente")
    public ModelAndView borrarCliente(String ref) {
        clientes.clientes.remove(clientes.findByRef(ref));

        return agendaClientes();
    }

    @PostMapping("/dameCliente")
    public ModelAndView dameCliente(String ref) {
        model.addObject("cliente", clientes.findByRef(ref));

        return agendaClientes();
    }

    @PostMapping("/editarCliente")
    public ModelAndView editarCliente(String ref, String nombre, String apellidos, String id, String telefono, String correo, String dir, boolean premium) {
        clientes.editarCliente(ref, nombre, apellidos, id, telefono, correo, dir, premium);

        return agendaClientes();
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
