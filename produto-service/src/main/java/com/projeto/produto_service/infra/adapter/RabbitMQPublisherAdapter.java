package com.projeto.produto_service.infra.adapter;

import com.projeto.produto_service.domain.EstoqueAtualizadoEvent;
import com.projeto.produto_service.domain.PedidoEventPublisherPort;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQPublisherAdapter implements PedidoEventPublisherPort {
    private final RabbitTemplate rabbitTemplate;

    public RabbitMQPublisherAdapter(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void publicar(EstoqueAtualizadoEvent event) {
        rabbitTemplate.convertAndSend("pedidos.exchange","estoque.atualizado", event);
    }}
