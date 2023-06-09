package com.Agenda.Empleado.Entidad;

import com.Usuario.Entidad.Usuario;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "empleados")
public class Empleado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int generadorId;
    private static final String refEmpleado = "EMP";

    @Column (name = "nombre")
    private String nombre;
    @Column (name = "apellidos")
    private String apellidos;
    @Column (name = "id")
    private String id;
    @Column (name = "telefono")
    private String telefono;
    @Column (name = "email")
    private String email;
    @Column (name = "direccion")
    private String direccion;
    @OneToOne
    private Usuario usuario;
    @Column (name = "puesto")
    private String puesto;
    @Column (name = "antiguedad")
    private String antiguedad;
    @Column (name = "ref")
    private String ref;

    @Column (name = "numSS")
    private String numSS;

    // Fin Variables

    // Inicio Constructores
    public Empleado () {
        setNombre("");
        setApellidos("");
        setId("");
        setTelefono("");
        setEmail("");
        setDireccion("");
        setRef("");
        setUsuario(null);
        setPuesto("");
        setAntiguedad("");
    }

    public Empleado (String nombre, String apellidos, String id, String telefono, String email, String direccion, Usuario usuario, String puesto, String antiguedad, String numSS, int pos) {
        setNombre(nombre);
        setApellidos(apellidos);
        setId(id);
        setTelefono(telefono);
        setEmail(email);
        setDireccion(direccion);
        if (!esDNICorrecto(id)){
            throw new RuntimeException("El valor del DNI o del CIF no es correcto");
        }
        setRef (generadorRef(++pos, refEmpleado));
        setUsuario(usuario);
        setPuesto(puesto);
        setAntiguedad(antiguedad);
        setNumSS(numSS);
    }

    public Empleado (String ref, String nombre, String apellidos, String id, String telefono, String email, String direccion, Usuario usuario, String puesto, String antiguedad, String numSS) {
        setNombre(nombre);
        setApellidos(apellidos);
        setId(id);
        setTelefono(telefono);
        setEmail(email);
        setDireccion(direccion);
        setRef(ref);
        setUsuario(usuario);
        setPuesto(puesto);
        setAntiguedad(antiguedad);
        setNumSS(numSS);
    }

    public Empleado (Empleado empleado){
        setNombre(empleado.getNombre());
        setApellidos(empleado.getApellidos());
        setId(empleado.getId());
        setTelefono(empleado.getTelefono());
        setEmail(empleado.getEmail());
        setDireccion(empleado.getDireccion());
        setRef(empleado.getRef());
        setUsuario(empleado.getUsuario());
        setPuesto(empleado.getPuesto());
        setAntiguedad(empleado.getAntiguedad());
        setNumSS(empleado.getNumSS());
    }

    // Fin Constructores

    // Inicio Setters

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public void setId(String id) {
        if (id.equals("")){
            this.id = id;
        } else if (!esDNICorrecto(id)){
            throw new RuntimeException("El valor del DNI no es correcto");
        } else {
            this.id = id;
        }
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    private void setRef (String ref){
        this.ref = ref;
    }

    public void setUsuario (Usuario usuario) {
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

    public String getNombre() {
        return this.nombre;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public String getId() {
        return this.id;
    }

    public String getTelefono() {
        return this.telefono;
    }
    public String getEmail() {
        return this.email;
    }

    public String getDireccion() {
        return this.direccion;
    }
    public String getPuesto() {
        return this.puesto;
    }

    public String getAntiguedad() {
        return this.antiguedad;
    }

    public Usuario getUsuario() {
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

    public boolean esDNICorrecto (String dni){
        final char[] letrasDNI = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};

        if (dni.length() != 9){
            return false;
        } else {
            int numero = Integer.parseInt(dni.substring(0, 8));
            char letra = dni.charAt(8);

            return (letrasDNI[(numero % 23)] == letra);
        }
    }

    public String generadorRef (int num, String ref){
        int digitos = (int)(Math.log10(num)+ 1);
        String refAux = "";
        for (int i = 0; i < (4-digitos); i++){
            refAux = refAux.concat("0");
        }
        return (ref + (refAux) + num);
    }

    // Fin Funciones

}
