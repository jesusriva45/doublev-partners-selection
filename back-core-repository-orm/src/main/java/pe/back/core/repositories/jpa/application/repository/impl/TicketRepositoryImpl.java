package pe.back.core.repositories.jpa.application.repository.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.back.core.application.repositories.TicketRepository;
import pe.back.core.domain.exceptions.DoubleVPartnersException;
import pe.back.core.domain.vo.TicketVO;
import pe.back.core.repositories.jpa.application.repository.TicketJPARepository;
import pe.back.core.repositories.jpa.domain.models.Ticket;
import pe.back.core.repositories.jpa.infraestructure.mappers.TicketMapper;

import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class TicketRepositoryImpl implements TicketRepository {

    private final TicketJPARepository repository;
    private final TicketMapper ticketMapper;

    public TicketRepositoryImpl(TicketJPARepository ticketJPARepository, TicketMapper ticketMapper) {
        this.repository = ticketJPARepository;
        this.ticketMapper = ticketMapper;
    }


    @Override
    @Transactional
    public Optional<TicketVO> saveTicket(TicketVO ticketVO) {

        ticketVO.setFechaCreacion(new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
        ticketVO.setEstado("A");
        Optional<TicketVO> ticket = Optional.ofNullable(this.ticketMapper.fromEntity(repository.save(this.ticketMapper.voToEntity(ticketVO))));

        if (ticket.isEmpty()) {
            return Optional.empty();
        }

        return ticket;
    }

    @Override
    @Transactional
    public Optional<TicketVO> updateTicket(TicketVO ticketVO) {

        Optional<Ticket> ticket = repository.findById(ticketVO.getIdTicket());

        if (ticket.isEmpty()) {
            throw new DoubleVPartnersException("Ticket no registrado", HttpStatus.NOT_FOUND, null);
        }

        Optional<TicketVO> ticketUpdate = Optional.ofNullable(this.ticketMapper.fromEntity(repository.save(this.ticketMapper.voToEntity(ticketVO))));

        if (ticketUpdate.isEmpty()) {
            return Optional.empty();
        }


        return ticketUpdate;
    }

    @Override
    @Transactional
    public void deleteTicket(Long idTicket) {

        repository.deleteById(idTicket);

    }

    @Override
    public Optional<TicketVO> findTicketById(Long idTicket) {

        Optional<Ticket> ticket = repository.findById(idTicket);

        if(ticket.isEmpty()){
            throw new DoubleVPartnersException("Ticket no registrado", HttpStatus.NOT_FOUND, Optional.empty());
        }

        return Optional.ofNullable(this.ticketMapper.fromEntity(ticket.get()));
    }

    @Override
    public List<TicketVO> listAllTicketPaginedByFielName(String fieldName) {
        return repository.findAll(Sort.by(Sort.Direction.DESC, fieldName)).stream().map(this.ticketMapper::fromEntity).toList();
    }

    @Override
    public List<TicketVO> listAllTicket() {
//        Pageable paging = PageRequest.of(offset, pageSize, Sort.by(fieldName));
//        Page<Ticket> pagedResult = repository.findAll(paging);
        return repository.findAll().stream().map(this.ticketMapper::fromEntity).toList();//pagedResult.getContent().stream().map(this.ticketMapper::fromEntity).toList();
    }
}
