package com.projeto.pedido_service.infra.consumer;

import com.projeto.pedido_service.application.CriarPedidoService;
import com.projeto.pedido_service.domain.EstoqueAtualizadoEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class EstoqueAtualizadoConsumer {
    private final CriarPedidoService service;

    public EstoqueAtualizadoConsumer(CriarPedidoService service) {
        this.service = service;
    }

    @RabbitListener(queues = "${broker.queue.estoque-atualizado}")
    public void consumir(EstoqueAtualizadoEvent event){
        service.aplicarResultadoEstoque(event);
    }
}
