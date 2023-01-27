package com.Application;

import com.Calendario.Calendario;
import com.Usuario.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import java.util.Calendar;

@Controller
public class CalendarioController {
    ModelAndView calendariomodel = new ModelAndView();

    Calendario calendario = new Calendario();

    public ModelAndView renderCalendar(Usuario user){
        calendariomodel.setViewName("calendario.html");
        calendariomodel.addObject("fechaActual", calendario.getFechaActual());
        calendariomodel.addObject("dia", calendario.getDia());
        calendariomodel.addObject("mes", calendario.getMes());
        calendariomodel.addObject("mesEscrito", calendario.getMesEscrito());
        calendariomodel.addObject("anyo", calendario.getAnyo());
        calendariomodel.addObject("semanas", calendario.getSemanasMes());
        calendariomodel.addObject("usuario", user);
        return calendariomodel;
    }

    public ModelAndView renderCalendar(Usuario user, int mes, int anyo){
        Calendario calendar;
        if (mes > 12){
            calendar = new Calendario(1, 1, (anyo + 1));
        } else if (mes == 0){
            calendar = new Calendario(1, 12, (anyo - 1));
        } else {
            calendar = new Calendario(1, mes, anyo);
        }

        calendariomodel.setViewName("calendario.html");
        calendariomodel.addObject("fechaActual", calendario.getFechaActual());
        calendariomodel.addObject("dia", calendar.getDia());
        calendariomodel.addObject("mes", calendar.getMes());
        calendariomodel.addObject("mesEscrito", calendar.getMesEscrito());
        calendariomodel.addObject("anyo", calendar.getAnyo());
        calendariomodel.addObject("semanas", calendar.getSemanasMes());
        calendariomodel.addObject("usuario", user);
        return calendariomodel;
    }


}
