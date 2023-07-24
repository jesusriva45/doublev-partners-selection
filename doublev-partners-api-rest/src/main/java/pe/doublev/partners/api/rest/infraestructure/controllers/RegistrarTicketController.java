package pe.doublev.partners.api.rest.infraestructure.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pe.back.core.domain.vo.TicketVO;
import pe.back.core.domain.vo.UsuarioVO;
import pe.back.core.repositories.jpa.domain.models.Ticket;
import pe.doublev.partners.api.rest.application.service.TicketService;
import pe.doublev.partners.api.rest.domain.request.RegistrarTicketRequest;

import java.util.Date;

@RestController
public class RegistrarTicketController {

    private final TicketService ticketService;

    public RegistrarTicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping("/ticket")
    public ResponseEntity<TicketVO> registrarTicket(@RequestBody RegistrarTicketRequest registrarTicketRequest) {

       TicketVO ticketVO = ticketService.saveTicket(setTicketVO(registrarTicketRequest)).get();

        return new ResponseEntity<>(ticketVO, HttpStatus.OK);

    }

    private TicketVO setTicketVO(RegistrarTicketRequest registrarTicketRequest) {
        TicketVO ticketVO = new TicketVO();
        ticketVO.setUsuario(setUsuario(registrarTicketRequest));
        return ticketVO;
    }

    private UsuarioVO setUsuario(RegistrarTicketRequest registrarTicketRequest) {

        UsuarioVO usuarioVO = new UsuarioVO();
        usuarioVO.setNombre(registrarTicketRequest.getNombre());
        usuarioVO.setApellido(registrarTicketRequest.getApellido());
        usuarioVO.setIdentificacion(registrarTicketRequest.getIdentificacion());

        return usuarioVO;
    }


}
