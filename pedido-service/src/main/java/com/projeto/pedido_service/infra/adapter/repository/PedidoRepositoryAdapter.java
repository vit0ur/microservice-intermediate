package com.projeto.pedido_service.infra.adapter.repository;

import com.projeto.pedido_service.domain.Pedido;
import com.projeto.pedido_service.domain.PedidoRepositoryPort;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class PedidoRepositoryAdapter implements PedidoRepositoryPort {

    private final PedidoJpaRepository jpa;

    public PedidoRepositoryAdapter(PedidoJpaRepository jpa) {
        this.jpa = jpa;
    }
    private Pedido toDomain(PedidoEntity e){
        Pedido pedido = new Pedido();
        BeanUtils.copyProperties(e, pedido);
        return pedido;
    }

    @Override
    public Pedido salvar(Pedido pedido) {
        var entidade = new PedidoEntity();
        BeanUtils.copyProperties(pedido, entidade);

        var salvo = jpa.save(entidade);

        return toDomain(salvo);
    }

    @Override
    public Optional<Pedido> buscarPorId(Long id) {
        return jpa.findById(id).map(this::toDomain);
    }

    @Override
    public List<Pedido> listar() {
        return jpa.findAll().stream().map(this::toDomain).toList();
    }
}
