package com.Usuario;
import com.Agenda.Empleado;

import java.util.LinkedHashMap;

public class Usuarios {
    public LinkedHashMap<String, Usuario> usuarios = new LinkedHashMap<>();


    Usuario usuario01 = new Usuario(new Empleado("EMP0004","Javier", "Barrio", "53852636E", "608844077",
            "barriomartinjavier@gmail.com","Av. Guadarama 21, S.S. de los Reyes", "jbarrio", "CEO", 10), "1234",
            true, "profile-img.jpg");

    Usuario usuario02 = new Usuario(new Empleado("EMP0002","Paco", "López", "53852030Z", "674851283", "plopez@gmail.com",
            "Av. Guadarama 21, S.S. de los Reyes", "plopez", "Repartidor", 0), "1234",
            false, "profile-img.jpg");

    Usuario usuario03 = new Usuario(new Empleado("EMP0005","María del Mar", "Martín", "53852636E", "607849292", "superlux@superlux.com",
            "C. Enriq Prat de la Riba", "mmar", "CEO", 30), "1234",
            true, "profile-img-mmar.jpg");

    public Usuarios () {
        this.usuarios.put(usuario01.getEmpleado().getUsuario(), usuario01);
        this.usuarios.put(usuario02.getEmpleado().getUsuario(), usuario02);
        this.usuarios.put(usuario03.getEmpleado().getUsuario(), usuario03);
    }

    public void editarUsuario (String user, String ref, String nombre, String apellidos, String dni, String telefono, String email,
                               String direccion, String antiguedad, String puesto, String imagen){
        this.usuarios.put(user, new Usuario(new Empleado(ref, nombre, apellidos, dni, telefono, email, direccion, user, puesto,
                Integer.parseInt(antiguedad)), this.usuarios.get(user).getContrasenya(), this.usuarios.get(user).isAdmin(), imagen));
    }

    public void editarContrasenya (String user, String currentPassword, String newPassword){
        if (this.usuarios.get(user).getContrasenya().equals(currentPassword)){
            this.usuarios.get(user).setContrasenya(newPassword);
        }
    }
}
