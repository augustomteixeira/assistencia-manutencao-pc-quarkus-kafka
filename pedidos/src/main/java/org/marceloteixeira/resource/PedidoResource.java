package org.marceloteixeira.resource;

import io.quarkus.hibernate.reactive.panache.common.WithTransaction;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.marceloteixeira.entity.Pedido;
import org.marceloteixeira.enumeration.StatusPedido;
import org.marceloteixeira.event.PedidoCriadoEvent;

import java.time.LocalDateTime;
import java.util.List;

@Path("/pedidos")
public class PedidoResource {

    @Inject
    @Channel("pedidoCriado")
    Emitter<PedidoCriadoEvent> pedidoCriadoEventEmitter;

    @GET
    public Uni<List<Pedido>> getPedidos() {
        return Pedido.find("SELECT DISTINCT p FROM Pedido p LEFT JOIN FETCH p.servicos").list();
    }

    @POST
    @WithTransaction
    public Uni<Pedido> addPedido(Pedido pedido) {
        pedido.id = null; // Garantir que o ID seja gerado automaticamente
        pedido.dataHora = LocalDateTime.now();
        pedido.calcularValorTotal();

        return pedido.persist()
                .invoke(() -> {
                    System.out.println("Pedido persistido");
                    PedidoCriadoEvent event =
                            new PedidoCriadoEvent(pedido.id, pedido.cliente.id, pedido.valorTotal, StatusPedido.RECEBIDO, pedido.dataHora);
                    pedidoCriadoEventEmitter.send(event);
                }).replaceWith(pedido);
    }

    @PUT
    public  Uni<Pedido> updatePedido(Pedido pedido) {
        return Pedido.<Pedido>findById(pedido.id)
                .onItem().ifNotNull().transform(p -> {
                    p.cliente = pedido.cliente;
                    p.servicos = pedido.servicos;
                    p.status = pedido.status;
                    p.calcularValorTotal();

                    return p;
                });
    }

    @DELETE
    @Transactional
    public Uni<Void> deletePedido(int id) {
        return Pedido.deleteById(id)
                .replaceWithVoid();
    }

}
