package com.Agenda.EmpresaSubcontratada.Entidad;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "empresas")
public class EmpresaSub implements Serializable {

    // Inicio Variables

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int generadorId;

    private static final String refEmpresa = "EMS";

    @Column (name = "nombre")
    private String nombre;
    @Column (name = "tipo")
    private String tipo;
    @Column (name = "id")
    private String id;
    @Column (name = "telefono")
    private String telefono;
    @Column (name = "email")
    private String email;
    @Column (name = "direccion")
    private String direccion;
    @Column (name = "ref")
    private String ref;

    // Fin Variables

    // Inicio Constructores

    public EmpresaSub() {
        setNombre("");
        setTipo("");
        setId("");
        setTelefono("");
        setEmail("");
        setDireccion("");
        setRef("");
    }

    public EmpresaSub(String nombre, String tipo, String id, String telefono, String email, String direccion, int pos){
        setNombre(nombre);
        setTipo(tipo);
        setId(id);
        setTelefono(telefono);
        setEmail(email);
        setDireccion(direccion);
        setRef (generadorRef(++pos, refEmpresa));
    }

    public EmpresaSub(String ref, String nombre, String tipo, String id, String telefono, String email, String direccion){
        setNombre(nombre);
        setTipo(tipo);
        setId(id);
        setTelefono(telefono);
        setEmail(email);
        setDireccion(direccion);
        setRef(ref);
    }

    // Fin Constructores

    // Inicio Setters

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public void setId(String id) {
        if (id.equals("")){
            this.id = id;
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
    private void setRef (String ref){
        this.ref = ref;
    }

    // Fin Setters

    // Inicio Getters

    public String getRef (){
        return this.ref;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getTipo() {
        return this.tipo;
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
