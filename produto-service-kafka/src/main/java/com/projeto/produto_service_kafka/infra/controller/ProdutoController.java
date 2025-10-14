package com.projeto.produto_service_kafka.infra.controller;

import com.projeto.produto_service_kafka.domain.Produto;
import com.projeto.produto_service_kafka.domain.ProdutoRepositoryPort;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private final ProdutoRepositoryPort repo;

    public ProdutoController(ProdutoRepositoryPort repo) {
        this.repo = repo;
    }

    @GetMapping("/{id}")
    public Optional<Produto> buscarPorId(@PathVariable Long id){
        return repo.buscarPorId(id);
    }

    @PostMapping
    public Produto salvar(@RequestBody Produto p){
        return repo.salvar(p);
    }
}
