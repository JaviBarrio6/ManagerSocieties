package com.Inventario.Service;

import com.Inventario.Herramienta.Entidad.Herramienta;
import com.Inventario.Maquina.Entidad.Maquina;
import com.Inventario.Material.Entidad.Material;
import com.Inventario.Producto.Entidad.Producto;
import com.Inventario.Vehiculo.Entidad.Vehiculo;
import com.Usuario.Entidad.Usuario;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Service
public class InventarioService {
    ModelAndView inventarioModel = new ModelAndView();

    public ModelAndView inventarioHerramientas(Usuario user, List<Herramienta> herramientas) {
        inventarioModel.setViewName("inventario-herramientas.html");
        inventarioModel.addObject("herramientas", herramientas);
        inventarioModel.addObject("numHerramientas", herramientas.size());
        inventarioModel.addObject("usuario", user);
        return inventarioModel;
    }

    public ModelAndView inventarioMaquinas(Usuario user, List<Maquina> maquinas) {
        inventarioModel.setViewName("inventario-maquinas.html");
        inventarioModel.addObject("maquinas", maquinas);
        inventarioModel.addObject("numMaquinas", maquinas.size());
        inventarioModel.addObject("usuario", user);
        return inventarioModel;
    }

    public ModelAndView inventarioMateriales(Usuario user, List<Material> materiales) {
        inventarioModel.setViewName("inventario-materiales.html");
        inventarioModel.addObject("materiales", materiales);
        inventarioModel.addObject("numMateriales", materiales.size());
        inventarioModel.addObject("usuario", user);
        return inventarioModel;
    }
    // Fin Materiales

    // Inicio Productos
    public ModelAndView inventarioProductos(Usuario user, List<Producto> productos) {
        inventarioModel.setViewName("inventario-productos.html");
        inventarioModel.addObject("productos", productos);
        inventarioModel.addObject("numProductos", productos.size());
        inventarioModel.addObject("usuario", user);
        return inventarioModel;
    }
    // Fin Vehículos

    // Inicio Vehículos
    public ModelAndView inventarioVehiculos(Usuario user, List<Vehiculo> vehiculos) {
        inventarioModel.setViewName("inventario-vehiculos.html");
        inventarioModel.addObject("vehiculos", vehiculos);
        inventarioModel.addObject("numVehiculos", vehiculos.size());
        inventarioModel.addObject("usuario", user);
        return inventarioModel;
    }
}
