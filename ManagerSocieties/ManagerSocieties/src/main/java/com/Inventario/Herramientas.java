package com.Inventario;

import java.util.LinkedHashMap;

public class Herramientas {
    public LinkedHashMap<String, Herramienta> herramientas = new LinkedHashMap<>();

    Herramienta herramienta01 = new Herramienta("Bosch", "Taladro EasyImpact 6300", 54.99, 10);
    Herramienta herramienta02 = new Herramienta("Cevik", "Soldador Inverter 200A", 199, 2);

    public Herramientas(){
        this.herramientas.put(herramienta01.getRef(), herramienta01);
        this.herramientas.put(herramienta02.getRef(), herramienta02);
    }

    public void editarHerramienta (String ref, String marca, String modelo, double precio, int cantidad){
        this.herramientas.put(ref, new Herramienta(ref, marca, modelo, precio, cantidad));
    }
}
