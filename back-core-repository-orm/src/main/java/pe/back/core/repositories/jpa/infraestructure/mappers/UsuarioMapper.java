package pe.back.core.repositories.jpa.infraestructure.mappers;

import org.mapstruct.Mapper;
import pe.back.core.domain.vo.UsuarioVO;
import pe.back.core.repositories.jpa.domain.models.Usuario;

@Mapper
public interface UsuarioMapper {

    Usuario voToEntity(UsuarioVO usuarioDTO);

    UsuarioVO fromEntity(Usuario usuario);

}
