package pe.back.core.repositories.jpa.application.repository.impl;

import org.springframework.stereotype.Repository;
import pe.back.core.application.repositories.UsuarioRepository;
import pe.back.core.domain.vo.TicketVO;
import pe.back.core.domain.vo.UsuarioVO;
import pe.back.core.repositories.jpa.application.repository.UsuarioJPARepository;
import pe.back.core.repositories.jpa.infraestructure.mappers.UsuarioMapper;

import java.util.Optional;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepository {

    private final UsuarioJPARepository repository;

    private final UsuarioMapper usuarioMapper;

    public UsuarioRepositoryImpl(UsuarioJPARepository UsuarioJPARepository, UsuarioMapper usuarioMapper) {
        this.repository = UsuarioJPARepository;
        this.usuarioMapper = usuarioMapper;
    }


    @Override
    public Optional<UsuarioVO> getUsuarioByIdentificacion(String nroIdentificacion) {

        Optional<UsuarioVO> usuarioVo = repository.findByIdentificacion(nroIdentificacion)
                .map(this.usuarioMapper::fromEntity);

        return usuarioVo;
    }

    @Override
    public Optional<UsuarioVO> saveUsuario(UsuarioVO usuarioVO) {
        Optional<UsuarioVO> usuario = Optional.ofNullable(this.usuarioMapper.fromEntity(repository.save(this.usuarioMapper.voToEntity(usuarioVO))));

        if (usuario.isEmpty()) {
            return Optional.empty();
        }

        return usuario;
    }
}
