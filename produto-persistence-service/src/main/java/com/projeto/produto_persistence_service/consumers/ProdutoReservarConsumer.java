package com.projeto.produto_persistence_service.consumers;

import com.projeto.produto_persistence_service.model.ProdutoEntity;
import com.projeto.produto_persistence_service.repository.ProdutoRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Component
public class ProdutoReservarConsumer {

    private final ProdutoRepository repo;
    private final RabbitTemplate rabbit;

    public ProdutoReservarConsumer(ProdutoRepository repo, RabbitTemplate rabbit) {
        this.repo = repo;
        this.rabbit = rabbit;
    }

    @RabbitListener(queues = "${broker.queue.produto-reservar}")
    public void reservarEstoque(Map<String, Object> msg){

        Long produtoId = Long.parseLong(msg.get("produtoId").toString());
        int quantidade = (int) msg.get("quantidade") ;
        Long pedidoId = Long.parseLong(msg.get("pedidoId").toString());

        Optional<ProdutoEntity> opt = repo.findById(produtoId);


        if(opt.isEmpty()){
            rabbit.convertAndSend("produto.exchange","estoque.resultado",
                    Map.of("status", "INSUFICIENTE",
                            "pedidoId",pedidoId,
                            "produtoId",produtoId,
                            "mensagem","Produto não encontrado"));
            return;
        }

        ProdutoEntity produto = opt.get();
        if(produto.getEstoque() >= quantidade){
            produto.setEstoque(produto.getEstoque() -quantidade);
            repo.save(produto);
            rabbit.convertAndSend("produto.exchange","estoque.resultado",
                    Map.of("status", "RESERVADO",
                            "pedidoId",pedidoId,
                            "produtoId",produtoId,
                            "mensagem","Produto disponível"));
        }else{
            rabbit.convertAndSend("produto.exchange","estoque.resultado",
                    Map.of("status", "INSUFICIENTE",
                            "pedidoId",pedidoId,
                            "produtoId",produtoId,
                            "mensagem","Estoque insuficiente"));
        }
    }
}
