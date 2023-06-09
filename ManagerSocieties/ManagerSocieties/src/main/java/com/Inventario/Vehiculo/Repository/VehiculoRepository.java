package com.Inventario.Vehiculo.Repository;

import com.Inventario.Vehiculo.Entidad.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Integer> {

    Vehiculo findVehiculoByRef (String ref);

    @Query(value = "SELECT generador_id FROM Vehiculos order by generador_id desc limit 1", nativeQuery = true)
    Integer giveLastId();

}
