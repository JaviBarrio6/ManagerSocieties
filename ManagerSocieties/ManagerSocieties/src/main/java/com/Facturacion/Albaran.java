package com.Facturacion;

import com.Agenda.Cliente;
import com.Agenda.Empleado;
import com.Inventario.Producto;
import com.Tareas.Tarea;
import com.Tareas.Tareas;

import java.util.ArrayList;

public class Albaran {

    // Inicio Variables

    public static int generadorId = 0;
    private static final String refAlbaran = "ALB";
    private String ref;
    private Cliente cliente;

    private String fecha;

    private ArrayList<Producto> productos;
    private ArrayList<Tarea> tareas;
    private double IVA;

    private double precioSinIva;

    private double precio;

    // Fin Variables

    // Inicio Constructores

    public Albaran(){
        setRef("");
        setCliente(null);
        setFecha("");
        setProductos(null);
        setTareas(null);
        setIVA(0);
        setPrecioSinIva();
        setPrecio();
    }

    public Albaran (Cliente cliente, String fecha, ArrayList<Producto> productos, ArrayList<Tarea> tareas, double IVA){

        generadorId++;
        setRef (generadorRef(generadorId, refAlbaran));
        setCliente(cliente);
        setFecha(fecha);
        setProductos(productos);
        setTareas(tareas);
        setIVA(IVA);
        setPrecioSinIva();
        setPrecio();
    }

    public Albaran (String ref, Cliente cliente, String fecha, ArrayList<Producto> productos, ArrayList<Tarea> tareas, double IVA){

        setRef (ref);
        setCliente(cliente);
        setFecha(fecha);
        setProductos(productos);
        setTareas(tareas);
        setIVA(IVA);
        setPrecioSinIva();
        setPrecio();
    }

    // Fin Constructores

    // Inicio Setters
    public void setRef(String ref) {
        this.ref = ref;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setFecha (String fecha){
        this.fecha = darFormatoFecha(fecha);
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = (productos != null)?productos: new ArrayList<>();
    }

    public void setTareas(ArrayList<Tarea> tareas) {
        this.tareas = (tareas != null)?tareas: new ArrayList<>();
    }

    public void setIVA(double IVA) {
        this.IVA = (IVA / 100);
    }

    public void setPrecioSinIva() {
        double precio = 0;
        for (Producto producto: this.productos){
            precio += producto.getPrecio();
        }
        for (Tarea tarea: this.tareas){
            precio += tarea.getPrecio();
        }
        this.precioSinIva = precio;
    }

    public void setPrecio() {
        this.precio = this.precioSinIva * (1 + this.IVA);
    }

    // Fin Setters

    // Inicio Getters


    public String getRef() {
        return this.ref;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public String getFecha() {
        return this.fecha;
    }

    public ArrayList<Producto> getProductos() {
        return this.productos;
    }

    public ArrayList<Tarea> getTareas() {
        return this.tareas;
    }

    public double getIVA() {
        return this.IVA;
    }

    public double getPrecioSinIva() {
        return this.precioSinIva;
    }

    public double getPrecio() {
        return this.precio;
    }

    // Fin Getters

    // Inicio Funciones

    public String generadorRef (int num, String ref){
        int digitos = (int)(Math.log10(num)+ 1);
        String refAux = "";
        for (int i = 0; i < (4-digitos); i++){
            refAux = refAux.concat("0");
        }
        return (ref + (refAux) + num);
    }

    public String darFormatoPrecio (double sueldo){
        String[] cadena = Double.toString(sueldo).split("\\.");
        if (cadena[1].length() == 0){
            return cadena[0].concat(",").concat("00").concat(" €");
        } else if (cadena[1].length() == 1) {
            String valor = cadena[0].concat(",").concat(cadena[1]).concat("0").concat(" €");
            return valor;
        } else if (cadena[1].length() == 2) {
            return cadena[0].concat(",").concat(cadena[1]).concat(" €");
        } else {
            return cadena[0].concat(",").concat(cadena[1].substring(0, 2)).concat(" €");
        }
    }

    public String darFormatoFecha (String fecha){
        String[] campos = fecha.split("-");
        if (campos.length != 3){
            return fecha;
        } else {
            return campos[2].concat("/".concat(campos[1]).concat("/").concat(campos[0]));
        }
    }

    public String desformatearFecha (String fecha){
        if (fecha.equals("-")){
            return fecha;
        } else {
            String[] campos = fecha.split("/");
            return campos[2].concat("-".concat(campos[1]).concat("-").concat(campos[0]));
        }
    }

    // Fin Funciones
}
