package pe.back.core.repositories.jpa.infraestructure.mappers;

import org.mapstruct.Mapper;
import pe.back.core.domain.vo.TicketVO;
import pe.back.core.repositories.jpa.domain.models.Ticket;

@Mapper
public interface TicketMapper {

    Ticket voToEntity(TicketVO ticketVO);

    TicketVO fromEntity(Ticket ticket);

}
