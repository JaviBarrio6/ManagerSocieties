package com.Inventario.Producto.Repository;

import com.Inventario.Producto.Entidad.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductosRepository extends JpaRepository<Producto, Integer> {

    Producto findProductoByRef (String ref);

    @Query(value = "SELECT generador_id FROM Productos order by generador_id desc limit 1", nativeQuery = true)
    Integer giveLastId();

}