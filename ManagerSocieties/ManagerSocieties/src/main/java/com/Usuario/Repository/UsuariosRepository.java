package com.Usuario.Repository;

import com.Usuario.Entidad.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {

    Usuario findByUsername (String username);

}
