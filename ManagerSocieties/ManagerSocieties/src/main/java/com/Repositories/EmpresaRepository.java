package com.Repositories;

import com.Usuario.Entidad.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository <Empresa, Integer> {

    Empresa findEmpresaByCif (String cif);

    @Query(value = "SELECT * FROM Empresa limit 1", nativeQuery = true)
    Empresa getEmpresa ();
}
