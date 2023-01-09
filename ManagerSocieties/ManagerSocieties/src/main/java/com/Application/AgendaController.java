package com.Application;

import com.Agenda.*;
import org.springframework.web.servlet.ModelAndView;

public class AgendaController {

    Clientes clientes = new Clientes();
    Empleados empleados = new Empleados();
    Empresas empresas = new Empresas();
    Proveedores proveedores = new Proveedores();
    ModelAndView agendaModel = new ModelAndView();

    public ModelAndView agendaClientes() {
        agendaModel.setViewName("agenda-clientes.html");
        agendaModel.addObject("clientes", clientes.clientes.values());
        agendaModel.addObject("numClientes", clientes.getClientesEmpresas()[0]);
        agendaModel.addObject("numEmpresas", clientes.getClientesEmpresas()[1]);
        return agendaModel;
    }

    public ModelAndView anyadirCliente(String nombre, String apellidos, String id, String telefono, String correo, String dir, boolean premium) {
        Cliente cliente = new Cliente(nombre, apellidos, id, telefono, correo, dir, premium);
        clientes.clientes.put(cliente.getRef(), cliente);

        return agendaClientes();
    }

    public ModelAndView borrarCliente(String ref) {
        clientes.clientes.remove(ref);

        return agendaClientes();
    }

    public ModelAndView editarCliente(String ref, String nombre, String apellidos, String id, String telefono, String correo, String dir, boolean premium) {
        clientes.editarCliente(ref, nombre, apellidos, id, telefono, correo, dir, premium);

        return agendaClientes();
    }

    public ModelAndView agendaEmpleados() {
        agendaModel.setViewName("agenda-empleados.html");
        agendaModel.addObject("empleados", empleados.empleados.values());
        agendaModel.addObject("numEmpleados", empleados.empleados.size());
        return agendaModel;
    }

    public ModelAndView anyadirEmpleado(String nombre, String apellidos, String usuario, String id, String telefono, String email, String direccion, String antiguedad, String puesto) {
        Empleado empleado = new Empleado(nombre, apellidos, id, telefono, email, direccion, usuario, puesto, Integer.parseInt(antiguedad));
        empleados.empleados.put(empleado.getRef(), empleado);

        return agendaEmpleados();
    }

    public ModelAndView borrarEmpleado(String ref) {
        empleados.empleados.remove(ref);

        return agendaEmpleados();
    }

    public ModelAndView editarEmpleado(String ref, String nombre, String apellidos, String usuario, String id, String telefono, String email, String direccion, String antiguedad, String puesto) {
        empleados.editarEmpleado(ref, nombre, apellidos, id, telefono, email, direccion, usuario, puesto, Integer.parseInt(antiguedad));

        return agendaEmpleados();
    }

    // Fin Empleados

    // Inicio Empresas Subcontratadas

    public ModelAndView agendaEmpresasSubcontratadas() {
        agendaModel.setViewName("agenda-empresassubcontratadas.html");
        agendaModel.addObject("empresas", empresas.empresas.values());
        agendaModel.addObject("numEmpresas", empresas.empresas.values().size());
        return agendaModel;
    }

    public ModelAndView anyadirEmpresa(String nombre, String tipo, String id, String telefono, String email, String direccion) {
        Empresa empresa = new Empresa(nombre, tipo, id, telefono, email, direccion);
        empresas.empresas.put(empresa.getRef(), empresa);

        return agendaEmpresasSubcontratadas();
    }

    public ModelAndView borrarEmpresa(String ref) {
        empresas.empresas.remove(ref);

        return agendaEmpresasSubcontratadas();
    }

    public ModelAndView editarEmpresa(String ref, String nombre, String tipo, String id, String telefono, String email, String direccion) {
        empresas.editarEmpresa(ref, nombre, tipo, id, telefono, email, direccion);

        return agendaEmpresasSubcontratadas();
    }

    public ModelAndView agendaProveedores() {
        agendaModel.setViewName("agenda-proveedores.html");
        agendaModel.addObject("proveedores", proveedores.proveedores.values());
        agendaModel.addObject("numProveedores", proveedores.proveedores.values().size());
        return agendaModel;
    }

    public ModelAndView anyadirProveedor(String nombre, String tipo, String id, String telefono, String email, String direccion) {
        Proveedor proveedor = new Proveedor(nombre, tipo, id, telefono, email, direccion);
        proveedores.proveedores.put(proveedor.getRef(), proveedor);

        return agendaProveedores();
    }

    public ModelAndView borrarProveedor(String ref) {
        proveedores.proveedores.remove(ref);

        return agendaProveedores();
    }

    public ModelAndView editarProveedor(String ref, String nombre, String tipo, String id, String telefono, String email, String direccion) {
        proveedores.editarProveedor(ref, nombre, tipo, id, telefono, email, direccion);

        return agendaProveedores();
    }
}
