package com.projeto.produto_service_kafka.infra.consumer;

import com.projeto.produto_service_kafka.domain.EstoqueServicePort;
import com.projeto.produto_service_kafka.domain.PedidoCriadoEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PedidoCriadoConsumer {
    private final EstoqueServicePort service;

    public PedidoCriadoConsumer(EstoqueServicePort service) {
        this.service = service;
    }

    @KafkaListener(topics = "${broker.topic.pedido-criado}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumir(PedidoCriadoEvent event) {
        service.processarPedido(event);
    }
}