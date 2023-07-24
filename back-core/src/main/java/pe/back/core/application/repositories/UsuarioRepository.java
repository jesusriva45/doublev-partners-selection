package pe.back.core.application.repositories;

import pe.back.core.domain.vo.UsuarioVO;

import java.util.Optional;

public interface UsuarioRepository {

    Optional<UsuarioVO> getUsuarioByIdentificacion(String nroIdentificacion);

    Optional<UsuarioVO> saveUsuario(UsuarioVO usuarioVO);

}
