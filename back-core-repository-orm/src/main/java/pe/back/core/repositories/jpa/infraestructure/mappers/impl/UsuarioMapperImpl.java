package pe.back.core.repositories.jpa.infraestructure.mappers.impl;

import org.springframework.stereotype.Component;
import pe.back.core.domain.vo.UsuarioVO;
import pe.back.core.repositories.jpa.domain.models.Usuario;
import pe.back.core.repositories.jpa.infraestructure.mappers.UsuarioMapper;

import javax.annotation.processing.Generated;

@Generated(
        value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class UsuarioMapperImpl implements UsuarioMapper {
    @Override
    public Usuario voToEntity(UsuarioVO usuarioVO) {

        Usuario usuario = new Usuario();

        usuario.setIdUsuario(usuarioVO.getIdUsuario());
        usuario.setNombre(usuarioVO.getNombre());
        usuario.setApellido(usuarioVO.getApellido());
        usuario.setIdentificacion(usuarioVO.getIdentificacion());

        return usuario;
    }

    @Override
    public UsuarioVO fromEntity(Usuario usuario) {

        UsuarioVO usuarioVo = new UsuarioVO();

        usuarioVo.setIdUsuario(usuario.getIdUsuario());
        usuarioVo.setNombre(usuario.getNombre());
        usuarioVo.setApellido(usuario.getApellido());
        usuarioVo.setIdentificacion(usuario.getIdentificacion());

        return usuarioVo;
    }
}
