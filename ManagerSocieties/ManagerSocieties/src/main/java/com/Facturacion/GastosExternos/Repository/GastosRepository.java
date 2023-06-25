package com.Facturacion.GastosExternos.Repository;

import com.Facturacion.GastosExternos.Entidad.Gasto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GastosRepository extends JpaRepository<Gasto, Integer> {

    Gasto findGastoByRef (String ref);
    @Query (value = "SELECT generador_id FROM Gastos order by generador_id desc limit 1", nativeQuery = true)
    Integer giveLastId();

}
