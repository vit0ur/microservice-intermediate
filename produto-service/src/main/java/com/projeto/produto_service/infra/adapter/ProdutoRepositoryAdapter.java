package com.projeto.produto_service.infra.adapter;

import com.projeto.produto_service.domain.Produto;
import com.projeto.produto_service.domain.ProdutoRepositoryPort;
import com.projeto.produto_service.infra.entity.ProdutoEntity;
import com.projeto.produto_service.infra.repository.ProdutoJpaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProdutoRepositoryAdapter  implements ProdutoRepositoryPort {

    private final ProdutoJpaRepository jpa;

    public ProdutoRepositoryAdapter(ProdutoJpaRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public Produto salvar(Produto produto) {
        var entity =  new ProdutoEntity();

        BeanUtils.copyProperties(produto, entity);

        var salvo = jpa.save(entity);

        BeanUtils.copyProperties(salvo, produto);
        return produto;
    }

    @Override
    public Optional<Produto> buscarPorId(Long id) {
        return jpa.findById(id)
                .map(e -> new Produto(e.getId(), e.getNome(), e.getEstoque(), e.getPreco()));
    }
}
