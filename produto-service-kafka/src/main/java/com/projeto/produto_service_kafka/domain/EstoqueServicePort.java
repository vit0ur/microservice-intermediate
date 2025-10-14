package com.projeto.produto_service_kafka.domain;

public interface EstoqueServicePort {
    void processarPedido(PedidoCriadoEvent event);
}
