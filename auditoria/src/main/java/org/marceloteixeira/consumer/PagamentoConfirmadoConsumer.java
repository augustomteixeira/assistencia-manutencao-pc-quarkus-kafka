package org.marceloteixeira.consumer;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.marceloteixeira.event.PagamentoConfirmadoEvent;
import org.marceloteixeira.log.MontadorMensagemLog;

@ApplicationScoped
public class PagamentoConfirmadoConsumer {

    @Inject
    MontadorMensagemLog mensagemLog;

    @Incoming("pagamentoConfirmado")
    public Uni<Void> consume(PagamentoConfirmadoEvent event) {
        return Uni.createFrom()
                .item(mensagemLog.montarMensagem(event))
                .onItem().invoke(mensagem -> System.out.println(mensagem))
                .replaceWithVoid();
    }

}
