package com.Tareas.Service;

import com.Agenda.Cliente.Entidad.Cliente;
import com.Agenda.Cliente.Repository.ClientesRepository;
import com.Agenda.Empleado.Entidad.Empleado;
import com.Agenda.Empleado.Repository.EmpleadosRepository;
import com.Inventario.Herramienta.Entidad.Herramienta;
import com.Inventario.Maquina.Entidad.Maquina;
import com.Inventario.Maquina.Repository.MaquinasRepository;
import com.Inventario.Material.Entidad.Material;
import com.Inventario.Material.Repository.MaterialesRepository;
import com.Inventario.Producto.Entidad.Producto;
import com.Inventario.Producto.Repository.ProductosRepository;
import com.Inventario.Vehiculo.Entidad.Vehiculo;
import com.Inventario.Vehiculo.Repository.VehiculoRepository;
import com.Tareas.Entidad.Tarea;
import com.Usuario.Entidad.Usuario;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Service
public class TareasService {
    ModelAndView tareasModel = new ModelAndView();

    public ModelAndView tareas(Usuario user, List<Tarea> tareas, List<Cliente> clientes, List<Empleado> empleados,
                               List<Herramienta> herramientas, List<Maquina> maquinas, List<Material> materiales,
                               List<Producto> productos, List<Vehiculo> vehiculos){
        tareasModel.setViewName("tareas.html");
        tareasModel.addObject("tareas", tareas);
        tareasModel.addObject("clientes", clientes);
        tareasModel.addObject("empleados", empleados);
        tareasModel.addObject("herramientas", herramientas);
        tareasModel.addObject("maquinas", maquinas);
        tareasModel.addObject("materiales", materiales);
        tareasModel.addObject("productos", productos);
        tareasModel.addObject("vehiculos", vehiculos);
        tareasModel.addObject("numTareas", tareas.size());
        tareasModel.addObject("usuario", user);
        return tareasModel;
    }

}
