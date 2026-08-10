package org.marceloteixeira.event;

public class PagamentoConfirmadoEvent {
    public Long pagamentoId;
    public Long pedidoId;

    public PagamentoConfirmadoEvent(Long pagamentoId, Long pedidoId) {
        this.pagamentoId = pagamentoId;
        this.pedidoId = pedidoId;
    }

    @Override
    public String toString() {
        return "PagamentoConfirmadoEvent{" +
                "pagamentoId=" + pagamentoId +
                ", pedidoId=" + pedidoId +
                '}';
    }
}
