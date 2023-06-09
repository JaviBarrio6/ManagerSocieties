package com.Usuario.Service;

import com.Agenda.Empleado.Entidad.Empleado;
import com.Usuario.Entidad.Usuario;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Service
public class UsuarioService {
    ModelAndView usuariosModel = new ModelAndView();

    public ModelAndView loginPage(boolean credenciales){
        usuariosModel.setViewName("pages-login.html");
        usuariosModel.addObject("credenciales", credenciales);
        return usuariosModel;
    }

    public Usuario login (String username, String password, List<Usuario> usuarios){
        for (Usuario usuario: usuarios){
            if (usuario.getUsername().equals(username)){
                if (usuario.getContrasenya().equals(password)){
                    return usuario;
                }
            }
        }
        return null;
    }

    public ModelAndView registerPage(List<Empleado> empleados){
        usuariosModel.setViewName("pages-register.html");
        usuariosModel.addObject("usuarios", empleados);
        return usuariosModel;
    }
}
