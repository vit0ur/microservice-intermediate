package com.projeto.pedido_service.domain;

public class PedidoCriadoEvent {
    private Long pedidoId;
    private Long produtoId;
    private int quantidade;

    public PedidoCriadoEvent() {
    }

    public PedidoCriadoEvent(Long pedidoId, Long produtoId, int quantidade) {
        this.pedidoId = pedidoId;
        this.produtoId = produtoId;
        this.quantidade = quantidade;
    }

    public Long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public Long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
