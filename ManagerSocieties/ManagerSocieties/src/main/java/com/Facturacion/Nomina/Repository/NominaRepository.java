package com.Facturacion.Nomina.Repository;

import com.Facturacion.Nomina.Entidad.Nomina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NominaRepository extends JpaRepository<Nomina, Integer> {

    Nomina findNominaByRef (String ref);
    @Query (value = "SELECT generador_id FROM Nominas order by generador_id desc limit 1", nativeQuery = true)
    Integer giveLastId();

    @Query (value = "SELECT CASE WHEN SUM(sueldo_bruto) IS NOT NULL THEN SUM(sueldo_bruto) ELSE 0 END FROM managersocieties.nominas WHERE substring(fecha, 7, 4) = YEAR(CURDATE())", nativeQuery = true)
    double sumNominas();

    @Query (value = "SELECT N.* FROM Nominas N, Empleados E WHERE N.empleado_generador_id = E.generador_id AND E.ref = :ref", nativeQuery = true)
    String[][] findNominasByEmpleado(@Param("ref") String ref);

}
