package com.Application;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ApplicationController {
    ModelAndView model = new ModelAndView();
    AgendaController agendaController = new AgendaController();
    @RequestMapping("/")
    public ModelAndView login() {
        model.setViewName("pages-login.html");
        return model;
    }

    // Inicio Agenda

        // Inicio Clientes

    @RequestMapping("/agenda-clientes")
    public ModelAndView agendaClientesModel() {
        return agendaController.agendaClientes();
    }

    @PostMapping("/anyadirCliente")
    public ModelAndView anayadirClienteModel(String nombre, String apellidos, String id, String telefono, String correo, String dir, boolean premium) {
        return agendaController.anayadirCliente(nombre, apellidos, id, telefono, correo, dir, premium);
    }

    @PostMapping("/borrarCliente")
    public ModelAndView borrarClienteModel(String ref) {
        return agendaController.borrarCliente(ref);
    }

    @PostMapping("/editarCliente")
    public ModelAndView editarClienteModel(String ref, String nombre, String apellidos, String id, String telefono, String correo, String dir, boolean premium) {
        return agendaController.editarCliente(ref, nombre, apellidos, id, telefono, correo, dir, premium);
    }

        // Fin Clientes

        // Inicio Empleados

    @RequestMapping("/agenda-empleados")
    public ModelAndView agendaEmpleadosModel() {
        return agendaController.agendaEmpleados();
    }

    @PostMapping("/anyadirEmpleado")
    public ModelAndView anayadirEmpleadoModel(String nombre, String apellidos, String usuario, String id, String telefono, String email, String direccion, String antiguedad, String puesto) {
        return agendaController.anayadirEmpleado(nombre, apellidos, usuario, id, telefono, email, direccion, antiguedad, puesto);
    }

    @PostMapping("/borrarEmpleado")
    public ModelAndView borrarEmpleadoModel(String ref) {
        return agendaController.borrarEmpleado(ref);
    }

    @PostMapping("/editarEmpleado")
    public ModelAndView editarEmpleadoModel(String ref, String nombre, String apellidos, String usuario, String id, String telefono, String email, String direccion, String antiguedad, String puesto) {
        return agendaController.editarEmpleado(ref, nombre, apellidos, usuario, id, telefono, email, direccion, antiguedad, puesto);
    }

    // Fin Empleados

    // Inicio Empresas Subcontratadas

    @RequestMapping("/agenda-empresassubcontratadas")
    public ModelAndView agendaEmpresasSubcontratadasModel() {
        return agendaController.agendaEmpresasSubcontratadas();
    }

    @PostMapping("/anyadirEmpresa")
    public ModelAndView anyadirEmpresaModel(String nombre, String tipo, String id, String telefono, String email, String direccion) {
        return agendaController.anyadirEmpresa(nombre, tipo, id, telefono, email, direccion);
    }

    @PostMapping("/borrarEmpresa")
    public ModelAndView borrarEmpresaModel(String ref) {
        return agendaController.borrarEmpresa(ref);
    }

    @PostMapping("/editarEmpresa")
    public ModelAndView editarEmpresaModel(String ref, String nombre, String tipo, String id, String telefono, String email, String direccion) {
        return agendaController.editarEmpresa(ref, nombre, tipo, id, telefono, email, direccion);
    }

    // Fin Empresas Subcontratadas

    // Inicio Proveedores

    @RequestMapping("/agenda-proveedores")
    public ModelAndView agendaProveedoresModel() {
        return agendaController.agendaProveedores();
    }

    @PostMapping("/anyadirProveedor")
    public ModelAndView anyadirProveedorModel(String nombre, String tipo, String id, String telefono, String email, String direccion) {
        return agendaController.anyadirProveedor(nombre, tipo, id, telefono, email, direccion);
    }

    @PostMapping("/borrarProveedor")
    public ModelAndView borrarProveedorModel(String ref) {
        return agendaController.borrarProveedor(ref);
    }

    @PostMapping("/editarProveedor")
    public ModelAndView editarProveedorModel(String ref, String nombre, String tipo, String id, String telefono, String email, String direccion) {
        return agendaController.editarProveedor(ref, nombre, tipo, id, telefono, email, direccion);
    }

    // Fin Proveedores

    // Fin Agenda

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
