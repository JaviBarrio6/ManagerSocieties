package com.Agenda.Cliente.Entidad;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {

    // Inicio Variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int generadorId;
    private static final String refCliente = "CLI";

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
    @Column (name = "premium")
    private boolean premium;

    @Column (name = "ref")
    private String ref;

    // Fin Variables

    // Inicio Constructores

    public Cliente () {
        setNombre("");
        setApellidos("");
        setId("");
        setTelefono("");
        setEmail("");
        setDireccion("");
        setRef("");
        setPremium(false);

    }
    public Cliente(String nombre, String apellidos, String id, String telefono, String email, String direccion, boolean premium, int pos) {
        setNombre(nombre);
        setApellidos(apellidos);
        setId(id);
        setTelefono(telefono);
        setEmail(email);
        setDireccion(direccion);
        setRef (generadorRef(++pos, refCliente));
        setPremium(premium);
    }

    public Cliente(String ref, String nombre, String apellidos, String id, String telefono, String email, String direccion, boolean premium) {
        setNombre(nombre);
        setApellidos(apellidos);
        setId(id);
        setTelefono(telefono);
        setEmail(email);
        setDireccion(direccion);
        setRef(ref);
        setPremium(premium);
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
        } else if (esDni(id)){
            if (!esDNICorrecto(id)){
                throw new RuntimeException("El valor del DNI no es correcto");
            } else {
                this.id = id;
            }
        } else if (!esCIFCorrecto(id)){
            throw new RuntimeException("El valor del CIF no es correcto");
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

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    private void setRef (String ref){
        this.ref = ref;
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
    public String getRef() {
        return this.ref;
    }

    public boolean getPremium() {
        return this.premium;
    }

    // Fin Getters

    // Inicio Funciones

    public boolean esDni (String id){
        return ((int)id.charAt(0) >= 48 && (int)id.charAt(0) <= 57);
    }

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

    public boolean esCIFCorrecto (String cif){
        if (cif.length() != 9){
            return false;
        } else {
            char tipoOrganizacion = cif.charAt(0);
            int codigoProvincia = Integer.parseInt(cif.substring(1, 2));
            int numProvincia = Integer.parseInt(cif.substring(3, 7));
            char digitoLetra = cif.charAt(8);

            return  ((((int)tipoOrganizacion >= 65) && ((int)tipoOrganizacion < 73)) || ((int)tipoOrganizacion >= 75) && ((int)tipoOrganizacion < 83));
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
