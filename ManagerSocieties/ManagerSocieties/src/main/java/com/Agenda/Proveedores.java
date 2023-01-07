package com.Agenda;

import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;

@Component
public class Proveedores {
    public LinkedHashMap<String, Proveedor> proveedores = new LinkedHashMap<>();

    Proveedor proveedor01 = new Proveedor("FreeMate", "SL", "B64560428", "933602222", "Freemate@freemate.com", "C. Castillejos, 316, Barcelona");
    Proveedor proveedor02 = new Proveedor("KP Limpieza", "SL", "27311763E", "699837191", "kplimpieza@kplimpieza.es", "C. Horizonte, 7, Sevilla");

    public Proveedores () {
        proveedores.put(proveedor01.getRef(), proveedor01);
        proveedores.put(proveedor02.getRef(), proveedor02);
    }

    public void editarProveedor (String ref, String nombre, String tipo, String id, String telefono, String correo, String dir){
        this.proveedores.put(ref, new Proveedor(ref, nombre, tipo, id, telefono, correo, dir));
    }

}
