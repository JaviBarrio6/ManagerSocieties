package com.Inventario;

import java.util.LinkedHashMap;

public class Productos {

    public LinkedHashMap<String, Producto> productos = new LinkedHashMap<>();

    Producto producto01 = new Producto("X-3 Cristalizador Rosa", 31, 100, "X3.png");
    Producto producto02 = new Producto("D-2 Decapante Alcalino", 28, 72, "D2.png");
    Producto producto03 = new Producto("A-4 Abrillantador Suelos Pizarra", 59, 3, "A4.png");
    Producto producto04 = new Producto("SUPERLUX A 330 S", 247, 4, "A330.jpg");
    Producto producto05 = new Producto("SUPERLUX A 28 S", 130, 2, "A28.jpg");

    public Productos(){
        this.productos.put(producto01.getRef(), producto01);
        this.productos.put(producto02.getRef(), producto02);
        this.productos.put(producto03.getRef(), producto03);
        this.productos.put(producto04.getRef(), producto04);
        this.productos.put(producto05.getRef(), producto05);
    }

    public void editarProducto (String ref, String modelo, double precio, int stock, String urlFoto){
        this.productos.put(ref, new Producto(ref, modelo, precio, stock, urlFoto));
    }

    public Producto dameProducto (String ref){
        return this.productos.get(ref);
    }

    public LinkedHashMap<String, Producto> getTheProductos(){
        return this.productos;
    }
}
