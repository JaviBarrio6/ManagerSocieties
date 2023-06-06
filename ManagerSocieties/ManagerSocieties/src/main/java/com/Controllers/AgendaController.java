package com.Controllers;

import com.Agenda.*;
import com.Repositories.ClientesRepository;
import com.Usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@RestController
public class AgendaController {

    @Autowired
    public ClientesRepository clientesRepository;


    Empleados empleados = new Empleados();
    Empresas empresas = new Empresas();
    Proveedores proveedores = new Proveedores();
    ModelAndView agendaModel = new ModelAndView();

    public ModelAndView agendaClientes(Usuario user) {
        agendaModel.setViewName("agenda-clientes.html");
        agendaModel.addObject("clientes", clientesRepository.findAll());
        agendaModel.addObject("numClientes", clientesRepository.findAll().size());
        agendaModel.addObject("usuario", user);
        return agendaModel;
    }

    public ModelAndView anyadirCliente(Usuario user, String nombre, String apellidos, String id, String telefono, String correo, String dir, boolean premium) {
        clientesRepository.save(new Cliente(nombre, apellidos, id, telefono, correo, dir, premium));
        return agendaClientes(user);
    }

    public ModelAndView borrarCliente(Usuario user, String ref) {
        clientesRepository.delete(clientesRepository.findClienteByRef(ref));

        return agendaClientes(user);
    }

    public ModelAndView editarCliente(Usuario user, String ref, String nombre, String apellidos, String id, String telefono, String correo, String dir, boolean premium) {
        Cliente cliente = clientesRepository.findClienteByRef(ref);
        cliente.setNombre(nombre);
        cliente.setApellidos(apellidos);
        cliente.setId(id);
        cliente.setTelefono(telefono);
        cliente.setEmail(correo);
        cliente.setDireccion(dir);
        cliente.setPremium(premium);

        return agendaClientes(user);
    }

    public Cliente dameCliente (String ref){
        return clientesRepository.findClienteByRef(ref);
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

    public ArrayList<Cliente> getClientes() {
        return (ArrayList<Cliente>) clientesRepository.findAll();
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
