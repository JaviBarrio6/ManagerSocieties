package com.Calendario.Evento;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Eventos {
    public LinkedHashMap <String, Evento> eventos = new LinkedHashMap<>();

    Evento evento01 = new Evento("", "Reunión", "2023-01-12", null, "11:00", "12:00");
    Evento evento02 = new Evento("", "Comida", "2023-01-27", null, "13:00", "14:00");
    Evento evento03 = new Evento("", "Fiesta", "2023-02-03", null, "13:00", "14:00");

    public Eventos(){
        this.eventos.put(evento01.getRef(), evento01);
        this.eventos.put(evento02.getRef(), evento02);
        this.eventos.put(evento03.getRef(), evento03);
    }

    public Eventos dameEventos (ArrayList<String> refTareas){
        Eventos eventosAux = new Eventos();
        for (Evento evento: this.eventos.values()){
           if (!refTareas.contains(evento.getRefTarea())) {
               eventosAux.eventos.remove(evento.getRef());
           }
        }
        return eventosAux;
    }
}
