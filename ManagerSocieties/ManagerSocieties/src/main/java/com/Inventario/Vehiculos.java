package com.Inventario;

import java.util.LinkedHashMap;

public class Vehiculos {
    public LinkedHashMap<String, Vehiculo> vehiculos = new LinkedHashMap<>();

    Vehiculo vehiculo01 = new Vehiculo("Citroen", "Nuevo Berlingo", "2652WHJ", "Blanca");
    Vehiculo vehiculo02 = new Vehiculo("Renault", "Master", "4010TFR", "Blanca");

    public Vehiculos(){
        this.vehiculos.put(vehiculo01.getRef(), vehiculo01);
        this.vehiculos.put(vehiculo02.getRef(), vehiculo02);
    }

    public void editarVehiculo (String ref, String marca, String modelo, String matricula, String color){
        this.vehiculos.put(ref, new Vehiculo(ref, marca, modelo, matricula, color));
    }
}
