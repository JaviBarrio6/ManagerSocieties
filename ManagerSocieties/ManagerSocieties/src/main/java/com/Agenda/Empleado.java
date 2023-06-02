package com.Agenda;

import com.Usuario.Usuarios;

import java.io.Serializable;

public class Empleado extends Persona implements Serializable {

    public static int generadorId = 4;
    private static final String refEmpleado = "EMP";

    private String usuario;
    private String puesto;
    private String antiguedad;
    private String ref;

    private String numSS;

    // Fin Variables

    // Inicio Constructores
    public Empleado () {
        super ("", "", "", "", "", "");
        setRef("");
        setUsuario("");
        setPuesto("");
        setAntiguedad("");
    }

    public Empleado (String nombre, String apellidos, String id, String telefono, String email, String direccion, String usuario, String puesto, String antiguedad, String numSS) {
        super(nombre, apellidos, id, telefono, email, direccion);
        if (!esDNICorrecto(id)){
            throw new RuntimeException("El valor del DNI o del CIF no es correcto");
        }

        generadorId++;
        setRef(generadorRef(generadorId, refEmpleado));
        setUsuario(usuario);
        setPuesto(puesto);
        setAntiguedad(antiguedad);
        setNumSS(numSS);
    }

    public Empleado (String ref, String nombre, String apellidos, String id, String telefono, String email, String direccion, String usuario, String puesto, String antiguedad, String numSS) {
        super(nombre, apellidos, id, telefono, email, direccion);
        if (!esDNICorrecto(id)){
            throw new RuntimeException("El valor del DNI o del CIF no es correcto");
        }

        setRef(ref);
        setUsuario(usuario);
        setPuesto(puesto);
        setAntiguedad(antiguedad);
        setNumSS(numSS);
    }

    public Empleado (Empleado empleado){
        super(empleado.getNombre(), empleado.getApellidos(), empleado.getId(), empleado.getTelefono(), empleado.getEmail(), empleado.getDireccion());
        setRef(empleado.getRef());
        setUsuario(empleado.getUsuario());
        setPuesto(empleado.getPuesto());
        setAntiguedad(empleado.getAntiguedad());
        setNumSS(empleado.getNumSS());
    }

    // Fin Constructores

    // Inicio Setters

    private void setRef (String ref){
        this.ref = ref;
    }

    private void setUsuario (String usuario) {
        this.usuario = usuario;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public void setAntiguedad(String antiguedad) {
        this.antiguedad = antiguedad;
    }

    public void setNumSS (String numSS) {
        this.numSS = numSS;
    }

    // Fin Setters

    // Inicio Getters

    public String getPuesto() {
        return this.puesto;
    }

    public String getAntiguedad() {
        return this.antiguedad;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getRef() {
        return this.ref;
    }

    public String getNumSS(){
        return this.numSS;
    }

    // Fin Getters

    // Inicio Funciones

    public void editarEmpleado (String nombre, String apellidos, String usario, String id, String telefono, String email, String direccion, String puesto, String antiguedad) {
        setNombre(nombre);
        setApellidos(apellidos);
        setUsuario(usuario);
        setId(id);
        setTelefono(telefono);
        setEmail(email);
        setDireccion(direccion);
        setPuesto(puesto);
        setAntiguedad(antiguedad);
    }

    // Fin Funciones

}
