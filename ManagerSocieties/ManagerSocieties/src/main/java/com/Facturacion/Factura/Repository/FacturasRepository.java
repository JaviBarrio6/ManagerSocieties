package com.Facturacion.Factura.Repository;

import com.Facturacion.Factura.Entidad.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FacturasRepository extends JpaRepository<Factura, Integer> {

    Factura findFacturaByRef (String ref);
    @Query(value = "SELECT generador_id FROM Facturas order by generador_id desc limit 1", nativeQuery = true)
    Integer giveLastId();

    @Query(value = "SELECT SUM(precio) FROM managersocieties.facturas WHERE substring(fecha, 7, 4) = YEAR(CURDATE())", nativeQuery = true)
    double sumIngresos();

    @Query(value = "SELECT CASE WHEN SUM(precio) IS NOT NULL THEN SUM(precio) ELSE 0 END FROM managersocieties.facturas " +
            "WHERE (substring(fecha, 4, 2) = :mes) and (substring(fecha, 7, 4) = YEAR(CURDATE()))", nativeQuery = true)
    double ingresosMes (@Param("mes") String mes);

    @Query(value = "SELECT sum(precio), F.cliente_generador_id, C.generador_id, C.nombre, C.apellidos " +
            "FROM managersocieties.facturas F, managersocieties.clientes C " +
            "WHERE F.cliente_generador_id = C.generador_id and (substring(F.fecha, 7, 4) = YEAR(CURDATE())) " +
            "GROUP BY F.cliente_generador_id ORDER BY sum(precio) DESC", nativeQuery = true)
    String[][] obtenerIngresosPorCliente ();

}