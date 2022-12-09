package com.Application;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomErrorController implements ErrorController {

    private static final String PATH = "/error";

    @RequestMapping (value = PATH)
    public ModelAndView error () {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("pages-error-404.html");
        return modelAndView;
    }
}
