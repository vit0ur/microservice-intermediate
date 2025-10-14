package com.projeto.produto_service_kafka.domain;


public class Produto {

    private Long id;
    private String nome;
    private int estoque;
    private double preco;

    public boolean  reservarEstoque(int quantidade){
        if(estoque >= quantidade){
            estoque -= quantidade
                    ;
            return true;
        }
        return false;
    }

    public Produto() {
    }

    public Produto(Long id, String nome, int estoque, double preco) {
        this.id = id;
        this.nome = nome;
        this.estoque = estoque;
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
