package com.projeto.produto_persistence_service.consumers;

import com.projeto.produto_persistence_service.model.ProdutoEntity;
import com.projeto.produto_persistence_service.repository.ProdutoRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ProdutoSalvaConsumer {
    private final ProdutoRepository repo;
    private final RabbitTemplate rabbitTemplate;

    public ProdutoSalvaConsumer(ProdutoRepository repo, RabbitTemplate rabbitTemplate) {
        this.repo = repo;
        this.rabbitTemplate = rabbitTemplate;
    }
//    @RabbitListener(queues = "${broker.queue.produto-salvar}")
//    public void salvarProduto(ProdutoEntity produto){
//        System.out.println("SALVO");
//
//       ProdutoEntity p =  repo.save(produto);
//        rabbitTemplate.convertAndSend("produto.exchange","produto-salvo", p);
//    }
        @RabbitListener(queues = "${broker.queue.produto-salvar}")
        public void salvarProduto(Map<String, Object> msg){
            System.out.println("[produto persistência]Mensagem recebeida");

            ProdutoEntity produto = new ProdutoEntity();
            produto.setNome(msg.get("nome").toString());
            produto.setEstoque((int) msg.get("estoque"));
            produto.setPreco(Double.parseDouble(msg.get("preco").toString()));

            ProdutoEntity salvo =  repo.save(produto);

            System.out.println("Produto salbo vom id: "+salvo.getId());

            rabbitTemplate.convertAndSend("produto.exchange","produto.salvo",
                    Map.of("produtoId", salvo.getId(),
                            "nome", salvo.getNome(),
                            "estoque", salvo.getEstoque(),
                            "preco", salvo.getPreco()));

        }
}
