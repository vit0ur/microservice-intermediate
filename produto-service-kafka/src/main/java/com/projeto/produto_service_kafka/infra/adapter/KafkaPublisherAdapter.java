package com.projeto.produto_service_kafka.infra.adapter;

import com.projeto.produto_service_kafka.domain.EstoqueAtualizadoEvent;
import com.projeto.produto_service_kafka.domain.PedidoEventPublisherPort;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaPublisherAdapter implements PedidoEventPublisherPort {
    private final KafkaTemplate<String, EstoqueAtualizadoEvent> kafkaTemplate;

    public KafkaPublisherAdapter(KafkaTemplate<String, EstoqueAtualizadoEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void publicar(EstoqueAtualizadoEvent event) {
        kafkaTemplate.send("estoque.atualizado", event);
    }
}