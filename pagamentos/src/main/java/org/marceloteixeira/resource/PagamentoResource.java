package org.marceloteixeira.resource;

import io.quarkus.hibernate.reactive.panache.Panache;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.marceloteixeira.entity.Pagamento;
import org.marceloteixeira.enumeration.StatusPagamento;
import org.marceloteixeira.event.PagamentoConfirmadoEvent;

import java.util.List;

@Path("/pagamentos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PagamentoResource {

    @Inject
    @Channel("pagamentoConfirmado")
    Emitter<PagamentoConfirmadoEvent> emitter;

    @GET
    public Uni<List<Pagamento>> getPagamentos() {
        return Pagamento.listAll();
    }

    @GET
    @Path("/{id}")
    public Uni<Pagamento> porId(Long id) {
        return Pagamento.findById(id);
    }

    @PUT
    @Path("/confirma/{id}")
    public Uni<Pagamento> confirma(Long id) {
        return Panache.withTransaction(() ->
                Pagamento.<Pagamento>findById(id)
                        .onItem().ifNotNull().invoke(pagamento -> {
                            pagamento.status = StatusPagamento.CONFIRMADO;
                                PagamentoConfirmadoEvent event =
                                        new PagamentoConfirmadoEvent(pagamento.id, pagamento.pedidoId);
                                emitter.send(event);
                        })
                );
    }

}
