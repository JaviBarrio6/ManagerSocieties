package com.Agenda.EmpresaSubcontratada.Repository;

import com.Agenda.EmpresaSubcontratada.Entidad.EmpresaSub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresasRepository extends JpaRepository<EmpresaSub, Integer> {

    EmpresaSub findEmpresaByRef (String ref);

    @Query(value = "SELECT generador_id FROM Empresas order by generador_id desc limit 1", nativeQuery = true)
    Integer giveLastId ();

}
