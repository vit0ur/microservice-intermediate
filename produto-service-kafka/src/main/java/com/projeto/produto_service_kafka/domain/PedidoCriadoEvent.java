package com.projeto.produto_service_kafka.domain;

public class PedidoCriadoEvent {
    private Long pedidoId;
    private Long produtoId;
    private int quantidade;

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

    public void setQuantiade(int quantidade) {
        this.quantidade = quantidade;
    }
}
