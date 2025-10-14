package com.projeto.pedido_service.domain;

public interface PedidoEventPublisherPort {
    void publicarPedidoCriado(PedidoCriadoEvent event);
}
