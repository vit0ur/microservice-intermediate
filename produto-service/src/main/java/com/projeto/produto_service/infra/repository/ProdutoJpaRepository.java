package com.projeto.produto_service.infra.repository;

import com.projeto.produto_service.infra.entity.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoJpaRepository extends JpaRepository<ProdutoEntity, Long> {
}
