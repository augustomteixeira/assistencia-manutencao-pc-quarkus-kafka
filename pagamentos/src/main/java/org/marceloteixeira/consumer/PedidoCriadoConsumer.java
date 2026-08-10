package org.marceloteixeira.consumer;

import io.quarkus.hibernate.reactive.panache.common.WithTransaction;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.marceloteixeira.entity.Pagamento;
import org.marceloteixeira.enumeration.StatusPagamento;
import org.marceloteixeira.event.PedidoCriadoEvent;

@ApplicationScoped
public class PedidoCriadoConsumer {

    @Incoming("pedidoCriado")
    @WithTransaction
    public Uni<Void> consume(PedidoCriadoEvent event) {
        Pagamento p =  new Pagamento();
        p.status = StatusPagamento.CRIADO;
        p.pedidoId = event.pedidoId;

        return p.persist()
                .invoke(() -> {
                    System.out.println("Pagamento persistido");
                }).replaceWithVoid();
    }

}
