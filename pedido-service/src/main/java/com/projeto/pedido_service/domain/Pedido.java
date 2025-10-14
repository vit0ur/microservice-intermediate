package com.projeto.pedido_service.domain;

public class Pedido {
    private Long id;
    private Long produtoId;
    private int quantidade;
    private String status;

    public Pedido(Long id, Long produtoId, int quantidade, String status) {
        this.id = id;
        this.produtoId = produtoId;
        this.quantidade = quantidade;
        this.status = status;
    }

    public Pedido() {
    }

    public void aprovar(){
        this.status = "APROVADO";
    }

    public void rejeitar(){
        this.status = "REJEITADO";
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void pendente(){
        this.status = "PENDENTE";
    }

    public String getStatus() {
        return status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
