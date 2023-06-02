package com.Usuario;

import com.Agenda.Cliente;
import com.Agenda.Empleado;

import java.io.Serializable;

public class Usuario implements Serializable {

    // Inicio Variables
    private String contrasenya;
    private boolean admin;
    private String imagenUrl;

    private Empleado empleado;

    // Fin Variables

    // Inicio Constructores

    public Usuario (){
        this.empleado = new Empleado();
        setAdmin(false);
        setContrasenya("");
        setImagenUrl("");
    }

    public Usuario (Empleado empleado, String contrasenya, boolean admin, String imagenUrl){
        setEmpleado(empleado);
        setContrasenya(contrasenya);
        setAdmin(admin);
        setImagenUrl(imagenUrl);
    }

    // Fin Constructores

    // Inicio Setters

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public void setImagenUrl (String imagenUrl){
        if (imagenUrl != null){
            this.imagenUrl = "/img/" + imagenUrl;
        } else {
            this.imagenUrl = "/img/no-img.jpg";
        }
    }

    public void setEmpleado (Empleado empleado){
        this.empleado = new Empleado(empleado.getRef(), empleado.getNombre(), empleado.getApellidos(), empleado.getId(), empleado.getTelefono(), empleado.getEmail(), empleado.getDireccion(),
                empleado.getUsuario(), empleado.getPuesto(), empleado.getAntiguedad(), empleado.getNumSS());
    }

    // Fin Setters


    // Inicio Getters

    public String getContrasenya() {
        return this.contrasenya;
    }

    public boolean isAdmin() {
        return this.admin;
    }

    public String getImagenUrl(){
        return this.imagenUrl;
    }

    public Empleado getEmpleado(){
        return this.empleado;
    }

    // Fin Getters

    // Inicio Funciones

    // Fin Funciones
}
