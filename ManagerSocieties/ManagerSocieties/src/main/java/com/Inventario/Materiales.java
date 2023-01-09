package com.Inventario;

import java.util.LinkedHashMap;

public class Materiales {
    public LinkedHashMap<String, Material> materiales = new LinkedHashMap<>();

    Material material01 = new Material("Spax", "Tornillos madera 16 mm", 1.59, 347, 35);
    Material material02 = new Material("Spax", "Tornillo de Métrica de acero de 30 mm", 2.89,215, 8);

    public Materiales(){
        this.materiales.put(material01.getRef(), material01);
        this.materiales.put(material02.getRef(), material02);
    }

    public void editarMaterial (String ref, String marca, String modelo, double precio, int cantidad, int unidades){
        this.materiales.put(ref, new Material(ref, marca, modelo, precio, cantidad, unidades));
    }
}
