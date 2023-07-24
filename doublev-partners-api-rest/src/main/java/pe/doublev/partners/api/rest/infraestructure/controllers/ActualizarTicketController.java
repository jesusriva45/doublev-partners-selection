package pe.doublev.partners.api.rest.infraestructure.controllers;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pe.back.core.domain.vo.TicketVO;
import pe.doublev.partners.api.rest.application.service.TicketService;
import pe.doublev.partners.api.rest.domain.request.ActualizarTicketRequest;

@RestController
public class ActualizarTicketController {

    private final TicketService ticketService;

    public ActualizarTicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PutMapping("/actualizar")
    public ResponseEntity<TicketVO> registrarTicket(@RequestBody @Valid ActualizarTicketRequest actualizarTicketRequest) {

       TicketVO ticketVO = ticketService.updateTicket(setTicketVO(actualizarTicketRequest)).get();

        return new ResponseEntity<>(ticketVO, HttpStatus.OK);

    }

    private TicketVO setTicketVO(ActualizarTicketRequest actualizarTicketRequest) {
        TicketVO ticketVO = new TicketVO();

        ticketVO.setIdTicket(actualizarTicketRequest.getIdTicket());
        ticketVO.setEstado(actualizarTicketRequest.getEstado());

        return ticketVO;
    }




}
