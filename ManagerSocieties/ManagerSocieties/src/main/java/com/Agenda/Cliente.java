package com.Agenda;

import java.io.Serializable;

public class Cliente extends Persona implements Serializable {

    public static int generadorId = 0;
    public final char[] letrasDNI = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};

    private boolean premium;
    private String ref;

    public Cliente () {
        super ("", "", "", "", "", "");
        this.ref = "";
        this.premium = false;

    }
    public Cliente(String nombre, String apellidos, String id, String telefono, String email, String direccion, boolean premium) {
        super(nombre, apellidos, id, telefono, email, direccion);
        if (esDni(id)){
            if (!esDNICorrecto(id)){
                throw new RuntimeException("El valor del DNI o del CIF no es correcto");
            }
        } else if (!esCIFCorrecto(id)) {
            throw new RuntimeException("El valor del DNI o del CIF no es correcto");
        }

        generadorId++;
        int digitos = (int)(Math.log10(generadorId)+ 1);
        String refAux = "";
        for (int i = 0; i < (4-digitos); i++){
            refAux = refAux.concat("0");
        }
        this.ref = "CLI" + (refAux) + generadorId;
        this.premium = premium;
    }

    public boolean esDNICorrecto (String dni){
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

    public boolean esDni (String id){
        return ((int)id.charAt(0) >= 48 && (int)id.charAt(0) <= 57);
    }

    public char[] getLetrasDNI() {
        return letrasDNI;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    public String getRef() {
        return this.ref;
    }

    public boolean getPremium() {
        return this.premium;
    }

    public void editarCliente (String nombre, String apellidos, String id, String telefono, String correo, String dir, boolean premium) {
        setNombre(nombre);
        setApellidos(apellidos);
        setId(id);
        setTelefono(telefono);
        setEmail(correo);
        setDireccion(dir);
        setPremium(premium);
    }
}
