package com.Facturacion.GastosExternos.Entidad;

import com.Agenda.Empleado.Entidad.Empleado;
import jakarta.persistence.*;

@Entity
@Table (name = "gastos")
public class Gasto {

    // Inicio Variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int generadorId;
    private static final String refGasto = "GEX";
    @Column (name = "ref")
    private String ref;
    @OneToOne
    private Empleado empleado;
    @Column (name = "motivo")
    private String motivo;
    @Column (name = "fecha")
    private String fecha;
    @Column (name = "gasto")
    private double gasto;

    // Fin Variables

    // Inicio Constructores

    public Gasto(){
        setRef("");
        setEmpleado(null);
        setMotivo("");
        setFecha("");
        setGasto(0);
    }

    public Gasto (Empleado empleado, String motivo, String fecha, double gasto, int pos){
        setRef (generadorRef(++pos, refGasto));
        setEmpleado(empleado);
        setMotivo(motivo);
        setFecha(fecha);
        setGasto(gasto);
    }

    public Gasto (String ref, Empleado empleado, String motivo, String fecha, double gasto){
        setRef (ref);
        setEmpleado(empleado);
        setMotivo(motivo);
        setFecha(fecha);
        setGasto(gasto);
    }

    // Fin Constructores

    // Inicio Setters

    public void setRef(String ref){
        this.ref = ref;
    }
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    public void setMotivo (String motivo){
        this.motivo = motivo;
    }
    public void setFecha(String fecha) {
        this.fecha = darFormatoFecha(fecha);
    }
    public void setGasto (double gasto){
        this.gasto = gasto;
    }
    // Fin Setters

    // Inicio Getters

    public String getRef() {
        return this.ref;
    }

    public Empleado getEmpleado() {
        return this.empleado;
    }
    public String getMotivo (){
        return this.motivo;
    }

    public String getFecha() {
        return this.fecha;
    }
    public double getGasto(){
        return this.gasto;
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

    public String darFormatoGasto (double sueldo){
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
