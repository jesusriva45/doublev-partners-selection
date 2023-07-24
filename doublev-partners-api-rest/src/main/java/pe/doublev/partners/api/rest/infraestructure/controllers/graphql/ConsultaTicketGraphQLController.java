package pe.doublev.partners.api.rest.infraestructure.controllers.graphql;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import pe.back.core.domain.response.PaginationResponse;
import pe.doublev.partners.api.rest.application.service.TicketService;
import pe.doublev.partners.api.rest.domain.request.ConsultaTicketPaginationRequest;

@Controller
public class ConsultaTicketGraphQLController {

    private final TicketService ticketService;

    public ConsultaTicketGraphQLController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    private final static String SORT_ID_TICKET= "idTicket";

    @QueryMapping
    public PaginationResponse listarTicketPorCampo(@Argument ConsultaTicketPaginationRequest request){
        if(request.getFieldName() == null || request.getFieldName().trim().equals("")){
            request.setFieldName(SORT_ID_TICKET);
        }

        PaginationResponse listPaginated = ticketService.listAllTicketWithPaginationAndSorting(
                request.getIdTicket(),
                request.getOffset(),
                request.getPageSize(),
                request.getFieldName());


        return listPaginated;
    }

}
