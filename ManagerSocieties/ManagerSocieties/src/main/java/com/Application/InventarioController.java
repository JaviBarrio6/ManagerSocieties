package com.Application;

import com.Inventario.*;
import com.Usuario.Usuario;
import org.springframework.web.servlet.ModelAndView;

public class InventarioController {

    Herramientas herramientas = new Herramientas();
    Maquinas maquinas = new Maquinas();
    Materiales materiales = new Materiales();

    Productos productos = new Productos();
    Vehiculos vehiculos = new Vehiculos();
    ModelAndView inventarioModel = new ModelAndView();

    // Inicio Herramientas

    public ModelAndView inventarioHerramientas(Usuario user){
        inventarioModel.setViewName("inventario-herramientas.html");
        inventarioModel.addObject("herramientas", herramientas.herramientas.values());
        inventarioModel.addObject("numHerramientas", herramientas.herramientas.values().size());
        inventarioModel.addObject("usuario", user);
        return inventarioModel;
    }

    public ModelAndView anyadirHerramienta (Usuario user, String marca, String modelo, double precio, int cantidad){
        Herramienta herramienta = new Herramienta(marca, modelo, precio, cantidad);
        herramientas.herramientas.put(herramienta.getRef(), herramienta);

        return inventarioHerramientas(user);
    }

    public ModelAndView borrarHerramienta (Usuario user, String ref){
        herramientas.herramientas.remove(ref);

        return inventarioHerramientas(user);
    }

    public ModelAndView editarHerramienta (Usuario user, String ref, String marca, String modelo, double precio, int cantidad){
        herramientas.editarHerramienta(ref, marca, modelo, precio, cantidad);

        return inventarioHerramientas(user);
    }

    // Fin Herramientas

    // Inicio Máquinas
    public ModelAndView inventarioMaquinas(Usuario user){
        inventarioModel.setViewName("inventario-maquinas.html");
        inventarioModel.addObject("maquinas", maquinas.maquinas.values());
        inventarioModel.addObject("numMaquinas", maquinas.maquinas.values().size());
        inventarioModel.addObject("usario", user);
        return inventarioModel;
    }

    public ModelAndView anyadirMaquina (Usuario user, String marca, String modelo, double precio, int cantidad){
        Maquina maquina = new Maquina(marca, modelo, precio, cantidad);
        maquinas.maquinas.put(maquina.getRef(), maquina);

        return inventarioMaquinas(user);
    }

    public ModelAndView borrarMaquina (Usuario user, String ref){
        maquinas.maquinas.remove(ref);

        return inventarioMaquinas(user);
    }

    public ModelAndView editarMaquina (Usuario user, String ref, String marca, String modelo, double precio, int cantidad){
        maquinas.editarMaquina(ref, marca, modelo, precio, cantidad);

        return inventarioMaquinas(user);
    }
    // Fin Máquinas

    // Inicio Materiales
    public ModelAndView inventarioMateriales(Usuario user){
        inventarioModel.setViewName("inventario-materiales.html");
        inventarioModel.addObject("materiales", materiales.materiales.values());
        inventarioModel.addObject("numMateriales", materiales.materiales.values().size());
        inventarioModel.addObject("usuario", user);
        return inventarioModel;
    }

    public ModelAndView anyadirMaterial (Usuario user, String marca, String modelo, double precio, int cantidad, int unidades){
        Material material = new Material(marca, modelo, precio, cantidad, unidades);
        materiales.materiales.put(material.getRef(), material);

        return inventarioMateriales(user);
    }

    public ModelAndView borrarMaterial (Usuario user, String ref){
        materiales.materiales.remove(ref);

        return inventarioMateriales(user);
    }

    public ModelAndView editarMaterial (Usuario user, String ref, String marca, String modelo, double precio, int cantidad, int unidades){
        materiales.editarMaterial(ref, marca, modelo, precio, cantidad, unidades);

        return inventarioMateriales(user);
    }
    // Fin Materiales

    // Inicio Productos
    public ModelAndView inventarioProductos(Usuario user){
        inventarioModel.setViewName("inventario-productos.html");
        inventarioModel.addObject("productos", productos.productos.values());
        inventarioModel.addObject("numProductos", productos.productos.values().size());
        inventarioModel.addObject("usuario", user);
        return inventarioModel;
    }

    public ModelAndView anyadirProducto (Usuario user, String modelo, double precio, int stock, String urlFoto){
        Producto producto = new Producto (modelo, precio, stock, urlFoto);
        productos.productos.put(producto.getRef(), producto);

        return inventarioProductos(user);
    }

    public ModelAndView borrarProducto (Usuario user, String ref){
        productos.productos.remove(ref);

        return inventarioProductos(user);
    }

    public ModelAndView editarProducto (Usuario user, String ref, String modelo, double precio, int stock, String urlFoto){
        productos.editarProducto(ref, modelo, precio, stock, urlFoto);

        return inventarioProductos(user);
    }
    // Fin Vehículos

    // Inicio Vehículos
    public ModelAndView inventarioVehiculos(Usuario user){
        inventarioModel.setViewName("inventario-vehiculos.html");
        inventarioModel.addObject("vehiculos", vehiculos.vehiculos.values());
        inventarioModel.addObject("numVehiculos", vehiculos.vehiculos.values().size());
        inventarioModel.addObject("usuario", user);
        return inventarioModel;
    }

    public ModelAndView anyadirVehiculo (Usuario user, String marca, String modelo, String matricula, String color){
        Vehiculo vehiculo = new Vehiculo(marca, modelo, matricula, color);
        vehiculos.vehiculos.put(vehiculo.getRef(), vehiculo);

        return inventarioVehiculos(user);
    }

    public ModelAndView borrarVehiculo (Usuario user, String ref){
        vehiculos.vehiculos.remove(ref);

        return inventarioVehiculos(user);
    }

    public ModelAndView editarVehiculo (Usuario user, String ref, String marca, String modelo, String matricula, String color){
        vehiculos.editarVehiculo(ref, marca, modelo, matricula, color);

        return inventarioVehiculos(user);
    }
    // Fin Vehículos

    // Inicio Getters

    public Herramientas getHerramientas() {
        return this.herramientas;
    }

    public Maquinas getMaquinas() {
        return this.maquinas;
    }

    public Materiales getMateriales() {
        return this.materiales;
    }

    public Productos getProductos() {
        return this.productos;
    }

    public Vehiculos getVehiculos() {
        return this.vehiculos;
    }


    // Fin Getters
}
