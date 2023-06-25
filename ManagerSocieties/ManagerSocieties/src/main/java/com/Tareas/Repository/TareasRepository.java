package com.Tareas.Repository;

import com.Agenda.Empleado.Entidad.Empleado;
import com.Tareas.Entidad.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TareasRepository extends JpaRepository<Tarea, Integer> {

    Tarea findTareaByRef (String ref);

    @Query(value = "SELECT generador_id FROM Tareas order by generador_id desc limit 1", nativeQuery = true)
    Integer giveLastId ();

    @Query (value = "SELECT * FROM Empleados WHERE generador_id <> Tareas_Empleados.empleados_generador_id", nativeQuery = true)
    List<Empleado> findEmpleadosLibres();

    List<Tarea> findAllByEstadoIsNot (int estado);

}
