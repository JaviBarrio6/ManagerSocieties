package com.Calendario.Evento.Repository;

import com.Calendario.Evento.Entidad.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EventosRepository extends JpaRepository<Evento, Integer> {

    Evento findEventoByRef (String ref);

    Evento findEventoByRefTarea (String ref);

    @Query(value = "SELECT generador_id FROM Eventos order by generador_id desc limit 1", nativeQuery = true)
    Integer giveLastId ();
}
