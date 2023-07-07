package com.Dashboard.Repository;

import com.Dashboard.Entidad.Actividad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActividadesRepositoy extends JpaRepository<Actividad, Integer> {


    @Query(value = "SELECT * FROM managersocieties.actividades WHERE (substring(fecha, 7, 4) = YEAR(curdate())) " +
            "AND (substring(fecha, 4, 2) = MONTH(curdate())) AND (substring(fecha, 1, 4) = DAY(curdate()))" +
            "ORDER BY generador_id DESC LIMIT 15", nativeQuery = true)
    List<Actividad> findActividadesHoy ();
}
