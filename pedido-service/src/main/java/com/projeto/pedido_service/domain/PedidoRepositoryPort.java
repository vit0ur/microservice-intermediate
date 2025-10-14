package com.projeto.pedido_service.domain;

import java.util.List;
import java.util.Optional;

public interface PedidoRepositoryPort {
    Pedido salvar(Pedido pedido);
    Optional<Pedido> buscarPorId(Long id);
    List<Pedido> listar();
}
