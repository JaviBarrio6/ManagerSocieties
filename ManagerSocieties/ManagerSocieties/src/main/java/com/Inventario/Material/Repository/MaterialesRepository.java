package com.Inventario.Material.Repository;

import com.Inventario.Maquina.Entidad.Maquina;
import com.Inventario.Material.Entidad.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MaterialesRepository extends JpaRepository<Material, Integer> {

    Material findMaterialByRef (String ref);

    @Query(value = "SELECT generador_id FROM Materiales order by generador_id desc limit 1", nativeQuery = true)
    Integer giveLastId();
}