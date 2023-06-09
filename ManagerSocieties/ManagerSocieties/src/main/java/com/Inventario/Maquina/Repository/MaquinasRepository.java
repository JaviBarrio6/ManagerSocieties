package com.Inventario.Maquina.Repository;

import com.Inventario.Maquina.Entidad.Maquina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MaquinasRepository extends JpaRepository<Maquina, Integer> {

    Maquina findMaquinaByRef (String ref);

    @Query (value = "SELECT generador_id FROM Maquinas order by generador_id desc limit 1", nativeQuery = true)
    Integer giveLastId();

}