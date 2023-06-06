package com.Repositories;

import com.Agenda.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@org.springframework.stereotype.Repository
public interface ClientesRepository extends JpaRepository<Cliente, String> {

    Cliente findClienteByRef (String ref);
    int searchClientesById(String id);

}
