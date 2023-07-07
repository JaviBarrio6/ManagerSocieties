package com.Facturacion.Factura.Repository;

import com.Facturacion.Factura.Entidad.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FacturasRepository extends JpaRepository<Factura, Integer> {

    Factura findFacturaByRef (String ref);
    @Query(value = "SELECT generador_id FROM Facturas order by generador_id desc limit 1", nativeQuery = true)
    Integer giveLastId();

    @Query(value = "SELECT CASE WHEN SUM(precio) IS NOT NULL THEN SUM(precio) ELSE 0 END FROM managersocieties.facturas WHERE substring(fecha, 7, 4) = YEAR(CURDATE())", nativeQuery = true)
    double sumIngresos();

    @Query(value = "SELECT CASE WHEN SUM(precio) IS NOT NULL THEN SUM(precio) ELSE 0 END FROM managersocieties.facturas " +
            "WHERE (substring(fecha, 4, 2) = :mes) and (substring(fecha, 7, 4) = YEAR(CURDATE()))", nativeQuery = true)
    double ingresosMes (@Param("mes") String mes);

    @Query(value = "SELECT sum(precio), F.cliente_generador_id, C.generador_id, C.nombre, C.apellidos " +
            "FROM managersocieties.facturas F, managersocieties.clientes C " +
            "WHERE F.cliente_generador_id = C.generador_id and (substring(F.fecha, 7, 4) = YEAR(CURDATE())) " +
            "GROUP BY F.cliente_generador_id ORDER BY sum(precio) DESC", nativeQuery = true)
    String[][] obtenerIngresosPorCliente ();

    @Query(value = "SELECT COUNT(productos_generador_id) FROM managersocieties.facturas_productos, managersocieties.facturas \n" +
            "WHERE generador_id = factura_generador_id AND (substring(fecha, 7, 4) = YEAR(curdate())) AND (substring(fecha, 4, 2) = MONTH(curdate())) " +
            "AND (substring(fecha, 1, 4) = DAY(curdate()))", nativeQuery = true)
    int numVentasHoy ();

    @Query(value = "SELECT COUNT(productos_generador_id) FROM managersocieties.facturas_productos, managersocieties.facturas \n" +
            "WHERE generador_id = factura_generador_id AND (substring(fecha, 7, 4) = YEAR(curdate())) AND (substring(fecha, 4, 2) = MONTH(curdate()))", nativeQuery = true)
    int numVentasEsteMes ();

    @Query(value = "SELECT COUNT(productos_generador_id) FROM managersocieties.facturas_productos, managersocieties.facturas \n" +
            "WHERE generador_id = factura_generador_id AND (substring(fecha, 7, 4) = YEAR(curdate()))", nativeQuery = true)
    int numVentasEsteAnyo ();

    @Query(value = "SELECT CASE WHEN SUM(precio) IS NOT NULL THEN SUM(precio) ELSE 0 END FROM managersocieties.facturas " +
            "WHERE (substring(fecha, 4, 2) = MONTH(CURDATE())) and (substring(fecha, 7, 4) = YEAR(CURDATE())) " +
            "AND (substring(fecha, 1, 4) = DAY(curdate()))", nativeQuery = true)
    double ingresosHoy ();

    @Query(value = "SELECT CASE WHEN SUM(precio) IS NOT NULL THEN SUM(precio) ELSE 0 END FROM managersocieties.facturas " +
            "WHERE (substring(fecha, 4, 2) = MONTH(CURDATE())) and (substring(fecha, 7, 4) = YEAR(CURDATE()))", nativeQuery = true)
    double ingresosEsteMes ();

    @Query(value = "SELECT CASE WHEN SUM(precio) IS NOT NULL THEN SUM(precio) ELSE 0 END FROM managersocieties.facturas " +
            "WHERE (substring(fecha, 7, 4) = YEAR(CURDATE()))", nativeQuery = true)
    double ingresosEsteAnyo ();

    @Query(value = "SELECT * FROM managersocieties.facturas WHERE (substring(fecha, 4, 2) = MONTH(CURDATE())) AND " +
            "(substring(fecha, 7, 4) = YEAR(CURDATE())) AND (substring(fecha, 1, 4) = DAY(curdate()))", nativeQuery = true)
    List<Factura> facturasHoy ();

    @Query(value = "SELECT P.url_foto, P.modelo, P.precio, count(FP.productos_generador_id), P.precio * count(FP.productos_generador_id)\n" +
            "FROM managersocieties.facturas_productos FP, managersocieties.facturas F, managersocieties.productos P \n" +
            "WHERE F.generador_id = FP.factura_generador_id and FP.productos_generador_id = P.generador_id AND " +
            "(substring(fecha, 7, 4) = YEAR(CURDATE())) group by FP.productos_generador_id " +
            "ORDER BY count(FP.productos_generador_id) DESC;", nativeQuery = true)
    String[][] getTable();
}