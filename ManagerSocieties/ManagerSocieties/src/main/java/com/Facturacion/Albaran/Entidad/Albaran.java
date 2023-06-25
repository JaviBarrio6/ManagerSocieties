package com.Facturacion.Albaran.Entidad;

import com.Agenda.Cliente.Entidad.Cliente;
import com.Inventario.Producto.Entidad.Producto;
import com.Tareas.Entidad.Tarea;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Entity
@Table(name = "albaranes")
public class Albaran {

    // Inicio Variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int generadorId;
    private static final String refAlbaran = "ALB";
    @Column (name = "ref")
    private String ref;
    @OneToOne
    private Cliente cliente;

    @Column (name = "fecha")
    private String fecha;

    @ManyToMany
    private List<Producto> productos;
    @ManyToMany
    private List<Tarea> tareas;
    @Column (name = "IVA")
    private double IVA;

    @Column (name = "precio_sin_iva")
    private double precioSinIva;

    @Column (name = "precio")
    private double precio;

    @Column (name = "facturado")
    private boolean facturado;

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
        setFacturado(false);
    }

    public Albaran (Cliente cliente, String fecha, List<Producto> productos, List<Tarea> tareas, double IVA, int pos){

        setRef (generadorRef(++pos, refAlbaran));
        setCliente(cliente);
        setFecha(fecha);
        setProductos(productos);
        setTareas(tareas);
        setIVA(IVA);
        setPrecioSinIva();
        setPrecio();
        setFacturado(false);
    }

    public Albaran (String ref, Cliente cliente, String fecha, List<Producto> productos, ArrayList<Tarea> tareas, double IVA){

        setRef (ref);
        setCliente(cliente);
        setFecha(fecha);
        setProductos(productos);
        setTareas(tareas);
        setIVA(IVA);
        setPrecioSinIva();
        setPrecio();
        setFacturado(false);
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

    public void setProductos(List<Producto> productos) {
        this.productos = (productos != null)?productos: new ArrayList<>();
    }

    public void setTareas(List<Tarea> tareas) {
        this.tareas = (tareas != null)?tareas: new ArrayList<>();
    }

    public void setIVA(double IVA) {
        this.IVA = (IVA);
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

    public void setFacturado(boolean facturado){
        this.facturado = facturado;
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

    public List<Producto> getProductos() {
        return this.productos;
    }

    public List<Tarea> getTareas() {
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

    public boolean getFacturado(){
        return this.facturado;
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

    public int getNumProductos (String ref){
        int count = 0;
        for (Producto producto: this.productos){
            if (producto.getRef().equals(ref)) {
                count++;
            }
        }
        return count;
    }

    public int getNumTareas (String ref){
        int count = 0;
        for (Tarea tarea: this.tareas){
            if (tarea.getRef().equals(ref)) {
                count++;
            }
        }
        return count;
    }

    // Fin Funciones
}
