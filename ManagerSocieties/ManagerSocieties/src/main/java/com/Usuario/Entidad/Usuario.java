package com.Usuario.Entidad;

import com.Agenda.Empleado.Entidad.Empleado;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table (name = "usuarios")
public class Usuario implements Serializable {

    // Inicio Variables

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int generadorId;
    @Column
    private String username;
    @Column
    private String contrasenya;
    @Column
    private boolean admin;
    @Column
    private String imagenUrl;

    @OneToOne
    private Empleado empleado;

    // Fin Variables

    // Inicio Constructores

    public Usuario (){
        setUsername("");
        setAdmin(false);
        setContrasenya("");
        setImagenUrl("");
        setEmpleado(null);
    }

    public Usuario (String username, String contrasenya, boolean admin, String imagenUrl, Empleado empleado){
        setUsername(username);
        setContrasenya(contrasenya);
        setAdmin(admin);
        setImagenUrl(imagenUrl);
        setEmpleado(empleado);
    }

    // Fin Constructores

    // Inicio Setters

    public void setUsername (String username){this.username = username;}

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
        this.empleado = empleado;
    }


    // Fin Setters


    // Inicio Getters

    public String getUsername(){
        return this.username;
    }

    public String getContrasenya() {
        return this.contrasenya;
    }

    public boolean isAdmin() {
        return this.admin;
    }

    public String getImagenUrl(){
        return this.imagenUrl;
    }

    public Empleado getEmpleado() {
        return this.empleado;
    }

    // Fin Getters

    // Inicio Funciones

    // Fin Funciones
}
