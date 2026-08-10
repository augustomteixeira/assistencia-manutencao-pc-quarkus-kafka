package org.marceloteixeira.entity;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.persistence.*;
import org.marceloteixeira.enumeration.StatusPedido;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Pedido extends PanacheEntity {

    public LocalDateTime dataHora;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    public Cliente cliente;

    @ManyToMany
    @JoinTable(name = "pedido_servico",
            joinColumns = @JoinColumn(name = "pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "servico_id"))
    public List<Servico> servicos;

    public BigDecimal valorTotal;

    @Enumerated(EnumType.STRING)
    public StatusPedido status;

    public void calcularValorTotal() {
        this.valorTotal = servicos.stream().map(s -> s.preco).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}