package pe.back.core.repositories.jpa.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.back.core.repositories.jpa.domain.models.Ticket;

public interface TicketJPARepository extends JpaRepository<Ticket, Long> {
}
