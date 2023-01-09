package com.Application;

import com.Inventario.*;
import org.springframework.web.servlet.ModelAndView;

public class InventarioController {

    Herramientas herramientas = new Herramientas();
    Maquinas maquinas = new Maquinas();
    Materiales materiales = new Materiales();
    Vehiculos vehiculos = new Vehiculos();
    ModelAndView inventarioModel = new ModelAndView();

    // Inicio Herramientas

    public ModelAndView inventarioHerramientas(){
        inventarioModel.setViewName("inventario-herramientas.html");
        inventarioModel.addObject("herramientas", herramientas.herramientas.values());
        inventarioModel.addObject("numHerramientas", herramientas.herramientas.values().size());
        return inventarioModel;
    }

    public ModelAndView anyadirHerramienta (String marca, String modelo, double precio, int cantidad){
        Herramienta herramienta = new Herramienta(marca, modelo, precio, cantidad);
        herramientas.herramientas.put(herramienta.getRef(), herramienta);

        return inventarioHerramientas();
    }

    public ModelAndView borrarHerramienta (String ref){
        herramientas.herramientas.remove(ref);

        return inventarioHerramientas();
    }

    public ModelAndView editarHerramienta (String ref, String marca, String modelo, double precio, int cantidad){
        herramientas.editarHerramienta(ref, marca, modelo, precio, cantidad);

        return inventarioHerramientas();
    }

    // Fin Herramientas

    // Inicio Máquinas
    public ModelAndView inventarioMaquinas(){
        inventarioModel.setViewName("inventario-maquinas.html");
        inventarioModel.addObject("maquinas", maquinas.maquinas.values());
        inventarioModel.addObject("numMaquinas", maquinas.maquinas.values().size());
        return inventarioModel;
    }

    public ModelAndView anyadirMaquina (String marca, String modelo, double precio, int cantidad){
        Maquina maquina = new Maquina(marca, modelo, precio, cantidad);
        maquinas.maquinas.put(maquina.getRef(), maquina);

        return inventarioMaquinas();
    }

    public ModelAndView borrarMaquina (String ref){
        maquinas.maquinas.remove(ref);

        return inventarioMaquinas();
    }

    public ModelAndView editarMaquina (String ref, String marca, String modelo, double precio, int cantidad){
        maquinas.editarMaquina(ref, marca, modelo, precio, cantidad);

        return inventarioMaquinas();
    }
    // Fin Máquinas

    // Inicio Materiales
    public ModelAndView inventarioMateriales(){
        inventarioModel.setViewName("inventario-materiales.html");
        inventarioModel.addObject("materiales", materiales.materiales.values());
        inventarioModel.addObject("numMateriales", materiales.materiales.values().size());
        return inventarioModel;
    }

    public ModelAndView anyadirMaterial (String marca, String modelo, double precio, int cantidad, int unidades){
        Material material = new Material(marca, modelo, precio, cantidad, unidades);
        materiales.materiales.put(material.getRef(), material);

        return inventarioMateriales();
    }

    public ModelAndView borrarMaterial (String ref){
        materiales.materiales.remove(ref);

        return inventarioMateriales();
    }

    public ModelAndView editarMaterial (String ref, String marca, String modelo, double precio, int cantidad, int unidades){
        materiales.editarMaterial(ref, marca, modelo, precio, cantidad, unidades);

        return inventarioMateriales();
    }
    // Fin Materiales

    // Inicio Vehículos
    public ModelAndView inventarioVehiculos(){
        inventarioModel.setViewName("inventario-vehiculos.html");
        inventarioModel.addObject("vehiculos", vehiculos.vehiculos.values());
        inventarioModel.addObject("numVehiculos", vehiculos.vehiculos.values().size());
        return inventarioModel;
    }

    public ModelAndView anyadirVehiculo (String marca, String modelo, String matricula, String color){
        Vehiculo vehiculo = new Vehiculo(marca, modelo, matricula, color);
        vehiculos.vehiculos.put(vehiculo.getRef(), vehiculo);

        return inventarioVehiculos();
    }

    public ModelAndView borrarVehiculo (String ref){
        vehiculos.vehiculos.remove(ref);

        return inventarioVehiculos();
    }

    public ModelAndView editarVehiculo (String ref, String marca, String modelo, String matricula, String color){
        vehiculos.editarVehiculo(ref, marca, modelo, matricula, color);

        return inventarioVehiculos();
    }
    // Fin Vehículos
}
