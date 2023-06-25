package com.Facturacion.Nomina.Repository;

import com.Facturacion.Nomina.Entidad.Nomina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface NominaRepository extends JpaRepository<Nomina, Integer> {

    Nomina findNominaByRef (String ref);
    @Query (value = "SELECT generador_id FROM Nominas order by generador_id desc limit 1", nativeQuery = true)
    Integer giveLastId();

}
