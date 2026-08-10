package org.marceloteixeira.consumer;

import io.quarkus.hibernate.reactive.panache.common.WithTransaction;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.marceloteixeira.entity.Pedido;
import org.marceloteixeira.enumeration.StatusPedido;
import org.marceloteixeira.event.PagamentoConfirmadoEvent;
import org.marceloteixeira.event.PedidoAlteradoEvent;

@ApplicationScoped
public class PagamentoConfirmadoConsumer {

    @Inject
    @Channel("pedidoAlterado")
    Emitter<PedidoAlteradoEvent> emitter;

    @Incoming("pagamentoConfirmado")
    @WithTransaction
    public Uni<Void> consume(PagamentoConfirmadoEvent event) {
        return Pedido.<Pedido>findById(event.pedidoId)
                .onItem().ifNotNull().invoke(p -> {
                    p.status = StatusPedido.CONCLUIDO;

                    PedidoAlteradoEvent pedidoAlteradoEvent =
                            new PedidoAlteradoEvent(p.id, p.cliente.id, p.valorTotal, p.status, p.dataHora);
                    emitter.send(pedidoAlteradoEvent);
                    System.out.println("Pedido Alterado!");
                }).replaceWithVoid();
    }

}
