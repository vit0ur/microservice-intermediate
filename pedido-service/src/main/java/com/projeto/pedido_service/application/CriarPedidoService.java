package com.projeto.pedido_service.application;

import com.projeto.pedido_service.domain.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CriarPedidoService {
    private final PedidoRepositoryPort repo;
    private final PedidoEventPublisherPort publisher;


    public CriarPedidoService(PedidoRepositoryPort repo, PedidoEventPublisherPort publisher) {
        this.repo = repo;
        this.publisher = publisher;
    }

    public List<Pedido> listar(){
        return repo.listar();
    }

    @Transactional
    public Pedido criar(Long ProdutoId, int quantidade){
        var pedido = new Pedido();
        pedido.setQuantidade(quantidade);
        pedido.setProdutoId(ProdutoId);
        pedido.pendente();

        var salvo = repo.salvar(pedido);

        var evento =  new PedidoCriadoEvent();
        evento.setPedidoId(salvo.getId());
        evento.setProdutoId(salvo.getProdutoId());
        evento.setQuantidade(salvo.getQuantidade());
        publisher.publicarPedidoCriado(evento);

        return salvo;

    }

    @Transactional
    public void aplicarResultadoEstoque(EstoqueAtualizadoEvent event){
        if (event.getPedidoId() == null) {
            throw new IllegalArgumentException("Pedido ID não pode ser nulo ao publicar evento de estoque");
        }

        var pedido = repo.buscarPorId(event.getPedidoId())
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado: "+event.getPedidoId()));

        if(event.isReservado()) pedido.aprovar();
        else pedido.rejeitar();

        repo.salvar(pedido);
    }
}
