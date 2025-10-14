package com.projeto.produto_service.domain;

public class EstoqueAtualizadoEvent {
    private Long pedidoId;
    private Long produtoId;
    private boolean reservado;

    public EstoqueAtualizadoEvent(Long pedidoId, Long produtoId, boolean reservado) {
        this.pedidoId = pedidoId;
        this.produtoId = produtoId;
        this.reservado = reservado;
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

    public boolean isReservado() {
        return reservado;
    }

    public void setReservado(boolean reservado) {
        this.reservado = reservado;
    }
}
