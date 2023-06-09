package com.Agenda.Proveedor.Repository;

import com.Agenda.Proveedor.Entidad.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedoresRepository extends JpaRepository<Proveedor, Integer> {

    Proveedor findProveedorByRef (String ref);

    @Query(value = "SELECT generador_id FROM Proveedores order by generador_id desc limit 1", nativeQuery = true)
    Integer giveLastId ();

}
