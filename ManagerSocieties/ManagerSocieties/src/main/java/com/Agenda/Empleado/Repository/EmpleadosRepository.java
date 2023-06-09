package com.Agenda.Empleado.Repository;

import com.Agenda.Empleado.Entidad.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadosRepository extends JpaRepository<Empleado, Integer> {

    Empleado findEmpleadoByRef (String ref);

    @Query (value = "SELECT generador_id FROM Empleados order by generador_id desc limit 1", nativeQuery = true)
    Integer giveLastId ();

    @Query (value = "SELECT * FROM Empleados WHERE usuario_generador_id IS NULL", nativeQuery = true)
    List<Empleado> findEmpleadosWithoutUser();


}
