package pe.doublev.partners.api.rest.application.service;

import org.springframework.beans.support.PagedListHolder;
import org.springframework.data.domain.Page;
import pe.back.core.domain.response.PaginationResponse;
import pe.back.core.domain.vo.TicketVO;

import java.util.List;
import java.util.Optional;

public interface TicketService {

    Optional<TicketVO> saveTicket(TicketVO ticketVO);

    Optional<TicketVO> updateTicket(TicketVO ticketVO);

    void deleteTicket(Long idTicket);

    List<TicketVO> listAllTicketPaginedByFielName(String fieldName);

    PaginationResponse listAllTicketWithPaginationAndSorting(Long idTicket, int offset, int pageSize, String fieldName);
}
