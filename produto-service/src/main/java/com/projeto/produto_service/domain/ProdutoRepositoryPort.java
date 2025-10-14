package com.projeto.produto_service.domain;

import java.util.Optional;

public interface ProdutoRepositoryPort {
    Produto salvar(Produto produto);
    Optional<Produto> buscarPorId(Long id);
}
