package com.Repositories;

import com.Agenda.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadosRepository extends JpaRepository<Empleado, Integer> {

    Empleado findEmpleadoByRef (String ref);

    @Query (value = "SELECT generador_id FROM Empleados order by generador_id desc limit 1", nativeQuery = true)
    int giveLastId ();


}
