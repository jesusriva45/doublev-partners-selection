package pe.back.core.application.repositories;

import org.springframework.data.domain.Page;
import pe.back.core.domain.vo.TicketVO;

import java.util.List;
import java.util.Optional;

public interface TicketRepository {

    Optional<TicketVO> saveTicket(TicketVO ticketVO);

    Optional<TicketVO> updateTicket(TicketVO ticketVO);

    void deleteTicket(Long idTicket);

    Optional<TicketVO> findTicketById(Long idTicket);

    List<TicketVO> listAllTicketPaginedByFielName(String fieldName);

    List<TicketVO> listAllTicket();



}
