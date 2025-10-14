package com.projeto.produto_service_kafka.application;

import com.projeto.produto_service_kafka.domain.*;
import org.springframework.stereotype.Service;

@Service
public class EstoqueServiceImpl implements EstoqueServicePort {

    private final ProdutoRepositoryPort produtoRepository;
    private final PedidoEventPublisherPort eventPublisher;

    public EstoqueServiceImpl(ProdutoRepositoryPort produtoRepositoryPort, PedidoEventPublisherPort eventPublisher) {
        this.produtoRepository= produtoRepositoryPort;
        this.eventPublisher = eventPublisher;
    }


    @Override
    public void processarPedido(PedidoCriadoEvent event) {
        if (event.getProdutoId() == null){
            throw new IllegalArgumentException("Produto ID não pode ser nulo ao publicar evento de estoque");
        }
        var produto =  produtoRepository.buscarPorId(event.getProdutoId())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        System.out.println(event.getQuantidade());

        boolean reservado = produto.reservarEstoque(event.getQuantidade());
        produtoRepository.salvar(produto);

        eventPublisher.publicar(new EstoqueAtualizadoEvent(
                event.getPedidoId(),
                event.getProdutoId(),
                reservado
        ));

    }
}
