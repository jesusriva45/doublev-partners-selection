package pe.doublev.partners.api.rest.infraestructure.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.back.core.domain.vo.TicketVO;
import pe.doublev.partners.api.rest.application.service.TicketService;
import pe.doublev.partners.api.rest.domain.request.RegistrarTicketRequest;

@RestController
public class EliminarTicketController {

    private final TicketService ticketService;

    public EliminarTicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @DeleteMapping("/eliminar/{idTicket}")
    public ResponseEntity<TicketVO> registrarTicket(@PathVariable Long idTicket) {

        ticketService.deleteTicket(idTicket);

        return new ResponseEntity<>(null, HttpStatus.OK);

    }
}
