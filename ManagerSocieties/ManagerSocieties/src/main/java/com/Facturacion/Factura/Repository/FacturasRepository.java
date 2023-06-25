package com.Facturacion.Factura.Repository;

import com.Facturacion.Factura.Entidad.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FacturasRepository extends JpaRepository<Factura, Integer> {

    Factura findFacturaByRef (String ref);
    @Query(value = "SELECT generador_id FROM Facturas order by generador_id desc limit 1", nativeQuery = true)
    Integer giveLastId();

}