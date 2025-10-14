package com.projeto.produto_service_kafka.domain;

public interface PedidoEventPublisherPort {
    void publicar(EstoqueAtualizadoEvent event);
}
