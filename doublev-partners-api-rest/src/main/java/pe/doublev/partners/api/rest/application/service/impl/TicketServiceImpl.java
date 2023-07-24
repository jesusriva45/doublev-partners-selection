package pe.doublev.partners.api.rest.application.service.impl;

import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.beans.support.SortDefinition;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import pe.back.core.application.repositories.TicketRepository;
import pe.back.core.application.repositories.UsuarioRepository;
import pe.back.core.domain.exceptions.DoubleVPartnersException;
import pe.back.core.domain.response.PaginationResponse;
import pe.back.core.domain.vo.TicketVO;
import pe.back.core.domain.vo.UsuarioVO;
import pe.back.core.repositories.jpa.domain.models.Ticket;
import pe.doublev.partners.api.rest.application.service.TicketService;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final UsuarioRepository usuarioRepository;

    public TicketServiceImpl(TicketRepository ticketRepository, UsuarioRepository usuarioRepository) {
        this.ticketRepository = ticketRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Optional<TicketVO> saveTicket(TicketVO ticketVO) {

        Optional<UsuarioVO> usuarioVo = usuarioRepository.getUsuarioByIdentificacion(ticketVO.getUsuario().getIdentificacion());

        if (!usuarioVo.isEmpty()) {
            ticketVO.setUsuario(usuarioVo.get());
        } else {
            usuarioVo = usuarioRepository.saveUsuario(ticketVO.getUsuario());

            if (usuarioVo.isEmpty()) {
                throw new DoubleVPartnersException("Usuario no registrado, ocurrio un error al registrar Usuario", HttpStatus.BAD_REQUEST, Optional.empty());
            }
            ticketVO.setUsuario(usuarioVo.get());
        }
        Optional<TicketVO> vo = ticketRepository.saveTicket(ticketVO);
        return vo;
    }

    @Override
    public Optional<TicketVO> updateTicket(TicketVO ticketVO) {

        Optional<TicketVO> vo = ticketRepository.findTicketById(ticketVO.getIdTicket());

        vo.get().setEstado(ticketVO.getEstado());
        vo.get().setFechaActualizacion(new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());


        Optional<TicketVO> ticketUpdate = ticketRepository.updateTicket(vo.get());

        if (ticketUpdate.isEmpty()) {
            throw new DoubleVPartnersException("Error al actualizar Ticket", HttpStatus.BAD_REQUEST, Optional.empty());
        }

        return ticketUpdate;
    }

    @Override
    public void deleteTicket(Long idTicket) {
        ticketRepository.deleteTicket(idTicket);
    }

    @Override
    public List<TicketVO> listAllTicketPaginedByFielName(String fieldName) {
        return ticketRepository.listAllTicketPaginedByFielName(fieldName);
    }

    @Override
    public PaginationResponse listAllTicketWithPaginationAndSorting(Long idTicket, int offset, int pageSize, String fieldName) {

        PaginationResponse response = new PaginationResponse();

        if (idTicket == null || idTicket.toString().trim().equals("")) {


            List<TicketVO> listVO = new ArrayList<>(ticketRepository.listAllTicket());

            PagedListHolder<TicketVO> page = new PagedListHolder(listVO);
            page.setPage(offset);
            page.setPageSize(pageSize);
            System.out.println("fieldName : " + fieldName);

            MutableSortDefinition sortDefinition = new MutableSortDefinition (fieldName, true, true);
            page.setSort(sortDefinition);
            page.resort();


            response.setResponse(page.getPageList());
            response.setTotalElementByPage(page.getPageSize());
            response.setTotalElements(page.getNrOfElements());
        } else {

            Optional<TicketVO> vo = ticketRepository.findTicketById(idTicket);

            ArrayList list = new ArrayList<>();
            list.add(vo);
            response.setResponse(list);
            response.setTotalElementByPage(1);
            response.setTotalElements(1);

        }


        return response;
    }
}
