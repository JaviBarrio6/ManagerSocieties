package com.Inventario;

import java.util.LinkedHashMap;

public class Maquinas {
    public LinkedHashMap<String, Maquina> maquinas = new LinkedHashMap<>();

    Maquina maquina01 = new Maquina("Einhell", "Torno Madera 400W", 181, 1);
    Maquina maquina02 = new Maquina("Genergy", "Generador Gasolina LIMITED3000", 395, 2);

    public Maquinas(){
        this.maquinas.put(maquina01.getRef(), maquina01);
        this.maquinas.put(maquina02.getRef(), maquina02);
    }

    public void editarMaquina (String ref, String marca, String modelo, double precio, int cantidad){
        this.maquinas.put(ref, new Maquina(ref, marca, modelo, precio, cantidad));
    }
}
