package com.projeto.pedido_service.infra.controller;

import com.projeto.pedido_service.application.CriarPedidoService;
import com.projeto.pedido_service.domain.Pedido;
import com.projeto.pedido_service.infra.adapter.repository.PedidoEntity;
import com.projeto.pedido_service.infra.adapter.repository.PedidoRepositoryAdapter;
import com.projeto.pedido_service.infra.controller.dto.NovoPedidoDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    private final CriarPedidoService service;

    public PedidoController(CriarPedidoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Pedido> listar(){
        return service.listar();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pedido criar(@RequestBody NovoPedidoDto dto){
        return service.criar(dto.produtoId(), dto.quantidade());
    }


}
