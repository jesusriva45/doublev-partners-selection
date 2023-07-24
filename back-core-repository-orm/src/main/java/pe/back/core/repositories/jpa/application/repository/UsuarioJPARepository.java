package pe.back.core.repositories.jpa.application.repository;

import org.springframework.data.repository.CrudRepository;
import pe.back.core.repositories.jpa.domain.models.Usuario;

import java.util.Optional;

public interface UsuarioJPARepository extends CrudRepository<Usuario, Long> {

    Optional<Usuario> findByIdentificacion(String identificacion);

}
