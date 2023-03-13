package com.Tareas;

import com.Agenda.Cliente;
import java.io.Serializable;


public class Tarea implements Serializable {

    // Inicio Variables

    private static int generadorId = 0;
    private static final String refTareas = "TAR";
    private String ref;
    private Cliente cliente;
    private String fechaInicio;
    private String fechaFin;

    private String hora;
    private String[] empleados;
    private double gastoExtra;

    private String[] inventario;
    private String info;

    private int estado;

    // Fin Variables

    // Inicio Constructores
    public Tarea (){
       setRef("");
       setCliente(null);
       setFechaInicio("-");
       setFechaFin("-");
       setGastoExtra(0);
       setInfo("");
       setEstado(0);
       setEmpleados(null);
       setHora("-");
       setInventario(null);
    }

    public Tarea (Cliente cliente, String[] empleados, String fechaInicio, String fechaFin, String hora, double gastoExtra, String info, int estado, String[] inventario){
        setCliente(cliente);
        setFechaInicio(fechaInicio);
        setFechaFin(fechaFin);
        setGastoExtra(gastoExtra);
        setInfo(info);
        setEstado(estado);
        setEmpleados(empleados);
        setHora(hora);
        setInventario(inventario);

        generadorId++;
        setRef(generadorRef(generadorId, refTareas));
    }

    public Tarea (String ref, Cliente cliente, String[] empleados, String fechaInicio, String fechaFin, String hora, double gastoExtra, String info, int estado, String[] inventario){
        setCliente(cliente);
        setFechaInicio(fechaInicio);
        setFechaFin(fechaFin);
        setGastoExtra(gastoExtra);
        setInfo(info);
        setEstado(estado);
        setEmpleados(empleados);
        setHora(hora);
        setInventario(inventario);

        setRef(ref);
    }

    // Fin Constructores

    // Inicio Setters

    public void setRef(String ref) {
        this.ref = ref;
    }

    public void setFechaInicio(String fechaInicio) {
        if (fechaInicio == null){
            this.fechaInicio = "-";
        } else if (fechaInicio.equals("")){
            this.fechaInicio = "-";
        } else {
            this.fechaInicio = (darFormatoFecha(fechaInicio));

        }
    }

    public void setFechaFin(String fechaFin) {
        if (fechaFin == null){
            this.fechaFin = "-";
        } else if (fechaFin.equals("")){
            this.fechaFin = "-";
        } else {
            this.fechaFin = (darFormatoFecha(fechaFin));

        }
    }

    public void setHora (String hora){
        this.hora = hora;
    }

    public void setGastoExtra(double gastoExtra) {
        this.gastoExtra = gastoExtra;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setCliente (Cliente cliente){
        this.cliente = cliente;
    }

    public void setEmpleados (String[] empleados){
        this.empleados = empleados;
    }

    public void setInventario (String[] inventario){
        this.inventario = inventario;
    }

    public void setEstado (int estado){
        if (estado < 0 || estado > 2){
            this.estado = 0;
        } else {
            this.estado = estado;
        }
    }

    // Fin Setters

    // Inicio Getters

    public String getRef() {
        return this.ref;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public String getFechaInicio() {
        return this.fechaInicio;
    }

    public String getFechaFin() {
        return this.fechaFin;
    }

    public String getHora() {
        return this.hora;
    }

    public String[] getEmpleados() {
        return this.empleados;
    }

    public double getGastoExtra() {
        return this.gastoExtra;
    }

    public String[] getInventario() {
        return this.inventario;
    }

    public String getInfo() {
        return this.info;
    }

    public int getEstado() {
        return this.estado;
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

    public boolean contieneEmpleado (String empleado, String[] empleados){
        for (int contador = 0; contador < empleados.length; contador++){
            if (empleado.equals(empleados[contador])){
                return true;
            }
        }
        return false;
    }

    public boolean contieneInventario (String objeto, String[] inventario){
        if (inventario == null){
            return false;
        }
        for (int contador = 0; contador < inventario.length; contador++){
            if (objeto.equals(inventario[contador])){
                return true;
            }
        }
        return false;
    }

    // Fin Funciones
}
