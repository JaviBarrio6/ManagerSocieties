package com.Agenda.Service;

import com.Agenda.Cliente.Entidad.Cliente;
import com.Agenda.Empleado.Entidad.Empleado;
import com.Agenda.EmpresaSubcontratada.Entidad.EmpresaSub;
import com.Agenda.Proveedor.Entidad.Proveedor;
import com.Usuario.Entidad.Usuario;
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
    public ModelAndView agendaEmpleados(Usuario user, List<Empleado> empleados) {
        agendaModel.setViewName("agenda-empleados.html");
        agendaModel.addObject("empleados", empleados);
        agendaModel.addObject("numEmpleados", empleados.size());
        agendaModel.addObject("usuario", user);
        return agendaModel;
    }

    public ModelAndView agendaEmpresasSubcontratadas(Usuario user, List<EmpresaSub> empresas) {
        agendaModel.setViewName("agenda-empresassubcontratadas.html");
        agendaModel.addObject("empresas", empresas);
        agendaModel.addObject("numEmpresas", empresas.size());
        agendaModel.addObject("usuario", user);
        return agendaModel;
    }

    public ModelAndView agendaProveedores(Usuario user, List<Proveedor> proveedores) {
        agendaModel.setViewName("agenda-proveedores.html");
        agendaModel.addObject("proveedores", proveedores);
        agendaModel.addObject("numProveedores", proveedores.size());
        agendaModel.addObject("usuario", user);
        return agendaModel;
    }
}
