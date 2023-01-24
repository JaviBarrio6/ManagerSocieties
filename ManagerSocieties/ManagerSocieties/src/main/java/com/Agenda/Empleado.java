package com.Agenda;

import java.io.Serializable;

public class Empleado extends Persona implements Serializable {

    public static int generadorId = 0;
    private static final String refEmpleado = "EMP";

    private String usuario;

    private String puesto;
    private int antiguedad;
    private String ref;

    // Fin Variables

    // Inicio Constructores
    public Empleado () {
        super ("", "", "", "", "", "");
        setRef("");
        setUsuario("");
        setPuesto("");
        setAntiguedad(0);
    }

    public Empleado (String nombre, String apellidos, String id, String telefono, String email, String direccion, String usuario, String puesto, int antiguedad) {
        super(nombre, apellidos, id, telefono, email, direccion);
        if (!esDNICorrecto(id)){
            throw new RuntimeException("El valor del DNI o del CIF no es correcto");
        }

        generadorId++;
        setRef(generadorRef(generadorId, refEmpleado));
        setUsuario(usuario);
        setPuesto(puesto);
        setAntiguedad(antiguedad);
    }

    public Empleado (String ref, String nombre, String apellidos, String id, String telefono, String email, String direccion, String usuario, String puesto, int antiguedad) {
        super(nombre, apellidos, id, telefono, email, direccion);
        if (!esDNICorrecto(id)){
            throw new RuntimeException("El valor del DNI o del CIF no es correcto");
        }

        setRef(ref);
        setUsuario(usuario);
        setPuesto(puesto);
        setAntiguedad(antiguedad);
    }

    public Empleado (Empleado empleado){
        super(empleado.getNombre(), empleado.getApellidos(), empleado.getId(), empleado.getTelefono(), empleado.getEmail(), empleado.getDireccion());
        setRef(empleado.getRef());
        setUsuario(empleado.getUsuario());
        setPuesto(empleado.getPuesto());
        setAntiguedad(empleado.getAntiguedad());
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

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    // Fin Setters

    // Inicio Getters

    public String getPuesto() {
        return this.puesto;
    }

    public int getAntiguedad() {
        return this.antiguedad;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getRef() {
        return this.ref;
    }

    // Fin Getters

    // Inicio Funciones

    public void editarEmpleado (String nombre, String apellidos, String usario, String id, String telefono, String email, String direccion, String puesto, int antiguedad) {
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
