package pe.doublev.partners.api.rest.infraestructure.controllers;

import org.springframework.beans.support.PagedListHolder;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pe.back.core.domain.response.PaginationResponse;
import pe.back.core.domain.vo.TicketVO;
import pe.doublev.partners.api.rest.application.service.TicketService;
import pe.doublev.partners.api.rest.domain.request.ConsultaTicketPaginationRequest;

import java.util.List;

@RestController
public class ConsultarTicketPaginacionController {

    private final TicketService ticketService;

    public ConsultarTicketPaginacionController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    private final static String SORT_ID_TICKET= "idTicket";

    @GetMapping("/listar-tickets-por-campo")
    public ResponseEntity<PaginationResponse> listarTicketPorCampo(@RequestBody ConsultaTicketPaginationRequest request) {

        if(request.getFieldName() == null || request.getFieldName().trim().equals("")){
            request.setFieldName(SORT_ID_TICKET);
        }

        List<TicketVO> listPaginated = ticketService.listAllTicketPaginedByFielName(request.getFieldName());

        PaginationResponse response = new PaginationResponse();

        response.setTotalElements(listPaginated.size());
        response.setResponse(listPaginated);

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @GetMapping("/paginacion-ticket")
    public ResponseEntity<PaginationResponse> paginacionTicket(@RequestBody ConsultaTicketPaginationRequest request) {

        if(request.getFieldName() == null || request.getFieldName().trim().equals("")){
            request.setFieldName(SORT_ID_TICKET);
        }

        PaginationResponse listPaginated = ticketService.listAllTicketWithPaginationAndSorting(
                request.getIdTicket(),
                request.getOffset(),
                request.getPageSize(),
                request.getFieldName());


        return new ResponseEntity<>(listPaginated, HttpStatus.OK);

    }
}
