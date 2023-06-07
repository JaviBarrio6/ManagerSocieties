package com.Services;

import com.Agenda.*;
import com.Usuario.Usuario;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Service
public class AgendaService {
    ModelAndView agendaModel = new ModelAndView();

    public ModelAndView agendaClientes(Usuario user, List<Cliente> clientes, int personas) {
        agendaModel.setViewName("agenda-clientes.html");
        agendaModel.addObject("clientes", clientes);
        agendaModel.addObject("numClientes", personas);
        agendaModel.addObject("numEmpresas", clientes.size() - personas);
        agendaModel.addObject("usuario", user);
        return agendaModel;
    }

    public ModelAndView editarCliente(Usuario user, Cliente cliente, Cliente clienteAux, List<Cliente> clientes, int personas) {
        cliente.setNombre(clienteAux.getNombre());
        cliente.setApellidos(clienteAux.getApellidos());
        cliente.setId(clienteAux.getId());
        cliente.setTelefono(clienteAux.getTelefono());
        cliente.setEmail(clienteAux.getEmail());
        cliente.setDireccion(clienteAux.getDireccion());
        cliente.setPremium(clienteAux.getPremium());

        return agendaClientes(user, clientes, personas);
    }

    public ModelAndView agendaEmpleados(Usuario user, List<Empleado> empleados) {
        agendaModel.setViewName("agenda-empleados.html");
        agendaModel.addObject("empleados", empleados);
        agendaModel.addObject("numEmpleados", empleados.size());
        agendaModel.addObject("usuario", user);
        return agendaModel;
    }

    public ModelAndView editarEmpleado(Usuario user, Empleado empleado, Empleado empleadoAux, List<Empleado> empleados) {
        empleado.setNombre(empleadoAux.getNombre());
        empleado.setApellidos(empleadoAux.getApellidos());
        empleado.setId(empleadoAux.getId());
        empleado.setTelefono(empleadoAux.getTelefono());
        empleado.setEmail(empleadoAux.getEmail());
        empleado.setDireccion(empleadoAux.getDireccion());
        empleado.setPuesto(empleadoAux.getPuesto());
        empleado.setAntiguedad(empleadoAux.getAntiguedad());
        empleado.setNumSS(empleadoAux.getNumSS());

        return agendaEmpleados(user, empleados);
    }

    // Fin Empleados

    // Inicio Empresas Subcontratadas

    public ModelAndView agendaEmpresasSubcontratadas(Usuario user, List<EmpresaSub> empresas) {
        agendaModel.setViewName("agenda-empresassubcontratadas.html");
        agendaModel.addObject("empresas", empresas);
        agendaModel.addObject("numEmpresas", empresas.size());
        agendaModel.addObject("usuario", user);
        return agendaModel;
    }

    public ModelAndView editarEmpresa(Usuario user, EmpresaSub empresa, EmpresaSub empresaAux, List<EmpresaSub> empresas) {
        empresa.setNombre(empresaAux.getNombre());
        empresa.setTipo(empresaAux.getTipo());
        empresa.setId(empresaAux.getId());
        empresa.setTelefono(empresaAux.getTelefono());
        empresa.setEmail(empresaAux.getEmail());
        empresa.setDireccion(empresaAux.getDireccion());
        return agendaEmpresasSubcontratadas(user, empresas);
    }

    public ModelAndView agendaProveedores(Usuario user, List<Proveedor> proveedores) {
        agendaModel.setViewName("agenda-proveedores.html");
        agendaModel.addObject("proveedores", proveedores);
        agendaModel.addObject("numProveedores", proveedores.size());
        agendaModel.addObject("usuario", user);
        return agendaModel;
    }

    public ModelAndView editarProveedor(Usuario user, Proveedor proveedor, Proveedor proveedorAux, List<Proveedor> proveedores) {
        proveedor.setNombre(proveedorAux.getNombre());
        proveedor.setTipo(proveedorAux.getTipo());
        proveedor.setId(proveedorAux.getId());
        proveedor.setTelefono(proveedorAux.getTelefono());
        proveedor.setEmail(proveedorAux.getEmail());
        proveedor.setDireccion(proveedorAux.getDireccion());

        return agendaProveedores(user, proveedores);
    }

    // Inicio Getters

    // Fin Getters

}
