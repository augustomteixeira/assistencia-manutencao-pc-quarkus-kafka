package org.marceloteixeira.consumer;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.marceloteixeira.event.PedidoAlteradoEvent;
import org.marceloteixeira.log.MontadorMensagemLog;

@ApplicationScoped
public class PedidoAlteradoConsumer {

    @Inject
    MontadorMensagemLog mensagemLog;

    @Incoming("pedidoAlterado")
    public Uni<Void> consume(PedidoAlteradoEvent event) {
        return Uni.createFrom()
                .item(mensagemLog.montarMensagem(event))
                .onItem().invoke(mensagem -> System.out.println(mensagem))
                .replaceWithVoid();
    }

}
