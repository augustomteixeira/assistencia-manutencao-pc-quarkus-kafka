package org.marceloteixeira.event;

import org.marceloteixeira.enumeration.StatusPedido;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PedidoCriadoEvent {
    public Long pedidoId;
    public Long clienteId;
    public BigDecimal valorTotal;
    public StatusPedido status;
    public LocalDateTime dataHora;

    public PedidoCriadoEvent(Long pedidoId, Long clienteId, BigDecimal valorTotal, StatusPedido status, LocalDateTime dataHora) {
        this.pedidoId = pedidoId;
        this.clienteId = clienteId;
        this.valorTotal = valorTotal;
        this.status = status;
        this.dataHora = dataHora;
    }

    @Override
    public String toString() {
        return "PedidoCriadoEvent{" +
                "pedidoId=" + pedidoId +
                ", clienteId=" + clienteId +
                ", valorTotal=" + valorTotal +
                ", status=" + status +
                ", dataHora" + dataHora +
                '}';
    }
}
