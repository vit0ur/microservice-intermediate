package com.projeto.produto_service.domain;

public interface PedidoEventPublisherPort {
    void publicar(EstoqueAtualizadoEvent event);
}
