package org.marceloteixeira.log;

import jakarta.enterprise.context.ApplicationScoped;
import org.marceloteixeira.event.PagamentoConfirmadoEvent;
import org.marceloteixeira.event.PedidoAlteradoEvent;
import org.marceloteixeira.event.PedidoCriadoEvent;

import java.time.format.DateTimeFormatter;

@ApplicationScoped
public class MontadorMensagemLog {

    public String montarMensagem (PedidoCriadoEvent event) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy 'às' HH:mm:ss");

        return "O pedido " + event.pedidoId
                + ", com valor de R$ " + event.valorTotal
                + ", foi criado em " + event.dataHora.format(formatter)
                + " para o cliente " + event.clienteId + ".";
    }

    public String montarMensagem (PedidoAlteradoEvent event) {
        return "O pedido " + event.pedidoId + " foi alterado.";
    }

    public String montarMensagem (PagamentoConfirmadoEvent event) {
        return "O pagamento do pedido " + event.pedidoId + " foi confirmado";
    }

}
