package com.projeto.produto_service.domain;

public interface EstoqueServicePort {
    void processarPedido(PedidoCriadoEvent event);
}
