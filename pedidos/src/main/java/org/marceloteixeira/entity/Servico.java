package org.marceloteixeira.entity;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;
import org.marceloteixeira.enumeration.TipoServico;

import java.math.BigDecimal;
import java.util.List;

@Entity
public class Servico extends PanacheEntity {

    @Enumerated(EnumType.STRING)
    public TipoServico tipo;

    public BigDecimal preco;

    @ManyToMany(mappedBy = "servicos")
    @JsonbTransient
    public List<Pedido> pedidos;


}
