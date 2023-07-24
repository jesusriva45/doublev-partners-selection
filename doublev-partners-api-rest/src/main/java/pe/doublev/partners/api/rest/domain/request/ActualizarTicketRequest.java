package pe.doublev.partners.api.rest.domain.request;

import jakarta.validation.constraints.Pattern;

public class ActualizarTicketRequest {

    private Long idTicket;

    @Pattern(regexp = "[A]|[C]", message = "Solo se acepta estado con valor 'A' o 'C'")
    private String estado;

    public Long getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(Long idTicket) {
        this.idTicket = idTicket;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
