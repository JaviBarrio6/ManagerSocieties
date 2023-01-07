package com.Application;

import com.Agenda.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ApplicationController {

    Clientes clientes = new Clientes();
    Empleados empleados = new Empleados();
    Empresas empresas = new Empresas();
    Proveedores proveedores = new Proveedores();

    ModelAndView model = new ModelAndView();
    @RequestMapping("/")
    public ModelAndView login() {
        model.setViewName("pages-login.html");
        return model;
    }

    // Inicio Agenda

    // Inicio Clientes

    @RequestMapping("/agenda-clientes")
    public ModelAndView agendaClientes() {
        model.setViewName("agenda-clientes.html");
        model.addObject("clientes", clientes.clientes.values());
        model.addObject("numClientes", clientes.getClientesEmpresas()[0]);
        model.addObject("numEmpresas", clientes.getClientesEmpresas()[1]);
        return model;
    }

    @PostMapping("/anyadirCliente")
    public ModelAndView anayadirCliente(String nombre, String apellidos, String id, String telefono, String correo, String dir, boolean premium) {
        Cliente cliente = new Cliente(nombre, apellidos, id, telefono, correo, dir, premium);
        clientes.clientes.put(cliente.getRef(), cliente);

        return agendaClientes();
    }

    @PostMapping("/borrarCliente")
    public ModelAndView borrarCliente(String ref) {
        clientes.clientes.remove(ref);

        return agendaClientes();
    }

    @PostMapping("/editarCliente")
    public ModelAndView editarCliente(String ref, String nombre, String apellidos, String id, String telefono, String correo, String dir, boolean premium) {
        clientes.editarCliente(ref, nombre, apellidos, id, telefono, correo, dir, premium);

        return agendaClientes();
    }

    // Fin Clientes

    // Inicio Empleados

    @RequestMapping("/agenda-empleados")
    public ModelAndView agendaEmpleados() {
        model.setViewName("agenda-empleados.html");
        model.addObject("empleados", empleados.empleados.values());
        model.addObject("numEmpleados", empleados.empleados.size());
        return model;
    }

    @PostMapping("/anyadirEmpleado")
    public ModelAndView anayadirEmpleado(String nombre, String apellidos, String usuario, String id, String telefono, String email, String direccion, String antiguedad, String puesto) {
        Empleado empleado = new Empleado(nombre, apellidos, id, telefono, email, direccion, usuario, puesto, Integer.parseInt(antiguedad));
        empleados.empleados.put(empleado.getRef(), empleado);

        return agendaEmpleados();
    }

    @PostMapping("/borrarEmpleado")
    public ModelAndView borrarEmpleado(String ref) {
        empleados.empleados.remove(ref);

        return agendaEmpleados();
    }

    @PostMapping("/editarEmpleado")
    public ModelAndView editarEmpleado(String ref, String nombre, String apellidos, String usuario, String id, String telefono, String email, String direccion, String antiguedad, String puesto) {
        empleados.editarEmpleado(ref, nombre, apellidos, id, telefono, email, direccion, usuario, puesto, Integer.parseInt(antiguedad));

        return agendaEmpleados();
    }

    // Fin Empleados

    // Inicio Empresas Subcontratadas

    @RequestMapping("/agenda-empresassubcontratadas")
    public ModelAndView agendaEmpresasSubcontratadas() {
        model.setViewName("agenda-empresassubcontratadas.html");
        model.addObject("empresas", empresas.empresas.values());
        model.addObject("numEmpresas", empresas.empresas.values().size());
        return model;
    }

    @PostMapping("/anyadirEmpresa")
    public ModelAndView anyadirEmpresa(String nombre, String tipo, String id, String telefono, String email, String direccion) {
        Empresa empresa = new Empresa(nombre, tipo, id, telefono, email, direccion);
        empresas.empresas.put(empresa.getRef(), empresa);

        return agendaEmpresasSubcontratadas();
    }

    @PostMapping("/borrarEmpresa")
    public ModelAndView borrarEmpresa(String ref) {
        empresas.empresas.remove(ref);

        return agendaEmpresasSubcontratadas();
    }

    @PostMapping("/editarEmpresa")
    public ModelAndView editarEmpresa(String ref, String nombre, String tipo, String id, String telefono, String email, String direccion) {
        empresas.editarEmpresa(ref, nombre, tipo, id, telefono, email, direccion);

        return agendaEmpresasSubcontratadas();
    }

    // Fin Empresas Subcontratadas

    // Inicio Proveedores

    @RequestMapping("/agenda-proveedores")
    public ModelAndView agendaProveedores() {
        model.setViewName("agenda-proveedores.html");
        model.addObject("proveedores", proveedores.proveedores.values());
        model.addObject("numProveedores", proveedores.proveedores.values().size());
        return model;
    }

    @PostMapping("/anyadirProveedor")
    public ModelAndView anyadirProveedor(String nombre, String tipo, String id, String telefono, String email, String direccion) {
        Proveedor proveedor = new Proveedor(nombre, tipo, id, telefono, email, direccion);
        proveedores.proveedores.put(proveedor.getRef(), proveedor);

        return agendaProveedores();
    }

    @PostMapping("/borrarProveedor")
    public ModelAndView borrarProveedor(String ref) {
        proveedores.proveedores.remove(ref);

        return agendaProveedores();
    }

    @PostMapping("/editarProveedor")
    public ModelAndView editarProveedor(String ref, String nombre, String tipo, String id, String telefono, String email, String direccion) {
        proveedores.editarProveedor(ref, nombre, tipo, id, telefono, email, direccion);

        return agendaProveedores();
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
