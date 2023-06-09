package com.Controllers;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class CustomErrorController implements ErrorController {

    private static final String PATH = "/error";

    @RequestMapping (value = PATH)
    public ModelAndView handleError(HttpServletResponse response) throws IOException {
        int status = response.getStatus();
        ModelAndView modelAndView = new ModelAndView();
        switch (status) {
            case 400:
                modelAndView.addObject("msg", "El Servidor no ha podido interpretar su solicitud");
                break;

            case 401:
                modelAndView.addObject("msg", "Usted no está Autentificado");
                break;

            case 403:
                modelAndView.addObject("msg", "Usted no posee los permisos necesarios");
                break;

            case 404:
                modelAndView.addObject("msg", "La página que usted busca no existe");
                break;

            case 408:
                modelAndView.addObject("msg", "El tiempo de espera de conexión con el Servidor ha sido superado");
                break;

            case 500:
                modelAndView.addObject("msg", "Se ha producido un Error interno del Servidor");
                break;

            case 502:
                modelAndView.addObject("msg", "El Servidor está caído");
                break;
        }
        modelAndView.addObject("error", status);
        modelAndView.setViewName("pages-error.html");
        return modelAndView;

    }
}
