package com.Controllers;

import com.Agenda.Empleado;
import com.Agenda.Empleados;
import com.Usuario.Usuario;
import com.Usuario.Usuarios;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

public class UsuarioController {

    Usuarios usuarios = new Usuarios();

    Empleados empleados = new Empleados();

    ModelAndView usuariosModel = new ModelAndView();

    public ModelAndView loginPage(boolean credenciales){
        usuariosModel.setViewName("pages-login.html");
        usuariosModel.addObject("credenciales", credenciales);
        return usuariosModel;
    }

    public boolean login(String usuario, String password){
        if (this.usuarios.usuarios.containsKey(usuario)){
            return usuarios.usuarios.get(usuario).getContrasenya().equals(password);
        } else {
            return false;
        }
    }

    public ModelAndView registerPage(){
        ArrayList<Empleado> empleadosSinUsuario = new ArrayList<>();
        for (Empleado empleado: empleados.empleados.values()){
            if (!usuarios.usuarios.containsKey(empleado.getUsuario())){
                empleadosSinUsuario.add(empleado);
            }
        }
        usuariosModel.setViewName("pages-register.html");
        usuariosModel.addObject("usuarios", empleadosSinUsuario);
        return usuariosModel;
    }

    public ModelAndView register(String ref, String usuario, String password, boolean admin) {
        Empleado empleado = empleados.empleados.get(ref);
        Usuario usuarioAux = new Usuario(empleado, password, admin, "");
        usuarios.usuarios.put(usuario, usuarioAux);
        return usuariosModel;
    }

    public Usuario dameUsuario (String usuario, String password) {
        if (usuarios.usuarios.containsKey(usuario)) {
            if (usuarios.usuarios.get(usuario).getContrasenya().equals(password)) {
                return usuarios.usuarios.get(usuario);
            }
        }
        return null;
    }

    public void editarUsuario (Usuario usuario, String nombre, String apellidos, String dni, String telefono, String email,
                               String direccion, String antiguedad, String puesto, String imagen){
        usuarios.editarUsuario(usuario.getEmpleado().getUsuario(), usuario.getEmpleado().getRef(), nombre, apellidos, dni, telefono, email, direccion, antiguedad, puesto, imagen);
    }

    public void editarContrasenya (Usuario usuario, String currentPassword, String newPassword){
        usuarios.editarContrasenya(usuario.getEmpleado().getUsuario(), currentPassword, newPassword);
    }
}
