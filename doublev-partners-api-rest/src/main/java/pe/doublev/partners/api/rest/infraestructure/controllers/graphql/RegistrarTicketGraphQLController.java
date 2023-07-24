package pe.doublev.partners.api.rest.infraestructure.controllers.graphql;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pe.back.core.domain.vo.TicketVO;
import pe.back.core.domain.vo.UsuarioVO;
import pe.doublev.partners.api.rest.application.service.TicketService;
import pe.doublev.partners.api.rest.domain.request.RegistrarTicketRequest;

@RestController
public class RegistrarTicketGraphQLController {

    private final TicketService ticketService;

    public RegistrarTicketGraphQLController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @MutationMapping
    public TicketVO registrarTicket(@Argument RegistrarTicketRequest registrarTicketRequest) {

       TicketVO ticketVO = ticketService.saveTicket(setTicketVO(registrarTicketRequest)).get();

        return ticketVO;

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
