package org.marceloteixeira.entity;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import org.marceloteixeira.enumeration.StatusPagamento;

@Entity
public class Pagamento extends PanacheEntity {

    @Enumerated(EnumType.STRING)
    public StatusPagamento status;

    @Column(name = "pedido_id")
    public Long pedidoId;

    @Override
    public String toString() {
        return "Pagamento{" +
                "status=" + status +
                ", pedidoId=" + pedidoId +
                ", id=" + id +
                '}';
    }
}
