package com.Agenda.Cliente.Repository;

import com.Agenda.Cliente.Entidad.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface ClientesRepository extends JpaRepository<Cliente, Integer> {

    Cliente findClienteByRef (String ref);

    @Query (value = "SELECT count(id) FROM Clientes WHERE SUBSTRING(id, 1, 1)", nativeQuery = true)
    int countPeople ();

    @Query (value = "SELECT generador_id FROM Clientes order by generador_id desc limit 1", nativeQuery = true)
    Integer giveLastId();

}
