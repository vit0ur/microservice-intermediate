package com.projeto.pedido_service.infra.adapter.messaging;

import com.projeto.pedido_service.domain.PedidoCriadoEvent;
import com.projeto.pedido_service.domain.PedidoEventPublisherPort;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaPublisherAdapter implements PedidoEventPublisherPort {

    private final KafkaTemplate<String, PedidoCriadoEvent> kafkaTemplate;

    public KafkaPublisherAdapter(KafkaTemplate<String, PedidoCriadoEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void publicarPedidoCriado(PedidoCriadoEvent event) {
        kafkaTemplate.send("pedido.criado", event);
    }
}