package com.Calendario.Service;

import com.Calendario.Entidad.Calendario;
import com.Calendario.Evento.Entidad.Evento;
import com.Usuario.Entidad.Usuario;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Service
public class CalendarioService {
    ModelAndView calendariomodel = new ModelAndView();

    Calendario calendario = new Calendario();

    public ModelAndView renderCalendar(Usuario user, List<Evento> eventos){
        calendariomodel.setViewName("calendario.html");
        calendariomodel.addObject("fechaActual", calendario.getFechaActual());
        calendariomodel.addObject("dia", calendario.getDia());
        calendariomodel.addObject("mes", calendario.getMes());
        calendariomodel.addObject("mesEscrito", calendario.getMesEscrito());
        calendariomodel.addObject("anyo", calendario.getAnyo());
        calendariomodel.addObject("semanas", calendario.getSemanasMes());
        calendariomodel.addObject("usuario", user);
        calendariomodel.addObject("eventos", eventos);
        return calendariomodel;
    }

    public ModelAndView renderCalendar(Usuario user, int mes, int anyo, List<Evento> eventos){
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
        calendariomodel.addObject("eventos", eventos);
        return calendariomodel;
    }

}
