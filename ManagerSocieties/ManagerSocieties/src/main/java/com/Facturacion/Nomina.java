package com.Facturacion;

import com.Agenda.Empleado.Entidad.Empleado;

import java.io.Serializable;

public class Nomina implements Serializable {

    // Inicio Variables

    public static int generadorId = 0;
    private static final String refNomina = "NOM";
    private String ref;
    private String nombreEmpresa;
    private String direccionEmpresa;
    private String numSSEmpresa;
    private Empleado empleado;
    private String fecha;
    private int dias;
    private double[] salarioConvenio = new double[2];
    private double[] prestacionAccidente = new double[2];
    private double[] complementoSalarial = new double[2];
    private double[] teletrabajo = new double[2];
    private double[] productividad = new double[2];
    private double[] pagasExtra = new double[2];
    private double[] contingencias = new double[2];
    private double[] formacionP = new double[2];
    private double[] desempleo = new double[2];
    private double[] tIRPF = new double[2];

    private double sueldoBruto;
    private double sueldoNeto;

    // Fin Variables

    // Inicio Constructores

    public Nomina(){
        setRef("");
        setEmpleado(null);
        setFecha("");
        setDias(0);
        setSalarioConvenio(0);
        setPrestacionAccidente(0);
        setComplementoSalarial(0);
        setTeletrabajo(0);
        setProductividad(0);
        setPagasExtra(0);
        setContingencias(0);
        setFormacionP(0);
        setDesempleo(0);
        settIRPF();
        setSueldoBruto();
        setSueldoNeto();
    }

    public Nomina (Empleado empleado, String fecha, int dias, double salarioConvenio, double prestacionAccidente,
                   double complementoSalarial, double teletrabajo, double productividad, double pagasExtra,
                   double contingencias, double formacionP, double desempleo){

        generadorId++;
        setRef (generadorRef(generadorId, refNomina));
        setEmpleado(empleado);
        setFecha(fecha);
        setDias(dias);
        setSalarioConvenio(salarioConvenio);
        setPrestacionAccidente(prestacionAccidente);
        setComplementoSalarial(complementoSalarial);
        setTeletrabajo(teletrabajo);
        setProductividad(productividad);
        setPagasExtra(pagasExtra);
        setSueldoBruto();
        setContingencias(contingencias);
        setFormacionP(formacionP);
        setDesempleo(desempleo);
        settIRPF();
        setSueldoNeto();
    }

    public Nomina (String ref, Empleado empleado, String fecha, int dias, double salarioConvenio, double prestacionAccidente,
                   double complementoSalarial, double teletrabajo, double productividad, double pagasExtra,
                   double contingencias, double formacionP, double desempleo){

        setRef (ref);
        setEmpleado(empleado);
        setFecha(fecha);
        setDias(dias);
        setSalarioConvenio(salarioConvenio);
        setPrestacionAccidente(prestacionAccidente);
        setComplementoSalarial(complementoSalarial);
        setTeletrabajo(teletrabajo);
        setProductividad(productividad);
        setPagasExtra(pagasExtra);
        setSueldoBruto();
        setContingencias(contingencias);
        setFormacionP(formacionP);
        setDesempleo(desempleo);
        settIRPF();
        setSueldoNeto();
    }

    // Fin Constructores

    // Inicio Setters

    public void setRef(String ref){
        this.ref = ref;
    }
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public void setFecha(String fecha) {
        this.fecha = darFormatoFecha(fecha);
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public void setSalarioConvenio(double salarioConvenio) {

        this.salarioConvenio[0] = salarioConvenio;
        this.salarioConvenio[1] = getDias() * salarioConvenio;

    }

    public void setPrestacionAccidente(double prestacionAccidente) {
        this.prestacionAccidente[0] = prestacionAccidente;
        this.prestacionAccidente[1] = getDias() * prestacionAccidente;
    }

    public void setComplementoSalarial(double complementoSalarial) {
        this.complementoSalarial[0] = complementoSalarial;
        this.complementoSalarial[1] = getDias() * complementoSalarial;
    }

    public void setTeletrabajo(double teletrabajo) {
        this.teletrabajo[0] = teletrabajo;
        this.teletrabajo[1] = getDias() * teletrabajo;
    }

    public void setProductividad(double productividad) {
        this.productividad[0] = productividad;
        this.productividad[1] = getDias() * productividad;
    }

    public void setPagasExtra(double pagasExtra){
        this.pagasExtra[0] = pagasExtra;
        this.pagasExtra[1] = getDias() * pagasExtra * 2;
    }

    public void setContingencias(double contingencias) {
        this.contingencias[0] = contingencias;
        this.contingencias[1] = getSueldoBruto() * (contingencias / 100);
    }

    public void setFormacionP(double formacionP) {
        this.formacionP[0] = formacionP;
        this.formacionP[1] = getSueldoBruto() * (formacionP / 100);
    }

    public void setDesempleo(double desempleo) {
        this.desempleo[0] = desempleo;
        this.desempleo[1] = getSueldoBruto() * (desempleo / 100);
    }

    public void settIRPF() {
        this.tIRPF[0] = Math.round(getPercentIRPF(getSueldoBruto()) * 100) / 100d;
        this.tIRPF[1] = Math.round(getSueldoBruto() * this.tIRPF[0] / 100);
    }

    public void setSueldoBruto(){
        this.sueldoBruto = Math.round((this.salarioConvenio[1] + this.prestacionAccidente[1] + this.complementoSalarial[1] +
                this.teletrabajo[1] + this.productividad[1] + this.pagasExtra[1]) * 100) / 100d;
    }

    public void setSueldoNeto(){
        this.sueldoNeto = Math.round((getSueldoBruto() - (this.contingencias[1] + this.formacionP[1] + this.desempleo[1] + this.tIRPF[1])) * 100) / 100d;
    }

    // Fin Setters

    // Inicio Getters

    public String getRef() {
        return this.ref;
    }

    public String getNombreEmpresa() {
        return this.nombreEmpresa;
    }

    public String getDireccionEmpresa() {
        return this.direccionEmpresa;
    }

    public String getNumSSEmpresa() {
        return this.numSSEmpresa;
    }

    public Empleado getEmpleado() {
        return this.empleado;
    }

    public String getFecha() {
        return this.fecha;
    }

    public int getDias() {
        return this.dias;
    }

    public double[] getSalarioConvenio() {
        return this.salarioConvenio;
    }

    public double[] getPrestacionAccidente() {
        return this.prestacionAccidente;
    }

    public double[] getComplementoSalarial() {
        return this.complementoSalarial;
    }

    public double[] getTeletrabajo() {
        return this.teletrabajo;
    }

    public double[] getProductividad() {
        return this.productividad;
    }

    public double[] getPagasExtra(){
        return this.pagasExtra;
    }

    public double[] getContingencias() {
        return this.contingencias;
    }

    public double[] getFormacionP() {
        return this.formacionP;
    }

    public double[] getDesempleo() {
        return this.desempleo;
    }

    public double[] gettIRPF() {
        return this.tIRPF;
    }

    public double getSueldoBruto(){
        return this.sueldoBruto;
    }

    public double getSueldoNeto(){
        return this.sueldoNeto;
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

    public double getPercentIRPF(double sueldoMes){
        double bruto = sueldoMes * 12;
        if (bruto <= 12450){
            return 0.19;
        } else if (bruto <= 20200){
            return ((((12450 * 0.19) + (bruto - 12450) * 0.24) * 100) / bruto);
        } else if (bruto <= 35200){
            return ((((12450 * 0.19) + (7750 * 0.24) + (bruto - 20200) * 0.30) * 100) / bruto);
        } else if (bruto <= 60000){
            return ((((12450 * 0.19) + (7750 * 0.24) + (15000 * 0.30) + (bruto - 35200) * 0.37) * 100) / bruto);
        } else if (bruto <= 300000){
            return ((((12450 * 0.19) + (7750 * 0.24) + (15000 * 0.30) + (24800 * 0.37) + (bruto - 60000) * 0.45) * 100) / bruto);
        } else {
            return ((((12450 * 0.19) + (7750 * 0.24) + (15000 * 0.30) + (24800 * 0.37) + (240000 * 0.45) + (bruto - 300000) * 0.47) * 100) / bruto);
        }
    }

    public String darFormatoSueldo (double sueldo){
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
