package com.Facturacion.Albaran.Repository;

import com.Facturacion.Albaran.Entidad.Albaran;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface AlbaranesRepository extends JpaRepository<Albaran, Integer> {

    Albaran findAlbaranByRef (String ref);
    @Query(value = "SELECT generador_id FROM Albaranes order by generador_id desc limit 1", nativeQuery = true)
    Integer giveLastId();

}

