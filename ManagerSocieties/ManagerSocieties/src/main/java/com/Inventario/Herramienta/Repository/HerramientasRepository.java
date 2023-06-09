package com.Inventario.Herramienta.Repository;

import com.Inventario.Herramienta.Entidad.Herramienta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HerramientasRepository extends JpaRepository<Herramienta, Integer> {

    Herramienta findHerramientaByRef (String ref);

    @Query(value = "SELECT generador_id FROM Herramientas order by generador_id desc limit 1", nativeQuery = true)
    Integer giveLastId ();

}
