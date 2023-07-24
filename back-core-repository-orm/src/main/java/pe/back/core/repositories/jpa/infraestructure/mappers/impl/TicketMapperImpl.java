package pe.back.core.repositories.jpa.infraestructure.mappers.impl;

import org.springframework.stereotype.Component;
import pe.back.core.application.repositories.TicketRepository;
import pe.back.core.domain.vo.TicketVO;
import pe.back.core.domain.vo.UsuarioVO;
import pe.back.core.repositories.jpa.domain.models.Ticket;
import pe.back.core.repositories.jpa.domain.models.Usuario;
import pe.back.core.repositories.jpa.infraestructure.mappers.TicketMapper;

import javax.annotation.processing.Generated;

@Generated(
        value = "org.mapstruct.ap.MappingProcessor"
)
@Component
public class TicketMapperImpl implements TicketMapper {

    @Override
    public Ticket voToEntity(TicketVO ticketVO) {

        Ticket ticketEntity = new Ticket();

        ticketEntity.setIdTicket(ticketVO.getIdTicket());
        ticketEntity.setFechaCreacion(ticketVO.getFechaCreacion());
        ticketEntity.setFechaActualizacion(ticketVO.getFechaActualizacion());
        ticketEntity.setEstado(ticketVO.getEstado());

        Usuario usuario = new Usuario();
        usuario.setIdUsuario(ticketVO.getUsuario().getIdUsuario());
        usuario.setNombre(ticketVO.getUsuario().getNombre());
        usuario.setApellido(ticketVO.getUsuario().getApellido());
        usuario.setIdentificacion(ticketVO.getUsuario().getIdentificacion());

        ticketEntity.setUsuario(usuario);


        return ticketEntity;
    }

    @Override
    public TicketVO fromEntity(Ticket ticket) {

        TicketVO ticketVO = new TicketVO();

        ticketVO.setIdTicket(ticket.getIdTicket());
        ticketVO.setFechaCreacion(ticket.getFechaCreacion());
        ticketVO.setFechaActualizacion(ticket.getFechaActualizacion());
        ticketVO.setEstado(ticket.getEstado());

        UsuarioVO usuarioVO = new UsuarioVO();
        usuarioVO.setIdUsuario(ticket.getUsuario().getIdUsuario());
        usuarioVO.setNombre(ticket.getUsuario().getNombre());
        usuarioVO.setApellido(ticket.getUsuario().getApellido());
        usuarioVO.setIdentificacion(ticket.getUsuario().getIdentificacion());

        ticketVO.setUsuario(usuarioVO);


        return ticketVO;
    }
}
