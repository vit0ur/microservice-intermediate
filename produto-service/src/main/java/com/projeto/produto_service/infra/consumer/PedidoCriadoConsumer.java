package com.projeto.produto_service.infra.consumer;

import com.projeto.produto_service.domain.EstoqueServicePort;
import com.projeto.produto_service.domain.PedidoCriadoEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PedidoCriadoConsumer
{
    private final EstoqueServicePort service;

    public PedidoCriadoConsumer(EstoqueServicePort service) {
        this.service = service;
    }

    @RabbitListener(queues = "${broker.queue.pedido-criado}")
    public void consumir(PedidoCriadoEvent event){
        service.processarPedido(event);
    }
}
