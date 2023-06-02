package com.Controllers;

import com.Agenda.*;
import com.Usuario.Usuario;
import org.springframework.web.servlet.ModelAndView;

public class AgendaController {

    Clientes clientes = new Clientes();
    Empleados empleados = new Empleados();
    Empresas empresas = new Empresas();
    Proveedores proveedores = new Proveedores();
    ModelAndView agendaModel = new ModelAndView();

    public ModelAndView agendaClientes(Usuario user) {
        agendaModel.setViewName("agenda-clientes.html");
        agendaModel.addObject("clientes", clientes.clientes.values());
        agendaModel.addObject("numClientes", clientes.getClientesEmpresas()[0]);
        agendaModel.addObject("numEmpresas", clientes.getClientesEmpresas()[1]);
        agendaModel.addObject("usuario", user);
        return agendaModel;
    }

    public ModelAndView anyadirCliente(Usuario user, String nombre, String apellidos, String id, String telefono, String correo, String dir, boolean premium) {
        Cliente cliente = new Cliente(nombre, apellidos, id, telefono, correo, dir, premium);
        clientes.clientes.put(cliente.getRef(), cliente);

        return agendaClientes(user);
    }

    public ModelAndView borrarCliente(Usuario user, String ref) {
        clientes.clientes.remove(ref);

        return agendaClientes(user);
    }

    public ModelAndView editarCliente(Usuario user, String ref, String nombre, String apellidos, String id, String telefono, String correo, String dir, boolean premium) {
        clientes.editarCliente(ref, nombre, apellidos, id, telefono, correo, dir, premium);

        return agendaClientes(user);
    }

    public Cliente dameCliente (String ref){
        return clientes.clientes.get(ref);
    }

    public ModelAndView agendaEmpleados(Usuario user) {
        agendaModel.setViewName("agenda-empleados.html");
        agendaModel.addObject("empleados", empleados.empleados.values());
        agendaModel.addObject("numEmpleados", empleados.empleados.size());
        agendaModel.addObject("usuario", user);
        return agendaModel;
    }

    public ModelAndView anyadirEmpleado(Usuario user, String nombre, String apellidos, String usuario, String id, String telefono, String email, String direccion, String antiguedad, String numSS, String puesto) {
        Empleado empleado = new Empleado(nombre, apellidos, id, telefono, email, direccion, usuario, puesto, antiguedad, numSS);
        empleados.empleados.put(empleado.getRef(), empleado);

        return agendaEmpleados(user);
    }

    public ModelAndView borrarEmpleado(Usuario user, String ref) {
        empleados.empleados.remove(ref);

        return agendaEmpleados(user);
    }

    public ModelAndView editarEmpleado(Usuario user, String ref, String nombre, String apellidos, String usuario, String id, String telefono, String email, String direccion, String antiguedad, String numSS, String puesto) {
        empleados.editarEmpleado(ref, nombre, apellidos, id, telefono, email, direccion, usuario, puesto, antiguedad, numSS);

        return agendaEmpleados(user);
    }

    public Empleado dameEmpleado (String ref){
        return empleados.empleados.get(ref);
    }

    // Fin Empleados

    // Inicio Empresas Subcontratadas

    public ModelAndView agendaEmpresasSubcontratadas(Usuario user) {
        agendaModel.setViewName("agenda-empresassubcontratadas.html");
        agendaModel.addObject("empresas", empresas.empresas.values());
        agendaModel.addObject("numEmpresas", empresas.empresas.values().size());
        return agendaModel;
    }

    public ModelAndView anyadirEmpresa(Usuario user, String nombre, String tipo, String id, String telefono, String email, String direccion) {
        Empresa empresa = new Empresa(nombre, tipo, id, telefono, email, direccion);
        empresas.empresas.put(empresa.getRef(), empresa);

        return agendaEmpresasSubcontratadas(user);
    }

    public ModelAndView borrarEmpresa(Usuario user, String ref) {
        empresas.empresas.remove(ref);

        return agendaEmpresasSubcontratadas(user);
    }

    public ModelAndView editarEmpresa(Usuario user, String ref, String nombre, String tipo, String id, String telefono, String email, String direccion) {
        empresas.editarEmpresa(ref, nombre, tipo, id, telefono, email, direccion);

        return agendaEmpresasSubcontratadas(user);
    }

    public ModelAndView agendaProveedores(Usuario user) {
        agendaModel.setViewName("agenda-proveedores.html");
        agendaModel.addObject("proveedores", proveedores.proveedores.values());
        agendaModel.addObject("numProveedores", proveedores.proveedores.values().size());
        agendaModel.addObject("usario", user);
        return agendaModel;
    }

    public ModelAndView anyadirProveedor(Usuario user, String nombre, String tipo, String id, String telefono, String email, String direccion) {
        Proveedor proveedor = new Proveedor(nombre, tipo, id, telefono, email, direccion);
        proveedores.proveedores.put(proveedor.getRef(), proveedor);

        return agendaProveedores(user);
    }

    public ModelAndView borrarProveedor(Usuario user, String ref) {
        proveedores.proveedores.remove(ref);

        return agendaProveedores(user);
    }

    public ModelAndView editarProveedor(Usuario user, String ref, String nombre, String tipo, String id, String telefono, String email, String direccion) {
        proveedores.editarProveedor(ref, nombre, tipo, id, telefono, email, direccion);

        return agendaProveedores(user);
    }

    // Inicio Getters

    public Clientes getClientes() {
        return this.clientes;
    }

    public Empleados getEmpleados() {
        return this.empleados;
    }

    public Empresas getEmpresas() {
        return this.empresas;
    }

    public Proveedores getProveedores() {
        return this.proveedores;
    }

    // Fin Getters

}
