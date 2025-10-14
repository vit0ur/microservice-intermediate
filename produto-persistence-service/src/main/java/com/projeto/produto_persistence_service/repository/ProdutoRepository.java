package com.projeto.produto_persistence_service.repository;

import com.projeto.produto_persistence_service.model.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {
}
